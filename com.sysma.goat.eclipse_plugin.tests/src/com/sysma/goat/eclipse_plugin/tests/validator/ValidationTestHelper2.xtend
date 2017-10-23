package com.sysma.goat.eclipse_plugin.tests.validator

import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.emf.ecore.EObject

class ValidationTestHelper2 extends ValidationTestHelper {
	def errors(EObject resource){
		val validate = validate(resource)
		validate.filter[severity == Severity.ERROR]
	}
}