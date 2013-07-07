package br.ufms.facom.acctrace.dialog;

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
import org.eclipse.swt.widgets.Text;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class WCAGDialog.
 */
public class WCAGDialog extends Dialog {

	/** The combo. */
	private Combo combo;

	/** The combo_1. */
	private Combo combo_1;

	/** The owl factory. */
	private AccessibilityOWLFactory owlFactory = AccessibilityOWLFactory
			.getInstance();

	/** The individuals. */
	private Map<String, OWLIndividual> individuals = new HashMap<>();

	/** The classes. */
	private Map<String, OWLClass> classes = new HashMap<>();

	/** The ontology. */
	private OWLOntology ontology;

	/** The selected iri. */
	private static IRI selectedIri;

	/** The text. */
	private Text text;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @throws OWLOntologyCreationException
	 *             the oWL ontology creation exception
	 */
	public WCAGDialog(Shell parentShell) throws OWLOntologyCreationException {
		super(parentShell);

		ontology = owlFactory.getOWLOntology("WCAG2");
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
		// container.getShell().setText(keyChoice+" selection");

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

				OWLClass clazz = classes.get(selected);

				individuals.clear();

				for (OWLIndividual ind : clazz.getIndividuals(ontology)) {
					individuals.put(AccessibilityOWLFactory.getInstance()
							.getValue(ind, "hasName", ontology), ind);
				}

				text.setText("");
				combo_1.setItems(individuals.keySet().toArray(new String[0]));
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// DO NOTHING
			}
		});

		// selectedIri = IRI.create(owlFactory.getIRIofClass(keyChoice));

		for (OWLClass clazz : ontology.getClassesInSignature()) {
			if (clazz.getSubClasses(ontology).size() == 0) {
				String label = clazz
						.getSignature()
						.toString()
						.substring(
								clazz.getSignature().toString().indexOf('#') + 1,
								clazz.getSignature().toString().length() - 2);
				classes.put(label, clazz);
			}
		}

		combo.setItems(classes.keySet().toArray(new String[0]));

		Label lblSpecifyAnElement = new Label(container, SWT.NONE);
		lblSpecifyAnElement.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblSpecifyAnElement.setText("Specify an Element:");

		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		text = new Text(container, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text.heightHint = 203;
		text.setLayoutData(gd_text);

		combo_1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = ((Combo) e.getSource()).getText();

				OWLIndividual individual = individuals.get(selected);

				selectedIri = IRI.create(individual.toStringID());

				String values = owlFactory.getValues(individual, ontology);

				text.setText(values);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// DO NOTHING

			}
		});

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
		return new Point(542, 367);
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
