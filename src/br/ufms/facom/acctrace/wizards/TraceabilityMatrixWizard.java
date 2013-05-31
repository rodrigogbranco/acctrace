package br.ufms.facom.acctrace.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import br.ufms.facom.acctrace.model.controller.ModelController;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "ods". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class TraceabilityMatrixWizard extends Wizard implements INewWizard {
	private TraceabilityMatrixWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for TraceabilityMatrixWizard.
	 */
	public TraceabilityMatrixWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new TraceabilityMatrixWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(fileName, monitor);
				} catch ( Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 * @throws Exception 
	 */

	private void doFinish(
		String fileName,
		IProgressMonitor monitor) {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		final IFile file =  page.getAccTraceFile().getProject().getFile(new Path(fileName));
		try {
			createSpreadsheetDocument(file,page.getAccTraceFile());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		monitor.worked(1);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 * @throws Exception 
	 */

	private void createSpreadsheetDocument(IFile file, IFile acctraceFile) throws Exception {			
			SpreadsheetDocument doc = SpreadsheetDocument.newSpreadsheetDocument();
			
			ModelController controller = ModelController.getInstance();
			controller.load(acctraceFile);
			
			doc.save(file.getRawLocation().makeAbsolute().toFile());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "br.ufms.facom.acctrace", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}