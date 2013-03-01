package br.ufms.facom.acctrace.editors;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLPartitionScanner.
 */
public class XMLPartitionScanner extends RuleBasedPartitionScanner {

	/** The Constant XML_COMMENT. */
	public final static String XML_COMMENT = "__xml_comment";

	/** The Constant XML_TAG. */
	public final static String XML_TAG = "__xml_tag";

	/**
	 * Instantiates a new xML partition scanner.
	 */
	public XMLPartitionScanner() {

		IToken xmlComment = new Token(XML_COMMENT);
		IToken tag = new Token(XML_TAG);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new MultiLineRule("<!--", "-->", xmlComment);
		rules[1] = new TagRule(tag);

		setPredicateRules(rules);
	}
}
