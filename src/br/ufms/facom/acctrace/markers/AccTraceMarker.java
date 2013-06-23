/**
 * 
 */
package br.ufms.facom.acctrace.markers;

import javax.print.attribute.standard.Severity;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

// TODO: Auto-generated Javadoc
/**
 * The Class AccTraceMarker.
 *
 * @author Rodrigo Branco
 */
public class AccTraceMarker extends CategorizedProblem {

	/** The severity. */
	Severity severity = Severity.REPORT;
	
	/** The message. */
	String message = null;
	
	/** The start offset. */
	int startOffset = 0;
	
	/** The end offset. */
	int endOffset = 0;
	
	/** The line. */
	int line = 0;
	
	/** The file. */
	char[] file = null;
	
	/** The args. */
	String[] args = null;
	
	/** The Constant ID. */
	public final static int ID = 5500;
	
	/** The Constant MARKER_TYPE. */
	public final static String MARKER_TYPE = "br.ufms.facom.acctrace.markers.AccTraceMarker";
	
	
	/**
	 * Instantiates a new acc trace marker.
	 *
	 * @param msg the msg
	 * @param file the file
	 * @param startingOffset the starting offset
	 * @param endingOffset the ending offset
	 * @param line the line
	 * @param args the args
	 */
	public AccTraceMarker(String msg, 
			char[] file,                
			int startingOffset, 
			int endingOffset,         
			int line,
			String[] args) {
		message = msg;
		this.file = file;
		startOffset = startingOffset;
		endOffset = endingOffset;
		this.line = line;
		this.args = args;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getID()
	 */
	@Override
	public int getID() {
		return ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getOriginatingFileName()
	 */
	@Override
	public char[] getOriginatingFileName() {
		return file;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getSourceEnd()
	 */
	@Override
	public int getSourceEnd() {
		// TODO Auto-generated method stub
		return endOffset;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getSourceLineNumber()
	 */
	@Override
	public int getSourceLineNumber() {
		// TODO Auto-generated method stub
		return line;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getSourceStart()
	 */
	@Override
	public int getSourceStart() {
		// TODO Auto-generated method stub
		return startOffset;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#isError()
	 */
	@Override
	public boolean isError() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#isWarning()
	 */
	@Override
	public boolean isWarning() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#setSourceEnd(int)
	 */
	@Override
	public void setSourceEnd(int arg0) {
		// TODO Auto-generated method stub
		endOffset = arg0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#setSourceLineNumber(int)
	 */
	@Override
	public void setSourceLineNumber(int arg0) {
		// TODO Auto-generated method stub
		line = arg0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#setSourceStart(int)
	 */
	@Override
	public void setSourceStart(int arg0) {
		// TODO Auto-generated method stub
		startOffset = arg0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.CategorizedProblem#getCategoryID()
	 */
	@Override
	public int getCategoryID() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.CategorizedProblem#getMarkerType()
	 */
	@Override
	public String getMarkerType() {
		return MARKER_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jdt.core.compiler.IProblem#getArguments()
	 */
	@Override
	public String[] getArguments() {
		return args;
	}

}
