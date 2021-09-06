package twitter4j;

class HashtagEntityJSONImpl extends EntityIndex implements HashtagEntity, SymbolEntity {
	private static final long serialVersionUID = -5317828991902848906L;
	private String text;

	HashtagEntityJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	HashtagEntityJSONImpl(final int start, final int end, final String text) {
		this.setStart(start);
		this.setEnd(end);
		this.text = text;
	}

	HashtagEntityJSONImpl() {
	}

	private void init(final JSONObject json) throws TwitterException {
		try {
			final JSONArray indicesArray = json.getJSONArray("indices");
			this.setStart(indicesArray.getInt(0));
			this.setEnd(indicesArray.getInt(1));
			if (!json.isNull("text")) {
				this.text = json.getString("text");
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public String getText() {
		return this.text;
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
		final HashtagEntityJSONImpl that = (HashtagEntityJSONImpl) o;
		if (this.text != null) {
			if (this.text.equals(that.text)) {
				return true;
			}
		} else if (that.text == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.text != null) ? this.text.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "HashtagEntityJSONImpl{text='" + this.text + '\'' + '}';
	}
}
