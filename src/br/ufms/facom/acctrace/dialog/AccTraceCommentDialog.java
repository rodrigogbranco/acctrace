/**
 * 
 */
package br.ufms.facom.acctrace.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceCommentDialog extends Dialog {
	private Text text;
	private String message;

	/**
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public AccTraceCommentDialog(Shell parentShell, String message) {
		super(parentShell);
		this.message = message;
	}

	/**
	 * @param parentShell
	 */
	public AccTraceCommentDialog(IShellProvider parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		text = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.heightHint = 201;
		text.setLayoutData(gd_text);
		
		text.setText(message);
		
		return container;
	}

}
