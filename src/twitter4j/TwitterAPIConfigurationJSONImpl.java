package twitter4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import twitter4j.conf.Configuration;

class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
	private static final long serialVersionUID = -3588904550808591686L;
	private int photoSizeLimit;
	private int shortURLLength;
	private int shortURLLengthHttps;
	private int charactersReservedPerMedia;
	private Map<Integer, MediaEntity.Size> photoSizes;
	private String[] nonUsernamePaths;
	private int maxMediaPerUpload;

	TwitterAPIConfigurationJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
		super(res);
		try {
			final JSONObject json = res.asJSONObject();
			this.photoSizeLimit = ParseUtil.getInt("photo_size_limit", json);
			this.shortURLLength = ParseUtil.getInt("short_url_length", json);
			this.shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", json);
			this.charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", json);
			final JSONObject sizes = json.getJSONObject("photo_sizes");
			(this.photoSizes = new HashMap<Integer, MediaEntity.Size>(4)).put(MediaEntity.Size.LARGE,
					new MediaEntityJSONImpl.Size(sizes.getJSONObject("large")));
			JSONObject medium;
			if (sizes.isNull("med")) {
				medium = sizes.getJSONObject("medium");
			} else {
				medium = sizes.getJSONObject("med");
			}
			this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(medium));
			this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(sizes.getJSONObject("small")));
			this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(sizes.getJSONObject("thumb")));
			if (conf.isJSONStoreEnabled()) {
				TwitterObjectFactory.clearThreadLocalMap();
				TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
			}
			final JSONArray nonUsernamePathsJSONArray = json.getJSONArray("non_username_paths");
			this.nonUsernamePaths = new String[nonUsernamePathsJSONArray.length()];
			for (int i = 0; i < nonUsernamePathsJSONArray.length(); ++i) {
				this.nonUsernamePaths[i] = nonUsernamePathsJSONArray.getString(i);
			}
			this.maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", json);
		} catch (JSONException jsone) {
			throw new TwitterException(jsone);
		}
	}

	@Override
	public int getPhotoSizeLimit() {
		return this.photoSizeLimit;
	}

	@Override
	public int getShortURLLength() {
		return this.shortURLLength;
	}

	@Override
	public int getShortURLLengthHttps() {
		return this.shortURLLengthHttps;
	}

	@Override
	public int getCharactersReservedPerMedia() {
		return this.charactersReservedPerMedia;
	}

	@Override
	public Map<Integer, MediaEntity.Size> getPhotoSizes() {
		return this.photoSizes;
	}

	@Override
	public String[] getNonUsernamePaths() {
		return this.nonUsernamePaths;
	}

	@Override
	public int getMaxMediaPerUpload() {
		return this.maxMediaPerUpload;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TwitterAPIConfigurationJSONImpl)) {
			return false;
		}
		final TwitterAPIConfigurationJSONImpl that = (TwitterAPIConfigurationJSONImpl) o;
		if (this.charactersReservedPerMedia != that.charactersReservedPerMedia) {
			return false;
		}
		if (this.maxMediaPerUpload != that.maxMediaPerUpload) {
			return false;
		}
		if (this.photoSizeLimit != that.photoSizeLimit) {
			return false;
		}
		if (this.shortURLLength != that.shortURLLength) {
			return false;
		}
		if (this.shortURLLengthHttps != that.shortURLLengthHttps) {
			return false;
		}
		if (!Arrays.equals(this.nonUsernamePaths, that.nonUsernamePaths)) {
			return false;
		}
		if (this.photoSizes != null) {
			if (this.photoSizes.equals(that.photoSizes)) {
				return true;
			}
		} else if (that.photoSizes == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = this.photoSizeLimit;
		result = 31 * result + this.shortURLLength;
		result = 31 * result + this.shortURLLengthHttps;
		result = 31 * result + this.charactersReservedPerMedia;
		result = 31 * result + ((this.photoSizes != null) ? this.photoSizes.hashCode() : 0);
		result = 31 * result + ((this.nonUsernamePaths != null) ? Arrays.hashCode(this.nonUsernamePaths) : 0);
		result = 31 * result + this.maxMediaPerUpload;
		return result;
	}

	@Override
	public String toString() {
		return "TwitterAPIConfigurationJSONImpl{photoSizeLimit=" + this.photoSizeLimit + ", shortURLLength="
				+ this.shortURLLength + ", shortURLLengthHttps=" + this.shortURLLengthHttps
				+ ", charactersReservedPerMedia=" + this.charactersReservedPerMedia + ", photoSizes=" + this.photoSizes
				+ ", nonUsernamePaths="
				+ ((this.nonUsernamePaths == null) ? null : Arrays.asList(this.nonUsernamePaths))
				+ ", maxMediaPerUpload=" + this.maxMediaPerUpload + '}';
	}
}
