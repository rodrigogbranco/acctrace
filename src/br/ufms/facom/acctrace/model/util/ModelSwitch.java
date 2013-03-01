/**
 */
package br.ufms.facom.acctrace.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.obeonetwork.dsl.requirement.NamedElement;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.OWLOntology;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.RequirementContainer;
import br.ufms.facom.acctrace.model.RequirementFilter;
import br.ufms.facom.acctrace.model.RequirementRepository;
import br.ufms.facom.acctrace.model.UMLModel;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @param <T>
 *            the generic type
 * @see br.ufms.facom.acctrace.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {

	/** The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param ePackage
	 *            the e package
	 * @return whether this is a switch for the given package.
	 * @parameter ePackage the package in question.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns
	 * a non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param classifierID
	 *            the classifier id
	 * @param theEObject
	 *            the the e object
	 * @return the first non-null result returned by a <code>caseXXX</code>
	 *         call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ModelPackage.REFERENCE: {
			Reference reference = (Reference) theEObject;
			T result = caseReference(reference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.ACC_TRACE_MODEL: {
			AccTraceModel accTraceModel = (AccTraceModel) theEObject;
			T result = caseAccTraceModel(accTraceModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.OWL_ONTOLOGY: {
			OWLOntology owlOntology = (OWLOntology) theEObject;
			T result = caseOWLOntology(owlOntology);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.UML_MODEL: {
			UMLModel umlModel = (UMLModel) theEObject;
			T result = caseUMLModel(umlModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.REQUIREMENT_CONTAINER: {
			RequirementContainer requirementContainer = (RequirementContainer) theEObject;
			T result = caseRequirementContainer(requirementContainer);
			if (result == null)
				result = caseNamedElement(requirementContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.REQUIREMENT_REPOSITORY: {
			RequirementRepository requirementRepository = (RequirementRepository) theEObject;
			T result = caseRequirementRepository(requirementRepository);
			if (result == null)
				result = caseRepository(requirementRepository);
			if (result == null)
				result = caseNamedElement(requirementRepository);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ModelPackage.REQUIREMENT_FILTER: {
			RequirementFilter requirementFilter = (RequirementFilter) theEObject;
			T result = caseRequirementFilter(requirementFilter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Reference</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Acc Trace Model</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Acc Trace Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccTraceModel(AccTraceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>OWL Ontology</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>OWL Ontology</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOWLOntology(OWLOntology object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>UML Model</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>UML Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLModel(UMLModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Requirement Container</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Requirement Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementContainer(RequirementContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Requirement Repository</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Requirement Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementRepository(RequirementRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Requirement Filter</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Requirement Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementFilter(RequirementFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Named Element</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Repository</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepository(Repository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // ModelSwitch
