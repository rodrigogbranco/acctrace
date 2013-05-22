/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Repository;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Acc Trace Model</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.AccTraceModel#getReferences <em>References</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.AccTraceModel#getFilterType <em>Filter Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.AccTraceModel#getRequirementRepositories <em>Requirement Repositories</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufms.facom.acctrace.model.ModelPackage#getAccTraceModel()
 * @model
 * @generated
 */
public interface AccTraceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link br.ufms.facom.acctrace.model.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getAccTraceModel_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Filter Type</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link br.ufms.facom.acctrace.model.RequirementFilter}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Type</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Filter Type</em>' containment reference
	 *         list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getAccTraceModel_FilterType()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequirementFilter> getFilterType();

	/**
	 * Returns the value of the '<em><b>Requirement Repositories</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.requirement.Repository}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Requirement Repositories</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Repositories</em>' reference list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getAccTraceModel_RequirementRepositories()
	 * @model
	 * @generated
	 */
	EList<Repository> getRequirementRepositories();

} // AccTraceModel
