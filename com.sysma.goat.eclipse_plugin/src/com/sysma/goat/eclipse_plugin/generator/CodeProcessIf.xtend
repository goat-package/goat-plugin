package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet

class CodeProcessIf {
	
	val ProcessIf ifProcess
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessIf ifProcess, LocalVariableMap map, CharSequence procRef) {
		this.ifProcess = ifProcess
		this.map = map
		this.procRef = procRef
	}
	
	def code() {
		val attrVar = "attr"
		val branchChoiceVar = "branchIf"
		val branchReceiveVar = "branchReceive"
		val conds = ifProcess.cond.map[CodeExpression.cast(ExprType.BOOL, it, map, attrVar)] + 
			if (ifProcess.action.length > ifProcess.cond.length) #["true"] else #[]
		'''
		{
			var «branchChoiceVar» int
			var «branchReceiveVar» int
			_ = «branchReceiveVar»
			«procRef».SendOrReceive(func(«attrVar» *goat.Attributes, receiving bool) goat.SendReceive{
				«FOR branch : conds.indexed»
					«var action = ifProcess.action.get(branch.key)»
					«var cond = branch.value»
					if(«cond»){
						«branchChoiceVar» = «branch.key»
						if (receiving != «action instanceof ProcessReceive»){
							return goat.ThenFail()
						} else {
							«IF action instanceof ProcessReceive»
								return goat.ThenReceive(«new CodeProcessReceive(action, map, procRef).getAcceptCode(branchReceiveVar)»)
							«ELSEIF action instanceof ProcessSend»
								«new CodeProcessSend(action as ProcessSend, map, procRef).getCodeIfBranch(attrVar)»
							«ELSEIF action instanceof ProcessSet»
								«new CodeProcessSet(action as ProcessSet, map, procRef).getCodeIfBranch(attrVar)»
							«ELSE»
								@ERR NOT IMPLEMENTED
							«ENDIF»
						}
					}
				«ENDFOR»
				
				return goat.ThenFail()
			})
			
			switch «branchChoiceVar» {
				«FOR branch : ifProcess.action.indexed»
					case «branch.key»:
					{
						«var action = branch.value»
						«var then = ifProcess.then.get(branch.key)»
						«IF action instanceof ProcessReceive»
							«new CodeProcessReceive(action, map, procRef).getThenCode(branchReceiveVar)»
						«ENDIF»
						«new CodeProcessBlock(then, map, procRef).code»
					}
				«ENDFOR»
				default:
					panic("Invalid branch!")
			}
		}
		'''
	}
	
}