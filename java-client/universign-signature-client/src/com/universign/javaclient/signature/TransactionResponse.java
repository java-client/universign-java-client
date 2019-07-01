
package com.universign.javaclient.signature;

/**
 * Describes the response sent after a request for a transaction.
 * used as a return value only.
 *
 */
public class TransactionResponse
{
	private String url;
	private String id;

	/**
	 * The TransactionResponse Constructor.
	 */
	TransactionResponse()
	{
		// package constructor
	}

	/**
	 * Returns the URL to the web interface for the first signer.
	 *
	 * @return The first signer URL.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the URL to the web interface for the first signer.
	 *
	 * @param url The url to set for the first signer.
	 * @return The current object instance
	 */
	public TransactionResponse setUrl(String url)
	{
		this.url = url;
		return this;
	}

	/**
	 * Returns the transaction Id.
	 *
	 * @return The transaction Id.
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Sets the transaction Id.
	 *
	 * @param id The transaction Id to set.
	 * @return The current object instance
	 */
	public TransactionResponse setId(String id)
	{
		this.id = id;
		return this;
	}
}
