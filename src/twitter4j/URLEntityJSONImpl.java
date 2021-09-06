package twitter4j;

final class URLEntityJSONImpl extends EntityIndex implements URLEntity {
	private static final long serialVersionUID = 7333552738058031524L;
	private String url;
	private String expandedURL;
	private String displayURL;

	URLEntityJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	URLEntityJSONImpl(final int start, final int end, final String url, final String expandedURL,
			final String displayURL) {
		this.setStart(start);
		this.setEnd(end);
		this.url = url;
		this.expandedURL = expandedURL;
		this.displayURL = displayURL;
	}

	URLEntityJSONImpl() {
	}

	private void init(final JSONObject json) throws TwitterException {
		try {
			final JSONArray indicesArray = json.getJSONArray("indices");
			this.setStart(indicesArray.getInt(0));
			this.setEnd(indicesArray.getInt(1));
			this.url = json.getString("url");
			if (!json.isNull("expanded_url")) {
				this.expandedURL = json.getString("expanded_url");
			} else {
				this.expandedURL = this.url;
			}
			if (!json.isNull("display_url")) {
				this.displayURL = json.getString("display_url");
			} else {
				this.displayURL = this.url;
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public String getText() {
		return this.url;
	}

	@Override
	public String getURL() {
		return this.url;
	}

	@Override
	public String getExpandedURL() {
		return this.expandedURL;
	}

	@Override
	public String getDisplayURL() {
		return this.displayURL;
	}

	@Override
	public int getStart() {
		return super.getStart();
	}

	@Override
	public int getEnd() {
		return super.getEnd();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final URLEntityJSONImpl that = (URLEntityJSONImpl) o;
		Label_0062: {
			if (this.displayURL != null) {
				if (this.displayURL.equals(that.displayURL)) {
					break Label_0062;
				}
			} else if (that.displayURL == null) {
				break Label_0062;
			}
			return false;
		}
		Label_0095: {
			if (this.expandedURL != null) {
				if (this.expandedURL.equals(that.expandedURL)) {
					break Label_0095;
				}
			} else if (that.expandedURL == null) {
				break Label_0095;
			}
			return false;
		}
		if (this.url != null) {
			if (this.url.equals(that.url)) {
				return true;
			}
		} else if (that.url == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.url != null) ? this.url.hashCode() : 0;
		result = 31 * result + ((this.expandedURL != null) ? this.expandedURL.hashCode() : 0);
		result = 31 * result + ((this.displayURL != null) ? this.displayURL.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "URLEntityJSONImpl{url='" + this.url + '\'' + ", expandedURL='" + this.expandedURL + '\''
				+ ", displayURL='" + this.displayURL + '\'' + '}';
	}
}
