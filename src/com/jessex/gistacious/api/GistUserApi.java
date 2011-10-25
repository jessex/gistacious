package com.jessex.gistacious.api;

import java.io.IOException;

import com.jessex.gistacious.gist.GistUser;

/**
 * The interface for making calls pertaining to gist users to the GitHub 
 * Gist API.
 * 
 * @author jessex
 */
public interface GistUserApi extends AuthenticationApi {

    /**
     * Returns the gist user object for the user with the given user name.
     * 
     * @param user the user name of a user
     * @return gist user with the given user name
     * @throws IOException
     */
	GistUser getUser(String user) throws IOException;
	
	/**
	 * Returns the currently authenticated gist user.
	 * 
	 * @return currently authenticated gist user
	 * @throws IOException
	 */
	GistUser getMyUser() throws IOException;
}
