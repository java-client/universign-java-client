
package com.universign.javaclient.users;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test the User UninstantiatedBeans Factory.
 *
 */
public class UninstantiatedBeansFactoryTest
{
    @Test
    public void shouldReturnUserDetailsObject()
    {
        UserDetails userDetails = UninstantiatedBeansFactory
                .createUserDetails("test@test", "prenomTest",
                        "nomTest", 0);
        assertNotNull("is null", userDetails);
        assertEquals("incorrect", "test@test",
                userDetails.getEmail());
        assertEquals("incorrect", "prenomTest",
                userDetails.getfirstname());
        assertEquals("incorrect", "nomTest", userDetails.getlastname());
        assertEquals("incorrect", 0, userDetails.getStatus());
    }

    @Test
    public void shouldReturnPersonnalInfoObject()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", "fr123");
        map.put("admin", true);
        map.put("contact", true);
        map.put("creationDate", new Date());
        map.put("lastLogin", new Date());
        map.put("operatorStatus", 0);
        map.put("hasCertificate", true);
        map.put("remainingSignatures", 0);
        map.put("remainingTimestamps", 0);
        map.put("remainingServerstamps", 0);
        map.put("status", 0);
        map.put("firstname", "firstname");
        map.put("lastname", "lastname");
        PersonnalInfo personnalInfo = UninstantiatedBeansFactory
                .createPersonnalInfo(map);
        assertNotNull("is null", personnalInfo);
        assertEquals("incorrect", map.get("userId"),
                personnalInfo.getUserId());
        assertEquals("incorrect", map.get("admin"),
                personnalInfo.isAdmin());
        assertEquals("incorrect", map.get("contact"),
                personnalInfo.isContact());
        assertEquals("incorrect", map.get("firstname"),
                personnalInfo.getfirstname());
        assertEquals("incorrect", map.get("lastname"),
                personnalInfo.getlastname());
        assertEquals("incorrect", map.get("creationDate"),
                personnalInfo.getCreationDate());
        assertEquals("incorrect", map.get("firstname"),
                personnalInfo.getfirstname());
        assertEquals("incorrect", map.get("lastname"),
                personnalInfo.getlastname());
        assertTrue("is False", personnalInfo.isHasCetificate());
    }
}
