/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatComponents;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Formatted Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement#getToPrint <em>To Print</em>}</li>
 * </ul>
 *
 * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getPrintFormattedStatement()
 * @model
 * @generated
 */
public interface PrintFormattedStatement extends PrintStatement
{
  /**
   * Returns the value of the '<em><b>To Print</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Print</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Print</em>' attribute.
   * @see #setToPrint(String)
   * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage#getPrintFormattedStatement_ToPrint()
   * @model
   * @generated
   */
  String getToPrint();

  /**
   * Sets the value of the '{@link com.sysma.goat.eclipse_plugin.goatComponents.PrintFormattedStatement#getToPrint <em>To Print</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Print</em>' attribute.
   * @see #getToPrint()
   * @generated
   */
  void setToPrint(String value);

} // PrintFormattedStatement