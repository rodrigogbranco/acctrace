package br.ufms.facom.acctrace.dialog;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class ApplicationAndDeviceDialog extends Dialog {

	private String keyChoice;
	
	private HashMap<String, ArrayList<String>> map = new HashMap<>();
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ApplicationAndDeviceDialog(Shell parentShell, String key) {
		super(parentShell);
		keyChoice = key;
		
		ArrayList<String> array = new ArrayList<>();
		array.add("CORE");
		array.add("HTML");
		array.add("CSS");
		
		map.put("Application", array);
		
		array.clear();
		
		array.add("Scanning Software");
		array.add("Alternative Keyboards or Switches");
		array.add("Braille");
		array.add("Listening Device");
		array.add("Screen Magnifiers");
		array.add("Screen Reader");
		array.add("Speech Devices");
		array.add("Text Browsers");			
		
		map.put("Device", array);		
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;
		
		Label lblSelect = new Label(container, SWT.NONE);
		lblSelect.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSelect.setText("Select:");
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 183);
	}

}
