package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import twitter4j.conf.Configuration;

final class TrendsJSONImpl extends TwitterResponseImpl implements Trends, Serializable {
	private static final long serialVersionUID = 2054973282133379835L;
	private Date asOf;
	private Date trendAt;
	private Trend[] trends;
	private Location location;

	@Override
	public int compareTo(final Trends that) {
		return this.trendAt.compareTo(that.getTrendAt());
	}

	TrendsJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		this.init(res.asString(), conf.isJSONStoreEnabled());
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(this, res.asString());
		}
	}

	TrendsJSONImpl(final String jsonStr) throws TwitterException {
		this(jsonStr, false);
	}

	TrendsJSONImpl(final String jsonStr, final boolean storeJSON) throws TwitterException {
		this.init(jsonStr, storeJSON);
	}

	void init(final String jsonStr, final boolean storeJSON) throws TwitterException {
		try {
			JSONObject json;
			if (jsonStr.startsWith("[")) {
				final JSONArray array = new JSONArray(jsonStr);
				if (array.length() <= 0) {
					throw new TwitterException("No trends found on the specified woeid");
				}
				json = array.getJSONObject(0);
			} else {
				json = new JSONObject(jsonStr);
			}
			this.asOf = ParseUtil.parseTrendsDate(json.getString("as_of"));
			this.location = extractLocation(json, storeJSON);
			final JSONArray array = json.getJSONArray("trends");
			this.trendAt = this.asOf;
			this.trends = jsonArrayToTrendArray(array, storeJSON);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone.getMessage(), jsone);
		}
	}

	TrendsJSONImpl(final Date asOf, final Location location, final Date trendAt, final Trend[] trends) {
		this.asOf = asOf;
		this.location = location;
		this.trendAt = trendAt;
		this.trends = trends;
	}

	static ResponseList<Trends> createTrendsList(final HttpResponse res, final boolean storeJSON)
			throws TwitterException {
		final JSONObject json = res.asJSONObject();
		try {
			final Date asOf = ParseUtil.parseTrendsDate(json.getString("as_of"));
			final JSONObject trendsJson = json.getJSONObject("trends");
			final Location location = extractLocation(json, storeJSON);
			final ResponseList<Trends> trends = new ResponseListImpl<Trends>(trendsJson.length(), res);
			final Iterator<String> ite = trendsJson.keys();
			while (ite.hasNext()) {
				final String key = ite.next();
				final JSONArray array = trendsJson.getJSONArray(key);
				final Trend[] trendsArray = jsonArrayToTrendArray(array, storeJSON);
				if (key.length() == 19) {
					trends.add(new TrendsJSONImpl(asOf, location, ParseUtil.getDate(key, "yyyy-MM-dd HH:mm:ss"),
							trendsArray));
				} else if (key.length() == 16) {
					trends.add(new TrendsJSONImpl(asOf, location, ParseUtil.getDate(key, "yyyy-MM-dd HH:mm"),
							trendsArray));
				} else {
					if (key.length() != 10) {
						continue;
					}
					trends.add(new TrendsJSONImpl(asOf, location, ParseUtil.getDate(key, "yyyy-MM-dd"), trendsArray));
				}
			}
			Collections.sort(trends);
			return trends;
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + res.asString(), jsone);
		}
	}

	private static Location extractLocation(final JSONObject json, final boolean storeJSON) throws TwitterException {
		if (json.isNull("locations")) {
			return null;
		}
		ResponseList<Location> locations;
		try {
			locations = LocationJSONImpl.createLocationList(json.getJSONArray("locations"), storeJSON);
		} catch (JSONException e) {
			throw new AssertionError((Object) "locations can't be null");
		}
		Location location;
		if (locations.size() != 0) {
			location = locations.get(0);
		} else {
			location = null;
		}
		return location;
	}

	private static Trend[] jsonArrayToTrendArray(final JSONArray array, final boolean storeJSON) throws JSONException {
		final Trend[] trends = new Trend[array.length()];
		for (int i = 0; i < array.length(); ++i) {
			final JSONObject trend = array.getJSONObject(i);
			trends[i] = new TrendJSONImpl(trend, storeJSON);
		}
		return trends;
	}

	@Override
	public Trend[] getTrends() {
		return this.trends;
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public Date getAsOf() {
		return this.asOf;
	}

	@Override
	public Date getTrendAt() {
		return this.trendAt;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Trends)) {
			return false;
		}
		final Trends trends1 = (Trends) o;
		Label_0058: {
			if (this.asOf != null) {
				if (this.asOf.equals(trends1.getAsOf())) {
					break Label_0058;
				}
			} else if (trends1.getAsOf() == null) {
				break Label_0058;
			}
			return false;
		}
		if (this.trendAt != null) {
			if (this.trendAt.equals(trends1.getTrendAt())) {
				return Arrays.equals(this.trends, trends1.getTrends());
			}
		} else if (trends1.getTrendAt() == null) {
			return Arrays.equals(this.trends, trends1.getTrends());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.asOf != null) ? this.asOf.hashCode() : 0;
		result = 31 * result + ((this.trendAt != null) ? this.trendAt.hashCode() : 0);
		result = 31 * result + ((this.trends != null) ? Arrays.hashCode(this.trends) : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TrendsJSONImpl{asOf=" + this.asOf + ", trendAt=" + this.trendAt + ", trends="
				+ ((this.trends == null) ? null : Arrays.asList(this.trends)) + '}';
	}
}
