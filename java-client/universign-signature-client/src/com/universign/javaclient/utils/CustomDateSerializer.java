
package com.universign.javaclient.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Date;

/**
 * Describes the custom Jackson library Date serializer
 *
 */
public class CustomDateSerializer extends StdSerializer<Date>
{

    /**
     * The default CustomDateSerializer constructor
     */
    public CustomDateSerializer()
    {
        super(Date.class);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGen,
                          SerializerProvider serProv)
            throws IOException
    {
        jsonGen.writeEmbeddedObject(date);
    }
}
