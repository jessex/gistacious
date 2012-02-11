package com.jessex.gistacious.api.auth;

/**
 * Utilities for assisting in tests with handle authentication.
 *
 * @author jessex
 */
public class AuthenticationTestUtils {

    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";

    /**
     * Creates and returns a new {@link AuthenticationCredentialsDTO} object with the given user name and password.
     *
     * @param userName the user name to use for authentication
     * @param password the password to use for authentication
     * @return the authentication credentials
     */
    public static AuthenticationCredentialsDTO getCredentials(String userName, String password) {
        return new AuthenticationCredentialsDTO(userName, password);
    }
}
