package com.jessex.gistacious.json;

/**
 * A cache of parsed Gist* objects to be used in JSON deserialization to save
 * time in repeated calls to the Gist API.
 *
 * @param <K> key for the cache (typically a String)
 * @param <V> value for the cache (such as Gist, GistComment, etc.)
 * 
 * @author jessex
 */
public interface JsonCache<K,V> {
	
	/**
	 * Returns if the cache contains an entry with the given key.
	 * 
	 * @param key key to search for in cache
	 * @return whether or not the key is in the cache
	 */
	boolean isInCache(K key);
	
	/**
	 * Returns the value in the cache corresponding to the given key. Returns 
	 * null if the key is not found within the cache.
	 * 
	 * @param key key to search for in cache
	 * @return value corresponding to key in key-value pair in cache
	 */
	V getValue(K key);
	
	/**
	 * Puts the key-value pair into the cache. If the given key is already in an
	 * entry in the cache, the current value corresponding to the key is 
	 * overwritten with the given value. Otherwise, a new entry is created.
	 * 
	 * @param key key to add to cache
	 * @param value value to add to cache
	 */
	void putValue(K key, V value);
	
	/**
	 * Resets the cache to its original, empty state.
	 */
	void resetCache();
	
}
