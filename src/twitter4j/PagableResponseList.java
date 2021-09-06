package twitter4j;

public interface PagableResponseList<T extends TwitterResponse> extends ResponseList<T>, CursorSupport {
	boolean hasPrevious();

	long getPreviousCursor();

	boolean hasNext();

	long getNextCursor();
}
