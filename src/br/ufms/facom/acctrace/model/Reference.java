/**
 */
package br.ufms.facom.acctrace.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.requirement.Requirement;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getUmlModel <em>Uml Model</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.Reference#getOntologies <em>Ontologies</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends EObject {
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
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' reference.
	 * @see #setRequirement(Requirement)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Requirement()
	 * @model
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getRequirement <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Uml Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Model</em>' reference.
	 * @see #setUmlModel(EObject)
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_UmlModel()
	 * @model
	 * @generated
	 */
	EObject getUmlModel();

	/**
	 * Sets the value of the '{@link br.ufms.facom.acctrace.model.Reference#getUmlModel <em>Uml Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Model</em>' reference.
	 * @see #getUmlModel()
	 * @generated
	 */
	void setUmlModel(EObject value);

	/**
	 * Returns the value of the '<em><b>Ontologies</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontologies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ontologies</em>' attribute list.
	 * @see br.ufms.facom.acctrace.model.ModelPackage#getReference_Ontologies()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getOntologies();

} // Reference
