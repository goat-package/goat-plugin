/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatInfrastructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getAddress <em>Address</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.GoatInfrastructurePackage#getTreeNode()
 * @model
 * @generated
 */
public interface TreeNode extends EObject
{
  /**
   * Returns the value of the '<em><b>Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Address</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Address</em>' attribute.
   * @see #setAddress(String)
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.GoatInfrastructurePackage#getTreeNode_Address()
   * @model
   * @generated
   */
  String getAddress();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getAddress <em>Address</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Address</em>' attribute.
   * @see #getAddress()
   * @generated
   */
  void setAddress(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.GoatInfrastructurePackage#getTreeNode_Children()
   * @model containment="true"
   * @generated
   */
  EList<TreeNode> getChildren();

} // TreeNode
