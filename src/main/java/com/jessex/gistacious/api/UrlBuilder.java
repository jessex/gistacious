package com.jessex.gistacious.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility for constructing the URLs necessary to make calls to the GitHub API.
 * 
 * @author jessex
 */
class UrlBuilder {

    private static final String URL_BASE = "https://api.github.com/";

    /** Extensions to be placed on to the ends of the API's base URL. */
    @SuppressWarnings("serial")
    private static final Map<UrlType, String> URL_EXTENSIONS = new HashMap<UrlType, String>() {
        {
            put(UrlType.GET_GIST, "gists/%s");
            put(UrlType.GET_USER_GISTS, "users/%s/gists");
            put(UrlType.GET_PUBLIC_GISTS, "gists/public");
            put(UrlType.GET_AUTHENTICATED_USER_GISTS, "gists");
            put(UrlType.GET_AUTHENTICATED_USER_STARRED_GISTS, "gists/starred");

            put(UrlType.CREATE_GIST, "gists");
            put(UrlType.EDIT_GIST, "gists/%s");
            put(UrlType.FORK_GIST, "gists/%s/fork");
            put(UrlType.DELETE_GIST, "gists/%s");

            put(UrlType.STAR_GIST, "gists/%s/star");
            put(UrlType.UNSTAR_GIST, "gists/%s/star");
            put(UrlType.IS_GIST_STARRED, "gists/%s/star");

            put(UrlType.GET_COMMENT, "gists/comments/%s");
            put(UrlType.GET_GIST_COMMENTS, "gists/%s/comments");
            put(UrlType.POST_COMMENT, "gists/%s/comments");
            put(UrlType.EDIT_COMMENT, "gists/comments/%s");
            put(UrlType.DELETE_COMMENT, "gists/comments/%s");
        }
    };

    /**
     * Returns a Gist API URL of the given type with the given URL parameters.
     *
     * @param urlType the type of URL being requested
     * @param parameters any parameter values that needs to be placed in the URL
     * @return String representation of constructed URL
     */
    static String getURL(UrlType urlType, String... parameters) {
        Validator.paramNotNull(urlType, "urlType");

        return URL_BASE + String.format(URL_EXTENSIONS.get(urlType), parameters);
    }
}
