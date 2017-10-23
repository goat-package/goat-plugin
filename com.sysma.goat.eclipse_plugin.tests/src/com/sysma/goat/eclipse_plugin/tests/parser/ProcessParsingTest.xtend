package com.sysma.goat.eclipse_plugin.tests.parser

import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import org.junit.Assert
import org.junit.Test
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSpawn
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive
import com.sysma.goat.eclipse_plugin.goatComponents.BoolConstant
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateLocalAttribute
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessBlock
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateComponentAttribute

@RunWith(XtextRunner)
@InjectWith(GoatComponentsInjectorProvider)
class ProcessParsingTest {
	@Inject
	ParseHelper<Model> parseHelper
	
	def private encapsulateProcess(CharSequence proc){
		val result = parseHelper.parse('''
		infrastructure infr
		
		process P {
			«proc»
		}
		''')
		Assert.assertNotNull(result)
		result.processes.get(0).block
	}
	
	@Test
	def zeroProcess(){
		val result = encapsulateProcess('''''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.empty)
	}
	
	@Test
	def call(){
		val result = encapsulateProcess('''call(P)''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessCall)
		val cp = result.statements.get(0) as ProcessCall
		Assert.assertTrue(cp.proc.name == "P")
	}
	
	@Test
	def interleaving(){
		val result = encapsulateProcess('''spawn(P)''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessSpawn)
		val p = result.statements.get(0) as ProcessSpawn
		Assert.assertTrue(p.proc.name == "P")
	}
	
	@Test
	def defineInterleaving(){
		val defin = parseHelper.parse('''
		infrastructure infr
		
		process P = P|P|P|P
		''')
		Assert.assertNotNull(defin)
		val result = defin.processes.get(0).block
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.reverseView.tail.filter[!(it instanceof ProcessSpawn)].empty)
		Assert.assertTrue(result.statements.last instanceof ProcessCall)
	}
	
	// Input process
	@Test
	def inputProcessSimple(){
		val result = encapsulateProcess('''receive (true) {x,y,z};''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessReceive)
		val iprocs = result.statements.get(0) as ProcessReceive
		Assert.assertTrue(iprocs.cases.length == 1)
		val case0 = iprocs.cases.head
		Assert.assertTrue(case0.cond instanceof BoolConstant)
		Assert.assertTrue(case0.msgInParts.length == 3)
	}
	
	@Test
	def threeInputProcessSimple(){
		val result = encapsulateProcess('''
		receive {
			case (true) {x,y,z} : {}
			case (true) {x,y,z} : {}
			case (true) {x,y,z} : {}
		}''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessReceive)
		val iprocs = result.statements.get(0) as ProcessReceive
		Assert.assertTrue(iprocs.cases.length == 3)
		iprocs.cases.forEach[
			Assert.assertTrue(cond instanceof BoolConstant)
			Assert.assertTrue(msgInParts.length == 3)
		]
	}
	
	@Test
	def threeInputProcessUpdate(){
		val result = encapsulateProcess('''
		receive {
			case (true) {x,y,z} [proc.z := 5] : {}
			case (true) {x,y,z} [proc.z := 5] : {}
			case (true) {x,y,z} [proc.z := 5] : {}
		}''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessReceive)
		val iprocs = result.statements.get(0) as ProcessReceive
		Assert.assertTrue(iprocs.cases.length == 3)
		iprocs.cases.forEach[
			Assert.assertTrue(cond instanceof BoolConstant)
			Assert.assertTrue(msgInParts.length == 3)
			Assert.assertTrue(updates.attribute.get(0) instanceof UpdateLocalAttribute)
			Assert.assertTrue((updates.attribute.get(0) as UpdateLocalAttribute).atname == "z")
		]
	}
	
	@Test
	def outputProcess(){
		val result = encapsulateProcess('''send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessSend)
		val p = result.statements.head as ProcessSend
		Assert.assertTrue(p.send_pred instanceof Expression)
		Assert.assertTrue(p.msgOutParts.length == 3)
		Assert.assertTrue(p.msgOutParts.forall[it instanceof Expression])
		Assert.assertTrue(p.updates.attribute.empty)
		Assert.assertNull(p.print)
	}
	
	@Test
	def outputProcessPrint(){
		val result = encapsulateProcess('''send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1) print("Ciao ciao");''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessSend)
		val p = result.statements.head as ProcessSend
		Assert.assertTrue(p.print instanceof PrintFormattedStatement)
		Assert.assertTrue((p.print as PrintFormattedStatement).toPrint == "Ciao ciao")
	}
	
	@Test
	def inputProcessEmpty(){
		val result = encapsulateProcess('''receive (true) {};''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.get(0) instanceof ProcessReceive)
		val iprocs = result.statements.get(0) as ProcessReceive
		Assert.assertTrue(iprocs.cases.length == 1)
		val case0 = iprocs.cases.head
		Assert.assertTrue(case0.cond instanceof BoolConstant)
		Assert.assertTrue(case0.msgInParts.empty)
	}
	
	@Test
	def outputProcessEmpty(){
		val result = encapsulateProcess('''send {} @ (true);''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessSend)
		val p = result.statements.head as ProcessSend
		Assert.assertTrue(p.send_pred instanceof Expression)
		Assert.assertTrue(p.msgOutParts.empty)
		Assert.assertTrue(p.updates.attribute.empty)
		Assert.assertNull(p.print)
	}
	
	
	@Test
	def sequence(){
		val result = encapsulateProcess('''send {} @ (true); receive (proc.x > 3) {a}; set [proc.s := 8];''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	// if 
	
	@Test
	def if_(){
		val result = encapsulateProcess('''
		if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		}''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessIf)
		val ifp = result.statements.head as ProcessIf
		Assert.assertTrue(ifp.cond.length == 1)
		Assert.assertTrue(ifp.action.length == 1)
		Assert.assertTrue(ifp.then.length == 1)
		Assert.assertTrue(ifp.action.head instanceof ProcessSend)
		val p = ifp.then.head as ProcessBlock
		Assert.assertTrue(p.statements.empty)
	}
	
	@Test
	def if_ElseIf(){
		val result = encapsulateProcess('''
		if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
			set;
		} else if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
			set;
		} ''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessIf)
		val ifp = result.statements.head as ProcessIf
		Assert.assertTrue(ifp.cond.length == 2)
		Assert.assertTrue(ifp.action.length == 2)
		Assert.assertTrue(ifp.then.length == 2)
		
		Assert.assertTrue(ifp.action.filter[!(it instanceof ProcessSend)].empty)
		Assert.assertTrue(ifp.then.filter[it.statements.length != 1].empty)
	}
	
	@Test
	def if_Else(){
		val result = encapsulateProcess('''
		if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
			set;
		} else { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
			set;
		} ''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessIf)
		val ifp = result.statements.head as ProcessIf
		Assert.assertTrue(ifp.cond.length == 1)
		Assert.assertTrue(ifp.action.length == 2)
		Assert.assertTrue(ifp.then.length == 2)
		
		Assert.assertTrue(ifp.action.filter[!(it instanceof ProcessSend)].empty)
		Assert.assertTrue(ifp.then.filter[it.statements.length != 1].empty)
	}
	
	@Test
	def if_Else_Else(){
		val result = encapsulateProcess('''
		if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		} else { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		} else { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		}''')
		Assert.assertNotNull(result)
		Assert.assertFalse(result.eResource.errors.isEmpty)
	}
	
	@Test
	def if_Else_ElseIf(){
		val result = encapsulateProcess('''
		if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		} else { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		} else if (true) { 
			send {proc.x,comp.y,proc.z} @ (receiver.ciao == 1);
		}''')
		Assert.assertNotNull(result)
		Assert.assertFalse(result.eResource.errors.isEmpty)
	}
	
	// Waitfor
	@Test
	def sleep(){
		val result = encapsulateProcess('''waitfor(100);''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessWaitFor)
		val p = result.statements.head as ProcessWaitFor
		Assert.assertTrue(p.cond instanceof IntConstant)
	}
	
	@Test
	def awareness(){
		val result = encapsulateProcess('''waitfor(proc.x > 0);''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessWaitFor)
		val p = result.statements.head as ProcessWaitFor
		Assert.assertTrue(p.cond instanceof Expression)
	}
	
	// Set
	@Test
	def set_(){
		val result = encapsulateProcess('''set [comp.d := 9, proc.f := comp.d];''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertTrue(result.statements.head instanceof ProcessSet)
		val p = result.statements.head as ProcessSet
		Assert.assertTrue(p.update.attribute.length == 2)
		Assert.assertTrue(p.update.value.length == 2)
		Assert.assertTrue(p.update.attribute.get(0) instanceof UpdateComponentAttribute)
		Assert.assertTrue((p.update.attribute.get(0) as UpdateComponentAttribute).atname == "d")
		Assert.assertTrue(p.update.attribute.get(1) instanceof UpdateLocalAttribute)
		Assert.assertTrue((p.update.attribute.get(1) as UpdateLocalAttribute).atname == "f")
	}
}
