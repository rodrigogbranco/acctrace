/**
 *
 * $Id$
 */
package br.ufms.facom.acctrace.model.validation;

import org.obeonetwork.dsl.requirement.RequirementType;

// TODO: Auto-generated Javadoc
/**
 * A sample validator interface for
 * {@link br.ufms.facom.acctrace.model.RequirementFilter}. This doesn't really
 * do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RequirementFilterValidator {

	/**
	 * Validate.
	 * 
	 * @return true, if successful
	 */
	boolean validate();

	/**
	 * Validate requirement type.
	 * 
	 * @param value
	 *            the value
	 * @return true, if successful
	 */
	boolean validateRequirementType(RequirementType value);

	/**
	 * Validate sub type.
	 * 
	 * @param value
	 *            the value
	 * @return true, if successful
	 */
	boolean validateSubType(String value);

	/**
	 * Validate id.
	 * 
	 * @param value
	 *            the value
	 * @return true, if successful
	 */
	boolean validateId(String value);
}
