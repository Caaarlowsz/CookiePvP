package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

final class CategoryJSONImpl implements Category, Serializable {
	private static final long serialVersionUID = 3811335888122469876L;
	private String name;
	private String slug;
	private int size;

	CategoryJSONImpl(final JSONObject json) throws JSONException {
		this.init(json);
	}

	void init(final JSONObject json) throws JSONException {
		this.name = json.getString("name");
		this.slug = json.getString("slug");
		this.size = ParseUtil.getInt("size", json);
	}

	static ResponseList<Category> createCategoriesList(final HttpResponse res, final Configuration conf)
			throws TwitterException {
		return createCategoriesList(res.asJSONArray(), res, conf);
	}

	static ResponseList<Category> createCategoriesList(final JSONArray array, final HttpResponse res,
			final Configuration conf) throws TwitterException {
		try {
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
			}
			final ResponseList<Category> categories = new ResponseListImpl<Category>(array.length(), res);
			for (int i = 0; i < array.length(); ++i) {
				final JSONObject json = array.getJSONObject(i);
				final Category category = new CategoryJSONImpl(json);
				categories.add(category);
				if (conf.isJSONStoreEnabled()) {
					TwitterObjectFactory.registerJSONObject(category, json);
				}
			}
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.registerJSONObject(categories, array);
			}
			return categories;
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSlug() {
		return this.slug;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final CategoryJSONImpl that = (CategoryJSONImpl) o;
		if (this.size != that.size) {
			return false;
		}
		Label_0075: {
			if (this.name != null) {
				if (this.name.equals(that.name)) {
					break Label_0075;
				}
			} else if (that.name == null) {
				break Label_0075;
			}
			return false;
		}
		if (this.slug != null) {
			if (this.slug.equals(that.slug)) {
				return true;
			}
		} else if (that.slug == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.name != null) ? this.name.hashCode() : 0;
		result = 31 * result + ((this.slug != null) ? this.slug.hashCode() : 0);
		result = 31 * result + this.size;
		return result;
	}

	@Override
	public String toString() {
		return "CategoryJSONImpl{name='" + this.name + '\'' + ", slug='" + this.slug + '\'' + ", size=" + this.size
				+ '}';
	}
}
