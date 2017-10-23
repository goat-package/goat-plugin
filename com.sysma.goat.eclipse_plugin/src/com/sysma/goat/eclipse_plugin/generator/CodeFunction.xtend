package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition
import com.sysma.goat.eclipse_plugin.goatComponents.FuncBlock
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping

class CodeFunction {
	val FuncDefinition definition;
	
	new(FuncDefinition fdef){
		definition = fdef
	}
	
	def getCode(){
		'''
			func f_«definition.name»(«
			definition.params.map['''«it.name» «ExpressionTyping.goType(it.type)»'''].join(",")») «ExpressionTyping.goType(definition.type)» «makeCode(definition.blk)»
		'''
	}
	
	def CharSequence makeCode(Object item){
		switch item{
			FuncBlock:
				'''
				{
					«item.statements.map[makeCode].join('\n')»
				}'''
			FuncVarAssign:
				'''«item.^var.name» = «makeCode(item.^val)»'''
			FuncIfElse:
				(0..<item.then.length).map[i|
					'''
					if («makeCode(item.test.get(i))») «makeCode(item.then.get(i))»'''].join("else ") 
							+ 
				if (item.elseBranch !== null) {
					'''else «makeCode(item.elseBranch)»'''
				} else {
					''
				}
			FuncReturn:
				'''return «makeCode(item.^val)»'''
			FuncVarDeclaration:
				'''
				var «item.name» = «makeCode(item.^val)»
				_ = «item.name»'''
			Expression:
				CodeExpression.getExpressionWithoutAttributes(item)
		}
	}
}
