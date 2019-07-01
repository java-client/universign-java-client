
package com.universign.javaclient.ra;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines the different enum which
 * will be used in the Ra package
 *
 */
public class RaConstants
{
    /**
     * Server Url connection that can be used.
     */
    public enum RaUrl
    {
        PROD_URL("https://ws.universign.eu/ra/rpc/"),
        TEST_URL("https://sign.test.cryptolog.com/ra/rpc/");

        private String url;

        private RaUrl(String url)
        {
            this.url = url;
        }

        @JsonValue
        public String getUrl()
        {
            return url;
        }
    }

    /**
     * ID document type that can be used.
     */
    public enum IdDocumentTypes
    {
        FRENCH_ID_CARD(0),
        FRENCH_PASSEPORT(1),
        RESIDENCE_PERMIT(2);

        private int type;

        private IdDocumentTypes(int type)
        {
            this.type = type;
        }

        @JsonValue
        public int getType()
        {
            return type;
        }
    }
}
