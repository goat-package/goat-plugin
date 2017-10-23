package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType

class CodeProcessReceive {
	
	val ProcessReceive receive
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessReceive receive, LocalVariableMap map, CharSequence procRef) {
		this.receive = receive
		this.map = map
		this.procRef = procRef
	}
	
	def getCode() {
		val varForChoice = "branch"
		//val attributesVar = "attrs"
		'''
		{
			var «varForChoice» int
			«procRef».Receive(«getAcceptCode(varForChoice)»)
			
			«getThenCode(varForChoice)»
		}
		'''
	}
	
	def getAcceptCode(String varForChoice){
		val messageVar = "msg"
		val attributesVar = "attrs"
		val locVarBak = new LocalVariableMap("locvarBak")
		'''
		func(«attributesVar» *goat.Attributes, «messageVar» goat.Tuple)bool{
			«locVarBak.declare»
			«FOR input: receive.cases.indexed»
			if («messageVar».IsLong(«(input.value.msgInParts?:#[]).length»)) {
				«locVarBak.name» = «map.copy»
				«FOR v : (input.value.msgInParts?:#[]).indexed»
					«locVarBak.assign(v.value, '''«messageVar».Get(«v.key»)''')»
				«ENDFOR»
				if(«CodeExpression.cast(ExprType.BOOL, input.value.cond, locVarBak, attributesVar)»){
					«varForChoice» = «input.key»
					«FOR v : (input.value.msgInParts?:#[]).indexed»
						«map.assign(v.value, '''«messageVar».Get(«v.key»)''')»
					«ENDFOR»
					«new CodeUpdate(input.value.updates, map, procRef, attributesVar).code»
					«CodePrint.ofProcAttrs(input.value.print, attributesVar, map, (input.value.msgInParts?:#[]))»
					return true
				}
			}
			«ENDFOR»
			return false
		}'''
	}
	
	def getThenCode(String varForChoice){
		'''
		switch(«varForChoice»){
			«FOR input: receive.cases.indexed»
			case «input.key»:
			{
				«new CodeProcessBlock(receive.then.get(input.key), map, procRef).code»
			}
			«ENDFOR»
			default:
				panic("Invalid branch!")
		}'''
	}
	
}