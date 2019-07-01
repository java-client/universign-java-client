
package com.universign.javaclient.ra;


/**
 * Describes the matching filter criteria.
 *
 */
public class MatchingFilter
{
	private String lastname;
	private String firstname;
	private String mobile;
	private String email;

	/**
	 * Returns the matching filter user lastname.
	 *
	 * @return The user lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets the matching filter user lastname.
	 *
	 * @param lastname The user lastname.
	 * @return The current object instance
	 */
	public MatchingFilter setLastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}

	/**
	 * Returns the matching filter user firstname.
	 *
	 * @return The user firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets the matching filter user firstname.
	 *
	 * @param firstname The user firstname.
	 * @return The current object instance
	 */
	public MatchingFilter setFirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Returns the matching filter user mobile.
	 *
	 * @return The user mobile.
	 */
	public String getMobile()
	{
		return mobile;
	}

	/**
	 * Sets the matching filter user mobile.
	 *
	 * @param mobile The user mobile.
	 * @return The current object instance
	 */
	public MatchingFilter setMobile(String mobile)
	{
		this.mobile = mobile;
		return this;
	}

	/**
	 * Returns the matching filter user email.
	 *
	 * @return The user email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the matching filter user email.
	 *
	 * @param email The user email.
	 * @return The current object instance
	 */
	public MatchingFilter setEmail(String email)
	{
		this.email = email;
		return this;
	}
}
