package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType

class CodeProcessSend {
	val ProcessSend send
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessSend send, LocalVariableMap map, CharSequence procRef) {
		this.send = send
		this.map = map
		this.procRef = procRef
	}
	
	def getCode() {
		getCodeWithPrecondition(null)
	}
	
	def getCodeWithPrecondition(Expression precond){
		val messageVar = "msg"
		val attrVar = "attrs"
		val messageParts = (send.msgOutParts?:#[]).map[CodeExpression.getExpressionWithAttributes(it, map, attrVar)]
		'''
		«procRef».SendFunc(func(«attrVar» *goat.Attributes) (goat.Tuple, goat.Predicate, bool){
			«IF precond !== null»
				if (!«CodeExpression.cast(ExprType.BOOL,precond, map, attrVar)»){
					return goat.NewTuple(), goat.False(), false
				}
			«ENDIF»
			«messageVar» := goat.NewTuple(«messageParts.join(", ")»)
			pred := «new CodeSendPred(send.send_pred,map, attrVar).code»
			«new CodeUpdate(send.updates, map, procRef, attrVar).code»
			«IF send.print !== null»
				«CodePrint.of(send.print, attrVar, map, (send.msgOutParts?:#[]))»
			«ENDIF»
			return «messageVar», pred, true
		})
		'''
	}
	
	def getCodeIfBranch(String attrVar){
		val messageParts = (send.msgOutParts?:#[]).map[CodeExpression.getExpressionWithAttributes(it, map, attrVar)]
		val messageVar = "msg"
		'''
		«messageVar» := goat.NewTuple(«messageParts.join(", ")»)
		pred := «new CodeSendPred(send.send_pred,map, attrVar).code»
		«new CodeUpdate(send.updates, map, procRef, attrVar).code»
		«IF send.print !== null»
			«CodePrint.of(send.print, attrVar, map, (send.msgOutParts?:#[]))»
		«ENDIF»
		return goat.ThenSend(«messageVar», pred.CloseUnder(«attrVar»))
		'''
	}
}