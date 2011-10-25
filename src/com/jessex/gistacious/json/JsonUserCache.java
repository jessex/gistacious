package com.jessex.gistacious.json;

import java.util.HashMap;
import java.util.Map;

import com.jessex.gistacious.gist.GistUser;

/**
 * Implementation of JsonCache for GistUser objects.
 * 
 * @author jessex
 */
public class JsonUserCache implements JsonCache<String, GistUser>{

	private Map<String, GistUser> userCache;
	
	public JsonUserCache() {
		this.userCache = new HashMap<String, GistUser>();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean isInCache(String login) {
		return userCache.containsKey(login);
	}
	
	/** {@inheritDoc} */
	@Override
	public GistUser getValue(String login) {
		return userCache.get(login);
	}
	
	/** {@inheritDoc} */
	@Override
	public void putValue(String login, GistUser user) {
		userCache.put(user.getLogin(), user);
	}
	
	/** {@inheritDoc} */
    @Override
	public void resetCache() {
		this.userCache.clear();
	}
	
}
