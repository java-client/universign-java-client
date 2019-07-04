
package com.universign.javaclient.users;

import com.universign.javaclient.UniversignClientException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Tests the users manager.
 *
 */
public final class UsersManagerTest
{
    private XmlRpcClient client;
    private UsersManager usersManager;
    private UsersManager mockedManager;

    @Before
    public void setup()
    {
        client = Mockito.mock(XmlRpcClient.class);
        mockedManager = Mockito.mock(UsersManager.class);
        usersManager = new UsersManager(client);
    }

    @Test
    public void shouldAddUser()
            throws UniversignClientException
    {
        mockedManager.userAdd("test@123");
        verify((mockedManager), atLeastOnce())
                .userAdd("test@123");
    }

    @Test
    public void shouldRelaunchUser()
            throws UniversignClientException
    {
        mockedManager.relaunchUser("test@123");
        verify((mockedManager), atLeastOnce())
                .relaunchUser("test@123");
    }

    @Test
    public void shouldDeleteUser()
            throws UniversignClientException
    {
        mockedManager.deleteUser("test@123");
        verify((mockedManager), atLeastOnce())
                .deleteUser("test@123");
    }

    @Test
    public void shouldReturnListOfUserDetails()
            throws XmlRpcException, UniversignClientException
    {
        Object[] list = new Object[1];
        Map userDetails = new HashMap();
        userDetails.put("firstname", "firstname");
        userDetails.put("lastname", "lastname");
        userDetails.put("status", 0);
        list[0] = userDetails;
        when(client.execute(eq("user.listUsers"),
                any(Object[].class))).thenReturn(list);
        UserDetails[] users = usersManager.listUsers();
        assertNotNull("is null", users);
        assertEquals("incorrect", userDetails.get("firstname"),
                users[0].getfirstname());
        assertEquals("incorrect", userDetails.get("lastname"),
                users[0].getlastname());
        assertEquals("incorrect", userDetails.get("status"),
                users[0].getStatus());
    }

    @Test
    public void shouldReturnPersonnalInformation()
            throws XmlRpcException, UniversignClientException
    {
        Map personnalInfoMap = new HashMap();
        personnalInfoMap.put("userId", "fr123");
        personnalInfoMap.put("admin", true);
        personnalInfoMap.put("contact", true);
        personnalInfoMap.put("firstname", "firstname");
        personnalInfoMap.put("lastname", "lastname");
        personnalInfoMap.put("creationDate", new Date());
        personnalInfoMap.put("lastLogin", new Date());
        personnalInfoMap.put("operatorStatus", 0);
        personnalInfoMap.put("hasCertificate", true);
        personnalInfoMap.put("remainingSignatures", 0);
        personnalInfoMap.put("remainingTimestamps", 0);
        personnalInfoMap.put("remainingServerstamps", 0);
        personnalInfoMap.put("status", 0);
        when(client.execute(eq("user.getPersonnalInformation"),
                any(Object[].class))).thenReturn(personnalInfoMap);
        PersonnalInfo personnalInfo = usersManager
                .getPersonnalInformation();
        assertNotNull("is null", personnalInfo);
        assertEquals("incorrect", personnalInfoMap.get("userId"),
                personnalInfo.getUserId());
        assertEquals("incorrect", personnalInfoMap.get("admin"),
                personnalInfo.isAdmin());
        assertEquals("incorrect", personnalInfoMap.get("contact"),
                personnalInfo.isContact());
        assertEquals("incorrect", personnalInfoMap.get("firstname"),
                personnalInfo.getfirstname());
        assertEquals("incorrect", personnalInfoMap.get("lastname"),
                personnalInfo.getlastname());
        assertEquals("incorrect", personnalInfoMap.get("creationDate"),
                personnalInfo.getCreationDate());
    }

    @Test
    public void shouldReturnTrueIfUserIsInMyOrganization()
            throws XmlRpcException, UniversignClientException
    {
        when(client.execute(eq("user.isUserInMyOrganization"),
                any(Object[].class))).thenReturn(true);
        boolean result = usersManager.isUserInMyOrganization("test");
        assertTrue("is false", result);
    }

    @Test(expected = UniversignClientException.class)
    public void shouldThrowUniversignClientExceptionWhenCannotContactServer()
            throws Exception
    {
        when(client.execute(eq("user.listUsers"),
                any(Object[].class)))
                .thenThrow(new XmlRpcException("connection error"));
        usersManager.listUsers();
    }

    @Test(expected = UniversignClientException.class)
    public void shouldThrowUniversignClientExceptionWhenCannotGetUserList()
            throws Exception
    {
        when(client.execute(eq("user.listUsers"),
                any(Object[].class)))
                .thenThrow(new XmlRpcException("failure get user list"));
        usersManager.listUsers();
    }
}
