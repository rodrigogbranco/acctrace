/**
 * 
 */
package br.ufms.facom.acctrace.editors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.internal.registry.osgi.Activator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.ReaderDocumentSource;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.OWLOntologyMerger;

import uk.ac.manchester.cs.owl.owlapi.OWLOntologyManagerImpl;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceFormPage extends FormPage {
	
	/**
	 * @param id
	 * @param title
	 */
	public AccTraceFormPage(String id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param editor
	 * @param id
	 * @param title
	 * @throws CoreException 
	 * @throws BadLocationException 
	 * @throws ParserConfigurationException 
	 */
	public AccTraceFormPage(FormEditor editor, String id, String title) throws CoreException, BadLocationException, ParserConfigurationException {
		super(editor, id, title);
		try {
			/*OWLDataFactory df = OWLManager.getOWLDataFactory();
			URL owlFile = FileLocator.find(Platform.getBundle("br.ufms.facom.acctrace"), new Path("owlFiles/WCAG2.owl"), null);
			IRI genericOWLIRI = IRI.create(owlFile.toURI());
			OWLOntologyManager m = OWLManager.createOWLOntologyManager();
			OWLOntology o = m.loadOntologyFromOntologyDocument(genericOWLIRI);
			for(OWLClass owlClass : o.getClassesInSignature()) {
				System.out.println(owlClass.getIRI().toString());
			}
			*/
				OWLOntologyManager m = OWLManager.createOWLOntologyManager();
				URL waiAriaURL = FileLocator.find(Platform.getBundle("br.ufms.facom.acctrace"), new Path("owlFiles/WAIARIA.owl"), null);
				IRI waiAriaIRI = IRI.create(waiAriaURL.toURI());
				URL screenReaderURL = FileLocator.find(Platform.getBundle("br.ufms.facom.acctrace"), new Path("owlFiles/screenReader.owl"), null);
				IRI screenReaderIRI = IRI.create(screenReaderURL.toURI());				
				OWLOntology o1 = m.loadOntology(waiAriaIRI);
				OWLOntology o2 = m.loadOntology(screenReaderIRI);
				// Create our ontology merger
				OWLOntologyMerger merger = new OWLOntologyMerger(m);
				// Merge all of the loaded ontologies, specifying an IRI for the
				IRI mergedOntologyIRI =
				IRI.create("http://www.semanticweb.com/mymergedont");
				OWLOntology merged = merger.createMergedOntology(m,
				mergedOntologyIRI);
				for(OWLClass owlClass : merged.getClassesInSignature()) {
					System.out.println(owlClass);
				}
				
			//System.out.println(df.getOWLClass(IRI.create(genericOWLIRI + "#Checkpoint")).toString());

		} catch (OWLOntologyCreationException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEditorInput input = editor.getEditorInput();
		//System.out.println(input.toString());
		IDocument idocument = new XMLDocumentProvider().createDocument(input);
		//System.out.println(idocument.get(0, idocument.getLength()).toString());
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(false);
		dbf.newDocumentBuilder();
		
	}

	/**
	* Create contents of the form.
	*
	* @param managedForm
	*/
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Form with wrapped controls");
		ColumnLayout layout = new ColumnLayout();
		layout.topMargin = 0;
		layout.bottomMargin = 5;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.horizontalSpacing = 10;
		layout.verticalSpacing = 10;
		layout.maxNumColumns = 4;
		layout.minNumColumns = 1;
		form.getBody().setLayout(layout);
		form.getBody().setBackground(
				form.getBody().getDisplay().getSystemColor(SWT.COLOR_GREEN));
		createSectionWithLinks(managedForm, "Link Section",
				"An example of a section with links", 2);
		createSectionWithLinks(managedForm, "Link Section",
				"An example of a section with links", 2);
		createMixedSection(managedForm, "Mixed Section",
				"An example of a section with both links and form controls");
		createSectionWithLinks(managedForm, "Link Section",
				"An example of a section with links", 4);
		createSectionWithControls(managedForm, "Control Section",
				"An example of a section with form controls");
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 3);
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 5);
		createMixedSection(managedForm, "Mixed Section",
				"An example of a section with both links and form controls");
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 2);
		createSectionWithControls(managedForm, "Control Section",
				"An example of a section with links");
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 4);
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 2);
		createMixedSection(managedForm, "Mixed Section",
				"An example of a section with both links and form controls");
		createSectionWithLinks(managedForm, "Sample Section",
				"An example of a section with links", 2);
		createSectionWithControls(managedForm, "Control Section",
				"An example of a section with form controls");
	}
	private void createSectionWithLinks(IManagedForm mform, String title,
			String desc, int nlinks) {
		Composite client = createSection(mform, title, desc, 1);
		FormToolkit toolkit = mform.getToolkit();
		for (int i = 1; i <= nlinks; i++)
			toolkit.createHyperlink(client, "Hyperlink text " + i, SWT.WRAP);
	}
	private void createSectionWithControls(IManagedForm mform, String title,
			String desc) {
		Composite client = createSection(mform, title, desc, 1);
		FormToolkit toolkit = mform.getToolkit();
		toolkit.createButton(client, "A radio button 1", SWT.RADIO);
		toolkit.createButton(client, "A radio button 2", SWT.RADIO);
		toolkit.createButton(client, "A radio button with a longer text",
				SWT.RADIO);
		toolkit.createButton(client, "A checkbox button", SWT.CHECK);
	}
	private void createMixedSection(IManagedForm mform, String title, String desc) {
		Composite client = createSection(mform, title, desc, 2);
		FormToolkit toolkit = mform.getToolkit();
		Hyperlink link = toolkit.createHyperlink(client,
				"A longer hyperlink text example", SWT.WRAP);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		link.setLayoutData(gd);
		link = toolkit.createHyperlink(client, "Another hyperlink text",
				SWT.WRAP);
		gd = new GridData();
		gd.horizontalSpan = 2;
		link.setLayoutData(gd);
		toolkit.createLabel(client, "A text label:");
		Text text = toolkit.createText(client, "", SWT.SINGLE);
		text.setText("Sample text");
		text.setEnabled(false);
		gd = new GridData();
		gd.widthHint = 150;
		text.setLayoutData(gd);
		toolkit.paintBordersFor(client);
	}
	private Composite createSection(IManagedForm mform, String title,
			String desc, int numColumns) {
		final ScrolledForm form = mform.getForm();
		FormToolkit toolkit = mform.getToolkit();
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE
				| Section.SHORT_TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		layout.numColumns = numColumns;
		client.setLayout(layout);
		section.setClient(client);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		return client;
	}
}
