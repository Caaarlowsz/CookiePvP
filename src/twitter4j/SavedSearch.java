package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface SavedSearch extends Comparable<SavedSearch>, TwitterResponse, Serializable {
	Date getCreatedAt();

	String getQuery();

	int getPosition();

	String getName();

	long getId();
}
