package twitter4j;

import twitter4j.conf.Configuration;
import java.io.Serializable;

public class OEmbedJSONImpl extends TwitterResponseImpl implements OEmbed, Serializable
{
    private static final long serialVersionUID = -2207801480251709819L;
    private String html;
    private String authorName;
    private String url;
    private String version;
    private long cacheAge;
    private String authorURL;
    private int width;
    
    OEmbedJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
        super(res);
        final JSONObject json = res.asJSONObject();
        this.init(json);
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, json);
        }
    }
    
    OEmbedJSONImpl(final JSONObject json) throws TwitterException {
        this.init(json);
    }
    
    private void init(final JSONObject json) throws TwitterException {
        try {
            this.html = json.getString("html");
            this.authorName = json.getString("author_name");
            this.url = json.getString("url");
            this.version = json.getString("version");
            this.cacheAge = json.getLong("cache_age");
            this.authorURL = json.getString("author_url");
            this.width = json.getInt("width");
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public String getHtml() {
        return this.html;
    }
    
    @Override
    public String getAuthorName() {
        return this.authorName;
    }
    
    @Override
    public String getURL() {
        return this.url;
    }
    
    @Override
    public String getVersion() {
        return this.version;
    }
    
    @Override
    public long getCacheAge() {
        return this.cacheAge;
    }
    
    @Override
    public String getAuthorURL() {
        return this.authorURL;
    }
    
    @Override
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final OEmbedJSONImpl that = (OEmbedJSONImpl)o;
        if (this.cacheAge != that.cacheAge) {
            return false;
        }
        if (this.width != that.width) {
            return false;
        }
        Label_0089: {
            if (this.authorName != null) {
                if (this.authorName.equals(that.authorName)) {
                    break Label_0089;
                }
            }
            else if (that.authorName == null) {
                break Label_0089;
            }
            return false;
        }
        Label_0122: {
            if (this.authorURL != null) {
                if (this.authorURL.equals(that.authorURL)) {
                    break Label_0122;
                }
            }
            else if (that.authorURL == null) {
                break Label_0122;
            }
            return false;
        }
        Label_0155: {
            if (this.html != null) {
                if (this.html.equals(that.html)) {
                    break Label_0155;
                }
            }
            else if (that.html == null) {
                break Label_0155;
            }
            return false;
        }
        Label_0188: {
            if (this.url != null) {
                if (this.url.equals(that.url)) {
                    break Label_0188;
                }
            }
            else if (that.url == null) {
                break Label_0188;
            }
            return false;
        }
        if (this.version != null) {
            if (this.version.equals(that.version)) {
                return true;
            }
        }
        else if (that.version == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (this.html != null) ? this.html.hashCode() : 0;
        result = 31 * result + ((this.authorName != null) ? this.authorName.hashCode() : 0);
        result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
        result = 31 * result + ((this.version != null) ? this.version.hashCode() : 0);
        result = 31 * result + (int)(this.cacheAge ^ this.cacheAge >>> 32);
        result = 31 * result + ((this.authorURL != null) ? this.authorURL.hashCode() : 0);
        result = 31 * result + this.width;
        return result;
    }
    
    @Override
    public String toString() {
        return "OEmbedJSONImpl{html='" + this.html + '\'' + ", authorName='" + this.authorName + '\'' + ", url='" + this.url + '\'' + ", version='" + this.version + '\'' + ", cacheAge=" + this.cacheAge + ", authorURL='" + this.authorURL + '\'' + ", width=" + this.width + '}';
    }
}
