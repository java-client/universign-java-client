
package com.universign.javaclient.signature;

/**
 * Describes the same data of SignatureField and give more advanced option.
 * Note : a mix of DocSignatureField and SignatureField will not work.
 *
 * @author yacoubi
 * @version $Revision:  $
 */
public class DocSignatureField extends SignatureField
{
	private int signerIndex;
	private String patternName;
	private String label;
	private byte[] image;

	/**
	 * Returns the index of the signer which uses this field.
	 *
	 * @return The index of the signer.
	 */
	public int getSignerIndex()
	{
		return signerIndex;
	}

	/**
	 * Sets the index of the signer which uses this field.
	 * Signers enumerated starting at 0.
	 *
	 * @param signerIndex The index of the signer.
	 * @return The current object instance
	 */
	public DocSignatureField setSignerIndex(int signerIndex)
	{
		this.signerIndex = signerIndex;
		return this;
	}

	/**
	 * Returns the name of the pattern.
	 *
	 * @return The pattern name.
	 */
	public String getPatternName()
	{
		return patternName;
	}

	/**
	 * Sets the name of the pattern if more than one pattern
	 * is set on the signature profile.
	 * The default value is "default".
	 * The magic value "invisible" mean that the field
	 * will not be visible in the PDF.
	 *
	 * @param patternName The name of the pattern.
	 * @return The current object instance
	 */
	public DocSignatureField setPatternName(String patternName)
	{
		this.patternName = patternName.trim();
		return this;
	}

	/**
	 * Returns the label which defines the signature field.
	 *
	 * @return The signature field label.
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * Sets the label which defines the signature field.
	 * If a signer has more than one field on the same document,
	 * label will be mandatory.
	 *
	 * @param label The signature field label.
	 * @return The current object instance
	 */
	public DocSignatureField setLabel(String label)
	{
		this.label = label.trim();
		return this;
	}

	/**
	 * Returns the image to be displayed in the signature field.
	 *
	 * @return The image to be displayed.
	 */
	public byte[] getImage()
	{
		return image;
	}

	/**
	 * Sets the image to be displayed in the signature field.
	 *
	 * @param image The image to be displayed.
	 * @return The current object instance
	 */
	public DocSignatureField setImage(byte[] image)
	{
		this.image = image;
		return this;
	}
}
