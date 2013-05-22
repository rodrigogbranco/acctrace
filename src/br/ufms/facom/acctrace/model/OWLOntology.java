/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>OWL Ontology</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.OWLOntology#getPath <em>Path</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.OWLOntology#getReference <em>Reference</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.OWLOntology#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufms.facom.acctrace.model.ModelPackage#getOWLOntology()
 * @model
 * @generated
 */
public interface OWLOntology extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getOWLOntology_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.OWLOntology#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link br.ufms.facom.acctrace.model.Reference#getOntologies <em>Ontologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(Reference)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getOWLOntology_Reference()
	 * @see br.ufms.facom.acctrace.model.Reference#getOntologies
	 * @model opposite="ontologies"
	 * @generated
	 */
	Reference getReference();

	/**
	 * Sets the value of the '
	 * {@link br.ufms.facom.acctrace.model.OWLOntology#getReference
	 * <em>Reference</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Reference value);

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
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getOWLOntology_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.OWLOntology#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // OWLOntology
