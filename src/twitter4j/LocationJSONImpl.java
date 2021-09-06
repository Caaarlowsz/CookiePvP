package twitter4j;

import twitter4j.conf.Configuration;

final class LocationJSONImpl implements Location {
	private static final long serialVersionUID = -1312752311160422264L;
	private final int woeid;
	private final String countryName;
	private final String countryCode;
	private final String placeName;
	private final int placeCode;
	private final String name;
	private final String url;

	LocationJSONImpl(final JSONObject location) throws TwitterException {
		try {
			this.woeid = ParseUtil.getInt("woeid", location);
			this.countryName = ParseUtil.getUnescapedString("country", location);
			this.countryCode = ParseUtil.getRawString("countryCode", location);
			if (!location.isNull("placeType")) {
				final JSONObject placeJSON = location.getJSONObject("placeType");
				this.placeName = ParseUtil.getUnescapedString("name", placeJSON);
				this.placeCode = ParseUtil.getInt("code", placeJSON);
			} else {
				this.placeName = null;
				this.placeCode = -1;
			}
			this.name = ParseUtil.getUnescapedString("name", location);
			this.url = ParseUtil.getUnescapedString("url", location);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	static ResponseList<Location> createLocationList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
		}
		return createLocationList(res.asJSONArray(), conf.isJSONStoreEnabled());
	}

	static ResponseList<Location> createLocationList(final JSONArray list, final boolean storeJSON)
			throws TwitterException {
		try {
			final int size = list.length();
			final ResponseList<Location> locations = new ResponseListImpl<Location>(size, null);
			for (int i = 0; i < size; ++i) {
				final JSONObject json = list.getJSONObject(i);
				final Location location = new LocationJSONImpl(json);
				locations.add(location);
				if (storeJSON) {
					TwitterObjectFactory.registerJSONObject(location, json);
				}
			}
			if (storeJSON) {
				TwitterObjectFactory.registerJSONObject(locations, list);
			}
			return locations;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public int getWoeid() {
		return this.woeid;
	}

	@Override
	public String getCountryName() {
		return this.countryName;
	}

	@Override
	public String getCountryCode() {
		return this.countryCode;
	}

	@Override
	public String getPlaceName() {
		return this.placeName;
	}

	@Override
	public int getPlaceCode() {
		return this.placeCode;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getURL() {
		return this.url;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof LocationJSONImpl)) {
			return false;
		}
		final LocationJSONImpl that = (LocationJSONImpl) o;
		return this.woeid == that.woeid;
	}

	@Override
	public int hashCode() {
		return this.woeid;
	}

	@Override
	public String toString() {
		return "LocationJSONImpl{woeid=" + this.woeid + ", countryName='" + this.countryName + '\'' + ", countryCode='"
				+ this.countryCode + '\'' + ", placeName='" + this.placeName + '\'' + ", placeCode='" + this.placeCode
				+ '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + '}';
	}
}
