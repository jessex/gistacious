package com.jessex.gistacious.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.util.EntityUtils;

import com.jessex.gistacious.gist.*;
import com.jessex.gistacious.json.*;

public class FullGistApi implements GistApi, GistCommentApi, GistUserApi {

	private HttpAuthenticator authenticator;
	private JsonDeserializer deserializer;
	private JsonSerializer serializer;
	
	public FullGistApi() { 
		deserializer = new JsonSimpleDeserializer();
		serializer = new JsonSimpleSerializer();
	}
	
	public FullGistApi(HttpAuthenticator auth) {
		this.authenticator = auth;
		this.deserializer = new JsonSimpleDeserializer();
		this.serializer = new JsonSimpleSerializer();
	}
	
	
	@Override
	public HttpAuthenticator getHttpAuthenticator() {
		return this.authenticator;
	}

	@Override
	public void setHttpAuthenticator(HttpAuthenticator auth) {
		this.authenticator = auth;
	}
	

	@Override
	public GistUser getUser(String user) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.USER, user);
		String json = executeGetCall(url, false);
		return deserializer.deserializeUserFromJson(json);
	}

	@Override
	public GistUser getMyUser() throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.USER_ME);
		String json = executeGetCall(url, true);
		return deserializer.deserializeUserFromJson(json);
	}

	@Override
	public List<GistComment> getGistComments(long gistId) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_COMMENTS, 
				Long.toString(gistId));
		String json = executeGetCall(url, false);
		return deserializer.deserializeCommentsFromJson(json);
	}

	@Override
	public GistComment getGistComment(long commentId) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.SINGLE_COMMENT, 
				Long.toString(commentId));
		String json = executeGetCall(url, false);
		return deserializer.deserializeCommentFromJson(json);
	}

	@Override
	public GistComment createGistComment(long gistId, GistComment comment) 
	throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_COMMENTS, 
				Long.toString(gistId));
		String json = serializer.serializeJsonFromGistComment(comment);
		String responseJson = executePostCall(url, json);
		return deserializer.deserializeCommentFromJson(responseJson);
	}

	@Override
	public GistComment editGistComment(long commentId, GistComment newComment) 
	throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.SINGLE_COMMENT, 
				Long.toString(commentId));
		String json = serializer.serializeJsonFromGistComment(newComment);
		String responseJson = executePostCall(url, json);
		return deserializer.deserializeCommentFromJson(responseJson);
	}

	@Override
	public void deleteGistComment(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.SINGLE_COMMENT, 
				Long.toString(id));
		HttpDelete delete = HttpRequester.buildDeleteRequest(url, 
				authenticator);
		HttpRequester.executeRequest(delete);
	}

	@Override
	public Gist getGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST, 
				Long.toString(id));
		String json = executeGetCall(url, false);
		return deserializer.deserializeGistFromJson(json);
	}

	@Override
	public List<Gist> getUserGists(String user) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.USER_GISTS, user);
		String json = executeGetCall(url, false);
		return deserializer.deserializeGistsFromJson(json);
	}

	@Override
	public List<Gist> getMyGists() throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.MY_GISTS);
		String json = executeGetCall(url, true);
		return deserializer.deserializeGistsFromJson(json);
	}

	@Override
	public List<Gist> getMyStarredGists() throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.MY_STARRED_GISTS);
		String json = executeGetCall(url, true);
		return deserializer.deserializeGistsFromJson(json);
	}

	@Override
	public List<Gist> getPublicGists() throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.PUBLIC_GISTS);
		String json = executeGetCall(url, false);
		return deserializer.deserializeGistsFromJson(json);
	}

	@Override
	public Gist createGist(Gist gist) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.MY_GISTS);
		String json = serializer.serializeJsonFromGistCreate(gist);
		String responseJson = executePostCall(url, json);
		return deserializer.deserializeGistFromJson(responseJson);
	}

	@Override
	public Gist editGist(long id, Gist newGist, List<GistFile> oldFiles) 
	throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST, 
				Long.toString(id));
		String json = serializer.serializeJsonFromGistEdit(newGist, oldFiles);
		String responseJson = executePostCall(url, json);
		return deserializer.deserializeGistFromJson(responseJson);
	}

	@Override
	public Gist forkGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_FORK, 
				Long.toString(id));
		HttpPost post = new HttpPost(url);
		authenticator.authenticateRequest(post);
		HttpResponse response = HttpRequester.executeRequest(post);
		if (response == null) throw new IOException();
		else {
			if (response.getStatusLine().getStatusCode() != 201) {
				//Deal with status line issue
			}
			
			String responseJson = EntityUtils.toString(response.getEntity());
			return deserializer.deserializeGistFromJson(responseJson);
		}
	}

	@Override
	public void deleteGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST, 
				Long.toString(id));
		HttpDelete delete = HttpRequester.buildDeleteRequest(url, 
				authenticator);
		HttpResponse response = HttpRequester.executeRequest(delete);
		if (response == null) throw new IOException();
	}

	@Override
	public boolean isStarredGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_STAR, 
				Long.toString(id));
		HttpGet get = HttpRequester.buildGetRequest(url);
		HttpResponse response = HttpRequester.executeRequest(get);
		if (response.getStatusLine().getStatusCode() == 204)
			return true;
		else return false;
	}

	@Override
	public void starGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_STAR, 
				Long.toString(id));
		HttpPut put = HttpRequester.buildPutRequest(url, "", authenticator);
		HttpRequester.executeRequest(put);
	}

	@Override
	public void unstarGist(long id) throws IOException {
		String url = UrlBuilder.getURL(UrlBuilder.UrlType.GIST_STAR, 
				Long.toString(id));
		HttpDelete delete = HttpRequester.buildDeleteRequest(url, 
				authenticator);
		HttpRequester.executeRequest(delete);
	}
	
	
	
	private String executeGetCall(String url, boolean needsAuthentication) 
	throws IOException {
		HttpGet get = HttpRequester.buildGetRequest(url);
		if (needsAuthentication) authenticator.authenticateRequest(get);
		HttpResponse response = HttpRequester.executeRequest(get);
		
		if (response == null) throw new IOException();
		else {
			if (response.getStatusLine().getStatusCode() != 200) {
				//Deal with status line issue (possible 404)
			}
			
			return EntityUtils.toString(response.getEntity());
		}
	}
	
	private String executePostCall(String url, String json) throws IOException {
		HttpPost post = HttpRequester.buildPostRequest(url, json, 
				authenticator);
		HttpResponse response = HttpRequester.executeRequest(post);
		if (response == null) throw new IOException();
		else {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200 && statusCode != 201) {
				//Deal with status line issue
			}
			
			return EntityUtils.toString(response.getEntity());
		}
	}
	
	
	
}
