package com.sysma.goat.eclipse_plugin.generator

import static extension com.sysma.goat.eclipse_plugin.generator.Utils.*
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster

class CodeCluster implements CodeInfrastructure {
	val Cluster cluster;
	
	new(Cluster cluster){
		this.cluster = cluster
	}
	
	override getCode(){
		val mustWait = cluster.mid_assigner.isLocalAddress || cluster.registration.isLocalAddress ||
			cluster.message_queue.isLocalAddress || !cluster.nodes.filter[isLocalAddress].empty
		'''
			package main
			import (
				«Utils.importPath»
				"fmt"
			)
			
			func main(){
				«IF cluster.mid_assigner.isLocalAddress»
					go goat.NewClusterCounter(«cluster.mid_assigner.portNumber»).Work(0, make(chan struct{}))
				«ENDIF»
				«IF cluster.registration.isLocalAddress»
					go goat.NewClusterAgentRegistration(«cluster.registration.portNumber», "«cluster.mid_assigner»", «cluster.nodes.goList»).Work(0, make(chan struct{}))
				«ENDIF»
				«IF cluster.message_queue.isLocalAddress»
					go goat.NewClusterMessageQueue(«cluster.message_queue.portNumber»).Work(0, make(chan struct{}))
				«ENDIF»
				«FOR node : cluster.nodes.filter[isLocalAddress]»
					go goat.NewClusterNode(«node.portNumber», "«cluster.message_queue»", "«cluster.mid_assigner»", "«cluster.registration»").Work(0, make(chan struct{}))
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