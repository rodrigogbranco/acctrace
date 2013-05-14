package br.ufms.facom.acctrace;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.util.OWLOntologyWalker;
import org.semanticweb.owlapi.util.OWLOntologyWalkerVisitor;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

// TODO: Auto-generated Javadoc
/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "br.ufms.facom.acctrace"; //$NON-NLS-1$

	// The shared instance
	/** The plugin. */
	private static Activator plugin;
	
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * The constructor.
	 * @throws IOException 
	 * 
	 * @throws URISyntaxException
	 * @throws OWLOntologyCreationException
	 */
	public Activator() throws IOException, OWLOntologyCreationException, URISyntaxException {
		 URL confURL = getBundle().getEntry("log4j.properties");
	     PropertyConfigurator.configure( FileLocator.toFileURL(confURL).getFile());	
			
			AccessibilityOWLFactory owlFactory = AccessibilityOWLFactory.getInstance();
			
			//Set<OWLOntology> ontologies = owlFactory.getOWLOntology();
			
			try {
				Set<OWLOntology> ontologies = owlFactory.getOWLOntology();
				int i = 0;
				
				for(OWLOntology ontology : ontologies.toArray(new OWLOntology[0])) {
					for (OWLClass cls : ontology.getClassesInSignature()) {
						if(cls.getIndividuals(ontology).size() > 0) {
							logger.info("Class with friends: "+cls);
							for(OWLIndividual owlIn : cls.getIndividuals(ontology)) {
								Map<OWLDataPropertyExpression, Set<OWLLiteral>> map = owlIn.getDataPropertyValues(ontology);
								for(OWLDataPropertyExpression exp : map.keySet()) {
									for(OWLLiteral lit : map.get(exp)) {
										logger.info("IRI "+owlIn.toStringID()+" Literal "+exp+" "+lit.getLiteral());									
									}
									logger.info("");
								}
								logger.info("");
							}
							
						}
						else
							logger.info("Class: "+cls);
					}
					logger.info("classersssss :"+i++);
				}
							
			} catch (OWLOntologyCreationException e) {
				logger.error("Erro na criacao", e);
			} catch (URISyntaxException e) {
				logger.error("Erro na URI", e);
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
