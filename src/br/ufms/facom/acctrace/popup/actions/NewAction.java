package br.ufms.facom.acctrace.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

// TODO: Auto-generated Javadoc
/**
 * The Class NewAction.
 */
public class NewAction implements IObjectActionDelegate {

	/** The shell. */
	private Shell shell;

	/**
	 * Constructor for Action1.
	 */
	public NewAction() {
		super();
	}

	/**
	 * Sets the active part.
	 * 
	 * @param action
	 *            the action
	 * @param targetPart
	 *            the target part
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * Run.
	 * 
	 * @param action
	 *            the action
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		MessageDialog.openInformation(shell, "AccTrace",
				"New Action was executed.");
	}

	/**
	 * Selection changed.
	 * 
	 * @param action
	 *            the action
	 * @param selection
	 *            the selection
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
