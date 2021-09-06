package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import twitter4j.conf.Configuration;

final class QueryResultJSONImpl extends TwitterResponseImpl implements QueryResult, Serializable {
	private static final long serialVersionUID = -5359566235429947156L;
	private long sinceId;
	private long maxId;
	private String refreshUrl;
	private int count;
	private double completedIn;
	private String query;
	private List<Status> tweets;
	private String nextResults;

	QueryResultJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		final JSONObject json = res.asJSONObject();
		try {
			final JSONObject searchMetaData = json.getJSONObject("search_metadata");
			this.completedIn = ParseUtil.getDouble("completed_in", searchMetaData);
			this.count = ParseUtil.getInt("count", searchMetaData);
			this.maxId = ParseUtil.getLong("max_id", searchMetaData);
			this.nextResults = (searchMetaData.has("next_results") ? searchMetaData.getString("next_results") : null);
			this.query = ParseUtil.getURLDecodedString("query", searchMetaData);
			this.refreshUrl = ParseUtil.getUnescapedString("refresh_url", searchMetaData);
			this.sinceId = ParseUtil.getLong("since_id", searchMetaData);
			final JSONArray array = json.getJSONArray("statuses");
			this.tweets = new ArrayList<Status>(array.length());
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			for (int i = 0; i < array.length(); ++i) {
				final JSONObject tweet = array.getJSONObject(i);
				this.tweets.add(new StatusJSONImpl(tweet, conf));
			}
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	QueryResultJSONImpl(final Query query) {
		this.sinceId = query.getSinceId();
		this.count = query.getCount();
		this.tweets = new ArrayList<Status>(0);
	}

	@Override
	public long getSinceId() {
		return this.sinceId;
	}

	@Override
	public long getMaxId() {
		return this.maxId;
	}

	@Override
	public String getRefreshURL() {
		return this.refreshUrl;
	}

	@Override
	public int getCount() {
		return this.count;
	}

	@Override
	public double getCompletedIn() {
		return this.completedIn;
	}

	@Override
	public String getQuery() {
		return this.query;
	}

	@Override
	public List<Status> getTweets() {
		return this.tweets;
	}

	@Override
	public Query nextQuery() {
		if (this.nextResults == null) {
			return null;
		}
		return Query.createWithNextPageQuery(this.nextResults);
	}

	@Override
	public boolean hasNext() {
		return this.nextResults != null;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final QueryResult that = (QueryResult) o;
		if (Double.compare(that.getCompletedIn(), this.completedIn) != 0) {
			return false;
		}
		if (this.maxId != that.getMaxId()) {
			return false;
		}
		if (this.count != that.getCount()) {
			return false;
		}
		if (this.sinceId != that.getSinceId()) {
			return false;
		}
		if (!this.query.equals(that.getQuery())) {
			return false;
		}
		Label_0149: {
			if (this.refreshUrl != null) {
				if (this.refreshUrl.equals(that.getRefreshURL())) {
					break Label_0149;
				}
			} else if (that.getRefreshURL() == null) {
				break Label_0149;
			}
			return false;
		}
		if (this.tweets != null) {
			if (this.tweets.equals(that.getTweets())) {
				return true;
			}
		} else if (that.getTweets() == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (int) (this.sinceId ^ this.sinceId >>> 32);
		result = 31 * result + (int) (this.maxId ^ this.maxId >>> 32);
		result = 31 * result + ((this.refreshUrl != null) ? this.refreshUrl.hashCode() : 0);
		result = 31 * result + this.count;
		final long temp = (this.completedIn != 0.0) ? Double.doubleToLongBits(this.completedIn) : 0L;
		result = 31 * result + (int) (temp ^ temp >>> 32);
		result = 31 * result + this.query.hashCode();
		result = 31 * result + ((this.tweets != null) ? this.tweets.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "QueryResultJSONImpl{sinceId=" + this.sinceId + ", maxId=" + this.maxId + ", refreshUrl='"
				+ this.refreshUrl + '\'' + ", count=" + this.count + ", completedIn=" + this.completedIn + ", query='"
				+ this.query + '\'' + ", tweets=" + this.tweets + '}';
	}
}
