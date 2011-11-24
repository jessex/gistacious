package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.methods.HttpDelete;

import com.jessex.gistacious.api.http.AuthenticationCredentialsDTO;
import com.jessex.gistacious.api.http.HttpRequester;
import com.jessex.gistacious.api.url.UrlBuilder;
import com.jessex.gistacious.api.url.UrlType;
import com.jessex.gistacious.gist.GistComment;
import com.jessex.gistacious.json.DefaultJsonDeserializer;
import com.jessex.gistacious.json.DefaultJsonSerializer;
import com.jessex.gistacious.json.JsonDeserializer;
import com.jessex.gistacious.json.JsonSerializer;

/**
 * Default implementation of the {@link GistCommentApi} interface.
 * 
 * @author jessex
 */
public class DefaultGistCommentApi implements GistCommentApi {
    
    private JsonSerializer serializer = new DefaultJsonSerializer();
    private JsonDeserializer deserializer = new DefaultJsonDeserializer();
    
    /** {@inheritDoc} */
    @Override
    public List<GistComment> getGistComments(long gistId) throws IOException {
        String url = UrlBuilder.getURL(UrlType.GIST_COMMENTS, 
                Long.toString(gistId));
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeCommentsFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment getGistComment(long commentId) throws IOException {
        String url = UrlBuilder.getURL(UrlType.SINGLE_COMMENT, 
                Long.toString(commentId));
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeCommentFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment createGistComment(long gistId, GistComment comment,
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.GIST_COMMENTS, 
                Long.toString(gistId));
        String json = serializer.serializeJsonFromGistComment(comment);
        String responseJson = ApiUtils.executePostCall(url, json, credentials);
        return deserializer.deserializeCommentFromJson(responseJson);
    }

    /** {@inheritDoc} */
    @Override
    public GistComment editGistComment(long commentId, GistComment newComment,
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.SINGLE_COMMENT, 
                Long.toString(commentId));
        String json = serializer.serializeJsonFromGistComment(newComment);
        String responseJson = ApiUtils.executePostCall(url, json, credentials);
        return deserializer.deserializeCommentFromJson(responseJson);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteGistComment(long id, 
        AuthenticationCredentialsDTO credentials) throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.SINGLE_COMMENT, 
                Long.toString(id));
        HttpDelete delete = HttpRequester.buildDeleteRequest(url, credentials);
        HttpRequester.executeRequest(delete);
    }
}
