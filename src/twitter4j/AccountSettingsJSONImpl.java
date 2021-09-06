package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

class AccountSettingsJSONImpl extends TwitterResponseImpl implements AccountSettings, Serializable {
	private static final long serialVersionUID = 603189815663175766L;
	private final boolean SLEEP_TIME_ENABLED;
	private final String SLEEP_START_TIME;
	private final String SLEEP_END_TIME;
	private final Location[] TREND_LOCATION;
	private final boolean GEO_ENABLED;
	private final String LANGUAGE;
	private final TimeZone TIMEZONE;
	private final boolean ALWAYS_USE_HTTPS;
	private final boolean DISCOVERABLE_BY_EMAIL;
	private final String SCREEN_NAME;

	private AccountSettingsJSONImpl(final HttpResponse res, final JSONObject json) throws TwitterException {
		super(res);
		try {
			final JSONObject sleepTime = json.getJSONObject("sleep_time");
			this.SLEEP_TIME_ENABLED = ParseUtil.getBoolean("enabled", sleepTime);
			this.SLEEP_START_TIME = sleepTime.getString("start_time");
			this.SLEEP_END_TIME = sleepTime.getString("end_time");
			if (json.isNull("trend_location")) {
				this.TREND_LOCATION = new Location[0];
			} else {
				final JSONArray locations = json.getJSONArray("trend_location");
				this.TREND_LOCATION = new Location[locations.length()];
				for (int i = 0; i < locations.length(); ++i) {
					this.TREND_LOCATION[i] = new LocationJSONImpl(locations.getJSONObject(i));
				}
			}
			this.GEO_ENABLED = ParseUtil.getBoolean("geo_enabled", json);
			this.LANGUAGE = json.getString("language");
			this.ALWAYS_USE_HTTPS = ParseUtil.getBoolean("always_use_https", json);
			this.DISCOVERABLE_BY_EMAIL = ParseUtil.getBoolean("discoverable_by_email", json);
			if (json.isNull("time_zone")) {
				this.TIMEZONE = null;
			} else {
				this.TIMEZONE = new TimeZoneJSONImpl(json.getJSONObject("time_zone"));
			}
			this.SCREEN_NAME = json.getString("screen_name");
		} catch (JSONException e) {
			throw new TwitterException(e);
		}
	}

	AccountSettingsJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		this(res, res.asJSONObject());
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
		}
	}

	AccountSettingsJSONImpl(final JSONObject json) throws TwitterException {
		this(null, json);
	}

	@Override
	public boolean isSleepTimeEnabled() {
		return this.SLEEP_TIME_ENABLED;
	}

	@Override
	public String getSleepStartTime() {
		return this.SLEEP_START_TIME;
	}

	@Override
	public String getSleepEndTime() {
		return this.SLEEP_END_TIME;
	}

	@Override
	public Location[] getTrendLocations() {
		return this.TREND_LOCATION;
	}

	@Override
	public boolean isGeoEnabled() {
		return this.GEO_ENABLED;
	}

	@Override
	public boolean isDiscoverableByEmail() {
		return this.DISCOVERABLE_BY_EMAIL;
	}

	@Override
	public boolean isAlwaysUseHttps() {
		return this.ALWAYS_USE_HTTPS;
	}

	@Override
	public String getScreenName() {
		return this.SCREEN_NAME;
	}

	@Override
	public String getLanguage() {
		return this.LANGUAGE;
	}

	@Override
	public TimeZone getTimeZone() {
		return this.TIMEZONE;
	}
}
