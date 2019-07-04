
package com.universign.javaclient.signature;

/**
 * Contains a description for a document signature.
 * used to create a server signature.
 *
 */
public class SignOptions
{
	private String profile;
	private SignatureField signatureField;
	private String reason;
	private String location;
	private SignatureConstants.SignatureFormats signatureFormat;
	private SignatureConstants.Language language;
	private String patternName;

	/**
	 * Returns the name of the signature profile to use.
	 *
	 * @return The name of the signature profile.
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Sets the name of the signature profile to use.
	 * The default value is "default".
	 *
	 * @param profile The name of the signature profile.
     * @return The current object instance
	 */
	public SignOptions setProfile(String profile)
	{
		this.profile = profile.trim();
		return this;
	}

	/**
	 * Returns a description of a visible signature field.
	 *
	 * @see SignatureField
	 *
	 * @return The visible signature field.
	 */
	public SignatureField getSignatureField()
	{
		return signatureField;
	}

	/**
	 * Sets the description of the visible signature field.
	 *
	 * @see SignatureField
	 *
	 * @param signatureField The visible signature field.
     * @return The current object instance
	 */
	public SignOptions setSignatureField(SignatureField signatureField)
	{
		this.signatureField = signatureField;
		return this;
	}

	/**
	 * Returns the reason for the digital signature.
	 *
	 * @return The digital signature reason.
	 */
	public String getReason()
	{
		return reason;
	}

	/**
	 * Sets the reason for the digital signature.
	 *
	 * @param reason The digital signature reason.
     * @return The current object instance
	 */
	public SignOptions setReason(String reason)
	{
		this.reason = reason.trim();
		return this;
	}

	/**
	 * Returns the signer's location.
	 *
	 * @return The signer's location.
	 */
	public String getLocation()
	{
		return location;
	}

	/**
	 * Sets the signer's location.
	 *
	 * @param location The signer's location.
     * @return The current object instance
	 */
	public SignOptions setLocation(String location)
	{
		this.location = location.trim();
		return this;
	}

	/**
	 * Returns the signature format.
	 *
	 * @return The signature format.
	 */
	public SignatureConstants.SignatureFormats getSignatureFormat()
	{
		return signatureFormat;
	}

	/**
	 * Sets the signature format.
	 * The format can be :
	 * <code>PADES</code>, <code>PADES-COMP</code>
	 * or <code>ISO-32000-1</code>.
	 *
	 * @param signatureFormat The signature format.
     * @return The current object instance
	 */
	public SignOptions setSignatureFormat(
			SignatureConstants.SignatureFormats signatureFormat)
	{
		this.signatureFormat = signatureFormat;
		return this;
	}

	/**
	 * Returns the transaction language.
	 *
	 * @return The transaction language.
	 */
	public SignatureConstants.Language getLanguage()
	{
		return language;
	}

	/**
	 * Sets the transaction language.
	 *
	 * @param language The transaction language.
     * @return The current object instance
	 */
	public SignOptions setLanguage(SignatureConstants.Language language)
	{
		this.language = language;
		return this;
	}

	/**
	 * Returns the name of the pattern for the signature field.
	 *
	 * @return The name of the pattern.
	 */
	public String getPatternName()
	{
		return patternName;
	}

	/**
	 * Sets the name of the pattern for the signature field.
	 *
	 * @param patternName The name of the pattern.
     * @return The current object instance
	 */
	public SignOptions setPatternName(String patternName)
	{
		this.patternName = patternName.trim();
		return this;
	}
}
