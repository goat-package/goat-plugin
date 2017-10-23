package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement
import com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement
import java.util.ArrayList
import org.apache.commons.lang.math.NumberUtils
import java.util.List
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.goatComponents.impl.LocalAttributeRefImpl

class CodePrint {
	
	private static class LocalAttributeRefImplConversion  extends LocalAttributeRefImpl{
		new (String attrname){
			super()
			this.attribute = attrname
		}
	}
	
	def static of(PrintStatement pstat, String componentAttr, LocalVariableMap localAttr, List<Expression> message){
		switch pstat{
			PrintFormattedStatement:
				'''fmt.Println(«convertString(pstat.toPrint, componentAttr, localAttr, message)»)'''
			default:
				""
		}
	}
	
	def static ofProcAttrs(PrintStatement pstat, String componentAttr, LocalVariableMap localAttr, List<String> message){
		val exprMessage = message.map[new LocalAttributeRefImplConversion(it) as Expression]
		CodePrint.of(pstat, componentAttr, localAttr, exprMessage)
	}
	
	def private static escape(String escapedSequence, String componentAttr, LocalVariableMap localAttr, List<Expression> message){
		if(escapedSequence.length == 0){
			return ('"$"')
		} else if (NumberUtils.isDigits(escapedSequence)) {
			val tupleIdx = Integer.parseInt(escapedSequence)
			if (tupleIdx >= message.length){
				return '''"<invalid tuple index>"'''
		    } else {
		    	//val attribCode = new CodeAttribute(message.get(tupleIdx), componentAttr, localAttr)
				return ('''fmt.Sprintf("%s: %v","«""»", «CodeExpression.getExpressionWithAttributes(message.get(tupleIdx),localAttr, componentAttr)»)''')
			}
		} else{
			var attrName = ""
			var compLevel = false
			if(escapedSequence.startsWith("comp.")){
				compLevel = true
				attrName = escapedSequence.substring(5)
			} else {
				compLevel = false
				attrName = escapedSequence
			}
			val attribCode = new CodeAttribute(attrName,compLevel, componentAttr, localAttr)
			return ('''fmt.Sprintf("%v",«attribCode.read»)''')
		}
	}
	
	// TODO escaping actual strings for go
	def private static convertString(String text, String componentAttr, LocalVariableMap localAttr, List<Expression> message){
		var outTokens = new ArrayList<String>()
		var String escapedSequence = null
		var actualString = ""
		
		for(ch:text.toCharArray){
			if(ch == '$'.charAt(0)){
				if(escapedSequence === null){
					escapedSequence =  ""
					outTokens.add('"'+actualString+'"')
				} else {
					outTokens.add(escape(escapedSequence, componentAttr, localAttr, message))
					escapedSequence = null
				}
				actualString =  ""
			} else {
				if(escapedSequence === null){
					actualString += ch
				} else {
					escapedSequence += ch
				}
			}
		}
		if (escapedSequence === null){
			outTokens.add('"'+actualString+'"')
		} else {
			outTokens.add(escape(escapedSequence, componentAttr, localAttr, message))
		}
		return String.join(" + ", outTokens)
	}
}