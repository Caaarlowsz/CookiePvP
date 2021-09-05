package twitter4j;

import java.util.Arrays;

public class ExtendedMediaEntityJSONImpl extends MediaEntityJSONImpl implements ExtendedMediaEntity
{
    private static final long serialVersionUID = -3889082303259253211L;
    private int videoAspectRatioWidth;
    private int videoAspectRatioHeight;
    private long videoDurationMillis;
    private Variant[] videoVariants;
    
    ExtendedMediaEntityJSONImpl(final JSONObject json) throws TwitterException {
        super(json);
        try {
            if (json.has("video_info")) {
                final JSONObject videoInfo = json.getJSONObject("video_info");
                final JSONArray aspectRatio = videoInfo.getJSONArray("aspect_ratio");
                this.videoAspectRatioWidth = aspectRatio.getInt(0);
                this.videoAspectRatioHeight = aspectRatio.getInt(1);
                if (!videoInfo.isNull("duration_millis")) {
                    this.videoDurationMillis = videoInfo.getLong("duration_millis");
                }
                final JSONArray variants = videoInfo.getJSONArray("variants");
                this.videoVariants = new Variant[variants.length()];
                for (int i = 0; i < variants.length(); ++i) {
                    this.videoVariants[i] = new Variant(variants.getJSONObject(i));
                }
            }
            else {
                this.videoVariants = new Variant[0];
            }
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    ExtendedMediaEntityJSONImpl() {
    }
    
    @Override
    public int getVideoAspectRatioWidth() {
        return this.videoAspectRatioWidth;
    }
    
    @Override
    public int getVideoAspectRatioHeight() {
        return this.videoAspectRatioHeight;
    }
    
    @Override
    public long getVideoDurationMillis() {
        return this.videoDurationMillis;
    }
    
    @Override
    public ExtendedMediaEntity.Variant[] getVideoVariants() {
        return this.videoVariants;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExtendedMediaEntityJSONImpl)) {
            return false;
        }
        final ExtendedMediaEntityJSONImpl that = (ExtendedMediaEntityJSONImpl)o;
        return this.id == that.id;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.id ^ this.id >>> 32);
    }
    
    @Override
    public String toString() {
        return "ExtendedMediaEntityJSONImpl{id=" + this.id + ", url=" + this.url + ", mediaURL=" + this.mediaURL + ", mediaURLHttps=" + this.mediaURLHttps + ", expandedURL=" + this.expandedURL + ", displayURL='" + this.displayURL + '\'' + ", sizes=" + this.sizes + ", type=" + this.type + ", videoAspectRatioWidth=" + this.videoAspectRatioWidth + ", videoAspectRatioHeight=" + this.videoAspectRatioHeight + ", videoDurationMillis=" + this.videoDurationMillis + ", videoVariants=" + Arrays.toString(this.videoVariants) + '}';
    }
    
    static class Variant implements ExtendedMediaEntity.Variant
    {
        private static final long serialVersionUID = 1027236588556797980L;
        int bitrate;
        String contentType;
        String url;
        
        Variant(final JSONObject json) throws JSONException {
            this.bitrate = (json.has("bitrate") ? json.getInt("bitrate") : 0);
            this.contentType = json.getString("content_type");
            this.url = json.getString("url");
        }
        
        Variant() {
        }
        
        @Override
        public int getBitrate() {
            return this.bitrate;
        }
        
        @Override
        public String getContentType() {
            return this.contentType;
        }
        
        @Override
        public String getUrl() {
            return this.url;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Variant)) {
                return false;
            }
            final Variant variant = (Variant)o;
            return this.bitrate == variant.bitrate && this.contentType.equals(variant.contentType) && this.url.equals(variant.url);
        }
        
        @Override
        public int hashCode() {
            int result = this.bitrate;
            result = 31 * result + ((this.contentType != null) ? this.contentType.hashCode() : 0);
            result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
            return result;
        }
        
        @Override
        public String toString() {
            return "Variant{bitrate=" + this.bitrate + ", contentType=" + this.contentType + ", url=" + this.url + '}';
        }
    }
}
