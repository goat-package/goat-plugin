package com.sysma.goat.eclipse_plugin.validation

import com.sysma.goat.eclipse_plugin.goatComponents.And
import com.sysma.goat.eclipse_plugin.goatComponents.Comparison
import com.sysma.goat.eclipse_plugin.goatComponents.Equality
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.goatComponents.FunctionCall
import com.sysma.goat.eclipse_plugin.goatComponents.Minus
import com.sysma.goat.eclipse_plugin.goatComponents.MulOrDiv
import com.sysma.goat.eclipse_plugin.goatComponents.Not
import com.sysma.goat.eclipse_plugin.goatComponents.Or
import com.sysma.goat.eclipse_plugin.goatComponents.Plus
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping.ExprType
import org.eclipse.xtext.validation.Check
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage
import org.eclipse.emf.ecore.EReference
import com.google.inject.Inject
import org.eclipse.xtext.validation.EValidatorRegistrar
import com.sysma.goat.eclipse_plugin.goatComponents.Concatenate
import com.sysma.goat.eclipse_plugin.goatComponents.ReceiveCase
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor

class ExpressionTypingValidator extends AbstractGoatComponentsValidator {
    @Inject
    def override register(EValidatorRegistrar registrar) {
        // nothing to do
    }
    
	def private expectedType(Expression expr, ExprType typ, EReference at){
		if (!ExpressionTyping.matchable(ExpressionTyping.typeOf(expr), typ)){
			error('''Expected a «ExpressionTyping.goType(typ)» expression''', at)
		}
	}
	
	def private expected2Types(Expression expr, ExprType typ, ExprType typ2, EReference at){
		if (!ExpressionTyping.matchable(ExpressionTyping.typeOf(expr), typ) && !ExpressionTyping.matchable(ExpressionTyping.typeOf(expr), typ2)){
			error('''Expected a «ExpressionTyping.goType(typ)» or «ExpressionTyping.goType(typ2)» expression''', at)
			true
		} else { 
			false
		}
	}
	
	def private sameType(Expression expr1, Expression expr2, EReference at2){
		val type1 = ExpressionTyping.typeOf(expr1)
		val type2 = ExpressionTyping.typeOf(expr2)
		if (!ExpressionTyping.matchable(type1, type2)){
			error('''Expected a «ExpressionTyping.goType(type1)» expression''', at2)
		}
	}
	
	@Check
	def checkTypeReceivePredicate(ReceiveCase iproc){
		expectedType(iproc.cond, ExprType.BOOL, GoatComponentsPackage.eINSTANCE.receiveCase_Cond)
	}
	
	@Check
	def checkTypeSendPredicate(ProcessSend oproc){
		expectedType(oproc.send_pred, ExprType.BOOL, GoatComponentsPackage.eINSTANCE.processSend_Send_pred)
	}
	
	@Check
	def checkTypeAwareness(ProcessWaitFor awr){
		expected2Types(awr.cond, ExprType.BOOL, ExprType.INT, GoatComponentsPackage.eINSTANCE.processWaitFor_Cond)
	}
	
	@Check
	def checkTypes(Expression expr){
		switch(expr){
			And: {
				if (expr.sub.filter[!ExpressionTyping.matchable(ExpressionTyping.typeOf(it), ExprType.BOOL)].length > 0){
					error('''And requires boolean expressions''', GoatComponentsPackage.eINSTANCE.and_Sub)
				}
			}
			Or: {
				if (expr.sub.filter[!ExpressionTyping.matchable(ExpressionTyping.typeOf(it), ExprType.BOOL)].length > 0){
					error('''Or requires boolean expressions''', GoatComponentsPackage.eINSTANCE.and_Sub)
				}
			}
			Not:
				expectedType(expr.expression, ExprType.BOOL, GoatComponentsPackage.eINSTANCE.not_Expression)
			Equality: 
				sameType(expr.left, expr.right, GoatComponentsPackage.eINSTANCE.equality_Right)
			Comparison:{
				val errL = expected2Types(expr.left, ExprType.INT, ExprType.STRING, GoatComponentsPackage.eINSTANCE.comparison_Left)
				val errR = expected2Types(expr.right, ExprType.INT, ExprType.STRING, GoatComponentsPackage.eINSTANCE.comparison_Right)
				if (!errL && !errR){
					sameType(expr.left, expr.right, GoatComponentsPackage.eINSTANCE.comparison_Right)
				}
			}
			Plus:
			{
				expectedType(expr.left, ExprType.INT, GoatComponentsPackage.eINSTANCE.plus_Left)
				expectedType(expr.right, ExprType.INT, GoatComponentsPackage.eINSTANCE.plus_Right)
			}
			Concatenate: //always ok
			{ }
			Minus: {
				expectedType(expr.left, ExprType.INT, GoatComponentsPackage.eINSTANCE.minus_Left)
				expectedType(expr.right, ExprType.INT, GoatComponentsPackage.eINSTANCE.minus_Right)
			}
			MulOrDiv: {
				expectedType(expr.left, ExprType.INT, GoatComponentsPackage.eINSTANCE.mulOrDiv_Left)
				expectedType(expr.right, ExprType.INT, GoatComponentsPackage.eINSTANCE.mulOrDiv_Right)
			}
			FunctionCall: {
				var okTypes = expr.function.params.length == expr.params.length
				if (okTypes){
					for(i : 0..<expr.params.length){
						okTypes = okTypes && ExpressionTyping.matchable(
							ExpressionTyping.typeOf(expr.function.params.get(i).type),
							ExpressionTyping.typeOf(expr.params.get(i))
						)
					}
				}
				if (!okTypes){
					val exp = expr.function.params.map[ExpressionTyping.goType(ExpressionTyping.typeOf(it.type))].join(", ")
					val got = expr.params.map[ExpressionTyping.goType(ExpressionTyping.typeOf(it))].join(", ")
					error('''Expected («exp») as arguments but got («got»)''', GoatComponentsPackage.eINSTANCE.functionCall_Params)
				}	
			}
		}
	}
}