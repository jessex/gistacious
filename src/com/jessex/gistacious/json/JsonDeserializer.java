package com.jessex.gistacious.json;

public interface JsonDeserializer {

	Object deserializeGistFromJson(String json);
	
	Object deserializeCommentFromJson(String json);
	
	Object deserializeUserFromJson(String json);
	
}
