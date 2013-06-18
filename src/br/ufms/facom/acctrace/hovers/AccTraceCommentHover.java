/**
 * 
 */
package br.ufms.facom.acctrace.hovers;

import org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.IEditorPart;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceCommentHover implements IJavaEditorTextHover {

	@Override
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		return null;
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		return null;
	}

	@Override
	public void setEditor(IEditorPart arg0) {
	}


}
