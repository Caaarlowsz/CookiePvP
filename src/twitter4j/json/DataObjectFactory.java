package twitter4j.json;

import java.util.Map;

import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.UserList;

public final class DataObjectFactory {
	private DataObjectFactory() {
		throw new AssertionError((Object) "not intended to be instantiated.");
	}

	public static String getRawJSON(final Object obj) {
		return TwitterObjectFactory.getRawJSON(obj);
	}

	public static Status createStatus(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createStatus(rawJSON);
	}

	public static User createUser(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createUser(rawJSON);
	}

	public static AccountTotals createAccountTotals(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createAccountTotals(rawJSON);
	}

	public static Relationship createRelationship(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createRelationship(rawJSON);
	}

	public static Place createPlace(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createPlace(rawJSON);
	}

	public static SavedSearch createSavedSearch(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createSavedSearch(rawJSON);
	}

	public static Trend createTrend(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createTrend(rawJSON);
	}

	public static Trends createTrends(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createTrends(rawJSON);
	}

	public static IDs createIDs(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createIDs(rawJSON);
	}

	public static Map<String, RateLimitStatus> createRateLimitStatus(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createRateLimitStatus(rawJSON);
	}

	public static Category createCategory(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createCategory(rawJSON);
	}

	public static DirectMessage createDirectMessage(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createDirectMessage(rawJSON);
	}

	public static Location createLocation(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createLocation(rawJSON);
	}

	public static UserList createUserList(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createUserList(rawJSON);
	}

	public static OEmbed createOEmbed(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createOEmbed(rawJSON);
	}

	@Deprecated
	public static Object createObject(final String rawJSON) throws TwitterException {
		return TwitterObjectFactory.createObject(rawJSON);
	}
}
