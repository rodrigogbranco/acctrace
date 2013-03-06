/**
 * 
 */
package br.ufms.facom.acctrace.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.obeonetwork.dsl.requirement.Category;
import org.obeonetwork.dsl.requirement.Repository;

import br.ufms.facom.acctrace.model.controller.ModelController;

// TODO: Auto-generated Javadoc
/**
 * The Class ReferenceView.
 * 
 * @author Rodrigo Branco
 */
public class ReferenceView {

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

	/** The parent map. */
	private HashMap<Object, Object> parentMap = new HashMap<Object, Object>();

	/** The form. */
	private AccTraceFormPage form;

	/** The view provider. */
	private ViewContentProvider viewProvider = new ViewContentProvider();

	/** The label provider. */
	private ViewLabelProvider labelProvider = new ViewLabelProvider();

	/** The name sorter. */
	private NameSorter nameSorter = new NameSorter();

	/** The listeners. */
	private ArrayList<IPropertyChangeListener> listeners = null;

	/**
	 * Instantiates a new reference view.
	 * 
	 * @param form
	 *            the form
	 * @param composite
	 *            the composite
	 */
	public ReferenceView(AccTraceFormPage form, Composite composite) {
		if (listeners == null)
			listeners = new ArrayList<IPropertyChangeListener>();

		this.form = form;
		viewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
	}

	/**
	 * Adds the property change listener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		if (!listeners.contains(listener))
			listeners.add(listener);
	}

	/**
	 * Removes the property change listener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Gets the content provider.
	 * 
	 * @return the content provider
	 */
	public ViewContentProvider getContentProvider() {
		return viewProvider;
	}

	/**
	 * Gets the label provider.
	 * 
	 * @return the label provider
	 */
	public ViewLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Gets the tree viewer.
	 * 
	 * @return the tree viewer
	 */
	public TreeViewer getTreeViewer() {
		return viewer;
	}

	/**
	 * Gets the name sorter.
	 * 
	 * @return the name sorter
	 */
	public NameSorter getNameSorter() {
		return nameSorter;
	}

	/**
	 * The Class ViewContentProvider.
	 */
	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
		 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
		 * java.lang.Object)
		 */
		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang
		 * .Object)
		 */
		public Object getParent(Object child) {
			if (child instanceof Category)
				return ((Category) child).getParentCategory();
			else
				return parentMap.get(child);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang
		 * .Object)
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

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang
		 * .Object)
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

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */

		/** The current. */
		private Category current = null;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object obj) {
			if (obj instanceof Category) {
				current = ((Category) obj);
				Category cat = (Category) obj;
				return "Category Name: " + cat.getName() + " ID: "
						+ cat.getId();
			}

			parentMap.put(obj, current);

			return ModelController.getInstance().getLabel((NamedElement) obj);

			// return "Error in generating Label for element "+obj.toString();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object obj) {
			// String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			String imageKey = ISharedImages.IMG_OBJS_WARN_TSK;
			if (obj instanceof Category)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			else if (obj instanceof Classifier)
				imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			else if (obj instanceof PackageableElement)
				imageKey = ISharedImages.IMG_DEF_VIEW;

			// ISharedImages.
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
				ReferenceView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		form.getSite().registerContextMenu(menuMgr, viewer);
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
	 * @param manager
	 *            the manager
	 */
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	/**
	 * Fill context menu.
	 * 
	 * @param manager
	 *            the manager
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
	 * @param manager
	 *            the manager
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
	 * Hook single click action.
	 */
	private void hookSingleClickAction() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				for (Iterator<IPropertyChangeListener> iter = listeners
						.iterator(); iter.hasNext();) {
					IPropertyChangeListener element = iter.next();
					element.propertyChange(new PropertyChangeEvent(this,
							"elementSelected", parentMap.get(obj), obj));
				}
			}
		});
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
	 * @param message
	 *            the message
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

	/**
	 * Do actions.
	 */
	public void doActions() {
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		hookSingleClickAction();
	}
}
