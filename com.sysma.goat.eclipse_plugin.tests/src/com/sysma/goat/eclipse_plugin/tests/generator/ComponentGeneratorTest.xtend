package com.sysma.goat.eclipse_plugin.tests.generator

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import com.google.inject.Inject
import org.junit.Test
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(GoatComponentsInjectorProvider)
class ComponentGeneratorTest {
	@Inject extension GeneratorTestHelper
	
	@Test
	def sendReceive(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send{"hello world"}@(true);
		}
		
		process Q {
			receive(true){x}print("$x$");
		}
		
		component {} P
		component {} Q
		''',[out, err| Assert.assertTrue(out.contains("hello world"))])
	}
	
	@Test
	def sendReceiveSameComponent(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			send{"hello world"}@(true);
		}
		
		process Q {
			receive(true){x}print("$x$");
		}
		
		process R {
			receive(true){x};
			send{"wow"}@(true);
		}
		
		process PQ = P|Q
		
		component {} PQ
		component {} R
		''',[out, err| Assert.assertFalse(out.contains("hello world"))])
	}
	
	@Test
	def ifProcess(){
		compileAndRun('''
		infrastructure infr
		
		process P1 {
			send{0}@(true);
			send{3}@(true);
		}
		
		process P2 {
			send{2}@(true);
			send{1}@(true);
		}
		
		process P = P1|P2
		
		process Q {
			if (comp.remaining > 0){
				receive(true){x}[comp.remaining := comp.remaining - 1];
				spawn(Qrep)
				call(Q)
			} else {
				set;
			}
		}

		process Qrep{
			if (proc.x < 2) {
				send{}@(false)print("$x$ is little");
			} else {
				send{}@(false)print("$x$ is big");
			}
		}
		
		component {} P
		component {remaining := 4} Q
		''',[out, err| 
			Assert.assertTrue(out.contains("0 is little"))
			Assert.assertTrue(out.contains("1 is little"))
			Assert.assertTrue(out.contains("2 is big"))
			Assert.assertTrue(out.contains("3 is big"))
		])
	}
	
	@Test
	def infiniteServer(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			set [proc.x := 0];
			send{proc.x}@(true);
			call(Pp)
		}
		
		process Pp {
			if (proc.x < 1000){
				set [proc.x := proc.x + 1];
				send{proc.x}@(true);
				call(Pp)
			} else {
				set;
			}
		}
		
		process Q {
			loop{
				receive(true){x}[comp.remaining := comp.remaining - 1];
				spawn(Qrep)
			}
		}
		
		process Qrep {
			if (proc.x == 0){
				send{}@(false)print("$x$ is zero");
			} else if (proc.x%2 == 0) {
				send{}@(false)print("$x$ is even");
			} else {
				send{}@(false)print("$x$ is odd");
			}
		}
		
		component {} P
		component {remaining := 1000} Q
		''',[out, err| 
			Assert.assertTrue(out.contains("0 is zero"))
			(1..999).forEach[Assert.assertTrue(out.contains(it + " is " + (if(it % 2 == 0)"even" else "odd")))]
		], 2000)
	}
	
	@Test
	def infiniteServerPlus(){
		compileAndRun('''
		infrastructure infr
		
		process P {
			set [proc.x := 0];
			send{proc.x}@(true);
			call(Pp)
		}
		
		process Pp {
			if (proc.x < 1000){
				set [proc.x := proc.x + 1];
				send{proc.x}@(true);
				call(Pp)
			} else {
				set;
			}
		}
		
		process Q {
			loop{
				receive{
					case (even(proc.x)){x}print("$x$ is even"):{} 
					case (!(even(proc.x))){x}print("$x$ is odd"):{}
				}
			}
		}
		
		function bool even(int x){
			return x % 2 == 0
		}
		
		component {} P
		component {} Q
		''',[out, err| 
			var init = 0
			for(i : 0..999){ // must be received in order
				val pl = out.substring(init).indexOf(i + " is " + (if(i % 2 == 0)"even" else "odd")) 
				Assert.assertTrue(pl >= 0)
				init = init + pl
			}
		], 2000)
	}
}
