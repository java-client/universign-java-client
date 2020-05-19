
package com.universign.javaclient.ra;

/**
 * Defines the Universign user data.
 * MatchingResult is used only as a return value.
 *
 */
public class MatchingResult
{
	private String lastname;
	private String firstname;
	private String mobile;
	private String email;
	private String certificateLevel;
	private String certificateStatus;
	private CertificateInfo certificateInfo;

	/**
	 * The MatchingResult constructor.
	 */
	MatchingResult()
	{
		// package constructor.
	}

	/**
	 * Returns the matching user lastname.
	 *
	 * @return The user lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets the matching user lastname.
	 *
	 * @param lastname The user lastname.
	 * @return The current object instance
	 */
	public MatchingResult setLastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}

	/**
	 * Returns the matching user firstname.
	 *
	 * @return The user firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets the matching user firstname.
	 *
	 * @param firstname The user firstname.
	 * @return The current object instance
	 */
	public MatchingResult setFirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Returns the matching user mobile.
	 *
	 * @return The user mobile.
	 */
	public String getMobile()
	{
		return mobile;
	}

	/**
	 * Sets the matching user mobile.
	 *
	 * @param mobile The user mobile.
	 * @return The current object instance
	 */
	public MatchingResult setMobile(String mobile)
	{
		this.mobile = mobile;
		return this;
	}

	/**
	 * Returns the matching user email.
	 *
	 * @return The user email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the matching user email.
	 *
	 * @param email The user email.
	 * @return The current object instance
	 */
	public MatchingResult setEmail(String email)
	{
		this.email = email;
		return this;
	}

	/**
	 * Returns the matching user certificate level.
	 *
	 * @return The user certificate level.
	 */
	public String getCertificateLevel()
	{
		return certificateLevel;
	}

	/**
	 * Sets the matching user certificate level.
	 *
	 * @param certificateLevel The certificate level to set.
	 * @return The current object instance
	 */
	public MatchingResult setCertificateLevel(String certificateLevel)
	{
		this.certificateLevel = certificateLevel;
		return this;
	}

	/**
	 * Returns the certificate status
	 *
	 * @return certificateStatus
	 */
	public String getCertificateStatus()
	{
		return certificateStatus;
	}

	/**
	 * Sets the certificate status
	 *
	 * @param certificateStatus to set
	 * @return MatchingResult instance
	 */
	public MatchingResult setCertificateStatus(String certificateStatus)
	{
		this.certificateStatus = certificateStatus;
		return this;
	}

	/**
	 * Returns the certificate info
	 *
	 * @return certificateInfo
	 */
	public CertificateInfo getCertificateInfo()
	{
		return certificateInfo;
	}

	/**
	 * Sets the certificate info
	 *
	 * @param certificateInfo to set
	 * @return MatchingResult instance
	 */
	public MatchingResult setCertificateInfo(CertificateInfo certificateInfo)
	{
		this.certificateInfo = certificateInfo;
		return this;
	}
}
