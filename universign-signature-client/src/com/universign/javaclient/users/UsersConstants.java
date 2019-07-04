
package com.universign.javaclient.users;

/**
 * Defines the different constants which
 * will be used in the Users package.
 *
 */
public class UsersConstants
{
    /**
     * Server Url connection that can be used.
     */
    public enum UsersUrl
    {
        PROD_URL("https://ws.universign.eu/user/rpc/"),
        TEST_URL("https://sign.test.cryptolog.com/user/rpc/");

        private String url;

        private UsersUrl(String url)
        {
            this.url = url;
        }

        public String getUrl()
        {
            return url;
        }
    }
}
