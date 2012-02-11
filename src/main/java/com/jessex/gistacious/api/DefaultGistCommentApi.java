package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.jessex.gistacious.api.auth.AuthenticationCredentialsDTO;
import com.jessex.gistacious.gist.GistComment;

import static com.jessex.gistacious.api.HttpRequester.executeRequest;
import static com.jessex.gistacious.api.HttpResponseHandler.*;
import static com.jessex.gistacious.api.RequestBuilder.buildGetRequest;
import static com.jessex.gistacious.api.RequestBuilder.buildPostRequest;

/**
 * Default implementation of the {@link GistCommentApi} interface.
 * 
 * @author jessex
 */
public class DefaultGistCommentApi implements GistCommentApi {

    // TODO: Get rid of duplication in method calls with some sort of abstraction layer

    private static final String COMMENT_JSON = "{ \"body\" : \"%s\" } ";

    /** {@inheritDoc} */
    @Override
    public List<GistComment> getGistComments(long gistId) throws IOException, GistApiException {
        String url = UrlBuilder.getURL(UrlType.GET_GIST_COMMENTS, Long.toString(gistId));
        HttpGet httpGet = buildGetRequest(url);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForComments(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment getGistComment(long commentId) throws IOException, GistApiException {
        String url = UrlBuilder.getURL(UrlType.GET_COMMENT, Long.toString(commentId));
        HttpGet httpGet = buildGetRequest(url);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForComment(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment createGistComment(long gistId, String comment, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {
        Validator.paramNotEmpty(comment, "comment cannot be empty or null");
        Validator.paramNotNull(credentials, "credentials");

        String url = UrlBuilder.getURL(UrlType.POST_COMMENT, Long.toString(gistId));
        String json = String.format(COMMENT_JSON, comment);
        HttpPost httpPost = buildPostRequest(url, json, credentials);
        HttpResponse httpResponse = executeRequest(httpPost);
        return parseResponseForComment(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment editGistComment(long commentId, String comment, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {
        Validator.paramNotEmpty(comment, "comment cannot be empty or null");
        Validator.paramNotNull(credentials, "credentials");

        String url = UrlBuilder.getURL(UrlType.EDIT_COMMENT, Long.toString(commentId));
        String json = String.format(COMMENT_JSON, comment);
        HttpPost httpPost = buildPostRequest(url, json, credentials);
        HttpResponse httpResponse = executeRequest(httpPost);
        return parseResponseForComment(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteGistComment(long commentId, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {
        Validator.paramNotNull(credentials, "credentials");

        String url = UrlBuilder.getURL(UrlType.DELETE_COMMENT, Long.toString(commentId));
        HttpDelete delete = RequestBuilder.buildDeleteRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(delete);
        parseResponseForStatusCode(httpResponse);
    }
}
