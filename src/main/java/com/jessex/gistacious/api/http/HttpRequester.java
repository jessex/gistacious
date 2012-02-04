package com.jessex.gistacious.api.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * A utility for constructing and executing HTTP requests of the type GET, POST,
 * PUT and DELETE. At present, the PATCH method is not supported.
 * 
 * @author jessex
 */
public class HttpRequester {

	private static final HttpClient client = new DefaultHttpClient();
	private static final HttpAuthenticator httpAuthenticator = 
	    new DefaultAuthenticator();
	
	/**
	 * Executes a given HTTP request and returns the response from the server.
	 * Returns null if there is an IOException, signifying an issue with the
	 * server connection.
	 * 
	 * @param request the HTTP request to make to some server
	 * @return server response to HTTP request
	 */
	public static HttpResponse executeRequest(HttpRequestBase request) {
		try {
			return client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns a GET request for the given URL.
	 * 
	 * @param url the URL to send the GET request to
	 * @return HTTP GET request
	 */
	public static HttpGet buildGetRequest(String url) {
		return new HttpGet(url);
	}
	
	/**
	 * Returns a DELETE request for the given URL and with the given 
	 * authentication credentials.
	 * 
	 * @param url the URL to send the DELETE request to
	 * @param credentials the authentication credentials
	 * @return HTTP DELETE request
	 */
	public static HttpDelete buildDeleteRequest(String url, 
	        AuthenticationCredentialsDTO credentials) {
	    
		HttpDelete request = new HttpDelete(url);
		httpAuthenticator.authenticateRequest(request, credentials);
		return request;
	}
	
	/**
	 * Returns a POST request for the given URL with a body specified by the 
	 * given JSON text and with the given authentication credentials.
	 * 
	 * @param url the URL to send the POST request to
	 * @param json the JSON text to package as the body of the request
	 * @param credentials the authentication credentials
	 * @return HTTP POST request
	 */
	public static HttpPost buildPostRequest(String url, String json, 
	        AuthenticationCredentialsDTO credentials) {
	    
		HttpPost request = new HttpPost(url);
		augmentRequest(request, json, credentials);
		return request;
	}
	
	/**
	 * Returns a PUT request for the given URL with a body specified by the 
	 * given JSON text and with the given authentication credentials.
	 * 
	 * @param url the URL to send the PUT request to
	 * @param json the JSON text to package as the body of the request
	 * @param credentials the authentication credentials
	 * @return HTTP PUT request
	 */
	public static HttpPut buildPutRequest(String url, String json, 
	        AuthenticationCredentialsDTO credentials) {
	    
		HttpPut request = new HttpPut(url);
		augmentRequest(request, json, credentials);
		return request;
	}
	
	/**
	 * Augments an HTTP request (of the POST or PUT method) by setting the body 
	 * content type as JSON, adding the JSON text to the body and adding the
	 * authentication credentials to the request header.
	 * 
	 * @param request HTTP request to augment
	 * @param json the JSON text to package as the body of the request
	 * @param credentials the authentication credentials
	 */
	private static void augmentRequest(HttpEntityEnclosingRequestBase request, 
			String json, AuthenticationCredentialsDTO credentials) {
	    
		request.setHeader("Content-type", "application/json");
		httpAuthenticator.authenticateRequest(request, credentials);
		
		try {
			request.setEntity(new StringEntity(json, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
