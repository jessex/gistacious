package com.jessex.gistacious.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApiCaller {

	private static HttpClient client = new DefaultHttpClient();
	
	/**
	 * Sends a GET request to the given URL and returns the response from the 
	 * server. Throws an IOException if the URL is malformed or if there is any 
	 * issue with establishing the connection to the URL.
	 * @param url -
	 * 			the URL to send the GET request to
	 * @return response -
	 * 			response (org.apache.http.HttpResponse) from the GET request
	 * @throws IOException
	 */
	public static HttpResponse sendGetRequest(String url) throws IOException {
		HttpGet get = new HttpGet();
		try {
			get.setURI(new URI(url));
		} catch (URISyntaxException e) {
			throw new IOException();
		}
		return client.execute(get);
	}
	
	/**
	 * Sends a POST request to the given URL with a body specified by the given
	 * JSON text and returns the response from the server. Throws an IOException 
	 * if the URL is malformed or if there is any issue with establishing the 
	 * connection to the URL.
	 * @param url -
	 * 			the URL to send the POST request to
	 * @param json -
	 * 			the JSON text to package as the body of the request
	 * @return response -
	 * 			response (org.apache.http.HttpResponse) from the POST request
	 * @throws IOException
	 */
	public static HttpResponse sendPostRequest(String url, String json) 
	throws IOException {
		HttpPost post = new HttpPost();
		try {
			post.setURI(new URI(url));
		} catch (URISyntaxException e) {
			throw new IOException();
		}
		post.setHeader("Content-type", "application/json");
		StringEntity jsonEntity = null;
		try {
			jsonEntity = new StringEntity(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		post.setEntity(jsonEntity);
		
		return client.execute(post);
	}
	
}
