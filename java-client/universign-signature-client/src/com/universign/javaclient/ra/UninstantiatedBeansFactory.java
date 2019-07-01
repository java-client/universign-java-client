
package com.universign.javaclient.ra;

import java.util.Map;

/**
 * Defines the object creation from class used only as a return value.
 *
 */
final class UninstantiatedBeansFactory
{
	private UninstantiatedBeansFactory()
	{
		// Private constructor
	}

	/**
	 * Creates and sets the MatchingResult object.
	 *
	 * @param lastname The matching user lastname.
	 * @param firstname The matching user firstname.
	 * @param mobile The matching user mobile number.
	 * @param email The matching user email.
	 * @param certificateLevel The matching user certificate level.
	 *
	 * @return The created MatchingResult object.
	 */
	static MatchingResult createMatchingResult(String lastname,
			String firstname, String mobile, String email,
			String certificateLevel)
	{
		MatchingResult matchResult = new MatchingResult();
		matchResult.setLastname(lastname)
				.setFirstname(firstname)
				.setMobile(mobile)
				.setEmail(email)
				.setCertificateLevel(certificateLevel);
		return matchResult;
	}

	/**
	 * Creates and sets the ValidatorResult object.
	 *
	 * @param id The validation session Id.
	 * @param status The validation session status.
	 * @param reason The error number.
	 * @param reasonMessage The error message.
	 * @param result The list of failing zones
	 * @return The ValidatorResult Object
	 */
	static ValidatorResult createValidatorResult(String id,
			int status, int reason, String reasonMessage,
			Map<String, Object> result)
	{
		ValidatorResult validatorResult = new ValidatorResult();
		validatorResult.setId(id)
				.setStatus(status)
				.setReason(reason)
				.setReasonMessage(reasonMessage)
				.setResult(result);
		return validatorResult;
	}
}
