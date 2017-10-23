package com.sysma.goat.eclipse_plugin.generator

class CodeAttribute {
	val String attribute
	val boolean comp
	val String componentMap
	val LocalVariableMap localMap
	
	new(String attrName, boolean comp, String componentMap, LocalVariableMap localMap){
		this.attribute = attrName
		this.comp = comp
		this.componentMap = componentMap
		this.localMap = localMap
	}
	
	def assign(CharSequence value) {
		if (comp) {
			'''«componentMap».Set("«attribute»", «value»)'''
		} else {
			localMap.assign(attribute, value)
		}
	}
	
	def getName(){
		if (comp) {
			'''comp.«attribute»'''
		} else {
			attribute
		}
	}
	
	def read() {
		if (comp) {
			'''«componentMap».GetValue("«attribute»")'''
		} else {
			localMap.readValue(attribute)
		}
	}
	
	def exists(){
		if (comp) {
			'''«componentMap».Has("«attribute»")'''
		} else {
			localMap.has(attribute)
		}
	}
}
