/*
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.ide

import com.google.inject.Guice
import com.sysma.goat.eclipse_plugin.GoatInfrastructureRuntimeModule
import com.sysma.goat.eclipse_plugin.GoatInfrastructureStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class GoatInfrastructureIdeSetup extends GoatInfrastructureStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new GoatInfrastructureRuntimeModule, new GoatInfrastructureIdeModule))
	}
	
}