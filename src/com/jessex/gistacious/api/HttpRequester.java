package com.jessex.gistacious.api;

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

public class HttpRequester {

	private static HttpClient client = new DefaultHttpClient();
	
	/**
	 * Executes a given HTTP request and returns the response from the server.
	 * Returns null if there is an IOException, signifying an issue with the
	 * server connection.
	 * @param request -
	 * 			HTTP request to make to server
	 * @return response -
	 * 			server response to HTTP request
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
	 * @param url -
	 * 			the URL to send the GET request to
	 * @return request -
	 * 			HTTP GET request
	 */
	public static HttpGet buildGetRequest(String url) {
		return new HttpGet(url);
	}
	
	/**
	 * Returns a DELETE request for the given URL and with the given 
	 * authentication credentials.
	 * @param url -
	 * 			the URL to send the DELETE request to
	 * @param auth -
	 * 			authentication credentials
	 * @return request -
	 * 			HTTP DELETE request
	 */
	public static HttpDelete buildDeleteRequest(String url, 
			HttpAuthenticator auth) {
		HttpDelete request = new HttpDelete(url);
		auth.authenticateRequest(request);
		return request;
	}
	
	/**
	 * Returns a POST request for the given URL with a body specified by the 
	 * given JSON text and with the given authentication credentials.
	 * @param url -
	 * 			the URL to send the POST request to
	 * @param json -
	 * 			the JSON text to package as the body of the request
	 * @param auth -
	 * 			authentication credentials
	 * @return request -
	 * 			HTTP POST request
	 */
	public static HttpPost buildPostRequest(String url, String json, 
			HttpAuthenticator auth) {
		HttpPost request = new HttpPost(url);
		augmentRequest(request, json, auth);
		return request;
	}
	
	/**
	 * Returns a PUT request for the given URL with a body specified by the 
	 * given JSON text and with the given authentication credentials.
	 * @param url -
	 * 			the URL to send the PUT request to
	 * @param json -
	 * 			the JSON text to package as the body of the request
	 * @param auth -
	 * 			authentication credentials
	 * @return request -
	 * 			HTTP PUT request
	 */
	public static HttpPut buildPutRequest(String url, String json, 
			HttpAuthenticator auth) {
		HttpPut request = new HttpPut(url);
		augmentRequest(request, json, auth);
		return request;
	}
	
	/**
	 * Augments an HTTP request (of the POST or PUT method) by setting the body 
	 * content type as JSON, adding the JSON text to the body and adding the
	 * authentication credentials to the request header.
	 * @param request -
	 * 			HTTP request to augment
	 * @param json -
	 * 			the JSON text to package as the body of the request
	 * @param auth -
	 * 			authentication credentials
	 */
	private static void augmentRequest(HttpEntityEnclosingRequestBase request, 
			String json, HttpAuthenticator auth) {
		request.setHeader("Content-type", "application/json");
		auth.authenticateRequest(request);
		try {
			request.setEntity(new StringEntity(json, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
