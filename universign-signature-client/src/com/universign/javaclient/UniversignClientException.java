
package com.universign.javaclient;

/**
 * The Universign Client Exception.
 *
 */
public class UniversignClientException extends Exception
{

	/**
	 * The UniversignClientException constructor.
	 *
	 * @param message The exception message.
	 * @param cause The exception cause.
	 */
	public UniversignClientException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
