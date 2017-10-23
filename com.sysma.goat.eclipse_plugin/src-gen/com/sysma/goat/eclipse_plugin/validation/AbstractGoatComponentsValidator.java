/*
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators = {FunctionValidator.class, ExpressionContextValidator.class, ExpressionTypingValidator.class})
public abstract class AbstractGoatComponentsValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage.eINSTANCE);
		return result;
	}
	
}
