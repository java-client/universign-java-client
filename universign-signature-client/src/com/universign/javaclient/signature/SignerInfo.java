
package com.universign.javaclient.signature;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.utils.CustomDateDeserializer;
import com.universign.javaclient.utils.CustomDateSerializer;

import java.util.Date;

/**
 * Describes the status of a signer.
 * Used as a return value only.
 *
 */
public class SignerInfo
{
	private String status;
	private String error;
	private CertificateInfo certificateInfo;
	private String url;
	private String email;
	private String firstname;
	private String lastname;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date actionDate;
	private int[] refusedDocs;

	/**
	 * The SignerInfo Constructor.
	 */
	SignerInfo()
	{
		// Package Constructor
	}

	/**
	 * Returns the signer/observer status.
	 *
	 * @return The signer/observer status.
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the signer/observer status.
	 * Status can be :
	 * <code>waiting</code> if the signer/observer has not yet been invited
	 * to sign/to access to access the documents(s),
	 * <code>ready</code> if the signer/observer has been invited
	 * to sign/to access the documents(s) but has not tried yet,
	 * <code>accessed</code> if the signer/observer has accessed
	 * the signature service/to access the documents(s),
	 * <code>code-sent</code> if the signer agreed to sign
	 * and has been sent an OTP,
	 * <code>signed</code> if the signer has successfully signed,
	 * <code>pending-id-docs</code> if the signer has successfully signed
	 * and must send the ID documents for registration,
	 * <code>pending-validation</code> if the signer has successfully signed
	 * and is pending RA validation,
	 * <code>canceled</code> if the signer refused to sign,
	 * or <code>failed</code> if an error occurred during the signature.
	 *
	 * @param status The signer/observer status.
	 * @return The current object instance
	 */
	public SignerInfo setStatus(String status)
	{
		this.status = status;
		return this;
	}

	/**
	 * Returns the error message in case of failure.
	 *
	 * @return The error message.
	 */
	public String getError()
	{
		return error;
	}

	/**
	 * Sets the error message in case of failure.
	 *
	 * @param error The error message.
	 * @return The current object instance
	 */
	public SignerInfo setError(String error)
	{
		this.error = error;
		return this;
	}

	/**
	 * Returns a bean containing information about the certificate
	 * the signer used to sign.
	 *
	 * @return The information about the used certificate.
	 */
	public CertificateInfo getCertificateInfo()
	{
		return certificateInfo;
	}

	/**
	 * Sets the bean containing information about the certificate
	 * the signer used to sign.
	 * An empty structure will be set if an error occurs
	 * during the signature.
	 *
	 * @param certificateInfo Information about the certificate.
	 * @return The current object instance
	 */
	public SignerInfo setCertificateInfo(CertificateInfo certificateInfo)
	{
		this.certificateInfo = certificateInfo;
		return this;
	}

	/**
	 * Returns the URL of the signature page.
	 *
	 * @return The signature page URL.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the URL of the signature page.
	 *
	 * @param url The signature page URL.
	 * @return The current object instance
	 */
	public SignerInfo setUrl(String url)
	{
		this.url = url;
		return this;
	}

	/**
	 * Returns the signer/observer email.
	 *
	 * @return The signer/observer email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the signer's email.
	 *
	 * @param email The signer/observer email.
	 * @return The current object instance
	 */
	public SignerInfo setEmail(String email)
	{
		this.email = email;
		return this;
	}

	/**
	 * Returns the signer/observer first name.
	 *
	 * @return The signer/observer firstname.
	 */
	public String getfirstname()
	{
		return firstname;
	}

	/**
	 * Sets the signer/observer first name.
	 *
	 * @param firstname The signer/observer firstname.
	 * @return The current object instance
	 */
	public SignerInfo setfirstname(String firstname)
	{
		this.firstname = firstname;
		return this;
	}

	/**
	 * Returns the signer/observer last name.
	 *
	 * @return The signer/observer lastname.
	 */
	public String getlastname()
	{
		return lastname;
	}

	/**
	 * Sets the signer/observer last name.
	 *
	 * @param lastname The signer/observer lastname.
	 * @return The current object instance
	 */
	public SignerInfo setlastname(String lastname)
	{
		this.lastname = lastname;
		return this;
	}

	/**
	 * Returns the action date (signature, cancel or other).
	 *
	 * @return The action date.
	 */
	public Date getActionDate()
	{
		return actionDate;
	}

	/**
	 * Sets the action date.
	 *
	 * @param actionDate The action date.
	 * @return The current object instance
	 */
	public SignerInfo setActionDate(Date actionDate)
	{
		this.actionDate = actionDate;
		return this;
	}

	/**
	 * Returns the indexes list of refused documents.
	 *
	 * @return The indexes list of refused documents.
	 */
	public int[] getRefusedDocs()
	{
		return refusedDocs;
	}

	/**
	 * Sets the indexes list of refused documents.
	 *
	 * @param refusedDocs The indexes list of refused documents.
	 * @return The current object instance
	 */
	public SignerInfo setRefusedDocs(int[] refusedDocs)
	{
		this.refusedDocs = refusedDocs;
		return this;
	}
}
