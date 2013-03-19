package br.ufms.facom.acctrace.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

public class ApplicationAndDeviceDialog extends Dialog {

	private String keyChoice = "Application";
	
	Logger logger = Logger.getLogger(this.getClass());
	
	private HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	private Label lblChoice_1;
	
	private Label lblDescription_1;
	
	private Combo combo;
	
	private Combo combo_1;
	
	private AccessibilityOWLFactory owlFactory = AccessibilityOWLFactory.getInstance();
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
		
		array = new ArrayList<>();
		
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
		container.getShell().setText(keyChoice+" selection");
		
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;
		
		Label lblSelect = new Label(container, SWT.NONE);
		lblSelect.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSelect.setText("Select:");
		
		combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo combo = ((Combo)e.getSource());
				
				List<String> names = AccessibilityOWLFactory.getInstance().getNames(combo.getText());
				
				combo_1.setItems(names.toArray(new String[0]));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//DO NOTHING
			}
		});
		
		combo.setItems(map.get(keyChoice).toArray(new String[0]));
		
		Label lblSpecifyAnElement = new Label(container, SWT.NONE);
		lblSpecifyAnElement.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpecifyAnElement.setText("Specify an Element:");
		
		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblChoice = new Label(container, SWT.NONE);
		lblChoice.setText("Choice:");
		
		lblChoice_1 = new Label(container, SWT.NONE);
		lblChoice_1.setText("Choice");
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setText("Description:");
		
		lblDescription_1 = new Label(container, SWT.NONE);
		GridData gd_lblDescription_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblDescription_1.heightHint = 88;
		lblDescription_1.setLayoutData(gd_lblDescription_1);
		lblDescription_1.setText("Description of element");

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
		return new Point(450, 280);
	}

}
