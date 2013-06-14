/**
 * 
 */
package br.ufms.facom.acctrace.hovers;

import java.util.Iterator;

import org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorPart;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceCommentHover implements IAnnotationHover {

	@Override
	public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
		Iterator it = sourceViewer.getAnnotationModel().getAnnotationIterator();
		while(it.hasNext()) {
			Annotation an = (Annotation)it.next();
			System.out.println(an);
		}
		return null;
	}


}
