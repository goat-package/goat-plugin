package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ComponentDefinition
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure
import com.sysma.goat.eclipse_plugin.goatComponents.Environment
import com.sysma.goat.eclipse_plugin.goatComponents.EnvironmentDefinition

class CodeComponentDefinition {
	
	val ComponentDefinition cdef
	val CharSequence mainFunc
	val CharSequence compName
	
	new(ComponentDefinition cdef, CharSequence runFunc, CharSequence compName){
		this.cdef = cdef
		this.mainFunc = runFunc
		this.compName = compName
	}
	
	def getComponentDeclaration(Infrastructure infr){
		val infrCode = new CodeInfrastructureAgent(infr).code
		val envCode = if(cdef.env !== null) {getCode(cdef.env)} else {getCode(cdef.envref.env)}
		'''
			«compName» := goat.NewComponentWithAttributes(«infrCode»,  «envCode»)
		'''
	}
	
	private def getCode(Environment env){
		'''
		map[string]interface{}{
			«FOR v : env.attrs.indexed»
				"«v.value»" : «CodeExpression.getExpressionWithoutAttributes(env.vals.get(v.key))»,
			«ENDFOR»
		}'''
	}
	
	def getCode() {
		val fncCode = new CodeProcessBlock(cdef.block, new LocalVariableMap("locvar"), "p").codeAsFunction
		'''
		goat.NewProcess(«compName»).Run(«mainFunc»(&wg, «fncCode», &(map[string]interface{}{})))'''
	}
	
}
