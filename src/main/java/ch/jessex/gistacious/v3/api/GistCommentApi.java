package ch.jessex.gistacious.v3.api;

import java.io.IOException;
import java.util.List;

import ch.jessex.gistacious.v3.api.auth.AuthenticationCredentialsDTO;
import ch.jessex.gistacious.v3.gist.GistComment;

/**
 * The interface for making calls about Gist comments to the Github Gist API. This is in a separate interface from
 * {@link GistApi GistApi} to reflect the fact that calls to retrieve Gist resources do not include comments on those
 * Gists: they must be retrieved separately.
 * 
 * @author jessex
 */
public interface GistCommentApi {

    /**
     * Returns the list of Gist comments for the Gist with the given id.
     *
     * @param gistId the id of some Gist
     * @return a list of Gist comments
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    List<GistComment> getGistComments(long gistId) throws IOException, GistApiException;

    /**
     * Returns the Gist comment with the given comment id.
     *
     * @param commentId the id of some Gist comment
     * @return a Gist comment
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    GistComment getGistComment(long commentId) throws IOException, GistApiException;

    /**
     * Creates a Gist comment with the given String as its body for the Gist with the given id and returns the new Gist
     * comment.
     *
     * @param gistId the id of the Gist to comment on
     * @param comment the Gist comment to write to the Gist
     * @param credentials the authentication credentials
     * @return the Gist comment written to the Gist
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    GistComment createGistComment(long gistId, String comment, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException;

    /**
     * Edits the Gist comment with the given comment id by changing it the body of the comment into the given String and
     * returns the edited Gist comment.
     *
     * @param commentId the id of the Gist comment to edit
     * @param comment the content to write to the edited Gist comment
     * @param credentials the authentication credentials
     * @return the edited Gist comment
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    GistComment editGistComment(long commentId, String comment, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException;

    /**
     * Deletes the Gist comment with the given comment id.
     *
     * @param commentId the id of the Gist comment to delete
     * @param credentials the authentication credentials
     * @throws IOException if there is an issue connecting to the server
     * @throws GistApiException if there is an error raised by the response from the server
     */
    void deleteGistComment(long commentId, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException;
}
