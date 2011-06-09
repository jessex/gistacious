package com.jessex.gistacious.api;

import java.util.HashMap;
import java.util.Map;

public class UrlBuilder {

	private static final String URLBASE = "https://api.github.com";
	private static final String TOKEN = ":replace";
	
	//Types of URLs to be constructed
	public static enum UrlType {
		GIST,
		GIST_STAR,
		GIST_FORK,
		USER_GISTS,
		PUBLIC_GISTS,
		MY_GISTS,
		MY_STARRED_GISTS,
		GIST_COMMENTS,
		SINGLE_COMMENT,
		USER,
		USER_ME
	}
	
	//Extensions to be placed on to the ends of the API's base URL
	@SuppressWarnings("serial")
	private static final Map<UrlType, String> URLEXTENSIONS = new 
	HashMap<UrlType, String>() {
		{
			put(UrlType.GIST, "/gists/:replace");
			put(UrlType.GIST_STAR, "/gists/:replace/star");
			put(UrlType.GIST_FORK, "/gists/:replace/fork");
			put(UrlType.USER_GISTS, "/users/:replace/gists");
			put(UrlType.PUBLIC_GISTS, "/gists/public");
			put(UrlType.MY_GISTS, "/gists");
			put(UrlType.MY_STARRED_GISTS, "/gists/starred");
			put(UrlType.GIST_COMMENTS, "/gists/:replace/comments");
			put(UrlType.SINGLE_COMMENT, "/gists/comments/:replace");
			put(UrlType.USER, "/users/:replace");
			put(UrlType.USER_ME, "/user");
		}
	};
	
	/**
	 * Returns a specifically crafted URL to be used in calls to the Github API.
	 * Takes in the specific type of URL to be created and the value to be 
	 * inserted into the URL. For example, to retrieve the URL for finding the 
	 * Gist with id 11111, one would call getURL(UrlType.GIST, "11111").
	 * @param type -
	 * 			type of URL (UrlType) being requested
	 * @param value -
	 * 			some value that needs to be placed in the URL
	 * @return url -
	 * 			String representation of constructed URL
	 */
	public static String getURL(UrlType type, String value) {
		if (value.equals(""))  //Cannot accept empty string
			return null;
		else 
			return URLBASE + URLEXTENSIONS.get(type).replace(TOKEN, value);
	}
	
	/**
	 * Returns a specifically crafted URL to be used in calls to the Github API.
	 * Takes in the specific type of URL to be created. For example, to retrieve
	 * the URL for finding all of the authenticated user's gists, one would call 
	 * getURL(UrlType.MY_GISTS).
	 * @param type -
	 * 			type of URL (UrlType) being requested
	 * @return url -
	 * 			String representation of constructed URL
	 */
	public static String getURL(UrlType type) {
		String extension = URLEXTENSIONS.get(type);
		if (extension.contains(TOKEN)) //Needed value for this type
			return null;
		else 
			return URLBASE + extension;
	}
	
}
