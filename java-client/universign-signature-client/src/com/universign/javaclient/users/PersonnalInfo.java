
package com.universign.javaclient.users;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.utils.CustomDateDeserializer;
import com.universign.javaclient.utils.CustomDateSerializer;

import java.util.Date;

/**
 * Describes the structure contains information about user.
 * It extends the UserDetails structure.
 *
 */
public class PersonnalInfo extends UserDetails
{
	private String userId;
	private String language;
	private String phoneNum;
	private String landlineNum;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date creationDate;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date lastLogin;
	private int operatorStatus;
	private boolean admin;
	private boolean contact;
	private boolean hasCertificate;
	private int remainingSignatures;
	private int remainingTimestamps;
	private int remainingServerStamps;

	/**
	 * The PersonnalInfo constructor.
	 */
	PersonnalInfo()
	{
		//Package Constructor.
	}

	/**
	 * Returns the user id.
	 *
	 * @return The UserId.
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId The user id to set.
	 * @return The current object instance.
	 */
	public PersonnalInfo setUserId(String userId)
	{
		this.userId = userId;
		return this;
	}

	/**
	 * Returns the user language.
	 *
	 * @return The language.
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * Sets the user language.
	 *
	 * @param language The language to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setLanguage(String language)
	{
		this.language = language;
		return this;
	}

	/**
	 * Returns the user phone number.
	 *
	 * @return The phone Number.
	 */
	public String getPhoneNum()
	{
		return phoneNum;
	}

	/**
	 * Sets the user phone number.
	 *
	 * @param phoneNum The phone Number to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
		return this;
	}

	/**
	 * Returns the user landline phone number.
	 *
	 * @return The landline phone number.
	 */
	public String getLandlineNum()
	{
		return landlineNum;
	}

	/**
	 * Sets the user landline phone number.
	 *
	 * @param landlineNum The landline phone number to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setLandlineNum(String landlineNum)
	{
		this.landlineNum = landlineNum;
		return this;
	}

	/**
	 * Returns the creation date of user.
	 *
	 * @return The creationDate.
	 */
	public Date getCreationDate()
	{
		return creationDate;
	}

	/**
	 * Sets the creation date of user.
	 *
	 * @param creationDate The date to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
		return this;
	}

	/**
	 * Returns the last login date of the user.
	 *
	 * @return The lastLogin date.
	 */
	public Date getLastLogin()
	{
		return lastLogin;
	}

	/**
	 * Sets the last login date of the user.
	 *
	 * @param lastLogin The date to set
	 * @return The current object instance
	 */
	public PersonnalInfo setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
		return this;
	}

	/**
	 * Returns the operator status of user.
	 *
	 * @return The operatorStatus.
	 */
	public int getOperatorStatus()
	{
		return operatorStatus;
	}

	/**
	 * Sets the operator status of user.
	 *
	 * @param operatorStatus The operatorStatus to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setOperatorStatus(int operatorStatus)
	{
		this.operatorStatus = operatorStatus;
		return this;
	}

	/**
	 * Returns if the user is administrator or not.
	 *
	 * @return The admin.
	 */
	public boolean isAdmin()
	{
		return admin;
	}

	/**
	 * Sets if the user is administrator or not.
	 *
	 * @param admin The admin to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setAdmin(boolean admin)
	{
		this.admin = admin;
		return this;
	}

	/**
	 * Returns if the user can be contacted or not.
	 *
	 * @return The contact.
	 */
	public boolean isContact()
	{
		return contact;
	}

	/**
	 * Sets if the user can be contacted or not.
	 *
	 * @param contact The contact to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setContact(boolean contact)
	{
		this.contact = contact;
		return this;
	}

	/**
	 * Returns if the user has a certificate or not.
	 *
	 * @return The hasCetificate.
	 */
	public boolean isHasCetificate()
	{
		return hasCertificate;
	}

	/**
	 * Sets if the user has a certificate or not.
	 *
	 * @param hasCetificate The hasCetificate to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setHasCetificate(boolean hasCetificate)
	{
		this.hasCertificate = hasCetificate;
		return this;
	}

	/**
	 * Returns the remaining credit of web signature.
	 *
	 * @return The remainingSignatures.
	 */
	public int getRemainingSignatures()
	{
		return remainingSignatures;
	}

	/**
	 * Sets the remaining credit of web signature.
	 *
	 * @param remainingSignatures The remainingSignatures to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setRemainingSignatures(int remainingSignatures)
	{
		this.remainingSignatures = remainingSignatures;
		return this;
	}

	/**
	 * Returns the remaining credit of timestamps service.
	 *
	 * @return the remainingTimestamps.
	 */
	public int getRemainingTimestamps()
	{
		return remainingTimestamps;
	}

	/**
	 * Sets the remaining credit of timestamps service.
	 *
	 * @param remainingTimestamps The remainingTimestamps to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setRemainingTimestamps(int remainingTimestamps)
	{
		this.remainingTimestamps = remainingTimestamps;
		return this;
	}

	/**
	 * Returns the remaining credit of server signature.
	 *
	 * @return The remainingServerStamps.
	 */
	public int getRemainingServerStamps()
	{
		return remainingServerStamps;
	}

	/**
	 * Sets the remaining credit of server signature.
	 *
	 * @param remainingServerStamps The remainingServerStamps to set.
	 * @return The current object instance
	 */
	public PersonnalInfo setRemainingServerStamps(int remainingServerStamps)
	{
		this.remainingServerStamps = remainingServerStamps;
		return this;
	}
}
