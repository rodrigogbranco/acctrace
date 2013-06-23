/**
 */
package br.ufms.facom.acctrace.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.RequirementFilter;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Acc Trace Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl#getReferences <em>References</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl#getFilterType <em>Filter Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl#getRequirementRepositories <em>Requirement Repositories</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.AccTraceModelImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccTraceModelImpl extends EObjectImpl implements AccTraceModel {
	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> references;

	/**
	 * The cached value of the '{@link #getFilterType() <em>Filter Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterType()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementFilter> filterType;

	/**
	 * The cached value of the '{@link #getRequirementRepositories() <em>Requirement Repositories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementRepositories()
	 * @generated
	 * @ordered
	 */
	protected EList<Repository> requirementRepositories;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @generated
	 */
	protected AccTraceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the e class
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ACC_TRACE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the references
	 * @generated
	 */
	public EList<Reference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference>(Reference.class, this, ModelPackage.ACC_TRACE_MODEL__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the filter type
	 * @generated
	 */
	public EList<RequirementFilter> getFilterType() {
		if (filterType == null) {
			filterType = new EObjectContainmentEList<RequirementFilter>(RequirementFilter.class, this, ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE);
		}
		return filterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the requirement repositories
	 * @generated
	 */
	public EList<Repository> getRequirementRepositories() {
		if (requirementRepositories == null) {
			requirementRepositories = new EObjectResolvingEList<Repository>(Repository.class, this, ModelPackage.ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES);
		}
		return requirementRepositories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the id
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param newId the new id
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACC_TRACE_MODEL__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param otherEnd the other end
	 * @param featureID the feature id
	 * @param msgs the msgs
	 * @return the notification chain
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ACC_TRACE_MODEL__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE:
				return ((InternalEList<?>)getFilterType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @param resolve the resolve
	 * @param coreType the core type
	 * @return the object
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ACC_TRACE_MODEL__REFERENCES:
				return getReferences();
			case ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE:
				return getFilterType();
			case ModelPackage.ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES:
				return getRequirementRepositories();
			case ModelPackage.ACC_TRACE_MODEL__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @param newValue the new value
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ACC_TRACE_MODEL__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE:
				getFilterType().clear();
				getFilterType().addAll((Collection<? extends RequirementFilter>)newValue);
				return;
			case ModelPackage.ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES:
				getRequirementRepositories().clear();
				getRequirementRepositories().addAll((Collection<? extends Repository>)newValue);
				return;
			case ModelPackage.ACC_TRACE_MODEL__ID:
				setId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.ACC_TRACE_MODEL__REFERENCES:
				getReferences().clear();
				return;
			case ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE:
				getFilterType().clear();
				return;
			case ModelPackage.ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES:
				getRequirementRepositories().clear();
				return;
			case ModelPackage.ACC_TRACE_MODEL__ID:
				setId(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @param featureID the feature id
	 * @return true, if successful
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.ACC_TRACE_MODEL__REFERENCES:
				return references != null && !references.isEmpty();
			case ModelPackage.ACC_TRACE_MODEL__FILTER_TYPE:
				return filterType != null && !filterType.isEmpty();
			case ModelPackage.ACC_TRACE_MODEL__REQUIREMENT_REPOSITORIES:
				return requirementRepositories != null && !requirementRepositories.isEmpty();
			case ModelPackage.ACC_TRACE_MODEL__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the string
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

} //AccTraceModelImpl
