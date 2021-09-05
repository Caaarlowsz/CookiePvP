package twitter4j;

import java.io.Serializable;

public final class UploadedMedia implements Serializable
{
    private static final long serialVersionUID = 5393092535610604718L;
    private int imageWidth;
    private int imageHeight;
    private String imageType;
    private long mediaId;
    private long size;
    
    UploadedMedia(final JSONObject json) throws TwitterException {
        this.init(json);
    }
    
    public int getImageWidth() {
        return this.imageWidth;
    }
    
    public int getImageHeight() {
        return this.imageHeight;
    }
    
    public String getImageType() {
        return this.imageType;
    }
    
    public long getMediaId() {
        return this.mediaId;
    }
    
    public long getSize() {
        return this.size;
    }
    
    private void init(final JSONObject json) throws TwitterException {
        this.mediaId = ParseUtil.getLong("media_id", json);
        this.size = ParseUtil.getLong("size", json);
        try {
            if (!json.isNull("image")) {
                final JSONObject image = json.getJSONObject("image");
                this.imageWidth = ParseUtil.getInt("w", image);
                this.imageHeight = ParseUtil.getInt("h", image);
                this.imageType = ParseUtil.getUnescapedString("image_type", image);
            }
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final UploadedMedia that = (UploadedMedia)o;
        return this.imageWidth == that.imageWidth && this.imageHeight == that.imageHeight && this.imageType == that.imageType && this.mediaId == that.mediaId && this.size == that.size;
    }
    
    @Override
    public int hashCode() {
        int result = (int)(this.mediaId ^ this.mediaId >>> 32);
        result = 31 * result + this.imageWidth;
        result = 31 * result + this.imageHeight;
        result = 31 * result + ((this.imageType != null) ? this.imageType.hashCode() : 0);
        result = 31 * result + (int)(this.size ^ this.size >>> 32);
        return result;
    }
    
    @Override
    public String toString() {
        return "UploadedMedia{mediaId=" + this.mediaId + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageType='" + this.imageType + '\'' + ", size=" + this.size + '}';
    }
}
