package com.jessex.gistacious.json;

import java.util.List;

import com.jessex.gistacious.gist.*;

public interface JsonSerializer {

	String serializeJsonFromGistCreate(Gist gist);
	
	String serializeJsonFromGistEdit(Gist gist, List<GistFile> oldFiles);
	
	String serializeJsonFromGistComment(GistComment comment);
	
}
