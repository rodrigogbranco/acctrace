package br.ufms.facom.acctrace.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;

public class ApplicationAndDeviceDialog extends Dialog {

	private String keyChoice = "Application";
	
	Logger logger = Logger.getLogger(this.getClass());
	
	private HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	private Label lblDescription_1;
	
	private Combo combo;
	
	private Combo combo_1;
	
	private AccessibilityOWLFactory owlFactory = AccessibilityOWLFactory.getInstance();
	
	private Map<String, OWLNamedIndividual> individuals = null;
	
	private OWLOntology ontology;
	
	private IRI selectedIri;
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
		lblSelect.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSelect.setText("Select:");
		
		combo = new Combo(container, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = ((Combo)e.getSource()).getText();
				
				ontology = owlFactory.getOWLOntology(selected);
				
				selectedIri = ontology.getOntologyID().getOntologyIRI();
				
				logger.debug(selectedIri);
	
				individuals = owlFactory.getNames(selected, ontology);
				
				combo_1.setItems(individuals.keySet().toArray(new String[0]));
				
				lblDescription_1.setText("Nothing selected");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//DO NOTHING
			}
		});
		
		selectedIri = IRI.create(owlFactory.getIRIofClass(keyChoice));
		logger.debug(selectedIri);
		
		combo.setItems(map.get(keyChoice).toArray(new String[0]));
		
		Label lblSpecifyAnElement = new Label(container, SWT.NONE);
		lblSpecifyAnElement.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblSpecifyAnElement.setText("Specify an Element:");
		
		combo_1 = new Combo(container, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo_1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected = ((Combo)e.getSource()).getText();
				
				OWLNamedIndividual ann = individuals.get(selected);
				
				selectedIri = ann.getIRI();
				
				logger.debug(selectedIri);
				
				lblDescription_1.setText(owlFactory.getDescription(ann, ontology));			
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//DO NOTHING
				
			}
		});
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDescription.setText("Description:");
		
		lblDescription_1 = new Label(container, SWT.WRAP);
		GridData gd_lblDescription_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblDescription_1.widthHint = 314;
		gd_lblDescription_1.heightHint = 62;
		lblDescription_1.setLayoutData(gd_lblDescription_1);
		lblDescription_1.setText("Nothing selected.");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
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
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 220);
	}

}
