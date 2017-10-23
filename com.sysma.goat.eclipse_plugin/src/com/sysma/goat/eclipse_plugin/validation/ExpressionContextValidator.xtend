package com.sysma.goat.eclipse_plugin.validation

import com.sysma.goat.eclipse_plugin.validation.AbstractGoatComponentsValidator
import org.eclipse.xtext.validation.Check
import com.sysma.goat.eclipse_plugin.goatComponents.Expression
import com.sysma.goat.eclipse_plugin.goatComponents.RecAttributeRef
import org.eclipse.emf.ecore.EObject
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage
import com.sysma.goat.eclipse_plugin.goatComponents.ComponentAttributeRef
import com.sysma.goat.eclipse_plugin.goatComponents.LocalAttributeRef
import com.sysma.goat.eclipse_plugin.goatComponents.FuncDefinition
import com.google.inject.Inject
import org.eclipse.xtext.validation.EValidatorRegistrar
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend

class ExpressionContextValidator extends AbstractGoatComponentsValidator {
	@Inject
    def override register(EValidatorRegistrar registrar) {
        // nothing to do
    }
	@Check
	def checkExpressionContext(Expression expr){
		switch expr{
			RecAttributeRef:
			{
				var EObject eobj = expr
				var eobjCont = eobj.eContainer
				while(eobjCont !== null){
					if (eobjCont instanceof ProcessSend){
						if(eobjCont.send_pred == eobj)
							return
					}
					else {
						eobj = eobjCont
						eobjCont = eobjCont.eContainer
					}
				}
				error("Receiver attributes can be used only in output predicates", GoatComponentsPackage.eINSTANCE.recAttributeRef_Attribute)
			}
			ComponentAttributeRef:
			{
				var eobjCont = expr.eContainer
				while(eobjCont !== null){
					if (eobjCont instanceof FuncDefinition){
						error("Attributes cannot be used inside functions", GoatComponentsPackage.eINSTANCE.componentAttributeRef_Attribute)
						eobjCont = null
					} else {
						eobjCont = eobjCont.eContainer
					}
				}
			}
			LocalAttributeRef:
			{
				var eobjCont = expr.eContainer
				while(eobjCont !== null){
					if (eobjCont instanceof FuncDefinition){
						error("Attributes cannot be used inside functions", GoatComponentsPackage.eINSTANCE.localAttributeRef_Attribute)
					}
					eobjCont = eobjCont.eContainer
				}
			}
		}
	}
}