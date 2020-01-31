
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the Redirection URL config.
 */
public class RedirectionConfig
{
    private String url;
    private String displayName;

    /**
     * Returns the redirection url.
     *
     * @return Redirection URL.
     */
    @JsonProperty("URL")
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets the redirection url.
     *
     * @param url Redirection URL.
     * @return The current object instance.
     */
    @JsonProperty("URL")
    public RedirectionConfig setUrl(String url)
    {
        this.url = url;
        return this;
    }

    /**
     * Returns the redirection url name.
     *
     * @return Display Name.
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the redirection url name.
     *
     * @param displayName Display Name.
     * @return The current object instance.
     */
    public RedirectionConfig setDisplayName(String displayName)
    {
        this.displayName = displayName;
        return this;
    }
}
