package com.sysma.goat.eclipse_plugin.tests.generator

import org.eclipse.xtext.testing.InjectWith
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import com.google.inject.Inject
import org.junit.Test
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(GoatComponentsInjectorProvider)
class ExpressionGeneratorTest {
	@Inject extension GeneratorTestHelper
	
	@Test
	def sumExpression(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send{}@(false) [proc.x := 1+5] print("EXPRESSION $x$");
		}
		
		component {} P
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION 6"))])
	}
	
	@Test
	def expressionWithAttributes(){
		compileAndRun('''
		infrastructure infr
				
		process P {
			send{}@(false) [
				proc.g := 3, 
				proc.f := ((comp.seven+5)*proc.g)/7
			] print("EXPRESSION $f$");
		}
		
		component {seven := 7} P
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION 5"))])
	}
	
	@Test
	def expressionWithComparisonInt(){
		compileAndRun('''
		infrastructure infr

		process P {
			send{}@(false) [proc.g := 3, proc.f := comp.seven > 3] print("EXPRESSION $f$");
		}
		
		component {seven := 7} P
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION true"))])
	}
	
	@Test
	def expressionWithComparisonIntBool(){
		compileAndRun('''
		infrastructure infr
		
		process P{
			send{}@(false) [proc.g := 3, proc.f := comp.seven > 3 == 3 > 4] print("EXPRESSION $f$");
		}
		
		component {seven := 7} P
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION false"))])
	}
	
	@Test
	def expressionFunctionRecursive(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send {} @ (false) [
				proc.six := 6, 
				proc.f := fact(proc.six)
			] print("EXPRESSION $f$");
		}
		
		component {} P
		
		function int fact(int n){
			if (n <= 1) {
				return 1
			} else {
				return n * fact(n-1)
			}
		}
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION 720"))])
	}
	
	@Test
	def expressionWithNegativeConst(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send {} @ (false) [
				proc.val := -1, 
				proc.f := fn(proc.val)
			] print("EXPRESSION $f$");
		}
		
		component {} P
		
		function int fn(int n){
			return -n
		}
		''',[out, err| Assert.assertTrue(out.contains("EXPRESSION 1"))])
	}
	
	@Test
	def expressionSendPredicate(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send{1}@(receiver.pname == "Q");
			receive(true){x} print("P got $x$");
		}
		
		process Q {
			receive(true){x}print("Q got $x$");
			send{proc.x + 1}@(receiver.pname == "P");
		}
		
		component {pname := "P"} P
		component {pname := "Q"} Q
		''',[out, err| 
				Assert.assertTrue(out.contains("Q got 1"))
				Assert.assertTrue(out.contains("P got 2"))
		])
	}
	
	@Test
	def expressionSendPredicateStrings(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send {"ciao: come (va)"} @ (receiver.pname == "Q");
		}
		
		process Q {
			receive (true) {x} print("$x$");
		}
		
		component {pname := "P"} P
		component {pname := "Q"} Q
		''',[out, err| 
				Assert.assertTrue(out.contains("ciao: come (va)"))
		])
	}
}