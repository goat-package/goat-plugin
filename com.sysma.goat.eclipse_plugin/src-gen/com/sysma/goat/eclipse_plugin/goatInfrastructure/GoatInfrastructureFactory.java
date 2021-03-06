/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatInfrastructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.GoatInfrastructurePackage
 * @generated
 */
public interface GoatInfrastructureFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GoatInfrastructureFactory eINSTANCE = com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructureFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Infrastructure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Infrastructure</em>'.
   * @generated
   */
  Infrastructure createInfrastructure();

  /**
   * Returns a new object of class '<em>Single Server</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Server</em>'.
   * @generated
   */
  SingleServer createSingleServer();

  /**
   * Returns a new object of class '<em>Cluster</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cluster</em>'.
   * @generated
   */
  Cluster createCluster();

  /**
   * Returns a new object of class '<em>Ring</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ring</em>'.
   * @generated
   */
  Ring createRing();

  /**
   * Returns a new object of class '<em>Tree</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree</em>'.
   * @generated
   */
  Tree createTree();

  /**
   * Returns a new object of class '<em>Tree Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree Node</em>'.
   * @generated
   */
  TreeNode createTreeNode();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GoatInfrastructurePackage getGoatInfrastructurePackage();

} //GoatInfrastructureFactory
