package com.jessex.gistacious.json;

public interface JsonDeserializer {

	/**
	 * Parses a Gist object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return Gist object
	 */
	Object deserializeGistFromJson(String json);
	
	/**
	 * Parses a GistComment object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return GistComment object
	 */
	Object deserializeCommentFromJson(String json);
	
	/**
	 * Parses a GistUser object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return GistUser object
	 */
	Object deserializeUserFromJson(String json);
	
}
