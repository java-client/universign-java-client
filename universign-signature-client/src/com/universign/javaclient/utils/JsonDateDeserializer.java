
package com.universign.javaclient.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describes the custom Jackson library Date deserializer
 *
 */
public class JsonDateDeserializer extends StdDeserializer<Date>
{
    private SimpleDateFormat formatter =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * The default JsonDteDeserializer constructor
     */
    public JsonDateDeserializer()
    {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext context)
            throws IOException, RuntimeException
    {
        String date = jsonparser.getText();
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
