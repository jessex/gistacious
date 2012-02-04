package com.jessex.gistacious.api;

import com.jessex.gistacious.api.http.AuthenticationCredentialsDTO;
import com.jessex.gistacious.api.http.DefaultAuthenticator;
import com.jessex.gistacious.api.http.HttpAuthenticator;
import com.jessex.gistacious.api.http.HttpRequester;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Utilities for use by the various Gist APIs.
 * 
 * @author jessex
 */
public class ApiUtils {
    
    private static HttpAuthenticator authenticator = new DefaultAuthenticator();

    /**
     * Executes a GET HTTP call to the given URL, with the given authentication
     * credentials if necessary. Returns the server's response to the call.
     * 
     * To append authentication credentials to the call, set needsAuthentication
     * to true and wrap the credentials in the given DTO. If no authentication 
     * is necessary, set the boolean to false and pass in a null object for the 
     * DTO.
     * 
     * @param url the URL to make the GET call to
     * @param needsAuthentication whether or not authentication is required
     * @param credentials authentication credentials to use
     * @return the server's response as a String
     * @throws IOException if the server could not be reached
     */
    public static String executeGetCall(String url, boolean needsAuthentication, 
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        HttpGet get = HttpRequester.buildGetRequest(url);
        if (needsAuthentication) 
            authenticator.authenticateRequest(get, credentials);
        
        HttpResponse response = HttpRequester.executeRequest(get);
        
        if (response == null) throw new IOException();
        else {
            if (response.getStatusLine().getStatusCode() != 200) {
                //TODO: Deal with status line issue (possible 404)
            }
            
            return EntityUtils.toString(response.getEntity());
        }
    }
    
    /**
     * Executes a POST HTTP call to the given URL, with the given authentication
     * credentials and the given JSON data to post. 
     * 
     * @param url the URL to make the POST call to
     * @param json the JSON data to post
     * @param credentials authentication credentials to use
     * @return the server's response as a String
     * @throws IOException if the server could not be reached
     */
    public static String executePostCall(String url, String json,
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        HttpPost post = HttpRequester.buildPostRequest(url, json, credentials);
        HttpResponse response = HttpRequester.executeRequest(post);
        
        if (response == null) throw new IOException();
        else {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200 && statusCode != 201) {
                //TODO: Deal with status line issue
            }
            
            return EntityUtils.toString(response.getEntity());
        }
    }
    
}
