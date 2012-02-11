package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import com.jessex.gistacious.api.auth.AuthenticationCredentialsDTO;
import com.jessex.gistacious.api.json.DefaultJsonSerializer;
import com.jessex.gistacious.api.json.JsonSerializer;
import com.jessex.gistacious.gist.Gist;
import com.jessex.gistacious.gist.GistFile;

import static com.jessex.gistacious.api.HttpRequester.executeRequest;
import static com.jessex.gistacious.api.HttpResponseHandler.*;
import static com.jessex.gistacious.api.RequestBuilder.*;

/**
 * Default implementation of the {@link GistApi} interface.
 * 
 * @author jessex
 */
public class DefaultGistApi implements GistApi {

    // TODO: Get rid of duplication in method calls with some sort of abstraction layer

    private JsonSerializer serializer = new DefaultJsonSerializer();

    /** {@inheritDoc} */
    @Override
    public Gist getGist(long id) throws IOException {
        String url = UrlBuilder.getURL(UrlType.GET_GIST,  Long.toString(id));
        HttpGet httpGet = buildGetRequest(url);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForGist(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getUserGists(String user) throws IOException, GistApiException {
        String url = UrlBuilder.getURL(UrlType.GET_USER_GISTS, user);
        HttpGet httpGet = buildGetRequest(url);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForGists(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getAuthenticatedUserGists(AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.GET_AUTHENTICATED_USER_GISTS);
        HttpGet httpGet = buildGetRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForGists(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getAuthenticatedUserStarredGists(AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.GET_AUTHENTICATED_USER_STARRED_GISTS);
        HttpGet httpGet = buildGetRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForGists(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getPublicGists() throws IOException, GistApiException {
        String url = UrlBuilder.getURL(UrlType.GET_PUBLIC_GISTS);
        HttpGet httpGet = buildGetRequest(url);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForGists(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public Gist createGist(Gist gist, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException {
        String url = UrlBuilder.getURL(UrlType.CREATE_GIST);
        String json = serializer.serializeJsonFromGistCreate(gist);
        HttpPost httpPost = buildPostRequest(url, json, credentials);
        HttpResponse httpResponse = executeRequest(httpPost);
        return parseResponseForGist(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public Gist editGist(long id, Gist newGist, List<GistFile> oldFiles, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.EDIT_GIST, Long.toString(id));
        String json = serializer.serializeJsonFromGistEdit(newGist, oldFiles);
        HttpPost httpPost = buildPostRequest(url, json, credentials);
        HttpResponse httpResponse = executeRequest(httpPost);
        return parseResponseForGist(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public Gist forkGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.FORK_GIST, Long.toString(id));
        HttpPost httpPost = buildPostRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpPost);
        return parseResponseForGist(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.DELETE_GIST, Long.toString(id));
        HttpDelete httpDelete = buildDeleteRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpDelete);
        parseResponseForStatusCode(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isStarredGist(long id, AuthenticationCredentialsDTO credentials)
            throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.IS_GIST_STARRED, Long.toString(id));
        HttpGet httpGet = buildGetRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpGet);
        return parseResponseForStatusCode(httpResponse) == 204;
    }

    /** {@inheritDoc} */
    @Override
    public void starGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.STAR_GIST, Long.toString(id));
        HttpPut httpPut = buildPutRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpPut);
        parseResponseForStatusCode(httpResponse);
    }

    /** {@inheritDoc} */
    @Override
    public void unstarGist(long id, AuthenticationCredentialsDTO credentials) throws IOException, GistApiException {

        String url = UrlBuilder.getURL(UrlType.UNSTAR_GIST,
                Long.toString(id));
        HttpDelete httpDelete = buildDeleteRequest(url, credentials);
        HttpResponse httpResponse = executeRequest(httpDelete);
        parseResponseForStatusCode(httpResponse);
    }
}
