package br.ufms.facom.acctrace.rulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;

/**
 * @author Rodrigo Branco
 * 
 */
public class DataRequestSelectAnnotationRulerAction extends
		SelectMarkerRulerAction {

	private ITextEditor fTextEditor;
	private boolean fHasCorrection;
	private Annotation fAnnotation;

	private static ArrayList<IPropertyChangeListener> listeners = null;

	/**
	 * @param bundle
	 * @param prefix
	 * @param editor
	 * @param ruler
	 */
	public DataRequestSelectAnnotationRulerAction(ResourceBundle bundle,
			String prefix, ITextEditor editor, IVerticalRulerInfo ruler) {
		super(bundle, prefix, editor, ruler);
		fTextEditor = editor;
	}

	/**
	 * @param listener
	 */
	public static void addListener(IPropertyChangeListener listener) {
		if (listeners == null)
			listeners = new ArrayList<IPropertyChangeListener>();

		if (!listeners.contains(listener))
			listeners.add(listener);
	}

	/**
	 * @param listener
	 */
	public static void removeListener(IPropertyChangeListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void update() {
		findDataRequestAnnotation();
		setEnabled(true);

		super.update();

		if (fHasCorrection) {
			for (IPropertyChangeListener element : listeners) {
				if (element != null) {
					PropertyChangeEvent pChange = new PropertyChangeEvent(this,
							"acctraceComment", null, fAnnotation.getText());
					element.propertyChange(pChange);
				} else
					removeListener(element);
			}

			fHasCorrection = false;
		}
	}

	private void findDataRequestAnnotation() {
		fAnnotation = null;
		fHasCorrection = false;

		AbstractMarkerAnnotationModel model = this.getAnnotationModel();

		IDocument document = getDocument();
		if (model == null)
			return;

		Iterator iter = model.getAnnotationIterator();

		while (iter.hasNext()) {
			Annotation annotation = (Annotation) iter.next();

			if (!annotation.getText().matches(
					"//!ACCTRACE!(/)?([^/\\\\0#]+(/)?)+#([^\\*\\*/])+"))
				continue;

			if (annotation.isMarkedDeleted())
				continue;

			Position position = model.getPosition(annotation);
			if (!includesRulerLine(position, document))
				continue;

			fAnnotation = annotation;
			fHasCorrection = true;
			return;
		}
	}

}
