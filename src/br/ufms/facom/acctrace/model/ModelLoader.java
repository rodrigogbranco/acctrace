/**
 * 
 */
package br.ufms.facom.acctrace.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelLoader.
 * 
 * @author Rodrigo Branco
 */
public final class ModelLoader {

	/** The Constant instance. */
	private static final ModelLoader instance = new ModelLoader();

	/**
	 * Instantiates a new model loader.
	 */
	private ModelLoader() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the single instance of ModelLoader.
	 * 
	 * @return single instance of ModelLoader
	 */
	public static synchronized ModelLoader getInstance() {
		return instance;
	}

	/**
	 * Initialize acc trace model.
	 * 
	 * @param nameFile
	 *            the name file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void initializeAccTraceModel(String nameFile) throws IOException {
		ModelPackage.eINSTANCE.eClass();

		ModelFactory factory = ModelFactory.eINSTANCE;
		AccTraceModel model = factory.createAccTraceModel();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("acctrace", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI(nameFile));

		resource.getContents().add(model);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		resource.save(options);
	}

}
