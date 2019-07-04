
package com.universign.javaclient.ra;

import java.util.Map;

/**
 * Describes the result of a validation session.
 *
 */
public class ValidatorResult
{
	private String id;
	private int status;
	private int reason;
	private String reasonMessage;
	private Map<String, Object> result;

	/**
	 * The ValidatorResult constructor.
	 */
	ValidatorResult()
	{
		//Package Constructor.
	}

	/**
	 * Returns the validation session Id;
	 *
	 * @return The validation session Id.
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Sets the validation session Id.
	 *
	 * @param id The validation session Id.
	 * @return The current object instance
	 */
	public ValidatorResult setId(String id)
	{
		this.id = id;
		return this;
	}

	/**
	 * Returns the validation session status.
	 *
	 * @return The status of the validation session.
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Sets the validation session status.
	 *
	 * @param status The status of the validation session.
	 * @return The current object instance
	 */
	public ValidatorResult setStatus(int status)
	{
		this.status = status;
		return this;
	}

	/**
	 * Returns the error number in case of failure
	 * of the validation session.
	 *
	 * @return The error number.
	 */
	public int getReason()
	{
		return reason;
	}

	/**
	 * Sets the error number in case of failure
	 * of the validation session.
	 *
	 * @param reason The error number.
	 * @return The current object instance
	 */
	public ValidatorResult setReason(int reason)
	{
		this.reason = reason;
		return this;
	}

	/**
	 * Returns the error message in case of failure
	 * of the validation session.
	 *
	 * @return The error message.
	 */
	public String getReasonMessage()
	{
		return reasonMessage;
	}

	/**
	 * Sets the error message in case of failure
	 * of the validation session.
	 *
	 * @param reasonMessage The error message.
	 * @return The current object instance
	 */
	public ValidatorResult setReasonMessage(String reasonMessage)
	{
		this.reasonMessage = reasonMessage;
		return this;
	}

	/**
	 * Returns the list of the failing zones in case of failure
	 * of the validation session.
	 *
	 * @return The failing zones list.
	 */
	public Map<String, Object> getResult()
	{
		return result;
	}

	/**
	 * Sets the list of the failing zones in case of failure
	 * of the validation session.
	 *
	 * @param result The failing zones list.
	 * @return The current object instance
	 */
	public ValidatorResult setResult(Map<String, Object> result)
	{
		this.result = result;
		return this;
	}
}
