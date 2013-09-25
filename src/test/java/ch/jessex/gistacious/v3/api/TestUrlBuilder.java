package ch.jessex.gistacious.v3.api;

import java.util.IllegalFormatException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the URL builder utility.
 *
 * @author jessex
 */
public class TestUrlBuilder {

    @Test
    public void testNoParameters() {
        String url = UrlBuilder.getURL(UrlType.GET_PUBLIC_GISTS);
        assertEquals("https://api.github.com/gists/public", url);
        
        url = UrlBuilder.getURL(UrlType.GET_AUTHENTICATED_USER_GISTS);
        assertEquals("https://api.github.com/gists", url);
    }
    
    @Test
    public void testOneParameter() {
        String url = UrlBuilder.getURL(UrlType.GET_GIST_COMMENTS, "3");
        assertEquals("https://api.github.com/gists/3/comments", url);
        
        url = UrlBuilder.getURL(UrlType.STAR_GIST, "314159");
        assertEquals("https://api.github.com/gists/314159/star", url);
    }

    @Test
    public void testTooManyParametersExcessShouldBeIgnored() {
        String url = UrlBuilder.getURL(UrlType.GET_USER_GISTS, "161803", "399");
        assertEquals("https://api.github.com/users/161803/gists", url);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUrlType() {
        UrlBuilder.getURL(null);
    }

    @Test(expected = IllegalFormatException.class)
    public void testShouldHaveHadParameter() {
        UrlBuilder.getURL(UrlType.POST_COMMENT);
    }
}
