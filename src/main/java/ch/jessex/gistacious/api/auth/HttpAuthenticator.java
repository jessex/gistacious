package ch.jessex.gistacious.api.auth;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * Interface for adding authentication credentials to an HTTP request.
 * 
 * @author jessex
 */
public interface HttpAuthenticator {

    /**
     * Adds authentication credentials to the given HTTP request.
     * 
     * @param request the HTTP request to add authentication credentials to
     * @param credentials the authentication credentials to add
     */
    void addAuthenticationCredentials(HttpRequestBase request, AuthenticationCredentialsDTO credentials);
}
