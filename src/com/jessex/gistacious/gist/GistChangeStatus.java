package com.jessex.gistacious.gist;

public class GistChangeStatus {

	private int additions;
	
	private int deletions;
	
	private int total;
	
	public GistChangeStatus() { }
	
	public GistChangeStatus(int additions, int deletions, int total) {
		this.additions = additions;
		this.deletions = deletions;
		this.total = total;
	}

	/**
	 * Sets the amount of additions for this change.
	 * @param additions the additions to set
	 */
	public void setAdditions(int additions) {
		this.additions = additions;
	}

	/**
	 * Returns the amount of additions for this change.
	 * @return the additions
	 */
	public int getAdditions() {
		return additions;
	}

	/**
	 * Sets the amount of deletions for this change.
	 * @param deletions the deletions to set
	 */
	public void setDeletions(int deletions) {
		this.deletions = deletions;
	}

	/**
	 * Returns the amount of deletions for this change.
	 * @return the deletions
	 */
	public int getDeletions() {
		return deletions;
	}

	/**
	 * Sets the total amount of changes for this change.
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Returns the total amount of changes for this change.
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	
	
}
