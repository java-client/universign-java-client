
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.utils.JsonDateSerializer;
import com.universign.javaclient.utils.JsonDateDeserializer;

import java.util.Date;

/**
 * Describes a filter on transactions.
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TransactionFilter
{
	private String requesterEmail;
	private String profile;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date notBefore;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date notAfter;
	private int startRange;
	private int stopRange;
	private String signerId;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date notBeforeCompletion;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date notAfterCompletion;
	private int status;
	private boolean withAffiliated;

	/**
	 * Returns the requester email address.
	 *
	 * @return The requester email.
	 */
	public String getRequesterEmail()
	{
		return requesterEmail;
	}

	/**
	 * Sets the requester email address.
	 *
	 * @param requesterEmail The email to set.
	 * @return The current object instance
	 */
	public TransactionFilter setRequesterEmail(String requesterEmail)
	{
		this.requesterEmail = requesterEmail.trim();
		return this;
	}

	/**
	 * Returns the signature profile name used to create transaction.
	 *
	 * @return The profile name.
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Sets the signature profile name.
	 *
	 * @param profile The profile name to set.
	 * @return The current object instance
	 */
	public TransactionFilter setProfile(String profile)
	{
		this.profile = profile.trim();
		return this;
	}

	/**
	 * Returns the date after which the transaction was created.
	 *
	 * @return The date after which the transaction was created.
	 */
	public Date getNotBefore()
	{
		return notBefore;
	}

	/**
	 * Sets the date after which the transaction was created.
	 *
	 * @param notBefore The date to set.
	 * @return The current object instance
	 */
	public TransactionFilter setNotBefore(Date notBefore)
	{
		this.notBefore = notBefore;
		return this;
	}

	/**
	 * Returns the date before which the transaction was created.
	 *
	 * @return The date before which the transaction was created.
	 */
	public Date getNotAfter()
	{
		return notAfter;
	}

	/**
	 * Sets the date before which the transaction was created.
	 *
	 * @param notAfter The date to set.
	 * @return The current object instance
	 */
	public TransactionFilter setNotAfter(Date notAfter)
	{
		this.notAfter = notAfter;
		return this;
	}

	/**
	 * Returns the start range index.
	 *
	 * @return The index of the start range.
	 */
	public int getStartRange()
	{
		return startRange;
	}

	/**
	 * Sets the start range index.
	 * default value is <code>0</code>.
	 *
	 * @param startRange The index to set.
	 * @return The current object instance
	 */
	public TransactionFilter setStartRange(int startRange)
	{
		this.startRange = startRange;
		return this;
	}

	/**
	 * Returns the stop range index.
	 *
	 * @return The index of the stop range.
	 */
	public int getStopRange()
	{
		return stopRange;
	}

	/**
	 * Sets the stop range index.
	 * default and maximum value is <code>StartRange+1000</code>.
	 *
	 * @param stopRange The index to set.
	 * @return The current object instance
	 */
	public TransactionFilter setStopRange(int stopRange)
	{
		this.stopRange = stopRange;
		return this;
	}

	/**
	 * Returns the id of signer.
	 *
	 * @return The signer Id.
	 */
	public String getSignerId()
	{
		return signerId;
	}

	/**
	 * Sets the id of signer.
	 *
	 * @param signerId The id to set.
	 * @return The current object instance
	 */
	public TransactionFilter setSignerId(String signerId)
	{
		this.signerId = signerId.trim();
		return this;
	}

	/**
	 * Returns the date after which the transactions are completed.
	 *
	 * @return The date after which the transactions are completed.
	 */
	public Date getNotBeforeCompletion()
	{
		return notBeforeCompletion;
	}

	/**
	 * Sets the date after which the transactions are completed.
	 *
	 * @param notBeforeCompletion The date to set.
	 * @return The current object instance
	 */
	public TransactionFilter setNotBeforeCompletion(
			Date notBeforeCompletion)
	{
		this.notBeforeCompletion = notBeforeCompletion;
		return this;
	}

	/**
	 * Returns the date before which the transactions are completed.
	 *
	 * @return The date before which the transactions are completed.
	 */
	public Date getNotAfterCompletion()
	{
		return notAfterCompletion;
	}

	/**
	 * Sets the date before which the transactions are completed.
	 *
	 * @param notAfterCompletion The date to set.
	 * @return The current object instance
	 */
	public TransactionFilter setNotAfterCompletion(Date notAfterCompletion)
	{
		this.notAfterCompletion = notAfterCompletion;
		return this;
	}

	/**
	 * Returns the transaction status.
	 *
	 * @return The transaction status.
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Sets the transaction status.
	 *
	 * @param status The status of transaction to set.
	 * @return The current object instance
	 */
	public TransactionFilter setStatus(int status)
	{
		this.status = status;
		return this;
	}

	/**
	 * Returns if the own transaction won't be listed or not.
	 *
	 * @return The value of withAffiliated parameter.
	 */
	public boolean getWithAffiliated()
	{
		return withAffiliated;
	}

	/**
	 * Sets the with Affiliated filter.
	 * <code>true</code> if the own transaction won't be listed.
	 *
	 * @param withAffiliated The filter to set.
	 * @return The current object instance
	 */
	public TransactionFilter setWithAffiliated(boolean withAffiliated)
	{
		this.withAffiliated = withAffiliated;
		return this;
	}
}
