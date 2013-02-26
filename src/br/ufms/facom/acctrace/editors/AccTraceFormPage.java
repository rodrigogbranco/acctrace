/**
 * 
 */
package br.ufms.facom.acctrace.editors;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
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
		IEditorInput input = editor.getEditorInput();
		//input.
		System.out.println(input.toString());
		IDocument idocument = new XMLDocumentProvider().createDocument(input);
		System.out.println(idocument.get(0, idocument.getLength()).toString());
		
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
