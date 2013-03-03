/**
 * 
 */
package br.ufms.facom.acctrace.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ui.IEditorInput;
import org.obeonetwork.dsl.requirement.Repository;

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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI,
				ModelPackage.eINSTANCE);
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
	 * @param container
	 *            the container
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws CoreException
	 *             the core exception
	 */
	public void initializeAccTraceModel(String nameFile, IContainer container)
			throws IOException, CoreException {
		AccTraceModel model = ModelFactory.eINSTANCE.createAccTraceModel();

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI(nameFile));

		if (container != null)
			loadRequirementFiles(model, container);

		resource.getContents().add(model);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		resource.save(options);
	}

	/**
	 * Gets the acc trace model.
	 * 
	 * @param file
	 *            the file
	 * @return the acc trace model
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public AccTraceModel getAccTraceModel(IEditorInput file) throws IOException {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(file.getName()),
				true);

		return (AccTraceModel) resource.getContents().get(0);
	}

	/**
	 * Load requirement files.
	 * 
	 * @param model
	 *            the model
	 * @param container
	 *            the container
	 * @throws CoreException
	 *             the core exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void loadRequirementFiles(AccTraceModel model, IContainer container)
			throws CoreException, IOException {
		for (IResource member : container.members()) {
			if (member.getType() == IResource.FILE
					&& ((IFile) member).getFileExtension()
							.equals("requirement"))
				model.getRequirementRepositories().add(
						getRequirementRepository((IFile) member));
		}
	}

	/**
	 * Gets the requirement repository.
	 * 
	 * @param file
	 *            the file
	 * @return the requirement repository
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Repository getRequirementRepository(IFile file) throws IOException {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createPlatformResourceURI(
				file.getFullPath().toString(), true), true);
		return (Repository) resource.getContents().get(0);
	}

	/**
	 * Gets the requirement repository.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the requirement repository
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Repository getRequirementRepository(String filePath)
			throws IOException {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(
				URI.createPlatformResourceURI(filePath, true), true);
		return (Repository) resource.getContents().get(0);
	}
}
