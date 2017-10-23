package com.sysma.goat.eclipse_plugin.ui

import org.eclipse.ui.console.IOConsole
import org.eclipse.jface.resource.ImageDescriptor

class Console extends IOConsole {
	
	private var ConsoleActions observer;
	private var Process process;
	
	new(String name, ImageDescriptor imageDescriptor) {
		super(name, imageDescriptor)
	}
	
	new(String name, String consoleType, ImageDescriptor imageDescriptor, boolean autoLifecycle) {
		super(name, consoleType, imageDescriptor, autoLifecycle)
	}
	
	def setProcess(Process p){
		process = p
		if (observer !== null){
			observer.process = process
		}
	}
	
	def setObserver(ConsoleActions o){
		this.observer = o
		if (process !== null){
			observer.process = process
		}
	}
}