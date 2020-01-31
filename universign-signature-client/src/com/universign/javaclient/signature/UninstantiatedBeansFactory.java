
package com.universign.javaclient.signature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.universign.javaclient.utils.Utils;

/**
 * Defines the object creation from class used only as a return value.
 *
 */
final class UninstantiatedBeansFactory
{
	static final String KEY_SIGNER_STATUS = "status";
	static final String KEY_ERROR = "error";
	static final String KEY_CERT_INFO = "certificateInfo";
	static final String KEY_URL = "url";
	static final String KEY_EMAIL = "email";
	static final String KEY_FIRSTNAME = "firstName";
	static final String KEY_LASTNAME = "lastName";
	static final String KEY_ACTION_DATE = "actionDate";
	static final String KEY_REFUSED_DOCS = "refusedDocs";
	static final String KEY_STATUS = "status";
	static final String KEY_SIGNER_INFOS = "signerInfos";
	static final String KEY_CURRENT_SIGNER = "currentSigner";
	static final String KEY_CREATION_DATE = "creationDate";
	static final String KEY_DESCRIPTION = "description";
	static final String KEY_INITIATOR_INFO = "initiatorInfo";
	static final String KEY_EACH_FIELD = "eachField";
	static final String KEY_CUSTOMID = "customId";
	static final String KEY_TRANSACTIONID = "transactionId";
	static final String KEY_REDIRECT_POLICY = "redirectPolicy";
	static final String KEY_REDIRECT_WAIT = "redirectWait";
	static final String KEY_REFUSAL_COMMENT = "refusalComment";

	private UninstantiatedBeansFactory()
	{
		// Private constructor
	}

	/**
	 * Creates and sets the CertificateInfo object.
	 *
	 * @param subject The subject DN to set.
	 * @param issuer The issuer DN to set.
	 * @param serial The serial number to set.
	 * @return The created CertificateInfo object.
	 */
	static CertificateInfo createCertificateInfo(
			String subject, String issuer, String serial)
	{
		CertificateInfo certInfo = new CertificateInfo();
		certInfo.setSubject(subject)
				.setIssuer(issuer)
				.setSerial(serial);
		return certInfo;
	}

	/**
	 * Creates and sets the InitiatorInfo object.
	 *
	 * @param email The requester email.
	 * @param firstname The requester firstname.
	 * @param lastname The requester lastname.
	 * @return The created InitiatorInfo object.
	 */
	static InitiatorInfo createInitiatorInfo(
			String email, String firstname, String lastname)
	{
		InitiatorInfo initInfo = new InitiatorInfo();
		initInfo.setEmail(email)
				.setFirstname(firstname)
				.setLastname(lastname);
		return initInfo;
	}

	/**
	 * Creates and sets the TransactionInfo object
	 *
	 * @param map The Map contains values of the TransactionInfo
	 * attributes.
	 * @return The created TransactionInfo object
	 */
	@SuppressWarnings("unchecked")
	static TransactionInfo createTransactionInfo(
			Map<String, Object> map)
	{
		//Using Java Map because the parameters number is greater
		//than 8 authorized
		Object[] list = (Object[])map.get(KEY_SIGNER_INFOS);
		List<SignerInfo> listSigner = new ArrayList<SignerInfo>();
		for (int i = 0; i < list.length; i++) {
			Map<String, Object> mapList = Utils
					.objectToMap(list[i]);
			listSigner.add(createSignerInfo(mapList));
		}
		Map<String, Object> initInfoMap = (Map<String, Object>)
				map.get(KEY_INITIATOR_INFO);
		InitiatorInfo initiatorInfo = createInitiatorInfo(
				(String)initInfoMap.get("email"),
				(String)initInfoMap.get("firstName"),
				(String)initInfoMap.get("lastName"));
		return new TransactionInfo()
				.setStatus((String)map.get(KEY_STATUS))
				.setSignerInfos(listSigner)
				.setCurrentSigner(
						(Integer)map.get(KEY_CURRENT_SIGNER))
				.setCreationDate(
						(Date)map.get(KEY_CREATION_DATE))
				.setDescription(
						(String)map.get(KEY_DESCRIPTION))
				.setInitiatorInfo(initiatorInfo)
				.setEachField(
						(Boolean)map.get(KEY_EACH_FIELD))
				.setCustomId((String)map.get(KEY_CUSTOMID))
				.setTransactionId(
						(String)map.get(KEY_TRANSACTIONID))
				.setRedirectPolicy((SignatureConstants.RedirectPolicy)
						map.get(KEY_REDIRECT_POLICY))
				.setRedirectWait(map.get(KEY_REDIRECT_WAIT) != null ?
						(Integer)map.get(KEY_REDIRECT_WAIT) : 5);
	}

	/**
	 * Creates and sets the TransactionResponse object.
	 *
	 * @param url The first signer URL.
	 * @param id The transaction Id.
	 * @return The created TransactionResponse object.
	 */
	static TransactionResponse createTransactionResponse(
			String url, String id)
	{
		return new TransactionResponse()
				.setUrl(url)
				.setId(id);
	}

	/**
	 * Creates and sets the SignerInfo object.
	 *
	 * @param map The Map contains values of the SignerInfo attributes.
	 * @return The created SignerInfo object.
	 */
	@SuppressWarnings("unchecked")
	static SignerInfo createSignerInfo(
			Map<String, Object> map)
	{
		//Using Java Map because the parameters number is greater
		//than 8 authorized
		Map<String, Object> certificateInfoMap = (Map<String, Object>)
				map.get(KEY_CERT_INFO);
		CertificateInfo certificateInfo = null;
		if (certificateInfoMap != null && !certificateInfoMap.isEmpty()) {

			certificateInfo = createCertificateInfo(
					(String)certificateInfoMap.get("subject"),
					(String)certificateInfoMap.get("issuer"),
					(String)certificateInfoMap.get("serial"));
		}
		return new SignerInfo()
				.setStatus((String)map.get(KEY_SIGNER_STATUS))
				.setError((String)map.get(KEY_ERROR))
				.setCertificateInfo(certificateInfo)
				.setUrl((String)map.get(KEY_URL))
				.setEmail((String)map.get(KEY_EMAIL))
				.setFirstname((String)map.get(KEY_FIRSTNAME))
				.setLastname((String)map.get(KEY_LASTNAME))
				.setRefusedDocs((int[])map.get(KEY_REFUSED_DOCS))
				.setActionDate((Date)map.get(KEY_ACTION_DATE))
				.setRefusalComment((String)map.get(KEY_REFUSAL_COMMENT))
				.setRedirectPolicy((SignatureConstants.RedirectPolicy)
						map.get(KEY_REDIRECT_POLICY))
				.setRedirectWait(map.get(KEY_REDIRECT_WAIT) != null ?
						(Integer)map.get(KEY_REDIRECT_WAIT) : 5);
	}
}
