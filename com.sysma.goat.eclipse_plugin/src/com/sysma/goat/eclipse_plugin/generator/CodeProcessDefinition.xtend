package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessDefinition

class CodeProcessDefinition {
	val ProcessDefinition pdef
	
	new(ProcessDefinition pdef){
		this.pdef = pdef
	}
	
	def getCode() {
		var localVariablesMap = new LocalVariableMap("locvar")
		var CharSequence procReference = "p"
		'''
		func «process_func_name»(wg *sync.WaitGroup, «localVariablesMap.name» *map[string]interface{}, «procReference» *goat.Process) continuationProcess{
			«new CodeProcessBlock(pdef.block, localVariablesMap, procReference).code»
			return nil
		}
		'''
	}
	
	def getProcess_func_name() {
		return '''pr_«pdef.name»'''
	}
	
}