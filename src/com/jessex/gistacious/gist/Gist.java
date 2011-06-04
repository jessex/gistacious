package com.jessex.gistacious.gist;

import java.util.List;

public class Gist {

	private List<GistFile> files;
	private List<Gist> forks;
	private List<GistHistory> history;
	private Gist forkOf;
	private GistUser user;
	
	private String description;
	private int commentCount;
	private long id;
	private String updatedAt;
	private String createdAt;
	private boolean isPublic;
	private String htmlUrl;
	private String gitPushUrl;
	private String gitPullUrl;
	private String url;
	
	public Gist() { }
	
	//Condensed constructor for quickly building a fork gist
	public Gist(Long id, String url, String createdAt, GistUser user) {
		this.id = id;
		this.url = url;
		this.createdAt = createdAt;
		this.user = user;
	}

	/**
	 * Sets the list of forks from this gist.
	 * @param forks the forks to set
	 */
	public void setForks(List<Gist> forks) {
		this.forks = forks;
	}

	/**
	 * Returns the list of forks from this gist.
	 * @return the forks
	 */
	public List<Gist> getForks() {
		return forks;
	}

	/**
	 * Sets the commit history for this gist.
	 * @param history the history to set
	 */
	public void setHistory(List<GistHistory> history) {
		this.history = history;
	}

	/**
	 * Returns the commit history for this gist.
	 * @return the history
	 */
	public List<GistHistory> getHistory() {
		return history;
	}

	/**
	 * Sets the gist forked from this gist.
	 * @param forkOf the forkOf to set
	 */
	public void setForkOf(Gist forkOf) {
		this.forkOf = forkOf;
	}

	/**
	 * Returns the gist forked from this gist.
	 * @return the forkOf
	 */
	public Gist getForkOf() {
		return forkOf;
	}

	/**
	 * Sets the description of this gist.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the description of this gist.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the amount of comments for this gist.
	 * @param comments the comments to set
	 */
	public void setCommentCount(int comments) {
		this.commentCount = comments;
	}

	/**
	 * Returns the amount of comments for this gist.
	 * @return the comments
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * Sets the id of this gist.
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns the id of this gist.
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the user for this gist.
	 * @param user the user to set
	 */
	public void setUser(GistUser user) {
		this.user = user;
	}

	/**
	 * Returns the user for this gist.
	 * @return the user
	 */
	public GistUser getUser() {
		return user;
	}

	/**
	 * Sets the update time for this gist.
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Returns the update time for this gist.
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets the create time for this gist.
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Returns the create time for this gist.
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets whether or not this gist is public.
	 * @param isPublic the isPublic to set
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * Returns whether or not this gist is public.
	 * @return the isPublic
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * Sets the HTML URL for this gist.
	 * @param htmlUrl the htmlUrl to set
	 */
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	/**
	 * Returns the HTML URL for this gist.
	 * @return the htmlUrl
	 */
	public String getHtmlUrl() {
		return htmlUrl;
	}

	/**
	 * Sets the push URL for this gist.
	 * @param gitPushUrl the gitPushUrl to set
	 */
	public void setGitPushUrl(String gitPushUrl) {
		this.gitPushUrl = gitPushUrl;
	}

	/**
	 * Returns the push URL for this gist.
	 * @return the gitPushUrl
	 */
	public String getGitPushUrl() {
		return gitPushUrl;
	}

	/**
	 * Sets the pull URL for this gist.
	 * @param gitPullUrl the gitPullUrl to set
	 */
	public void setGitPullUrl(String gitPullUrl) {
		this.gitPullUrl = gitPullUrl;
	}

	/**
	 * Returns the pull URL for this gist.
	 * @return the gitPullUrl
	 */
	public String getGitPullUrl() {
		return gitPullUrl;
	}

	/**
	 * Sets the URL for this gist.
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the URL for this gist.
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the list of files in this gist.
	 * @param files the files to set
	 */
	public void setFiles(List<GistFile> files) {
		this.files = files;
	}

	/**
	 * Returns the list of files in this gist.
	 * @return the files
	 */
	public List<GistFile> getFiles() {
		return files;
	}
	
	
	
	
	
}
