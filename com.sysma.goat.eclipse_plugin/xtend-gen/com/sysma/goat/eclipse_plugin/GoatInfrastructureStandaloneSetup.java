/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin;

import com.sysma.goat.eclipse_plugin.GoatInfrastructureStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class GoatInfrastructureStandaloneSetup extends GoatInfrastructureStandaloneSetupGenerated {
  public static void doSetup() {
    new GoatInfrastructureStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
