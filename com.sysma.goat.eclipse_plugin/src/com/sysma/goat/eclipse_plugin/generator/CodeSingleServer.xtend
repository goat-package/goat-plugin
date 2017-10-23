package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer
import static extension com.sysma.goat.eclipse_plugin.generator.Utils.*

class CodeSingleServer implements CodeInfrastructure {
	val SingleServer ssrv;
	
	new(SingleServer ssrv){
		this.ssrv = ssrv
	}
	
	override getCode(){
		'''
			package main
			import (
				«Utils.importPath»
				"fmt"
			)
			
			func main(){
				«IF ssrv.server.isLocalAddress»
				term := make(chan struct{})
				goat.RunCentralServer(«ssrv.server.portNumber», term, «ssrv.timeout»)
				fmt.Println("Started")
				<- term
				fmt.Println("Terminated")
				«ELSE»
				fmt.Println("Started")
				_ = goat.RunCentralServer
				«ENDIF»
			}
		'''
	}
	
	def String getServerAddress(){
		ssrv.server
	}
}