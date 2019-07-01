
package com.universign.javaclient.signature;

/**
 * Contains information for the signer registration.
 *
 */
public class RegistrationRequest
{

	private SignatureConstants.IdDocumentTypes type;
	private byte[][] documents;

	/**
	 * Returns the list of ID documents used to register the signer.
	 *
	 * @return The list of ID documents.
	 */
	public byte[][] getDocuments()
	{
		return documents;
	}

	/**
	 * Sets the list of ID documents to use to register the signer.
	 * This list can contains one or two ID documents.
	 *
	 * @param documents The list of ID documents.
	 * @return The current object instance
	 */
	public RegistrationRequest setDocuments(byte[][] documents)
	{
		this.documents = documents;
		return this;
	}

	/**
	 * Return the type of ID documents.
	 *
	 * @return The type of ID documents.
	 */
	public SignatureConstants.IdDocumentTypes getType()
	{
		return type;
	}

	/**
	 * Sets type of ID documents.
	 * Type can be <code>id_card_fr</code> if it's a French ID card,
	 * <code>passeport_eu</code> if it's an European passport,
	 * <code>titre_sejour</code> if it's a resident permit
	 * or <code>drive_license</code> if it's a drive license.
	 *
	 * @param type The type of ID documents.
	 * @return The current object instance
	 */
	public RegistrationRequest setType(
			SignatureConstants.IdDocumentTypes type)
	{
		this.type = type;
		return this;
	}
}
