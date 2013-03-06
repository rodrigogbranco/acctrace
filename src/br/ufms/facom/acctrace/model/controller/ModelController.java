/**
 * 
 */
package br.ufms.facom.acctrace.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelLoader;

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
	 * Gets the requirement repositories paths.
	 * 
	 * @return the requirement repositories paths
	 */
	public ArrayList<String> getRequirementRepositoriesPaths() {
		ArrayList<String> list = new ArrayList<String>();
		for (EObject object : model.getRequirementRepositories()) {
			Repository repository = (Repository) object;
			list.add(repository.eResource().getURI().toString());
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
		int lastIndexofPeriod = pElement.getClass().toString().lastIndexOf(".");
		int indexOfImpl = pElement.getClass().toString().indexOf("Impl");
		String umlClass = pElement.getClass().toString()
				.substring(lastIndexofPeriod + 1, indexOfImpl);
		umlClass += pElement.getQualifiedName() != null ? pElement
				.getQualifiedName() : "";
		return umlClass;
	}
}
