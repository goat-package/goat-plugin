package com.sysma.goat.eclipse_plugin.tests.parser

import com.sysma.goat.eclipse_plugin.tests.GoatComponentsInjectorProvider
import com.google.inject.Inject
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse
import com.sysma.goat.eclipse_plugin.goatComponents.Comparison
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration
import static extension com.sysma.goat.eclipse_plugin.tests.parser.ParsingTestHelper.*

@RunWith(XtextRunner)
@InjectWith(GoatComponentsInjectorProvider)
class FunctionParsingTest {
	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	def functionDecl(){
		val result = parseHelper.parse('''
			infrastructure infr
			
			function int fun (int i, string s, bool b){
				return 4
			}
		''')
		Assert.assertNotNull(result)
		result.checkNoErrorApartInfr
		var func = result.functions.get(0)
		Assert.assertTrue(func.type == "int")
		Assert.assertTrue(func.name == "fun")
		Assert.assertTrue(func.params.length == 3)
		
		Assert.assertTrue(func.params.get(0).name == "i")
		Assert.assertTrue(func.params.get(0).type == "int")
		Assert.assertTrue(func.params.get(1).name == "s")
		Assert.assertTrue(func.params.get(1).type == "string")
		Assert.assertTrue(func.params.get(2).name == "b")
		Assert.assertTrue(func.params.get(2).type == "bool")
	}
	
	@Test
	def functionMix(){
		val result = parseHelper.parse('''
			infrastructure infr
			
			function int fun (int i, string s, bool b){
				var y = i
				if (y > 5) {
					return 0
				} else if (y < 5) {
					return 1
				} else {
					return 2
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkNoErrorApartInfr
		var func = result.functions.get(0)
		Assert.assertTrue(func.type == "int")
		Assert.assertTrue(func.name == "fun")
		Assert.assertTrue(func.params.length == 3)
		Assert.assertTrue(func.params.get(0).name == "i")
		Assert.assertTrue(func.params.get(0).type == "int")
		Assert.assertTrue(func.params.get(1).name == "s")
		Assert.assertTrue(func.params.get(1).type == "string")
		Assert.assertTrue(func.params.get(2).name == "b")
		Assert.assertTrue(func.params.get(2).type == "bool")
		Assert.assertTrue(func.blk.statements.length == 2)
		
		val ass = func.blk.statements.get(0) as FuncVarDeclaration
		Assert.assertTrue(ass.name == "y")
		
		val if_ = func.blk.statements.get(1) as FuncIfElse
		Assert.assertTrue(if_.test.length == 2)
		Assert.assertTrue((if_.test.get(0) as Comparison).op == ">")
		Assert.assertTrue((if_.test.get(1) as Comparison).op == "<")
		Assert.assertTrue(((if_.then.get(0).statements.get(0) as FuncReturn).^val as IntConstant).value == 0)
		Assert.assertTrue(((if_.then.get(1).statements.get(0) as FuncReturn).^val as IntConstant).value == 1)
		Assert.assertTrue(((if_.elseBranch.statements.get(0) as FuncReturn).^val as IntConstant).value == 2)
	}
	
	@Test
	def ifElifNoElse(){
		val result = parseHelper.parse('''
			infrastructure infr
			
			function int fun (int i, string s, bool b){
				var y = i
				if (y > 5) {
					return 0
				} else if (y < 5) {
					return 1
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkNoErrorApartInfr
		var func = result.functions.get(0)
		Assert.assertTrue(func.type == "int")
		Assert.assertTrue(func.name == "fun")
		Assert.assertTrue(func.params.length == 3)
		Assert.assertTrue(func.params.get(0).name == "i")
		Assert.assertTrue(func.params.get(0).type == "int")
		Assert.assertTrue(func.params.get(1).name == "s")
		Assert.assertTrue(func.params.get(1).type == "string")
		Assert.assertTrue(func.params.get(2).name == "b")
		Assert.assertTrue(func.params.get(2).type == "bool")
		Assert.assertTrue(func.blk.statements.length == 2)
		
		val ass = func.blk.statements.get(0) as FuncVarDeclaration
		Assert.assertTrue(ass.name == "y")
		
		val if_ = func.blk.statements.get(1) as FuncIfElse
		Assert.assertTrue(if_.test.length == 2)
		Assert.assertTrue((if_.test.get(0) as Comparison).op == ">")
		Assert.assertTrue((if_.test.get(1) as Comparison).op == "<")
		Assert.assertTrue(((if_.then.get(0).statements.get(0) as FuncReturn).^val as IntConstant).value == 0)
		Assert.assertTrue(((if_.then.get(1).statements.get(0) as FuncReturn).^val as IntConstant).value == 1)
		Assert.assertNull(if_.elseBranch)
	}
	
	@Test
	def ifElse(){
		val result = parseHelper.parse('''
			infrastructure infr

			function int fun (int i, string s, bool b){
				var y = i
				if (y > 5) {
					return 0
				} else {
					return 1
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkNoErrorApartInfr
	}
	
	@Test
	def elseNoConds(){
		val result = parseHelper.parse('''
			infrastructure infr
			
			function int fun (int i, string s, bool b){
				var y = i
				if (y > 5) {
					return 0
				} else (true) {
					return 1
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkErrorApartInfr
	}
	
	@Test
	def maxOneElse(){
		val result = parseHelper.parse('''
			infrastructure infr

			function int fun (int i, string s, bool b){
				var y = i
				if (y > 5) {
					return 0
				} else {
					return 1
				} else {
					return 1
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkErrorApartInfr
	}
	
	@Test
	def elseAlone(){
		val result = parseHelper.parse('''
			infrastructure infr

			function int fun (int i, string s, bool b){
				else {
					return 1
				}
			}
		''')
		Assert.assertNotNull(result)
		result.checkErrorApartInfr
	}
	
	@Test
	def assign(){
		val result = parseHelper.parse('''
			infrastructure infr

			function int fun (int i, string s, bool b){
				var y = i
				var x = 9
				y = x
			}
		''')
		Assert.assertNotNull(result)
		result.checkNoErrorApartInfr
		Assert.assertTrue((result.functions.get(0).blk.statements.get(2) as FuncVarAssign).^var.name == "y")
	}
}