package twitter4j;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import twitter4j.conf.Configuration;

class UserListJSONImpl extends TwitterResponseImpl implements UserList, Serializable {
	private static final long serialVersionUID = 449418980060197008L;
	private long id;
	private String name;
	private String fullName;
	private String slug;
	private String description;
	private int subscriberCount;
	private int memberCount;
	private String uri;
	private boolean mode;
	private User user;
	private boolean following;
	private Date createdAt;

	UserListJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.clearThreadLocalMap();
		}
		final JSONObject json = res.asJSONObject();
		this.init(json);
		if (conf.isJSONStoreEnabled()) {
			TwitterObjectFactory.registerJSONObject(this, json);
		}
	}

	UserListJSONImpl(final JSONObject json) throws TwitterException {
		this.init(json);
	}

	private void init(final JSONObject json) throws TwitterException {
		this.id = ParseUtil.getLong("id", json);
		this.name = ParseUtil.getRawString("name", json);
		this.fullName = ParseUtil.getRawString("full_name", json);
		this.slug = ParseUtil.getRawString("slug", json);
		this.description = ParseUtil.getRawString("description", json);
		this.subscriberCount = ParseUtil.getInt("subscriber_count", json);
		this.memberCount = ParseUtil.getInt("member_count", json);
		this.uri = ParseUtil.getRawString("uri", json);
		this.mode = "public".equals(ParseUtil.getRawString("mode", json));
		this.following = ParseUtil.getBoolean("following", json);
		this.createdAt = ParseUtil.getDate("created_at", json);
		try {
			if (!json.isNull("user")) {
				this.user = new UserJSONImpl(json.getJSONObject("user"));
			}
		} catch (JSONException jsone) {
			throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
		}
	}

	@Override
	public int compareTo(final UserList that) {
		final long delta = this.id - that.getId();
		if (delta < -2147483648L) {
			return Integer.MIN_VALUE;
		}
		if (delta > 2147483647L) {
			return Integer.MAX_VALUE;
		}
		return (int) delta;
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
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public String getSlug() {
		return this.slug;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public int getSubscriberCount() {
		return this.subscriberCount;
	}

	@Override
	public int getMemberCount() {
		return this.memberCount;
	}

	@Override
	public URI getURI() {
		try {
			return new URI(this.uri);
		} catch (URISyntaxException ex) {
			return null;
		}
	}

	@Override
	public boolean isPublic() {
		return this.mode;
	}

	@Override
	public boolean isFollowing() {
		return this.following;
	}

	@Override
	public Date getCreatedAt() {
		return this.createdAt;
	}

	@Override
	public User getUser() {
		return this.user;
	}

	static PagableResponseList<UserList> createPagableUserListList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final JSONObject json = res.asJSONObject();
			final JSONArray list = json.getJSONArray("lists");
			final int size = list.length();
			final PagableResponseList<UserList> users = new PagableResponseListImpl<UserList>(size, json, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject userListJson = list.getJSONObject(i);
				final UserList userList = new UserListJSONImpl(userListJson);
				users.add(userList);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(userList, userListJson);
				}
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(users, json);
			}
			return users;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	static ResponseList<UserList> createUserListList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final JSONArray list = res.asJSONArray();
			final int size = list.length();
			final ResponseList<UserList> users = new ResponseListImpl<UserList>(size, res);
			for (int i = 0; i < size; ++i) {
				final JSONObject userListJson = list.getJSONObject(i);
				final UserList userList = new UserListJSONImpl(userListJson);
				users.add(userList);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(userList, userListJson);
				}
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(users, list);
			}
			return users;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public int hashCode() {
		return (int) this.id;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj != null && (this == obj || (obj instanceof UserList && ((UserList) obj).getId() == this.id));
	}

	@Override
	public String toString() {
		return "UserListJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", fullName='" + this.fullName + '\''
				+ ", slug='" + this.slug + '\'' + ", description='" + this.description + '\'' + ", subscriberCount="
				+ this.subscriberCount + ", memberCount=" + this.memberCount + ", uri='" + this.uri + '\'' + ", mode="
				+ this.mode + ", user=" + this.user + ", following=" + this.following + '}';
	}
}
