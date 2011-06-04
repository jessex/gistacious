package com.jessex.gistacious.json;

import java.util.HashMap;

import com.jessex.gistacious.gist.GistUser;

public class JsonCache {

	private HashMap<String, GistUser> userCache;
	
	public JsonCache() {
		this.userCache = new HashMap<String, GistUser>();
	}
	
	/**
	 * Returns whether or not the GistUser with the given login is in the user
	 * cache.
	 * @param login -
	 * 			login of GistUser
	 * @return isInCache -
	 * 			whether or not user with login is in cache
	 */
	public boolean isInCache(String login) {
		return userCache.containsKey(login);
	}
	
	/**
	 * Returns the GistUser in the user cache with the given login.
	 * @param login -
	 * 			login of GistUser
	 * @return user -
	 * 			GistUser with given login
	 */
	public GistUser getUser(String login) {
		return userCache.get(login);
	}
	
	/**
	 * Adds the given GistUser to the user cache.
	 * @param user -
	 * 			GistUser to add to cache
	 */
	public void addUser(GistUser user) {
		userCache.put(user.getLogin(), user);
	}
	
	/**
	 * Resets the user cache by clearing all entries.
	 */
	public void resetCache() {
		this.userCache.clear();
	}
	
}
