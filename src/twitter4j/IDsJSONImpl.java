package twitter4j;

import java.util.Arrays;

import twitter4j.conf.Configuration;

final class IDsJSONImpl extends TwitterResponseImpl implements IDs {
	private static final long serialVersionUID = 6999637496007165672L;
	private long[] ids;
	private long previousCursor;
	private long nextCursor;

	IDsJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		this.previousCursor = -1L;
		this.nextCursor = -1L;
		final String json = res.asString();
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	IDsJSONImpl(final String json) throws TwitterException {
		this.previousCursor = -1L;
		this.nextCursor = -1L;
		this.init(json);
	}

	private void init(final String jsonStr) throws TwitterException {
		try {
			if (jsonStr.startsWith("{")) {
				final JSONObject json = new JSONObject(jsonStr);
				final JSONArray idList = json.getJSONArray("ids");
				this.ids = new long[idList.length()];
				for (int i = 0; i < idList.length(); ++i) {
					try {
						this.ids[i] = Long.parseLong(idList.getString(i));
					} catch (NumberFormatException nfe) {
						throw new TwitterException("Twitter API returned malformed response: " + json, nfe);
					}
				}
				this.previousCursor = ParseUtil.getLong("previous_cursor", json);
				this.nextCursor = ParseUtil.getLong("next_cursor", json);
			} else {
				final JSONArray idList = new JSONArray(jsonStr);
				this.ids = new long[idList.length()];
				for (int j = 0; j < idList.length(); ++j) {
					try {
						this.ids[j] = Long.parseLong(idList.getString(j));
					} catch (NumberFormatException nfe2) {
						throw new TwitterException("Twitter API returned malformed response: " + idList, nfe2);
					}
				}
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public long[] getIDs() {
		return this.ids;
	}

	@Override
	public boolean hasPrevious() {
		return 0L != this.previousCursor;
	}

	@Override
	public long getPreviousCursor() {
		return this.previousCursor;
	}

	@Override
	public boolean hasNext() {
		return 0L != this.nextCursor;
	}

	@Override
	public long getNextCursor() {
		return this.nextCursor;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IDs)) {
			return false;
		}
		final IDs iDs = (IDs) o;
		return Arrays.equals(this.ids, iDs.getIDs());
	}

	@Override
	public int hashCode() {
		return (this.ids != null) ? Arrays.hashCode(this.ids) : 0;
	}

	@Override
	public String toString() {
		return "IDsJSONImpl{ids=" + Arrays.toString(this.ids) + ", previousCursor=" + this.previousCursor
				+ ", nextCursor=" + this.nextCursor + '}';
	}
}
