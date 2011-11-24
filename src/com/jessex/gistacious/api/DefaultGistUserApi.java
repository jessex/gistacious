package com.jessex.gistacious.api;

import java.io.IOException;

import com.jessex.gistacious.api.http.AuthenticationCredentialsDTO;
import com.jessex.gistacious.api.url.UrlBuilder;
import com.jessex.gistacious.api.url.UrlType;
import com.jessex.gistacious.gist.GistUser;
import com.jessex.gistacious.json.DefaultJsonDeserializer;
import com.jessex.gistacious.json.JsonDeserializer;

/**
 * Default implementation of the {@link GistUserApi} interface.
 * 
 * @author jessex
 */
public class DefaultGistUserApi implements GistUserApi {

    private JsonDeserializer deserializer = new DefaultJsonDeserializer();
    
    /** {@inheritDoc} */
    @Override
    public GistUser getUser(String user) throws IOException {
        String url = UrlBuilder.getURL(UrlType.USER, user);
        String json = ApiUtils.executeGetCall(url, false, null);
        return deserializer.deserializeUserFromJson(json);
    }

    /** {@inheritDoc} */
    @Override
    public GistUser getMyUser(AuthenticationCredentialsDTO credentials) 
        throws IOException {
        
        String url = UrlBuilder.getURL(UrlType.USER_ME);
        String json = ApiUtils.executeGetCall(url, true, 
                credentials);
        return deserializer.deserializeUserFromJson(json);
    }
}
