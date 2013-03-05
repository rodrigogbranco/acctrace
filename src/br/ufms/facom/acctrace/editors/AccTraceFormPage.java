/**
 * 
 */
package br.ufms.facom.acctrace.editors;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
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
import org.eclipse.ui.part.DrillDownAdapter;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.editors.filter.AccTraceFileFilter;
import br.ufms.facom.acctrace.model.controller.ModelController;

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

	/** The viewer. */
	private TreeViewer viewer;
	
	/** The drill down adapter. */
	private DrillDownAdapter drillDownAdapter;
	
	/** The action1. */
	private Action action1;
	
	/** The action2. */
	private Action action2;
	
	/** The double click action. */
	private Action doubleClickAction;

	/** The controller. */
	private ModelController controller;

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

		controller = ModelController.getInstance();
		controller.load(inputFile);
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
		for (String path : controller.getRequirementRepositoriesPaths())
			requirementFilesList.add(path);

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

		// TODO load model and create Tree View

		viewer = new TreeViewer(client, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(controller.getModel().getRequirementRepositories()
				.get(0));
		viewer.expandAll();

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(viewer.getControl(), "br.ufms.facom.acctrace.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
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

			controller.removeFromModel(filePath);

			requirementFilesList.remove(requirementFilesList
					.getSelectionIndex());
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
				Repository repository = controller
						.getRequirementRepository((IFile) result[0]);
				String repositoryPath = repository.eResource().getURI()
						.toString();

				if (requirementFilesList.indexOf(repositoryPath) == -1) {
					controller.addRepository(repository);
					requirementFilesList.add(repositoryPath);
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
				| Section.EXPANDED);
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

	/**
	 * The Class TreeObject.
	 */
	class TreeObject implements IAdaptable {
		
		/** The object. */
		private EObject object;
		
		/** The parent. */
		private TreeParent parent;

		/**
		 * Instantiates a new tree object.
		 *
		 * @param object the object
		 */
		public TreeObject(EObject object) {
			this.object = object;
		}

		/**
		 * Gets the object.
		 *
		 * @return the object
		 */
		public EObject getObject() {
			return object;
		}

		/**
		 * Sets the parent.
		 *
		 * @param parent the new parent
		 */
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}

		/**
		 * Gets the parent.
		 *
		 * @return the parent
		 */
		public TreeParent getParent() {
			return parent;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return object.toString();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class key) {
			return object.getClass();
		}
	}

	/**
	 * The Class TreeParent.
	 */
	class TreeParent extends TreeObject {
		
		/** The children. */
		private ArrayList<TreeObject> children;

		/**
		 * Instantiates a new tree parent.
		 *
		 * @param object the object
		 */
		public TreeParent(EObject object) {
			super(object);
			children = new ArrayList<TreeObject>();
		}

		/**
		 * Adds the child.
		 *
		 * @param child the child
		 */
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}

		/**
		 * Removes the child.
		 *
		 * @param child the child
		 */
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}

		/**
		 * Gets the children.
		 *
		 * @return the children
		 */
		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children
					.size()]);
		}

		/**
		 * Checks for children.
		 *
		 * @return true, if successful
		 */
		public boolean hasChildren() {
			return children.size() > 0;
		}
	}

	/**
	 * The Class ViewContentProvider.
	 */
	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider {
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parent) {
			if (parent instanceof Repository) {
				Repository rep = (Repository) parent;
				Object[] elements = new Object[rep.getReferencedObject().size()
						+ rep.getMainCategories().size()];
				for (int i = 0; i < rep.getReferencedObject().size(); i++)
					elements[i] = rep.getReferencedObject().get(i);
				for (int i = 0; i < rep.getMainCategories().size(); i++)
					elements[i + rep.getReferencedObject().size()] = rep
							.getMainCategories().get(i);
				return elements;
			}
			if (parent instanceof Category) {
				Category cat = (Category) parent;
				Object[] elements = new Object[cat.getReferencedObject().size()
						+ cat.getSubCategories().size()];
				for (int i = 0; i < cat.getReferencedObject().size(); i++)
					elements[i] = cat.getReferencedObject().get(i);
				for (int i = 0; i < cat.getSubCategories().size(); i++)
					elements[i + cat.getReferencedObject().size()] = cat
							.getSubCategories().get(i);
				return elements;
			}

			return null;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object parent) {
			if (parent instanceof Repository) {
				Repository rep = (Repository) parent;
				if (rep.getReferencedObject().size()
						+ rep.getMainCategories().size() > 0)
					return true;
			}
			if (parent instanceof Category) {
				Category cat = (Category) parent;
				if (cat.getReferencedObject().size()
						+ cat.getSubCategories().size() > 0)
					return true;
			}

			return false;
		}

		/*
		 * private void initialize() { TreeObject to1 = new
		 * TreeObject("Leaf 1"); TreeObject to2 = new TreeObject("Leaf 2");
		 * TreeObject to3 = new TreeObject("Leaf 3"); TreeParent p1 = new
		 * TreeParent("Parent 1"); p1.addChild(to1); p1.addChild(to2);
		 * p1.addChild(to3);
		 * 
		 * TreeObject to4 = new TreeObject("Leaf 4"); TreeParent p2 = new
		 * TreeParent("Parent 2"); p2.addChild(to4);
		 * 
		 * TreeParent root = new TreeParent("Root"); root.addChild(p1);
		 * root.addChild(p2);
		 * 
		 * invisibleRoot = new TreeParent(""); invisibleRoot.addChild(root); }
		 */
	}

	/**
	 * The Class ViewLabelProvider.
	 */
	class ViewLabelProvider extends LabelProvider {

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object obj) {
			if (obj instanceof Category) {
				Category cat = (Category) obj;
				return "Category Name: " + cat.getName() + " ID: "
						+ cat.getId();
			}

			// Model umlModel = controller.loadUMLModel((EObject)obj);
			// EObject x = EcoreUtil.resolve(eObj, umlModel);
			// System.out.println("uri "+eObj.toString()+" x "+umlModel.toString());
			// return umlModel.get+ +umlModel.getLabel();
			// System.out.println(umlModel.get);
			return "x";
		}

		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(imageKey);
		}
	}

	/**
	 * The Class NameSorter.
	 */
	class NameSorter extends ViewerSorter {
	}

	/**
	 * Hook context menu.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				AccTraceFormPage.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Contribute to action bars.
	 */
	private void contributeToActionBars() {
		// IActionBars bars = getSite().getActionBars();
		// fillLocalPullDown(bars.getMenuManager());
		// fillLocalToolBar(bars.getToolBarManager());
	}

	/**
	 * Fill local pull down.
	 *
	 * @param manager the manager
	 */
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	/**
	 * Fill context menu.
	 *
	 * @param manager the manager
	 */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/**
	 * Fill local tool bar.
	 *
	 * @param manager the manager
	 */
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	/**
	 * Make actions.
	 */
	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	/**
	 * Hook double click action.
	 */
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * Show message.
	 *
	 * @param message the message
	 */
	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Sample View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
