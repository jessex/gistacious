package ch.jessex.gistacious.gist;

/**
 * The model for a gist comment, which is a comment made by some gist user on
 * some gist object.
 * 
 * @author jessex
 */
public class GistComment {

    private long id;
    private String url;
    private String body;
    private String createdAt;
    private GistUser user;

    private String gistId;

    public GistComment() { }

    public GistComment(long id, String url, String body, String createdAt,
            GistUser user) {
        this.id = id;
        this.url = url;
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
    }

    /**
     * Sets the id of this comment.
     *
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the id of this comment.
     *
     * @return id of this comment
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the url of the gist containing this comment.
     *
     * @param url the url of the gist with this comment
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the url of the gist containing this comment.
     *
     * @return url of the gist with this comment
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the body of this comment.
     *
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Returns the body of this comment.
     *
     * @return body of this comment
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the create time for this comment.
     *
     * @param createdAt String representation of the creation time
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the create time for this comment.
     *
     * @return String representation of the creation time
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the user of this comment.
     *
     * @param user the user who wrote this comment
     */
    public void setUser(GistUser user) {
        this.user = user;
    }

    /**
     * Returns the user of this comment.
     *
     * @return the user who wrote this comment
     */
    public GistUser getUser() {
        return user;
    }

    /**
     * Sets the id for the gist containing this comment.
     *
     * @param gistId the id of the gist with this comment
     */
    public void setGistId(String gistId) {
        this.gistId = gistId;
    }

    /**
     * Returns the id for the gist containing this comment.
     *
     * @return id of the gist with this comment
     */
    public String getGistId() {
        return gistId;
    }
}
