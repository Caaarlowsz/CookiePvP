package twitter4j;

import twitter4j.conf.Configuration;

class FriendshipJSONImpl implements Friendship {
	private static final long serialVersionUID = 6847273186993125826L;
	private final long id;
	private final String name;
	private final String screenName;
	private boolean following;
	private boolean followedBy;

	FriendshipJSONImpl(final JSONObject json) throws TwitterException {
		this.following = false;
		this.followedBy = false;
		try {
			this.id = ParseUtil.getLong("id", json);
			this.name = json.getString("name");
			this.screenName = json.getString("screen_name");
			final JSONArray connections = json.getJSONArray("connections");
			for (int i = 0; i < connections.length(); ++i) {
				final String connection = connections.getString(i);
				if ("following".equals(connection)) {
					this.following = true;
				} else if ("followed_by".equals(connection)) {
					this.followedBy = true;
				}
			}
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	static ResponseList<Friendship> createFriendshipList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final JSONArray list = res.asJSONArray();
			final int size = list.length();
			final ResponseList<Friendship> friendshipList = new ResponseListImpl<Friendship>(size, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject json = list.getJSONObject(i);
				final Friendship friendship = new FriendshipJSONImpl(json);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(friendship, json);
				}
				friendshipList.add(friendship);
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(friendshipList, list);
			}
			return friendshipList;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public long getId() {
		return this.id;
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
	public boolean isFollowing() {
		return this.following;
	}

	@Override
	public boolean isFollowedBy() {
		return this.followedBy;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final FriendshipJSONImpl that = (FriendshipJSONImpl) o;
		return this.followedBy == that.followedBy && this.following == that.following && this.id == that.id
				&& this.name.equals(that.name) && this.screenName.equals(that.screenName);
	}

	@Override
	public int hashCode() {
		int result = (int) (this.id ^ this.id >>> 32);
		result = 31 * result + ((this.name != null) ? this.name.hashCode() : 0);
		result = 31 * result + ((this.screenName != null) ? this.screenName.hashCode() : 0);
		result = 31 * result + (this.following ? 1 : 0);
		result = 31 * result + (this.followedBy ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "FriendshipJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", screenName='" + this.screenName
				+ '\'' + ", following=" + this.following + ", followedBy=" + this.followedBy + '}';
	}
}
