package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import com.jessex.gistacious.api.http.AuthenticationCredentialsDTO;
import com.jessex.gistacious.gist.*;

/**
 * The interface for making calls pertaining to gists to the GitHub Gist API.
 * 
 * @author jessex
 */
public interface GistApi {

    /**
     * Returns the gist with the given id.
     * 
     * @param id the id of the desired gist
     * @return gist with the given id
     * @throws IOException
     */
	Gist getGist(long id) throws IOException;
	
	/**
	 * Returns the list of gists created by the gist user with the given user 
	 * name.
	 * 
	 * @param user the user name of some user
	 * @return list of gists created by the given user
	 * @throws IOException
	 */
	List<Gist> getUserGists(String user) throws IOException;
	
	/**
	 * Returns the list of gists created by the currently authenticated user.
	 * 
	 * @param credentials the authentication credentials
	 * @return list of gists by the currently authenticated user
	 * @throws IOException
	 */
	List<Gist> getMyGists(AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Returns the list of starred gists for the currently authenticated user.
	 * 
	 * @param credentials the authentication credentials
	 * @return list of starred gists for the currently authenticated user
	 * @throws IOException
	 */
	List<Gist> getMyStarredGists(AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Returns the list of all public gists.
	 * 
	 * @return list of all public gists
	 * @throws IOException
	 */
	List<Gist> getPublicGists() throws IOException;
	
	/**
	 * Creates and returns the given gist object.
	 * 
	 * @param gist the gist to create
	 * @param credentials the authentication credentials
	 * @return the created gist
	 * @throws IOException
	 */
	Gist createGist(Gist gist, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Edits and returns the given gist with the given id. The list of files 
	 * from the previous revision of the gist is used to determine the precise
	 * nature of the edit.
	 * 
	 * @param id the id of the gist
	 * @param newGist the gist to be written over the edited gist
	 * @param oldFiles the list of files from the previous version of the gist
	 * @param credentials the authentication credentials
	 * @return the edited gist
	 * @throws IOException
	 */
	Gist editGist(long id, Gist newGist, List<GistFile> oldFiles,
	    AuthenticationCredentialsDTO credentials) throws IOException;
	
	/**
	 * Forks the gist with the given id and return the forked gist.
	 * 
	 * @param id of the gist to fork
	 * @param credentials the authentication credentials
	 * @return the forked gist
	 * @throws IOException
	 */
	Gist forkGist(long id, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Deletes the gist with the given id.
	 * 
	 * @param id the id of the gist to delete
	 * @param credentials the authentication credentials
	 * @throws IOException
	 */
	void deleteGist(long id, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Returns whether or not the gist with the given id has been starred by
	 * the currently authenticated user.
	 * 
	 * @param id the id of the gist to check
	 * @param credentials the authentication credentials
	 * @return whether or not the gist is starred by the currently authenticated
	 * user
	 * @throws IOException
	 */
	boolean isStarredGist(long id, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Stars the gist with the given id for the currently authenticated user.
	 * 
	 * @param id the id of the gist to star
	 * @throws IOException
	 */
	void starGist(long id, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
	
	/**
	 * Un-stars the gist with the given id for the currently authenticated user.
	 * 
	 * @param id the id of the gist to un-star
	 * @param credentials the authentication credentials
	 * @throws IOException
	 */
	void unstarGist(long id, AuthenticationCredentialsDTO credentials) 
	    throws IOException;
}