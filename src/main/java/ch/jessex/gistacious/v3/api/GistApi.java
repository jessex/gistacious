package ch.jessex.gistacious.v3.api;

import java.io.IOException;
import java.util.List;

import ch.jessex.gistacious.v3.api.auth.AuthenticationCredentialsDTO;
import ch.jessex.gistacious.v3.gist.Gist;
import ch.jessex.gistacious.v3.gist.GistFile;

/**
 * The interface for making calls pertaining to Gists to the GitHub Gist API.
 * 
 * @author jessex
 */
public interface GistApi {

    /**
     * Returns the Gist with the given id.
     * 
     * @param id the id of the desired Gist
     * @return the Gist with the given id
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    Gist getGist(long id) throws IOException, GistApiException;

    /**
     * Returns the list of Gists created by the user with the given user name.
     *
     * @param userName the user name of some user
     * @return the list of Gists by the given user
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
     List<Gist> getUserGists(String userName) throws IOException, GistApiException;

    /**
     * Returns the list of Gists created by the authenticated user.
     *
     * @param credentials the authentication credentials
     * @return the list of Gists by the authenticated user
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    List<Gist> getAuthenticatedUserGists(AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

    /**
     * Returns the list of starred Gists for the authenticated user.
     *
     * @param credentials the authentication credentials
     * @return the list of starred Gists for the authenticated user
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    List<Gist> getAuthenticatedUserStarredGists(AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException;

    /**
     * Returns the list of all public Gists.
     *
     * @return the list of all public Gists
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    List<Gist> getPublicGists() throws IOException, GistApiException;

    /**
     * Creates the given Gist and returns it as she was posted.
     *
     * @param gist the Gist to create
     * @param credentials the authentication credentials
     * @return the created gist
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    Gist createGist(Gist gist, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

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
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    Gist editGist(long id, Gist newGist, List<GistFile> oldFiles, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException;

    /**
     * Forks the gist with the given id and return the forked gist.
     *
     * @param id of the gist to fork
     * @param credentials the authentication credentials
     * @return the forked gist
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    Gist forkGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

    /**
     * Deletes the gist with the given id.
     *
     * @param id the id of the gist to delete
     * @param credentials the authentication credentials
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    void deleteGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

    /**
     * Returns whether or not the gist with the given id has been starred by
     * the currently authenticated user.
     *
     * @param id the id of the gist to check
     * @param credentials the authentication credentials
     * @return whether or not the gist is starred by the currently authenticated
     * user
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    boolean isStarredGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

    /**
     * Stars the gist with the given id for the currently authenticated user.
     *
     * @param id the id of the gist to star
     * @param credentials the authentication credentials
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    void starGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;

    /**
     * Un-stars the gist with the given id for the currently authenticated user.
     *
     * @param id the id of the gist to un-star
     * @param credentials the authentication credentials
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    void unstarGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException;
}
