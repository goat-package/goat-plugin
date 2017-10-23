package com.sysma.goat.eclipse_plugin.generator

import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.core.runtime.Path

class CommandLineContext extends GeneratorContext {
	public val Path projectPath;
	new(String projectPath){
		super() 
		cancelIndicator = CancelIndicator.NullImpl
		this.projectPath = new Path(projectPath)
		
	}
}