
package com.universign.javaclient.ra;

import com.universign.javaclient.UniversignClientException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Tests the Ra manager
 *
 */
public class RaManagerTest
{
    private XmlRpcClient client;
    private RaManager raManager;
    private RaManager mockedManager;

    @Before
    public void setup()
    {
        client = Mockito.mock(XmlRpcClient.class);
        mockedManager = Mockito.mock(RaManager.class);
        raManager = new RaManager(client);
    }

    /*@Test
    public void shouldCreateRaManagerInstance()
            throws UniversignClientException
    {
        mockedManager.create("test", "test",
                RaConstants.RaUrl.TEST_URL, 1500, 1500);
        verify(mockedManager, atLeastOnce()).create("test",
                "test", RaConstants.RaUrl.TEST_URL, 1500, 1500);
    }*/

    @Test
    public void shouldReturnTheOperatorStatus()
            throws XmlRpcException, UniversignClientException
    {
        //Given
        int mockedResult = 0;
        when(client.execute(eq("ra.checkOperatorStatus"),
                any(Object[].class))).thenReturn(mockedResult);
        //when
        int result = raManager.checkOperatorStatus("test@test");
        //then
        assertNotNull("is null", result);
        assertEquals("invalid return", 0, result);
    }

    @Test
    public void shouldReturnArrayOfMatchingResult()
            throws XmlRpcException, UniversignClientException
    {
        Object[] matchingResults = new Object[1];
        Map<String, Object> matching = new HashMap<String, Object>();
        matching.put("lastname", "lastname");
        matching.put("firstname", "firstname");
        matching.put("email", "email@email");
        matchingResults[0] = matching;
        MatchingFilter matchingFilter = new MatchingFilter();
        matchingFilter.setFirstname("firstname")
                .setLastname("lastname");
        when(client.execute(eq("matcher.matchAccount"),
                any(Object[].class))).thenReturn(matchingResults);
        MatchingResult[] results = raManager.matchAccount(matchingFilter);
        MatchingResult matchRes = UninstantiatedBeansFactory
                .createMatchingResult((String)matching.get("lastname"),
                        (String)matching.get("firstname"), null,
                        (String)matching.get("email"), null);
        assertNotNull("is null", results);
        assertTrue("is false", results[0] instanceof MatchingResult);
        assertEquals("invalid return", matchRes.getLastname(),
                results[0].getLastname());
        assertEquals("invalid return", matchRes.getEmail(),
                results[0].getEmail());
        assertEquals("invalid return", matchRes.getFirstname(),
                results[0].getFirstname());
    }

    @Test
    public void shouldGetCertificateAgreementAsByteArray()
            throws XmlRpcException, UniversignClientException
    {
        byte[] mockedResult = new byte[10];
        new Random().nextBytes(mockedResult);
        when(client.execute(eq("ra.getCertificateAgreement"),
                any(Object[].class))).thenReturn(mockedResult);
        byte[] result = raManager.getCertificateAgreement(
                "test@test");
        assertNotNull("is null", result);
        assertArrayEquals("invalid return", mockedResult, result);
    }

    @Test
    public void shouldRevokeCertificate()
            throws UniversignClientException
    {
        mockedManager.revokeCertificate("test06");
        verify(mockedManager, atLeastOnce())
                .revokeCertificate("test06");
    }

    @Test
    public void shouldRevokeMyCertificate()
            throws UniversignClientException
    {
        mockedManager.revokeMyCertificate();
        verify(mockedManager, atLeastOnce())
                .revokeMyCertificate();
    }

    @Test
    public void shouldSentValidationRequestAndReturnValidationResult()
            throws XmlRpcException, UniversignClientException
    {
        Map mockedResult = new HashMap();
        mockedResult.put("id", "id123");
        mockedResult.put("status", 1);
        mockedResult.put("reason", 1);
        when(client.execute(eq("validator.validate"),
                any(Object[].class))).thenReturn(mockedResult);
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstname("firstname")
                .setLastname("lastname");
        IdDocument idDocument = new IdDocument();
        idDocument.setType(RaConstants.IdDocumentTypes.FRENCH_PASSEPORT);
        ValidationRequest validationRequest = new ValidationRequest();
        validationRequest.setCallbackURL("callback")
                .setAllowManual(true)
                .setPersonalInfo(personalInfo)
                .setIdDocument(idDocument);
        ValidatorResult validatorResult = raManager.validate(validationRequest);
        assertNotNull("is null", validatorResult);
        assertEquals("incorrect", "id123", validatorResult.getId());
        assertEquals("incorrect", 1, validatorResult.getStatus());
        assertEquals("incorrect", 1, validatorResult.getReason());
    }

    @Test
    public void shouldReturnValidationResultBySessionId()
            throws XmlRpcException, UniversignClientException
    {
        Map mockedResult = new HashMap();
        mockedResult.put("id", "id123");
        mockedResult.put("status", 1);
        mockedResult.put("reason", 1);
        when(client.execute(eq("validator.getResult"),
                any(Object[].class))).thenReturn(mockedResult);
        ValidatorResult validatorResult = raManager.getResult(
                "testSession123456");
        assertNotNull("is null", validatorResult);
        assertEquals("incorrect", "id123", validatorResult.getId());
        assertEquals("incorrect", 1, validatorResult.getStatus());
        assertEquals("incorrect", 1, validatorResult.getReason());
    }

    @Test(expected = UniversignClientException.class)
    public void shouldThrowUniversignClientExceptionWhenCannotContactServer()
            throws Exception
    {
        // Given
        when(client.execute(eq("ra.revokeMyCertificate"),
                any(Object[].class))).thenThrow(
                        new XmlRpcException("connection error"));
        // When
        raManager.revokeMyCertificate();
    }
}
