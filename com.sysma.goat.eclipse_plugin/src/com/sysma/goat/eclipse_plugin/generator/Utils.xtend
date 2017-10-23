package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.ProcessStatement
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSpawn
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessCall
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessLoop
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessReceive
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessIf
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSet
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor
import java.net.InetAddress
import com.google.common.net.HostAndPort
import java.util.List

class Utils{
	def static getImportPath(){
		'''"github.com/goat-package/goat/goat"'''
	}
	
	def static getCode(ProcessStatement stmt, LocalVariableMap locvars, CharSequence processRef){
		switch(stmt){
			ProcessSpawn:
				new CodeProcessSpawn(stmt, locvars, processRef).code
			ProcessCall:
				new CodeProcessCall(stmt).code
			ProcessLoop:
				new CodeProcessLoop(stmt, locvars, processRef).code
			ProcessSend:
				new CodeProcessSend(stmt, locvars, processRef).code
			ProcessReceive:
				new CodeProcessReceive(stmt, locvars, processRef).code
			ProcessIf:
				new CodeProcessIf(stmt, locvars, processRef).code
			ProcessSet:
				new CodeProcessSet(stmt, locvars, processRef).code
			ProcessWaitFor:
				new CodeProcessWaitFor(stmt, locvars, processRef).code
			default:
				throw new UnsupportedOperationException("not implemented")
		}
	}
	
	def static utilityFunctions(){
		'''
		func runWith(wg *sync.WaitGroup, pfunc continuationProcess, vars *map[string]interface{}) func(*goat.Process){
		    wg.Add(1)
			return func(p *goat.Process){
				for fnc := pfunc; fnc != nil; fnc = fnc(wg, vars, p) {}
				wg.Done()
			}
		}
		
		func mapCopy(x *map[string]interface{}) *map[string]interface{}{
			cx := map[string]interface{}{}
			for k,v := range *x {
				cx[k] = v
			}
			return &cx
		}
		
		func getValue(x *map[string]interface{}, k string) interface{}{
			v, _ := (*x)[k]
			return v
		}
		
		func has(x *map[string]interface{}, k string) bool{
			_, h := (*x)[k]
			return h
		}
		'''
	}
	
	def static isLocalAddress(String address){
		val ad = InetAddress.getByName(HostAndPort.fromString(address).host)
		ad.isLoopbackAddress
	}
	
	def static getPortNumber(String address){
		HostAndPort.fromString(address).port
	}
	
	def static goList(List<String> strings){
		'''[]string{«strings.map['''"«it»"'''].join(", ")»}'''
	}
}