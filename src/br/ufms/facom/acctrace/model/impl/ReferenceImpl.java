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
import org.eclipse.emf.ecore.util.InternalEList;

import br.ufms.facom.acctrace.model.ModelPackage;
import br.ufms.facom.acctrace.model.OWLOntology;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.RequirementContainer;
import br.ufms.facom.acctrace.model.UMLModel;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getUmlModels <em>
 * Uml Models</em>}</li>
 * <li>
 * {@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getRequirementContainer
 * <em>Requirement Container</em>}</li>
 * <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getOntologies <em>
 * Ontologies</em>}</li>
 * <li>{@link br.ufms.facom.acctrace.model.impl.ReferenceImpl#getId <em>Id</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ReferenceImpl extends EObjectImpl implements Reference {
	/**
	 * The cached value of the '{@link #getUmlModels() <em>Uml Models</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUmlModels()
	 * @generated
	 * @ordered
	 */
	protected EList<UMLModel> umlModels;

	/**
	 * The cached value of the '{@link #getRequirementContainer()
	 * <em>Requirement Container</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequirementContainer()
	 * @generated
	 * @ordered
	 */
	protected RequirementContainer requirementContainer;

	/**
	 * The cached value of the '{@link #getOntologies() <em>Ontologies</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOntologies()
	 * @generated
	 * @ordered
	 */
	protected OWLOntology ontologies;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the e class
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the uml models
	 * @generated
	 */
	public EList<UMLModel> getUmlModels() {
		if (umlModels == null) {
			umlModels = new EObjectContainmentEList<UMLModel>(UMLModel.class,
					this, ModelPackage.REFERENCE__UML_MODELS);
		}
		return umlModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the requirement container
	 * @generated
	 */
	public RequirementContainer getRequirementContainer() {
		return requirementContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param newRequirementContainer
	 *            the new requirement container
	 * @param msgs
	 *            the msgs
	 * @return the notification chain
	 * @generated
	 */
	public NotificationChain basicSetRequirementContainer(
			RequirementContainer newRequirementContainer, NotificationChain msgs) {
		RequirementContainer oldRequirementContainer = requirementContainer;
		requirementContainer = newRequirementContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ModelPackage.REFERENCE__REQUIREMENT_CONTAINER,
					oldRequirementContainer, newRequirementContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param newRequirementContainer
	 *            the new requirement container
	 * @generated
	 */
	public void setRequirementContainer(
			RequirementContainer newRequirementContainer) {
		if (newRequirementContainer != requirementContainer) {
			NotificationChain msgs = null;
			if (requirementContainer != null)
				msgs = ((InternalEObject) requirementContainer)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.REFERENCE__REQUIREMENT_CONTAINER,
								null, msgs);
			if (newRequirementContainer != null)
				msgs = ((InternalEObject) newRequirementContainer)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.REFERENCE__REQUIREMENT_CONTAINER,
								null, msgs);
			msgs = basicSetRequirementContainer(newRequirementContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.REFERENCE__REQUIREMENT_CONTAINER,
					newRequirementContainer, newRequirementContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the ontologies
	 * @generated
	 */
	public OWLOntology getOntologies() {
		if (ontologies != null && ontologies.eIsProxy()) {
			InternalEObject oldOntologies = (InternalEObject) ontologies;
			ontologies = (OWLOntology) eResolveProxy(oldOntologies);
			if (ontologies != oldOntologies) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.REFERENCE__ONTOLOGIES, oldOntologies,
							ontologies));
			}
		}
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the oWL ontology
	 * @generated
	 */
	public OWLOntology basicGetOntologies() {
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param newOntologies
	 *            the new ontologies
	 * @param msgs
	 *            the msgs
	 * @return the notification chain
	 * @generated
	 */
	public NotificationChain basicSetOntologies(OWLOntology newOntologies,
			NotificationChain msgs) {
		OWLOntology oldOntologies = ontologies;
		ontologies = newOntologies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ModelPackage.REFERENCE__ONTOLOGIES,
					oldOntologies, newOntologies);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param newOntologies
	 *            the new ontologies
	 * @generated
	 */
	public void setOntologies(OWLOntology newOntologies) {
		if (newOntologies != ontologies) {
			NotificationChain msgs = null;
			if (ontologies != null)
				msgs = ((InternalEObject) ontologies).eInverseRemove(this,
						ModelPackage.OWL_ONTOLOGY__REFERENCE,
						OWLOntology.class, msgs);
			if (newOntologies != null)
				msgs = ((InternalEObject) newOntologies).eInverseAdd(this,
						ModelPackage.OWL_ONTOLOGY__REFERENCE,
						OWLOntology.class, msgs);
			msgs = basicSetOntologies(newOntologies, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.REFERENCE__ONTOLOGIES, newOntologies,
					newOntologies));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the id
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param newId
	 *            the new id
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.REFERENCE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param otherEnd
	 *            the other end
	 * @param featureID
	 *            the feature id
	 * @param msgs
	 *            the msgs
	 * @return the notification chain
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.REFERENCE__ONTOLOGIES:
			if (ontologies != null)
				msgs = ((InternalEObject) ontologies).eInverseRemove(this,
						ModelPackage.OWL_ONTOLOGY__REFERENCE,
						OWLOntology.class, msgs);
			return basicSetOntologies((OWLOntology) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param otherEnd
	 *            the other end
	 * @param featureID
	 *            the feature id
	 * @param msgs
	 *            the msgs
	 * @return the notification chain
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.REFERENCE__UML_MODELS:
			return ((InternalEList<?>) getUmlModels()).basicRemove(otherEnd,
					msgs);
		case ModelPackage.REFERENCE__REQUIREMENT_CONTAINER:
			return basicSetRequirementContainer(null, msgs);
		case ModelPackage.REFERENCE__ONTOLOGIES:
			return basicSetOntologies(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param featureID
	 *            the feature id
	 * @param resolve
	 *            the resolve
	 * @param coreType
	 *            the core type
	 * @return the object
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.REFERENCE__UML_MODELS:
			return getUmlModels();
		case ModelPackage.REFERENCE__REQUIREMENT_CONTAINER:
			return getRequirementContainer();
		case ModelPackage.REFERENCE__ONTOLOGIES:
			if (resolve)
				return getOntologies();
			return basicGetOntologies();
		case ModelPackage.REFERENCE__ID:
			return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param featureID
	 *            the feature id
	 * @param newValue
	 *            the new value
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.REFERENCE__UML_MODELS:
			getUmlModels().clear();
			getUmlModels().addAll((Collection<? extends UMLModel>) newValue);
			return;
		case ModelPackage.REFERENCE__REQUIREMENT_CONTAINER:
			setRequirementContainer((RequirementContainer) newValue);
			return;
		case ModelPackage.REFERENCE__ONTOLOGIES:
			setOntologies((OWLOntology) newValue);
			return;
		case ModelPackage.REFERENCE__ID:
			setId((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param featureID
	 *            the feature id
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.REFERENCE__UML_MODELS:
			getUmlModels().clear();
			return;
		case ModelPackage.REFERENCE__REQUIREMENT_CONTAINER:
			setRequirementContainer((RequirementContainer) null);
			return;
		case ModelPackage.REFERENCE__ONTOLOGIES:
			setOntologies((OWLOntology) null);
			return;
		case ModelPackage.REFERENCE__ID:
			setId(ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @param featureID
	 *            the feature id
	 * @return true, if successful
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.REFERENCE__UML_MODELS:
			return umlModels != null && !umlModels.isEmpty();
		case ModelPackage.REFERENCE__REQUIREMENT_CONTAINER:
			return requirementContainer != null;
		case ModelPackage.REFERENCE__ONTOLOGIES:
			return ontologies != null;
		case ModelPackage.REFERENCE__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @return the string
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // ReferenceImpl
