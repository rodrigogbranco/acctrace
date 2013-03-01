/**
 * 
 */
package br.ufms.facom.acctrace.editors.filter;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class AccTraceFileFilter.
 */
public class AccTraceFileFilter extends ViewerFilter {

	/**
	 * Instantiates a new acc trace file filter.
	 */
	public AccTraceFileFilter() {
		/* Do nothing */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
	 * .Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IFile
				&& ((IFile) element).getFileExtension() != null
				&& ((IFile) element).getFileExtension().equals("requirement"))
			return true;

		return false;
	}

}
