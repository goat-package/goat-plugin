package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet

class CodeProcessSet {
	val ProcessSet set
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessSet set, LocalVariableMap map, CharSequence procRef) {
		this.set = set
		this.map = map
		this.procRef = procRef
	}
	
	def getCode() {
		getCodeWithPrecondition(null)
	}
	
	def getCodeWithPrecondition(Expression precond){
		val attrVar = "attrs"
		'''
		«procRef».SendFunc(func(«attrVar» *goat.Attributes) (goat.Tuple, goat.Predicate, bool){
			«IF precond !== null»
				if (!«CodeExpression.cast(ExprType.BOOL,precond, map, attrVar)»){
					return goat.NewTuple(), goat.False(), false
				}
			«ENDIF»
			«new CodeUpdate(set.update, map, procRef, attrVar).code»
			«IF set.print !== null»
				«CodePrint.of(set.print, attrVar, map, #[])»
			«ENDIF»
			return goat.NewTuple(), goat.False(), true
		})
		'''
	}
	
	def getCodeIfBranch(String attrVar){
		'''
		«new CodeUpdate(set.update, map, procRef, attrVar).code»
		«IF set.print !== null»
			«CodePrint.of(set.print, attrVar, map, #[])»
		«ENDIF»
		return goat.ThenSend(goat.NewTuple(), goat.False())
		'''
	}
}