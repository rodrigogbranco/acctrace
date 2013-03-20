package br.ufms.facom.acctrace.owl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * A factory for creating AccessibilityOWL objects.
 */
public final class AccessibilityOWLFactory {

	/** The Constant instance. */
	private static final AccessibilityOWLFactory instance = new AccessibilityOWLFactory();

	/** The bundle. */
	private Bundle bundle = Platform.getBundle("br.ufms.facom.acctrace");

	/** The owl path. */
	private String owlPath = "owlFiles/";

	/** The owl extension. */
	private String owlExtension = ".owl";

	/** The key string. */
	private String keyString = "Generic";

	/** The manager. */
	private OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

	/** The owl map. */
	private TreeMap<String, TreeSet<String>> owlMap = new TreeMap<String, TreeSet<String>>();

	/** The owl hash. */
	private HashMap<String, String> owlHash = new HashMap<String, String>();
	
	private HashMap<String, String> rdfID = new HashMap<String, String>();
	
	private HashMap<String, IRI> iriMap = new HashMap<String, IRI>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private static final String nsBase = "http://www.AccessibleOntology.com/";
	
	public static final String hasName = "<" + nsBase + "GenericOntology.owl#hasName" + ">";
	
	public static final String hasDescription = "<"+ nsBase + "GenericOntology.owl#hasDescription" + ">";
	

	/**
	 * Instantiates a new accessibility owl factory. The constructor also set up
	 * the owl Map (mapping general classes to specific ones) and owl Hash table
	 * (mapping a class to a OWL file).
	 */
	private AccessibilityOWLFactory() {
		// Generic
		TreeSet<String> set = null;

		owlMap.put("Generic", set = new TreeSet<String>());
		set.add("Application");
		rdfID.put("Application", nsBase + "GenericOntology.owl#Application");
		set.add("Approach");
		rdfID.put("Approach", nsBase + "GenericOntology.owl#Approach");
		// set.add("Capability");
		set.add("Checkpoint");
		rdfID.put("Checkpoint", nsBase + "GenericOntology.owl#Checkpoint");
		set.add("Device");
		rdfID.put("Device", nsBase + "GenericOntology.owl#Device");
		set.add("Disability");
		rdfID.put("Disability", nsBase + "GenericOntology.owl#Disability");
		set.add("Functional Limitation");
		rdfID.put("Functional Limitation", nsBase + "GenericOntology.owl#FunctionalLimitation");
		set.add("Guideline");
		rdfID.put("Guideline", nsBase + "GenericOntology.owl#Guideline");
		set.add("Impairment");
		rdfID.put("Impairment", nsBase + "GenericOntology.owl#Impairment");
		set.add("Output Result");
		rdfID.put("Output Result", nsBase + "GenericOntology.owl#Output Result");
		set.add("Standard");
		rdfID.put("Standard", nsBase + "GenericOntology.owl#Standard");
		set.add("Technique");
		rdfID.put("Technique", nsBase + "GenericOntology.owl#Technique");
		set.add("Test");
		rdfID.put("Test", nsBase + "GenericOntology.owl#Test");
		// set.add("User");
		set.add("WAI ARIA");
		rdfID.put("WAI ARIA", nsBase + "GenericOntology.owl#WaiAria");

		// Application
		owlMap.put("Application", set = new TreeSet<String>());
		set.add("HTML");
		rdfID.put("HTML", nsBase+"HTML.owl#HTML");
		set.add("CSS");
		rdfID.put("CSS", nsBase+"CSS.owl#CSS");
		set.add("CORE");
		rdfID.put("CORE", nsBase+"CORE.owl#CORE");

		// Approach
		owlMap.put("Approach", set = new TreeSet<String>());
		set.add("Web Service");
		set.add("WCAG 2.0");
		// set.add("Description Language";)
		set.add("Mobile Web Best Practices");

		// Device
		owlMap.put("Device", set = new TreeSet<String>());
		set.add("Scanning Software");
		rdfID.put("Scanning Software", nsBase+"ScanningSoftware.owl#Scanning_Software");
		set.add("Alternative Keyboards or Switches");
		rdfID.put("Alternative Keyboards or Switches", 
				nsBase+"AlternativeKeyboardsOrSwitches.owl#Alternative_Keyboard_Or_Switches");
		set.add("Braille");
		rdfID.put("Braille", nsBase+"Braille.owl#Braille");
		set.add("Listening Device");
		rdfID.put("Listening Device", nsBase+"ListeningDevices.owl#Listening_Devices");
		set.add("Screen Magnifiers");
		rdfID.put("Screen Magnifiers", nsBase+"ScreenMagnifiers.owl#Screen_Magnifiers");
		set.add("Screen Reader");
		rdfID.put("Screen Reader", nsBase+"ScreenReader.owl#ScreenReader");
		set.add("Speech Devices");
		rdfID.put("Speech Devices", nsBase+"SpeechDevices.owl#Speech_Devices");
		set.add("Text Browsers");
		rdfID.put("Text Browsers", nsBase+"TextBrowsers.owl#Text_Browsers");

		// Guideline
		owlMap.put("Guideline", set = new TreeSet<String>());
		set.add("Web Service");
		set.add("WCAG 2.0");
		// set.add("Description Language";)
		set.add("Mobile Web Best Practices");

		// Output Result
		owlMap.put("Output Result", set = new TreeSet<String>());
		set.add("Mobile Web Best Practices");

		// Technique
		owlMap.put("Technique", set = new TreeSet<String>());
		set.add("Web Service");
		set.add("WCAG 2.0");
		// set.add("Description Language";)
		set.add("Mobile Web Best Practices");

		// Test
		owlMap.put("Test", set = new TreeSet<String>());
		set.add("Web Service");
		set.add("WCAG 2.0");
		// set.add("Description Language";)
		set.add("Mobile Web Best Practices");

		// Filling hash map with file names
		owlHash.put("Generic", "GenericOntology");		
		owlHash.put("HTML", "HTML");		
		owlHash.put("CSS", "CSS");		
		owlHash.put("CORE", "CORE");	
		owlHash.put("Scanning Software", "ScanningSoftware");	
		owlHash.put("Alternative Keyboards or Switches",
				"AlternativeKeyboardsOrSwitches");	
		owlHash.put("Braille", "Braille");
		owlHash.put("Listening Device", "ListeningDevices");	
		owlHash.put("Screen Magnifiers", "ScreenMagnifiers");
		owlHash.put("Screen Reader", "ScreenReader");
		owlHash.put("Speech Devices", "SpeechDevices");	
		owlHash.put("Text Browsers", "TextBrowsers");	
		owlHash.put("Web Service", "WebService1");		
		owlHash.put("WCAG 2.0", "WCAG2");		
		owlHash.put("Mobile Web Best Practices", "MWBP");		
		owlHash.put("WAI/ARIA", "WAIARIA");

	}

	/**
	 * Gets the single instance of AccessibilityOWLFactory.
	 * 
	 * @return single instance of AccessibilityOWLFactory
	 */
	public static synchronized AccessibilityOWLFactory getInstance() {
		return instance;
	}

	/**
	 * Gets the oWL ontology.
	 * 
	 * @return the oWL built ontology
	 * @throws URISyntaxException
	 *             the uRI syntax exception
	 * @throws OWLOntologyCreationException
	 *             the oWL ontology creation exception
	 */
	public Set<OWLOntology> getOWLOntology() throws URISyntaxException,
			OWLOntologyCreationException {
		for(String key : owlHash.keySet()) {
			URL url = FileLocator
					.find(bundle, new Path(owlPath + owlHash.get(key)
							+ owlExtension), null);
			IRI iri = IRI.create(url.toURI());
			OWLOntology o = manager.loadOntology(iri);
			iriMap.put(key, o.getOntologyID().getOntologyIRI());
			
		}
		return manager.getOntologies();
	}
	
	
	public OWLOntology getOWLOntology(String iri) {
		log.debug(iri);
		log.debug(iriMap.get(iri));
		log.debug(rdfID.get(iri));
		if(iriMap.get(iri) != null)
			return manager.getOntology(iriMap.get(iri));
		else
			return manager.getOntology(iriMap.get("Generic"));
	}
	
	public String getIRIofClass(String clazz) {
		return rdfID.get(clazz);
	}
	
	public OWLDataFactory getDataFactory() {
		return manager.getOWLDataFactory();
	}

	/**
	 * Gets the keys.
	 * 
	 * @param key
	 *            the key
	 * @return the keys
	 */
	public TreeSet<String> getKeys(String key) {
		return owlMap.get(key);
	}

	/**
	 * Gets the keys.
	 * 
	 * @return the keys
	 */
	public TreeSet<String> getKeys() {
		return getKeys(keyString);
	}
	
	public Map<String, OWLNamedIndividual> getNames(String choice, OWLOntology ontology) {
		HashMap<String, OWLNamedIndividual> map = new HashMap<>();
		
		log.debug(ontology);
		
		for(OWLNamedIndividual n : ontology.getIndividualsInSignature()) {
			for(OWLAnnotation ann : n.getAnnotations(ontology)) {
				if(ann.getValue() instanceof OWLLiteral
						&& ann.getProperty().toString().equals(hasName)) {
					OWLLiteral lit = ((OWLLiteral)ann.getValue());
					log.debug(ann.getProperty()+" "+AccessibilityOWLFactory.hasName);
					log.debug(lit);
					map.put(lit.getLiteral(), n);
				}
			}
		}
		
		return map;
	}
	
	public String getDescription(OWLNamedIndividual individual, OWLOntology ontology) {
		for(OWLAnnotation ann : individual.getAnnotations(ontology)) {
			if(ann.getValue() instanceof OWLLiteral
					&& ann.getProperty().toString().equals(hasDescription)) {
				OWLLiteral lit = ((OWLLiteral)ann.getValue());
				log.debug(ann.getProperty()+" "+AccessibilityOWLFactory.hasDescription);
				log.debug(lit);
				return lit.getLiteral();
			}
		}
		return "";
	}
}
