
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
public class CustomDateDeserializer extends StdDeserializer<Date>
{
    private SimpleDateFormat formatter =
            new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    /**
     * The default CustomDteDeserializer constructor
     */
    public CustomDateDeserializer()
    {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext context)
            throws IOException, RuntimeException
    {
        String date = jsonparser.getValueAsString();
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
