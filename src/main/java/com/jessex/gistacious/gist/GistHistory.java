package com.jessex.gistacious.gist;

/**
 * The model for a gist history, which is metadata about a particular revision 
 * of a particular gist object.
 * 
 * @author jessex
 */
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
     * Sets the URL of this gist commit history.
     *
     * @param url String representation of the url of this history
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the URL of this gist commit history.
     *
     * @return String representation of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the version string of this gist commit history.
     *
     * @param version the version string of this history
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Returns the version string of this gist commit history.
     *
     * @return version string
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the commit time for this gist commit history.
     *
     * @param committedAt String representation of the commit time
     */
    public void setCommittedAt(String committedAt) {
        this.committedAt = committedAt;
    }

    /**
     * Returns the commit time for this gist commit history.
     *
     * @return String representation of the commit time
     */
    public String getCommittedAt() {
        return committedAt;
    }

    /**
     * Sets the user for this gist commit history.
     *
     * @param user the user of this history
     */
    public void setUser(GistUser user) {
        this.user = user;
    }

    /**
     * Returns the user for this gist commit history.
     *
     * @return user
     */
    public GistUser getUser() {
        return user;
    }

    /**
     * Sets the change status for this gist commit history.
     *
     * @param changeStatus the change status of this history
     */
    public void setChangeStatus(GistChangeStatus changeStatus) {
        this.changeStatus = changeStatus;
    }

    /**
     * Returns the change status for this gist commit history.
     *
     * @return change status
     */
    public GistChangeStatus getChangeStatus() {
        return changeStatus;
    }
}
