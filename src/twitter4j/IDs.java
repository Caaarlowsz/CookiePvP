package twitter4j;

import java.io.Serializable;

public interface IDs extends TwitterResponse, CursorSupport, Serializable {
	long[] getIDs();

	boolean hasPrevious();

	long getPreviousCursor();

	boolean hasNext();

	long getNextCursor();
}
