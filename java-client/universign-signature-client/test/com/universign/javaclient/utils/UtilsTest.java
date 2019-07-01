
package com.universign.javaclient.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.universign.javaclient.signature.TransactionDocument;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests the Utils class.
 *
 */
public class UtilsTest
{
    private ObjectMapper objectMapper;

    @Before
    public void setup()
    {
        objectMapper = Mockito.mock(ObjectMapper.class);
    }

    @Test
    public void shouldReturnMap()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fileName", "test");
        map.put("url", "test.com/test.pdf");
        map.put("title", "test");

        TransactionDocument transactionDocument =
                new TransactionDocument();
        transactionDocument
                .setFileName("test")
                .setUrl("test.com/test.pdf")
                .setTitle("test");
        when(objectMapper.convertValue(anyObject(), eq(Map.class)))
                .thenReturn(map);
        Map<String, Object> objectToMap = Utils.objectToMap(
                transactionDocument);
        assertNotNull("is null", objectToMap);
        assertEquals("invalid file name return",
                map.get("fileName"),
                objectToMap.get("fileName"));
        assertEquals("invalid url return", map.get("url"),
                objectToMap.get("url"));
        assertEquals("invalid title return", map.get("title"),
                objectToMap.get("title"));
    }

    @Test
    public void shouldReturnObject()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fileName", "test");
        map.put("url", "test.com/test.pdf");
        map.put("title", "test");

        TransactionDocument transactionDocument =
                new TransactionDocument();
        transactionDocument
                .setFileName("test")
                .setUrl("test.com/test.pdf")
                .setTitle("test");
        when(objectMapper.convertValue(anyMap(), eq(Object.class)))
                .thenReturn(transactionDocument);
        TransactionDocument mapToObject = Utils.mapToObject(map,
                TransactionDocument.class);
        assertNotNull("is null", mapToObject);
        assertEquals("invalid file name return",
                map.get("fileName"),
                mapToObject.getFileName());
        assertEquals("invalid url return", map.get("url"),
                mapToObject.getUrl());
        assertEquals("invalid title return", map.get("title"),
                mapToObject.getTitle());
    }
}
