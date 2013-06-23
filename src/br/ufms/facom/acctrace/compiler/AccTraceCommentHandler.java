package br.ufms.facom.acctrace.compiler;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.requirement.Requirement;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.controller.ModelController;
import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class AccTraceCommentHandler.
 */
public class AccTraceCommentHandler {

	/** The instance. */
	private static AccTraceCommentHandler instance = null;

	/** The file map. */
	private Map<String, IFile> fileMap = new HashMap<String, IFile>();
	
	/** The model map. */
	private Map<IFile, AccTraceModel> modelMap = new HashMap<IFile, AccTraceModel>();
	
	/** The reference map. */
	private Map<String, Reference> referenceMap = new HashMap<String, Reference>();
	
	/** The requirement map. */
	private Map<Reference, Requirement> requirementMap = new HashMap<Reference, Requirement>();
	
	/** The uml map. */
	private Map<Reference, NamedElement> umlMap = new HashMap<Reference, NamedElement>();

	/**
	 * Instantiates a new acc trace comment handler.
	 */
	private AccTraceCommentHandler() {
	}

	/**
	 * Gets the file.
	 *
	 * @param stringPath the string path
	 * @return the file
	 */
	public IFile getFile(String stringPath) {
		IFile file = null;
		if ((file = fileMap.get(stringPath)) == null) {
			Path path = new Path(stringPath);
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			fileMap.put(stringPath, null);
		}
		return file;
	}

	/**
	 * Gets the model.
	 *
	 * @param file the file
	 * @return the model
	 */
	public AccTraceModel getModel(IFile file) {
		AccTraceModel model = null;
		try {
			ModelController.getInstance().load(file);
			model = ModelController.getInstance().getModel();
			modelMap.put(file, model);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return model;
	}

	/**
	 * Gets the reference.
	 *
	 * @param model the model
	 * @param referenceId the reference id
	 * @return the reference
	 */
	public Reference getReference(AccTraceModel model, String referenceId) {
		Reference ref = null;
		if ((ref = referenceMap.get(referenceId)) == null) {
			for (Reference reference : model.getReferences()) {
				if (reference.getId().equals(referenceId)) {
					ref = reference;
					referenceMap.put(referenceId, ref);
				}
			}
		}

		return ref;
	}

	/**
	 * Gets the requirement.
	 *
	 * @param ref the ref
	 * @return the requirement
	 */
	public Requirement getRequirement(Reference ref) {
		Requirement req = null;
		if ((req = requirementMap.get(ref)) == null) {
			req = ref.getRequirement();
			requirementMap.put(ref, req);
		}
		return req;
	}

	/**
	 * Gets the uml.
	 *
	 * @param ref the ref
	 * @return the uml
	 */
	public NamedElement getUml(Reference ref) {
		NamedElement uml = null;
		if ((uml = umlMap.get(ref)) == null) {
			try {
				uml = (NamedElement) ref.getUmlModel();
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
			umlMap.put(ref, uml);
		}

		return uml;
	}

	/**
	 * Gets the single instance of AccTraceCommentHandler.
	 *
	 * @return single instance of AccTraceCommentHandler
	 */
	public static AccTraceCommentHandler getInstance() {
		if (instance == null)
			instance = new AccTraceCommentHandler();

		return instance;
	}

	/**
	 * Gets the message.
	 *
	 * @param comment the comment
	 * @return the message
	 * @throws OWLOntologyCreationException the oWL ontology creation exception
	 * @throws URISyntaxException the uRI syntax exception
	 */
	public String getMessage(String comment)
			throws OWLOntologyCreationException, URISyntaxException {
		String stringPath = comment.substring(12, comment.indexOf('#'));
		String referenceId = comment.substring(comment.indexOf('#') + 1,
				comment.length());

		return getMessage(stringPath, referenceId);
	}

	/**
	 * Gets the message.
	 *
	 * @param stringPath the string path
	 * @param referenceId the reference id
	 * @return the message
	 * @throws OWLOntologyCreationException the oWL ontology creation exception
	 * @throws URISyntaxException the uRI syntax exception
	 */
	public String getMessage(String stringPath, String referenceId)
			throws OWLOntologyCreationException, URISyntaxException {
		IFile file = getFile(stringPath);
		if (file == null)
			return "Error: I could not open the file " + stringPath;

		AccTraceModel model = getModel(file);
		if (model == null)
			return "Error: I could not load the the model " + stringPath;

		Reference ref = getReference(model, referenceId);
		if (ref == null) {
			return "Error: I could not find the " + referenceId + " in "
					+ stringPath;
		}

		String message = "";

		Requirement req = getRequirement(ref);

		message += "Requirement: " + req.getName() + " ID: " + req.getId()
				+ "\n\r";

		NamedElement uml = getUml(ref);

		message += "UML Model: " + ModelController.getInstance().getLabel(uml)
				+ "\n\n";

		message += "Techniques: \n\n";

		for (String obj : ref.getOntologies()) {
			OWLOntology ontology = AccessibilityOWLFactory.getInstance()
					.getOWLOntologyByIRI(obj.toString());
			OWLNamedIndividual individual = AccessibilityOWLFactory
					.getInstance().getNamedIndividual(obj.toString(), ontology);
			message += AccessibilityOWLFactory.getInstance().getDescription(
					individual, ontology)
					+ "\n";
		}

		return message;
	}
}
