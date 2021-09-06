package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import twitter4j.conf.Configuration;

final class UserJSONImpl extends TwitterResponseImpl implements User, Serializable {
	private static final long serialVersionUID = -5448266606847617015L;
	private long id;
	private String name;
	private String screenName;
	private String location;
	private String description;
	private URLEntity[] descriptionURLEntities;
	private URLEntity urlEntity;
	private boolean isContributorsEnabled;
	private String profileImageUrl;
	private String profileImageUrlHttps;
	private boolean isDefaultProfileImage;
	private String url;
	private boolean isProtected;
	private int followersCount;
	private Status status;
	private String profileBackgroundColor;
	private String profileTextColor;
	private String profileLinkColor;
	private String profileSidebarFillColor;
	private String profileSidebarBorderColor;
	private boolean profileUseBackgroundImage;
	private boolean isDefaultProfile;
	private boolean showAllInlineMedia;
	private int friendsCount;
	private Date createdAt;
	private int favouritesCount;
	private int utcOffset;
	private String timeZone;
	private String profileBackgroundImageUrl;
	private String profileBackgroundImageUrlHttps;
	private String profileBannerImageUrl;
	private boolean profileBackgroundTiled;
	private String lang;
	private int statusesCount;
	private boolean isGeoEnabled;
	private boolean isVerified;
	private boolean translator;
	private int listedCount;
	private boolean isFollowRequestSent;
	private String[] withheldInCountries;

	UserJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
		}
		final JSONObject json = res.asJSONObject();
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	UserJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	UserJSONImpl() {
	}

	private void init(final JSONObject json) throws TwitterException {
		try {
			this.id = ParseUtil.getLong("id", json);
			this.name = ParseUtil.getRawString("name", json);
			this.screenName = ParseUtil.getRawString("screen_name", json);
			this.location = ParseUtil.getRawString("location", json);
			this.descriptionURLEntities = getURLEntitiesFromJSON(json, "description");
			final URLEntity[] urlEntities = getURLEntitiesFromJSON(json, "url");
			if (urlEntities.length > 0) {
				this.urlEntity = urlEntities[0];
			}
			this.description = ParseUtil.getRawString("description", json);
			if (this.description != null) {
				this.description = HTMLEntity.unescapeAndSlideEntityIncdices(this.description, null,
						this.descriptionURLEntities, null, null);
			}
			this.isContributorsEnabled = ParseUtil.getBoolean("contributors_enabled", json);
			this.profileImageUrl = ParseUtil.getRawString("profile_image_url", json);
			this.profileImageUrlHttps = ParseUtil.getRawString("profile_image_url_https", json);
			this.isDefaultProfileImage = ParseUtil.getBoolean("default_profile_image", json);
			this.url = ParseUtil.getRawString("url", json);
			this.isProtected = ParseUtil.getBoolean("protected", json);
			this.isGeoEnabled = ParseUtil.getBoolean("geo_enabled", json);
			this.isVerified = ParseUtil.getBoolean("verified", json);
			this.translator = ParseUtil.getBoolean("is_translator", json);
			this.followersCount = ParseUtil.getInt("followers_count", json);
			this.profileBackgroundColor = ParseUtil.getRawString("profile_background_color", json);
			this.profileTextColor = ParseUtil.getRawString("profile_text_color", json);
			this.profileLinkColor = ParseUtil.getRawString("profile_link_color", json);
			this.profileSidebarFillColor = ParseUtil.getRawString("profile_sidebar_fill_color", json);
			this.profileSidebarBorderColor = ParseUtil.getRawString("profile_sidebar_border_color", json);
			this.profileUseBackgroundImage = ParseUtil.getBoolean("profile_use_background_image", json);
			this.isDefaultProfile = ParseUtil.getBoolean("default_profile", json);
			this.showAllInlineMedia = ParseUtil.getBoolean("show_all_inline_media", json);
			this.friendsCount = ParseUtil.getInt("friends_count", json);
			this.createdAt = ParseUtil.getDate("created_at", json, "EEE MMM dd HH:mm:ss z yyyy");
			this.favouritesCount = ParseUtil.getInt("favourites_count", json);
			this.utcOffset = ParseUtil.getInt("utc_offset", json);
			this.timeZone = ParseUtil.getRawString("time_zone", json);
			this.profileBackgroundImageUrl = ParseUtil.getRawString("profile_background_image_url", json);
			this.profileBackgroundImageUrlHttps = ParseUtil.getRawString("profile_background_image_url_https", json);
			this.profileBannerImageUrl = ParseUtil.getRawString("profile_banner_url", json);
			this.profileBackgroundTiled = ParseUtil.getBoolean("profile_background_tile", json);
			this.lang = ParseUtil.getRawString("lang", json);
			this.statusesCount = ParseUtil.getInt("statuses_count", json);
			this.listedCount = ParseUtil.getInt("listed_count", json);
			this.isFollowRequestSent = ParseUtil.getBoolean("follow_request_sent", json);
			if (!json.isNull("status")) {
				final JSONObject statusJSON = json.getJSONObject("status");
				this.status = new StatusJSONImpl(statusJSON);
			}
			if (!json.isNull("withheld_in_countries")) {
				final JSONArray withheld_in_countries = json.getJSONArray("withheld_in_countries");
				final int length = withheld_in_countries.length();
				this.withheldInCountries = new String[length];
				for (int i = 0; i < length; ++i) {
					this.withheldInCountries[i] = withheld_in_countries.getString(i);
				}
			}
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	private static URLEntity[] getURLEntitiesFromJSON(final JSONObject json, final String category)
			throws JSONException, TwitterException {
		if (!json.isNull("entities")) {
			final JSONObject entitiesJSON = json.getJSONObject("entities");
			if (!entitiesJSON.isNull(category)) {
				final JSONObject descriptionEntitiesJSON = entitiesJSON.getJSONObject(category);
				if (!descriptionEntitiesJSON.isNull("urls")) {
					final JSONArray urlsArray = descriptionEntitiesJSON.getJSONArray("urls");
					final int len = urlsArray.length();
					final URLEntity[] urlEntities = new URLEntity[len];
					for (int i = 0; i < len; ++i) {
						urlEntities[i] = new URLEntityJSONImpl(urlsArray.getJSONObject(i));
					}
					return urlEntities;
				}
			}
		}
		return new URLEntity[0];
	}

	@Override
	public int compareTo(final User that) {
		return (int) (this.id - that.getId());
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getScreenName() {
		return this.screenName;
	}

	@Override
	public String getLocation() {
		return this.location;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean isContributorsEnabled() {
		return this.isContributorsEnabled;
	}

	@Override
	public String getProfileImageURL() {
		return this.profileImageUrl;
	}

	@Override
	public String getBiggerProfileImageURL() {
		return this.toResizedURL(this.profileImageUrl, "_bigger");
	}

	@Override
	public String getMiniProfileImageURL() {
		return this.toResizedURL(this.profileImageUrl, "_mini");
	}

	@Override
	public String getOriginalProfileImageURL() {
		return this.toResizedURL(this.profileImageUrl, "");
	}

	private String toResizedURL(final String originalURL, final String sizeSuffix) {
		if (originalURL != null) {
			final int index = originalURL.lastIndexOf("_");
			final int suffixIndex = originalURL.lastIndexOf(".");
			final int slashIndex = originalURL.lastIndexOf("/");
			String url = String.valueOf(originalURL.substring(0, index)) + sizeSuffix;
			if (suffixIndex > slashIndex) {
				url = String.valueOf(url) + originalURL.substring(suffixIndex);
			}
			return url;
		}
		return null;
	}

	@Override
	public String getProfileImageURLHttps() {
		return this.profileImageUrlHttps;
	}

	@Override
	public String getBiggerProfileImageURLHttps() {
		return this.toResizedURL(this.profileImageUrlHttps, "_bigger");
	}

	@Override
	public String getMiniProfileImageURLHttps() {
		return this.toResizedURL(this.profileImageUrlHttps, "_mini");
	}

	@Override
	public String getOriginalProfileImageURLHttps() {
		return this.toResizedURL(this.profileImageUrlHttps, "");
	}

	@Override
	public boolean isDefaultProfileImage() {
		return this.isDefaultProfileImage;
	}

	@Override
	public String getURL() {
		return this.url;
	}

	@Override
	public boolean isProtected() {
		return this.isProtected;
	}

	@Override
	public int getFollowersCount() {
		return this.followersCount;
	}

	@Override
	public String getProfileBackgroundColor() {
		return this.profileBackgroundColor;
	}

	@Override
	public String getProfileTextColor() {
		return this.profileTextColor;
	}

	@Override
	public String getProfileLinkColor() {
		return this.profileLinkColor;
	}

	@Override
	public String getProfileSidebarFillColor() {
		return this.profileSidebarFillColor;
	}

	@Override
	public String getProfileSidebarBorderColor() {
		return this.profileSidebarBorderColor;
	}

	@Override
	public boolean isProfileUseBackgroundImage() {
		return this.profileUseBackgroundImage;
	}

	@Override
	public boolean isDefaultProfile() {
		return this.isDefaultProfile;
	}

	@Override
	public boolean isShowAllInlineMedia() {
		return this.showAllInlineMedia;
	}

	@Override
	public int getFriendsCount() {
		return this.friendsCount;
	}

	@Override
	public Status getStatus() {
		return this.status;
	}

	@Override
	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public int getFavouritesCount() {
		return this.favouritesCount;
	}

	@Override
	public int getUtcOffset() {
		return this.utcOffset;
	}

	@Override
	public String getTimeZone() {
		return this.timeZone;
	}

	@Override
	public String getProfileBackgroundImageURL() {
		return this.profileBackgroundImageUrl;
	}

	@Override
	public String getProfileBackgroundImageUrlHttps() {
		return this.profileBackgroundImageUrlHttps;
	}

	@Override
	public String getProfileBannerURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/web") : null;
	}

	@Override
	public String getProfileBannerRetinaURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/web_retina")
				: null;
	}

	@Override
	public String getProfileBannerIPadURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/ipad") : null;
	}

	@Override
	public String getProfileBannerIPadRetinaURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/ipad_retina")
				: null;
	}

	@Override
	public String getProfileBannerMobileURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/mobile") : null;
	}

	@Override
	public String getProfileBannerMobileRetinaURL() {
		return (this.profileBannerImageUrl != null) ? (String.valueOf(this.profileBannerImageUrl) + "/mobile_retina")
				: null;
	}

	@Override
	public boolean isProfileBackgroundTiled() {
		return this.profileBackgroundTiled;
	}

	@Override
	public String getLang() {
		return this.lang;
	}

	@Override
	public int getStatusesCount() {
		return this.statusesCount;
	}

	@Override
	public boolean isGeoEnabled() {
		return this.isGeoEnabled;
	}

	@Override
	public boolean isVerified() {
		return this.isVerified;
	}

	@Override
	public boolean isTranslator() {
		return this.translator;
	}

	@Override
	public int getListedCount() {
		return this.listedCount;
	}

	@Override
	public boolean isFollowRequestSent() {
		return this.isFollowRequestSent;
	}

	@Override
	public URLEntity[] getDescriptionURLEntities() {
		return this.descriptionURLEntities;
	}

	@Override
	public URLEntity getURLEntity() {
		if (this.urlEntity == null) {
			final String plainURL = (this.url == null) ? "" : this.url;
			this.urlEntity = new URLEntityJSONImpl(0, plainURL.length(), plainURL, plainURL, plainURL);
		}
		return this.urlEntity;
	}

	@Override
	public String[] getWithheldInCountries() {
		return this.withheldInCountries;
	}

	static PagableResponseList<User> createPagableUserList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final JSONObject json = res.asJSONObject();
			final JSONArray list = json.getJSONArray("users");
			final int size = list.length();
			final PagableResponseList<User> users = new PagableResponseListImpl<User>(size, json, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject userJson = list.getJSONObject(i);
				final User user = new UserJSONImpl(userJson);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(user, userJson);
				}
				users.add(user);
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(users, json);
			}
			return users;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	static ResponseList<User> createUserList(final HttpResponse res, final Configuration conf) throws TwitterException {
		return createUserList(res.asJSONArray(), res, conf);
	}

	static ResponseList<User> createUserList(final JSONArray list, final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final int size = list.length();
			final ResponseList<User> users = new ResponseListImpl<User>(size, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject json = list.getJSONObject(i);
				final User user = new UserJSONImpl(json);
				users.add(user);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(user, json);
				}
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(users, list);
			}
			return users;
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
		return obj != null && (this == obj || (obj instanceof User && ((User) obj).getId() == this.id));
	}

	@Override
	public String toString() {
		return "UserJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", screenName='" + this.screenName + '\''
				+ ", location='" + this.location + '\'' + ", description='" + this.description + '\''
				+ ", isContributorsEnabled=" + this.isContributorsEnabled + ", profileImageUrl='" + this.profileImageUrl
				+ '\'' + ", profileImageUrlHttps='" + this.profileImageUrlHttps + '\'' + ", isDefaultProfileImage="
				+ this.isDefaultProfileImage + ", url='" + this.url + '\'' + ", isProtected=" + this.isProtected
				+ ", followersCount=" + this.followersCount + ", status=" + this.status + ", profileBackgroundColor='"
				+ this.profileBackgroundColor + '\'' + ", profileTextColor='" + this.profileTextColor + '\''
				+ ", profileLinkColor='" + this.profileLinkColor + '\'' + ", profileSidebarFillColor='"
				+ this.profileSidebarFillColor + '\'' + ", profileSidebarBorderColor='" + this.profileSidebarBorderColor
				+ '\'' + ", profileUseBackgroundImage=" + this.profileUseBackgroundImage + ", isDefaultProfile="
				+ this.isDefaultProfile + ", showAllInlineMedia=" + this.showAllInlineMedia + ", friendsCount="
				+ this.friendsCount + ", createdAt=" + this.createdAt + ", favouritesCount=" + this.favouritesCount
				+ ", utcOffset=" + this.utcOffset + ", timeZone='" + this.timeZone + '\''
				+ ", profileBackgroundImageUrl='" + this.profileBackgroundImageUrl + '\''
				+ ", profileBackgroundImageUrlHttps='" + this.profileBackgroundImageUrlHttps + '\''
				+ ", profileBackgroundTiled=" + this.profileBackgroundTiled + ", lang='" + this.lang + '\''
				+ ", statusesCount=" + this.statusesCount + ", isGeoEnabled=" + this.isGeoEnabled + ", isVerified="
				+ this.isVerified + ", translator=" + this.translator + ", listedCount=" + this.listedCount
				+ ", isFollowRequestSent=" + this.isFollowRequestSent + ", withheldInCountries="
				+ Arrays.toString(this.withheldInCountries) + '}';
	}
}
