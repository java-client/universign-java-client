
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.universign.javaclient.signature.SignatureConstants.Language;
import com.universign.javaclient.signature.SignatureConstants.CertificateType;
import com.universign.javaclient.signature.SignatureConstants.Role;
import com.universign.javaclient.utils.JsonDateDeserializer;
import com.universign.javaclient.utils.JsonDateSerializer;

import java.util.Date;

/**
 * Describes and contains all information of signer.
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TransactionSigner
{
	private String firstname;
	private String lastname;
	private String organization;
	private String profile;
	private String emailAddress;
	private String phoneNum;
	private Language language;
	private Role role;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date birthDate;
	private String universignId;
	private RedirectionConfig successRedirection;
	private RedirectionConfig cancelRedirection;
	private RedirectionConfig failRedirection;
	private CertificateType certificateType;
	private RegistrationRequest idDocuments;
	private String validationSessionId;
	private SignatureConstants.RedirectPolicy redirectPolicy;
	private int redirectWait;
	private boolean autoSendAgreements;

	/**
	 * Returns the signer firstname.
	 *
	 * @return The signer firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets the signer firstname.
	 *
	 * @param firstname The firstname to set.
	 * @return The current object instance
	 */
	public TransactionSigner setFirstname(String firstname)
	{
		this.firstname = firstname.trim();
		return this;
	}

	/**
	 * Returns the signer lastname.
	 *
	 * @return The signer lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets the signer lastname.
	 *
	 * @param lastname The lastname to set.
	 * @return The current object instance
	 */
	public TransactionSigner setLastname(String lastname)
	{
		this.lastname = lastname.trim();
		return this;
	}

	/**
	 * Returns the signer organization.
	 *
	 * @return The organization name.
	 */
	public String getOrganization()
	{
		return organization;
	}

	/**
	 * Sets the signer organization.
	 *
	 * @param organization The organization name to set.
	 * @return The current object instance
	 */
	public TransactionSigner setOrganization(String organization)
	{
		this.organization = organization.trim();
		return this;
	}

	/**
	 * Returns the name of signature profile.
	 *
	 * @return The profile name.
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Sets the name of the signature profile.
	 *
	 * @param profile The profile name to set.
	 * @return The current object instance
	 */
	public TransactionSigner setProfile(String profile)
	{
		this.profile = profile.trim();
		return this;
	}

	/**
	 * Returns the signer email.
	 *
	 * @return The signer emailAddress.
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * Sets the signer email.
	 *
	 * @param emailAddress The address to set.
	 * @return The current object instance
	 */
	public TransactionSigner setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress.trim();
		return this;
	}

	/**
	 * Returns the signer phone number.
	 *
	 * @return The phone number of signer.
	 */
	public String getPhoneNum()
	{
		return phoneNum;
	}

	/**
	 * Sets the signer phone number.
	 *
	 * @param phoneNum The signer phone number to set.
	 * @return The current object instance
	 */
	public TransactionSigner setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum.trim();
		return this;
	}

	/**
	 * Returns signer language.
	 *
	 * @return The language of signer.
	 */
	public Language getLanguage()
	{
		return language;
	}

	/**
	 * Sets the signer language.
	 *
	 * @param language The language of signer.
	 * @return The current object instance
	 */
	public TransactionSigner setLanguage(Language language)
	{
		this.language = language;
		return this;
	}

	/**
	 * Returns the signer role.
	 *
	 * @return The role of signer.
	 */
	public Role getRole()
	{
		return role;
	}

	/**
	 * Sets the signer role.
	 * Role can be <code>signer</code> or <code>observer</code>.
	 *
	 * @param role The role to set.
	 * @return The current object instance
	 */
	public TransactionSigner setRole(Role role)
	{
		this.role = role;
		return this;
	}

	/**
	 * Returns the signer birthDate.
	 *
	 * @return The signer birthDate.
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}

	/**
	 * Sets the signer birthDate.
	 *
	 * @param birthDate The date to set.
	 * @return The current object instance
	 */
	public TransactionSigner setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Returns the external identifier given by the organization
	 * that indicates the signer.
	 *
	 * @return The Universign Id.
	 */
	public String getUniversignId()
	{
		return universignId;
	}

	/**
	 * Sets the external identifier given by the organization
	 * that indicates the signer.
	 *
	 * @param universignId The external id to set.
	 * @return The current object instance
	 */
	public TransactionSigner setUniversignId(String universignId)
	{
		this.universignId = universignId.trim();
		return this;
	}

	/**
	 * Returns the URL to where the signer will be redirected
	 * after the signatures are completed.
	 *
	 * @return The successURL redirection.
	 */
	public RedirectionConfig getSuccessRedirection()
	{
		return successRedirection;
	}

	/**
	 * Sets the URL to where the signer will be redirected
	 * after the signatures are completed.
	 *
	 * @param successRedirection The redirection url to set.
	 * @return The current object instance
	 */
	public TransactionSigner setSuccessRedirection(
			RedirectionConfig successRedirection)
	{
		this.successRedirection = successRedirection;
		return this;
	}

	/**
	 * Returns the URL to where the signer will be redirected
	 * after the signatures are canceled.
	 *
	 * @return The cancelURL redirection.
	 */
	public RedirectionConfig getCancelRedirection()
	{
		return cancelRedirection;
	}

	/**
	 * Sets the URL to where the signer will be redirected
	 * after the signatures are canceled.
	 *
	 * @param cancelRedirection The redirection url to set.
	 * @return The current object instance
	 */
	public TransactionSigner setCancelRedirection(
			RedirectionConfig cancelRedirection)
	{
		this.cancelRedirection = cancelRedirection;
		return this;
	}

	/**
	 * Returns the URL to where the signer will be redirected
	 * after the signatures are failed.
	 *
	 * @return The failURL redirection.
	 */
	public RedirectionConfig getFailRedirection()
	{
		return failRedirection;
	}

	/**
	 * Sets the URL to where the signer will be redirected
	 * after the signatures are failed.
	 *
	 * @param failRedirection The redirection url to set.
	 * @return The current object instance
	 */
	public TransactionSigner setFailRedirection(
			RedirectionConfig failRedirection)
	{
		this.failRedirection = failRedirection;
		return this;
	}

	/**
	 * Returns the type of the certificate to use.
	 *
	 * @return The certificate type to use.
	 */
	public CertificateType getCertificateType()
	{
		return certificateType;
	}

	/**
	 * Sets the type of the certificate to use.
	 *
	 * @param certificateType The type of certificate to set.
	 * @return The current object instance
	 */
	public TransactionSigner setCertificateType(
			CertificateType certificateType)
	{
		this.certificateType = certificateType;
		return this;
	}

	/**
	 * Returns the ID documents to use in the signer registration.
	 * It's an option for the certified signature.
	 *
	 * @return The ID Documents.
	 */
	public RegistrationRequest getIdDocuments()
	{
		return idDocuments;
	}

	/**
	 * Sets the ID documents to use in the signer registration.
	 *
	 * @param idDocuments The ID documents to set.
	 * @return The current object instance
	 */
	public TransactionSigner setIdDocuments(
			RegistrationRequest idDocuments)
	{
		this.idDocuments = idDocuments;
		return this;
	}

	/**
	 * Returns the id of a valid ID validation Session
	 * from a validation request.
	 *
	 * @return The Id of the validation session.
	 */
	public String getValidationSessionId()
	{
		return validationSessionId;
	}

	/**
	 * Sets the id of a valid ID validation Session.
	 *
	 * @param validationSessionId The id of a validation session to set.
	 * @return The current object instance
	 */
	public TransactionSigner setValidationSessionId(
			String validationSessionId)
	{
		this.validationSessionId = validationSessionId.trim();
		return this;
	}

	/**
	 * Returns the redirectPolicy value.
	 *
	 * @return redirectPolicy.
	 */
	public SignatureConstants.RedirectPolicy getRedirectPolicy()
	{
		return redirectPolicy;
	}

	/**
	 * Sets the redirectPolicy value
	 *
	 * @param redirectPolicy The redirect policy.
	 * @return The current object instance.
	 */
	public TransactionSigner setRedirectPolicy(
			SignatureConstants.RedirectPolicy redirectPolicy)
	{
		this.redirectPolicy = redirectPolicy;
		return this;
	}

	/**
	 * Returns the redirect wait value.
	 *
	 * @return The redirectWait
	 */
	public int getRedirectWait()
	{
		return redirectWait;
	}

	/**
	 * Sets the redirect wait value.
	 *
	 * @param redirectWait The redirectWait.
	 * @return The current object instance.
	 */
	public TransactionSigner setRedirectWait(int redirectWait)
	{
		this.redirectWait = redirectWait;
		return this;
	}

	/**
	 * Returns <code>true</code> if the subscription agreements email
	 * should be automatically sent to signer.
	 *
	 * @return The isAutoSendAgreements value.
	 */
	public boolean isAutoSendAgreements()
	{
		return autoSendAgreements;
	}

	/**
	 * Sets the isAutoSendAgreements value.
	 *
	 * @param autoSendAgreements The isAutoSendAgreements value.
	 * @return The current object instance.
	 */
	public TransactionSigner setAutoSendAgreements(
			boolean autoSendAgreements)
	{
		this.autoSendAgreements = autoSendAgreements;
		return this;
	}
}
