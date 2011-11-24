package com.jessex.gistacious.api.http;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.auth.BasicScheme;

/**
 * Default implementation of the {@link HttpAuthenticator} interface.
 * 
 * @author jessex
 */
public class DefaultAuthenticator implements HttpAuthenticator {

	/** {@inheritDoc} */
	@Override
	public void authenticateRequest(HttpRequestBase request, 
	        AuthenticationCredentialsDTO authenticationCredentialsDTO) {
	    
	    String userName = authenticationCredentialsDTO.getUserName();
	    String password = authenticationCredentialsDTO.getPassword();
	    
		request.addHeader(BasicScheme.authenticate(
				new UsernamePasswordCredentials(userName, password), 
				"UTF-8", false));
	}
}
