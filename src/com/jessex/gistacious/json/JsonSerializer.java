package com.jessex.gistacious.json;

import java.util.List;

import com.jessex.gistacious.gist.*;

public interface JsonSerializer {

	String serializeJsonFromGist(Gist gist);
	
	String serializeJsonFromGists(List<Gist> gists);
	
	String serializeJsonFromGistComment(GistComment comment);
	
	String serializeJsonFromGistComments(List<GistComment> comments);
	
	String serializeJsonFromUser(GistUser user);
	
}
