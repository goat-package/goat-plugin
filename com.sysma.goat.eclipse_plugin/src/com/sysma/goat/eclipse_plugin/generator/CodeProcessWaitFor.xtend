package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType

class CodeProcessWaitFor {
	val ProcessWaitFor waitfor
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessWaitFor waitfor, LocalVariableMap map, CharSequence procRef) {
		this.waitfor = waitfor
		this.map = map
		this.procRef = procRef
	}
	
	def getCode() {
		val attrVar = "attrs"
		if (waitfor.cond instanceof IntConstant){
			val msec = (waitfor.cond as IntConstant).value
			'''
			«procRef».Sleep(«msec»)
			«IF waitfor.update.attribute.length > 0 || waitfor.print !== null»
				«procRef».WaitUntilTrue(func(«attrVar» *goat.Attributes) bool{
					«new CodeUpdate(waitfor.update, map, procRef, attrVar).code»
					«IF waitfor.print !== null»
						«CodePrint.of(waitfor.print, attrVar, map, #[])»
					«ENDIF»
					return true
				})
			«ENDIF»
			'''
		} else {
			'''
			«procRef».WaitUntilTrue(func(«attrVar» *goat.Attributes) bool{
				if («CodeExpression.cast(ExprType.BOOL, waitfor.cond, map, attrVar)»){
					«new CodeUpdate(waitfor.update, map, procRef, attrVar).code»
					«IF waitfor.print !== null»
						«CodePrint.of(waitfor.print, attrVar, map, #[])»
					«ENDIF»
					return true
				} else {
					return false
				}
			})
			'''
		}
	}
}