
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

        /**
         * Returns RaUrl from string value.
         *
         * @param url The Server Url as string.
         * @return RaUrl enum.
         */
        public static RaUrl fromString(String url)
        {
            for (RaUrl raUrl : values()) {
                if (raUrl.url.equals(url)) {
                    return raUrl;
                }
            }
            throw new IllegalArgumentException(
                    "No URL with such value: " + url);
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

        /**
         * Returns IdDocumentTypes from int value.
         *
         * @param type The id document type as int.
         * @return IdDocumentTypes enum
         */
        public static IdDocumentTypes fromInt(int type)
        {
            for (IdDocumentTypes t : values()) {
                if (t.type == type) {
                    return t;
                }
            }
            throw new IllegalArgumentException(
                    "No IdDocumentType with such value: " + type);
        }
    }
}
