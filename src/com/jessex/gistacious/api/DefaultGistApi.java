package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.util.EntityUtils;

import com.jessex.gistacious.api.http.AuthenticationCredentialsDTO;
import com.jessex.gistacious.api.http.DefaultAuthenticator;
import com.jessex.gistacious.api.http.HttpAuthenticator;
import com.jessex.gistacious.api.http.HttpRequester;
import com.jessex.gistacious.api.url.UrlBuilder;
import com.jessex.gistacious.api.url.UrlType;
import com.jessex.gistacious.gist.Gist;
import com.jessex.gistacious.gist.GistFile;
import com.jessex.gistacious.json.DefaultJsonDeserializer;
import com.jessex.gistacious.json.DefaultJsonSerializer;
import com.jessex.gistacious.json.JsonDeserializer;
import com.jessex.gistacious.json.JsonSerializer;

/**
 * Default implementation of the {@link GistApi} interface.
 * 
 * @author jessex
 */
public class DefaultGistApi implements GistApi {

    private JsonSerializer serializer = new DefaultJsonSerializer();
    private JsonDeserializer deserializer = new DefaultJsonDeserializer();
    private static HttpAuthenticator authenticator = new DefaultAuthenticator();
    
    /** {@inheritDoc} */
    @Override
    public Gist getGist(long id) throws IOException {
        String url = UrlBuilder.getURL(UrlType.GIST, 
                Long.toString(id));
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeGistFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getUserGists(String user) throws IOException {
        String url = UrlBuilder.getURL(UrlType.USER_GISTS, user);
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeGistsFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getMyGists(AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.MY_GISTS);
        String json = ApiUtils.executeGetCall(url, true, credentials);
        return deserializer.deserializeGistsFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getMyStarredGists(AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.MY_STARRED_GISTS);
        String json = ApiUtils.executeGetCall(url, true, credentials);
        return deserializer.deserializeGistsFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public List<Gist> getPublicGists() throws IOException {
        String url = UrlBuilder.getURL(UrlType.PUBLIC_GISTS);
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeGistsFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public Gist createGist(Gist gist, AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.MY_GISTS);
        String json = serializer.serializeJsonFromGistCreate(gist);
        String responseJson = ApiUtils.executePostCall(url, json, credentials);
        return deserializer.deserializeGistFromJson(responseJson);
    }

    /** {@inheritDoc} */
    @Override
    public Gist editGist(long id, Gist newGist, List<GistFile> oldFiles,
            AuthenticationCredentialsDTO credentials) throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST, Long.toString(id));
        String json = serializer.serializeJsonFromGistEdit(newGist, oldFiles);
        String responseJson = ApiUtils.executePostCall(url, json, credentials);
        return deserializer.deserializeGistFromJson(responseJson);
    }

    /** {@inheritDoc} */
    @Override
    public Gist forkGist(long id, AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST_FORK, Long.toString(id));
        HttpPost post = new HttpPost(url);
        authenticator.authenticateRequest(post, credentials);
        
        HttpResponse response = HttpRequester.executeRequest(post);
        if (response == null) throw new IOException();
        else {
            if (response.getStatusLine().getStatusCode() != 201) {
                //TODO: Deal with status line issue
            }
            
            String responseJson = EntityUtils.toString(response.getEntity());
            return deserializer.deserializeGistFromJson(responseJson);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void deleteGist(long id, AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST, Long.toString(id));
        HttpDelete delete = HttpRequester.buildDeleteRequest(url, 
                credentials);
        HttpResponse response = HttpRequester.executeRequest(delete);
        
        if (response == null) throw new IOException();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isStarredGist(long id, 
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST_STAR, Long.toString(id));
        HttpGet get = HttpRequester.buildGetRequest(url);
        authenticator.authenticateRequest(get, credentials);
        HttpResponse response = HttpRequester.executeRequest(get);
        
        if (response.getStatusLine().getStatusCode() == 204)
            return true;
        else 
            return false;
    }

    /** {@inheritDoc} */
    @Override
    public void starGist(long id, AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST_STAR, 
                Long.toString(id));
        HttpPut put = HttpRequester.buildPutRequest(url, "", credentials);
        HttpRequester.executeRequest(put);
    }

    /** {@inheritDoc} */
    @Override
    public void unstarGist(long id, AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST_STAR, 
                Long.toString(id));
        HttpDelete delete = HttpRequester.buildDeleteRequest(url, credentials);
        HttpRequester.executeRequest(delete);
    }
}
