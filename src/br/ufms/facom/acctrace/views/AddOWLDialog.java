/**
 * 
 */
package br.ufms.facom.acctrace.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

/**
 * @author Rodrigo Branco
 * 
 */
public class AddOWLDialog extends Dialog {

	private AccessibilityOWLFactory owlFactory;

	private Label firstLevelLabel;
	private Combo firstLevelCombo;

	private Label secondLevelLabel;
	private Combo secondLevelCombo;

	/**
	 * @param parentShell
	 */
	public AddOWLDialog(Shell parentShell) {
		super(parentShell);
		owlFactory = AccessibilityOWLFactory.getInstance();
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		/*
		 * OWLOntology ontology;
		 * 
		 * try { ontology = owlFactory.getOWLOntologyManager();
		 * System.out.println(ontology); } catch (OWLOntologyCreationException
		 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * catch (URISyntaxException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		GridLayout layout = new GridLayout();
		parent.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;

		firstLevelLabel = new Label(parent, SWT.NULL);
		firstLevelLabel.setText("Select the Accessibility Specification");

		firstLevelCombo = new Combo(parent, SWT.READ_ONLY);
		firstLevelCombo.setBounds(50, 50, 150, 65);
		firstLevelCombo.setItems(owlFactory.getKeys().toArray(new String[0]));

		secondLevelLabel = new Label(parent, SWT.NULL);
		secondLevelLabel.setText("Select the Accessibility Specification");

		secondLevelCombo = new Combo(parent, SWT.READ_ONLY);
		secondLevelCombo.setBounds(50, 50, 150, 65);
		secondLevelCombo.setItems(new String[0]);
		secondLevelLabel.setVisible(false);
		secondLevelCombo.setVisible(false);

		firstLevelCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				String selection = ((Combo) e.getSource()).getText();

				if (owlFactory.getKeys(selection) != null
						&& owlFactory.getKeys(selection).size() > 0) {
					secondLevelCombo.setBounds(50, 50, 150, 65);
					secondLevelCombo.setItems(owlFactory.getKeys(selection)
							.toArray(new String[0]));
					secondLevelLabel.setVisible(true);
					secondLevelCombo.setVisible(true);
				} else {
					secondLevelCombo.setItems(new String[0]);
					secondLevelLabel.setVisible(false);
					secondLevelCombo.setVisible(false);
				}
			}
		});

		Text containerText = new Text(parent, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			}
		});

		Button button = new Button(parent, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// handleBrowse();
			}
		});
		Label label = new Label(parent, SWT.NULL);
		label.setText("&File name:");

		Text fileText = new Text(parent, SWT.BORDER | SWT.SINGLE);

		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);

		return parent;
	}

	/**
	 * @param parentShell
	 */
	public AddOWLDialog(IShellProvider parentShell) {
		super(parentShell);
	}

}
