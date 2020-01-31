
package com.universign.javaclient.users;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import com.universign.javaclient.users.UsersConstants.UsersUrl;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.universign.javaclient.UniversignClientException;

/**
 * Users manager class.
 * Defines the XML-RPC calls for the users service.
 *
 * @author yacoubi
 * @version $Revision:  $
 */
public final class UsersManager
{
	private XmlRpcClient client;

	/**
	 * The manager constructor.
	 *
	 * @param client The XmlRpc Client.
	 */
	public UsersManager(XmlRpcClient client)
	{
		this.client = client;
	}

	/**
	 * A factory method.
	 * To instantiate the UsersManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @param url The server URL connection.
	 * @param connectTimeout The Http connection timeout.
	 * @param readTimeout The Http read timeout.
	 * @return The UserManager instance.
	 * @throws UniversignClientException Universign Exception.
	 */
	public static UsersManager create(String login, String password,
									  UsersUrl url, int connectTimeout,
									  int readTimeout)
			throws UniversignClientException
	{
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setConnectionTimeout(connectTimeout);
			config.setReplyTimeout(readTimeout);
			config.setServerURL(new URL(url.getUrl()));
			config.setBasicUserName(login);
			config.setBasicPassword(password);
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);
			return new UsersManager(client);
		} catch (MalformedURLException e) {
			throw new UniversignClientException(
					"Connection Error", e);
		}
	}

	/**
	 * A factory method.
	 * To instantiate the UsersManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @return The UserManager instance.
	 * @throws UniversignClientException Universign Exception.
	 */
	public static UsersManager create(String login, String password)
			throws UniversignClientException
	{
		return create(login, password, UsersUrl.PROD_URL, 5000, 5000);
	}

	/**
	 * A factory method.
	 * To instantiate the UsersManager.
	 *
	 * @param login The user email address.
	 * @param password The user password.
	 * @param url The server URL connection.
	 * @return The UserManager instance.
	 * @throws UniversignClientException Universign Exception.
	 */
	public static UsersManager create(String login, String password, UsersUrl url)
			throws UniversignClientException
	{
		return create(login, password, url, 5000, 5000);
	}

	/**
	 * Defines the userAdd web service call.
	 *
	 * @param userEmail The email of user to add.
	 * @throws UniversignClientException Universign Exception.
	 */
	public void userAdd(String userEmail)
			throws UniversignClientException
	{
		try {
			client.execute("user.addUser",
					new Object[]{userEmail});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Defines the relaunchUser web service call.
	 *
	 * @param userEmail The email of user to relaunch.
	 * @throws UniversignClientException Universign Exception.
	 */
	public void relaunchUser(String userEmail)
			throws UniversignClientException
	{
		try {
			client.execute("user.relaunchUser",
					new Object[]{userEmail});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Defines the deleteUser web service call.
	 *
	 * @param userEmail The email of the user to delete.
	 * @throws UniversignClientException Universign Exception.
	 */
	public void deleteUser(String userEmail)
			throws UniversignClientException
	{
		try {
			client.execute("user.deleteUser",
					new Object[]{userEmail});
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Defines the listUser web service call.
	 *
	 * @return The user details list.
	 * @throws UniversignClientException Universign Exception.
	 */
	public UserDetails[] listUsers() throws UniversignClientException
	{
		try {
			Object[] result = (Object[])client.execute(
					"user.listUsers", new Object[] {});
			UserDetails[] list = new UserDetails[result.length];
			for (int i = 0; i < result.length; i++) {
				@SuppressWarnings("unchecked")
				Map<String, Object> map =
						(Map<String, Object>)result[i];
				list[i] = UninstantiatedBeansFactory
						.createUserDetails(
								(String)map.get("email"),
								(String)map.get("firstname"),
								(String)map.get("lastname"),
								(Integer)map.get("status"));
			}
			return list;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Defines the getPersonnalInfo web service call.
	 *
	 * @return information about the requester and it's organization.
	 * @throws UniversignClientException Universign Exception.
	 */
	public PersonnalInfo getPersonnalInformation()
			throws UniversignClientException
	{
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> res = (Map<String, Object>)client.execute(
					"user.getPersonnalInformation",
					new Object[]{});
			return UninstantiatedBeansFactory
					.createPersonnalInfo(res);
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request", e);
		}
	}

	/**
	 * Defines the isUserInMyOrganization web service call.
	 *
	 * @param userMail The user e-mail.
	 * @return <code>true</code> if user is in my organisation.
	 * @throws UniversignClientException Universign Exception.
	 */
	public boolean isUserInMyOrganization(String userMail)
			throws UniversignClientException
	{
		Boolean result = false;
		try {
			Object object = client.execute(
					"user.isUserInMyOrganization",
					new Object[]{userMail});
			result = (Boolean)object;
		} catch (XmlRpcException e) {
			throw new UniversignClientException(
					"Invalid Request, try again later", e);
		}
		return result;
	}
}
