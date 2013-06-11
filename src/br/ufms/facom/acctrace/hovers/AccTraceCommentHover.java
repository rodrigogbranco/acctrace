/**
 * 
 */
package br.ufms.facom.acctrace.hovers;

import org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorPart;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceCommentHover implements IJavaEditorTextHover {

	/**
	 * 
	 */
	public AccTraceCommentHover() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.ITextHover#getHoverInfo(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion)
	 */
	@Override
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		if (hoverRegion != null) {
			try {
				if (hoverRegion.getLength() > -1) {
					String textHover = textViewer.getDocument().get(hoverRegion.getOffset()-4, hoverRegion.getLength()+5);
					
					if(textHover.equals("/**!ACCTRACE!")) {
						int i = 6;
						
						while((textHover = textViewer.getDocument().
								get(hoverRegion.getOffset()-4, hoverRegion.getLength()+ i++)) != null) {
							System.out.println(textHover);
							if(textHover.matches("/\\*\\*!ACCTRACE!(/)?([^/\\\\0#]+(/)?)+#([^\\*\\*/])+\\*\\*/"))
								return textHover;
							else if(textHover.matches(" "))
								return null;
						}
					}
				}
					//return textViewer.getDocument().get(hoverRegion.getOffset(), hoverRegion.getLength());					
			} catch (BadLocationException x) {
			}
		}
		return null; 
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.ITextHover#getHoverRegion(org.eclipse.jface.text.ITextViewer, int)
	 */
	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		Point selection= textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y)
			return new Region(selection.x, selection.y);
		return new Region(offset, 0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.ui.text.java.hover.IJavaEditorTextHover#setEditor(org.eclipse.ui.IEditorPart)
	 */
	@Override
	public void setEditor(IEditorPart arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
