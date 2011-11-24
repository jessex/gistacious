package com.jessex.gistacious.api.http;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * Interface for adding authentication credentials to an HTTP request.
 * 
 * @author jessex
 */
public interface HttpAuthenticator {

	/**
     * Attaches authentication information to a given HTTP request by adding a 
     * basic user name-password credential to the header of the request. Accepts 
     * any HTTP method which is a subclass of HttpRequestBase, which notably
     * includes HttpGet, HttpPost, HttpPut and HttpDelete.
     * 
     * @param request HTTP request to append authentication credentials to
     * @param credentials the authentication credentials
     */
	void authenticateRequest(HttpRequestBase request, 
            AuthenticationCredentialsDTO credentials);	
}
