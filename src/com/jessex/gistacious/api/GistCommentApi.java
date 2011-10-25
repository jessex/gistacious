package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import com.jessex.gistacious.gist.GistComment;

/**
 * The interface for making calls pertaining to gist comments to the GitHub 
 * Gist API.
 * 
 * @author jessex
 */
public interface GistCommentApi extends AuthenticationApi {

    /**
     * Returns the list of gist comments for the gist with the given id.
     * 
     * @param gistId the id of some gist
     * @return list of gist comments for some gist
     * @throws IOException
     */
	List<GistComment> getGistComments(long gistId) throws IOException;
	
	/**
	 * Returns the gist comment with the given comment id.
	 * 
	 * @param commentId the id of some gist comment
	 * @return gist comment with the given id
	 * @throws IOException
	 */
	GistComment getGistComment(long commentId) throws IOException;
	
	/**
	 * Writes and returns a gist comment from the given comment object for the
	 * gist with the given id.
	 * 
	 * @param gistId the id of the gist to comment on
	 * @param comment the gist comment to write to the gist
	 * @return gist comment written to the gist
	 * @throws IOException
	 */
	GistComment createGistComment(long gistId, GistComment comment) 
	throws IOException;
	
	/**
	 * Edits the gist comment with the given comment id by using the given
	 * comment object.
	 * 
	 * @param commentId the id of the gist comment to edit
	 * @param newComment the gist comment to write over the edited comment
	 * @return edited gist comment
	 * @throws IOException
	 */
	GistComment editGistComment(long commentId, GistComment newComment) 
	throws IOException;
	
	/**
	 * Deletes the gist comment with the given comment id.
	 * 
	 * @param id the id of the gist comment to delete
	 * @throws IOException
	 */
	void deleteGistComment(long id) throws IOException;
}
