package com.jessex.gistacious.json;

import org.json.simple.parser.ParseException;

public interface JsonDeserializer {

	Object deserializeGistFromJson(String json) throws ParseException;
	
	Object deserializeCommentFromJson(String json) throws ParseException;
	
}
