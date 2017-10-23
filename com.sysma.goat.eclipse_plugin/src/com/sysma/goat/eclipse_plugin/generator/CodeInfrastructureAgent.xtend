package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure
import com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree

class CodeInfrastructureAgent {
	val Infrastructure infr
	
	new (Infrastructure infr){
		this.infr = infr
	}
	
	def getCode(){
		switch(infr){
			SingleServer:{
				'''goat.NewSingleServerAgent("«infr.server»")'''
			}
			Cluster:
			{
				'''goat.NewClusterAgent("«infr.message_queue»", "«infr.registration»")'''
			}
			Ring:
			{
				'''goat.NewRingAgent("«infr.registration»")'''
			}
			Tree:
			{
				'''goat.NewTreeAgent("«infr.registration»")'''
			}
			default:
				""
		}
	}
}