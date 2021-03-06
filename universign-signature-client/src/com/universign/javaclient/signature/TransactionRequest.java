
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Contains information and options for a signature transaction creation.
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TransactionRequest
{
	private String profile;
	private String customId;
	private List<TransactionSigner> signers;
	private List<TransactionDocument> documents;
	private boolean mustContactFirstSigner;
	private boolean finalDocSent;
	private boolean finalDocRequesterSent;
	private boolean finalDocObserverSent;
	private String description;
	private SignatureConstants.CertificateType certificateType;
	private SignatureConstants.Language language;
	private SignatureConstants.HandwrittenMode handWrittenSignatureMode;
	private SignatureConstants.ChaningMode chainingMode;
	private List<String> finalDocCCeMails;
	private boolean towStepsRegistration;
	private RedirectionConfig autoValidationRedirection;
	private SignatureConstants.RedirectPolicy redirectPolicy;
	private int redirectWait;
	private boolean autoSendAgreements;
	private String operator;
	private String registrationCallbackURL;

	/**
	 * Returns the name of the signature profile to use.
	 *
	 * @return The profile name.
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Sets the name of the signature profile to use.
	 *
	 * @param profile The profile name.
	 * @return The current object instance
	 */
	public TransactionRequest setProfile(String profile)
	{
		this.profile = profile.trim();
		return this;
	}

	/**
	 * Returns the unique id used by the requester to identify
	 * the transaction.
	 *
	 * @return The transaction custom Id.
	 */
	public String getCustomId()
	{
		return customId;
	}

	/**
	 * Sets the unique id used by the requester to identify the transaction.
	 *
	 * @param customId The custom Id to set.
	 * @return The current object instance
	 */
	public TransactionRequest setCustomId(String customId)
	{
		this.customId = customId.trim();
		return this;
	}

	/**
	 * Returns the list of the signers that will have part of the transaction.
	 *
	 * @return The signers list for the transaction.
	 */
	public List<TransactionSigner> getSigners()
	{
		return signers;
	}

	/**
	 * Sets the list of the signers that will have part of the transaction.
	 * Must have at least one element.
	 *
	 * @param signers The list of signer to set.
	 * @return The current object instance
	 */
	public TransactionRequest setSigners(
			List<TransactionSigner> signers)
	{
		this.signers = signers;
		return this;
	}

	/**
	 * Returns the list of the documents to be signed.
	 *
	 * @return The documents list to be signed.
	 */
	public List<TransactionDocument> getDocuments()
	{
		return documents;
	}

	/**
	 * Sets the list of the documents to be signed.
	 * Must have at least one element.
	 * Size limit for each document is 10Mo.
	 *
	 * @param documents The document list to be signed.
	 * @return The current object instance
	 */
	public TransactionRequest setDocuments(
			List<TransactionDocument> documents)
	{
		this.documents = documents;
		return this;
	}

	/**
	 * Returns <code>true</code> if the first signer will receive
	 * an invitation mail.
	 *
	 * @return The parameter who check if the invitation mail
	 * will be sent to the first signer or not.
	 */
	public boolean getMustContactFirstSigner()
	{
		return mustContactFirstSigner;
	}

	/**
	 * Sets <code>true</code> if the first signer will receive
	 * an invitation mail.
	 * <code>false</code> if not.
	 *
	 * @param mustContactFirstSigner The parameter to set
	 * if the invitation mail will be sent to the first signer.
	 * @return The current object instance
	 */
	public TransactionRequest setMustContactFirstSigner(
			boolean mustContactFirstSigner)
	{
		this.mustContactFirstSigner = mustContactFirstSigner;
		return this;
	}

	/**
	 * Returns <code>true</code> if the signer will receive
	 * the signed document.
	 *
	 * @return The parameter who check if the signer will receive
	 * the signed document or not.
	 */
	public boolean getFinalDocSent()
	{
		return finalDocSent;
	}

	/**
	 * Sets <code>true</code> if the signer will receive the signed document
	 * else <code>false</code>.
	 *
	 * @param finalDocSent The parameter to set if the signer
	 * will receive the signed document.
	 * @return The current object instance
	 */
	public TransactionRequest setFinalDocSent(boolean finalDocSent)
	{
		this.finalDocSent = finalDocSent;
		return this;
	}

	/**
	 * Returns <code>true</code> if the requester will receive
	 * the signed document.
	 *
	 * @return The parameter who check if the requester
	 * will receive the signed document.
	 */
	public boolean getFinalDocRequesterSent()
	{
		return finalDocRequesterSent;
	}

	/**
	 * Sets <code>true</code> if the requester will receive
	 * the signed document else <code>false</code>.
	 *
	 * @param finalDocRequesterSent The parameter to set if the requester
	 * will receive the signed document.
	 * @return The current object instance
	 */
	public TransactionRequest setFinalDocRequesterSent(
			boolean finalDocRequesterSent)
	{
		this.finalDocRequesterSent = finalDocRequesterSent;
		return this;
	}

	/**
	 * Returns <code>true</code> if the observer will receive
	 * the signed document.
	 *
	 * @return The parameter who check if the observer
	 * will receive the signed document.
	 */
	public boolean getFinalDocObserverSent()
	{
		return finalDocObserverSent;
	}

	/**
	 * Sets <code>true</code> if the observer will receive
	 * the signed document else <code>false</code>.
	 *
	 * @param finalDocObserverSent The parameter to set
	 * if the observer will receive the signed document.
	 * @return The current object instance
	 */
	public TransactionRequest setFinalDocObserverSent(
			boolean finalDocObserverSent)
	{
		this.finalDocObserverSent = finalDocObserverSent;
		return this;
	}

	/**
	 * Returns the description or title of the signature.
	 *
	 * @return The signature description.
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the description or title of the signature.
	 *
	 * @param description The signature description to set.
	 * @return The current object instance
	 */
	public TransactionRequest setDescription(String description)
	{
		this.description = description.trim();
		return this;
	}

	/**
	 * Returns the type of the certificate will be used
	 * to perform the signature.
	 *
	 * @return The type of the certificate to use.
	 */
	public SignatureConstants.CertificateType getCertificateType()
	{
		return certificateType;
	}

	/**
	 * Sets the type of the certificate.
	 * The available value are :
	 * <code>local</code> if it's a local certificate
	 * existing on the local post.
	 * <code>certified</code> to allow signer to perform
	 * a certified signature
	 * <code>advanced</code> to allow signer to perform
	 * an advanced signature which requires the same option
	 * as a certified one.
	 * <code>simple</code> to allow signer to perform a simple signature.
	 *
	 * @param certificateType The type of the certificate to set.
	 * @return The current object instance
	 */
	public TransactionRequest setCertificateType(
			SignatureConstants.CertificateType certificateType)
	{
		this.certificateType = certificateType;
		return this;
	}

	/**
	 * Returns the transaction language.
	 *
	 * @return The language of the transaction.
	 */
	public SignatureConstants.Language getLanguage()
	{
		return language;
	}

	/**
	 * Sets the transaction language.
	 * The default value is <code>en</code>.
	 *
	 * @param language The transaction language to set.
	 * @return The current object instance
	 */
	public TransactionRequest setLanguage(
			SignatureConstants.Language language)
	{
		this.language = language;
		return this;
	}

	/**
	 * Returns the mode to enable for the handwritten signature.
	 *
	 * @return The activated mode of handWritten signature.
	 */
	public SignatureConstants
			.HandwrittenMode getHandWrittenSignatureMode()
	{
		return handWrittenSignatureMode;
	}

	/**
	 * Sets the mode to enable for the handwritten signature.
	 * Available value are :
	 * <code>0</code> to disable the handwritten signature.
	 * <code>1</code> to enable the handwritten signature.
	 * <code>2</code> to enable the handwritten signature only if it's
	 * a touch interface.
	 *
	 * @param handWrittenSignatureMode The mode to set.
	 * @return The current object instance
	 */
	public TransactionRequest setHandWrittenSignatureMode(
			SignatureConstants
					.HandwrittenMode handWrittenSignatureMode)
	{
		this.handWrittenSignatureMode = handWrittenSignatureMode;
		return this;
	}

	/**
	 * Returns how the signers are chained during the signing process.
	 *
	 * @return The activated chaining mode.
	 */
	public SignatureConstants.ChaningMode getChainingMode()
	{
		return chainingMode;
	}

	/**
	 * Sets how the signers are chained during the signing process.
	 * The mode can be :
	 * <code>none</code> if that each signer is redirected to the successURL
	 * after signing, there is no invitation mail sent.
	 * <code>email</code> is the default value,
	 * the signers receive an invitation mail.
	 * <code>web</code> enables the linked signature mode,
	 * in this mode, all signers must be physically in the same place.
	 *
	 * @param chainingMode The chaining mode to set.
	 * @return The current object instance
	 */
	public TransactionRequest setChainingMode(
			SignatureConstants.ChaningMode chainingMode)
	{
		this.chainingMode = chainingMode;
		return this;
	}

	/**
	 * Returns the list of addresses allows to receive a copy of the final
	 * signed document.
	 *
	 * @return The addresses list that will receive a copy.
	 */
	public List<String> getFinalDocCCeMails()
	{
		return finalDocCCeMails;
	}

	/**
	 * Sets the list of addresses allows to receive a copy of the final
	 * signed document.
	 *
	 * @param finalDocCCeMails The addresses list to set.
	 * @return The current object instance
	 */
	public TransactionRequest setFinalDocCCeMails(
			List<String> finalDocCCeMails)
	{
		this.finalDocCCeMails = finalDocCCeMails;
		return this;
	}

	/**
	 * Returns <code>true</code> if registration of signers via two steps
	 * registration process are activated.
	 *
	 * @return The parameter who check if two steps registration
	 * is activated.
	 */
	public boolean getTowStepsRegistration()
	{
		return towStepsRegistration;
	}

	/**
	 * Sets <code>true</code> if registration of signers via two steps
	 * registration process are activated.
	 * else <code>false</code>.
	 * default value is <code>false</code>.
	 *
	 * @param towStepsRegistration The parameter to set
	 * for the two steps registration mode.
	 * @return The current object instance
	 */
	public TransactionRequest setTowStepsRegistration(
			boolean towStepsRegistration)
	{
		this.towStepsRegistration = towStepsRegistration;
		return this;
	}

	/**
	 * Returns The redirection config.
	 *
	 * @return The redirection Config.
	 */
	public RedirectionConfig getAutoValidationRedirection()
	{
		return autoValidationRedirection;
	}

	/**
	 * Sets The redirection config.
	 *
	 * @param autoValidationRedirection The redirection config.
	 * @return The current object instance.
	 */
	public TransactionRequest setAutoValidationRedirection(
			RedirectionConfig autoValidationRedirection)
	{
		this.autoValidationRedirection = autoValidationRedirection;
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
	public TransactionRequest setRedirectPolicy(
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
	public TransactionRequest setRedirectWait(int redirectWait)
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
	public TransactionRequest setAutoSendAgreements(
			boolean autoSendAgreements)
	{
		this.autoSendAgreements = autoSendAgreements;
		return this;
	}

	/**
	 * Returns The operator email.
	 *
	 * @return The operator email.
	 */
	public String getOperator()
	{
		return operator;
	}

	/**
	 * Sets the operator email.
	 *
	 * @param operator The operator email.
	 * @return The current object instance.
	 */
	public TransactionRequest setOperator(String operator)
	{
		this.operator = operator.trim();
		return this;
	}

	/**
	 * Returns the registration callback Url.
	 *
	 * @return The registration callback Url.
	 */
	public String getRegistrationCallbackURL()
	{
		return registrationCallbackURL;
	}

	/**
	 * Sets the registration callback Url.
	 *
	 * @param registrationCallbackURL The registration callback Url.
	 * @return The current object instance.
	 */
	public TransactionRequest setRegistrationCallbackURL(
			String registrationCallbackURL)
	{
		this.registrationCallbackURL = registrationCallbackURL.trim();
		return this;
	}
}
