/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.obeonetwork.dsl.requirement.RequirementPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see br.ufms.facom.acctrace.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://facom.ufms.br/acctrace";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ModelPackage eINSTANCE = br.ufms.facom.acctrace.model.impl.ModelPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.ReferenceImpl
	 * <em>Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.ReferenceImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Uml Models</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__UML_MODELS = 0;

	/**
	 * The feature id for the '<em><b>Requirement Container</b></em>'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REQUIREMENT_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Ontologies</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ONTOLOGIES = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__ID = 3;

	/**
	 * The number of structural features of the '<em>Reference</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl
	 * <em>Acc Trace Model</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.AccTraceModelImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getAccTraceModel()
	 * @generated
	 */
	int ACC_TRACE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACC_TRACE_MODEL__REFERENCES = 0;

	/**
	 * The feature id for the '<em><b>Filter Type</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACC_TRACE_MODEL__FILTER_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Requirement Repositories</b></em>'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES = 2;

	/**
	 * The number of structural features of the '<em>Acc Trace Model</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACC_TRACE_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.OWLOntologyImpl
	 * <em>OWL Ontology</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.OWLOntologyImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getOWLOntology()
	 * @generated
	 */
	int OWL_ONTOLOGY = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWL_ONTOLOGY__PATH = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWL_ONTOLOGY__REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWL_ONTOLOGY__ID = 2;

	/**
	 * The number of structural features of the '<em>OWL Ontology</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWL_ONTOLOGY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.UMLModelImpl <em>UML Model</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.UMLModelImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getUMLModel()
	 * @generated
	 */
	int UML_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__ID = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PATH = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UML Model</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.RequirementContainerImpl
	 * <em>Requirement Container</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.RequirementContainerImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getRequirementContainer()
	 * @generated
	 */
	int REQUIREMENT_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CONTAINER__NAME = RequirementPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CONTAINER__ID = RequirementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Requirement Container</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CONTAINER_FEATURE_COUNT = RequirementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link br.ufms.facom.acctrace.model.impl.RequirementFilterImpl
	 * <em>Requirement Filter</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see br.ufms.facom.acctrace.model.impl.RequirementFilterImpl
	 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getRequirementFilter()
	 * @generated
	 */
	int REQUIREMENT_FILTER = 5;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FILTER__REQUIREMENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Sub Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FILTER__SUB_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FILTER__ID = 2;

	/**
	 * The number of structural features of the '<em>Requirement Filter</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FILTER_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.Reference <em>Reference</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see br.ufms.facom.acctrace.model.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link br.ufms.facom.acctrace.model.Reference#getUmlModels
	 * <em>Uml Models</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Uml Models</em>'.
	 * @see br.ufms.facom.acctrace.model.Reference#getUmlModels()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_UmlModels();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link br.ufms.facom.acctrace.model.Reference#getRequirementContainer
	 * <em>Requirement Container</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '
	 *         <em>Requirement Container</em>'.
	 * @see br.ufms.facom.acctrace.model.Reference#getRequirementContainer()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_RequirementContainer();

	/**
	 * Returns the meta object for the reference '
	 * {@link br.ufms.facom.acctrace.model.Reference#getOntologies
	 * <em>Ontologies</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Ontologies</em>'.
	 * @see br.ufms.facom.acctrace.model.Reference#getOntologies()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Ontologies();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.ufms.facom.acctrace.model.Reference#getId()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_Id();

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.AccTraceModel
	 * <em>Acc Trace Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Acc Trace Model</em>'.
	 * @see br.ufms.facom.acctrace.model.AccTraceModel
	 * @generated
	 */
	EClass getAccTraceModel();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link br.ufms.facom.acctrace.model.AccTraceModel#getReferences
	 * <em>References</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>References</em>'.
	 * @see br.ufms.facom.acctrace.model.AccTraceModel#getReferences()
	 * @see #getAccTraceModel()
	 * @generated
	 */
	EReference getAccTraceModel_References();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link br.ufms.facom.acctrace.model.AccTraceModel#getFilterType
	 * <em>Filter Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Filter Type</em>'.
	 * @see br.ufms.facom.acctrace.model.AccTraceModel#getFilterType()
	 * @see #getAccTraceModel()
	 * @generated
	 */
	EReference getAccTraceModel_FilterType();

	/**
	 * Returns the meta object for the reference list '
	 * {@link br.ufms.facom.acctrace.model.AccTraceModel#getRequirementRepositories
	 * <em>Requirement Repositories</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Requirement Repositories</em>'.
	 * @see br.ufms.facom.acctrace.model.AccTraceModel#getRequirementRepositories()
	 * @see #getAccTraceModel()
	 * @generated
	 */
	EReference getAccTraceModel_RequirementRepositories();

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology <em>OWL Ontology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>OWL Ontology</em>'.
	 * @see br.ufms.facom.acctrace.model.OWLOntology
	 * @generated
	 */
	EClass getOWLOntology();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.ufms.facom.acctrace.model.OWLOntology#getPath()
	 * @see #getOWLOntology()
	 * @generated
	 */
	EAttribute getOWLOntology_Path();

	/**
	 * Returns the meta object for the reference '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology#getReference
	 * <em>Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see br.ufms.facom.acctrace.model.OWLOntology#getReference()
	 * @see #getOWLOntology()
	 * @generated
	 */
	EReference getOWLOntology_Reference();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.ufms.facom.acctrace.model.OWLOntology#getId()
	 * @see #getOWLOntology()
	 * @generated
	 */
	EAttribute getOWLOntology_Id();

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.UMLModel <em>UML Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UML Model</em>'.
	 * @see br.ufms.facom.acctrace.model.UMLModel
	 * @generated
	 */
	EClass getUMLModel();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.UMLModel#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.ufms.facom.acctrace.model.UMLModel#getId()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.UMLModel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see br.ufms.facom.acctrace.model.UMLModel#getPath()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Path();

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.RequirementContainer
	 * <em>Requirement Container</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Requirement Container</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementContainer
	 * @generated
	 */
	EClass getRequirementContainer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.RequirementContainer#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementContainer#getId()
	 * @see #getRequirementContainer()
	 * @generated
	 */
	EAttribute getRequirementContainer_Id();

	/**
	 * Returns the meta object for class '
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter
	 * <em>Requirement Filter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Requirement Filter</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementFilter
	 * @generated
	 */
	EClass getRequirementFilter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter#getRequirementType
	 * <em>Requirement Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Requirement Type</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementFilter#getRequirementType()
	 * @see #getRequirementFilter()
	 * @generated
	 */
	EAttribute getRequirementFilter_RequirementType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter#getSubType
	 * <em>Sub Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sub Type</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementFilter#getSubType()
	 * @see #getRequirementFilter()
	 * @generated
	 */
	EAttribute getRequirementFilter_SubType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter#getId <em>Id</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see br.ufms.facom.acctrace.model.RequirementFilter#getId()
	 * @see #getRequirementFilter()
	 * @generated
	 */
	EAttribute getRequirementFilter_Id();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.ReferenceImpl
		 * <em>Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.ReferenceImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Uml Models</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFERENCE__UML_MODELS = eINSTANCE.getReference_UmlModels();

		/**
		 * The meta object literal for the '
		 * <em><b>Requirement Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFERENCE__REQUIREMENT_CONTAINER = eINSTANCE
				.getReference_RequirementContainer();

		/**
		 * The meta object literal for the '<em><b>Ontologies</b></em>'
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFERENCE__ONTOLOGIES = eINSTANCE.getReference_Ontologies();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE__ID = eINSTANCE.getReference_Id();

		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl
		 * <em>Acc Trace Model</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.AccTraceModelImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getAccTraceModel()
		 * @generated
		 */
		EClass ACC_TRACE_MODEL = eINSTANCE.getAccTraceModel();

		/**
		 * The meta object literal for the '<em><b>References</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ACC_TRACE_MODEL__REFERENCES = eINSTANCE
				.getAccTraceModel_References();

		/**
		 * The meta object literal for the '<em><b>Filter Type</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ACC_TRACE_MODEL__FILTER_TYPE = eINSTANCE
				.getAccTraceModel_FilterType();

		/**
		 * The meta object literal for the '
		 * <em><b>Requirement Repositories</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES = eINSTANCE
				.getAccTraceModel_RequirementRepositories();

		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.OWLOntologyImpl
		 * <em>OWL Ontology</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.OWLOntologyImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getOWLOntology()
		 * @generated
		 */
		EClass OWL_ONTOLOGY = eINSTANCE.getOWLOntology();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OWL_ONTOLOGY__PATH = eINSTANCE.getOWLOntology_Path();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OWL_ONTOLOGY__REFERENCE = eINSTANCE
				.getOWLOntology_Reference();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OWL_ONTOLOGY__ID = eINSTANCE.getOWLOntology_Id();

		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.UMLModelImpl
		 * <em>UML Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.UMLModelImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getUMLModel()
		 * @generated
		 */
		EClass UML_MODEL = eINSTANCE.getUMLModel();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_MODEL__ID = eINSTANCE.getUMLModel_Id();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UML_MODEL__PATH = eINSTANCE.getUMLModel_Path();

		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.RequirementContainerImpl
		 * <em>Requirement Container</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.RequirementContainerImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getRequirementContainer()
		 * @generated
		 */
		EClass REQUIREMENT_CONTAINER = eINSTANCE.getRequirementContainer();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_CONTAINER__ID = eINSTANCE
				.getRequirementContainer_Id();

		/**
		 * The meta object literal for the '
		 * {@link br.ufms.facom.acctrace.model.impl.RequirementFilterImpl
		 * <em>Requirement Filter</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see br.ufms.facom.acctrace.model.impl.RequirementFilterImpl
		 * @see br.ufms.facom.acctrace.model.impl.ModelPackageImpl#getRequirementFilter()
		 * @generated
		 */
		EClass REQUIREMENT_FILTER = eINSTANCE.getRequirementFilter();

		/**
		 * The meta object literal for the '<em><b>Requirement Type</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_FILTER__REQUIREMENT_TYPE = eINSTANCE
				.getRequirementFilter_RequirementType();

		/**
		 * The meta object literal for the '<em><b>Sub Type</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_FILTER__SUB_TYPE = eINSTANCE
				.getRequirementFilter_SubType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT_FILTER__ID = eINSTANCE.getRequirementFilter_Id();

	}

} // ModelPackage
