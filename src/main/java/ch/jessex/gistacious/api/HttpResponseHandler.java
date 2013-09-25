package ch.jessex.gistacious.api;

import java.util.List;

import ch.jessex.gistacious.gist.Gist;
import ch.jessex.gistacious.gist.GistComment;
import org.apache.http.HttpResponse;

/**
 * Parses and handles the responses received from making requests to the Gist API. This encompasses taking in an
 * {@link org.apache.http.HttpResponse HttpResponse} and returning the appropriate resource(s) output by the API call.
 *
 * @author jessex
 */
class HttpResponseHandler {

    // TODO: Consider adding expectedStatusCode parameter?
    // TODO: Implement methods

    /**
     * Parses the given HTTP response and returns a Gist.
     *
     * @param httpResponse the server response to an API call
     * @return the Gist returned in the response
     * @throws GistApiException if there is an error raised by the response from the server
     */
    static Gist parseResponseForGist(HttpResponse httpResponse) throws GistApiException {
        return null;
    }

    /**
     * Parses the given HTTP response and returns a list of Gists.
     *
     * @param httpResponse the server response to an API call
     * @return the list of Gists returned in the response
     * @throws GistApiException if there is an error raised by the response from the server
     */
    static List<Gist> parseResponseForGists(HttpResponse httpResponse) throws GistApiException {
        return null;
    }

    /**
     * Parses the given HTTP response and returns a Gist comment.
     *
     * @param httpResponse the server response to an API call
     * @return the Gist comment returned in the response
     * @throws GistApiException if there is an error raised by the response from the server
     */
    static GistComment parseResponseForComment(HttpResponse httpResponse) throws GistApiException {
        return null;
    }

    /**
     * Parses the given HTTP response and returns a list of Gist comments.
     *
     * @param httpResponse the server response to an API call
     * @return the list of Gist comments returned in the response
     * @throws GistApiException if there is an error raised by the response from the server
     */
    static List<GistComment> parseResponseForComments(HttpResponse httpResponse) throws GistApiException {
        return null;
    }

    /**
     * Parses the given HTTP response and returns the response status code.
     *
     * @param httpResponse the server response to an API call
     * @return the response status code
     * @throws GistApiException if there is an error raised by the response from the server
     */
    static int parseResponseForStatusCode(HttpResponse httpResponse) throws GistApiException {
        return 0;
    }
}
