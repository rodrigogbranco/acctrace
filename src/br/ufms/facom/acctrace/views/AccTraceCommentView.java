package br.ufms.facom.acctrace.views;

import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import br.ufms.facom.acctrace.compiler.AccTraceCommentHandler;
import br.ufms.facom.acctrace.rulers.DataRequestSelectAnnotationRulerAction;

public class AccTraceCommentView extends ViewPart implements
		IPropertyChangeListener {
	private Text text;

	private String message = "";

	private int i = 0;

	public static final String ID = "br.ufms.facom.acctrace.views.AccTraceCommentView";

	/**
	 * 
	 */
	public AccTraceCommentView() {
		DataRequestSelectAnnotationRulerAction.addListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

		if (event.getNewValue() != null) {
			message = (String) event.getNewValue();

			Job job = new Job("AccTrace Comment Handler") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("loading AccTrace comment...", 10);

					try {
						message = AccTraceCommentHandler.getInstance()
								.getMessage(message);

						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								text.setText(message);
							}
						});
					} catch (OWLOntologyCreationException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					monitor.done();

					return Status.OK_STATUS;
				}
			};

			job.setUser(false);
			job.setPriority(Job.LONG);
			text.setText("Loading informations...");
			job.schedule();
		}

	}

	@Override
	public void createPartControl(Composite parent) {

		text = new Text(parent, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP
				| SWT.V_SCROLL);
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
