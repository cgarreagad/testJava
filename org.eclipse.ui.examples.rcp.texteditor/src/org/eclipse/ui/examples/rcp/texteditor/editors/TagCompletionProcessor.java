package org.eclipse.ui.examples.rcp.texteditor.editors;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class TagCompletionProcessor implements IContentAssistProcessor  {

	
	private ITypedRegion wordRegion;
	private String currentWord;
	//private SmartTreeSet tags;
	public TagCompletionProcessor() {
		//tags = new SmartTreeSet();
		//filling tags skipped
	}
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		System.out.println("compute");
		wordRegion = viewer.getDocument().getDocumentPartitioner().getPartition(offset);
	    try {
			int offs = wordRegion.getOffset();
			int len = wordRegion.getLength();
			currentWord = viewer.getDocument().get(offs, len);
			//return tags.getProposals(currentWord.toLowerCase(), offs, len);
			return null;
		} catch (BadLocationException e) {
			return null;
		}
	}
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] {'<'};
	}
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	public String getErrorMessage() {
		return "No tags found";
	}

}
