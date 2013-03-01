/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Reference</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link br.ufms.facom.acctrace.model.Reference#getUmlModels <em>Uml Models
 * </em>}</li>
 * <li>{@link br.ufms.facom.acctrace.model.Reference#getRequirementContainer
 * <em>Requirement Container</em>}</li>
 * <li>{@link br.ufms.facom.acctrace.model.Reference#getOntologies <em>
 * Ontologies</em>}</li>
 * <li>{@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject {
	/**
	 * Returns the value of the '<em><b>Uml Models</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link br.ufms.facom.acctrace.model.UMLModel}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Models</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uml Models</em>' containment reference
	 *         list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_UmlModels()
	 * @model containment="true"
	 * @generated
	 */
	EList<UMLModel> getUmlModels();

	/**
	 * Returns the value of the '<em><b>Requirement Container</b></em>'
	 * containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Container</em>' containment
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requirement Container</em>' containment
	 *         reference.
	 * @see #setRequirementContainer(RequirementContainer)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_RequirementContainer()
	 * @model containment="true"
	 * @generated
	 */
	RequirementContainer getRequirementContainer();

	/**
	 * Sets the value of the '
	 * {@link br.ufms.facom.acctrace.model.Reference#getRequirementContainer
	 * <em>Requirement Container</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Requirement Container</em>'
	 *            containment reference.
	 * @see #getRequirementContainer()
	 * @generated
	 */
	void setRequirementContainer(RequirementContainer value);

	/**
	 * Returns the value of the '<em><b>Ontologies</b></em>' reference. It is
	 * bidirectional and its opposite is '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology#getReference
	 * <em>Reference</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontologies</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ontologies</em>' reference.
	 * @see #setOntologies(OWLOntology)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Ontologies()
	 * @see br.ufms.facom.acctrace.model.OWLOntology#getReference
	 * @model opposite="reference"
	 * @generated
	 */
	OWLOntology getOntologies();

	/**
	 * Sets the value of the '
	 * {@link br.ufms.facom.acctrace.model.Reference#getOntologies
	 * <em>Ontologies</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Ontologies</em>' reference.
	 * @see #getOntologies()
	 * @generated
	 */
	void setOntologies(OWLOntology value);

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
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Reference
