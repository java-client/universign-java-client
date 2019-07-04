
package com.universign.javaclient.signature;

/**
 * Contains the information about the signer to register
 * and allows to specify the profile to use.
 *
 */
public class StandaloneRegistrationRequest
{
	private String profile;
	private TransactionSigner signer;

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
}
