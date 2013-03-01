package br.ufms.facom.acctrace.editors;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * @author Rodrigo Branco
 * 
 */
public class AccTraceEditor extends FormEditor {
	/**
	 * 
	 */
	public AccTraceEditor() {
		super();
	}

	@Override
	protected void addPages() {
		try {
			addPage(new AccTraceFormPage(this, "AccTraceFormPage", "AccTrace"));
		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getActiveEditor().doSave(monitor);
	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
