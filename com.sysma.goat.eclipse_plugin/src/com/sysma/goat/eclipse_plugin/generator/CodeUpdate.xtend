package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.Update
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateComponentAttribute
import com.sysma.goat.eclipse_plugin.goatComponents.UpdateLocalAttribute

class CodeUpdate {
	val Update update
	val LocalVariableMap map
	val CharSequence procRef
	val CharSequence attrName
	
	new(Update update, LocalVariableMap map, CharSequence procRef, CharSequence attrName){
		this.update = update
		this.map = map
		this.procRef = procRef
		this.attrName = attrName
	}
	
	def CharSequence getCode(){
		update.attribute.indexed.map[vidx|
			val varUpd = vidx.value
			val valUpd = CodeExpression.getExpressionWithAttributes(update.value.get(vidx.key), map, attrName)
			switch(varUpd){
				UpdateComponentAttribute:
					'''«attrName».Set("«varUpd.atname»", «valUpd»)'''
				UpdateLocalAttribute:
					map.assign(varUpd.atname, valUpd)
				default:
					""
			}
		].join("\n")
	}
}