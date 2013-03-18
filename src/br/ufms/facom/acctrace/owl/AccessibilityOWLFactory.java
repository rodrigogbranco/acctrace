package br.ufms.facom.acctrace.owl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
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
		set.add("Approach");
		// set.add("Capability");
		set.add("Checkpoint");
		set.add("Device");
		set.add("Disability");
		set.add("Functional Limitation");
		set.add("Guideline");
		set.add("Impairment");
		set.add("Output Result");
		set.add("Standard");
		set.add("Technique");
		set.add("Test");
		// set.add("User");
		set.add("WAI ARIA");

		// Application
		owlMap.put("Application", set = new TreeSet<String>());
		set.add("HTML");
		set.add("CSS");
		set.add("CORE");

		// Approach
		owlMap.put("Approach", set = new TreeSet<String>());
		set.add("Web Service");
		set.add("WCAG 2.0");
		// set.add("Description Language";)
		set.add("Mobile Web Best Practices");

		// Device
		owlMap.put("Device", set = new TreeSet<String>());
		set.add("Scanning Software");
		set.add("Alternative Keyboards or Switches");
		set.add("Braille");
		set.add("Listening Device");
		set.add("Screen Magnifiers");
		set.add("Screen Reader");
		set.add("Speech Devices");
		set.add("Text Browsers");

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
			manager.loadOntology(iri);			
		}
		return manager.getOntologies();
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
}
