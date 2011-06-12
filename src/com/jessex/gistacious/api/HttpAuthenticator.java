package com.jessex.gistacious.api;

import org.apache.http.client.methods.HttpRequestBase;

public interface HttpAuthenticator {

	/**
	 * Adds a basic authentication credential header to the given request.
	 * @param request -
	 * 			request to append authentication credentials to
	 */
	void authenticateRequest(HttpRequestBase request);
	
	String getUser();
	
	void setUser(String user);
	
	String getPassword();
	
	void setPassword(String password);
	
}
