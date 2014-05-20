package org.eclipse.ui.examples.rcp.texteditor.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.examples.rcp.texteditor.editors.xml.XMLPartitionScanner;

public class TestSourceViewerConfiguration  extends SourceViewerConfiguration{

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
	
		/*ContentAssistant assistant = new ContentAssistant();       
	       assistant.enableAutoInsert(true);
	       assistant.enableAutoActivation(true);
	       assistant.setAutoActivationDelay(500);
	       IContentAssistProcessor processor = new ResourceFileContentAssistProcessor();           
	       assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
	        */
	       
	       ContentAssistant ca = new ContentAssistant();
	       IContentAssistProcessor pr = new HippieProposalProcessor();
	       ca.setContentAssistProcessor(pr, XMLPartitionScanner.XML_TAG);
	       ca.setContentAssistProcessor(pr, IDocument.DEFAULT_CONTENT_TYPE);
	      // ca.setInformationControlCreator(getInformationControlCreator(sv));
	  
	       
	       
	       return ca;
	
	}
}
