/**
 */
package br.ufms.facom.acctrace.model.impl;

import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.Reference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.obeonetwork.dsl.requirement.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getId <em>Id</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getUmlModel <em>Uml Model</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getOntologies <em>Ontologies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends EObjectImpl implements Reference {
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
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected Requirement requirement;

	/**
	 * The cached value of the '{@link #getUmlModel() <em>Uml Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlModel()
	 * @generated
	 * @ordered
	 */
	protected EObject umlModel;

	/**
	 * The cached value of the '{@link #getOntologies() <em>Ontologies</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntologies()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ontologies;

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
		if (requirement != null && requirement.eIsProxy()) {
			InternalEObject oldRequirement = (InternalEObject)requirement;
			requirement = (Requirement)eResolveProxy(oldRequirement);
			if (requirement != oldRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REFERENCE__REQUIREMENT, oldRequirement, requirement));
			}
		}
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(Requirement newRequirement) {
		Requirement oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__REQUIREMENT, oldRequirement, requirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getUmlModel() {
		if (umlModel != null && umlModel.eIsProxy()) {
			InternalEObject oldUmlModel = (InternalEObject)umlModel;
			umlModel = eResolveProxy(oldUmlModel);
			if (umlModel != oldUmlModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REFERENCE__UML_MODEL, oldUmlModel, umlModel));
			}
		}
		return umlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetUmlModel() {
		return umlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlModel(EObject newUmlModel) {
		EObject oldUmlModel = umlModel;
		umlModel = newUmlModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REFERENCE__UML_MODEL, oldUmlModel, umlModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOntologies() {
		if (ontologies == null) {
			ontologies = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.REFERENCE__ONTOLOGIES);
		}
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REFERENCE__ID:
				return getId();
			case ModelPackage.REFERENCE__REQUIREMENT:
				if (resolve) return getRequirement();
				return basicGetRequirement();
			case ModelPackage.REFERENCE__UML_MODEL:
				if (resolve) return getUmlModel();
				return basicGetUmlModel();
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return getOntologies();
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
			case ModelPackage.REFERENCE__ID:
				setId((String)newValue);
				return;
			case ModelPackage.REFERENCE__REQUIREMENT:
				setRequirement((Requirement)newValue);
				return;
			case ModelPackage.REFERENCE__UML_MODEL:
				setUmlModel((EObject)newValue);
				return;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				getOntologies().clear();
				getOntologies().addAll((Collection<? extends String>)newValue);
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
			case ModelPackage.REFERENCE__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.REFERENCE__REQUIREMENT:
				setRequirement((Requirement)null);
				return;
			case ModelPackage.REFERENCE__UML_MODEL:
				setUmlModel((EObject)null);
				return;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				getOntologies().clear();
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
			case ModelPackage.REFERENCE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.REFERENCE__REQUIREMENT:
				return requirement != null;
			case ModelPackage.REFERENCE__UML_MODEL:
				return umlModel != null;
			case ModelPackage.REFERENCE__ONTOLOGIES:
				return ontologies != null && !ontologies.isEmpty();
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
		result.append(", ontologies: ");
		result.append(ontologies);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
