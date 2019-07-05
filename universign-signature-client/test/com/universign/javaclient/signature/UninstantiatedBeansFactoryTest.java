
package com.universign.javaclient.signature;


import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the signature class factory
 *
 */
public class UninstantiatedBeansFactoryTest
{
    @Test
    public void shouldReturnCertificateInfoObject()
    {
        //when
        CertificateInfo certificateInfo = UninstantiatedBeansFactory
                .createCertificateInfo("azert", "azert", "azert");
        //then
        assertNotNull("is null", certificateInfo);
        assertEquals("invalid return", "azert",
                certificateInfo.getSubject());
        assertEquals("invalid return", "azert",
                certificateInfo.getIssuer());
        assertEquals("invalid return", "azert",
                certificateInfo.getSerial());
    }

    @Test
    public void shouldReturnInitiatorInfoObject()
    {
        //when
        InitiatorInfo initiatorInfo = UninstantiatedBeansFactory
                .createInitiatorInfo("azert@azert.com", "azert", "azert");
        //then
        assertNotNull("is null", initiatorInfo);
        assertEquals("invalid return", "azert@azert.com",
                initiatorInfo.getEmail());
        assertEquals("invalid return", "azert",
                initiatorInfo.getFirstname());
        assertEquals("invalid return", "azert",
                initiatorInfo.getLastname());
    }

    @Test
    public void shouldReturnTransactionInfoObject()
    {
        //given
        Map<String,Object> certificateInfo = new HashMap<String, Object>();
        certificateInfo.put("issuer", "certIssuer");
        certificateInfo.put("subject", "certSubject");
        Map<String, Object> signerInfo = new HashMap<String, Object>();
        signerInfo.put("firstName", "test");
        signerInfo.put("lastName", "test");
        signerInfo.put("certificateInfo", certificateInfo);
        Object[] list = new Object[1];
        list[0] = signerInfo;
        Map initiatorInfo = new HashMap();
        initiatorInfo.put("email", "test");
        initiatorInfo.put("firstName", "initiatorFirst");
        initiatorInfo.put("lastName", "initiatorLast");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("signerInfos", list);
        map.put("certificateInfo", certificateInfo);
        map.put("initiatorInfo", initiatorInfo);
        map.put("transactionId", "123456-123456");
        map.put("currentSigner", 0);
        map.put("eachField", true);
        //when
        TransactionInfo transactionInfo = UninstantiatedBeansFactory
                .createTransactionInfo(map);
        //then
        assertNotNull("is null", transactionInfo);
        assertEquals("invalid return", signerInfo.get("email"),
                transactionInfo.getSignerInfos()
                .get(0).getEmail());
        assertEquals("invalid return", signerInfo.get("firstName"),
                transactionInfo.getSignerInfos()
                .get(0).getFirstname());
        assertEquals("invalid return", signerInfo.get("lastName"),
                transactionInfo.getSignerInfos()
                        .get(0).getLastname());
        assertEquals("invalid return", certificateInfo.get("issuer"),
                transactionInfo.getSignerInfos()
                .get(0).getCertificateInfo().getIssuer());
        assertEquals("invalid return", certificateInfo.get("subject"),
                transactionInfo.getSignerInfos()
                        .get(0).getCertificateInfo().getSubject());
        assertEquals("invalid return", initiatorInfo.get("email"),
                transactionInfo.getInitiatorInfo().getEmail());
        assertEquals("invalid return", initiatorInfo.get("firstName"),
                transactionInfo.getInitiatorInfo().getFirstname());
        assertEquals("invalid return", initiatorInfo.get("lastName"),
                transactionInfo.getInitiatorInfo().getLastname());
    }

    @Test
    public void shouldReturnCorrectSignerInfoObject()
    {
        //given
        CertificateInfo certificateInfo = new CertificateInfo();
        certificateInfo.setIssuer("test");
        Map<String, Object> certificateInfoMap =
                new HashMap<String, Object>();
        certificateInfoMap.put("issuer", "test");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("certificateInfo", certificateInfoMap);
        map.put("lastName", "test");
        map.put("firstName", "test");
        map.put("error", "fakeError");
        map.put("actionDate", new Date());
        //when
        SignerInfo signerInfo = UninstantiatedBeansFactory
                .createSignerInfo(map);
        //then
        assertNotNull("is null", signerInfo);
        assertEquals("invalid return", "test",
                signerInfo.getFirstname());
        assertEquals("invalid return", "test",
                signerInfo.getLastname());
        assertEquals("invalid return", "fakeError",
                signerInfo.getError());
        assertEquals("invalid return", certificateInfoMap.get("issuer"),
                signerInfo.getCertificateInfo().getIssuer());
    }
}
