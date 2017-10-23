package com.sysma.goat.eclipse_plugin.tests.validator

import com.google.inject.Inject
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(GoatComponentsInjectorProvider)
class ExpressionValidatorTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper
	
	def checkNoErrorApartInfr(EObject obj){
		assertTrue(obj.eResource.errors.filter[it.message != "Couldn't resolve reference to Infrastructure 'infr'."].length == 0)
	}
	
	@Test
	def intExpression(){
		val result = parse('''
			infrastructure infr

			function int fun (int i, string s, bool b){
				var x = 0
				var y = 5
				return (x+y) * 6 - 5
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def boolExpression(){
		val result = parse('''
			infrastructure infr
			
			function bool fun (int i, string s, bool b){
				var x = 0
				var y = 5
				return ((x+y) * 6 - 5) > 10 == false
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def stringExpression(){
		val result = parse('''
			infrastructure infr
			
			function string fun (){
				var x = 0
				var y = 5
				return "o" ++ fun()
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def mixedSumExpression(){
		val result = parse('''
			infrastructure infr
			
			function string fun (int i, string s, bool b){
				var x = 0
				var y = 5
				return "3" + 9
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.plus, null, "Expected a int expression")
	}
	
	@Test
	def noGlobalAttributeInFunc(){
		val result = parse('''
			infrastructure infr
			
			function string fun (){
				var x = 0
				var y = 5
				return "o" ++ comp.z
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.componentAttributeRef, null, "Attributes cannot be used inside functions")
	}
	
	@Test
	def noRecAttributeInFunc(){
		val result = parse('''
			infrastructure infr
			
			function string fun (){
				var x = 0
				var y = 5
				return "o" ++ receiver.z
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.recAttributeRef, null, "Receiver attributes can be used only in output predicates")
	}
	
	// Expression on receive
	@Test
	def receiveBoolExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				receive (proc.x > 10) {w};
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def receiveNonBoolExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				receive (10) {w};
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.receiveCase, null, "Expected a bool expression")
	}
	
		@Test
	def globalAttributeInReceive(){
		val result = parse('''
			infrastructure infr
			
			process P {
				receive (comp.l) {w};
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def noRecAttributeInReceive(){
		val result = parse('''
			infrastructure infr
			
			process P {
				receive (receiver.l) {w};
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.recAttributeRef, null, "Receiver attributes can be used only in output predicates")
	}
	
	// Expression on send
	@Test
	def sendBoolExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				send {proc.w} @ (proc.x > 10);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def sendNonBoolExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				send {proc.w} @ ("k");
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.processSend, null, "Expected a bool expression")
	}
	
	@Test
	def globalAttributeInSendMessage(){
		val result = parse('''
			infrastructure infr
			
			process P {
				send {comp.w} @ (true);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def globalAttributeInSendPred(){
		val result = parse('''
			infrastructure infr
			
			process P {
				send {proc.w} @ (receiver.s == comp.d);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def globalAttributeInPreconditions(){
		val result = parse('''
			infrastructure infr
			
			process P {
				waitfor (comp.x == 8);
				send {} @ (true);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def noReceiverAttributeInSendPreconditions(){
		val result = parse('''
			infrastructure infr
			
			process P{
				waitfor (receiver.x == 8);
				send {} @ (true);
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.recAttributeRef, null, "Receiver attributes can be used only in output predicates")
	}
	
	// Expression on awareness
	@Test
	def awarenessBoolExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				waitfor(true);
				send {proc.w} @ (true);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def sleep(){
		val result = parse('''
			infrastructure infr
			
			process P {
				waitfor(4);
				send {proc.w} @ (false);
			}
		''')
		assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def awarenessNoStringExpression(){
		val result = parse('''
			infrastructure infr
			
			process P {
				waitfor("4");
				send {proc.w} @ (false);
			}
		''')
		assertNotNull(result)
		result.assertError(GoatComponentsPackage.eINSTANCE.processWaitFor, null, "Expected a bool or int expression")
	}
}