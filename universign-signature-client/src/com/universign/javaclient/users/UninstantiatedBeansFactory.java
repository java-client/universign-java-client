
package com.universign.javaclient.users;

import java.util.Date;
import java.util.Map;

/**
 * Defines the object creation from class used only as a return value.
 *
 */
final class UninstantiatedBeansFactory
{
	static final String KEY_USER_ID = "userId";
	static final String KEY_LANGUAGE = "language";
	static final String KEY_PHONE_NUM = "phoneNum";
	static final String KEY_LANDLINE_NUM = "landlineNum";
	static final String KEY_CREATION_DATE = "creationDate";
	static final String KEY_LAST_LOGIN_DATE = "lastLogin";
	static final String KEY_OPERATOR_STATUS = "operatorStatus";
	static final String KEY_ADMIN = "admin";
	static final String KEY_CONTACT = "contact";
	static final String KEY_HAS_CERIFICATE = "hasCertificate";
	static final String KEY_REMAINING_SIGNATURE = "remainingSignatures";
	static final String KEY_REMAINING_TIMESTAMPS = "remainingTimestamps";
	static final String KEY_REMAINING_SERVERSTAMPS =
			"remainingServerStamps";
	static final String KEY_USER_MAIL = "email";
	static final String KEY_FIRSTNAME = "firstname";
	static final String KEY_LASTNAME = "lastname";
	static final String KEY_STATUS = "status";

	private UninstantiatedBeansFactory()
	{
		// Private constructor
	}

	static UserDetails createUserDetails(String email, String firstname,
										 String lastname, int status)
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(email)
				.setFirstname(firstname)
				.setLastname(lastname)
				.setStatus(status);
		return userDetails;
	}

	static PersonnalInfo createPersonnalInfo(Map<String, Object> map)
	{
		//Using Java Map because the parameters number is greater
		//than 8 authorized
		PersonnalInfo persoInfo = new PersonnalInfo();
		persoInfo.setUserId((String)map.get(KEY_USER_ID))
				.setLanguage((String)map.get(KEY_LANGUAGE))
				.setPhoneNum((String)map.get(KEY_PHONE_NUM))
				.setLandlineNum((String)map.get(KEY_LANDLINE_NUM))
				.setCreationDate((Date)map.get(KEY_CREATION_DATE))
				.setLastLogin((Date)map.get(KEY_LAST_LOGIN_DATE))
				.setOperatorStatus((Integer)map.get(
						KEY_OPERATOR_STATUS))
				.setAdmin((Boolean)map.get(KEY_ADMIN))
				.setContact((Boolean)map.get(KEY_CONTACT))
				.setHasCetificate((Boolean)map.get(
						KEY_HAS_CERIFICATE))
				.setRemainingSignatures((Integer)map.get(
						KEY_REMAINING_SIGNATURE))
				.setRemainingTimestamps((Integer)map.get(
						KEY_REMAINING_TIMESTAMPS))
				.setRemainingServerStamps((Integer)map.get(
						KEY_REMAINING_SERVERSTAMPS))
				.setEmail((String)map.get((KEY_USER_MAIL)))
				.setFirstname((String)map.get(KEY_FIRSTNAME))
				.setLastname((String)map.get(KEY_LASTNAME))
				.setStatus((Integer)map.get(KEY_STATUS));
		return persoInfo;
	}
}
