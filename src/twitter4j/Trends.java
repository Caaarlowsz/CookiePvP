package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface Trends extends TwitterResponse, Comparable<Trends>, Serializable {
	Trend[] getTrends();

	Location getLocation();

	Date getAsOf();

	Date getTrendAt();
}
