package com.jessex.gistacious.gist;

public class GistHistory {

	private String url;
	private String version;
	private String committedAt;
	private GistUser user;
	private GistChangeStatus changeStatus;

	public GistHistory() { }
	
	public GistHistory(String url, String version, String committedAt,
			GistUser user, GistChangeStatus changeStatus) {
		this.url = url;
		this.version = version;
		this.committedAt = committedAt;
		this.user = user;
		this.changeStatus = changeStatus;
	}
	
	/**
	 * Sets the URL of this commit history.
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the URL of this commit history.
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the version string of this commit history.
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Returns the version string of this commit history.
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the commit time for this commit history.
	 * @param committedAt the committedAt to set
	 */
	public void setCommittedAt(String committedAt) {
		this.committedAt = committedAt;
	}

	/**
	 * Returns the commit time for this commit history.
	 * @return the committedAt
	 */
	public String getCommittedAt() {
		return committedAt;
	}

	/**
	 * Sets the user for this commit history.
	 * @param user the user to set
	 */
	public void setUser(GistUser user) {
		this.user = user;
	}

	/**
	 * Returns the user for this commit history.
	 * @return the user
	 */
	public GistUser getUser() {
		return user;
	}

	/**
	 * Sets the change status for this commit history.
	 * @param changeStatus the changeStatus to set
	 */
	public void setChangeStatus(GistChangeStatus changeStatus) {
		this.changeStatus = changeStatus;
	}

	/**
	 * Returns the change status for this commit history.
	 * @return the changeStatus
	 */
	public GistChangeStatus getChangeStatus() {
		return changeStatus;
	}
	
	
}
