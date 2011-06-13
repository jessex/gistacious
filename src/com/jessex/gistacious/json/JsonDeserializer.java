package com.jessex.gistacious.json;

import java.util.List;
import com.jessex.gistacious.gist.*;

public interface JsonDeserializer {

	/**
	 * Parses a Gist object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return Gist object
	 */
	Gist deserializeGistFromJson(String json);
	
	/**
	 * Parses a list of Gist objects from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return gists -
	 * 			List of Gist objects
	 */
	List<Gist> deserializeGistsFromJson(String json);
	
	/**
	 * Parses a GistComment object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return GistComment object
	 */
	GistComment deserializeCommentFromJson(String json);
	
	/**
	 * Parses a list of GistComment objects from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return gistComments -
	 * 			List of GistComment objects
	 */
	List<GistComment> deserializeCommentsFromJson(String json);
	
	/**
	 * Parses a GistUser object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return GistUser object
	 */
	GistUser deserializeUserFromJson(String json);
	
}
