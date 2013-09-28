/**
 * 
 */
package br.ufms.facom.acctrace.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.semanticweb.owlapi.model.IRI;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelFactory;
import br.ufms.facom.acctrace.model.ModelLoader;
import br.ufms.facom.acctrace.model.Reference;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelController.
 * 
 * @author Rodrigo Branco
 */
public final class ModelController {

	/** The Constant instance. */
	private static final ModelController instance = new ModelController();

	/** The model. */
	private AccTraceModel model;

	/** The options. */
	private Map<String, Object> options = new HashMap<String, Object>();

	/** The loader. */
	private ModelLoader loader;

	/**
	 * Instantiates a new model controller.
	 */
	private ModelController() {
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		loader = ModelLoader.getInstance();
	}

	/**
	 * Gets the single instance of ModelController.
	 * 
	 * @return single instance of ModelController
	 */
	public static synchronized ModelController getInstance() {
		return instance;
	}

	/**
	 * Gets the model.
	 * 
	 * @return the model
	 */
	public AccTraceModel getModel() {
		return model;
	}

	/**
	 * Load.
	 * 
	 * @param inputFile
	 *            the input file
	 */
	public void load(IEditorInput inputFile) {
		model = loader.load(inputFile);
	}

	/**
	 * Load.
	 * 
	 * @param inputFile
	 *            the input file
	 */
	public void load(IFile inputFile) {
		model = loader.load(inputFile);
	}

	/**
	 * Gets the requirement repositories paths.
	 * 
	 * @return the requirement repositories paths
	 */
	public ArrayList<String> getRequirementRepositoriesPaths() {
		ArrayList<String> list = new ArrayList<String>();
		for (EObject object : model.getRequirementRepositories()) {
			Repository repository = (Repository) object;
			list.add(EcoreUtil.getURI(repository).toString());
		}
		return list;
	}

	/**
	 * Removes the from model.
	 * 
	 * @param filePath
	 *            the file path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void removeFromModel(String filePath) throws IOException {
		Repository repository = loader.getRequirementRepository(filePath
				.substring(18));
		for (Repository rep : model.getRequirementRepositories()) {
			if (rep.eResource().getURI()
					.equals(repository.eResource().getURI())) {
				model.getRequirementRepositories().remove(rep);
				break;
			}
		}
		model.eResource().save(options);
	}

	/**
	 * Gets the requirement repository.
	 * 
	 * @param iFile
	 *            the i file
	 * @return the requirement repository
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Repository getRequirementRepository(IFile iFile) throws IOException {
		return loader.getRequirementRepository(iFile);
	}

	/**
	 * Adds the repository.
	 * 
	 * @param repository
	 *            the repository
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void addRepository(Repository repository) throws IOException {
		model.getRequirementRepositories().add(repository);
		model.eResource().save(options);
	}

	/**
	 * Adds the accessibility reference.
	 * 
	 * @param req
	 *            the req
	 * @param pack
	 *            the pack
	 * @param iri
	 *            the iri
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void addAccessibilityReference(Requirement req,
			PackageableElement pack, IRI iri) throws IOException {
		EList<Reference> refs = model.getReferences();

		Reference reference = null;
		for (Reference ref : refs) {
			if (ref.getUmlModel().equals(pack)
					&& ref.getRequirement().equals(req)) {
				reference = ref;
				break;
			}
		}

		if (reference == null) {
			reference = ModelFactory.eINSTANCE.createReference();
			reference.setRequirement(req);
			reference.setUmlModel(pack);
			reference.setId(EcoreUtil.generateUUID());
			refs.add(reference);
		}

		if (!reference.getOntologies().contains(iri.toString()))
			reference.getOntologies().add(iri.toString());

		model.eResource().save(options);
	}

	/**
	 * Removes the accessibility reference.
	 * 
	 * @param req
	 *            the req
	 * @param pack
	 *            the pack
	 * @param iri
	 *            the iri
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void removeAccessibilityReference(Requirement req,
			PackageableElement pack, IRI iri) throws IOException {
		for (Reference ref : model.getReferences()) {
			if (ref.getUmlModel().equals(pack)
					&& ref.getRequirement().equals(req)) {
				ref.getOntologies().remove(iri.toString());
				break;
			}
		}

		model.eResource().save(options);
	}

	/**
	 * Gets the reference.
	 * 
	 * @param req
	 *            the req
	 * @param pack
	 *            the pack
	 * @return the reference
	 */
	public Reference getReference(Requirement req, PackageableElement pack) {
		for (Reference ref : model.getReferences()) {
			if (ref.getUmlModel().equals(pack)
					&& ref.getRequirement().equals(req))
				return ref;
		}

		return null;
	}

	/**
	 * Load uml model.
	 * 
	 * @param eObj
	 *            the e obj
	 * @return the model
	 */
	public Model loadUMLModel(EObject eObj) {
		return loader.loadUMLModel(eObj);
	}

	/**
	 * Gets the label.
	 * 
	 * @param pElement
	 *            the element
	 * @return the label
	 */
	public String getLabel(NamedElement pElement) {
		if (pElement == null || pElement.getClass() == null)
			return "";

		int lastIndexofPeriod = pElement.getClass().toString().lastIndexOf(".");
		int indexOfImpl = pElement.getClass().toString().indexOf("Impl");
		String umlClass = pElement.getClass().toString()
				.substring(lastIndexofPeriod + 1, indexOfImpl);
		umlClass += pElement.getQualifiedName() != null ? pElement
				.getQualifiedName() : "";
		return umlClass;
	}

	/**
	 * Gets the label.
	 * 
	 * @param pElement
	 *            the element
	 * @return the label
	 */
	public String getLabel(EObject pElement) {
		int lastIndexofPeriod = pElement.getClass().toString().lastIndexOf(".");
		int indexOfImpl = pElement.getClass().toString().indexOf("Impl");
		String umlClass = pElement.getClass().toString()
				.substring(lastIndexofPeriod + 1, indexOfImpl);
		if (pElement instanceof EClass)
			umlClass += ((EClass) pElement).getName() != null ? ((EClass) pElement)
					.getName() : "";
		else {
			umlClass += ((NamedElement) pElement).getQualifiedName() != null ? ((NamedElement) pElement)
					.getQualifiedName() : "";
		}
		return umlClass;
	}

	/**
	 * Gets the req uml.
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the req uml
	 */
	public Map<Requirement, List<PackageableElement>> getReqUML(IFile inputFile) {
		Map<Requirement, List<PackageableElement>> map = new HashMap<Requirement, List<PackageableElement>>();

		load(inputFile);

		EList<Repository> repositories = getModel()
				.getRequirementRepositories();

		for (Repository repository : repositories) {
			for (Category category : repository.getMainCategories()) {
				navigateAndAdd(map, category);
			}
		}

		return map;
	}

	/**
	 * Gets the req tech.
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the req tech
	 */
	public Map<Requirement, List<String>> getReqTech(IFile inputFile) {
		Map<Requirement, List<String>> map = new HashMap<Requirement, List<String>>();

		load(inputFile);

		for (Reference reference : getModel().getReferences()) {
			List<String> list = map.get(reference.getRequirement());
			if (list == null) {
				list = new ArrayList<String>();
				map.put(reference.getRequirement(), list);
			}

			for (String ontology : reference.getOntologies()) {
				list.add(ontology);
			}
		}

		return map;
	}

	/**
	 * Gets the model tech.
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the model tech
	 */
	public Map<PackageableElement, List<String>> getModelTech(IFile inputFile) {
		Map<PackageableElement, List<String>> map = new HashMap<PackageableElement, List<String>>();

		load(inputFile);

		for (Reference reference : getModel().getReferences()) {
			List<String> list = map.get((PackageableElement) reference
					.getUmlModel());
			if (list == null) {
				list = new ArrayList<String>();
				map.put((PackageableElement) reference.getUmlModel(), list);
			}

			for (String ontology : reference.getOntologies()) {
				list.add(ontology);
			}
		}

		return map;
	}

	/**
	 * Navigate and add.
	 * 
	 * @param map
	 *            the map
	 * @param category
	 *            the category
	 */
	private void navigateAndAdd(Map<Requirement, List<PackageableElement>> map,
			Category category) {
		for (Requirement requirement : category.getRequirements()) {
			List<PackageableElement> list = map.get(requirement);
			if (list == null) {
				list = new ArrayList<PackageableElement>();
				map.put(requirement, list);
			}

			for (EObject obj : category.getReferencedObject()) {
				if (obj instanceof PackageableElement
						&& obj instanceof Classifier) {
					list.add((PackageableElement) obj);
				}
			}
		}

		for (Category subcategory : category.getSubCategories()) {
			navigateAndAdd(map, subcategory);
		}
	}
}
