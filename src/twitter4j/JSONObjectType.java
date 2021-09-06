package twitter4j;

public final class JSONObjectType {
	private static final Logger logger;

	static {
		logger = Logger.getLogger(JSONObjectType.class);
	}

	public static Type determine(final JSONObject json) {
		if (!json.isNull("sender")) {
			return Type.SENDER;
		}
		if (!json.isNull("text")) {
			return Type.STATUS;
		}
		if (!json.isNull("direct_message")) {
			return Type.DIRECT_MESSAGE;
		}
		if (!json.isNull("delete")) {
			return Type.DELETE;
		}
		if (!json.isNull("limit")) {
			return Type.LIMIT;
		}
		if (!json.isNull("warning")) {
			return Type.STALL_WARNING;
		}
		if (!json.isNull("scrub_geo")) {
			return Type.SCRUB_GEO;
		}
		if (!json.isNull("friends")) {
			return Type.FRIENDS;
		}
		if (!json.isNull("event")) {
			try {
				final String event = json.getString("event");
				if ("favorite".equals(event)) {
					return Type.FAVORITE;
				}
				if ("unfavorite".equals(event)) {
					return Type.UNFAVORITE;
				}
				if ("follow".equals(event)) {
					return Type.FOLLOW;
				}
				if ("unfollow".equals(event)) {
					return Type.UNFOLLOW;
				}
				if (event.startsWith("list")) {
					if ("list_member_added".equals(event)) {
						return Type.USER_LIST_MEMBER_ADDED;
					}
					if ("list_member_removed".equals(event)) {
						return Type.USER_LIST_MEMBER_DELETED;
					}
					if ("list_user_subscribed".equals(event)) {
						return Type.USER_LIST_SUBSCRIBED;
					}
					if ("list_user_unsubscribed".equals(event)) {
						return Type.USER_LIST_UNSUBSCRIBED;
					}
					if ("list_created".equals(event)) {
						return Type.USER_LIST_CREATED;
					}
					if ("list_updated".equals(event)) {
						return Type.USER_LIST_UPDATED;
					}
					if ("list_destroyed".equals(event)) {
						return Type.USER_LIST_DESTROYED;
					}
					return Type.UNKNOWN;
				} else {
					if ("user_update".equals(event)) {
						return Type.USER_UPDATE;
					}
					if ("user_delete".equals(event)) {
						return Type.USER_DELETE;
					}
					if ("user_suspend".equals(event)) {
						return Type.USER_SUSPEND;
					}
					if ("block".equals(event)) {
						return Type.BLOCK;
					}
					if ("unblock".equals(event)) {
						return Type.UNBLOCK;
					}
					if ("retweeted_retweet".equals(event)) {
						return Type.RETWEETED_RETWEET;
					}
					if ("favorited_retweet".equals(event)) {
						return Type.FAVORITED_RETWEET;
					}
					if ("quoted_tweet".equals(event)) {
						return Type.QUOTED_TWEET;
					}
					return Type.UNKNOWN;
				}
			} catch (JSONException jsone) {
				try {
					JSONObjectType.logger.warn("Failed to get event element: ", json.toString(2));
				} catch (JSONException ex) {
				}
			}
		}
		if (!json.isNull("disconnect")) {
			return Type.DISCONNECTION;
		}
		return Type.UNKNOWN;
	}

	public enum Type {
		SENDER("SENDER", 0), STATUS("STATUS", 1), DIRECT_MESSAGE("DIRECT_MESSAGE", 2), DELETE("DELETE", 3),
		LIMIT("LIMIT", 4), STALL_WARNING("STALL_WARNING", 5), SCRUB_GEO("SCRUB_GEO", 6), FRIENDS("FRIENDS", 7),
		FAVORITE("FAVORITE", 8), UNFAVORITE("UNFAVORITE", 9), FOLLOW("FOLLOW", 10), UNFOLLOW("UNFOLLOW", 11),
		USER_LIST_MEMBER_ADDED("USER_LIST_MEMBER_ADDED", 12), USER_LIST_MEMBER_DELETED("USER_LIST_MEMBER_DELETED", 13),
		USER_LIST_SUBSCRIBED("USER_LIST_SUBSCRIBED", 14), USER_LIST_UNSUBSCRIBED("USER_LIST_UNSUBSCRIBED", 15),
		USER_LIST_CREATED("USER_LIST_CREATED", 16), USER_LIST_UPDATED("USER_LIST_UPDATED", 17),
		USER_LIST_DESTROYED("USER_LIST_DESTROYED", 18), USER_UPDATE("USER_UPDATE", 19), USER_DELETE("USER_DELETE", 20),
		USER_SUSPEND("USER_SUSPEND", 21), BLOCK("BLOCK", 22), UNBLOCK("UNBLOCK", 23),
		DISCONNECTION("DISCONNECTION", 24), RETWEETED_RETWEET("RETWEETED_RETWEET", 25),
		FAVORITED_RETWEET("FAVORITED_RETWEET", 26), QUOTED_TWEET("QUOTED_TWEET", 27), UNKNOWN("UNKNOWN", 28);

		private Type(final String s, final int n) {
		}
	}
}
