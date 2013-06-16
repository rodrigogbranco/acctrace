package br.ufms.facom.acctrace.compiler;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.requirement.Requirement;

import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.controller.ModelController;

public class AccTraceCommentHandler {
	
	private static AccTraceCommentHandler instance = null;
	
	private Map<String,IFile> fileMap = new HashMap<String,IFile>();
	private Map<IFile,AccTraceModel> modelMap = new HashMap<IFile,AccTraceModel>();
	private Map<String,Reference> referenceMap = new HashMap<String,Reference>();
	private Map<Reference,Requirement> requirementMap = new HashMap<Reference,Requirement>();
	private Map<Reference,NamedElement> umlMap = new HashMap<Reference,NamedElement>();

	private AccTraceCommentHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public IFile getFile(String stringPath) {
		IFile file = null;
		if((file = fileMap.get(stringPath)) == null) {
			Path path = new Path(stringPath);
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			fileMap.put(stringPath, null);
		}
		return file;
	}
	
	public AccTraceModel getModel(IFile file) {	
		AccTraceModel model = null;
		try {
			ModelController.getInstance().load(file);
			model = ModelController.getInstance().getModel();
			modelMap.put(file, model);
		} catch (Exception  e) {
			e.printStackTrace();
			return null;
		}        		
    	return model;
	}
	
	public Reference getReference(AccTraceModel model, String referenceId) {
    	Reference ref= null;
    	if((ref = referenceMap.get(referenceId)) == null) {
	        for(Reference reference : model.getReferences()) {
	        	if(reference.getId().equals(referenceId)) {
	        		ref = reference;
	        		referenceMap.put(referenceId, ref);
	        	}
	        }
    	}
    	
    	return ref;
	}
	
	public Requirement getRequirement(Reference ref) {
		Requirement req = null;
		if((req = requirementMap.get(ref)) == null) {
			req = ref.getRequirement();
			requirementMap.put(ref, req);
		}
		return req;
	}
	
	public NamedElement getUml(Reference ref) {
		NamedElement uml = null;
		if((uml = umlMap.get(ref)) == null) {
			uml = (NamedElement)ref.getUmlModel();
			umlMap.put(ref, uml);
		}
		
		return uml;
	}
	
	public static AccTraceCommentHandler getInstance() {
		if(instance == null)
			instance = new AccTraceCommentHandler();
		
		return instance;
	}
	
	public String getMessage(String stringPath, String referenceId) {		
		IFile file = getFile(stringPath);
		if(file == null)
			return "Error: I could not open the file "+stringPath;
		
		
    	AccTraceModel model = getModel(file);
    	if(model == null)
	        return "Error: I could not load the the model "+stringPath; 
    			        	
    	Reference ref = getReference(model, referenceId);
    	if(ref == null) {
        	return "Error: I could not find the "+ referenceId +" in "+stringPath;	        		
    	}
    	
    	String message = "";
    	
    	Requirement req = getRequirement(ref);
    	
		message += "Requirement: " + req.getName() 
				+ " ID: " + req.getId()+"\n";
		
		/*NamedElement uml = getUml(ref);
		
		message += "UML Model: " + ModelController.getInstance().
				getLabel(uml)+"\n";*/
    	
    	return message;
	}
}
