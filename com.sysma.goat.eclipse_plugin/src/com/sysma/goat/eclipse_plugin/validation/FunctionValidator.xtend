package com.sysma.goat.eclipse_plugin.validation

import org.eclipse.xtext.validation.Check
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition
import com.sysma.goat.eclipse_plugin.goatComponents.FuncBlock
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarDeclaration
import com.sysma.goat.eclipse_plugin.goatComponents.FuncVarAssign
import com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse
import com.sysma.goat.eclipse_plugin.goatComponents.FuncReturn
import com.sysma.goat.eclipse_plugin.typing.ExpressionTyping
import org.eclipse.xtext.EcoreUtil2
import com.sysma.goat.eclipse_plugin.goatComponents.Model
import com.sysma.goat.eclipse_plugin.goatComponents.FuncParam
import org.eclipse.xtext.validation.EValidatorRegistrar
import com.google.inject.Inject

class FunctionValidator extends AbstractGoatComponentsValidator {
	@Inject
    def override register(EValidatorRegistrar registrar) {
        // nothing to do
    }
    
	@Check
	def checkMustReturn(FuncDefinition fdef){
		if (!isAlwaysReturning(fdef)){
			error("Functions must eventually return",
				GoatComponentsPackage.eINSTANCE.funcDefinition_Blk
			)
		}
	}
	
	def boolean isAlwaysReturning(Object x){
		switch x {
			FuncDefinition:
				isAlwaysReturning(x.blk)
			FuncBlock:
				x.statements.exists[alwaysReturning]
			FuncVarDeclaration,
			FuncVarAssign:
				false
			FuncIfElse:
				x.then.forall[alwaysReturning] && (x.elseBranch !== null &&
					isAlwaysReturning(x.elseBranch)
				)
			FuncReturn:
				true
			default:
				false
		}
	}
	
	@Check
	def checkReturningThePromisedType(FuncReturn fRet){
		var eobj = fRet.eContainer
		while(eobj !== null && !(eobj instanceof FuncDefinition))
			eobj = eobj.eContainer
		if(eobj !== null){
			var fdef = eobj as FuncDefinition
			val promise = ExpressionTyping.typeOf(fdef.type)
			if(ExpressionTyping.typeOf(fRet.^val) != promise){
				error("Must return a "+ExpressionTyping.goType(promise), GoatComponentsPackage.eINSTANCE.funcReturn_Val)
			}
		}
	}
	
	@Check
	def noDuplicateVars(FuncVarDeclaration vdecl){
		var eobj = vdecl.eContainer
		while(eobj !== null && !(eobj instanceof FuncDefinition)){
			eobj = eobj.eContainer
		}
		if(eobj !== null){
			var fdef = eobj as FuncDefinition
			if (EcoreUtil2.getAllContentsOfType(fdef.blk, FuncVarDeclaration).findFirst[vdecl != it && vdecl.name == it.name] !== null){
				error("Variable "+vdecl.name+" declared multiple times", GoatComponentsPackage.eINSTANCE.LRef_Name)
			}
		}
	}
	
	@Check
	def noDuplicateFunctions(FuncDefinition func){
		var eobj = func.eContainer
		while(eobj !== null && !(eobj instanceof Model)){
			eobj = eobj.eContainer
		}
		if(eobj !== null){
			var model = eobj as Model
			if (EcoreUtil2.getAllContentsOfType(model, FuncDefinition).findFirst[func != it && func.name == it.name] !== null){
				error("Function "+func.name+" declared multiple times", GoatComponentsPackage.eINSTANCE.funcDefinition_Name)
			}
		}
	}
	
	@Check
	def noVarsHidingParams(FuncVarDeclaration vdecl){
		var eobj = vdecl.eContainer
		while(eobj !== null && !(eobj instanceof FuncDefinition))
			eobj = eobj.eContainer
		if(eobj !== null){
			var fdef = eobj as FuncDefinition
			if(fdef.params.exists[param| param.name == vdecl.name]){
				error("Cannot declare "+vdecl.name+" as one of the params has the same name", GoatComponentsPackage.eINSTANCE.LRef_Name)
			}
		}
	}
	
	@Check
	def noDuplicateParams(FuncParam pdecl){
		if(pdecl.eContainer instanceof FuncDefinition){
			var fdef = pdecl.eContainer as FuncDefinition
			if (fdef.params.exists[param| param.name == pdecl.name && pdecl !== param]){
				error("Parameter "+pdecl.name+" declared multiple times", GoatComponentsPackage.eINSTANCE.LRef_Name)
			}
		}
	}
	
}
