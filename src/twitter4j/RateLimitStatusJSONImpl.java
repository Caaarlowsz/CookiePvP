package twitter4j;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import twitter4j.conf.Configuration;

final class RateLimitStatusJSONImpl implements RateLimitStatus, Serializable {
	private static final long serialVersionUID = 7790337632915862445L;
	private int remaining;
	private int limit;
	private int resetTimeInSeconds;
	private int secondsUntilReset;

	static Map<String, RateLimitStatus> createRateLimitStatuses(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		final JSONObject json = res.asJSONObject();
		final Map<String, RateLimitStatus> map = createRateLimitStatuses(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(map, json);
		}
		return map;
	}

	static Map<String, RateLimitStatus> createRateLimitStatuses(final JSONObject json) throws TwitterException {
		final Map<String, RateLimitStatus> map = new HashMap<String, RateLimitStatus>();
		try {
			final JSONObject resources = json.getJSONObject("resources");
			final Iterator<String> resourceKeys = resources.keys();
			while (resourceKeys.hasNext()) {
				final JSONObject resource = resources.getJSONObject(resourceKeys.next());
				final Iterator<String> endpointKeys = resource.keys();
				while (endpointKeys.hasNext()) {
					final String endpoint = endpointKeys.next();
					final JSONObject rateLimitStatusJSON = resource.getJSONObject(endpoint);
					final RateLimitStatus rateLimitStatus = new RateLimitStatusJSONImpl(rateLimitStatusJSON);
					map.put(endpoint, rateLimitStatus);
				}
			}
			return Collections.unmodifiableMap((Map<? extends String, ? extends RateLimitStatus>) map);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	private RateLimitStatusJSONImpl(final int limit, final int remaining, final int resetTimeInSeconds) {
		this.limit = limit;
		this.remaining = remaining;
		this.resetTimeInSeconds = resetTimeInSeconds;
		this.secondsUntilReset = (int) ((resetTimeInSeconds * 1000L - System.currentTimeMillis()) / 1000L);
	}

	RateLimitStatusJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	void init(final JSONObject json) throws TwitterException {
		this.limit = ParseUtil.getInt("limit", json);
		this.remaining = ParseUtil.getInt("remaining", json);
		this.resetTimeInSeconds = ParseUtil.getInt("reset", json);
		this.secondsUntilReset = (int) ((this.resetTimeInSeconds * 1000L - System.currentTimeMillis()) / 1000L);
	}

	static RateLimitStatus createFromResponseHeader(final HttpResponse res) {
		if (res == null) {
			return null;
		}
		final String strLimit = res.getResponseHeader("X-Rate-Limit-Limit");
		if (strLimit == null) {
			return null;
		}
		final int limit = Integer.parseInt(strLimit);
		final String remaining = res.getResponseHeader("X-Rate-Limit-Remaining");
		if (remaining == null) {
			return null;
		}
		final int remainingHits = Integer.parseInt(remaining);
		final String reset = res.getResponseHeader("X-Rate-Limit-Reset");
		if (reset != null) {
			final long longReset = Long.parseLong(reset);
			final int resetTimeInSeconds = (int) longReset;
			return new RateLimitStatusJSONImpl(limit, remainingHits, resetTimeInSeconds);
		}
		return null;
	}

	@Override
	public int getRemaining() {
		return this.remaining;
	}

	@Override
	public int getLimit() {
		return this.limit;
	}

	@Override
	public int getResetTimeInSeconds() {
		return this.resetTimeInSeconds;
	}

	@Override
	public int getSecondsUntilReset() {
		return this.secondsUntilReset;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final RateLimitStatusJSONImpl that = (RateLimitStatusJSONImpl) o;
		return this.limit == that.limit && this.remaining == that.remaining
				&& this.resetTimeInSeconds == that.resetTimeInSeconds
				&& this.secondsUntilReset == that.secondsUntilReset;
	}

	@Override
	public int hashCode() {
		int result = this.remaining;
		result = 31 * result + this.limit;
		result = 31 * result + this.resetTimeInSeconds;
		result = 31 * result + this.secondsUntilReset;
		return result;
	}

	@Override
	public String toString() {
		return "RateLimitStatusJSONImpl{remaining=" + this.remaining + ", limit=" + this.limit + ", resetTimeInSeconds="
				+ this.resetTimeInSeconds + ", secondsUntilReset=" + this.secondsUntilReset + '}';
	}
}
