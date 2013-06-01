package br.ufms.facom.acctrace.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;

import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.obeonetwork.dsl.requirement.Repository;
import org.obeonetwork.dsl.requirement.Requirement;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import br.ufms.facom.acctrace.model.controller.ModelController;
import br.ufms.facom.acctrace.owl.AccessibilityOWLFactory;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "ods". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class TraceabilityMatrixWizard extends Wizard implements INewWizard {
	private TraceabilityMatrixWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for TraceabilityMatrixWizard.
	 */
	public TraceabilityMatrixWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new TraceabilityMatrixWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(fileName, monitor);
				} catch ( Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 * @throws Exception 
	 */

	private void doFinish(
		String fileName,
		IProgressMonitor monitor) {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		final IFile file =  page.getAccTraceFile().getProject().getFile(new Path(fileName));
		try {
			createSpreadsheetDocument(file,page.getAccTraceFile());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		monitor.worked(1);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 * @throws Exception 
	 */

	private void createSpreadsheetDocument(IFile file, IFile acctraceFile) throws Exception {			
			SpreadsheetDocument doc = SpreadsheetDocument.newSpreadsheetDocument();
			
			Map<Requirement,List<PackageableElement>> map = ModelController.getInstance().getReqUML(acctraceFile);
			
			Collection<List<PackageableElement>> collection = map.values();
			
			List<PackageableElement> models = new ArrayList<PackageableElement>();
			
			Iterator<List<PackageableElement>> it = collection.iterator();
			while(it.hasNext()) {
				List<PackageableElement> list = it.next();
				for(PackageableElement pack : list) {
					if(!models.contains(pack))
						models.add(pack);
				}
			}
			
			Table table = doc.getSheetByIndex(0);
			table.setTableName("Requirements x Models");
			
			int j = 0;
			Row row = table.getRowByIndex(j++);
			
			int i = 1;
			
			for(PackageableElement pack : models){
				row.getCellByIndex(i++).addParagraph(ModelController.getInstance().getLabel(pack));
			}
			
			for(Requirement requirement : map.keySet()) {
				row = table.getRowByIndex(j++);
				i = 0;
				row.getCellByIndex(i++).addParagraph("Name: " + requirement.getName() + " ID: " + requirement.getId());
				for(PackageableElement pack : models){
					if(map.get(requirement).contains(pack))
						row.getCellByIndex(i++).addParagraph("X");
					else
						row.getCellByIndex(i++).addParagraph(" ");
				}
			}
			
			Map<Requirement,List<String>> map2 = ModelController.getInstance().getReqTech(acctraceFile);
			
			Collection<List<String>> collection2 = map2.values();
			
			List<String> models2 = new ArrayList<String>();
			
			Iterator<List<String>> it2 = collection2.iterator();
			while(it2.hasNext()) {
				List<String> list = it2.next();
				for(String ontology : list) {
					if(!models2.contains(ontology))
						models2.add(ontology);
				}
			}
			
			table = doc.appendSheet("Requirement x Techniques");
			
			j = 0;
			row = table.getRowByIndex(j++);
			
			i = 1;
			
			for(String strOntology : models2){
				
				OWLOntology ontology = AccessibilityOWLFactory.getInstance().
						getOWLOntologyByIRI(strOntology);
				System.out.println(strOntology);
				System.out.println(ontology);
				OWLNamedIndividual individual = AccessibilityOWLFactory.
						getInstance().getNamedIndividual(strOntology, ontology);
				
				row.getCellByIndex(i++).addParagraph(AccessibilityOWLFactory.getInstance().getValue(individual, "hasName", ontology));
			}
			
			for(Requirement requirement : map2.keySet()) {
				row = table.getRowByIndex(j++);
				i = 0;
				row.getCellByIndex(i++).addParagraph("Name: " + requirement.getName() + " ID: " + requirement.getId());
				for(String strOntology : models2){
					if(map2.get(requirement).contains(strOntology))
						row.getCellByIndex(i++).addParagraph("X");
					else
						row.getCellByIndex(i++).addParagraph(" ");
				}
			}
			
			Map<PackageableElement,List<String>> map3 = ModelController.getInstance().getModelTech(acctraceFile);
			
			Collection<List<String>> collection3 = map3.values();
			
			List<String> models3 = new ArrayList<String>();
			
			Iterator<List<String>> it3 = collection3.iterator();
			while(it3.hasNext()) {
				List<String> list = it3.next();
				for(String ontology : list) {
					if(!models3.contains(ontology))
						models3.add(ontology);
				}
			}
			
			table = doc.appendSheet("Model x Techniques");
			
			j = 0;
			row = table.getRowByIndex(j++);
			
			i = 1;
			
			for(String strOntology : models3){
				
				OWLOntology ontology = AccessibilityOWLFactory.getInstance().
						getOWLOntologyByIRI(strOntology);
				System.out.println(strOntology);
				System.out.println(ontology);
				OWLNamedIndividual individual = AccessibilityOWLFactory.
						getInstance().getNamedIndividual(strOntology, ontology);
				
				row.getCellByIndex(i++).addParagraph(AccessibilityOWLFactory.getInstance().getValue(individual, "hasName", ontology));
			}
			
			for(PackageableElement pack : map3.keySet()) {
				row = table.getRowByIndex(j++);
				i = 0;
				row.getCellByIndex(i++).addParagraph(ModelController.getInstance().getLabel(pack));
				for(String strOntology : models3){
					if(map3.get(pack).contains(strOntology))
						row.getCellByIndex(i++).addParagraph("X");
					else
						row.getCellByIndex(i++).addParagraph(" ");
				}
			}			
			
			doc.save(file.getRawLocation().makeAbsolute().toFile());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "br.ufms.facom.acctrace", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}