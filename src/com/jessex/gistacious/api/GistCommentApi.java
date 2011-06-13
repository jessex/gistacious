package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import com.jessex.gistacious.gist.GistComment;

public interface GistCommentApi extends AuthenticationApi {

	List<GistComment> getGistComments(long gistId) throws IOException;
	
	GistComment getGistComment(long commentId) throws IOException;
	
	GistComment createGistComment(long gistId, GistComment comment) 
	throws IOException;
	
	GistComment editGistComment(long commentId, GistComment newComment) 
	throws IOException;
	
	void deleteGistComment(long id) throws IOException;
	
}
