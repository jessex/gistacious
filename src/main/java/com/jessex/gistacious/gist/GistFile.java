package com.jessex.gistacious.gist;

/**
 * The model for a gist file, which is an actual text file of some sort that
 * composes part or all of the content of a gist.
 * 
 * @author jessex
 */
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
     *
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns the contents of the file.
     *
     * @return file content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the filename of the file.
     *
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Returns the filename of the file.
     *
     * @return file filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the size of the file in kilobytes.
     *
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Returns the size of the file in kilobytes.
     *
     * @return file size
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the raw access URL of the file.
     *
     * @param rawUrl String representation of the raw url of this file
     */
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    /**
     * Returns the raw access URL of the file.
     *
     * @return String representation of the raw url
     */
    public String getRawUrl() {
        return rawUrl;
    }

    /**
     * Sets whether or not this file is a renamed version of an old file in a
     * Gist edit.
     *
     * @param isRenamed whether or not this is a renamed version of an old file
     */
    public void setRenamed(boolean isRenamed) {
        this.isRenamed = isRenamed;
    }

    /**
     * Returns whether or notthis file is a renamed version of an old file in a
     * Gist edit.
     *
     * @return whether or not this file is a renamed version of an old file
     */
    public boolean isRenamed() {
        return isRenamed;
    }

    /**
     * Sets the name of the file in a previous revision.
     *
     * @param oldName the name of an older version of this file
     */
    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    /**
     * Returns the name of the file in a previous revision.
     *
     * @return name of an older version of this file
     */
    public String getOldName() {
        return oldName;
    }
}
