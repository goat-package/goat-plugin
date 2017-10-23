package com.sysma.goat.eclipse_plugin.generator

class LocalVariableMap {
	public val CharSequence name
	
	new(CharSequence name){
		this.name = name
	}
	
	def assign(CharSequence varname, CharSequence value){
		'''(*«name»)["«varname»"] = «value»'''
	}
	
	def declare(){
		'''«name» := new(map[string]interface{})'''
	}
	
	def copy(){
		'''mapCopy(«name»)'''
	}
	
	def readValue(String string) {
		return '''getValue(«name», "«string»")'''
	}
	
	def has(String string){
		return '''has(«name», «string»)'''
	}
}