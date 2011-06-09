package com.jessex.gistacious.api;

import java.util.HashMap;
import java.util.Map;

public class UrlBuilder {

	private static final String URLBASE = "https://api.github.com";
	private static final String TOKEN = ":replace";
	
	/** Types (categorized by purpose) of URLs to be constructed. **/
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
	
	/** Extensions to be placed on to the ends of the API's base URL. **/
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
	
	/**
	 * Appends a single name-value parameter pair to the given URL and returns.
	 * The parameter must be passed in as a length-2 String array, with the name
	 * occupying index 0 and the value occupying index 1.
	 * @param url -
	 * 			base URL to append parameter to
	 * @param parameter -
	 * 			parameter passed in as name-value pair
	 * @return newUrl -
	 * 			String representation of parameter-augmented URL
	 */
	public static String appendParameter(String url, String[] parameter) {
		if (parameter.length != 2) return url;
		
		StringBuilder sb = new StringBuilder(url);
		sb.append("?" + parameter[0]);
		sb.append("=" + parameter[1]);
		return sb.toString();
	}
	
	/**
	 * Appends an array of name-value parameter pairs to the given URL and 
	 * returns. The parameters must be passed in as a String array where each
	 * entry is of length 2, with the name occupying index [i][0] and the value
	 * occupying index [i][1] for each entry at index i. 
	 * @param url -
	 * 			base URL to append parameter to
	 * @param parameters -
	 * 			parameters passed in as array of name-value pairs
	 * @return newUrl -
	 * 			String representation of parameter-augmented URL
	 */
	public static String appendParameters(String url, String[][] parameters) {
		if (parameters.length < 1) return url;
		else if (parameters[0].length != 2) return url;
		
		StringBuilder sb = new StringBuilder(url);
		sb.append("?" + parameters[0][0]);
		sb.append("=" + parameters[0][1]);
		int length = parameters.length;
		for (int i=1; i<length; i++) {
			sb.append("&" + parameters[i][0]);
			sb.append("=" + parameters[i][1]);
		}
		return sb.toString();
	}
	
}
