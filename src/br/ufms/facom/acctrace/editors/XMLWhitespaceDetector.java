package br.ufms.facom.acctrace.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLWhitespaceDetector.
 */
public class XMLWhitespaceDetector implements IWhitespaceDetector {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWhitespaceDetector#isWhitespace(char)
	 */
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
