package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class GeoQuery implements Serializable {
	private static final long serialVersionUID = 5434503339001056634L;
	private GeoLocation location;
	private String query;
	private String ip;
	private String accuracy;
	private String granularity;
	private int maxResults;

	public GeoQuery(final GeoLocation location) {
		this.query = null;
		this.ip = null;
		this.accuracy = null;
		this.granularity = null;
		this.maxResults = -1;
		this.location = location;
	}

	public GeoQuery(final String ip) {
		this.query = null;
		this.ip = null;
		this.accuracy = null;
		this.granularity = null;
		this.maxResults = -1;
		this.ip = ip;
	}

	public GeoLocation getLocation() {
		return this.location;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(final String query) {
		this.query = query;
	}

	public String getIp() {
		return this.ip;
	}

	public String getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(final String accuracy) {
		this.accuracy = accuracy;
	}

	public GeoQuery accuracy(final String accuracy) {
		this.setAccuracy(accuracy);
		return this;
	}

	public String getGranularity() {
		return this.granularity;
	}

	public void setGranularity(final String granularity) {
		this.granularity = granularity;
	}

	public GeoQuery granularity(final String granularity) {
		this.setGranularity(granularity);
		return this;
	}

	public int getMaxResults() {
		return this.maxResults;
	}

	public void setMaxResults(final int maxResults) {
		this.maxResults = maxResults;
	}

	public GeoQuery maxResults(final int maxResults) {
		this.setMaxResults(maxResults);
		return this;
	}

	HttpParameter[] asHttpParameterArray() {
		final ArrayList<HttpParameter> params = new ArrayList<HttpParameter>();
		if (this.location != null) {
			this.appendParameter("lat", this.location.getLatitude(), params);
			this.appendParameter("long", this.location.getLongitude(), params);
		}
		if (this.ip != null) {
			this.appendParameter("ip", this.ip, params);
		}
		this.appendParameter("accuracy", this.accuracy, params);
		this.appendParameter("query", this.query, params);
		this.appendParameter("granularity", this.granularity, params);
		this.appendParameter("max_results", this.maxResults, params);
		final HttpParameter[] paramArray = new HttpParameter[params.size()];
		return params.toArray(paramArray);
	}

	private void appendParameter(final String name, final String value, final List<HttpParameter> params) {
		if (value != null) {
			params.add(new HttpParameter(name, value));
		}
	}

	private void appendParameter(final String name, final int value, final List<HttpParameter> params) {
		if (value > 0) {
			params.add(new HttpParameter(name, String.valueOf(value)));
		}
	}

	private void appendParameter(final String name, final double value, final List<HttpParameter> params) {
		params.add(new HttpParameter(name, String.valueOf(value)));
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final GeoQuery geoQuery = (GeoQuery) o;
		if (this.maxResults != geoQuery.maxResults) {
			return false;
		}
		Label_0075: {
			if (this.accuracy != null) {
				if (this.accuracy.equals(geoQuery.accuracy)) {
					break Label_0075;
				}
			} else if (geoQuery.accuracy == null) {
				break Label_0075;
			}
			return false;
		}
		Label_0108: {
			if (this.granularity != null) {
				if (this.granularity.equals(geoQuery.granularity)) {
					break Label_0108;
				}
			} else if (geoQuery.granularity == null) {
				break Label_0108;
			}
			return false;
		}
		Label_0141: {
			if (this.ip != null) {
				if (this.ip.equals(geoQuery.ip)) {
					break Label_0141;
				}
			} else if (geoQuery.ip == null) {
				break Label_0141;
			}
			return false;
		}
		if (this.location != null) {
			if (this.location.equals(geoQuery.location)) {
				return true;
			}
		} else if (geoQuery.location == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.location != null) ? this.location.hashCode() : 0;
		result = 31 * result + ((this.ip != null) ? this.ip.hashCode() : 0);
		result = 31 * result + ((this.accuracy != null) ? this.accuracy.hashCode() : 0);
		result = 31 * result + ((this.granularity != null) ? this.granularity.hashCode() : 0);
		result = 31 * result + this.maxResults;
		return result;
	}

	@Override
	public String toString() {
		return "GeoQuery{location=" + this.location + ", query='" + this.query + '\'' + ", ip='" + this.ip + '\''
				+ ", accuracy='" + this.accuracy + '\'' + ", granularity='" + this.granularity + '\'' + ", maxResults="
				+ this.maxResults + '}';
	}
}
