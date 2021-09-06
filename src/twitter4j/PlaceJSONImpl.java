package twitter4j;

import java.io.Serializable;
import java.util.Arrays;

import twitter4j.conf.Configuration;

final class PlaceJSONImpl extends TwitterResponseImpl implements Place, Serializable {
	private static final long serialVersionUID = -6368276880878829754L;
	private String name;
	private String streetAddress;
	private String countryCode;
	private String id;
	private String country;
	private String placeType;
	private String url;
	private String fullName;
	private String boundingBoxType;
	private GeoLocation[][] boundingBoxCoordinates;
	private String geometryType;
	private GeoLocation[][] geometryCoordinates;
	private Place[] containedWithIn;

	PlaceJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		final JSONObject json = res.asJSONObject();
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	PlaceJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	PlaceJSONImpl() {
	}

	private void init(final JSONObject json) throws TwitterException {
		try {
			this.name = ParseUtil.getUnescapedString("name", json);
			this.streetAddress = ParseUtil.getUnescapedString("street_address", json);
			this.countryCode = ParseUtil.getRawString("country_code", json);
			this.id = ParseUtil.getRawString("id", json);
			this.country = ParseUtil.getRawString("country", json);
			if (!json.isNull("place_type")) {
				this.placeType = ParseUtil.getRawString("place_type", json);
			} else {
				this.placeType = ParseUtil.getRawString("type", json);
			}
			this.url = ParseUtil.getRawString("url", json);
			this.fullName = ParseUtil.getRawString("full_name", json);
			if (!json.isNull("bounding_box")) {
				final JSONObject boundingBoxJSON = json.getJSONObject("bounding_box");
				this.boundingBoxType = ParseUtil.getRawString("type", boundingBoxJSON);
				final JSONArray array = boundingBoxJSON.getJSONArray("coordinates");
				this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(array);
			} else {
				this.boundingBoxType = null;
				this.boundingBoxCoordinates = null;
			}
			if (!json.isNull("geometry")) {
				final JSONObject geometryJSON = json.getJSONObject("geometry");
				this.geometryType = ParseUtil.getRawString("type", geometryJSON);
				final JSONArray array = geometryJSON.getJSONArray("coordinates");
				if (this.geometryType.equals("Point")) {
					this.geometryCoordinates = new GeoLocation[1][1];
					this.geometryCoordinates[0][0] = new GeoLocation(array.getDouble(1), array.getDouble(0));
				} else if (this.geometryType.equals("Polygon")) {
					this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(array);
				} else {
					this.geometryType = null;
					this.geometryCoordinates = null;
				}
			} else {
				this.geometryType = null;
				this.geometryCoordinates = null;
			}
			if (!json.isNull("contained_within")) {
				final JSONArray containedWithInJSON = json.getJSONArray("contained_within");
				this.containedWithIn = new Place[containedWithInJSON.length()];
				for (int i = 0; i < containedWithInJSON.length(); ++i) {
					this.containedWithIn[i] = new PlaceJSONImpl(containedWithInJSON.getJSONObject(i));
				}
			} else {
				this.containedWithIn = null;
			}
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	@Override
	public int compareTo(final Place that) {
		return this.id.compareTo(that.getId());
	}

	static ResponseList<Place> createPlaceList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		JSONObject json = null;
		try {
			json = res.asJSONObject();
			return createPlaceList(json.getJSONObject("result").getJSONArray("places"), res, conf);
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	static ResponseList<Place> createPlaceList(final JSONArray list, final HttpResponse res, final Configuration conf)
			throws TwitterException {
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
		}
		try {
			final int size = list.length();
			final ResponseList<Place> places = new ResponseListImpl<Place>(size, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject json = list.getJSONObject(i);
				final Place place = new PlaceJSONImpl(json);
				places.add(place);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(place, json);
				}
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(places, list);
			}
			return places;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getStreetAddress() {
		return this.streetAddress;
	}

	@Override
	public String getCountryCode() {
		return this.countryCode;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getCountry() {
		return this.country;
	}

	@Override
	public String getPlaceType() {
		return this.placeType;
	}

	@Override
	public String getURL() {
		return this.url;
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public String getBoundingBoxType() {
		return this.boundingBoxType;
	}

	@Override
	public GeoLocation[][] getBoundingBoxCoordinates() {
		return this.boundingBoxCoordinates;
	}

	@Override
	public String getGeometryType() {
		return this.geometryType;
	}

	@Override
	public GeoLocation[][] getGeometryCoordinates() {
		return this.geometryCoordinates;
	}

	@Override
	public Place[] getContainedWithIn() {
		return this.containedWithIn;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj != null && (this == obj || (obj instanceof Place && ((Place) obj).getId().equals(this.id)));
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public String toString() {
		return "PlaceJSONImpl{name='" + this.name + '\'' + ", streetAddress='" + this.streetAddress + '\''
				+ ", countryCode='" + this.countryCode + '\'' + ", id='" + this.id + '\'' + ", country='" + this.country
				+ '\'' + ", placeType='" + this.placeType + '\'' + ", url='" + this.url + '\'' + ", fullName='"
				+ this.fullName + '\'' + ", boundingBoxType='" + this.boundingBoxType + '\''
				+ ", boundingBoxCoordinates="
				+ ((this.boundingBoxCoordinates == null) ? null : Arrays.asList(this.boundingBoxCoordinates))
				+ ", geometryType='" + this.geometryType + '\'' + ", geometryCoordinates="
				+ ((this.geometryCoordinates == null) ? null : Arrays.asList(this.geometryCoordinates))
				+ ", containedWithIn=" + ((this.containedWithIn == null) ? null : Arrays.asList(this.containedWithIn))
				+ '}';
	}
}
