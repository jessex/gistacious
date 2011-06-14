package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import com.jessex.gistacious.gist.*;

public interface GistApi extends AuthenticationApi {

	Gist getGist(long id) throws IOException;
	
	List<Gist> getUserGists(String user) throws IOException;
	
	List<Gist> getMyGists() throws IOException;
	
	List<Gist> getMyStarredGists() throws IOException;
	
	List<Gist> getPublicGists() throws IOException;
	
	Gist createGist(Gist gist) throws IOException;
	
	Gist editGist(long id, Gist newGist, List<GistFile> oldFiles) 
	throws IOException;
	
	Gist forkGist(long id) throws IOException;
	
	void deleteGist(long id) throws IOException;
	
	boolean isStarredGist(long id) throws IOException;
	
	void starGist(long id) throws IOException;
	
	void unstarGist(long id) throws IOException;
	
	
}
