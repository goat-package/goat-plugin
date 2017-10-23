package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.Expression

class CodeSendPred {
	
	val Expression pred
	val LocalVariableMap localAttributes
	val CharSequence attrName
	
	new(Expression pred, LocalVariableMap localAttributes, CharSequence attrName) {
		this.pred = pred
		this.localAttributes = localAttributes
		this.attrName = attrName
	}
	
	def getCode() {
		CodeExpression.getOutputPredicate(pred, localAttributes, attrName)
	}
}