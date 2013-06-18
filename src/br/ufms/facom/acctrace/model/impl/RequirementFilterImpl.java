/**
 */
package br.ufms.facom.acctrace.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.obeonetwork.dsl.requirement.RequirementType;

import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.RequirementFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.RequirementFilterImpl#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.RequirementFilterImpl#getSubType <em>Sub Type</em>}</li>
 *   <li>{@link br.ufms.facom.acctrace.model.impl.RequirementFilterImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementFilterImpl extends EObjectImpl implements RequirementFilter {
	/**
	 * The default value of the '{@link #getRequirementType() <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementType()
	 * @generated
	 * @ordered
	 */
	protected static final RequirementType REQUIREMENT_TYPE_EDEFAULT = RequirementType.FUNCTIONAL;

	/**
	 * The cached value of the '{@link #getRequirementType() <em>Requirement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementType()
	 * @generated
	 * @ordered
	 */
	protected RequirementType requirementType = REQUIREMENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubType() <em>Sub Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubType()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubType() <em>Sub Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubType()
	 * @generated
	 * @ordered
	 */
	protected String subType = SUB_TYPE_EDEFAULT;

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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REQUIREMENT_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementType getRequirementType() {
		return requirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirementType(RequirementType newRequirementType) {
		RequirementType oldRequirementType = requirementType;
		requirementType = newRequirementType == null ? REQUIREMENT_TYPE_EDEFAULT : newRequirementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REQUIREMENT_FILTER__REQUIREMENT_TYPE, oldRequirementType, requirementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubType(String newSubType) {
		String oldSubType = subType;
		subType = newSubType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REQUIREMENT_FILTER__SUB_TYPE, oldSubType, subType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REQUIREMENT_FILTER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REQUIREMENT_FILTER__REQUIREMENT_TYPE:
				return getRequirementType();
			case ModelPackage.REQUIREMENT_FILTER__SUB_TYPE:
				return getSubType();
			case ModelPackage.REQUIREMENT_FILTER__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.REQUIREMENT_FILTER__REQUIREMENT_TYPE:
				setRequirementType((RequirementType)newValue);
				return;
			case ModelPackage.REQUIREMENT_FILTER__SUB_TYPE:
				setSubType((String)newValue);
				return;
			case ModelPackage.REQUIREMENT_FILTER__ID:
				setId((String)newValue);
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
			case ModelPackage.REQUIREMENT_FILTER__REQUIREMENT_TYPE:
				setRequirementType(REQUIREMENT_TYPE_EDEFAULT);
				return;
			case ModelPackage.REQUIREMENT_FILTER__SUB_TYPE:
				setSubType(SUB_TYPE_EDEFAULT);
				return;
			case ModelPackage.REQUIREMENT_FILTER__ID:
				setId(ID_EDEFAULT);
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
			case ModelPackage.REQUIREMENT_FILTER__REQUIREMENT_TYPE:
				return requirementType != REQUIREMENT_TYPE_EDEFAULT;
			case ModelPackage.REQUIREMENT_FILTER__SUB_TYPE:
				return SUB_TYPE_EDEFAULT == null ? subType != null : !SUB_TYPE_EDEFAULT.equals(subType);
			case ModelPackage.REQUIREMENT_FILTER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (requirementType: ");
		result.append(requirementType);
		result.append(", subType: ");
		result.append(subType);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //RequirementFilterImpl
