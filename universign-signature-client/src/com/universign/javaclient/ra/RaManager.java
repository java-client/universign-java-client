
package com.universign.javaclient.ra;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import com.universign.javaclient.ra.RaConstants.RaUrl;
import com.universign.javaclient.UniversignClientException;
import com.universign.javaclient.utils.Utils;

/**
 * Ra manager class.
 * Defines the XML-RPC calls for the registration service.
 *
 */
public final class RaManager
{
	private XmlRpcClient client;

	/**
	 * The Manager constructor
	 *
	 * @param client The XmlRpcClient.
	 */
	public RaManager(XmlRpcClient client)
	{
		this.client = client;
	}

    /**
     * A factory method.
	 * To instantiate the RaManager.
     *
     * @param login The user email address.
     * @param password The user password.
     * @param url The server URL connection.
     * @param connectTimeout The Http connection timeout.
     * @param readTimeout The Http read timeout.
	 * @return RaManager instance.
     * @throws UniversignClientException Universign Exception.
     */
	public static RaManager create(String login, String password,
								   RaUrl url, int connectTimeout,
								   int readTimeout)
			throws UniversignClientException
	{
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setEnabledForExtensions(true);
			config.setConnectionTimeout(connectTimeout);
			config.setReplyTimeout(readTimeout);
			config.setServerURL(new URL(url.getUrl()));
			config.setBasicUserName(login);
			config.setBasicPassword(password);
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);
			return new RaManager(client);
		} catch (MalformedURLException e) {
			throw new UniversignClientException(
					"Connection Error", e);
		}
	}

	/**
	 * A factory method.
	 * To instantiate the RaManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @return RaManager instance.
	 * @throws UniversignClientException Universign Exception.
	 */
	public static RaManager create(String login, String password)
			throws UniversignClientException
	{
		return create(login, password, RaUrl.PROD_URL, 5000, 5000);
	}

	/**
	 * A factory method.
	 * To instantiate the SignatureManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @param url The server URL connection.
	 * @return RaManager instance.
	 * @throws UniversignClientException Universign Exception.
	 */
	public static RaManager create(String login, String password, RaUrl url)
			throws UniversignClientException
	{
		return create(login, password, url, 5000, 5000);
	}

	/**
	 * Describes the checkOperatorStatus web service call.
	 *
	 * @param email The email of the user to check.
	 * @return The user operator status.
	 * @throws UniversignClientException Universign Exception.
	 */
	public int checkOperatorStatus(String email)
			throws UniversignClientException
	{
		try {
			Object res = (Object)client.execute(
					"ra.checkOperatorStatus",
					new Object[] {email});
			return (Integer)res;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Describes the matchAccount web service call.
	 *
	 * @param filter The filter to apply for this call.
	 * @return The matching user list.
	 * @throws UniversignClientException Universign Exception.
	 */
	@SuppressWarnings("unchecked")
	public MatchingResult[] matchAccount(MatchingFilter filter)
			throws UniversignClientException
	{
		Map<String, Object> filterMap = Utils.objectToMap(filter);
		try {
			Object[] res = (Object[])client.execute(
					"matcher.matchAccount",
					new Object[] {filterMap});
			MatchingResult[] result =
					new MatchingResult[res.length];
			for (int i = 0; i < res.length; i++) {
				Map<String, Object> map = (Map<String, Object>)res[i];
				result[i] = UninstantiatedBeansFactory
						.createMatchingResult((String)map.get("lastname"),
								(String)map.get("firstname"),
								(String)map.get("mobile"),
								(String)map.get("email"),
								(String)map.get("certificateLevel"),
								(String)map.get("certificateStatus"),
								Utils.mapToObject(
										(Map<String, Object>)map.get(
												"certificateInfo"),
										CertificateInfo.class));
			}
			return result;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Describes the getCertificateAgreement web service call.
	 *
	 * @param userEmail The user email.
	 * @return The certificate agreement.
	 * @throws UniversignClientException Universign exception.
	 */
	public byte[] getCertificateAgreement(String userEmail)
			throws UniversignClientException
	{
		try {
			return (byte[])client.execute(
					"ra.getCertificateAgreement",
					new Object[]{userEmail});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"impossible to get the certificate agreement", e);
		}
	}

	/**
	 * Describes the revokeCertificate web service call.
	 *
	 * @param emailOrPhoneNumber The user email or phone number.
	 * @throws UniversignClientException Universign exception.
	 */
	public void revokeCertificate(String emailOrPhoneNumber)
			throws UniversignClientException
	{
		try {
			client.execute("ra.revokeCertificate",
					new Object[]{emailOrPhoneNumber});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"cannot revoke this certificate", e);
		}
	}

	/**
	 * Describes the revokeMyCertificate web service call.
	 *
	 * @throws UniversignClientException Universign exception.
	 */
	public void revokeMyCertificate()
			throws UniversignClientException
	{
		try {
			client.execute("ra.revokeMyCertificate",
					new Object[]{});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"cannot revoke this certificate", e);
		}
	}

	/**
	 * Describes the validate web service call.
	 *
	 * @param validationRequest The structure contains data needed
	 * for validation request.
	 * @return The validation Result.
	 * @throws UniversignClientException Universign Exception.
	 */
	@SuppressWarnings("unchecked")
	public ValidatorResult validate(ValidationRequest validationRequest)
			throws UniversignClientException
	{
		Map<String, Object> requestMap = Utils.objectToMap(
				validationRequest);
		try {
			Map<String, Object> res = (Map<String, Object>)client
					.execute("validator.validate",
							new Object[] {requestMap});
			return UninstantiatedBeansFactory
					.createValidatorResult((String)res.get("id"),
							(Integer)res.get("status"),
							(Integer)res.get("reason"),
							(String)res.get("reason"
									+ "Message"),
							(Map<String, Object>)res.get("result"));
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Describes the getResult web service call.
	 *
	 * @param validationSessionId The id of the validation session
	 * whose result will be retrieved.
	 * @return The result of the validation session matching the given id.
	 * @throws UniversignClientException Universign Exception.
	 */
	@SuppressWarnings("unchecked")
	public ValidatorResult getResult(String validationSessionId)
			throws UniversignClientException
	{
		try {
			Map<String, Object> result = (Map<String, Object>)client
					.execute("validator.getResult",
							new Object[] {validationSessionId});
			return Utils.mapToObject(result, ValidatorResult.class);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}
}
