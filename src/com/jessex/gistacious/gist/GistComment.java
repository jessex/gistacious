package com.jessex.gistacious.gist;

public class GistComment {

	private String id;
	private String url;
	private String body;
	private String createdAt;
	private GistUser user;
	
	private String gistId;
	
	public GistComment() { }
	
	public GistComment(String id, String url, String body, String createdAt, 
			GistUser user) {
		this.id = id;
		this.url = url;
		this.body = body;
		this.createdAt = createdAt;
		this.user = user;
	}
	
	/**
	 * Sets the id of this comment.
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Returns the id of this comment.
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the url of the gist containing this comment.
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Returns the url of the gist containing this comment.
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the body of this comment.
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Returns the body of this comment.
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Sets the create time for this comment.
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * Returns the create time for this comment.
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Sets the user of this comment.
	 * @param user the user to set
	 */
	public void setUser(GistUser user) {
		this.user = user;
	}
	
	/**
	 * Returns the user of this comment.
	 * @return the user
	 */
	public GistUser getUser() {
		return user;
	}

	/**
	 * Sets the id for the gist containing this comment.
	 * @param gistId the gistId to set
	 */
	public void setGistId(String gistId) {
		this.gistId = gistId;
	}

	/**
	 * Returns the id for the gist containing this comment.
	 * @return the gistId
	 */
	public String getGistId() {
		return gistId;
	}
	
}
