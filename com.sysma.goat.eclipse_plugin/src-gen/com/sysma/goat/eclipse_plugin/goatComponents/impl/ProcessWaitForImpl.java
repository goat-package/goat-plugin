/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatComponents.impl;

import com.sysma.goat.eclipse_plugin.goatComponents.Expression;
import com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage;
import com.sysma.goat.eclipse_plugin.goatComponents.PrintStatement;
import com.sysma.goat.eclipse_plugin.goatComponents.ProcessWaitFor;
import com.sysma.goat.eclipse_plugin.goatComponents.Update;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Wait For</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.impl.ProcessWaitForImpl#getCond <em>Cond</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.impl.ProcessWaitForImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link com.sysma.goat.eclipse_plugin.goatComponents.impl.ProcessWaitForImpl#getPrint <em>Print</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessWaitForImpl extends ProcessStatementImpl implements ProcessWaitFor
{
  /**
   * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCond()
   * @generated
   * @ordered
   */
  protected Expression cond;

  /**
   * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdate()
   * @generated
   * @ordered
   */
  protected Update update;

  /**
   * The cached value of the '{@link #getPrint() <em>Print</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrint()
   * @generated
   * @ordered
   */
  protected PrintStatement print;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcessWaitForImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GoatComponentsPackage.Literals.PROCESS_WAIT_FOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCond()
  {
    return cond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCond(Expression newCond, NotificationChain msgs)
  {
    Expression oldCond = cond;
    cond = newCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__COND, oldCond, newCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCond(Expression newCond)
  {
    if (newCond != cond)
    {
      NotificationChain msgs = null;
      if (cond != null)
        msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__COND, null, msgs);
      if (newCond != null)
        msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__COND, null, msgs);
      msgs = basicSetCond(newCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__COND, newCond, newCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Update getUpdate()
  {
    return update;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpdate(Update newUpdate, NotificationChain msgs)
  {
    Update oldUpdate = update;
    update = newUpdate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE, oldUpdate, newUpdate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdate(Update newUpdate)
  {
    if (newUpdate != update)
    {
      NotificationChain msgs = null;
      if (update != null)
        msgs = ((InternalEObject)update).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE, null, msgs);
      if (newUpdate != null)
        msgs = ((InternalEObject)newUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE, null, msgs);
      msgs = basicSetUpdate(newUpdate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE, newUpdate, newUpdate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrintStatement getPrint()
  {
    return print;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrint(PrintStatement newPrint, NotificationChain msgs)
  {
    PrintStatement oldPrint = print;
    print = newPrint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT, oldPrint, newPrint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrint(PrintStatement newPrint)
  {
    if (newPrint != print)
    {
      NotificationChain msgs = null;
      if (print != null)
        msgs = ((InternalEObject)print).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT, null, msgs);
      if (newPrint != null)
        msgs = ((InternalEObject)newPrint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT, null, msgs);
      msgs = basicSetPrint(newPrint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT, newPrint, newPrint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GoatComponentsPackage.PROCESS_WAIT_FOR__COND:
        return basicSetCond(null, msgs);
      case GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE:
        return basicSetUpdate(null, msgs);
      case GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT:
        return basicSetPrint(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GoatComponentsPackage.PROCESS_WAIT_FOR__COND:
        return getCond();
      case GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE:
        return getUpdate();
      case GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT:
        return getPrint();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GoatComponentsPackage.PROCESS_WAIT_FOR__COND:
        setCond((Expression)newValue);
        return;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE:
        setUpdate((Update)newValue);
        return;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT:
        setPrint((PrintStatement)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GoatComponentsPackage.PROCESS_WAIT_FOR__COND:
        setCond((Expression)null);
        return;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE:
        setUpdate((Update)null);
        return;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT:
        setPrint((PrintStatement)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GoatComponentsPackage.PROCESS_WAIT_FOR__COND:
        return cond != null;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__UPDATE:
        return update != null;
      case GoatComponentsPackage.PROCESS_WAIT_FOR__PRINT:
        return print != null;
    }
    return super.eIsSet(featureID);
  }

} //ProcessWaitForImpl
