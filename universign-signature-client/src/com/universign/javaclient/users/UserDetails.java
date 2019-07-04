
package com.universign.javaclient.users;

/**
 * Defines the data structure contains informations
 * about the organisation's user.
 *
 */
public class UserDetails
{
	private String email;
	private String firstname;
	private String lastname;
	private int status;

	/**
	 * The UserDetails constructor.
	 */
	UserDetails()
	{
		//Package Constructor.
	}

	/**
	 * Return the email identifying user.
	 *
	 * @return The user email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the user email.
	 *
	 * @param email The email to set.
	 * @return The current object instance
	 */
	public UserDetails setEmail(String email)
	{
		this.email = email;
		return this;
	}

	/**
	 * Returns the user firstname.
	 *
	 * @return The user firstname.
	 */
	public String getfirstname()
	{
		return firstname;
	}

	/**
	 * Sets the user firstname.
	 *
	 * @param firstname The firstname to set.
	 * @return The current object instance
	 */
	public UserDetails setfirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Returns the user lastename.
	 *
	 * @return The user lastename.
	 */
	public String getlastname()
	{
		return lastname;
	}

	/**
	 * Sets the user lastename.
	 *
	 * @param lastname The lastname to set.
	 * @return The current object instance
	 */
	public UserDetails setlastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}

	/**
	 * Returns the registration status.
	 * <code>0</code> if registration is not yet done,
	 * else, <code>1</code> if user has already validated
	 * his registration.
	 *
	 * @return The user status.
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Sets the user status.
	 *
	 * @param status The status to set
	 * @return The current object instance
	 */
	public UserDetails setStatus(int status)
	{
		this.status = status;
		return this;
	}
}
