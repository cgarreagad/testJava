package org.eclipse.ui.examples.rcp.texteditor.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class OtraConfiguration extends SourceViewerConfiguration {

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        ContentAssistant ca = new ContentAssistant();
        IContentAssistProcessor cap = new CompletionProcessor();
        ca.setContentAssistProcessor(cap, IDocument.DEFAULT_CONTENT_TYPE);
        ca.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        return ca;
     }
}
