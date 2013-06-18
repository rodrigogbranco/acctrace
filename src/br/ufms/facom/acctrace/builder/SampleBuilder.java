package br.ufms.facom.acctrace.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleBuilder.
 */
public class SampleBuilder extends IncrementalProjectBuilder {

	/**
	 * The Class SampleDeltaVisitor.
	 */
	class SampleDeltaVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
		 * .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				checkXML(resource);
				checkAccTraceComments(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				checkXML(resource);
				checkAccTraceComments(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	/**
	 * The Class SampleResourceVisitor.
	 */
	class SampleResourceVisitor implements IResourceVisitor {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
		 * .resources.IResource)
		 */
		public boolean visit(IResource resource) {
			checkXML(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	/**
	 * The Class XMLErrorHandler.
	 */
	class XMLErrorHandler extends DefaultHandler {

		/** The file. */
		private IFile file;

		/**
		 * Instantiates a new xML error handler.
		 * 
		 * @param file
		 *            the file
		 */
		public XMLErrorHandler(IFile file) {
			this.file = file;
		}

		/**
		 * Adds the marker.
		 * 
		 * @param e
		 *            the e
		 * @param severity
		 *            the severity
		 */
		private void addMarker(SAXParseException e, int severity) {
			SampleBuilder.this.addMarker(file, e.getMessage(),
					e.getLineNumber(), severity);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException
		 * )
		 */
		public void error(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.
		 * SAXParseException)
		 */
		public void fatalError(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException
		 * )
		 */
		public void warning(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_WARNING);
		}
	}
	
	/**
	 * The Class AccTraceComment.
	 */
	class AccTraceCommentHandler extends DefaultHandler {

		/** The file. */
		private IFile file;

		/**
		 * Instantiates a new xML error handler.
		 * 
		 * @param file
		 *            the file
		 */
		public AccTraceCommentHandler(IFile file) {
			this.file = file;
		}

		/**
		 * Adds the marker.
		 * 
		 * @param e
		 *            the e
		 * @param severity
		 *            the severity
		 */
		private void addMarker(SAXParseException e, int severity) {
			SampleBuilder.this.addMarker(file, e.getMessage(),
					e.getLineNumber(), severity);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException
		 * )
		 */
		public void error(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.
		 * SAXParseException)
		 */
		public void fatalError(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException
		 * )
		 */
		public void warning(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_WARNING);
		}
	}	

	/** The Constant BUILDER_ID. */
	public static final String BUILDER_ID = "br.ufms.facom.acctrace.sampleBuilder";

	/** The Constant MARKER_TYPE. */
	private static final String MARKER_TYPE = "br.ufms.facom.acctrace.xmlProblem";

	/** The parser factory. */
	private SAXParserFactory parserFactory;

	/**
	 * Adds the marker.
	 * 
	 * @param file
	 *            the file
	 * @param message
	 *            the message
	 * @param lineNumber
	 *            the line number
	 * @param severity
	 *            the severity
	 */
	private void addMarker(IFile file, String message, int lineNumber,
			int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("rawtypes")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	/**
	 * Check xml.
	 * 
	 * @param resource
	 *            the resource
	 */
	void checkXML(IResource resource) {
		if (resource instanceof IFile && resource.getName().endsWith(".xml")) {
			IFile file = (IFile) resource;
			deleteMarkers(file);
			XMLErrorHandler reporter = new XMLErrorHandler(file);
			try {
				getParser().parse(file.getContents(), reporter);
			} catch (Exception e1) {
			}
		}
	}
	
	void checkAccTraceComments(IResource resource) {
		if (resource instanceof IFile && resource.getName().endsWith(".xml")) {
			IFile file = (IFile) resource;
			deleteMarkers(file);
			XMLErrorHandler reporter = new XMLErrorHandler(file);
			try {
				getParser().parse(file.getContents(), reporter);
			} catch (Exception e1) {
			}
		}
		if (resource instanceof IFile && resource.getName().endsWith(".java")) {
			IFile file = (IFile) resource;
			deleteMarkers(file);
			XMLErrorHandler reporter = new XMLErrorHandler(file);
			try {
				getParser().parse(file.getContents(), reporter);
			} catch (Exception e1) {
			}
		}
	}
	
	private void parse(InputStream in, DefaultHandler handler) throws IOException {
		Reader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		String token = null;
		
		while((token = br.readLine()) != null) {
			String[] tokens = token.split("\\*\\*!ACCTRACE!(/)?([^/\\0#]+(/)?)+\\.acctrace#(\\w)+\\*\\*\\/");
		}
	}

	/**
	 * Delete markers.
	 * 
	 * @param file
	 *            the file
	 */
	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}

	/**
	 * Full build.
	 * 
	 * @param monitor
	 *            the monitor
	 * @throws CoreException
	 *             the core exception
	 */
	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new SampleResourceVisitor());
		} catch (CoreException e) {
		}
	}

	/**
	 * Gets the parser.
	 * 
	 * @return the parser
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the sAX exception
	 */
	private SAXParser getParser() throws ParserConfigurationException,
			SAXException {
		if (parserFactory == null) {
			parserFactory = SAXParserFactory.newInstance();
		}
		return parserFactory.newSAXParser();
	}

	/**
	 * Incremental build.
	 * 
	 * @param delta
	 *            the delta
	 * @param monitor
	 *            the monitor
	 * @throws CoreException
	 *             the core exception
	 */
	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}
}
