/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getUmlModel <em>Uml Model</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getOntologies <em>Ontologies</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject {
	/**
	 * Returns the value of the '<em><b>Uml Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Model</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Model</em>' containment reference.
	 * @see #setUmlModel(UMLModel)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_UmlModel()
	 * @model containment="true"
	 * @generated
	 */
	UMLModel getUmlModel();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getUmlModel <em>Uml Model</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Uml Model</em>' containment reference.
	 * @see #getUmlModel()
	 * @generated
	 */
	void setUmlModel(UMLModel value);

	/**
	 * Returns the value of the '<em><b>Ontologies</b></em>' reference list.
	 * The list contents are of type {@link br.ufms.facom.acctrace.model.OWLOntology}.
	 * It is bidirectional and its opposite is '{@link br.ufms.facom.acctrace.model.OWLOntology#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontologies</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ontologies</em>' reference list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Ontologies()
	 * @see br.ufms.facom.acctrace.model.OWLOntology#getReference
	 * @model opposite="reference"
	 * @generated
	 */
	EList<OWLOntology> getOntologies();

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
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' containment reference.
	 * @see #setRequirement(Requirement)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Requirement()
	 * @model containment="true"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getRequirement <em>Requirement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' containment reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

} // Reference
