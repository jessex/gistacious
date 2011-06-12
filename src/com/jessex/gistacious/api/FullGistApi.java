package com.jessex.gistacious.api;

import java.util.List;

import com.jessex.gistacious.gist.Gist;
import com.jessex.gistacious.gist.GistComment;
import com.jessex.gistacious.gist.GistUser;

public class FullGistApi implements GistApi, GistCommentApi, GistUserApi {

	private HttpAuthenticator authenticator;
	
	public FullGistApi() {
		
	}
	
	@Override
	public HttpAuthenticator getHttpAuthenticator() {
		return this.authenticator;
	}

	@Override
	public void setHttpAuthenticator(HttpAuthenticator auth) {
		this.authenticator = auth;
	}

	@Override
	public GistUser getUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GistUser getMyUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GistComment> getGistComments(long gistId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GistComment getGistComment(long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GistComment createGistComment(long gistId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GistComment editGistComment(long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGistComment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gist getGist(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gist> getUserGists(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gist> getMyGists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gist> getMyStarredGists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gist> getPublicGists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gist createGist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gist editGist(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gist forkGist(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGist() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isStarredGist(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void starGist(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unstarGist(long id) {
		// TODO Auto-generated method stub
		
	}

}
