package twitter4j;

class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
	private static final long serialVersionUID = 6060510953676673013L;
	private String name;
	private String screenName;
	private long id;

	UserMentionEntityJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	UserMentionEntityJSONImpl(final int start, final int end, final String name, final String screenName,
			final long id) {
		this.setStart(start);
		this.setEnd(end);
		this.name = name;
		this.screenName = screenName;
		this.id = id;
	}

	UserMentionEntityJSONImpl() {
	}

	private void init(final JSONObject json) throws TwitterException {
		try {
			final JSONArray indicesArray = json.getJSONArray("indices");
			this.setStart(indicesArray.getInt(0));
			this.setEnd(indicesArray.getInt(1));
			if (!json.isNull("name")) {
				this.name = json.getString("name");
			}
			if (!json.isNull("screen_name")) {
				this.screenName = json.getString("screen_name");
			}
			this.id = ParseUtil.getLong("id", json);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public String getText() {
		return this.screenName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getScreenName() {
		return this.screenName;
	}

	@Override
	public long getId() {
		return this.id;
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
		final UserMentionEntityJSONImpl that = (UserMentionEntityJSONImpl) o;
		if (this.id != that.id) {
			return false;
		}
		Label_0076: {
			if (this.name != null) {
				if (this.name.equals(that.name)) {
					break Label_0076;
				}
			} else if (that.name == null) {
				break Label_0076;
			}
			return false;
		}
		if (this.screenName != null) {
			if (this.screenName.equals(that.screenName)) {
				return true;
			}
		} else if (that.screenName == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.name != null) ? this.name.hashCode() : 0;
		result = 31 * result + ((this.screenName != null) ? this.screenName.hashCode() : 0);
		result = 31 * result + (int) (this.id ^ this.id >>> 32);
		return result;
	}

	@Override
	public String toString() {
		return "UserMentionEntityJSONImpl{name='" + this.name + '\'' + ", screenName='" + this.screenName + '\''
				+ ", id=" + this.id + '}';
	}
}
