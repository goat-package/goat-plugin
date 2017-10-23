/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatComponents;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Func If Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse#getTest <em>Test</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse#getThen <em>Then</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 *
 * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getFuncIfElse()
 * @model
 * @generated
 */
public interface FuncIfElse extends FuncStatement
{
  /**
   * Returns the value of the '<em><b>Test</b></em>' containment reference list.
   * The list contents are of type {@link com.sysma.goat.eclipse_plugin.goatComponents.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test</em>' containment reference list.
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getFuncIfElse_Test()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getTest();

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference list.
   * The list contents are of type {@link com.sysma.goat.eclipse_plugin.goatComponents.FuncBlock}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference list.
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getFuncIfElse_Then()
   * @model containment="true"
   * @generated
   */
  EList<FuncBlock> getThen();

  /**
   * Returns the value of the '<em><b>Else Branch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Branch</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Branch</em>' containment reference.
   * @see #setElseBranch(FuncBlock)
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getFuncIfElse_ElseBranch()
   * @model containment="true"
   * @generated
   */
  FuncBlock getElseBranch();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatComponents.FuncIfElse#getElseBranch <em>Else Branch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Branch</em>' containment reference.
   * @see #getElseBranch()
   * @generated
   */
  void setElseBranch(FuncBlock value);

} // FuncIfElse