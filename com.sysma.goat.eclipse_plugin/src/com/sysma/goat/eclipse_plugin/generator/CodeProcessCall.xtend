package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall

class CodeProcessCall {
	
	val ProcessCall call
	
	new(ProcessCall call) {
		this.call = call
	}
	
	def getCode() {
		'''return «new CodeProcessDefinition(call.proc).process_func_name»'''
	}
	
}