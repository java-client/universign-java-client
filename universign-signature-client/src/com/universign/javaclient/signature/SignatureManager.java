
package com.universign.javaclient.signature;

import com.universign.javaclient.signature.SignatureConstants.SignatureUrl;
import com.universign.javaclient.UniversignClientException;
import com.universign.javaclient.utils.Utils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Signature manager class.
 * Defines the XML-RPC calls for the signature service.
 *
 */
public final class SignatureManager
{
	private XmlRpcClient client;

	/**
	 * The Manager Constructor.
	 *
	 * @param client The XmlRpcClient.
	 */
	public SignatureManager(XmlRpcClient client)
	{
		this.client = client;
	}

	/**
	 * A factory method.
	 * To instantiate the SignatureManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @param url The server URL connection.
	 * @param connectTimeout The Http connection timeout.
	 * @param readTimeout The Http read timeout.
	 * @return SignatureManager instance.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public static SignatureManager create(
			String login, String password, SignatureUrl url,
			int connectTimeout, int readTimeout)
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
			return new SignatureManager(client);
		} catch (MalformedURLException e) {
			throw new UniversignClientException(
					"Connection Error", e);
		}
	}

	/**
	 * A factory method.
	 * To instantiate the SignatureManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @param url The server URL connection.
	 * @return SignatureManager instance.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public static SignatureManager create(
			String login, String password, SignatureUrl url)
			throws UniversignClientException
	{
		return create(login, password, url,
				5000, 5000);
	}

	/**
	 * A factory method.
	 * To instantiate the SignatureManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @return SignatureManager instance.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public static SignatureManager create(String login,
										  String password)
			throws UniversignClientException
	{
		return create(login, password, SignatureUrl.PROD_URL,
				5000, 5000);
	}

	/**
	 * Describes the requestTransaction web service call.
	 *
	 * @param transaction The TransactionRequest Object.
	 * @return The TransactionResponse object.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionResponse requestTransaction(
			TransactionRequest transaction)
			throws UniversignClientException
	{
		Map<String, Object> request =
				Utils.objectToMap(transaction);
		try {
			Map<String, Object> result = (Map<String, Object>)client
					.execute("requester.requestTransaction",
							new Object[]{request});
			return UninstantiatedBeansFactory
					.createTransactionResponse(
							(String)result.get("url"),
							(String)result.get("id"));
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Describes the signer.Sign web service call.
	 *
	 * @param document The document to sign.
	 * @return The TransactionResponse object.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public byte[] sign(byte[] document) throws UniversignClientException
	{
		Object[] param = new Object[1];
		param[0] = document;
		try {
			return (byte[])client.execute(
					"signer.sign", param);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid request", e);
		}
	}

	/**
	 * Describes the signer.signWithOptions web service call.
	 *
	 * @param document The document to sign.
	 * @param options The defined options that will be used
	 * to create a transaction.
	 * @return The TransactionResponse object.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public byte[] signWithOptions(byte[] document,
								  SignOptions options) throws UniversignClientException
	{
		Map<String, Object> opt = Utils.objectToMap(options);
		Object[] params = new Object[2];
		params[0] = document;
		params[1] = opt;
		try {
			return (byte[])client.execute(
					"signer.signWithOptions", params);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid request", e);
		}
	}

	/**
	 * Describes the getDocuments web service call.
	 *
	 * @param transactionId The Id of the transaction
	 * whose document will be retrieved.
	 * @return The retrieved documents.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionDocument[] getDocuments(String transactionId)
			throws UniversignClientException
	{
		try {
			Object[] result = (Object[])client.execute(
					"requester.getDocuments",
					new Object[]{transactionId});
			TransactionDocument[] documents =
					new TransactionDocument[result.length];
			for (int i = 0; i < result.length; i++) {
				Map<String, Object> map =
						(Map<String, Object>)result[i];
				documents[i] = Utils.mapToObject(
						map, TransactionDocument.class);
			}
			return documents;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to retrieve the Documents", e);
		}
	}

	/**
	 * Describes the getDocumentsByCustomId web service call.
	 *
	 * @param customId The CustomId of the transaction
	 * whose document will be retrieved.
	 * @return The retrieved documents.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionDocument[] getDocumentsByCustomId(
			String customId)
			throws UniversignClientException
	{
		try {
			Object[] result = (Object[])client.execute(
					"requester.getDocumentsByCustomId",
					new Object[]{customId});
			TransactionDocument[] documents =
					new TransactionDocument[result.length];
			for (int i = 0; i < result.length; i++) {
				Map<String, Object> map =
						(Map<String, Object>)result[i];
				documents[i] = Utils.mapToObject(
						map, TransactionDocument.class);
			}
			return documents;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to retrieve the Documents", e);
		}
	}

	/**
	 * Describes the requester.getTransactionInfo web service call.
	 *
	 * @param transactionId The transaction ID which informations
	 * will be got.
	 * @return The TransactionInfo structure.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionInfo getTransactionInfo(String transactionId)
			throws UniversignClientException
	{
		try {
			Map<String, Object> result = (Map<String, Object>)client
					.execute("requester.getTransactionInfo",
							new Object[]{transactionId});
			return UninstantiatedBeansFactory
					.createTransactionInfo(result);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to retrieve the transaction"
							+ "information", e);
		}
	}

	/**
	 * Describes the requester.getTransactionInfoByCustomId
	 * web service call.
	 *
	 * @param customId The transaction CustomId which information
	 * will be got.
	 * @return The TransactionInfo structure.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionInfo getTransactionInfoByCustomId(
			String customId) throws UniversignClientException
	{
		try {
			Map<String, Object> result = (Map<String, Object>)client
					.execute("requester.getTransactionInfo"
							+ "ByCustomId",	new Object[]{customId});
			return UninstantiatedBeansFactory
					.createTransactionInfo(result);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to retrieve the transaction"
							+ "information", e);
		}
	}

	/**
	 * Describes the relaunchTransaction web service call.
	 *
	 * @param transactionId The Id of the transaction
	 * to be re launched.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public void relaunchTransaction(String transactionId)
			throws UniversignClientException
	{
		try {
			client.execute("requester.relaunchTransaction",
					new Object[]{transactionId});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to relaunch transaction", e);
		}
	}

	/**
	 * Describes the cancelTransaction web service call.
	 *
	 * @param transactionId The Id of the transaction to be canceled.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public void cancelTransaction(String transactionId)
			throws UniversignClientException
	{
		try {
			client.execute("requester.cancelTransaction",
					new Object[]{transactionId});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to cancel transaction", e);
		}
	}

	/**
	 * Describes the listTransaction web service call.
	 *
	 * @param transactionFilter The filter to apply for this call.
	 * @return The transaction list matching filter.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public String[] listTransactions(TransactionFilter transactionFilter)
			throws UniversignClientException
	{
		Map<String, Object> filter =
				Utils.objectToMap(transactionFilter);
		try {
			Object[] result = (Object[])client.execute(
					"requester.listTransactions",
					new Object[]{filter});
			String[] list = new String[result.length];
			for (int i = 0; i < result.length; i++) {
				list[i] = (String)result[i];
			}
			return list;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Unable to get transaction list", e);
		}
	}

	/**
	 * Describes the requestRegistration web service call.
	 *
	 * @param request The StandaloneRegistrationRequest to send
	 * for this call.
	 * @return The TransactionResponse object.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	@SuppressWarnings("unchecked")
	public TransactionResponse requestRegistration(
			StandaloneRegistrationRequest request)
			throws UniversignClientException
	{
		Map<String, Object> mappedRequest =
				Utils.objectToMap(request);
		try {
			Map<String, Object> result = (Map<String, Object>)client
					.execute("requester.requestRegistration",
							new Object[]{mappedRequest});
			return UninstantiatedBeansFactory
					.createTransactionResponse(
							(String)result.get("url"),
							(String)result.get("id"));
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid request", e);
		}
	}

	/**
	 * Describes the requestTwoStepsRegistration web service call.
	 *
	 * @param request The StandaloneRegistrationRequest to send
	 * for this call.
	 * @throws UniversignClientException Universign Client Exception.
	 */
	public void requestTwoStepsRegistration(
			StandaloneRegistrationRequest request)
			throws UniversignClientException
	{
		Map<String, Object> mappedRequest =
				Utils.objectToMap(request);
		try {
			client.execute("requester.requestTwoStepsRegistration",
					new Object[]{mappedRequest});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid request", e);
		}
	}
}
