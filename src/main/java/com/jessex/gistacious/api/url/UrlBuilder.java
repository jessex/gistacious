package com.jessex.gistacious.api.url;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility for constructing the URLs necessary to make calls to the GitHub API.
 * All returned URLs begin with the base URL for the API and end with an 
 * extension that is specific to the intended API request.
 * 
 * @author jessex
 */
public class UrlBuilder {

	private static final String URLBASE = "https://api.github.com";
	
	/** Extensions to be placed on to the ends of the API's base URL. **/
	@SuppressWarnings("serial")
	private static final Map<UrlType, String> URLEXTENSIONS = new 
	HashMap<UrlType, String>() {
		{
			put(UrlType.GIST, "/gists/%s");
			put(UrlType.GIST_STAR, "/gists/%s/star");
			put(UrlType.GIST_FORK, "/gists/%s/fork");
			put(UrlType.USER_GISTS, "/users/%s/gists");
			put(UrlType.PUBLIC_GISTS, "/gists/public");
			put(UrlType.MY_GISTS, "/gists");
			put(UrlType.MY_STARRED_GISTS, "/gists/starred");
			put(UrlType.GIST_COMMENTS, "/gists/%s/comments");
			put(UrlType.SINGLE_COMMENT, "/gists/comments/%s");
			put(UrlType.USER, "/users/%s");
			put(UrlType.USER_ME, "/user");
		}
	};
	
	/**
	 * Returns a specifically crafted URL to be used in calls to the Github API.
	 * Takes in the specific type of URL to be created and the value to be 
	 * inserted into the URL. 
	 * 
	 * For example, to retrieve the URL for finding the Gist with id 11111, one 
	 * would call getURL(UrlType.GIST, "11111").
	 * 
	 * @param urlType type of URL (UrlType) being requested
	 * @param value some value that needs to be placed in the URL
	 * @return String representation of constructed URL
	 */
	public static String getURL(UrlType urlType, String value) {
		if (value.equals(""))  //Cannot accept empty string
			return null; //TODO: change this to throw an exception
		else 
			return URLBASE + String.format(URLEXTENSIONS.get(urlType), value);
	}
	
	/**
	 * Returns a specifically crafted URL to be used in calls to the Github API.
	 * Takes in the specific type of URL to be created. 
	 * 
	 * For example, to retrieve the URL for finding all of the authenticated 
	 * user's gists, one would call getURL(UrlType.MY_GISTS).
	 * 
	 * @param urlType type of URL (UrlType) being requested
	 * @return String representation of constructed URL
	 */
	public static String getURL(UrlType urlType) {
		String extension = URLEXTENSIONS.get(urlType);
		if (extension.contains("%s")) //Needed value for this type
			return null;
		else 
			return URLBASE + extension;
	}
	
	/**
	 * Appends a single name-value parameter pair to the given URL and returns.
	 * The parameter must be passed in as a length-2 String array, with the name
	 * occupying index 0 and the value occupying index 1.
	 * 
	 * @param url base URL to append parameter to
	 * @param parameter parameter passed in as name-value pair
	 * @return String representation of parameter-augmented URL
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
	 *  
	 * @param url base URL to append parameter to
	 * @param parameters parameters passed in as array of name-value pairs
	 * @return String representation of parameter-augmented URL
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
