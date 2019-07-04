
package com.universign.javaclient.signature;

/**
 * Describes a requester of a transaction.
 * InitiatorInfo is used as a return value only.
 *
 */
public class InitiatorInfo
{
	private String email;
	private String firstname;
	private String lastname;

	/**
	 * The InitiatorInfo Constructor.
	 */
	InitiatorInfo()
	{
		// package constructor
	}

	/**
	 * Return the requester email.
	 *
	 * @return The requester email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets a requester email.
	 *
	 * @param email The requester email.
	 * @return The current object instance
	 */
	public InitiatorInfo setEmail(String email)
	{
		this.email = email;
		return this;
	}

	/**
	 * Return the requester first name.
	 *
	 * @return The requester firstname.
	 */
	public String getfirstname()
	{
		return firstname;
	}

	/**
	 * Sets the requester first name.
	 *
	 * @param firstname The requester first name.
	 * @return The current object instance
	 */
	public InitiatorInfo setfirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Return the requester last name.
	 *
	 * @return The requester lastname.
	 */
	public String getlastname()
	{
		return lastname;
	}

	/**
	 * Sets the requester last name.
	 *
	 * @param lastname The requester last name.
	 * @return The current object instance
	 */
	public InitiatorInfo setlastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}
}
