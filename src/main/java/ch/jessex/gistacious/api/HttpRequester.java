package ch.jessex.gistacious.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Executes HTTP requests and returns the server responses.
 * 
 * @author jessex
 */
class HttpRequester {

    private static final HttpClient CLIENT = new DefaultHttpClient();

    /**
     * Executes a given HTTP request and returns the response from the server.
     *
     * @param request the HTTP request to make to some server
     * @return server response to HTTP request
     * @throws IOException if there is an issue with the server connection
     */
    static HttpResponse executeRequest(HttpRequestBase request) throws IOException {
        return CLIENT.execute(request);
    }
}
