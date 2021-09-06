package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Query implements Serializable {
	private static final long serialVersionUID = 7196404519192910019L;
	private String query;
	private String lang;
	private String locale;
	private long maxId;
	private int count;
	private String since;
	private long sinceId;
	private String geocode;
	private String until;
	private ResultType resultType;
	private String nextPageQuery;
	public static final Unit MILES;
	public static final Unit KILOMETERS;
	public static final ResultType MIXED;
	public static final ResultType POPULAR;
	public static final ResultType RECENT;
	private static final HttpParameter WITH_TWITTER_USER_ID;

	static {
		MILES = Unit.mi;
		KILOMETERS = Unit.km;
		MIXED = ResultType.mixed;
		POPULAR = ResultType.popular;
		RECENT = ResultType.recent;
		WITH_TWITTER_USER_ID = new HttpParameter("with_twitter_user_id", "true");
	}

	public Query() {
		this.query = null;
		this.lang = null;
		this.locale = null;
		this.maxId = -1L;
		this.count = -1;
		this.since = null;
		this.sinceId = -1L;
		this.geocode = null;
		this.until = null;
		this.resultType = null;
		this.nextPageQuery = null;
	}

	public Query(final String query) {
		this.query = null;
		this.lang = null;
		this.locale = null;
		this.maxId = -1L;
		this.count = -1;
		this.since = null;
		this.sinceId = -1L;
		this.geocode = null;
		this.until = null;
		this.resultType = null;
		this.nextPageQuery = null;
		this.query = query;
	}

	static Query createWithNextPageQuery(final String nextPageQuery) {
		final Query query = new Query();
		query.nextPageQuery = nextPageQuery;
		if (nextPageQuery != null) {
			final String nextPageParameters = nextPageQuery.substring(1, nextPageQuery.length());
			final Map<String, String> params = new LinkedHashMap<String, String>();
			for (final HttpParameter param : HttpParameter.decodeParameters(nextPageParameters)) {
				params.put(param.getName(), param.getValue());
			}
			if (params.containsKey("q")) {
				query.setQuery(params.get("q"));
			}
			if (params.containsKey("lang")) {
				query.setLang(params.get("lang"));
			}
			if (params.containsKey("locale")) {
				query.setLocale(params.get("locale"));
			}
			if (params.containsKey("max_id")) {
				query.setMaxId(Long.parseLong(params.get("max_id")));
			}
			if (params.containsKey("count")) {
				query.setCount(Integer.parseInt(params.get("count")));
			}
			if (params.containsKey("geocode")) {
				final String[] parts = params.get("geocode").split(",");
				final double latitude = Double.parseDouble(parts[0]);
				final double longitude = Double.parseDouble(parts[1]);
				double radius = 0.0;
				Unit unit = null;
				final String radiusstr = parts[2];
				Unit[] values;
				for (int length = (values = Unit.values()).length, i = 0; i < length; ++i) {
					final Unit value = values[i];
					if (radiusstr.endsWith(value.name())) {
						radius = Double.parseDouble(radiusstr.substring(0, radiusstr.length() - 2));
						unit = value;
						break;
					}
				}
				if (unit == null) {
					throw new IllegalArgumentException("unrecognized geocode radius: " + radiusstr);
				}
				query.setGeoCode(new GeoLocation(latitude, longitude), radius, unit);
			}
			if (params.containsKey("result_type")) {
				query.setResultType(ResultType.valueOf(params.get("result_type")));
			}
		}
		return query;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(final String query) {
		this.query = query;
	}

	public Query query(final String query) {
		this.setQuery(query);
		return this;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(final String lang) {
		this.lang = lang;
	}

	public Query lang(final String lang) {
		this.setLang(lang);
		return this;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(final String locale) {
		this.locale = locale;
	}

	public Query locale(final String locale) {
		this.setLocale(locale);
		return this;
	}

	public long getMaxId() {
		return this.maxId;
	}

	public void setMaxId(final long maxId) {
		this.maxId = maxId;
	}

	public Query maxId(final long maxId) {
		this.setMaxId(maxId);
		return this;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(final int count) {
		this.count = count;
	}

	public Query count(final int count) {
		this.setCount(count);
		return this;
	}

	public String getSince() {
		return this.since;
	}

	public void setSince(final String since) {
		this.since = since;
	}

	public Query since(final String since) {
		this.setSince(since);
		return this;
	}

	public long getSinceId() {
		return this.sinceId;
	}

	public void setSinceId(final long sinceId) {
		this.sinceId = sinceId;
	}

	public Query sinceId(final long sinceId) {
		this.setSinceId(sinceId);
		return this;
	}

	public String getGeocode() {
		return this.geocode;
	}

	public void setGeoCode(final GeoLocation location, final double radius, final Unit unit) {
		this.geocode = String.valueOf(location.getLatitude()) + "," + location.getLongitude() + "," + radius
				+ unit.name();
	}

	@Deprecated
	public void setGeoCode(final GeoLocation location, final double radius, final String unit) {
		this.geocode = String.valueOf(location.getLatitude()) + "," + location.getLongitude() + "," + radius + unit;
	}

	public Query geoCode(final GeoLocation location, final double radius, final String unit) {
		this.setGeoCode(location, radius, unit);
		return this;
	}

	public String getUntil() {
		return this.until;
	}

	public void setUntil(final String until) {
		this.until = until;
	}

	public Query until(final String until) {
		this.setUntil(until);
		return this;
	}

	public ResultType getResultType() {
		return this.resultType;
	}

	public void setResultType(final ResultType resultType) {
		this.resultType = resultType;
	}

	public Query resultType(final ResultType resultType) {
		this.setResultType(resultType);
		return this;
	}

	HttpParameter[] asHttpParameterArray() {
		final ArrayList<HttpParameter> params = new ArrayList<HttpParameter>(12);
		this.appendParameter("q", this.query, params);
		this.appendParameter("lang", this.lang, params);
		this.appendParameter("locale", this.locale, params);
		this.appendParameter("max_id", this.maxId, params);
		this.appendParameter("count", this.count, params);
		this.appendParameter("since", this.since, params);
		this.appendParameter("since_id", this.sinceId, params);
		this.appendParameter("geocode", this.geocode, params);
		this.appendParameter("until", this.until, params);
		if (this.resultType != null) {
			params.add(new HttpParameter("result_type", this.resultType.name()));
		}
		params.add(Query.WITH_TWITTER_USER_ID);
		final HttpParameter[] paramArray = new HttpParameter[params.size()];
		return params.toArray(paramArray);
	}

	private void appendParameter(final String name, final String value, final List<HttpParameter> params) {
		if (value != null) {
			params.add(new HttpParameter(name, value));
		}
	}

	private void appendParameter(final String name, final long value, final List<HttpParameter> params) {
		if (0L <= value) {
			params.add(new HttpParameter(name, String.valueOf(value)));
		}
	}

	String nextPage() {
		return this.nextPageQuery;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final Query query1 = (Query) o;
		if (this.maxId != query1.maxId) {
			return false;
		}
		if (this.count != query1.count) {
			return false;
		}
		if (this.sinceId != query1.sinceId) {
			return false;
		}
		Label_0103: {
			if (this.geocode != null) {
				if (this.geocode.equals(query1.geocode)) {
					break Label_0103;
				}
			} else if (query1.geocode == null) {
				break Label_0103;
			}
			return false;
		}
		Label_0136: {
			if (this.lang != null) {
				if (this.lang.equals(query1.lang)) {
					break Label_0136;
				}
			} else if (query1.lang == null) {
				break Label_0136;
			}
			return false;
		}
		Label_0169: {
			if (this.locale != null) {
				if (this.locale.equals(query1.locale)) {
					break Label_0169;
				}
			} else if (query1.locale == null) {
				break Label_0169;
			}
			return false;
		}
		Label_0202: {
			if (this.nextPageQuery != null) {
				if (this.nextPageQuery.equals(query1.nextPageQuery)) {
					break Label_0202;
				}
			} else if (query1.nextPageQuery == null) {
				break Label_0202;
			}
			return false;
		}
		Label_0235: {
			if (this.query != null) {
				if (this.query.equals(query1.query)) {
					break Label_0235;
				}
			} else if (query1.query == null) {
				break Label_0235;
			}
			return false;
		}
		Label_0268: {
			if (this.resultType != null) {
				if (this.resultType.equals(query1.resultType)) {
					break Label_0268;
				}
			} else if (query1.resultType == null) {
				break Label_0268;
			}
			return false;
		}
		Label_0301: {
			if (this.since != null) {
				if (this.since.equals(query1.since)) {
					break Label_0301;
				}
			} else if (query1.since == null) {
				break Label_0301;
			}
			return false;
		}
		if (this.until != null) {
			if (this.until.equals(query1.until)) {
				return true;
			}
		} else if (query1.until == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.query != null) ? this.query.hashCode() : 0;
		result = 31 * result + ((this.lang != null) ? this.lang.hashCode() : 0);
		result = 31 * result + ((this.locale != null) ? this.locale.hashCode() : 0);
		result = 31 * result + (int) (this.maxId ^ this.maxId >>> 32);
		result = 31 * result + this.count;
		result = 31 * result + ((this.since != null) ? this.since.hashCode() : 0);
		result = 31 * result + (int) (this.sinceId ^ this.sinceId >>> 32);
		result = 31 * result + ((this.geocode != null) ? this.geocode.hashCode() : 0);
		result = 31 * result + ((this.until != null) ? this.until.hashCode() : 0);
		result = 31 * result + ((this.resultType != null) ? this.resultType.hashCode() : 0);
		result = 31 * result + ((this.nextPageQuery != null) ? this.nextPageQuery.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Query{query='" + this.query + '\'' + ", lang='" + this.lang + '\'' + ", locale='" + this.locale + '\''
				+ ", maxId=" + this.maxId + ", count=" + this.count + ", since='" + this.since + '\'' + ", sinceId="
				+ this.sinceId + ", geocode='" + this.geocode + '\'' + ", until='" + this.until + '\''
				+ ", resultType='" + this.resultType + '\'' + ", nextPageQuery='" + this.nextPageQuery + '\'' + '}';
	}

	public enum ResultType {
		popular("popular", 0), mixed("mixed", 1), recent("recent", 2);

		private ResultType(final String s, final int n) {
		}
	}

	public enum Unit {
		mi("mi", 0), km("km", 1);

		private Unit(final String s, final int n) {
		}
	}
}
