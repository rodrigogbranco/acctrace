/**
 */
package br.ufms.facom.acctrace.model.impl;

import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.OWLOntology;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.UMLModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.requirement.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getUmlModel <em>Uml Model</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getOntologies <em>Ontologies</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getId <em>Id</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getRequirement <em>Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends EObjectImpl implements Reference {
	/**
	 * The cached value of the '{@link #getUmlModel() <em>Uml Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlModel()
	 * @generated
	 * @ordered
	 */
	protected UMLModel umlModel;

	/**
	 * The cached value of the '{@link #getOntologies() <em>Ontologies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntologies()
	 * @generated
	 * @ordered
	 */
	protected EList<OWLOntology> ontologies;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected Requirement requirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLModel getUmlModel() {
		return umlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUmlModel(UMLModel newUmlModel, NotificationChain msgs) {
		UMLModel oldUmlModel = umlModel;
		umlModel = newUmlModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__UML_MODEL, oldUmlModel, newUmlModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlModel(UMLModel newUmlModel) {
		if (newUmlModel != umlModel) {
			NotificationChain msgs = null;
			if (umlModel != null)
				msgs = ((InternalEObject)umlModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.REFERENCE__UML_MODEL, null, msgs);
			if (newUmlModel != null)
				msgs = ((InternalEObject)newUmlModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.REFERENCE__UML_MODEL, null, msgs);
			msgs = basicSetUmlModel(newUmlModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__UML_MODEL, newUmlModel, newUmlModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OWLOntology> getOntologies() {
		if (ontologies == null) {
			ontologies = new EObjectWithInverseResolvingEList<OWLOntology>(OWLOntology.class, this, ModelPackage.REFERENCE__ONTOLOGIES, ModelPackage.OWL_ONTOLOGY__REFERENCE);
		}
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirement(Requirement newRequirement, NotificationChain msgs) {
		Requirement oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__REQUIREMENT, oldRequirement, newRequirement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(Requirement newRequirement) {
		if (newRequirement != requirement) {
			NotificationChain msgs = null;
			if (requirement != null)
				msgs = ((InternalEObject)requirement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.REFERENCE__REQUIREMENT, null, msgs);
			if (newRequirement != null)
				msgs = ((InternalEObject)newRequirement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.REFERENCE__REQUIREMENT, null, msgs);
			msgs = basicSetRequirement(newRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__REQUIREMENT, newRequirement, newRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOntologies()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.REFERENCE__UML_MODEL:
				return basicSetUmlModel(null, msgs);
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return ((InternalEList<?>)getOntologies()).basicRemove(otherEnd, msgs);
			case ModelPackage.REFERENCE__REQUIREMENT:
				return basicSetRequirement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REFERENCE__UML_MODEL:
				return getUmlModel();
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return getOntologies();
			case ModelPackage.REFERENCE__ID:
				return getId();
			case ModelPackage.REFERENCE__REQUIREMENT:
				return getRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.REFERENCE__UML_MODEL:
				setUmlModel((UMLModel)newValue);
				return;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				getOntologies().clear();
				getOntologies().addAll((Collection<? extends OWLOntology>)newValue);
				return;
			case ModelPackage.REFERENCE__ID:
				setId((String)newValue);
				return;
			case ModelPackage.REFERENCE__REQUIREMENT:
				setRequirement((Requirement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.REFERENCE__UML_MODEL:
				setUmlModel((UMLModel)null);
				return;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				getOntologies().clear();
				return;
			case ModelPackage.REFERENCE__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.REFERENCE__REQUIREMENT:
				setRequirement((Requirement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.REFERENCE__UML_MODEL:
				return umlModel != null;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return ontologies != null && !ontologies.isEmpty();
			case ModelPackage.REFERENCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.REFERENCE__REQUIREMENT:
				return requirement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
