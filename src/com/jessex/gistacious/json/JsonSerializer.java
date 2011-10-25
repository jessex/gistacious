package com.jessex.gistacious.json;

import java.util.List;

import com.jessex.gistacious.gist.*;

public interface JsonSerializer {

	/**
	 * Serializes and returns JSON-formatted text for a Gist.
	 * 
	 * @param gist Gist object to serialize
	 * @return serialized JSON text
	 */
	String serializeJsonFromGistCreate(Gist gist);
	
	/**
	 * Serializes and returns JSON-formatted text for an edited Gist.
	 * 
	 * @param gist Gist object to serialize
	 * @return serialized JSON text
	 */
	String serializeJsonFromGistEdit(Gist gist, List<GistFile> oldFiles);
	
	/**
	 * Serializes and returns JSON-formatted text for a GistComment.
	 * 
	 * @param comment GistComment object to serialize
	 * @return serialized JSON text
	 */
	String serializeJsonFromGistComment(GistComment comment);
	
}
