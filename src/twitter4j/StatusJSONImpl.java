package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import twitter4j.conf.Configuration;

final class StatusJSONImpl extends TwitterResponseImpl implements Status, Serializable {
	private static final long serialVersionUID = -6461195536943679985L;
	private Date createdAt;
	private long id;
	private String text;
	private String source;
	private boolean isTruncated;
	private long inReplyToStatusId;
	private long inReplyToUserId;
	private boolean isFavorited;
	private boolean isRetweeted;
	private int favoriteCount;
	private String inReplyToScreenName;
	private GeoLocation geoLocation;
	private Place place;
	private long retweetCount;
	private boolean isPossiblySensitive;
	private String lang;
	private long[] contributorsIDs;
	private Status retweetedStatus;
	private UserMentionEntity[] userMentionEntities;
	private URLEntity[] urlEntities;
	private HashtagEntity[] hashtagEntities;
	private MediaEntity[] mediaEntities;
	private ExtendedMediaEntity[] extendedMediaEntities;
	private SymbolEntity[] symbolEntities;
	private long currentUserRetweetId;
	private Scopes scopes;
	private User user;
	private String[] withheldInCountries;
	private Status quotedStatus;
	private long quotedStatusId;

	StatusJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		this.geoLocation = null;
		this.place = null;
		this.currentUserRetweetId = -1L;
		this.user = null;
		this.withheldInCountries = null;
		this.quotedStatusId = -1L;
		final JSONObject json = res.asJSONObject();
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	StatusJSONImpl(final JSONObject json, final Configuration conf) throws TwitterException {
		this.geoLocation = null;
		this.place = null;
		this.currentUserRetweetId = -1L;
		this.user = null;
		this.withheldInCountries = null;
		this.quotedStatusId = -1L;
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	StatusJSONImpl(final JSONObject json) throws TwitterException {
		this.geoLocation = null;
		this.place = null;
		this.currentUserRetweetId = -1L;
		this.user = null;
		this.withheldInCountries = null;
		this.quotedStatusId = -1L;
		this.init(json);
	}

	StatusJSONImpl() {
		this.geoLocation = null;
		this.place = null;
		this.currentUserRetweetId = -1L;
		this.user = null;
		this.withheldInCountries = null;
		this.quotedStatusId = -1L;
	}

	private void init(final JSONObject json) throws TwitterException {
		this.id = ParseUtil.getLong("id", json);
		this.source = ParseUtil.getUnescapedString("source", json);
		this.createdAt = ParseUtil.getDate("created_at", json);
		this.isTruncated = ParseUtil.getBoolean("truncated", json);
		this.inReplyToStatusId = ParseUtil.getLong("in_reply_to_status_id", json);
		this.inReplyToUserId = ParseUtil.getLong("in_reply_to_user_id", json);
		this.isFavorited = ParseUtil.getBoolean("favorited", json);
		this.isRetweeted = ParseUtil.getBoolean("retweeted", json);
		this.inReplyToScreenName = ParseUtil.getUnescapedString("in_reply_to_screen_name", json);
		this.retweetCount = ParseUtil.getLong("retweet_count", json);
		this.favoriteCount = ParseUtil.getInt("favorite_count", json);
		this.isPossiblySensitive = ParseUtil.getBoolean("possibly_sensitive", json);
		try {
			if (!json.isNull("user")) {
				this.user = new UserJSONImpl(json.getJSONObject("user"));
			}
			this.geoLocation = JSONImplFactory.createGeoLocation(json);
			if (!json.isNull("place")) {
				this.place = new PlaceJSONImpl(json.getJSONObject("place"));
			}
			if (!json.isNull("retweeted_status")) {
				this.retweetedStatus = new StatusJSONImpl(json.getJSONObject("retweeted_status"));
			}
			if (!json.isNull("contributors")) {
				final JSONArray contributorsArray = json.getJSONArray("contributors");
				this.contributorsIDs = new long[contributorsArray.length()];
				for (int i = 0; i < contributorsArray.length(); ++i) {
					this.contributorsIDs[i] = Long.parseLong(contributorsArray.getString(i));
				}
			} else {
				this.contributorsIDs = new long[0];
			}
			if (!json.isNull("entities")) {
				final JSONObject entities = json.getJSONObject("entities");
				if (!entities.isNull("user_mentions")) {
					final JSONArray userMentionsArray = entities.getJSONArray("user_mentions");
					final int len = userMentionsArray.length();
					this.userMentionEntities = new UserMentionEntity[len];
					for (int j = 0; j < len; ++j) {
						this.userMentionEntities[j] = new UserMentionEntityJSONImpl(userMentionsArray.getJSONObject(j));
					}
				}
				if (!entities.isNull("urls")) {
					final JSONArray urlsArray = entities.getJSONArray("urls");
					final int len = urlsArray.length();
					this.urlEntities = new URLEntity[len];
					for (int j = 0; j < len; ++j) {
						this.urlEntities[j] = new URLEntityJSONImpl(urlsArray.getJSONObject(j));
					}
				}
				if (!entities.isNull("hashtags")) {
					final JSONArray hashtagsArray = entities.getJSONArray("hashtags");
					final int len = hashtagsArray.length();
					this.hashtagEntities = new HashtagEntity[len];
					for (int j = 0; j < len; ++j) {
						this.hashtagEntities[j] = new HashtagEntityJSONImpl(hashtagsArray.getJSONObject(j));
					}
				}
				if (!entities.isNull("symbols")) {
					final JSONArray hashtagsArray = entities.getJSONArray("symbols");
					final int len = hashtagsArray.length();
					this.symbolEntities = new SymbolEntity[len];
					for (int j = 0; j < len; ++j) {
						this.symbolEntities[j] = new HashtagEntityJSONImpl(hashtagsArray.getJSONObject(j));
					}
				}
				if (!entities.isNull("media")) {
					final JSONArray mediaArray = entities.getJSONArray("media");
					final int len = mediaArray.length();
					this.mediaEntities = new MediaEntity[len];
					for (int j = 0; j < len; ++j) {
						this.mediaEntities[j] = new MediaEntityJSONImpl(mediaArray.getJSONObject(j));
					}
				}
			}
			if (!json.isNull("extended_entities")) {
				final JSONObject extendedEntities = json.getJSONObject("extended_entities");
				if (!extendedEntities.isNull("media")) {
					final JSONArray mediaArray2 = extendedEntities.getJSONArray("media");
					final int len2 = mediaArray2.length();
					this.extendedMediaEntities = new ExtendedMediaEntity[len2];
					for (int j = 0; j < len2; ++j) {
						this.extendedMediaEntities[j] = new ExtendedMediaEntityJSONImpl(mediaArray2.getJSONObject(j));
					}
				}
			}
			if (!json.isNull("quoted_status")) {
				this.quotedStatus = new StatusJSONImpl(json.getJSONObject("quoted_status"));
			}
			if (!json.isNull("quoted_status_id")) {
				this.quotedStatusId = ParseUtil.getLong("quoted_status_id", json);
			}
			if (!json.isNull("quoted_status")) {
				this.quotedStatus = new StatusJSONImpl(json.getJSONObject("quoted_status"));
			}
			if (!json.isNull("quoted_status_id")) {
				this.quotedStatusId = ParseUtil.getLong("quoted_status_id", json);
			}
			this.userMentionEntities = ((this.userMentionEntities == null) ? new UserMentionEntity[0]
					: this.userMentionEntities);
			this.urlEntities = ((this.urlEntities == null) ? new URLEntity[0] : this.urlEntities);
			this.hashtagEntities = ((this.hashtagEntities == null) ? new HashtagEntity[0] : this.hashtagEntities);
			this.symbolEntities = ((this.symbolEntities == null) ? new SymbolEntity[0] : this.symbolEntities);
			this.mediaEntities = ((this.mediaEntities == null) ? new MediaEntity[0] : this.mediaEntities);
			this.extendedMediaEntities = ((this.extendedMediaEntities == null) ? new ExtendedMediaEntity[0]
					: this.extendedMediaEntities);
			this.text = HTMLEntity.unescapeAndSlideEntityIncdices(json.getString("text"), this.userMentionEntities,
					this.urlEntities, this.hashtagEntities, this.mediaEntities);
			if (!json.isNull("current_user_retweet")) {
				this.currentUserRetweetId = json.getJSONObject("current_user_retweet").getLong("id");
			}
			if (!json.isNull("lang")) {
				this.lang = ParseUtil.getUnescapedString("lang", json);
			}
			if (!json.isNull("scopes")) {
				final JSONObject scopesJson = json.getJSONObject("scopes");
				if (!scopesJson.isNull("place_ids")) {
					final JSONArray placeIdsArray = scopesJson.getJSONArray("place_ids");
					final int len2 = placeIdsArray.length();
					final String[] placeIds = new String[len2];
					for (int k = 0; k < len2; ++k) {
						placeIds[k] = placeIdsArray.getString(k);
					}
					this.scopes = new ScopesImpl(placeIds);
				}
			}
			if (!json.isNull("withheld_in_countries")) {
				final JSONArray withheld_in_countries = json.getJSONArray("withheld_in_countries");
				final int length = withheld_in_countries.length();
				this.withheldInCountries = new String[length];
				for (int l = 0; l < length; ++l) {
					this.withheldInCountries[l] = withheld_in_countries.getString(l);
				}
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public int compareTo(final Status that) {
		final long delta = this.id - that.getId();
		if (delta < -2147483648L) {
			return Integer.MIN_VALUE;
		}
		if (delta > 2147483647L) {
			return Integer.MAX_VALUE;
		}
		return (int) delta;
	}

	@Override
	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public boolean isTruncated() {
		return this.isTruncated;
	}

	@Override
	public long getInReplyToStatusId() {
		return this.inReplyToStatusId;
	}

	@Override
	public long getInReplyToUserId() {
		return this.inReplyToUserId;
	}

	@Override
	public String getInReplyToScreenName() {
		return this.inReplyToScreenName;
	}

	@Override
	public GeoLocation getGeoLocation() {
		return this.geoLocation;
	}

	@Override
	public Place getPlace() {
		return this.place;
	}

	@Override
	public long[] getContributors() {
		return this.contributorsIDs;
	}

	@Override
	public boolean isFavorited() {
		return this.isFavorited;
	}

	@Override
	public boolean isRetweeted() {
		return this.isRetweeted;
	}

	@Override
	public int getFavoriteCount() {
		return this.favoriteCount;
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public boolean isRetweet() {
		return this.retweetedStatus != null;
	}

	@Override
	public Status getRetweetedStatus() {
		return this.retweetedStatus;
	}

	@Override
	public int getRetweetCount() {
		return (int) this.retweetCount;
	}

	@Override
	public boolean isRetweetedByMe() {
		return this.currentUserRetweetId != -1L;
	}

	@Override
	public long getCurrentUserRetweetId() {
		return this.currentUserRetweetId;
	}

	@Override
	public boolean isPossiblySensitive() {
		return this.isPossiblySensitive;
	}

	@Override
	public UserMentionEntity[] getUserMentionEntities() {
		return this.userMentionEntities;
	}

	@Override
	public URLEntity[] getURLEntities() {
		return this.urlEntities;
	}

	@Override
	public HashtagEntity[] getHashtagEntities() {
		return this.hashtagEntities;
	}

	@Override
	public MediaEntity[] getMediaEntities() {
		return this.mediaEntities;
	}

	@Override
	public ExtendedMediaEntity[] getExtendedMediaEntities() {
		return this.extendedMediaEntities;
	}

	@Override
	public SymbolEntity[] getSymbolEntities() {
		return this.symbolEntities;
	}

	@Override
	public Scopes getScopes() {
		return this.scopes;
	}

	@Override
	public String[] getWithheldInCountries() {
		return this.withheldInCountries;
	}

	@Override
	public long getQuotedStatusId() {
		return this.quotedStatusId;
	}

	@Override
	public Status getQuotedStatus() {
		return this.quotedStatus;
	}

	@Override
	public String getLang() {
		return this.lang;
	}

	static ResponseList<Status> createStatusList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final JSONArray list = res.asJSONArray();
			final int size = list.length();
			final ResponseList<Status> statuses = new ResponseListImpl<Status>(size, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject json = list.getJSONObject(i);
				final Status status = new StatusJSONImpl(json);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(status, json);
				}
				statuses.add(status);
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(statuses, list);
			}
			return statuses;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public int hashCode() {
		return (int) this.id;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj != null && (this == obj || (obj instanceof Status && ((Status) obj).getId() == this.id));
	}

	@Override
	public String toString() {
		return "StatusJSONImpl{createdAt=" + this.createdAt + ", id=" + this.id + ", text='" + this.text + '\''
				+ ", source='" + this.source + '\'' + ", isTruncated=" + this.isTruncated + ", inReplyToStatusId="
				+ this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited="
				+ this.isFavorited + ", isRetweeted=" + this.isRetweeted + ", favoriteCount=" + this.favoriteCount
				+ ", inReplyToScreenName='" + this.inReplyToScreenName + '\'' + ", geoLocation=" + this.geoLocation
				+ ", place=" + this.place + ", retweetCount=" + this.retweetCount + ", isPossiblySensitive="
				+ this.isPossiblySensitive + ", lang='" + this.lang + '\'' + ", contributorsIDs="
				+ Arrays.toString(this.contributorsIDs) + ", retweetedStatus=" + this.retweetedStatus
				+ ", userMentionEntities=" + Arrays.toString(this.userMentionEntities) + ", urlEntities="
				+ Arrays.toString(this.urlEntities) + ", hashtagEntities=" + Arrays.toString(this.hashtagEntities)
				+ ", mediaEntities=" + Arrays.toString(this.mediaEntities) + ", symbolEntities="
				+ Arrays.toString(this.symbolEntities) + ", currentUserRetweetId=" + this.currentUserRetweetId
				+ ", user=" + this.user + ", withHeldInCountries=" + Arrays.toString(this.withheldInCountries)
				+ ", quotedStatusId=" + this.quotedStatusId + ", quotedStatus=" + this.quotedStatus + '}';
	}
}
