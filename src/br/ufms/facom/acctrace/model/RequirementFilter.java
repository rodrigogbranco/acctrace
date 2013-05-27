/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.ecore.EObject;

import org.obeonetwork.dsl.requirement.RequirementType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.RequirementFilter#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.RequirementFilter#getSubType <em>Sub Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.RequirementFilter#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementFilter()
 * @model
 * @generated
 */
public interface RequirementFilter extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.obeonetwork.dsl.requirement.RequirementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Type</em>' attribute.
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @see #setRequirementType(RequirementType)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementFilter_RequirementType()
	 * @model
	 * @generated
	 */
	RequirementType getRequirementType();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.RequirementFilter#getRequirementType <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type</em>' attribute.
	 * @see org.obeonetwork.dsl.requirement.RequirementType
	 * @see #getRequirementType()
	 * @generated
	 */
	void setRequirementType(RequirementType value);

	/**
	 * Returns the value of the '<em><b>Sub Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Type</em>' attribute.
	 * @see #setSubType(String)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementFilter_SubType()
	 * @model
	 * @generated
	 */
	String getSubType();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.RequirementFilter#getSubType <em>Sub Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Type</em>' attribute.
	 * @see #getSubType()
	 * @generated
	 */
	void setSubType(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementFilter_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.RequirementFilter#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // RequirementFilter
