package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessLoop

class CodeProcessLoop {
	
	val ProcessLoop loop
	val LocalVariableMap map
	val CharSequence procRef
	
	new(ProcessLoop loop, LocalVariableMap map, CharSequence procRef) {
		this.map = map
		this.loop = loop
		this.procRef = procRef
	}
	
	def getCode() {
		'''
		for {
			«new CodeProcessBlock(loop.block, map, procRef).code»
		}
		'''
	}
	
}