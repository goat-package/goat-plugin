package com.sysma.goat.eclipse_plugin.generator

import java.util.List
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure

class CodeModel {
	val String packageName
	val String mainFuncName
	val List<CodeProcessDefinition> processes
	val Iterable<CodeComponentDefinition> components
	val Iterable<CodeFunction> functions
	val Infrastructure infr
	public static val runFuncName = "runWith"
	
	new(Model model){
		packageName = "main"
		mainFuncName = "main"
		processes = model.processes.map[new CodeProcessDefinition(it)]
		components = model.components.indexed.map[pair | new CodeComponentDefinition(pair.value, runFuncName, '''comp_«pair.key»''')]
		functions = model.functions.map[new CodeFunction(it)]
		infr = model.infrastructure
	}
	
	def static getGoatProcessReference(){
		"p"
	}
	
	def getCode(){
		'''
		package «packageName»
		
		import (
			«Utils.importPath»
			"strings"
			"fmt"
			"strconv"
			"sync"
		)
		
		type continuationProcess func(*sync.WaitGroup, *map[string]interface{}, *goat.Process) continuationProcess
		
		«Utils.utilityFunctions»
		
		«FOR func: functions»
			«func.code»
		«ENDFOR»
		
		«FOR c_pdef : processes»
			«c_pdef.code»
		«ENDFOR»
		
		func «mainFuncName»(){
			//Needed to avoid golang errors "imported and not used"
			_ = func(){
				fmt.Println(strings.Join([]string{},""))
				strconv.Atoi("")
			}
			
			var wg sync.WaitGroup
			«FOR cdef: components»
				«cdef.getComponentDeclaration(infr)»
			«ENDFOR»
			«FOR cdef: components»
				«cdef.code»
			«ENDFOR»
			wg.Wait()
		}
		'''
	}
	
}