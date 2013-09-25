package ch.jessex.gistacious.v3.gist;

/**
 * The model for a gist change status, which is the change status of a gist
 * commitment. This is essentially the quantifiable (numerical) diff data for
 * a gist revision, such as the number of additions, the number of deletions and
 * the total number of changes.
 * 
 * @author jessex
 */
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
     *
     * @param additions the amount of additions
     */
    public void setAdditions(int additions) {
        this.additions = additions;
    }

    /**
     * Returns the amount of additions for this change.
     *
     * @return amount of additions
     */
    public int getAdditions() {
        return additions;
    }

    /**
     * Sets the amount of deletions for this change.
     *
     * @param deletions the amount of deletions
     */
    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

    /**
     * Returns the amount of deletions for this change.
     *
     * @return amount of deletions
     */
    public int getDeletions() {
        return deletions;
    }

    /**
     * Sets the total amount of changes for this change.
     *
     * @param total the total amount of changes
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Returns the total amount of changes for this change.
     *
     * @return total amount of changes
     */
    public int getTotal() {
        return total;
    }
}
