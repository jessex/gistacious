package com.jessex.gistacious.api;

import java.util.Scanner;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import static com.jessex.gistacious.api.auth.AuthenticationTestUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the request builder utility.
 *
 * @author jessex
 */
public class TestRequestBuilder {

    private static final String URL = "https://api.github.com/gists/123";
    private static final String JSON = "{ \"field\" : \"data\" }";

    @Test
    public void testURLAddedCorrectly() {
        HttpGet httpGet = RequestBuilder.buildGetRequest(URL);
        assertEquals(URL, httpGet.getURI().toString());

        HttpPost httpPost = RequestBuilder.buildPostRequest(URL, "", getCredentials(USER_NAME, PASSWORD));
        assertEquals(URL, httpPost.getURI().toString());
    }

    @Test
    public void testJsonAddedCorrectly() throws Exception {
        HttpPost httpPost = RequestBuilder.buildPostRequest(URL, JSON, getCredentials(USER_NAME, PASSWORD));

        String json = new Scanner(httpPost.getEntity().getContent()).useDelimiter("\\A").next();
        assertEquals(JSON, json);

        assertEquals("application/json", httpPost.getFirstHeader("Content-type").getValue());
    }

    @Test
    public void testCredentialsAddedCorrectly() {
        HttpDelete httpDelete = RequestBuilder.buildDeleteRequest(URL, getCredentials(USER_NAME, PASSWORD));

        Header header = httpDelete.getFirstHeader("Authorization");
        assertNotNull(header);
        assertEquals("Basic dXNlck5hbWU6cGFzc3dvcmQ=", header.getValue());
    }
}
