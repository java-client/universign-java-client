
package com.universign.javaclient.signature;

/**
 * Describes the certificate Info which was used to sign.
 * CertificateInfo is used only as a return value.
 *
 */
public class CertificateInfo
{
	private String subject;
	private String issuer;
	private String serial;

	/**
	 * The CertificateInfo Constructor.
	 */
	CertificateInfo()
	{
		// package constructor.
	}

	/**
	 * Return the certificate subject DN.
	 *
	 * @return The subject DN.
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * Sets the certificate subject DN.
	 *
	 * @param subject The subject DN.
	 * @return The current object instance
	 */
	public CertificateInfo setSubject(String subject)
	{
		this.subject = subject;
		return this;
	}

	/**
	 * Return the certificate issuer DN.
	 *
	 * @return The issuer DN.
	 */
	public String getIssuer()
	{
		return issuer;
	}

	/**
	 * Sets the certificate issuer DN.
	 *
	 * @param issuer The issuer DN.
	 * @return The current object instance
	 */
	public CertificateInfo setIssuer(String issuer)
	{
		this.issuer = issuer;
		return this;
	}

	/**
	 * Return the certificate serial number.
	 *
	 * @return The serial number.
	 */
	public String getSerial()
	{
		return serial;
	}

	/**
	 * Sets the certificate serial number.
	 *
	 * @param serial The serial number.
	 * @return The current object instance
	 */
	public CertificateInfo setSerial(String serial)
	{
		this.serial = serial;
		return this;
	}
}
