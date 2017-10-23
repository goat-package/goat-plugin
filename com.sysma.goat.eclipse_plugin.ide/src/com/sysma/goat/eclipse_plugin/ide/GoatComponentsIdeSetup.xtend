/*
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.ide

import com.google.inject.Guice
import com.sysma.goat.eclipse_plugin.GoatComponentsRuntimeModule
import com.sysma.goat.eclipse_plugin.GoatComponentsStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class GoatComponentsIdeSetup extends GoatComponentsStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new GoatComponentsRuntimeModule, new GoatComponentsIdeModule))
	}
	
}