
package com.universign.javaclient.ra;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the RA class factory.
 *
 */
public class UninstantiatedBeansFactoryTest
{
    @Test
    public void shouldCreateMatchingResultObject()
    {
        //when
        MatchingResult matchingResult = UninstantiatedBeansFactory
                .createMatchingResult("last", "first", "06",
                        "test@test", "high");
        //then
        assertNotNull("is null", matchingResult);
        assertEquals("invalid return", "last",
                matchingResult.getlastname());
        assertEquals("invalid return", "first",
                matchingResult.getfirstname());
        assertEquals("invalid return", "06",
                matchingResult.getMobile());
        assertEquals("invalid return", "test@test",
                matchingResult.getEmail());
        assertEquals("invalid return", "high",
                matchingResult.getCertificateLevel());
    }

    @Test
    public void shouldCreateValidatorResultObject()
    {
        //given
        Map map = new HashMap();
        //when
        ValidatorResult validatorResult = UninstantiatedBeansFactory
                .createValidatorResult("test", 0, 0,
                        "unknown", map);
        //then
        assertNotNull("is null", validatorResult);
        assertEquals("invalid return", "test",
                validatorResult.getId());
        assertEquals("invalid return", 0,
                validatorResult.getStatus());
        assertEquals("invalid return", 0,
                validatorResult.getReason());
        assertEquals("invalid return", "unknown",
                validatorResult.getReasonMessage());
        assertEquals("invalid return", map, validatorResult.getResult());
    }
}
