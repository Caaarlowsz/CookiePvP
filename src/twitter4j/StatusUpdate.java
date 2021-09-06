package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StatusUpdate implements Serializable {
	private static final long serialVersionUID = 7422094739799350035L;
	private final String status;
	private long inReplyToStatusId;
	private GeoLocation location;
	private String placeId;
	private boolean displayCoordinates;
	private boolean possiblySensitive;
	private String mediaName;
	private transient InputStream mediaBody;
	private File mediaFile;
	private long[] mediaIds;

	public StatusUpdate(final String status) {
		this.inReplyToStatusId = -1L;
		this.location = null;
		this.placeId = null;
		this.displayCoordinates = true;
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public long getInReplyToStatusId() {
		return this.inReplyToStatusId;
	}

	public void setInReplyToStatusId(final long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public StatusUpdate inReplyToStatusId(final long inReplyToStatusId) {
		this.setInReplyToStatusId(inReplyToStatusId);
		return this;
	}

	public GeoLocation getLocation() {
		return this.location;
	}

	public void setLocation(final GeoLocation location) {
		this.location = location;
	}

	public StatusUpdate location(final GeoLocation location) {
		this.setLocation(location);
		return this;
	}

	public String getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(final String placeId) {
		this.placeId = placeId;
	}

	public StatusUpdate placeId(final String placeId) {
		this.setPlaceId(placeId);
		return this;
	}

	public boolean isDisplayCoordinates() {
		return this.displayCoordinates;
	}

	public void setDisplayCoordinates(final boolean displayCoordinates) {
		this.displayCoordinates = displayCoordinates;
	}

	public StatusUpdate displayCoordinates(final boolean displayCoordinates) {
		this.setDisplayCoordinates(displayCoordinates);
		return this;
	}

	public void setMedia(final File file) {
		this.mediaFile = file;
	}

	public StatusUpdate media(final File file) {
		this.setMedia(file);
		return this;
	}

	public void setMedia(final String name, final InputStream body) {
		this.mediaName = name;
		this.mediaBody = body;
	}

	public void setMediaIds(final long[] mediaIds) {
		this.mediaIds = mediaIds;
	}

	boolean isForUpdateWithMedia() {
		return this.mediaFile != null || this.mediaName != null;
	}

	public StatusUpdate media(final String name, final InputStream body) {
		this.setMedia(name, body);
		return this;
	}

	public void setPossiblySensitive(final boolean possiblySensitive) {
		this.possiblySensitive = possiblySensitive;
	}

	public StatusUpdate possiblySensitive(final boolean possiblySensitive) {
		this.setPossiblySensitive(possiblySensitive);
		return this;
	}

	public boolean isPossiblySensitive() {
		return this.possiblySensitive;
	}

	HttpParameter[] asHttpParameterArray() {
		final ArrayList<HttpParameter> params = new ArrayList<HttpParameter>();
		this.appendParameter("status", this.status, params);
		if (-1L != this.inReplyToStatusId) {
			this.appendParameter("in_reply_to_status_id", this.inReplyToStatusId, params);
		}
		if (this.location != null) {
			this.appendParameter("lat", this.location.getLatitude(), params);
			this.appendParameter("long", this.location.getLongitude(), params);
		}
		this.appendParameter("place_id", this.placeId, params);
		if (!this.displayCoordinates) {
			this.appendParameter("display_coordinates", "false", params);
		}
		if (this.mediaFile != null) {
			params.add(new HttpParameter("media[]", this.mediaFile));
			params.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
		} else if (this.mediaName != null && this.mediaBody != null) {
			params.add(new HttpParameter("media[]", this.mediaName, this.mediaBody));
			params.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
		} else if (this.mediaIds != null && this.mediaIds.length >= 1) {
			params.add(new HttpParameter("media_ids", StringUtil.join(this.mediaIds)));
		}
		final HttpParameter[] paramArray = new HttpParameter[params.size()];
		return params.toArray(paramArray);
	}

	private void appendParameter(final String name, final String value, final List<HttpParameter> params) {
		if (value != null) {
			params.add(new HttpParameter(name, value));
		}
	}

	private void appendParameter(final String name, final double value, final List<HttpParameter> params) {
		params.add(new HttpParameter(name, String.valueOf(value)));
	}

	private void appendParameter(final String name, final long value, final List<HttpParameter> params) {
		params.add(new HttpParameter(name, String.valueOf(value)));
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final StatusUpdate that = (StatusUpdate) o;
		if (this.displayCoordinates != that.displayCoordinates) {
			return false;
		}
		if (this.inReplyToStatusId != that.inReplyToStatusId) {
			return false;
		}
		if (this.possiblySensitive != that.possiblySensitive) {
			return false;
		}
		Label_0102: {
			if (this.location != null) {
				if (this.location.equals(that.location)) {
					break Label_0102;
				}
			} else if (that.location == null) {
				break Label_0102;
			}
			return false;
		}
		Label_0135: {
			if (this.mediaBody != null) {
				if (this.mediaBody.equals(that.mediaBody)) {
					break Label_0135;
				}
			} else if (that.mediaBody == null) {
				break Label_0135;
			}
			return false;
		}
		Label_0168: {
			if (this.mediaFile != null) {
				if (this.mediaFile.equals(that.mediaFile)) {
					break Label_0168;
				}
			} else if (that.mediaFile == null) {
				break Label_0168;
			}
			return false;
		}
		Label_0201: {
			if (this.mediaName != null) {
				if (this.mediaName.equals(that.mediaName)) {
					break Label_0201;
				}
			} else if (that.mediaName == null) {
				break Label_0201;
			}
			return false;
		}
		Label_0234: {
			if (this.mediaIds != null) {
				if (Arrays.equals(this.mediaIds, that.mediaIds)) {
					break Label_0234;
				}
			} else if (that.mediaIds == null) {
				break Label_0234;
			}
			return false;
		}
		Label_0267: {
			if (this.placeId != null) {
				if (this.placeId.equals(that.placeId)) {
					break Label_0267;
				}
			} else if (that.placeId == null) {
				break Label_0267;
			}
			return false;
		}
		if (this.status != null) {
			if (this.status.equals(that.status)) {
				return true;
			}
		} else if (that.status == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.status != null) ? this.status.hashCode() : 0;
		result = 31 * result + (int) (this.inReplyToStatusId ^ this.inReplyToStatusId >>> 32);
		result = 31 * result + ((this.location != null) ? this.location.hashCode() : 0);
		result = 31 * result + ((this.placeId != null) ? this.placeId.hashCode() : 0);
		result = 31 * result + (this.displayCoordinates ? 1 : 0);
		result = 31 * result + (this.possiblySensitive ? 1 : 0);
		result = 31 * result + ((this.mediaName != null) ? this.mediaName.hashCode() : 0);
		result = 31 * result + ((this.mediaBody != null) ? this.mediaBody.hashCode() : 0);
		result = 31 * result + ((this.mediaFile != null) ? this.mediaFile.hashCode() : 0);
		result = 31 * result + ((this.mediaIds != null) ? StringUtil.join(this.mediaIds).hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "StatusUpdate{status='" + this.status + '\'' + ", inReplyToStatusId=" + this.inReplyToStatusId
				+ ", location=" + this.location + ", placeId='" + this.placeId + '\'' + ", displayCoordinates="
				+ this.displayCoordinates + ", possiblySensitive=" + this.possiblySensitive + ", mediaName='"
				+ this.mediaName + '\'' + ", mediaBody=" + this.mediaBody + ", mediaFile=" + this.mediaFile
				+ ", mediaIds=" + this.mediaIds + '}';
	}
}
