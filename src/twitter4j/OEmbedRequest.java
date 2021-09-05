package twitter4j;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public final class OEmbedRequest implements Serializable
{
    private static final long serialVersionUID = 7454130135274547901L;
    private final long statusId;
    private final String url;
    private int maxWidth;
    private boolean hideMedia;
    private boolean hideThread;
    private boolean omitScript;
    private Align align;
    private String[] related;
    private String lang;
    
    public OEmbedRequest(final long statusId, final String url) {
        this.hideMedia = true;
        this.hideThread = true;
        this.omitScript = false;
        this.align = Align.NONE;
        this.related = new String[0];
        this.statusId = statusId;
        this.url = url;
    }
    
    public void setMaxWidth(final int maxWidth) {
        this.maxWidth = maxWidth;
    }
    
    public OEmbedRequest MaxWidth(final int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }
    
    public void setHideMedia(final boolean hideMedia) {
        this.hideMedia = hideMedia;
    }
    
    public OEmbedRequest HideMedia(final boolean hideMedia) {
        this.hideMedia = hideMedia;
        return this;
    }
    
    public void setHideThread(final boolean hideThread) {
        this.hideThread = hideThread;
    }
    
    public OEmbedRequest HideThread(final boolean hideThread) {
        this.hideThread = hideThread;
        return this;
    }
    
    public void setOmitScript(final boolean omitScript) {
        this.omitScript = omitScript;
    }
    
    public OEmbedRequest omitScript(final boolean omitScript) {
        this.omitScript = omitScript;
        return this;
    }
    
    public void setAlign(final Align align) {
        this.align = align;
    }
    
    public OEmbedRequest align(final Align align) {
        this.align = align;
        return this;
    }
    
    public void setRelated(final String[] related) {
        this.related = related;
    }
    
    public OEmbedRequest related(final String[] related) {
        this.related = related;
        return this;
    }
    
    public void setLang(final String lang) {
        this.lang = lang;
    }
    
    public OEmbedRequest lang(final String lang) {
        this.lang = lang;
        return this;
    }
    
    HttpParameter[] asHttpParameterArray() {
        final ArrayList<HttpParameter> params = new ArrayList<HttpParameter>(12);
        this.appendParameter("id", this.statusId, params);
        this.appendParameter("url", this.url, params);
        this.appendParameter("maxwidth", this.maxWidth, params);
        params.add(new HttpParameter("hide_media", this.hideMedia));
        params.add(new HttpParameter("hide_thread", this.hideThread));
        params.add(new HttpParameter("omit_script", this.omitScript));
        params.add(new HttpParameter("align", this.align.name().toLowerCase()));
        if (this.related.length > 0) {
            this.appendParameter("related", StringUtil.join(this.related), params);
        }
        this.appendParameter("lang", this.lang, params);
        final HttpParameter[] paramArray = new HttpParameter[params.size()];
        return params.toArray(paramArray);
    }
    
    private void appendParameter(final String name, final String value, final List<HttpParameter> params) {
        if (value != null) {
            params.add(new HttpParameter(name, value));
        }
    }
    
    private void appendParameter(final String name, final long value, final List<HttpParameter> params) {
        if (0L <= value) {
            params.add(new HttpParameter(name, String.valueOf(value)));
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
        final OEmbedRequest that = (OEmbedRequest)o;
        if (this.hideMedia != that.hideMedia) {
            return false;
        }
        if (this.hideThread != that.hideThread) {
            return false;
        }
        if (this.maxWidth != that.maxWidth) {
            return false;
        }
        if (this.omitScript != that.omitScript) {
            return false;
        }
        if (this.statusId != that.statusId) {
            return false;
        }
        if (this.align != that.align) {
            return false;
        }
        Label_0141: {
            if (this.lang != null) {
                if (this.lang.equals(that.lang)) {
                    break Label_0141;
                }
            }
            else if (that.lang == null) {
                break Label_0141;
            }
            return false;
        }
        if (!Arrays.equals(this.related, that.related)) {
            return false;
        }
        if (this.url != null) {
            if (this.url.equals(that.url)) {
                return true;
            }
        }
        else if (that.url == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (int)(this.statusId ^ this.statusId >>> 32);
        result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
        result = 31 * result + this.maxWidth;
        result = 31 * result + (this.hideMedia ? 1 : 0);
        result = 31 * result + (this.hideThread ? 1 : 0);
        result = 31 * result + (this.omitScript ? 1 : 0);
        result = 31 * result + ((this.align != null) ? this.align.hashCode() : 0);
        result = 31 * result + ((this.related != null) ? Arrays.hashCode(this.related) : 0);
        result = 31 * result + ((this.lang != null) ? this.lang.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "OEmbedRequest{statusId=" + this.statusId + ", url='" + this.url + '\'' + ", maxWidth=" + this.maxWidth + ", hideMedia=" + this.hideMedia + ", hideThread=" + this.hideThread + ", omitScript=" + this.omitScript + ", align=" + this.align + ", related=" + ((this.related == null) ? null : Arrays.asList(this.related)) + ", lang='" + this.lang + '\'' + '}';
    }
    
    public enum Align
    {
        LEFT("LEFT", 0), 
        CENTER("CENTER", 1), 
        RIGHT("RIGHT", 2), 
        NONE("NONE", 3);
        
        private Align(final String s, final int n) {
        }
    }
}
