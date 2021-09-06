package twitter4j;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public final class TwitterObjectFactory {
	private static final ThreadLocal<Map> rawJsonMap;
	private static boolean registeredAtleastOnce;

	static {
		rawJsonMap = new ThreadLocal<Map>() {
			@Override
			protected Map initialValue() {
				return new HashMap();
			}
		};
		TwitterObjectFactory.registeredAtleastOnce = false;
	}

	private TwitterObjectFactory() {
		throw new AssertionError((Object) "not intended to be instantiated.");
	}

	public static String getRawJSON(final Object obj) {
		if (!TwitterObjectFactory.registeredAtleastOnce) {
			throw new IllegalStateException("Apparently jsonStoreEnabled is not set to true.");
		}
		final Object json = TwitterObjectFactory.rawJsonMap.get().get(obj);
		if (json instanceof String) {
			return (String) json;
		}
		if (json != null) {
			return json.toString();
		}
		return null;
	}

	public static Status createStatus(final String rawJSON) throws TwitterException {
		try {
			return new StatusJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static User createUser(final String rawJSON) throws TwitterException {
		try {
			return new UserJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static AccountTotals createAccountTotals(final String rawJSON) throws TwitterException {
		try {
			return new AccountTotalsJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Relationship createRelationship(final String rawJSON) throws TwitterException {
		try {
			return new RelationshipJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Place createPlace(final String rawJSON) throws TwitterException {
		try {
			return new PlaceJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static SavedSearch createSavedSearch(final String rawJSON) throws TwitterException {
		try {
			return new SavedSearchJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Trend createTrend(final String rawJSON) throws TwitterException {
		try {
			return new TrendJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Trends createTrends(final String rawJSON) throws TwitterException {
		return new TrendsJSONImpl(rawJSON);
	}

	public static IDs createIDs(final String rawJSON) throws TwitterException {
		return new IDsJSONImpl(rawJSON);
	}

	public static Map<String, RateLimitStatus> createRateLimitStatus(final String rawJSON) throws TwitterException {
		try {
			return RateLimitStatusJSONImpl.createRateLimitStatuses(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Category createCategory(final String rawJSON) throws TwitterException {
		try {
			return new CategoryJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static DirectMessage createDirectMessage(final String rawJSON) throws TwitterException {
		try {
			return new DirectMessageJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Location createLocation(final String rawJSON) throws TwitterException {
		try {
			return new LocationJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static UserList createUserList(final String rawJSON) throws TwitterException {
		try {
			return new UserListJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static OEmbed createOEmbed(final String rawJSON) throws TwitterException {
		try {
			return new OEmbedJSONImpl(new JSONObject(rawJSON));
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	public static Object createObject(final String rawJSON) throws TwitterException {
		try {
			final JSONObject json = new JSONObject(rawJSON);
			final JSONObjectType.Type jsonObjectType = JSONObjectType.determine(json);
			switch (jsonObjectType) {
			case SENDER: {
				return registerJSONObject(new DirectMessageJSONImpl(json.getJSONObject("direct_message")), json);
			}
			case STATUS: {
				return registerJSONObject(new StatusJSONImpl(json), json);
			}
			case DIRECT_MESSAGE: {
				return registerJSONObject(new DirectMessageJSONImpl(json.getJSONObject("direct_message")), json);
			}
			case DELETE: {
				return registerJSONObject(
						new StatusDeletionNoticeImpl(json.getJSONObject("delete").getJSONObject("status")), json);
			}
			case LIMIT: {
				return json;
			}
			case SCRUB_GEO: {
				return json;
			}
			default: {
				return json;
			}
			}
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	static void clearThreadLocalMap() {
		TwitterObjectFactory.rawJsonMap.get().clear();
	}

	@SuppressWarnings("unchecked")
	static <T> T registerJSONObject(final T key, final Object json) {
		TwitterObjectFactory.registeredAtleastOnce = true;
		TwitterObjectFactory.rawJsonMap.get().put(key, json);
		return key;
	}
}
