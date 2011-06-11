package com.jessex.gistacious.api;

import org.apache.http.client.methods.HttpRequestBase;

public interface HttpAuthenticator {

	void authenticateRequest(HttpRequestBase request);
	
}
