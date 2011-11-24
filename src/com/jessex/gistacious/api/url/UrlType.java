package com.jessex.gistacious.api.url;

/**
 * An enumeration of the various types of URLs we will want to hit to make calls
 * to the GitHub Gist API. These are enumerated based on what type of request is
 * being made of the API.
 * 
 * @see UrlBuilder#URLEXTENSIONS
 * 
 * @author jessex
 */
public enum UrlType {
    /** For requesting, editing or deleting a gist */
	GIST,
	
	/** For checking if a gist is starred, or for starring/un-starring a gist */
	GIST_STAR,
	
	/** For forking a gist */
	GIST_FORK,
	
	/** For requesting all the gists of a particular user */
	USER_GISTS,
	
	/** For requesting all public gists */
	PUBLIC_GISTS,
	
	/** For requesting all the gists of the currently authenticated user, or for
	 * creating a new gist */
	MY_GISTS,
	
	/** For requesting all gists starred by the currently authenticated user */
	MY_STARRED_GISTS,
	
	/** For requesting all comments on a gist, or for creating a new comment */
	GIST_COMMENTS,
	
	/** For requesting, editing or deleting a comment */
	SINGLE_COMMENT,
	
	/** For requesting a user */
	USER,
	
	/** For requesting the currently authenticated user */
	USER_ME
}
