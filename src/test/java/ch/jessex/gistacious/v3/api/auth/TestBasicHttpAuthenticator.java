package ch.jessex.gistacious.v3.api.auth;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the basic HTTP authenticator.
 *
 * @author jessex
 */
public class TestBasicHttpAuthenticator {

    private HttpAuthenticator httpAuthenticator;

    @Before
    public void setUp() {
        this.httpAuthenticator = new BasicHttpAuthenticator();
    }

    @Test
    public void testAddCredentialsSuccessful() {
        HttpPost httpPost = new HttpPost();
        this.httpAuthenticator.addAuthenticationCredentials(httpPost, AuthenticationTestUtils.getCredentials("jessex", "sassafras"));

        Header header = httpPost.getFirstHeader("Authorization");
        assertNotNull(header);
        assertEquals("Basic amVzc2V4OnNhc3NhZnJhcw==", header.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCredentialsBadCredentialsNoUserName() {
        this.httpAuthenticator.addAuthenticationCredentials(new HttpGet(), AuthenticationTestUtils.getCredentials(null, "password"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCredentialsBadCredentialsNoPassword() {
        this.httpAuthenticator.addAuthenticationCredentials(new HttpGet(), AuthenticationTestUtils.getCredentials("userName", null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCredentialsNullRequest() {
        this.httpAuthenticator.addAuthenticationCredentials(null, AuthenticationTestUtils.getCredentials("", ""));
    }
}
