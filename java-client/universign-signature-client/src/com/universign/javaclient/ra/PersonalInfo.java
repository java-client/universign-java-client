
package com.universign.javaclient.ra;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.utils.CustomDateDeserializer;
import com.universign.javaclient.utils.CustomDateSerializer;

import java.util.Date;

/**
 * Describes the user informations needed to be compared
 * with ID document.
 *
 */
public class PersonalInfo
{
	private String lastname;
	private String firstname;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date birthDate;

	/**
	 * The PersonalInfo Constructor.
	 */
	PersonalInfo()
	{
		// package constructor
	}

	/**
	 * Returns the user lastname.
	 *
	 * @return The user lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets the user lastname.
	 *
	 * @param lastname The user lastname.
	 * @return The current object instance
	 */
	public PersonalInfo setLastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}

	/**
	 * Returns the user firstname.
	 *
	 * @return The user firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets the user firstname.
	 *
	 * @param firstname The user firstname.
	 * @return The current object instance
	 */
	public PersonalInfo setFirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Returns the user birthDate.
	 *
	 * @return The birthDate.
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}

	/**
	 * Sets the user birthDate.
	 *
	 * @param birthDate The birthDate to set.
	 * @return The current object instance
	 */
	public PersonalInfo setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
		return this;
	}
}
