
package com.universign.javaclient.ra;

/**
 * Describes the data needed to be sent in order to launch
 * a validation session.
 *
 */
public class ValidationRequest
{
	private IdDocument idDocument;
	private PersonalInfo personalInfo;
	private boolean allowManual;
	private String callbackURL;

	/**
	 * Returns the ID document.
	 *
	 * @return The ID document.
	 */
	public IdDocument getIdDocument()
	{
		return idDocument;
	}

	/**
	 * Sets the ID document.
	 *
	 * @param idDocument The ID document.
	 * @return The current object instance
	 */
	public ValidationRequest setIdDocument(IdDocument idDocument)
	{
		this.idDocument = idDocument;
		return this;
	}

	/**
	 * Returns the personal information to compare with
	 * the ID document.
	 *
	 * @return The personal information.
	 */
	public PersonalInfo getPersonalInfo()
	{
		return personalInfo;
	}

	/**
	 * Sets the personal information to compare with
	 * the ID document.
	 *
	 * @param personalInfo The personal information.
	 * @return The current object instance
	 */
	public ValidationRequest setPersonalInfo(PersonalInfo personalInfo)
	{
		this.personalInfo = personalInfo;
		return this;
	}

	/**
	 * Returns if manual validation is allowed or not.
	 *
	 * @return The whether to allow manual validation.
	 */
	public boolean isAllowManual()
	{
		return allowManual;
	}

	/**
	 * Sets <code>true</code> if manual validation is allowed,
	 * <code>false</code> if not.
	 *
	 * @param allowManual The whether to allow manual validation.
	 * @return The current object instance
	 */
	public ValidationRequest setAllowManual(boolean allowManual)
	{
		this.allowManual = allowManual;
		return this;
	}

	/**
	 * Returns the callback URL to be requested.
	 *
	 * @return The callback URL.
	 */
	public String getCallbackURL()
	{
		return callbackURL;
	}

	/**
	 * Sets the callback URL to be requested.
	 *
	 * @param callbackURL The callback URL.
	 * @return The current object instance
	 */
	public ValidationRequest setCallbackURL(String callbackURL)
	{
		this.callbackURL = callbackURL;
		return this;
	}
}
