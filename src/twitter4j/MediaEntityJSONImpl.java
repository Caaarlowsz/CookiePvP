package twitter4j;

import java.util.HashMap;
import java.util.Map;

public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
	private static final long serialVersionUID = 3609683338035442290L;
	protected long id;
	protected String url;
	protected String mediaURL;
	protected String mediaURLHttps;
	protected String expandedURL;
	protected String displayURL;
	protected Map<Integer, MediaEntity.Size> sizes;
	protected String type;

	MediaEntityJSONImpl(final JSONObject json) throws TwitterException {
		try {
			final JSONArray indicesArray = json.getJSONArray("indices");
			this.setStart(indicesArray.getInt(0));
			this.setEnd(indicesArray.getInt(1));
			this.id = ParseUtil.getLong("id", json);
			this.url = json.getString("url");
			this.expandedURL = json.getString("expanded_url");
			this.mediaURL = json.getString("media_url");
			this.mediaURLHttps = json.getString("media_url_https");
			this.displayURL = json.getString("display_url");
			final JSONObject sizes = json.getJSONObject("sizes");
			this.addMediaEntitySizeIfNotNull(this.sizes = new HashMap<Integer, MediaEntity.Size>(4), sizes,
					MediaEntity.Size.LARGE, "large");
			this.addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.MEDIUM, "medium");
			this.addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.SMALL, "small");
			this.addMediaEntitySizeIfNotNull(this.sizes, sizes, MediaEntity.Size.THUMB, "thumb");
			if (!json.isNull("type")) {
				this.type = json.getString("type");
			}
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	private void addMediaEntitySizeIfNotNull(final Map<Integer, MediaEntity.Size> sizes, final JSONObject sizesJSON,
			final Integer size, final String key) throws JSONException {
		if (!sizesJSON.isNull(key)) {
			sizes.put(size, new Size(sizesJSON.getJSONObject(key)));
		}
	}

	MediaEntityJSONImpl() {
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public String getMediaURL() {
		return this.mediaURL;
	}

	@Override
	public String getMediaURLHttps() {
		return this.mediaURLHttps;
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
	public String getDisplayURL() {
		return this.displayURL;
	}

	@Override
	public String getExpandedURL() {
		return this.expandedURL;
	}

	@Override
	public Map<Integer, MediaEntity.Size> getSizes() {
		return this.sizes;
	}

	@Override
	public String getType() {
		return this.type;
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
		if (!(o instanceof MediaEntityJSONImpl)) {
			return false;
		}
		final MediaEntityJSONImpl that = (MediaEntityJSONImpl) o;
		return this.id == that.id;
	}

	@Override
	public int hashCode() {
		return (int) (this.id ^ this.id >>> 32);
	}

	@Override
	public String toString() {
		return "MediaEntityJSONImpl{id=" + this.id + ", url=" + this.url + ", mediaURL=" + this.mediaURL
				+ ", mediaURLHttps=" + this.mediaURLHttps + ", expandedURL=" + this.expandedURL + ", displayURL='"
				+ this.displayURL + '\'' + ", sizes=" + this.sizes + ", type=" + this.type + '}';
	}

	static class Size implements MediaEntity.Size {
		private static final long serialVersionUID = -2515842281909325169L;
		int width;
		int height;
		int resize;

		Size() {
		}

		Size(final JSONObject json) throws JSONException {
			this.width = json.getInt("w");
			this.height = json.getInt("h");
			this.resize = ("fit".equals(json.getString("resize")) ? 100 : 101);
		}

		@Override
		public int getWidth() {
			return this.width;
		}

		@Override
		public int getHeight() {
			return this.height;
		}

		@Override
		public int getResize() {
			return this.resize;
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) {
				return true;
			}
			if (!(o instanceof Size)) {
				return false;
			}
			final Size size = (Size) o;
			return this.height == size.height && this.resize == size.resize && this.width == size.width;
		}

		@Override
		public int hashCode() {
			int result = this.width;
			result = 31 * result + this.height;
			result = 31 * result + this.resize;
			return result;
		}

		@Override
		public String toString() {
			return "Size{width=" + this.width + ", height=" + this.height + ", resize=" + this.resize + '}';
		}
	}
}
