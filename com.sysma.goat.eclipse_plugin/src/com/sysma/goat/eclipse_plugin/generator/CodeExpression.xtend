package com.sysma.goat.eclipse_plugin.generator

import com.sysma.goat.eclipse_plugin.goatComponents.And
import com.sysma.goat.eclipse_plugin.goatComponents.BoolConstant
import com.sysma.goat.eclipse_plugin.goatComponents.Comparison
import com.sysma.goat.eclipse_plugin.goatComponents.ComponentAttributeRef
import com.sysma.goat.eclipse_plugin.goatComponents.Equality
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.goatComponents.FunctionCall
import com.sysma.goat.eclipse_plugin.goatComponents.IntConstant
import com.sysma.goat.eclipse_plugin.goatComponents.LocalAttributeRef
import com.sysma.goat.eclipse_plugin.goatComponents.Minus
import com.sysma.goat.eclipse_plugin.goatComponents.MulOrDiv
import com.sysma.goat.eclipse_plugin.goatComponents.Not
import com.sysma.goat.eclipse_plugin.goatComponents.Or
import com.sysma.goat.eclipse_plugin.goatComponents.Plus
import com.sysma.goat.eclipse_plugin.goatComponents.RecAttributeRef
import com.sysma.goat.eclipse_plugin.goatComponents.StringConstant
import org.apache.commons.lang.StringEscapeUtils
import com.sysma.goat.eclipse_plugin.goatComponents.FuncParam
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping
import com.sysma.goat.eclipse_plugin.goatComponents.LocalVarRef
import com.sysma.goat.eclipse_plugin.goatComponents.Concatenate
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType
import java.util.List
import com.sysma.goat.eclipse_plugin.goatComponents.UnaryMinus
import com.sysma.goat.eclipse_plugin.goatComponents.NegativeIntConstant

class CodeExpression {
	def static cast(String typ, Expression expr, LocalVariableMap localAttributesMap, CharSequence attributesMap){
		cast(ExpressionTyping.typeOf(typ), expr, localAttributesMap, attributesMap)
	}
	def static cast(ExprType typ, Expression expr, LocalVariableMap localAttributesMap, CharSequence attributesMap){
		val econv = getExpressionWithAttributes(expr, localAttributesMap, attributesMap)
		switch(expr){
			LocalAttributeRef, RecAttributeRef, ComponentAttributeRef:
				'''(«econv»).(«ExpressionTyping.goType(typ)»)'''
			default:
				econv
		}
	}
	
	def static CharSequence getExpressionWithAttributes(Expression expr, LocalVariableMap localAttributesMap, CharSequence attributesMap){
		switch(expr){
			And:
				'''(«expr.sub.map[cast(ExprType.BOOL, it, localAttributesMap, attributesMap)].join(" && ")»)'''
			Or:
				'''(«expr.sub.map[cast(ExprType.BOOL, it, localAttributesMap, attributesMap)].join(" || ")»)'''
			Not:
				'''(!(«cast(ExprType.BOOL, expr.expression, localAttributesMap, attributesMap)»))'''
			Equality:
				'''(goat.Cmp(«getExpressionWithAttributes(expr.left, localAttributesMap, attributesMap)», "«expr.op»", «getExpressionWithAttributes(expr.right, localAttributesMap, attributesMap)»))'''
			Comparison:
				'''(goat.Cmp(«getExpressionWithAttributes(expr.left, localAttributesMap, attributesMap)», "«expr.op»", «getExpressionWithAttributes(expr.right, localAttributesMap, attributesMap)»))'''
			BoolConstant:
				expr.value
			Plus:
				'''(«cast(ExprType.INT, expr.left, localAttributesMap, attributesMap)» + «cast(ExprType.INT, expr.right, localAttributesMap, attributesMap)»)'''
			Concatenate:
				'''(goat.ToString(«getExpressionWithAttributes(expr.left, localAttributesMap, attributesMap)») + goat.ToString(«getExpressionWithAttributes(expr.right, localAttributesMap, attributesMap)»))'''
			Minus:
				'''(«cast(ExprType.INT, expr.left, localAttributesMap, attributesMap)» - «cast(ExprType.INT, expr.right, localAttributesMap, attributesMap)»)'''
			MulOrDiv:
				'''(«cast(ExprType.INT, expr.left, localAttributesMap, attributesMap)» «expr.op» «cast(ExprType.INT, expr.right, localAttributesMap, attributesMap)»)'''
			UnaryMinus:
				'''(-(«cast(ExprType.INT, expr.expression, localAttributesMap, attributesMap)»))'''	
			NegativeIntConstant:
				'''(-«expr.negvalue»)'''
			IntConstant:
				expr.value.toString
			StringConstant:
				'''"«StringEscapeUtils.escapeJava(expr.value)»"'''
			LocalVarRef:{
				val rf = expr.ref
				switch(rf){
					FuncVarDeclaration:
						rf.name
					FuncParam:
						rf.name
				}
			}
			LocalAttributeRef:
				if (attributesMap === null)
					throw new IllegalArgumentException("Unexpected local attribute")
				else
					localAttributesMap.readValue(expr.attribute)
			FunctionCall:
			{
				val args = ((0..<expr.params.length).map[i|cast(expr.function.params.get(i).type, expr.params.get(i), localAttributesMap, attributesMap)]).join(", ")
				'''f_«expr.function.name»(«args»)'''
			}
			RecAttributeRef:
				throw new IllegalArgumentException("Unexpected receiver attribute")
			ComponentAttributeRef:
				if (attributesMap === null)
					throw new IllegalArgumentException("Unexpected component attribute")
				else
					'''«attributesMap».GetValue("«expr.attribute»")'''
		}
	}
	
	def static CharSequence getExpressionWithoutAttributes(Expression expr){
		getExpressionWithAttributes(expr, null, null)
	}
	
	/*def private static boolean isOPImmediate(Expression expr) {
		switch(expr){
			LocalAttributeRef, ComponentAttributeRef, StringConstant, IntConstant, BoolConstant:
				true
			default:
				false 
		}
	}*/
	
	def private static boolean isOPAttribute(Expression expr){
		return expr instanceof RecAttributeRef
	}
	
	def static CharSequence binaryOperatorExtensor(CharSequence operator, List<CharSequence> operands){
		operands.tail.map[operator + "("].join + operands.head + operands.tail.map[''', «it»)'''].join
	}
	
	def static CharSequence getOutputPredicate(Expression expr, LocalVariableMap localAttributesMap, CharSequence attrName){
		switch(expr){
			And:
				binaryOperatorExtensor("goat.And", expr.sub.map[getOutputPredicate(it, localAttributesMap, attrName)])
			Or:
				binaryOperatorExtensor("goat.Or", expr.sub.map[getOutputPredicate(it, localAttributesMap, attrName)])
			Not:
				'''goat.Not(«getOutputPredicate(expr.expression, localAttributesMap, attrName)»)'''
			Equality:
			{
				val isOpLImm = !isOPAttribute(expr.left)
				val isOpRImm = !isOPAttribute(expr.right)
					
				'''goat.Comparison(«getOutputPredicate(expr.left, localAttributesMap, attrName)», «!isOpLImm», "«expr.op»", '''
					+ '''«getOutputPredicate(expr.right, localAttributesMap, attrName)», «!isOpRImm»)'''
			}
			Comparison:
			{
				val isOpLImm = !isOPAttribute(expr.left)
				val isOpRImm = !isOPAttribute(expr.right)
					
				'''goat.Comparison(«getOutputPredicate(expr.left, localAttributesMap, attrName)», «!isOpLImm», "«expr.op»", '''
					+ '''«getOutputPredicate(expr.right, localAttributesMap, attrName)», «!isOpRImm»)'''
			}
			BoolConstant:
				'''goat.«StringExtensions.toFirstUpper(expr.value)»()'''
			RecAttributeRef:
				'''"«expr.attribute»"'''
			Expression:
				CodeExpression.getExpressionWithAttributes(expr, localAttributesMap, attrName)
			/*Plus, Minus, MulOrDiv,FunctionCall:
				throw new IllegalArgumentException("Output predicate cannot contain expressions. Use updates.")
			LocalAttributeRef:
				localAttributesMap.readValue(expr.attribute)
			IntConstant:
				'''«expr.value»'''
			StringConstant:
				'''"«StringEscapeUtils.escapeJava(expr.value)»"'''
			
			ComponentAttributeRef:
				throw new IllegalArgumentException("Output predicate cannot refer component attributes.")*/
		}
	}
}