package com.sysma.goat.eclipse_plugin.ui

import java.io.InputStream
import java.io.OutputStream
import java.util.HashMap
import java.util.Map
import java.util.ArrayList

class StreamCopier implements Runnable {
	val InputStream from;
	val OutputStream to;
	val Map<String, ArrayList<()=>void>> listeners = new HashMap<String, ArrayList<()=>void>>();
	
	new (InputStream from, OutputStream to){
		this.from = from
		this.to = to
	}
	
	def addListener(String line, ()=>void todo){
		if(listeners.containsKey(line)){
			listeners.get(line).add(todo);
		} else {
			listeners.put(line, newArrayList(todo));
		}
		this
	}
	
	override run() {
		var line = ""
		var int chr;
		while((chr = from.read()) != -1) {
			to.write(chr)
			if (chr == 10) {
				to.flush()
				check(line)
				line = ""
			} else {
				line += chr as char;
			}
		}
		to.flush()
		check(line)
		line = ""
	}
	
	def private check(String line){
		listeners.get(line)?.forEach[apply]
		listeners.remove(line)
	}
	
}
