/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatComponents;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getMsgOutParts <em>Msg Out Parts</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getSend_pred <em>Send pred</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getUpdates <em>Updates</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getPrint <em>Print</em>}</li>
 * </ul>
 *
 * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getProcessSend()
 * @model
 * @generated
 */
public interface ProcessSend extends ProcessStatement
{
  /**
   * Returns the value of the '<em><b>Msg Out Parts</b></em>' containment reference list.
   * The list contents are of type {@link com.sysma.goat.eclipse_plugin.goatComponents.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msg Out Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msg Out Parts</em>' containment reference list.
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getProcessSend_MsgOutParts()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getMsgOutParts();

  /**
   * Returns the value of the '<em><b>Send pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Send pred</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Send pred</em>' containment reference.
   * @see #setSend_pred(Expression)
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getProcessSend_Send_pred()
   * @model containment="true"
   * @generated
   */
  Expression getSend_pred();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getSend_pred <em>Send pred</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Send pred</em>' containment reference.
   * @see #getSend_pred()
   * @generated
   */
  void setSend_pred(Expression value);

  /**
   * Returns the value of the '<em><b>Updates</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Updates</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Updates</em>' containment reference.
   * @see #setUpdates(Update)
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getProcessSend_Updates()
   * @model containment="true"
   * @generated
   */
  Update getUpdates();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getUpdates <em>Updates</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Updates</em>' containment reference.
   * @see #getUpdates()
   * @generated
   */
  void setUpdates(Update value);

  /**
   * Returns the value of the '<em><b>Print</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print</em>' containment reference.
   * @see #setPrint(PrintStatement)
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getProcessSend_Print()
   * @model containment="true"
   * @generated
   */
  PrintStatement getPrint();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatComponents.ProcessSend#getPrint <em>Print</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Print</em>' containment reference.
   * @see #getPrint()
   * @generated
   */
  void setPrint(PrintStatement value);

} // ProcessSend
