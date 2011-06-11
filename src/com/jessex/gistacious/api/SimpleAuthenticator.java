package com.jessex.gistacious.api;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.auth.BasicScheme;

public class SimpleAuthenticator implements HttpAuthenticator {

	private String user;
	private String password;

	public SimpleAuthenticator(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	/**
	 * Attaches authentication information to a given HTTP method by adding a 
	 * basic username-password credential to the header of the request. Accepts 
	 * any HTTP method which is a subclass of HttpRequestBase, which notably
	 * includes HttpGet, HttpPost, HttpPut and HttpDelete.
	 * @param request -
	 * 			HTTP request to authenticate
	 */
	public void authenticateRequest(HttpRequestBase request) {
		request.addHeader(BasicScheme.authenticate
				(new UsernamePasswordCredentials(this.user, this.password), 
						"UTF-8", false));
	}
	
	/**
	 * Sets the user of this authentication mechanism.
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Returns the user of this authentication mechanism.
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the password of this authentication mechanism.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the password of this authentication mechanism.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	
}
