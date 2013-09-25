package ch.jessex.gistacious.v3.api;

/**
 * An exception which has occurred at runtime as a result of some error in the call to the Gist API. These are errors
 * found in the actual response from the server, not prior (ie. during the process of executing the request or in
 * crafting the request).
 *
 * @author jessex
 */
public class GistApiException extends RuntimeException {

    public GistApiException() { }

    public GistApiException(String message) {
        super(message);
    }
}
