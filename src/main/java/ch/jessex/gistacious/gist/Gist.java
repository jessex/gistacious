package ch.jessex.gistacious.gist;

import java.util.List;

/**
 * The model for a gist. A full gist object not only contains gist metadata, but
 * also gist content in the form of one to many gist files, any gists that were
 * forked from this gist, the gist that this gist was forked from (if that is
 * indeed the case), and a list of histories for this gist.
 * 
 * @author jessex
 */
public class Gist {

    private List<GistFile> files;
    private List<Gist> forks;
    private List<GistHistory> histories;
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
     *
     * @param forks the list of forked gists
     */
    public void setForks(List<Gist> forks) {
        this.forks = forks;
    }

    /**
     * Returns the list of forks from this gist.
     *
     * @return list of forked gists
     */
    public List<Gist> getForks() {
        return forks;
    }

    /**
     * Sets the commit history for this gist. This includes each individual
     * history for this gist.
     *
     * @param history the list of commit histories of this gist
     */
    public void setHistories(List<GistHistory> histories) {
        this.histories = histories;
    }

    /**
     * Returns the commit history for this gist.
     *
     * @return list of commit histories of this gist
     */
    public List<GistHistory> getHistories() {
        return histories;
    }

    /**
     * Sets the gist that this gist is forked from.
     *
     * @param forkOf the gist that this gist is forked from
     */
    public void setForkOf(Gist forkOf) {
        this.forkOf = forkOf;
    }

    /**
     * Returns the gist that this gist is forked.
     *
     * @return gist that this gist is forked from
     */
    public Gist getForkOf() {
        return forkOf;
    }

    /**
     * Sets the description of this gist.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description of this gist.
     *
     * @return description of this gist
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the amount of comments for this gist.
     *
     * @param comments the amount of comments to set
     */
    public void setCommentCount(int comments) {
        this.commentCount = comments;
    }

    /**
     * Returns the amount of comments for this gist.
     *
     * @return amount of comments
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * Sets the id of this gist.
     *
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the id of this gist.
     *
     * @return id of this gist
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the user for this gist.
     *
     * @param user the user to set
     */
    public void setUser(GistUser user) {
        this.user = user;
    }

    /**
     * Returns the user for this gist.
     *
     * @return user of this gist
     */
    public GistUser getUser() {
        return user;
    }

    /**
     * Sets the most recent update time for this gist.
     *
     * @param updatedAt String representation of the most recent update time of
     * this gist
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Returns the most recent update time for this gist.
     *
     * @return String representation of the most recent update time of this gist
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the create time for this gist.
     *
     * @param createdAt String representation of the creation time of this gist
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the create time for this gist.
     *
     * @return String representation of the creation time of this gist
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets whether or not this gist is public.
     *
     * @param isPublic whether or not this gist is public
     */
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * Returns whether or not this gist is public.
     *
     * @return whether or not this gist is public
     */
    public boolean isPublic() {
        return isPublic;
    }

    /**
     * Sets the HTML URL for this gist.
     *
     * @param htmlUrl the HTML url to set
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Returns the HTML URL for this gist.
     *
     * @return HTML url of this gist
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Sets the push URL for this gist.
     *
     * @param gitPushUrl the git push url to set
     */
    public void setGitPushUrl(String gitPushUrl) {
        this.gitPushUrl = gitPushUrl;
    }

    /**
     * Returns the push URL for this gist.
     *
     * @return git push url of this gist
     */
    public String getGitPushUrl() {
        return gitPushUrl;
    }

    /**
     * Sets the pull URL for this gist.
     *
     * @param gitPullUrl the git pull url to set
     */
    public void setGitPullUrl(String gitPullUrl) {
        this.gitPullUrl = gitPullUrl;
    }

    /**
     * Returns the pull URL for this gist.
     *
     * @return git pull url of this gist
     */
    public String getGitPullUrl() {
        return gitPullUrl;
    }

    /**
     * Sets the URL for this gist.
     *
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the URL for this gist.
     *
     * @return url of this gist
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the list of files in this gist.
     *
     * @param files the list of files in this gist
     */
    public void setFiles(List<GistFile> files) {
        this.files = files;
    }

    /**
     * Returns the list of files in this gist.
     *
     * @return list of files in this gist
     */
    public List<GistFile> getFiles() {
        return files;
    }
}
