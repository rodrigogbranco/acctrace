package br.ufms.facom.acctrace.rulers;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSelectAnnotationRulerAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

public class AccTraceRulerAction extends AbstractRulerActionDelegate {

	public AccTraceRulerAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IAction createAction(ITextEditor editor,
			IVerticalRulerInfo rulerInfo) {
		return new DataRequestSelectAnnotationRulerAction(ResourceBundle.
				getBundle("org.eclipse.jdt.internal.ui.javaeditor.ConstructedJavaEditorMessages"), "JavaSelectAnnotationRulerAction.", editor, rulerInfo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
