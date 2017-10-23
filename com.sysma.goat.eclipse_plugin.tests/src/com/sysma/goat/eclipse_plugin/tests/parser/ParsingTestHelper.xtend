package com.sysma.goat.eclipse_plugin.tests.parser

import org.eclipse.emf.ecore.EObject
import org.junit.Assert

class ParsingTestHelper {
	def static checkNoErrorApartInfr(EObject obj){
		Assert.assertTrue(obj.eResource.errors.filter[it.message != "Couldn't resolve reference to Infrastructure 'infr'."].length == 0)
	}
	
	def static checkErrorApartInfr(EObject obj){
		Assert.assertFalse(obj.eResource.errors.filter[it.message != "Couldn't resolve reference to Infrastructure 'infr'."].length == 0)
	}
}