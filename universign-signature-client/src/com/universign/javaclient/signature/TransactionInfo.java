
package com.universign.javaclient.signature;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.utils.JsonDateDeserializer;
import com.universign.javaclient.utils.JsonDateSerializer;

import java.util.Date;
import java.util.List;

/**
 * Describes the essential info of a transaction.
 * used as a return value only.
 *
 */
public class TransactionInfo
{
	private String status;
	private List<SignerInfo> signerInfos;
	private int currentSigner;
	private Date creationDate;
	private String description;
	private InitiatorInfo initiatorInfo;
	private boolean eachField;
	private String customId;
	private String transactionId;
	private SignatureConstants.RedirectPolicy redirectPolicy;
	private int redirectWait;

	/**
	 * The TransactionInfo Constructor.
	 */
	TransactionInfo()
	{
		// package constructor
	}

	/**
	 * Returns the transaction status.
	 *
	 * @return The status of transaction.
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the transaction status.
	 *
	 * @param status The transaction status to set.
	 * @return The current object instance
	 */
	public TransactionInfo setStatus(String status)
	{
		this.status = status;
		return this;
	}

	/**
	 * Returns information about signer.
	 *
	 * @return Information about the signer.
	 */
	public List<SignerInfo> getSignerInfos()
	{
		return signerInfos;
	}

	/**
	 * Sets the information about signer.
	 *
	 * @param signerInfos The information to set.
	 * @return The current object instance
	 */
	public TransactionInfo setSignerInfos(List<SignerInfo> signerInfos)
	{
		this.signerInfos = signerInfos;
		return this;
	}

	/**
	 * Returns the index of the current signer.
	 *
	 * @return The index of the current signer.
	 */
	public int getCurrentSigner()
	{
		return currentSigner;
	}

	/**
	 * Sets the index of the current signer.
	 *
	 * @param currentSigner The signer index to set.
	 * @return The current object instance
	 */
	public TransactionInfo setCurrentSigner(int currentSigner)
	{
		this.currentSigner = currentSigner;
		return this;
	}

	/**
	 * Returns the creation date of transaction.
	 *
	 * @return The transaction creation date.
	 */
	public Date getCreationDate()
	{
		return creationDate;
	}

	/**
	 * Sets the date of creation of transaction.
	 *
	 * @param creationDate The date of creation to set.
	 * @return The current object instance
	 */
	public TransactionInfo setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
		return this;
	}

	/**
	 * Returns a description of transaction.
	 *
	 * @return The transaction description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the transaction description.
	 *
	 * @param description The transaction description to set.
	 * @return The current object instance
	 */
	public TransactionInfo setDescription(String description)
	{
		this.description = description;
		return this;
	}

	/**
	 * Returns information of the requester.
	 *
	 * @return Information about requester.
	 */
	public InitiatorInfo getInitiatorInfo()
	{
		return initiatorInfo;
	}

	/**
	 * Sets the requester information.
	 *
	 * @param initiatorInfo The requester information to set.
	 * @return The current object instance
	 */
	public TransactionInfo setInitiatorInfo(InitiatorInfo initiatorInfo)
	{
		this.initiatorInfo = initiatorInfo;
		return this;
	}

	/**
	 * Returns if handwritten signature is requested
	 * for each signature field or not.
	 *
	 * @return The requested eachField for each signature field.
	 */
	public boolean getEachField()
	{
		return eachField;
	}

	/**
	 * Sets <code>true</code> if handwritten signature is requested
	 * for each signature field.
	 *
	 * @param eachField The eachField to set for transaction
	 * with handwritten signature.
	 * @return The current object instance
	 */
	public TransactionInfo setEachField(boolean eachField)
	{
		this.eachField = eachField;
		return this;
	}

	/**
	 * Returns the Id specified by the requester to identify transaction.
	 *
	 * @return The custom Id of transaction.
	 */
	public String getCustomId()
	{
		return customId;
	}

	/**
	 * Sets the Id to identify transaction by requester.
	 *
	 * @param customId The custom Id to set.
	 * @return The current object instance
	 */
	public TransactionInfo setCustomId(String customId)
	{
		this.customId = customId;
		return this;
	}

	/**
	 * Returns the Universign Id of transaction.
	 *
	 * @return The Universign transaction Id.
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * Sets the Universign transactionId.
	 *
	 * @param transactionId The Id to set.
	 * @return The current object instance
	 */
	public TransactionInfo setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
		return this;
	}

	/**
	 * Returns the redirectPolicy value.
	 *
	 * @return redirectPolicy.
	 */
	public SignatureConstants.RedirectPolicy getRedirectPolicy()
	{
		return redirectPolicy;
	}

	/**
	 * Sets the redirectPolicy value
	 *
	 * @param redirectPolicy The redirect policy.
	 * @return The current object instance.
	 */
	public TransactionInfo setRedirectPolicy(
			SignatureConstants.RedirectPolicy redirectPolicy)
	{
		this.redirectPolicy = redirectPolicy;
		return this;
	}

	/**
	 * Returns the redirect wait value.
	 *
	 * @return The redirectWait
	 */
	public int getRedirectWait()
	{
		return redirectWait;
	}

	/**
	 * Sets the redirect wait value.
	 *
	 * @param redirectWait The redirectWait.
	 * @return The current object instance.
	 */
	public TransactionInfo setRedirectWait(int redirectWait)
	{
		this.redirectWait = redirectWait;
		return this;
	}
}
