package br.ufms.facom.acctrace.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationAndDeviceDialog.
 */
public class ApplicationAndDeviceDialog extends Dialog {

	/** The key choice. */
	private String keyChoice = "Application";

	/** The map. */
	private HashMap<String, ArrayList<String>> map = new HashMap<>();

	/** The lbl description_1. */
	private Label lblDescription_1;

	/** The combo. */
	private Combo combo;

	/** The combo_1. */
	private Combo combo_1;

	/** The owl factory. */
	private AccessibilityOWLFactory owlFactory = AccessibilityOWLFactory
			.getInstance();

	/** The individuals. */
	private Map<String, OWLNamedIndividual> individuals = null;

	/** The ontology. */
	private OWLOntology ontology;

	/** The selected iri. */
	private static IRI selectedIri;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param key
	 *            the key
	 */
	public ApplicationAndDeviceDialog(Shell parentShell, String key) {
		super(parentShell);

		selectedIri = null;

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
	 * 
	 * @param parent
	 *            the parent
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.getShell().setText(keyChoice + " selection");

		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;

		Label lblSelect = new Label(container, SWT.NONE);
		lblSelect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblSelect.setText("Select:");

		combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		combo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = ((Combo) e.getSource()).getText();

				try {
					ontology = owlFactory.getOWLOntology(selected);

					selectedIri = ontology.getOntologyID().getOntologyIRI();

					individuals = owlFactory.getNames(selected, ontology);

					combo_1.setItems(individuals.keySet()
							.toArray(new String[0]));

					lblDescription_1.setText("Nothing selected");
				} catch (OWLOntologyCreationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// DO NOTHING
			}
		});

		selectedIri = IRI.create(owlFactory.getIRIofClass(keyChoice));

		combo.setItems(map.get(keyChoice).toArray(new String[0]));

		Label lblSpecifyAnElement = new Label(container, SWT.NONE);
		lblSpecifyAnElement.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblSpecifyAnElement.setText("Specify an Element:");

		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		combo_1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = ((Combo) e.getSource()).getText();

				OWLNamedIndividual ann = individuals.get(selected);

				selectedIri = ann.getIRI();

				lblDescription_1.setText(owlFactory.getDescription(ann,
						ontology));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// DO NOTHING

			}
		});

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblDescription.setText("Description:");

		lblDescription_1 = new Label(container, SWT.WRAP);
		GridData gd_lblDescription_1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblDescription_1.widthHint = 314;
		gd_lblDescription_1.heightHint = 62;
		lblDescription_1.setLayoutData(gd_lblDescription_1);
		lblDescription_1.setText("Nothing selected.");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 *            the parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 * 
	 * @return the initial size
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 220);
	}

	/**
	 * Gets the selected iri.
	 * 
	 * @return the selected iri
	 */
	public static IRI getSelectedIri() {
		return selectedIri;
	}

}
