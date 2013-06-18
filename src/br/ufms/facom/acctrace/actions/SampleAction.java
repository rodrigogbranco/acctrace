package br.ufms.facom.acctrace.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		MessageDialog.openInformation(
			window.getShell(),
			"AccTrace",
			"Hello, Eclipse world");
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		  /*System.out.println("==========> selectionChanged");
		  if(selection instanceof TextSelection) {
			  //TextSelection t = (TextSelection)selection;
			  if(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() instanceof CompilationUnitEditor) {
				  AbstractTextEditor  editor = (AbstractTextEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				  ISourceViewer sourceViewer = 
					        (ISourceViewer) editor.getAdapter(ITextOperationTarget.class);
				  sourceViewer.setTextHover(new JavaTextHover(), JavaCore.JAVA_SOURCE_CONTENT_TYPE);
				  //System.out.println(sourceViewer);
				  
			  }
		  }
		  System.out.println(selection);*/	
	}
	
	class JavaTextHover implements ITextHover  {

		public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
			if (hoverRegion != null) {
				try {
					if (hoverRegion.getLength() > -1)
						return textViewer.getDocument().get(hoverRegion.getOffset(), hoverRegion.getLength());
				} catch (BadLocationException x) {
				}
			}
			return "JavaTextHover.emptySelection"; 
		}

		@Override
		public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
			Point selection= textViewer.getSelectedRange();
			if (selection.x <= offset && offset < selection.x + selection.y)
				return new Region(selection.x, selection.y);
			return new Region(offset, 0);
		}
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}