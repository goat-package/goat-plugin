package com.sysma.goat.eclipse_plugin.generator

import static extension com.sysma.goat.eclipse_plugin.generator.Utils.*
import com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree
import com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode
import java.util.List

class CodeTree implements CodeInfrastructure {
	val Tree tree;
	
	new(Tree tree){
		this.tree = tree
	}
	
	private static def List<String> makePlainList(TreeNode node){
		nodesList(node).map[address]
	}
	
	private static def parentNode(TreeNode node){
		if (node.eContainer instanceof TreeNode) {
			node.eContainer as TreeNode
		} else {
			null as TreeNode
		}
	}
	
	private static def List<TreeNode> nodesList(TreeNode node){
		val out = newArrayList(node)
		node.children.map[nodesList].forEach[
			out.addAll(it)
		]
		out
	}
	
	override getCode(){
		val mustWait = tree.registration.isLocalAddress || 
			!tree.root.nodesList.filter[address.isLocalAddress].empty
		'''
			package main
			import (
				«Utils.importPath»
				"fmt"
			)
			
			func main(){
				«IF tree.registration.isLocalAddress»
					go goat.NewTreeAgentRegistration(«tree.registration.portNumber», «tree.root.makePlainList.goList»).Work(0, make(chan struct{}))
				«ENDIF»
				«FOR node : tree.root.nodesList.filter[address.isLocalAddress]»
					go goat.NewTreeNode(«node.address.portNumber», "«(node.parentNode?.address)?:""»", «node.children.map[address].goList»).Work(0, make(chan struct{}))
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