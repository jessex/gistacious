package ch.jessex.gistacious.v3.api;

import java.io.UnsupportedEncodingException;

import ch.jessex.gistacious.v3.api.auth.AuthenticationCredentialsDTO;
import ch.jessex.gistacious.v3.api.auth.BasicHttpAuthenticator;
import ch.jessex.gistacious.v3.api.auth.HttpAuthenticator;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

/**
 * Constructs HTTP requests to be sent to a server.
 *
 * @author jessex
 */
class RequestBuilder {

    private static final String REQUEST_ENCODING = "UTF-8";
    private static final String INPUT_CONTENT_TYPE = "application/json";

    private static HttpAuthenticator httpAuthenticator = new BasicHttpAuthenticator();

    /**
     * Returns an HTTP GET request to the given URL.
     *
     * @param url the url to make a request to
     * @return a GET request
     */
    static HttpGet buildGetRequest(String url) {
        return new HttpGet(url);
    }

    /**
     * Returns an HTTP GET request to the given URL with the given credentials in its header.
     *
     * @param url the url to make a request to
     * @param credentials the credentials to add to the request
     * @return a GET request with authentication credentials in its header
     */
    static HttpGet buildGetRequest(String url, AuthenticationCredentialsDTO credentials) {
        HttpGet httpGet = new HttpGet(url);
        httpAuthenticator.addAuthenticationCredentials(httpGet, credentials);
        return httpGet;
    }

    /**
     * Returns an HTTP PUT request to the given URL.
     *
     * @param url the url to make a request to
     * @param credentials the credentials to add to the request
     * @return a PUT request
     */
    static HttpPut buildPutRequest(String url, AuthenticationCredentialsDTO credentials) {
        HttpPut httpPut = new HttpPut(url);
        httpAuthenticator.addAuthenticationCredentials(httpPut, credentials);
        return httpPut;
    }

    /**
     * Returns an HTTP DELETE request to the given URL.
     *
     * @param url the url to make a request to
     * @param credentials the credentials to add to the request
     * @return a DELETE request
     */
    static HttpDelete buildDeleteRequest(String url, AuthenticationCredentialsDTO credentials) {
        HttpDelete httpDelete = new HttpDelete(url);
        httpAuthenticator.addAuthenticationCredentials(httpDelete, credentials);
        return httpDelete;
    }

    /**
     * Returns an HTTP POST request to the given URL.
     *
     * @param url the url to make a request to
     * @param credentials the credentials to add to the request
     * @return a POST request
     */
    static HttpPost buildPostRequest(String url, AuthenticationCredentialsDTO credentials) {
        HttpPost httpPost = new HttpPost(url);
        httpAuthenticator.addAuthenticationCredentials(httpPost, credentials);
        return httpPost;
    }

    /**
     * Returns an HTTP POST request to the given URL with the given JSON-formatted input. Returns null if there was a
     * problem with using the default encoding (UTF-8) for the input.
     *
     * @param url the url to make a request to
     * @param json the input to add to the request
     * @param credentials the credentials to add to the request
     * @return a POST request
     */
    static HttpPost buildPostRequest(String url, String json, AuthenticationCredentialsDTO credentials) {
        HttpPost httpPost = new HttpPost(url);

        try {
            addInputToRequest(httpPost, json);
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }

        httpAuthenticator.addAuthenticationCredentials(httpPost, credentials);

        return httpPost;
    }

    /**
     * Adds the given JSON-formatted input to the given HTTP request. The given request should typically be of the type
     * {@link org.apache.http.client.methods.HttpPut HttpPut} or {@link org.apache.http.client.methods.HttpPost
     * HttpPost}.
     *
     * @param httpRequest the request to add the input to
     * @param json the input to add to the request
     * @throws UnsupportedEncodingException if there is a problem with the default encoding (UTF-8)
     */
    static void addInputToRequest(HttpEntityEnclosingRequestBase httpRequest, String json)
            throws UnsupportedEncodingException {

        httpRequest.setHeader("Content-type", INPUT_CONTENT_TYPE);
        httpRequest.setEntity(new StringEntity(json, REQUEST_ENCODING));
    }
}
