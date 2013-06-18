package br.ufms.facom.acctrace.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.core.compiler.ReconcileContext;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.LineComment;

import br.ufms.facom.acctrace.markers.AccTraceMarker;

/**
 * @author Rodrigo Branco
 * 
 */
public class AccTraceCommentCompilerMarker extends CompilationParticipant {

	private CompilationUnit cu = null;

	private String[] source = null;

	private ReconcileContext context = null;

	private ArrayList<CategorizedProblem> cp = new ArrayList<CategorizedProblem>();

	class AccTraceCommentVisitor extends ASTVisitor {

		public boolean visit(LineComment comment) {
			int startLineNumber = cu.getLineNumber(comment.getStartPosition()) - 1;
			String lineComment = source[startLineNumber].trim();

			if (lineComment
					.matches("//!ACCTRACE!(/)?([^/\\\\0#]+(/)?)+#([^\\*\\*/])+")) {

				CategorizedProblem prob = new AccTraceMarker(lineComment, cu
						.getJavaElement().getPath().toOSString().toCharArray(),
						comment.getStartPosition(), comment.getStartPosition()
								+ comment.getLength(), startLineNumber, null);

				cp.add(prob);
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
			cp.clear();
			for (Object o : l) {
				((Comment) o).accept(visitor);
			}
			context.putProblems(AccTraceMarker.MARKER_TYPE,
					cp.toArray(new CategorizedProblem[0]));
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
}
