package twitter4j;

import java.io.Serializable;

final class TrendJSONImpl implements Trend, Serializable {
	private static final long serialVersionUID = -4353426776065521132L;
	private final String name;
	private String url;
	private String query;

	TrendJSONImpl(final JSONObject json, final boolean storeJSON) {
		this.url = null;
		this.query = null;
		this.name = ParseUtil.getRawString("name", json);
		this.url = ParseUtil.getRawString("url", json);
		this.query = ParseUtil.getRawString("query", json);
		if (storeJSON) {
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	TrendJSONImpl(final JSONObject json) {
		this(json, false);
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
	public String getQuery() {
		return this.query;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Trend)) {
			return false;
		}
		final Trend trend = (Trend) o;
		if (!this.name.equals(trend.getName())) {
			return false;
		}
		Label_0076: {
			if (this.query != null) {
				if (this.query.equals(trend.getQuery())) {
					break Label_0076;
				}
			} else if (trend.getQuery() == null) {
				break Label_0076;
			}
			return false;
		}
		if (this.url != null) {
			if (this.url.equals(trend.getURL())) {
				return true;
			}
		} else if (trend.getURL() == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = this.name.hashCode();
		result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
		result = 31 * result + ((this.query != null) ? this.query.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "TrendJSONImpl{name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", query='" + this.query + '\''
				+ '}';
	}
}
