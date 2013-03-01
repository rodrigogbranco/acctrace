package br.ufms.facom.acctrace.properties;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;

// TODO: Auto-generated Javadoc
/**
 * The Class SamplePropertyPage.
 */
public class SamplePropertyPage extends PropertyPage {

	/** The Constant PATH_TITLE. */
	private static final String PATH_TITLE = "Path:";

	/** The Constant OWNER_TITLE. */
	private static final String OWNER_TITLE = "&Owner:";

	/** The Constant OWNER_PROPERTY. */
	private static final String OWNER_PROPERTY = "OWNER";

	/** The Constant DEFAULT_OWNER. */
	private static final String DEFAULT_OWNER = "John Doe";

	/** The Constant TEXT_FIELD_WIDTH. */
	private static final int TEXT_FIELD_WIDTH = 50;

	/** The owner text. */
	private Text ownerText;

	/**
	 * Constructor for SamplePropertyPage.
	 */
	public SamplePropertyPage() {
		super();
	}

	/**
	 * Adds the first section.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void addFirstSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		// Label for path field
		Label pathLabel = new Label(composite, SWT.NONE);
		pathLabel.setText(PATH_TITLE);

		// Path text field
		Text pathValueText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		pathValueText.setText(((IResource) getElement()).getFullPath()
				.toString());
	}

	/**
	 * Adds the separator.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	/**
	 * Adds the second section.
	 * 
	 * @param parent
	 *            the parent
	 */
	private void addSecondSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		// Label for owner field
		Label ownerLabel = new Label(composite, SWT.NONE);
		ownerLabel.setText(OWNER_TITLE);

		// Owner text field
		ownerText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		ownerText.setLayoutData(gd);

		// Populate owner text field
		try {
			String owner = ((IResource) getElement())
					.getPersistentProperty(new QualifiedName("", OWNER_PROPERTY));
			ownerText.setText((owner != null) ? owner : DEFAULT_OWNER);
		} catch (CoreException e) {
			ownerText.setText(DEFAULT_OWNER);
		}
	}

	/**
	 * Creates the contents.
	 * 
	 * @param parent
	 *            the parent
	 * @return the control
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		addFirstSection(composite);
		addSeparator(composite);
		addSecondSection(composite);
		return composite;
	}

	/**
	 * Creates the default composite.
	 * 
	 * @param parent
	 *            the parent
	 * @return the composite
	 */
	private Composite createDefaultComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		return composite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	protected void performDefaults() {
		super.performDefaults();
		// Populate the owner text field with the default value
		ownerText.setText(DEFAULT_OWNER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	public boolean performOk() {
		// store the value in the owner text field
		try {
			((IResource) getElement()).setPersistentProperty(new QualifiedName(
					"", OWNER_PROPERTY), ownerText.getText());
		} catch (CoreException e) {
			return false;
		}
		return true;
	}

}