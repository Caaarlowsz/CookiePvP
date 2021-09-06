package twitter4j;

import java.util.Map;

import twitter4j.api.HelpResources;
import twitter4j.conf.Configuration;

class JSONImplFactory implements ObjectFactory {
	private static final long serialVersionUID = -1853541456182663343L;
	private final Configuration conf;

	public JSONImplFactory(final Configuration conf) {
		this.conf = conf;
	}

	@Override
	public Status createStatus(final JSONObject json) throws TwitterException {
		return new StatusJSONImpl(json);
	}

	@Override
	public User createUser(final JSONObject json) throws TwitterException {
		return new UserJSONImpl(json);
	}

	@Override
	public UserList createAUserList(final JSONObject json) throws TwitterException {
		return new UserListJSONImpl(json);
	}

	@Override
	public Map<String, RateLimitStatus> createRateLimitStatuses(final HttpResponse res) throws TwitterException {
		return RateLimitStatusJSONImpl.createRateLimitStatuses(res, this.conf);
	}

	@Override
	public Status createStatus(final HttpResponse res) throws TwitterException {
		return new StatusJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<Status> createStatusList(final HttpResponse res) throws TwitterException {
		return StatusJSONImpl.createStatusList(res, this.conf);
	}

	static GeoLocation createGeoLocation(final JSONObject json) throws TwitterException {
		try {
			if (!json.isNull("coordinates")) {
				String coordinates = json.getJSONObject("coordinates").getString("coordinates");
				coordinates = coordinates.substring(1, coordinates.length() - 1);
				final String[] point = coordinates.split(",");
				return new GeoLocation(Double.parseDouble(point[1]), Double.parseDouble(point[0]));
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
		return null;
	}

	static GeoLocation[][] coordinatesAsGeoLocationArray(final JSONArray coordinates) throws TwitterException {
		try {
			final GeoLocation[][] boundingBox = new GeoLocation[coordinates.length()][];
			for (int i = 0; i < coordinates.length(); ++i) {
				final JSONArray array = coordinates.getJSONArray(i);
				boundingBox[i] = new GeoLocation[array.length()];
				for (int j = 0; j < array.length(); ++j) {
					final JSONArray coordinate = array.getJSONArray(j);
					boundingBox[i][j] = new GeoLocation(coordinate.getDouble(1), coordinate.getDouble(0));
				}
			}
			return boundingBox;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	public static RateLimitStatus createRateLimitStatusFromResponseHeader(final HttpResponse res) {
		return RateLimitStatusJSONImpl.createFromResponseHeader(res);
	}

	@Override
	public Trends createTrends(final HttpResponse res) throws TwitterException {
		return new TrendsJSONImpl(res, this.conf);
	}

	@Override
	public User createUser(final HttpResponse res) throws TwitterException {
		return new UserJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<User> createUserList(final HttpResponse res) throws TwitterException {
		return UserJSONImpl.createUserList(res, this.conf);
	}

	@Override
	public ResponseList<User> createUserListFromJSONArray(final HttpResponse res) throws TwitterException {
		return UserJSONImpl.createUserList(res.asJSONArray(), res, this.conf);
	}

	@Override
	public ResponseList<User> createUserListFromJSONArray_Users(final HttpResponse res) throws TwitterException {
		try {
			return UserJSONImpl.createUserList(res.asJSONObject().getJSONArray("users"), res, this.conf);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public QueryResult createQueryResult(final HttpResponse res, final Query query) throws TwitterException {
		try {
			return new QueryResultJSONImpl(res, this.conf);
		} catch (TwitterException te) {
			if (404 == te.getStatusCode()) {
				return new QueryResultJSONImpl(query);
			}
			throw te;
		}
	}

	@Override
	public IDs createIDs(final HttpResponse res) throws TwitterException {
		return new IDsJSONImpl(res, this.conf);
	}

	@Override
	public PagableResponseList<User> createPagableUserList(final HttpResponse res) throws TwitterException {
		return UserJSONImpl.createPagableUserList(res, this.conf);
	}

	@Override
	public UserList createAUserList(final HttpResponse res) throws TwitterException {
		return new UserListJSONImpl(res, this.conf);
	}

	@Override
	public PagableResponseList<UserList> createPagableUserListList(final HttpResponse res) throws TwitterException {
		return UserListJSONImpl.createPagableUserListList(res, this.conf);
	}

	@Override
	public ResponseList<UserList> createUserListList(final HttpResponse res) throws TwitterException {
		return UserListJSONImpl.createUserListList(res, this.conf);
	}

	@Override
	public ResponseList<Category> createCategoryList(final HttpResponse res) throws TwitterException {
		return CategoryJSONImpl.createCategoriesList(res, this.conf);
	}

	@Override
	public DirectMessage createDirectMessage(final HttpResponse res) throws TwitterException {
		return new DirectMessageJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<DirectMessage> createDirectMessageList(final HttpResponse res) throws TwitterException {
		return DirectMessageJSONImpl.createDirectMessageList(res, this.conf);
	}

	@Override
	public Relationship createRelationship(final HttpResponse res) throws TwitterException {
		return new RelationshipJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<Friendship> createFriendshipList(final HttpResponse res) throws TwitterException {
		return FriendshipJSONImpl.createFriendshipList(res, this.conf);
	}

	@Override
	public AccountTotals createAccountTotals(final HttpResponse res) throws TwitterException {
		return new AccountTotalsJSONImpl(res, this.conf);
	}

	@Override
	public AccountSettings createAccountSettings(final HttpResponse res) throws TwitterException {
		return new AccountSettingsJSONImpl(res, this.conf);
	}

	@Override
	public SavedSearch createSavedSearch(final HttpResponse res) throws TwitterException {
		return new SavedSearchJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<SavedSearch> createSavedSearchList(final HttpResponse res) throws TwitterException {
		return SavedSearchJSONImpl.createSavedSearchList(res, this.conf);
	}

	@Override
	public ResponseList<Location> createLocationList(final HttpResponse res) throws TwitterException {
		return LocationJSONImpl.createLocationList(res, this.conf);
	}

	@Override
	public Place createPlace(final HttpResponse res) throws TwitterException {
		return new PlaceJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<Place> createPlaceList(final HttpResponse res) throws TwitterException {
		try {
			return PlaceJSONImpl.createPlaceList(res, this.conf);
		} catch (TwitterException te) {
			if (te.getStatusCode() == 404) {
				return new ResponseListImpl<Place>(0, null);
			}
			throw te;
		}
	}

	@Override
	public TwitterAPIConfiguration createTwitterAPIConfiguration(final HttpResponse res) throws TwitterException {
		return new TwitterAPIConfigurationJSONImpl(res, this.conf);
	}

	@Override
	public ResponseList<HelpResources.Language> createLanguageList(final HttpResponse res) throws TwitterException {
		return LanguageJSONImpl.createLanguageList(res, this.conf);
	}

	@Override
	public <T> ResponseList<T> createEmptyResponseList() {
		return new ResponseListImpl<T>(0, null);
	}

	@Override
	public OEmbed createOEmbed(final HttpResponse res) throws TwitterException {
		return new OEmbedJSONImpl(res, this.conf);
	}

	public static HashtagEntity createHashtagEntity(final int start, final int end, final String text) {
		return new HashtagEntityJSONImpl(start, end, text);
	}

	public static UserMentionEntity createUserMentionEntity(final int start, final int end, final String name,
			final String screenName, final long id) {
		return new UserMentionEntityJSONImpl(start, end, name, screenName, id);
	}

	public static URLEntity createUrlEntity(final int start, final int end, final String url, final String expandedURL,
			final String displayURL) {
		return new URLEntityJSONImpl(start, end, url, expandedURL, displayURL);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof JSONImplFactory)) {
			return false;
		}
		final JSONImplFactory that = (JSONImplFactory) o;
		if (this.conf != null) {
			if (this.conf.equals(that.conf)) {
				return true;
			}
		} else if (that.conf == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.conf != null) ? this.conf.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "JSONImplFactory{conf=" + this.conf + '}';
	}
}
