package com.jessex.gistacious.gist;

public class GistUser {

	//Attributes from User objects found in Gist JSON
	private String avatarUrl;
	private String gravatarUrl;
	private String url;
	private String login;
	private long id;
	
	//Additional attributes from User objects found in generic User JSON
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private boolean hireable;
	private String bio;
	private int publicRepoCount;
	private int publicGistCount;
	private int followerCount;
	private int followingCount;
	private String htmlUrl;
	private String createdAt;
	private String type;
	
	//Additional attributes only for the currently authenticated user
	private int privateGistCount;
	private int privateRepoCount;
	
	private boolean isMe; //If this is the currently authenticated user

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

	/**
	 * Sets the name of this user.
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of this user.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the company of this user.
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Returns the company of this user.
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the blog URL of this user.
	 * @param blog the blog to set
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}

	/**
	 * Returns the blog URL of this user.
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}

	/**
	 * Sets the email address of this user.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the email address of this user.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the location of this user.
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Returns the location of this user.
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the bio of this user.
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Returns the bio of this user.
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Sets the hireability of this user.
	 * @param hireable the hireable to set
	 */
	public void setHireable(boolean hireable) {
		this.hireable = hireable;
	}

	/**
	 * Returns the hireability of this user.
	 * @return the hireable
	 */
	public boolean isHireable() {
		return hireable;
	}

	/**
	 * Sets the amount of public repositories for this user.
	 * @param publicRepos the publicRepos to set
	 */
	public void setPublicRepoCount(int publicRepos) {
		this.publicRepoCount = publicRepos;
	}

	/**
	 * Returns the amount of public repositories for this user.
	 * @return the publicRepos
	 */
	public int getPublicRepoCount() {
		return publicRepoCount;
	}

	/**
	 * Sets the amount of public gists for this user.
	 * @param publicGists the publicGists to set
	 */
	public void setPublicGistCount(int publicGists) {
		this.publicGistCount = publicGists;
	}

	/**
	 * Returns the amount of public gists for this user.
	 * @return the publicGists
	 */
	public int getPublicGistCount() {
		return publicGistCount;
	}

	/**
	 * Sets the amount of users following this user.
	 * @param followers the followers to set
	 */
	public void setFollowerCount(int followers) {
		this.followerCount = followers;
	}

	/**
	 * Returns the amount of users following this user.
	 * @return the followers
	 */
	public int getFollowerCount() {
		return followerCount;
	}

	/**
	 * Sets the amount of users that this user is following.
	 * @param following the following to set
	 */
	public void setFollowingCount(int following) {
		this.followingCount = following;
	}

	/**
	 * Returns the amount of users that this user is following.
	 * @return the following
	 */
	public int getFollowingCount() {
		return followingCount;
	}

	/**
	 * Sets the URL of this user's Github profile.
	 * @param htmlUrl the htmlUrl to set
	 */
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	/**
	 * Returns the URL of this user's Github profile.
	 * @return the htmlUrl
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * Sets the creation time of this user.
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Returns the creation time of this user.
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the type of this user, ie. "User".
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the type of this user, ie. "User".
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the amount of private gists for this user.
	 * @param privateGistCount the privateGistCount to set
	 */
	public void setPrivateGistCount(int privateGistCount) {
		this.privateGistCount = privateGistCount;
	}

	/**
	 * Returns the amount of private gists for this user.
	 * @return the privateGistCount
	 */
	public int getPrivateGistCount() {
		return privateGistCount;
	}

	/**
	 * Sets the amount of private repositories for this user.
	 * @param privateRepoCount the privateRepoCount to set
	 */
	public void setPrivateRepoCount(int privateRepoCount) {
		this.privateRepoCount = privateRepoCount;
	}

	/**
	 * Returns the amount of private repositories for this user.
	 * @return the privateRepoCount
	 */
	public int getPrivateRepoCount() {
		return privateRepoCount;
	}

	/**
	 * Sets whether or not this is the currently authenticated user.
	 * @param isMe the isMe to set
	 */
	public void setIsMe(boolean isMe) {
		this.isMe = isMe;
	}

	/**
	 * Returns whether or not this is the currently authenticated user.
	 * @return the isMe
	 */
	public boolean isMe() {
		return isMe;
	}
	
}
