package twitter4j;

import java.io.Serializable;

public interface AccountTotals extends TwitterResponse, Serializable {
	int getUpdates();

	int getFollowers();

	int getFavorites();

	int getFriends();
}
