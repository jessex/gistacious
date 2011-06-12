package com.jessex.gistacious.api;

import java.util.List;

import com.jessex.gistacious.gist.*;

public interface GistApi extends AuthenticationApi {

	Gist getGist(long id);
	
	List<Gist> getUserGists(String user);
	
	List<Gist> getMyGists();
	
	List<Gist> getMyStarredGists();
	
	List<Gist> getPublicGists();
	
	Gist createGist();
	
	Gist editGist(long id);
	
	Gist forkGist(long id);
	
	void deleteGist();
	
	boolean isStarredGist(long id);
	
	void starGist(long id);
	
	void unstarGist(long id);
	
	
}
