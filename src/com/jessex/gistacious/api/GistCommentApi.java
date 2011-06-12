package com.jessex.gistacious.api;

import java.util.List;

import com.jessex.gistacious.gist.GistComment;

public interface GistCommentApi extends AuthenticationApi {

	List<GistComment> getGistComments(long gistId);
	
	GistComment getGistComment(long commentId);
	
	GistComment createGistComment(long gistId);
	
	GistComment editGistComment(long commentId);
	
	void deleteGistComment();
	
}
