package br.ufms.facom.acctrace.rulers;

import java.awt.Event;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;

public class DataRequestSelectAnnotationRulerAction extends
		SelectMarkerRulerAction {

    private ITextEditor fTextEditor;
    private boolean fHasCorrection;
    private Position fPosition;
    private Annotation fAnnotation;
 
    public DataRequestSelectAnnotationRulerAction(ResourceBundle bundle, String prefix,
            ITextEditor editor, IVerticalRulerInfo ruler) {
        super(bundle, prefix, editor, ruler);
        fTextEditor = editor;
    }
    
    public void run(){
    	runWithEvent();
    }
 
    public void runWithEvent() {
        //if(fHasCorrection){
            ITextOperationTarget operation= (ITextOperationTarget) fTextEditor.getAdapter(ITextOperationTarget.class);
            final int opCode= ISourceViewer.QUICK_ASSIST;
            if (operation != null && operation.canDoOperation(opCode)) {
                fTextEditor.selectAndReveal(fPosition.getOffset(), fPosition.getLength());
                operation.doOperation(opCode);
            }
       // }
    }
 
    @Override
    public void update() {
        findDataRequestAnnotation();
        setEnabled(true);
 
        super.update();
    }
 
    private void findDataRequestAnnotation(){
        fPosition = null;
        fAnnotation = null;
        fHasCorrection = false;
 
        AbstractMarkerAnnotationModel model = this.getAnnotationModel();
        IAnnotationAccessExtension annotationAccess = this.getAnnotationAccessExtension();
 
        IDocument document = getDocument();
        if(model == null)
            return;
 
        boolean hasAssistLightbulb = true;
 
        Iterator iter = model.getAnnotationIterator();
        int layer = Integer.MIN_VALUE;
 
        while(iter.hasNext()){
            Annotation annotation = (Annotation)iter.next();
            
            if(!annotation.getText().matches("//!ACCTRACE!(/)?([^/\\\\0#]+(/)?)+#([^\\*\\*/])+"))
            	continue;
           
            if(annotation.isMarkedDeleted())
                continue;
 
            int annotationLayer = layer;
            if(annotationAccess != null){
                annotationLayer = annotationAccess.getLayer(annotation);
                if(annotationLayer < layer)
                    continue;
            }
 
            Position position = model.getPosition(annotation);
            if(!includesRulerLine(position, document))
                continue;
 
            boolean isReadOnly = fTextEditor instanceof ITextEditorExtension && ((ITextEditorExtension)fTextEditor).isEditorInputReadOnly();
 
            if(!isReadOnly && (
                    ((hasAssistLightbulb)))
            ){
                fPosition = position;
                fAnnotation = annotation;
                fHasCorrection = true;
                layer = annotationLayer;
                return;
            }
 
        }
    }

}
