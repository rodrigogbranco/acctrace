/**
 */
package br.ufms.facom.acctrace.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.NamedElement;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.OWLOntology;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.RequirementContainer;
import br.ufms.facom.acctrace.model.RequirementFilter;
import br.ufms.facom.acctrace.model.UMLModel;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see br.ufms.facom.acctrace.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch = new ModelSwitch<Adapter>() {
		@Override
		public Adapter caseReference(Reference object) {
			return createReferenceAdapter();
		}

		@Override
		public Adapter caseAccTraceModel(AccTraceModel object) {
			return createAccTraceModelAdapter();
		}

		@Override
		public Adapter caseOWLOntology(OWLOntology object) {
			return createOWLOntologyAdapter();
		}

		@Override
		public Adapter caseUMLModel(UMLModel object) {
			return createUMLModelAdapter();
		}

		@Override
		public Adapter caseRequirementContainer(RequirementContainer object) {
			return createRequirementContainerAdapter();
		}

		@Override
		public Adapter caseRequirementFilter(RequirementFilter object) {
			return createRequirementFilterAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.Reference <em>Reference</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.AccTraceModel
	 * <em>Acc Trace Model</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.AccTraceModel
	 * @generated
	 */
	public Adapter createAccTraceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology <em>OWL Ontology</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.OWLOntology
	 * @generated
	 */
	public Adapter createOWLOntologyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.UMLModel <em>UML Model</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.UMLModel
	 * @generated
	 */
	public Adapter createUMLModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.RequirementContainer
	 * <em>Requirement Container</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.RequirementContainer
	 * @generated
	 */
	public Adapter createRequirementContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter
	 * <em>Requirement Filter</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see br.ufms.facom.acctrace.model.RequirementFilter
	 * @generated
	 */
	public Adapter createRequirementFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.obeonetwork.dsl.requirement.NamedElement
	 * <em>Named Element</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.obeonetwork.dsl.requirement.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ModelAdapterFactory
