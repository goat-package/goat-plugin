package com.sysma.goat.eclipse_plugin.generator

import static extension com.sysma.goat.eclipse_plugin.generator.Utils.*
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring

class CodeRing implements CodeInfrastructure {
	val Ring ring;
	
	new(Ring ring){
		this.ring = ring
	}
	
	override getCode(){
		val mustWait = ring.mid_assigner.isLocalAddress || ring.registration.isLocalAddress ||
			!ring.nodes.filter[isLocalAddress].empty
		'''
			package main
			import (
				«Utils.importPath»
				"fmt"
			)
			
			func main(){
				«IF ring.mid_assigner.isLocalAddress»
					go goat.NewClusterCounter(«ring.mid_assigner.portNumber»).Work(0, make(chan struct{}))
				«ENDIF»
				«IF ring.registration.isLocalAddress»
					go goat.NewRingAgentRegistration(«ring.registration.portNumber», «ring.nodes.goList»).Work(0, make(chan struct{}))
				«ENDIF»
				«FOR node : ring.nodes.indexed.filter[value.isLocalAddress]»
					go goat.NewRingNode(«node.value.portNumber», "«ring.mid_assigner»", "«ring.nodes.get((node.key + 1)%(ring.nodes.length))»").Work(0, make(chan struct{}))
				«ENDFOR»
				fmt.Println("Started")
				«IF mustWait»
					<- make(chan bool)
				«ELSE»
					_ = goat.NewClusterCounter
				«ENDIF»
			}
		'''
	}
}