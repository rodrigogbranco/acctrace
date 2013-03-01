/**
 */
package br.ufms.facom.acctrace.model;

import org.obeonetwork.dsl.requirement.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Requirement Container</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link br.ufms.facom.acctrace.model.RequirementContainer#getId <em>Id
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementContainer()
 * @model
 * @generated
 */
public interface RequirementContainer extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getRequirementContainer_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link br.ufms.facom.acctrace.model.RequirementContainer#getId
	 * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // RequirementContainer
