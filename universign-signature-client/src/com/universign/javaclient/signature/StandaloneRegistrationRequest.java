
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Contains the information about the signer to register
 * and allows to specify the profile to use.
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StandaloneRegistrationRequest
{
	private String profile;
	private TransactionSigner signer;
	private RedirectionConfig successRedirection;
	private RedirectionConfig cancelRedirection;
	private RedirectionConfig failRedirection;
	private String callback;
	private String operator;
	private RedirectionConfig autoValidationRedirection;
	private SignatureConstants.RedirectPolicy redirectPolicy;
	private int redirectWait;

	/**
	 * Returns the profile name.
	 *
	 * @return The profile name.
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Sets the profile name.
	 *
	 * @param profile The profile name.
	 * @return The current object instance
	 */
	public StandaloneRegistrationRequest setProfile(String profile)
	{
		this.profile = profile.trim();
		return this;
	}

	/**
	 * Returns the signer that will be registered.
	 *
	 * @return The information about signer.
	 */
	public TransactionSigner getSigner()
	{
		return signer;
	}

	/**
	 * Sets the signer that will be registered.
	 *
	 * @param signer The signer information.
	 * @return The current object instance
	 */
	public StandaloneRegistrationRequest setSigner(
			TransactionSigner signer)
	{
		this.signer = signer;
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
	public StandaloneRegistrationRequest setSuccessRedirection(
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
	public StandaloneRegistrationRequest setCancelRedirection(
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
	public StandaloneRegistrationRequest setFailRedirection(
			RedirectionConfig failRedirection)
	{
		this.failRedirection = failRedirection;
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
	public StandaloneRegistrationRequest setAutoValidationRedirection(
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
	public StandaloneRegistrationRequest setRedirectPolicy(
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
	public StandaloneRegistrationRequest setRedirectWait(
			int redirectWait)
	{
		this.redirectWait = redirectWait;
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
	public StandaloneRegistrationRequest setOperator(
			String operator)
	{
		this.operator = operator.trim();
		return this;
	}

	/**
	 * Returns the callback Url.
	 *
	 * @return The callback Url.
	 */
	public String getCallback()
	{
		return callback;
	}

	/**
	 * Sets the callback Url.
	 *
	 * @param callback The callback Url.
	 */
	public StandaloneRegistrationRequest setCallback(
			String callback)
	{
		this.callback = callback;
		return this;
	}
}
