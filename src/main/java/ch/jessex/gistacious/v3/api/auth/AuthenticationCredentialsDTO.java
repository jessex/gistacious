package ch.jessex.gistacious.v3.api.auth;

import ch.jessex.gistacious.v3.api.Validator;

/**
 * A DTO containing credentials for authentication as a GitHub user.
 * 
 * @author jessex
 */
public class AuthenticationCredentialsDTO {

    private final String userName;
    private final String password;

    public AuthenticationCredentialsDTO(String userName, String password) {
        Validator.paramNotNull(userName, "userName");
        Validator.paramNotNull(password, "password");

        this.userName = userName;
        this.password = password;
    }

    /**
     * Returns the user name aspect of the credentials.
     * 
     * @return user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the password aspect of the credentials.
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
