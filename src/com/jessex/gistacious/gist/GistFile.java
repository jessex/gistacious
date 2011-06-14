package com.jessex.gistacious.gist;

public class GistFile {

	private String rawUrl;	
	private String content;
	private long size;
	private String filename;
	
	private boolean isRenamed;
	private String oldName;
	
	public GistFile() { }
	
	public GistFile(String filename, String content, String rawUrl, long size) {
		this.filename = filename;
		this.content = content;
		this.rawUrl = rawUrl;
		this.size = size;
	}


	/**
	 * Sets the contents of the file.
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the contents of the file.
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the filename of the file.
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Returns the filename of the file.
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the size of the file.
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * Returns the size of the file.
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * Sets the raw access URL of the file.
	 * @param rawUrl the rawUrl to set
	 */
	public void setRawUrl(String rawUrl) {
		this.rawUrl = rawUrl;
	}

	/**
	 * Returns the raw access URL of the file.
	 * @return the rawUrl
	 */
	public String getRawUrl() {
		return rawUrl;
	}

	/**
	 * Sets that this file is a renamed version of an old file in a Gist edit.
	 * @param isRenamed the isRenamed to set
	 */
	public void setRenamed(boolean isRenamed) {
		this.isRenamed = isRenamed;
	}

	/**
	 * Returns whether this file is a renamed version of an old file in a Gist
	 * edit.
	 * @return the isRenamed
	 */
	public boolean isRenamed() {
		return isRenamed;
	}

	/**
	 * Sets the name of the file in a previous revision.
	 * @param oldName the oldName to set
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	/**
	 * Returns the name of the file in a previous revision.
	 * @return the oldName
	 */
	public String getOldName() {
		return oldName;
	}
	
	
	
}
