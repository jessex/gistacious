package com.jessex.gistacious.gist;

public class GistUser {

	private String avatarUrl;
	private String gravatarUrl;
	private String url;
	private String login;
	private long id;

	public GistUser() { }
	
	public GistUser(String login, long id, String url, 
			String avatarUrl, String gravatarUrl) {
		this.login = login;
		this.id = id;
		this.url = url;
		this.avatarUrl = avatarUrl;
		this.gravatarUrl = gravatarUrl;
	}
	
	
	/**
	 * Sets the avatar URL for this user.
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * Returns the avatar URL for this user.
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * Sets the gravatar URL for this user.
	 * @param gravatarUrl the gravatarUrl to set
	 */
	public void setGravatarUrl(String gravatarUrl) {
		this.gravatarUrl = gravatarUrl;
	}

	/**
	 * Returns the gravatar URL for this user.
	 * @return the gravatarUrl
	 */
	public String getGravatarUrl() {
		return gravatarUrl;
	}

	/**
	 * Sets the URL for this user.
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the URL for this user.
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the login for this user.
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Returns the login for this user.
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the id for this user.
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns the id for this user.
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	
	
	
}
