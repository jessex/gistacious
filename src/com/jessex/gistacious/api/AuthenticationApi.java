package com.jessex.gistacious.api;

public interface AuthenticationApi {

	HttpAuthenticator getHttpAuthenticator();
	
	void setHttpAuthenticator(HttpAuthenticator auth);
	
}
