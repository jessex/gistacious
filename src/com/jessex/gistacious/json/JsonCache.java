package com.jessex.gistacious.json;

public interface JsonCache<K,V> {

	void resetCache();
	
	boolean isInCache(K key);
	
	V getValue(K key);
	
	void putValue(K key, V value);
	
}
