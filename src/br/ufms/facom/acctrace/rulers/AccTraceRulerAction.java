package br.ufms.facom.acctrace.rulers;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

// TODO: Auto-generated Javadoc
/**
 * The Class AccTraceRulerAction.
 */
public class AccTraceRulerAction extends AbstractRulerActionDelegate {

	/**
	 * Instantiates a new acc trace ruler action.
	 */
	public AccTraceRulerAction() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractRulerActionDelegate#createAction(org.eclipse.ui.texteditor.ITextEditor, org.eclipse.jface.text.source.IVerticalRulerInfo)
	 */
	@Override
	protected IAction createAction(ITextEditor editor,
			IVerticalRulerInfo rulerInfo) {
		return new DataRequestSelectAnnotationRulerAction(ResourceBundle.
				getBundle("org.eclipse.jdt.internal.ui.javaeditor.ConstructedJavaEditorMessages"), "JavaSelectAnnotationRulerAction.", editor, rulerInfo);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
