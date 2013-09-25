package ch.jessex.gistacious.gist;

/**
 * The model for a gist user, ie. some Github user who uses Github Gist.
 * 
 * @author jessex
 */
public class GistUser {

    private String avatarUrl;
    private String gravatarUrl;
    private String url;
    private String login;
    private long id;

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

    private int privateGistCount;
    private int privateRepoCount;

    private boolean isMe;

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
     *
     * @param avatarUrl the avatarUrl of this user
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * Returns the avatar URL for this user.
     *
     * @return avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Sets the gravatar URL for this user.
     *
     * @param gravatarUrl the gravatar url of this user
     */
    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    /**
     * Returns the gravatar URL for this user.
     *
     * @return gravatar url of this user
     */
    public String getGravatarUrl() {
        return gravatarUrl;
    }

    /**
     * Sets the URL for this user.
     *
     * @param url the url of this user
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the URL for this user.
     *
     * @return url of this user
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the login for this user.
     *
     * @param login the login of this user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the login for this user.
     *
     * @return login of this user
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the id for this user.
     *
     * @param id the id of this user
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the id for this user.
     *
     * @return id of this user
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the name of this user.
     *
     * @param name the name of this user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this user.
     *
     * @return name of this user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the company of this user.
     *
     * @param company the company of this user
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Returns the company of this user.
     *
     * @return company of this user
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the blog URL of this user.
     *
     * @param blog the blog of this user
     */
    public void setBlog(String blog) {
        this.blog = blog;
    }

    /**
     * Returns the blog URL of this user.
     *
     * @return url of the blog of this user
     */
    public String getBlog() {
        return blog;
    }

    /**
     * Sets the email address of this user.
     *
     * @param email the email of this user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the email address of this user.
     *
     * @return email address of this user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the location of this user.
     *
     * @param location the location of this user
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the location of this user.
     *
     * @return location of this user
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the bio of this user.
     *
     * @param bio the bio of this user
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Returns the bio of this user.
     *
     * @return biographical text of this user
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets the hireability of this user.
     *
     * @param hireable whether this user is hireable
     */
    public void setHireable(boolean hireable) {
        this.hireable = hireable;
    }

    /**
     * Returns the hireability of this user.
     *
     * @return whether this user is hireable
     */
    public boolean isHireable() {
        return hireable;
    }

    /**
     * Sets the amount of public repositories for this user.
     *
     * @param publicRepos the amount of public repositories of this user
     */
    public void setPublicRepoCount(int publicRepos) {
        this.publicRepoCount = publicRepos;
    }

    /**
     * Returns the amount of public repositories for this user.
     *
     * @return amount of public repositories
     */
    public int getPublicRepoCount() {
        return publicRepoCount;
    }

    /**
     * Sets the amount of public gists for this user.
     *
     * @param publicGists the amount of public gists of this user
     */
    public void setPublicGistCount(int publicGists) {
        this.publicGistCount = publicGists;
    }

    /**
     * Returns the amount of public gists for this user.
     *
     * @return amount of public gists
     */
    public int getPublicGistCount() {
        return publicGistCount;
    }

    /**
     * Sets the amount of users following this user.
     *
     * @param followers the amount of users following this user
     */
    public void setFollowerCount(int followers) {
        this.followerCount = followers;
    }

    /**
     * Returns the amount of users following this user.
     *
     * @return amount of users following this user
     */
    public int getFollowerCount() {
        return followerCount;
    }

    /**
     * Sets the amount of users that this user is following.
     *
     * @param following the amount of users this user is following
     */
    public void setFollowingCount(int following) {
        this.followingCount = following;
    }

    /**
     * Returns the amount of users that this user is following.
     *
     * @return amount of users this user is following
     */
    public int getFollowingCount() {
        return followingCount;
    }

    /**
     * Sets the URL of this user's Github profile.
     *
     * @param htmlUrl the HTML url of this user's Github profile
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Returns the URL of this user's Github profile.
     *
     * @return HTML url
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Sets the creation time of this user.
     *
     * @param createdAt String representation of creation time of this user
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Returns the creation time of this user.
     *
     * @return String representation of creation time
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the type of this user, ie. "User".
     *
     * @param type the type of this user
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the type of this user, ie. "User".
     *
     * @return type of user
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the amount of private gists for this user.
     *
     * @param privateGistCount the amount of private gists of this user
     */
    public void setPrivateGistCount(int privateGistCount) {
        this.privateGistCount = privateGistCount;
    }

    /**
     * Returns the amount of private gists for this user.
     *
     * @return amount of private gists
     */
    public int getPrivateGistCount() {
        return privateGistCount;
    }

    /**
     * Sets the amount of private repositories for this user.
     *
     * @param privateRepoCount the amount of private repositories of this user
     */
    public void setPrivateRepoCount(int privateRepoCount) {
        this.privateRepoCount = privateRepoCount;
    }

    /**
     * Returns the amount of private repositories for this user.
     *
     * @return amount of private repositories
     */
    public int getPrivateRepoCount() {
        return privateRepoCount;
    }

    /**
     * Sets whether or not this is the currently authenticated user.
     *
     * @param isMe if this is the currently authenticated user
     */
    public void setIsMe(boolean isMe) {
        this.isMe = isMe;
    }

    /**
     * Returns whether or not this is the currently authenticated user.
     *
     * @return if this is the currently authenticated user
     */
    public boolean isMe() {
        return isMe;
    }
}
