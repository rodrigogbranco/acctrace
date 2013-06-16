package br.ufms.facom.acctrace.compiler;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.core.compiler.ReconcileContext;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.requirement.Requirement;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import br.ufms.facom.acctrace.markers.AccTraceMarker;
import br.ufms.facom.acctrace.model.AccTraceModel;
import br.ufms.facom.acctrace.model.Reference;
import br.ufms.facom.acctrace.model.controller.ModelController;
import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

/**
 * @author Rodrigo Branco
 *
 */
public class AccTraceCommentCompilerMarker extends CompilationParticipant {
	
	private CompilationUnit cu = null;
	
	private String[] source = null;
	
	private ReconcileContext context = null;
	
	private Map<Path,AccTraceModel> modelMap = new HashMap<Path,AccTraceModel>();
	private Map<String,Reference> referenceMap = new HashMap<String,Reference>();
	private Map<Reference,Requirement> requirementMap = new HashMap<Reference,Requirement>();
	private Map<Reference,NamedElement> umlMap = new HashMap<Reference,NamedElement>();
	
	class AccTraceCommentVisitor extends ASTVisitor {

		public boolean visit(LineComment comment) {			
		       int startLineNumber = cu.getLineNumber(comment.getStartPosition()) - 1;
		        String lineComment = source[startLineNumber].trim();
		        
		        if(lineComment.matches("//!ACCTRACE!(/)?([^/\\\\0#]+(/)?)+#([^\\*\\*/])+")) {	        	
		        	/*String stringPath = lineComment.substring(12, lineComment.indexOf('#'));
		        	String referenceId = lineComment.substring(lineComment.indexOf('#')+1,lineComment.length());
		        	
		        	String message = AccTraceCommentHandler.getInstance().getMessage(stringPath, referenceId);*/

		        	CategorizedProblem prob = new AccTraceMarker
		        			(lineComment, 
		        			cu.getJavaElement().getPath().toOSString().toCharArray(),
		        			comment.getStartPosition(), comment.getStartPosition() + comment.getLength(), 
		        			startLineNumber, null);
		        	
		        	context.putProblems(AccTraceMarker.MARKER_TYPE, new CategorizedProblem[] { prob });
		  }		
		  return true;
		}
	}
	
	@Override
	public void reconcile(ReconcileContext con) {
		try {
			context = con;
			source = context.getWorkingCopy().getSource().split("\\n");			
			cu = context.getAST4();			
			AccTraceCommentVisitor visitor = new AccTraceCommentVisitor();		
			List l = cu.getCommentList();		
			for(Object o : l) {
				((Comment)o).accept(visitor);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return true;
	}

	@Override
	public boolean isAnnotationProcessor() {
		return true;
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
	}

	/*@Override
	public void buildFinished(IJavaProject project) {
		int left;
		synchronized (inputProjects) {
			inputProjects.remove(project);
			left = inputProjects.size();
		}

		if (left == 0) {
			startAnalysis();
		}
	}*/

	/*@Override
	public void processAnnotations(BuildContext[] files) {
		IProject prj = null;
		for (BuildContext ctx : files) {
			IProject p = ctx.getFile().getProject();
			if (prj == null)
				prj = p;
			if (p != prj)
				ctx.recordNewProblems(new CategorizedProblem[] { null });
		}
	}*/
}
