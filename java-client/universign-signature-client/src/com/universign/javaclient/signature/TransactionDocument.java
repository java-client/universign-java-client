// $Id:  $

package com.universign.javaclient.signature;

import java.util.List;
import java.util.Map;

/**
 * Describes all necessary informations about the transaction document.
 *
 */
public class TransactionDocument
{
	private SignatureConstants.DocumentTypes documentType;
	private byte[] content;
	private String url;
	private String fileName;
	private List<DocSignatureField> signatureFields;
	private List<String> checkBoxTexts;
	private Map<String, String> metaData;
	private String title;
	private SEPAData sepaData;

	/**
	 * Returns the type of the document to sign.
	 *
	 * @return The type of document.
	 */
	public SignatureConstants.DocumentTypes getDocumentType()
	{
		return documentType;
	}

	/**
	 * Sets the type of the document to sign.
	 * Valid value are :
	 * <code>pdf</code> to makes all TransactionDocument
	 * members relevant (default value).
	 * <code>pdf-for-presentation</code> to mark the document
	 * as view only.
	 * <code>sepa</code> no PDF is provided
	 * but Universign create a SEPA mandate.
	 *
	 * @param documentType The type of document to set.
	 * @return The current object instance
	 */
	public TransactionDocument setDocumentType(
			SignatureConstants.DocumentTypes documentType)
	{
		this.documentType = documentType;
		return this;
	}

	/**
	 * Returns the document content.
	 *
	 * @return The content of document.
	 */
	public byte[] getContent()
	{
		return content;
	}

	/**
	 * Sets the document content.
	 *
	 * @param content The document content to set.
	 * @return The current object instance
	 */
	public TransactionDocument setContent(byte[] content)
	{
		this.content = content;
		return this;
	}

	/**
	 * Returns the URL to download the document.
	 *
	 * @return The URL of the document.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the URL to download the document.
	 *
	 * @param url The document URL to set.
	 * @return The current object instance
	 */
	public TransactionDocument setUrl(String url)
	{
		this.url = url;
		return this;
	}

	/**
	 * Returns the file name of the document.
	 *
	 * @return The name of the document.
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * Sets the file name of the document.
	 * This Attribute is mandatory only if documentType
	 * isn't <code>sepa</code>
	 *
	 * @param fileName The name to set.
	 * @return The current object instance
	 */
	public TransactionDocument setFileName(String fileName)
	{
		this.fileName = fileName;
		return this;
	}

	/**
	 * Returns the list of signature field.
	 *
	 * @return The signature fields list.
	 */
	public List<DocSignatureField> getSignatureFields()
	{
		return signatureFields;
	}

	/**
	 * Sets the list of signature field.
	 *
	 * @param signatureFields The list of signature field to set.
	 * @return The current object instance
	 */
	public TransactionDocument setSignatureFields(
			List<DocSignatureField> signatureFields)
	{
		this.signatureFields = signatureFields;
		return this;
	}

	/**
	 * Returns the list of checkBox.
	 *
	 * @return The checkBoxTexts list.
	 */
	public List<String> getCheckBoxTexts()
	{
		return checkBoxTexts;
	}

	/**
	 * Sets the list of checkBox.
	 *
	 * @param checkBoxTexts The list of checkbox texts to set.
	 * @return The current object instance
	 */
	public TransactionDocument setCheckBoxTexts(List<String> checkBoxTexts)
	{
		this.checkBoxTexts = checkBoxTexts;
		return this;
	}

	/**
	 * Returns the metaData structure.
	 *
	 * @return The metaData structure.
	 */
	public Map<String, String> getMetaData()
	{
		return metaData;
	}

	/**
	 * Sets the metaData structure.
	 *
	 * @param metaData Structure to set.
	 * @return The current object instance
	 */
	public TransactionDocument setMetaData(Map<String, String> metaData)
	{
		this.metaData = metaData;
		return this;
	}

	/**
	 * Returns the title to be display.
	 *
	 * @return The title to display.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets title to display.
	 *
	 * @param title The displayed title to set.
	 * @return The current object instance
	 */
	public TransactionDocument setTitle(String title)
	{
		this.title = title;
		return this;
	}

	/**
	 * Returns data to create a SEPA mandate.
	 *
	 * @return The SEPA mandate data.
	 */
	public SEPAData getSEPAData()
	{
		return sepaData;
	}

	/**
	 * Sets data for SEPA mandate.
	 *
	 * @param sEPAData The data to set.
	 * @return The current object instance
	 */
	public TransactionDocument setSEPAData(SEPAData sEPAData)
	{
		sepaData = sEPAData;
		return this;
	}
}
