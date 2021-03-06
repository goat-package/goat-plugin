/**
 * generated by Xtext 2.12.0
 */
package com.sysma.goat.eclipse_plugin.goatInfrastructure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.GoatInfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface GoatInfrastructurePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "goatInfrastructure";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.sysma.com/goat/eclipse_plugin/GoatInfrastructure";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "goatInfrastructure";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GoatInfrastructurePackage eINSTANCE = com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl.init();

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.InfrastructureImpl <em>Infrastructure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.InfrastructureImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getInfrastructure()
   * @generated
   */
  int INFRASTRUCTURE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Infrastructure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.SingleServerImpl <em>Single Server</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.SingleServerImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getSingleServer()
   * @generated
   */
  int SINGLE_SERVER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_SERVER__NAME = INFRASTRUCTURE__NAME;

  /**
   * The feature id for the '<em><b>Server</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_SERVER__SERVER = INFRASTRUCTURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_SERVER__TIMEOUT = INFRASTRUCTURE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Single Server</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_SERVER_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.ClusterImpl <em>Cluster</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.ClusterImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getCluster()
   * @generated
   */
  int CLUSTER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__NAME = INFRASTRUCTURE__NAME;

  /**
   * The feature id for the '<em><b>Message queue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__MESSAGE_QUEUE = INFRASTRUCTURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Registration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__REGISTRATION = INFRASTRUCTURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mid assigner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__MID_ASSIGNER = INFRASTRUCTURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER__NODES = INFRASTRUCTURE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Cluster</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLUSTER_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.RingImpl <em>Ring</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.RingImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getRing()
   * @generated
   */
  int RING = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RING__NAME = INFRASTRUCTURE__NAME;

  /**
   * The feature id for the '<em><b>Registration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RING__REGISTRATION = INFRASTRUCTURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mid assigner</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RING__MID_ASSIGNER = INFRASTRUCTURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RING__NODES = INFRASTRUCTURE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ring</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RING_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeImpl <em>Tree</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getTree()
   * @generated
   */
  int TREE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE__NAME = INFRASTRUCTURE__NAME;

  /**
   * The feature id for the '<em><b>Registration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE__REGISTRATION = INFRASTRUCTURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE__ROOT = INFRASTRUCTURE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FEATURE_COUNT = INFRASTRUCTURE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeNodeImpl <em>Tree Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeNodeImpl
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getTreeNode()
   * @generated
   */
  int TREE_NODE = 5;

  /**
   * The feature id for the '<em><b>Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__ADDRESS = 0;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__CHILDREN = 1;

  /**
   * The number of structural features of the '<em>Tree Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure <em>Infrastructure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Infrastructure</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure
   * @generated
   */
  EClass getInfrastructure();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Infrastructure#getName()
   * @see #getInfrastructure()
   * @generated
   */
  EAttribute getInfrastructure_Name();

  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer <em>Single Server</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Server</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer
   * @generated
   */
  EClass getSingleServer();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer#getServer <em>Server</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Server</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer#getServer()
   * @see #getSingleServer()
   * @generated
   */
  EAttribute getSingleServer_Server();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.SingleServer#getTimeout()
   * @see #getSingleServer()
   * @generated
   */
  EAttribute getSingleServer_Timeout();

  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster <em>Cluster</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cluster</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster
   * @generated
   */
  EClass getCluster();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getMessage_queue <em>Message queue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message queue</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getMessage_queue()
   * @see #getCluster()
   * @generated
   */
  EAttribute getCluster_Message_queue();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getRegistration <em>Registration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Registration</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getRegistration()
   * @see #getCluster()
   * @generated
   */
  EAttribute getCluster_Registration();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getMid_assigner <em>Mid assigner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mid assigner</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getMid_assigner()
   * @see #getCluster()
   * @generated
   */
  EAttribute getCluster_Mid_assigner();

  /**
   * Returns the meta object for the attribute list '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Nodes</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Cluster#getNodes()
   * @see #getCluster()
   * @generated
   */
  EAttribute getCluster_Nodes();

  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring <em>Ring</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ring</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring
   * @generated
   */
  EClass getRing();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getRegistration <em>Registration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Registration</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getRegistration()
   * @see #getRing()
   * @generated
   */
  EAttribute getRing_Registration();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getMid_assigner <em>Mid assigner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mid assigner</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getMid_assigner()
   * @see #getRing()
   * @generated
   */
  EAttribute getRing_Mid_assigner();

  /**
   * Returns the meta object for the attribute list '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Nodes</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Ring#getNodes()
   * @see #getRing()
   * @generated
   */
  EAttribute getRing_Nodes();

  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree <em>Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree
   * @generated
   */
  EClass getTree();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree#getRegistration <em>Registration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Registration</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree#getRegistration()
   * @see #getTree()
   * @generated
   */
  EAttribute getTree_Registration();

  /**
   * Returns the meta object for the containment reference '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.Tree#getRoot()
   * @see #getTree()
   * @generated
   */
  EReference getTree_Root();

  /**
   * Returns the meta object for class '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode <em>Tree Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree Node</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode
   * @generated
   */
  EClass getTreeNode();

  /**
   * Returns the meta object for the attribute '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getAddress <em>Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Address</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getAddress()
   * @see #getTreeNode()
   * @generated
   */
  EAttribute getTreeNode_Address();

  /**
   * Returns the meta object for the containment reference list '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.TreeNode#getChildren()
   * @see #getTreeNode()
   * @generated
   */
  EReference getTreeNode_Children();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GoatInfrastructureFactory getGoatInfrastructureFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.InfrastructureImpl <em>Infrastructure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.InfrastructureImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getInfrastructure()
     * @generated
     */
    EClass INFRASTRUCTURE = eINSTANCE.getInfrastructure();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFRASTRUCTURE__NAME = eINSTANCE.getInfrastructure_Name();

    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.SingleServerImpl <em>Single Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.SingleServerImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getSingleServer()
     * @generated
     */
    EClass SINGLE_SERVER = eINSTANCE.getSingleServer();

    /**
     * The meta object literal for the '<em><b>Server</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_SERVER__SERVER = eINSTANCE.getSingleServer_Server();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_SERVER__TIMEOUT = eINSTANCE.getSingleServer_Timeout();

    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.ClusterImpl <em>Cluster</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.ClusterImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getCluster()
     * @generated
     */
    EClass CLUSTER = eINSTANCE.getCluster();

    /**
     * The meta object literal for the '<em><b>Message queue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLUSTER__MESSAGE_QUEUE = eINSTANCE.getCluster_Message_queue();

    /**
     * The meta object literal for the '<em><b>Registration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLUSTER__REGISTRATION = eINSTANCE.getCluster_Registration();

    /**
     * The meta object literal for the '<em><b>Mid assigner</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLUSTER__MID_ASSIGNER = eINSTANCE.getCluster_Mid_assigner();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLUSTER__NODES = eINSTANCE.getCluster_Nodes();

    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.RingImpl <em>Ring</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.RingImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getRing()
     * @generated
     */
    EClass RING = eINSTANCE.getRing();

    /**
     * The meta object literal for the '<em><b>Registration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RING__REGISTRATION = eINSTANCE.getRing_Registration();

    /**
     * The meta object literal for the '<em><b>Mid assigner</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RING__MID_ASSIGNER = eINSTANCE.getRing_Mid_assigner();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RING__NODES = eINSTANCE.getRing_Nodes();

    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeImpl <em>Tree</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getTree()
     * @generated
     */
    EClass TREE = eINSTANCE.getTree();

    /**
     * The meta object literal for the '<em><b>Registration</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE__REGISTRATION = eINSTANCE.getTree_Registration();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE__ROOT = eINSTANCE.getTree_Root();

    /**
     * The meta object literal for the '{@link com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeNodeImpl <em>Tree Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.TreeNodeImpl
     * @see com.sysma.goat.eclipse_plugin.goatInfrastructure.impl.GoatInfrastructurePackageImpl#getTreeNode()
     * @generated
     */
    EClass TREE_NODE = eINSTANCE.getTreeNode();

    /**
     * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE__ADDRESS = eINSTANCE.getTreeNode_Address();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE_NODE__CHILDREN = eINSTANCE.getTreeNode_Children();

  }

} //GoatInfrastructurePackage
