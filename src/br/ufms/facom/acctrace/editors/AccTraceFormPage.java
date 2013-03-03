/**
 * 
 */
package br.ufms.facom.acctrace.editors;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.editors.filter.AccTraceFileFilter;
import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.ModelLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class AccTraceFormPage.
 * 
 * @author Rodrigo Branco
 */
public class AccTraceFormPage extends FormPage {

	/** The input file. */
	private IEditorInput inputFile;

	/** The requirement files list. */
	private List requirementFilesList;

	/** The model. */
	private AccTraceModel model;

	/** The options. */
	private Map<String, Object> options = new HashMap<String, Object>();

	/**
	 * Instantiates a new acc trace form page.
	 * 
	 * @param editor
	 *            the editor
	 * @param id
	 *            the id
	 * @param title
	 *            the title
	 * @throws CoreException
	 *             the core exception
	 * @throws BadLocationException
	 *             the bad location exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public AccTraceFormPage(FormEditor editor, String id, String title)
			throws CoreException, BadLocationException,
			ParserConfigurationException, IOException {
		super(editor, id, title);

		inputFile = editor.getEditorInput();

		ResourceSet resSet = new ResourceSetImpl();

		options.put(XMIResource.OPTION_ENCODING, "UTF-8");

		ModelLoader.getInstance();

		Resource resource = resSet.getResource(
				URI.createURI(((IFileEditorInput) inputFile).getFile()
						.getFullPath().toString()), true);

		model = (AccTraceModel) resource.getContents().get(0);
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 *            the managed form
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		// FormToolkit toolkit = managedForm.getToolkit();
		form.setText("AccTrace Resume");
		ColumnLayout layout = new ColumnLayout();
		layout.topMargin = 0;
		layout.bottomMargin = 5;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 10;
		layout.maxNumColumns = 1;
		layout.minNumColumns = 1;
		form.getBody().setLayout(layout);
		// form.getBody().setBackground(
		// form.getBody().getDisplay().getSystemColor(SWT.COLOR_GREEN));
		createSectionOfRequirementFilesAssociated(managedForm,
				"Requirement Files Association",
				"List of all requirements files associateds in project.");
		createSectionOfModelToTechniqueMapping(managedForm,
				"Requirement to Model to Technique Mapping",
				"Manage all requirement to model to technique mapping");
		/*
		 * createSectionWithLinks(managedForm, "Link Section",
		 * "An example of a section with links", 2);
		 * createSectionWithLinks(managedForm, "Link Section",
		 * "An example of a section with links", 2);
		 * createMixedSection(managedForm, "Mixed Section",
		 * "An example of a section with both links and form controls");
		 * createSectionWithLinks(managedForm, "Link Section",
		 * "An example of a section with links", 4);
		 * createSectionWithControls(managedForm, "Control Section",
		 * "An example of a section with form controls");
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 3);
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 5);
		 * createMixedSection(managedForm, "Mixed Section",
		 * "An example of a section with both links and form controls");
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 2);
		 * createSectionWithControls(managedForm, "Control Section",
		 * "An example of a section with links");
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 4);
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 2);
		 * createMixedSection(managedForm, "Mixed Section",
		 * "An example of a section with both links and form controls");
		 * createSectionWithLinks(managedForm, "Sample Section",
		 * "An example of a section with links", 2);
		 * createSectionWithControls(managedForm, "Control Section",
		 * "An example of a section with form controls");
		 */
	}

	/**
	 * Creates the section of requirement files associated.
	 * 
	 * @param mform
	 *            the mform
	 * @param title
	 *            the title
	 * @param desc
	 *            the desc
	 */
	private void createSectionOfRequirementFilesAssociated(IManagedForm mform,
			String title, String desc) {
		Composite client = createSection(mform, title, desc, 1);

		requirementFilesList = new List(client, SWT.MULTI);

		// Loading requirement List with model data
		for (EObject object : model.getRequirementRepositories()) {
			Repository repository = (Repository) object;
			requirementFilesList
					.add(repository.eResource().getURI().toString());
		}

		Button buttonAdd = new Button(client, SWT.PUSH);
		buttonAdd.setText("Add...");
		buttonAdd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					handleAdd();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Button buttonRemove = new Button(client, SWT.PUSH);
		buttonRemove.setText("Remove");
		buttonRemove.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					handleRemove();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the section of model to technique mapping.
	 * 
	 * @param mform
	 *            the mform
	 * @param title
	 *            the title
	 * @param desc
	 *            the desc
	 */
	private void createSectionOfModelToTechniqueMapping(IManagedForm mform,
			String title, String desc) {
		Composite client = createSection(mform, title, desc, 1);

		// TODO load Model
	}

	/**
	 * Handle remove.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void handleRemove() throws IOException {
		if (requirementFilesList.getSelectionIndex() == -1) {
			// No requirement file selected
			MessageBox dialog = new MessageBox(getSite().getShell(),
					SWT.ICON_ERROR | SWT.OK);
			dialog.setText("Selection Error");
			dialog.setMessage("You must choose which requirement file you want to remove.");
			dialog.open();
		} else {
			// unbinding from model
			String filePath = requirementFilesList.getItem(requirementFilesList
					.getSelectionIndex());
			Repository repository = ModelLoader.getInstance()
					.getRequirementRepository(filePath.substring(18));
			for (Repository rep : model.getRequirementRepositories()) {
				if (rep.eResource().getURI()
						.equals(repository.eResource().getURI())) {
					model.getRequirementRepositories().remove(rep);
					model.eResource().save(options);
					requirementFilesList.remove(requirementFilesList
							.getSelectionIndex());
					break;
				}
			}
		}
	}

	/**
	 * Handle add.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void handleAdd() throws IOException {

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getSite().getShell(), new WorkbenchLabelProvider(),
				new BaseWorkbenchContentProvider());
		dialog.setInput(((IFileEditorInput) inputFile).getFile().getProject());
		dialog.addFilter(new AccTraceFileFilter());
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				Repository repository = ModelLoader.getInstance()
						.getRequirementRepository((IFile) result[0]);
				if (requirementFilesList.indexOf(repository.eResource()
						.getURI().toString()) == -1) {
					model.getRequirementRepositories().add(repository);
					model.eResource().save(options);
					requirementFilesList.add(repository.eResource().getURI()
							.toString());
				} else {
					MessageBox mBox = new MessageBox(getSite().getShell(),
							SWT.ICON_ERROR | SWT.OK);
					mBox.setText("Inclusion Error");
					mBox.setMessage("This resource is already added to list.");
					mBox.open();
				}
			}
		}
	}

	/*
	 * private void createSectionWithLinks(IManagedForm mform, String title,
	 * String desc, int nlinks) { Composite client = createSection(mform, title,
	 * desc, 1); FormToolkit toolkit = mform.getToolkit(); for (int i = 1; i <=
	 * nlinks; i++) toolkit.createHyperlink(client, "Hyperlink text " + i,
	 * SWT.WRAP); }
	 * 
	 * private void createSectionWithControls(IManagedForm mform, String title,
	 * String desc) { Composite client = createSection(mform, title, desc, 1);
	 * FormToolkit toolkit = mform.getToolkit(); toolkit.createButton(client,
	 * "A radio button 1", SWT.RADIO); toolkit.createButton(client,
	 * "A radio button 2", SWT.RADIO); toolkit.createButton(client,
	 * "A radio button with a longer text", SWT.RADIO);
	 * toolkit.createButton(client, "A checkbox button", SWT.CHECK); }
	 * 
	 * private void createMixedSection(IManagedForm mform, String title, String
	 * desc) { Composite client = createSection(mform, title, desc, 2);
	 * FormToolkit toolkit = mform.getToolkit(); Hyperlink link =
	 * toolkit.createHyperlink(client, "A longer hyperlink text example",
	 * SWT.WRAP); GridData gd = new GridData(); gd.horizontalSpan = 2;
	 * link.setLayoutData(gd); link = toolkit.createHyperlink(client,
	 * "Another hyperlink text", SWT.WRAP); gd = new GridData();
	 * gd.horizontalSpan = 2; link.setLayoutData(gd);
	 * toolkit.createLabel(client, "A text label:"); Text text =
	 * toolkit.createText(client, "", SWT.SINGLE); text.setText("Sample text");
	 * text.setEnabled(false); gd = new GridData(); gd.widthHint = 150;
	 * text.setLayoutData(gd); toolkit.paintBordersFor(client); }
	 */

	/**
	 * Creates the section.
	 * 
	 * @param mform
	 *            the mform
	 * @param title
	 *            the title
	 * @param desc
	 *            the desc
	 * @param numColumns
	 *            the num columns
	 * @return the composite
	 */
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE
				| Section.SHORT_TITLE_BAR | Section.DESCRIPTION
		/* | Section.EXPANDED */);
		section.setText(title);
		section.setDescription(desc);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		section.setClient(client);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		return client;
	}
}
