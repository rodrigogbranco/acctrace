package br.ufms.facom.acctrace.editors;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

// TODO: Auto-generated Javadoc
/**
 * The Class TagRule.
 */
public class TagRule extends MultiLineRule {

	/**
	 * Instantiates a new tag rule.
	 * 
	 * @param token
	 *            the token
	 */
	public TagRule(IToken token) {
		super("<", ">", token);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.rules.PatternRule#sequenceDetected(org.eclipse
	 * .jface.text.rules.ICharacterScanner, char[], boolean)
	 */
	protected boolean sequenceDetected(ICharacterScanner scanner,
			char[] sequence, boolean eofAllowed) {
		int c = scanner.read();
		if (sequence[0] == '<') {
			if (c == '?') {
				// processing instruction - abort
				scanner.unread();
				return false;
			}
			if (c == '!') {
				scanner.unread();
				// comment - abort
				return false;
			}
		} else if (sequence[0] == '>') {
			scanner.unread();
		}
		return super.sequenceDetected(scanner, sequence, eofAllowed);
	}
}
