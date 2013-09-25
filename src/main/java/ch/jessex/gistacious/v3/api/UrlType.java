package ch.jessex.gistacious.v3.api;

/**
 * An enumeration of the various types of URLs to hit to make calls to the GitHub Gist API.
 * 
 * @see UrlBuilder#URL_EXTENSIONS
 * 
 * @author jessex
 */
enum UrlType {

    /** For requesting a particular Gist */
    GET_GIST,

    /** For requesting all of the Gists belonging to a particular user */
    GET_USER_GISTS,

    /** For requesting all public Gists */
    GET_PUBLIC_GISTS,

    /** For requesting all of the authenticated user's Gists; returns all public Gists if called anonymously */
    GET_AUTHENTICATED_USER_GISTS,

    /** For requesting all of the authenticated user's starred Gists */
    GET_AUTHENTICATED_USER_STARRED_GISTS,

    /** For creating a new Gist */
    CREATE_GIST,

    /** For editing a particular Gist */
    EDIT_GIST,

    /** For forking a particular Gist */
    FORK_GIST,

    /** For deleting a particular Gist */
    DELETE_GIST,

    /** For starring a Gist */
    STAR_GIST,

    /** For un-starring a Gist */
    UNSTAR_GIST,

    /** For checking if a Gist is starred */
    IS_GIST_STARRED,

    /** For requesting a particular Gist comment */
    GET_COMMENT,

    /** For requesting all comments on a particular Gist */
    GET_GIST_COMMENTS,

    /** For creating a new Gist comment */
    POST_COMMENT,

    /** For editing a particular Gist comment */
    EDIT_COMMENT,

    /** For deleting a particular Gist comment */
    DELETE_COMMENT
}
