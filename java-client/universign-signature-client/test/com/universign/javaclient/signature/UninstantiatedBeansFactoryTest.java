
package com.universign.universigncs.javaclient.signature;


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
        CertificateInfo certificateInfo = new CertificateInfo();
        certificateInfo.setIssuer("test");
        SignerInfo signerInfo = new SignerInfo();
        signerInfo.setfirstName("test")
                .setlastName("test")
                .setEmail("test")
                .setCertificateInfo(certificateInfo);
        Object[] list = new Object[1];
        list[0] = signerInfo;
        Map initiatorInfo = new HashMap();
        initiatorInfo.put("email", "test");
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
        assertEquals("invalid return", signerInfo.getEmail(),
                transactionInfo.getSignerInfos()
                .get(0).getEmail());
        assertEquals("invalid return", signerInfo.getfirstname(),
                transactionInfo.getSignerInfos()
                .get(0).getfirstname());
        assertEquals("invalid return", certificateInfo.getIssuer(),
                transactionInfo.getSignerInfos()
                .get(0).getCertificateInfo().getIssuer());
        assertEquals("invalid return", initiatorInfo.get("email"),
                transactionInfo.getInitiatorInfo().getEmail());
        assertEquals("invalid return", initiatorInfo.get("firstname"),
                transactionInfo.getInitiatorInfo().getFirstname());
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
        map.put("lastname", "test");
        map.put("firstname", "test");
        map.put("error", "fakeError");
        map.put("actionDate", new Date());
        //when
        SignerInfo signerInfo = UninstantiatedBeansFactory
                .createSignerInfo(map);
        //then
        assertNotNull("is null", signerInfo);
        assertEquals("invalid return", "test",
                signerInfo.getfirstname());
        assertEquals("invalid return", "test",
                signerInfo.getlastname());
        assertEquals("invalid return", "fakeError",
                signerInfo.getError());
        assertEquals("invalid return", certificateInfoMap.get("issuer"),
                signerInfo.getCertificateInfo().getIssuer());
    }
}
