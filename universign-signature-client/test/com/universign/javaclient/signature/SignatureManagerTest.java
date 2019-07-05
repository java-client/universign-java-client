
package com.universign.javaclient.signature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import com.universign.javaclient.UniversignClientException;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.Arrays;

/**
 * Tests the signature manager
 *
 */
public final class SignatureManagerTest
{
    private SignatureManager manager;
    private XmlRpcClient client;
    private SignatureManager mockedManager;

    @Before
    public void setup()
    {
        client = Mockito.mock(XmlRpcClient.class);
        mockedManager = Mockito.mock(
                SignatureManager.class);
        manager = new SignatureManager(client);
    }

    /*@Test
    public void shouldCorrectCreateSignatureManagerInstance()
            throws UniversignClientException
    {
        mockedManager.create("test", "test",
                SignatureConstants.SignatureUrl.TEST_URL,
                1500, 1500);

        verify(mockedManager, atLeastOnce()).create("test",
                "test", SignatureConstants
                        .SignatureUrl.TEST_URL,
                1500, 1500);
    }*/

    @Test
    public void shouldReturnCorrectTransactionRequestResponse()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        Map<String, Object> mockedResult = new HashMap<String, Object>();
        mockedResult.put("id", "test_id");
        mockedResult.put("url", "test_url");
        when(client.execute(eq("requester.requestTransaction"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        DocSignatureField docSignatureField = new DocSignatureField();
        docSignatureField.setSignerIndex(1)
                .setPatternName("test")
                .setPage(-1)
                .setX(150)
                .setY(150);
        List<DocSignatureField> list = new ArrayList<DocSignatureField>();
        list.add(docSignatureField);
        SEPAThirdParty sepaThirdParty = new SEPAThirdParty();
        sepaThirdParty
                .setName("testname")
                .setAddress("testadress")
                .setCountry("testcountry");
        SEPAData sepaData = new SEPAData();
        sepaData.setBic("testbic")
                .setIban("testiban")
                .setRecurring(true)
                .setRum("testRum")
                .setCreditor(sepaThirdParty);
        TransactionDocument transactionDocument = new TransactionDocument();
        transactionDocument.setTitle("title")
                .setSignatureFields(list)
                .setDocumentType(SignatureConstants.DocumentTypes
                        .DOCUMENT_TYPE_SEPA)
                .setSEPAData(sepaData);
        List<TransactionDocument> listDoc =
                new ArrayList<TransactionDocument>();
        listDoc.add(transactionDocument);
        byte mockedId = 100;
        byte[][] mockedIdDocuments = new byte[1][1];
        mockedIdDocuments[0][0] = mockedId;
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setType(SignatureConstants
                .IdDocumentTypes.ID_TYPE_PASSPORT_EU)
                .setDocuments(mockedIdDocuments);
        TransactionSigner transactionSigner = new TransactionSigner();
        transactionSigner.setLastname("test")
                .setFirstname("test")
                .setEmailAddress("test@test.com")
                .setPhoneNum("123")
                .setIdDocuments(registrationRequest)
                .setRole(SignatureConstants.Role.SIGNER);
        List<TransactionSigner> signerList = new ArrayList<TransactionSigner>();
        signerList.add(transactionSigner);
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setProfile("default")
                .setDocuments(listDoc)
                .setSigners(signerList)
                .setChainingMode(SignatureConstants
                        .ChaningMode.CHAINING_MODE_NONE)
                .setFinalDocRequesterSent(false)
                .setCustomId("testId").setCertificateType(
                        SignatureConstants.CertificateType
                                .CERTIFICATE_TYPE_SIMPLE);
        TransactionResponse transactionResponse = manager
                .requestTransaction(transactionRequest);
        //Then
        assertNotNull("is null", transactionResponse);
        assertEquals("invalid id", "test_id",
                transactionResponse.getId());
        assertEquals("invalid url", "test_url",
                transactionResponse.getUrl());
    }

    @Test
    public void shouldReturnCorrectSignResponse()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        byte[] mockedResult = new byte[10];
        new Random().nextBytes(mockedResult);
        when(client.execute(eq("signer.sign"), any(Object[].class)))
                .thenReturn(mockedResult);
        //When
        byte[] document = new byte[10];
        new Random().nextBytes(document);
        byte[] response = manager.sign(document);

        //Then
        assertNotNull("is null", response);
        assertArrayEquals("invalid return", mockedResult, response);
    }

    @Test
    public void shouldReturnCorrectSignWithOptionsResponse()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        byte[] mockedResult = new byte[10];
        new Random().nextBytes(mockedResult);
        when(client.execute(eq("signer.signWithOptions"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        byte[] document = new byte[10];
        new Random().nextBytes(document);
        SignOptions signOptions = new SignOptions();
        signOptions.setProfile("test")
                .setLocation("paris")
                .setLanguage(SignatureConstants.Language.LANGUAGE_FR)
                .setReason("test").setSignatureFormat(
                        SignatureConstants.SignatureFormats
                                .SIGNATURE_FORMAT_PADES)
                .setSignatureFormat(SignatureConstants
                        .SignatureFormats.SIGNATURE_FORMAT_PADES);
        byte[] response = manager.signWithOptions(document, signOptions);
        //Then
        assertNotNull("is null", response);
        assertArrayEquals("invalid return", mockedResult, response);
    }

    @Test
    public void shouldReturnCorrectSignedDocument()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        TransactionDocument[] mockedResult = new TransactionDocument[1];
        when(client.execute(eq("requester.getDocuments"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        TransactionDocument[] response = manager.getDocuments(
                "test1234");
        //Then
        assertNotNull("is null", response);
        assertArrayEquals("Invalid return", mockedResult, response);
    }

    @Test
    public void shouldReturnCorrectSignedDocumentByCustomId()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        TransactionDocument[] mockedResult = new TransactionDocument[1];
        when(client.execute(eq("requester.getDocumentsByCustomId"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        TransactionDocument[] response = manager
                .getDocumentsByCustomId("test1234");
        //Then
        assertNotNull("is null", response);
        assertArrayEquals("Invalid return", mockedResult, response);
    }

    @Test
    public void shouldReturnCorrectTransactionInfo()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        Map<String, Object> mockedResult = new HashMap<String, Object>();
        Map<String, Object> certificateInfo = new HashMap<String, Object>();
        certificateInfo.put("subject", "certificate");
        Map<String, Object> initiatorInfo = new HashMap<String, Object>();
        initiatorInfo.put("firstName", "initiator");
        Map<String, Object> signer = new HashMap<String, Object>();
        signer.put("firstName", "signataire");
        signer.put("certificateInfo", certificateInfo);
        Object[] signerInfos = new Object[1];
        signerInfos[0] = signer;
        mockedResult.put("signerInfos", signerInfos);
        mockedResult.put("initiatorInfo", initiatorInfo);
        mockedResult.put("currentSigner", 0);
        mockedResult.put("eachField", true);
        mockedResult.put("status", "ready");
        when(client.execute(eq("requester.getTransactionInfo"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        TransactionInfo transactionInfo = manager
                .getTransactionInfo("123456");
        //Then
        assertNotNull("is null", transactionInfo);
        assertEquals("invalid return", 0,
                transactionInfo.getCurrentSigner());
        assertEquals("invalid return", "initiator",
                transactionInfo.getInitiatorInfo().getFirstname());
        assertEquals("invalid return", "certificate",
                transactionInfo.getSignerInfos()
                .get(0).getCertificateInfo().getSubject());
        assertEquals("invalid return", "signataire",
                transactionInfo.getSignerInfos()
                .get(0).getFirstname());
        assertTrue("is false", transactionInfo.getEachField());
        assertEquals("invalid return", "ready",
                transactionInfo.getStatus());
    }

    @Test
    public void shouldReturnCorrectTransactionInfoByCustomId()
            throws UniversignClientException, XmlRpcException
    {
        Map<String, Object> mockedResult = new HashMap<String, Object>();
        Map<String, Object> certificateInfo = new HashMap<String, Object>();
        certificateInfo.put("subject", "certificate");
        Map<String, Object> initiatorInfo = new HashMap<String, Object>();
        initiatorInfo.put("firstName", "initiator");
        Map<String, Object> signer = new HashMap<String, Object>();
        signer.put("firstName", "signataire");
        signer.put("certificateInfo", certificateInfo);
        signer.put("lastName", "lastname");
        Object[] signerInfos = new Object[1];
        signerInfos[0] = signer;
        mockedResult.put("signerInfos", signerInfos);
        mockedResult.put("initiatorInfo", initiatorInfo);
        mockedResult.put("currentSigner", 0);
        mockedResult.put("eachField", true);
        mockedResult.put("status", "ready");
        when(client.execute(eq("requester.getTransactionInfoByCustomId"),
                any(Object[].class))).thenReturn(mockedResult);
        //When
        TransactionInfo transactionInfo = manager
                .getTransactionInfoByCustomId("123456");
        //Then
        assertNotNull("is null", transactionInfo);
        assertEquals("invalid return", 0,
                transactionInfo.getCurrentSigner());
        assertEquals("invalid return", "initiator",
                transactionInfo.getInitiatorInfo()
                .getFirstname());
        assertEquals("invalid return", "certificate",
                transactionInfo.getSignerInfos()
                .get(0).getCertificateInfo().getSubject());
        assertEquals("invalid return", "signataire",
                transactionInfo.getSignerInfos()
                .get(0).getFirstname());
        assertEquals("invalid return", "lastname",
                transactionInfo.getSignerInfos()
                        .get(0).getLastname());
        assertTrue("is false", transactionInfo.getEachField());
        assertEquals("invalid return", "ready",
                transactionInfo.getStatus());
    }

    @Test
    public void shouldRelaunchTransaction()
            throws UniversignClientException
    {
        mockedManager.relaunchTransaction("123456");
        verify(mockedManager, atLeastOnce())
                .relaunchTransaction("123456");
    }

    @Test
    public void shouldCancelTransaction()
            throws UniversignClientException
    {
        mockedManager.cancelTransaction("123456");
        verify(mockedManager, atLeastOnce())
                .cancelTransaction("123456");
    }

    @Test
    public void shouldReturnCorrectListOfTransaction()
            throws UniversignClientException, XmlRpcException
    {
        //Given
        Object[] mockedResult = {"tr1", "tr2"};
        when(client.execute(eq("requester.listTransactions"),
                any(Object[].class))).thenReturn(mockedResult);

        // When
        TransactionFilter filter = new TransactionFilter();
        filter.setProfile("test")
                .setRequesterEmail("testemail")
                .setSignerId("test")
                .setStatus(0)
                .setStartRange(1000);
        String[] transactions = manager.listTransactions(filter);
        //Then
        String[] expected = {"tr1", "tr2"};
        assertNotNull("is null", transactions);
        assertArrayEquals("Expected the list of transactions " +
                "[tr1, tr2] but got " + Arrays.toString(transactions),
                expected, transactions);
    }

    @Test
    public void shouldDoingCorrectRegistrationRequest()
            throws XmlRpcException, UniversignClientException
    {
        //Given
        Map<String, Object> mockedResult = new HashMap<String, Object>();
        mockedResult.put("id", "test_id");
        mockedResult.put("url", "test_url");
        when(client.execute(eq("requester.requestRegistration"),
                any(Object[].class)))
                .thenReturn(mockedResult);
        //when
        TransactionSigner transactionSigner = new TransactionSigner();
        transactionSigner
                .setFirstname("signer")
                .setLastname("signerTest")
                .setLanguage(SignatureConstants.Language.LANGUAGE_FR)
                .setEmailAddress("emailAddress")
                .setBirthDate(new Date())
                .setProfile("test")
                .setFailURL("urltest");
        StandaloneRegistrationRequest standalone =
                new StandaloneRegistrationRequest();
        standalone.setProfile("default")
                .setSigner(transactionSigner);
        TransactionResponse transactionResponse =
                manager.requestRegistration(standalone);
        //then
        assertNotNull("is null", transactionResponse);
        assertEquals("invalid id", "test_id",
                transactionResponse.getId());
        assertEquals("invalid url", "test_url",
                transactionResponse.getUrl());
    }

    @Test
    public void shouldCorrectlyRequestTowStepsRegistration()
            throws UniversignClientException
    {
        TransactionSigner transactionSigner = new TransactionSigner();
        transactionSigner
                .setFirstname("signer")
                .setLastname("signerTest")
                .setLanguage(SignatureConstants.Language.LANGUAGE_FR);
        StandaloneRegistrationRequest standalone =
                new StandaloneRegistrationRequest();
        standalone.setProfile("default");
        standalone.setSigner(transactionSigner);
        SignatureManager signatureManager = Mockito
                .mock(SignatureManager.class);
        signatureManager.requestTwoStepsRegistration(standalone);
        verify(signatureManager, atLeastOnce())
                .requestTwoStepsRegistration(standalone);
    }

    @Test(expected = UniversignClientException.class)
    public void shouldThrowUniversignClientExceptionWhenCannotContactServer()
            throws Exception
    {
        // Given
        when(client.execute(eq("requester.getTransactionInfo"),
                any(Object[].class))).thenThrow(
                        new XmlRpcException("connection error"));
        // When
        manager.getTransactionInfo("");
    }
}
