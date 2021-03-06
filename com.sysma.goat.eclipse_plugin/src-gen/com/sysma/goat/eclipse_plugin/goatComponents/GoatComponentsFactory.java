/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatComponents;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sysma.goat.eclipse_plugin.goatComponents.GoatComponentsPackage
 * @generated
 */
public interface GoatComponentsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GoatComponentsFactory eINSTANCE = com.sysma.goat.eclipse_plugin.goatComponents.impl.GoatComponentsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Process Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Definition</em>'.
   * @generated
   */
  ProcessDefinition createProcessDefinition();

  /**
   * Returns a new object of class '<em>Process Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Block</em>'.
   * @generated
   */
  ProcessBlock createProcessBlock();

  /**
   * Returns a new object of class '<em>Process Spawn</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Spawn</em>'.
   * @generated
   */
  ProcessSpawn createProcessSpawn();

  /**
   * Returns a new object of class '<em>Process Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Call</em>'.
   * @generated
   */
  ProcessCall createProcessCall();

  /**
   * Returns a new object of class '<em>Process Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Statement</em>'.
   * @generated
   */
  ProcessStatement createProcessStatement();

  /**
   * Returns a new object of class '<em>Process Send</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Send</em>'.
   * @generated
   */
  ProcessSend createProcessSend();

  /**
   * Returns a new object of class '<em>Process Receive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Receive</em>'.
   * @generated
   */
  ProcessReceive createProcessReceive();

  /**
   * Returns a new object of class '<em>Process Receive Single</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Receive Single</em>'.
   * @generated
   */
  ProcessReceiveSingle createProcessReceiveSingle();

  /**
   * Returns a new object of class '<em>Process Receive Multiple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Receive Multiple</em>'.
   * @generated
   */
  ProcessReceiveMultiple createProcessReceiveMultiple();

  /**
   * Returns a new object of class '<em>Receive Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Receive Case</em>'.
   * @generated
   */
  ReceiveCase createReceiveCase();

  /**
   * Returns a new object of class '<em>Process If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process If</em>'.
   * @generated
   */
  ProcessIf createProcessIf();

  /**
   * Returns a new object of class '<em>Process Then Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Then Block</em>'.
   * @generated
   */
  ProcessThenBlock createProcessThenBlock();

  /**
   * Returns a new object of class '<em>Process Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Set</em>'.
   * @generated
   */
  ProcessSet createProcessSet();

  /**
   * Returns a new object of class '<em>Process Wait For</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Wait For</em>'.
   * @generated
   */
  ProcessWaitFor createProcessWaitFor();

  /**
   * Returns a new object of class '<em>Process Loop</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Loop</em>'.
   * @generated
   */
  ProcessLoop createProcessLoop();

  /**
   * Returns a new object of class '<em>Update</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update</em>'.
   * @generated
   */
  Update createUpdate();

  /**
   * Returns a new object of class '<em>Update Component Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update Component Attribute</em>'.
   * @generated
   */
  UpdateComponentAttribute createUpdateComponentAttribute();

  /**
   * Returns a new object of class '<em>Update Local Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Update Local Attribute</em>'.
   * @generated
   */
  UpdateLocalAttribute createUpdateLocalAttribute();

  /**
   * Returns a new object of class '<em>Print Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Print Statement</em>'.
   * @generated
   */
  PrintStatement createPrintStatement();

  /**
   * Returns a new object of class '<em>Print All Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Print All Statement</em>'.
   * @generated
   */
  PrintAllStatement createPrintAllStatement();

  /**
   * Returns a new object of class '<em>Print Formatted Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Print Formatted Statement</em>'.
   * @generated
   */
  PrintFormattedStatement createPrintFormattedStatement();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Environment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment</em>'.
   * @generated
   */
  Environment createEnvironment();

  /**
   * Returns a new object of class '<em>Environment Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment Definition</em>'.
   * @generated
   */
  EnvironmentDefinition createEnvironmentDefinition();

  /**
   * Returns a new object of class '<em>Component Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Definition</em>'.
   * @generated
   */
  ComponentDefinition createComponentDefinition();

  /**
   * Returns a new object of class '<em>LRef</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LRef</em>'.
   * @generated
   */
  LRef createLRef();

  /**
   * Returns a new object of class '<em>Func Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Param</em>'.
   * @generated
   */
  FuncParam createFuncParam();

  /**
   * Returns a new object of class '<em>Func Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Definition</em>'.
   * @generated
   */
  FuncDefinition createFuncDefinition();

  /**
   * Returns a new object of class '<em>Func Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Block</em>'.
   * @generated
   */
  FuncBlock createFuncBlock();

  /**
   * Returns a new object of class '<em>Func Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Statement</em>'.
   * @generated
   */
  FuncStatement createFuncStatement();

  /**
   * Returns a new object of class '<em>Func Var Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Var Declaration</em>'.
   * @generated
   */
  FuncVarDeclaration createFuncVarDeclaration();

  /**
   * Returns a new object of class '<em>Func Var Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Var Assign</em>'.
   * @generated
   */
  FuncVarAssign createFuncVarAssign();

  /**
   * Returns a new object of class '<em>Func If Else</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func If Else</em>'.
   * @generated
   */
  FuncIfElse createFuncIfElse();

  /**
   * Returns a new object of class '<em>Func Return</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Func Return</em>'.
   * @generated
   */
  FuncReturn createFuncReturn();

  /**
   * Returns a new object of class '<em>Negative Int Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negative Int Constant</em>'.
   * @generated
   */
  NegativeIntConstant createNegativeIntConstant();

  /**
   * Returns a new object of class '<em>Int Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Constant</em>'.
   * @generated
   */
  IntConstant createIntConstant();

  /**
   * Returns a new object of class '<em>String Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Constant</em>'.
   * @generated
   */
  StringConstant createStringConstant();

  /**
   * Returns a new object of class '<em>Bool Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Constant</em>'.
   * @generated
   */
  BoolConstant createBoolConstant();

  /**
   * Returns a new object of class '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or</em>'.
   * @generated
   */
  Or createOr();

  /**
   * Returns a new object of class '<em>And</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And</em>'.
   * @generated
   */
  And createAnd();

  /**
   * Returns a new object of class '<em>Equality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality</em>'.
   * @generated
   */
  Equality createEquality();

  /**
   * Returns a new object of class '<em>Comparison</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comparison</em>'.
   * @generated
   */
  Comparison createComparison();

  /**
   * Returns a new object of class '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plus</em>'.
   * @generated
   */
  Plus createPlus();

  /**
   * Returns a new object of class '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Minus</em>'.
   * @generated
   */
  Minus createMinus();

  /**
   * Returns a new object of class '<em>Concatenate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concatenate</em>'.
   * @generated
   */
  Concatenate createConcatenate();

  /**
   * Returns a new object of class '<em>Mul Or Div</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mul Or Div</em>'.
   * @generated
   */
  MulOrDiv createMulOrDiv();

  /**
   * Returns a new object of class '<em>Unary Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Minus</em>'.
   * @generated
   */
  UnaryMinus createUnaryMinus();

  /**
   * Returns a new object of class '<em>Not</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not</em>'.
   * @generated
   */
  Not createNot();

  /**
   * Returns a new object of class '<em>Local Var Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Var Ref</em>'.
   * @generated
   */
  LocalVarRef createLocalVarRef();

  /**
   * Returns a new object of class '<em>Local Attribute Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Attribute Ref</em>'.
   * @generated
   */
  LocalAttributeRef createLocalAttributeRef();

  /**
   * Returns a new object of class '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Call</em>'.
   * @generated
   */
  FunctionCall createFunctionCall();

  /**
   * Returns a new object of class '<em>Component Attribute Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Attribute Ref</em>'.
   * @generated
   */
  ComponentAttributeRef createComponentAttributeRef();

  /**
   * Returns a new object of class '<em>Rec Attribute Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rec Attribute Ref</em>'.
   * @generated
   */
  RecAttributeRef createRecAttributeRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GoatComponentsPackage getGoatComponentsPackage();

} //GoatComponentsFactory
