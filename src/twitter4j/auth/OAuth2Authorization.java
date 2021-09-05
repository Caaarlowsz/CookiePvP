package twitter4j.auth;

import twitter4j.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import twitter4j.HttpRequest;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.HttpResponseListener;
import twitter4j.HttpParameter;
import twitter4j.HttpClientFactory;
import twitter4j.HttpClient;
import twitter4j.conf.Configuration;
import java.io.Serializable;

public class OAuth2Authorization implements Authorization, Serializable, OAuth2Support
{
    private static final long serialVersionUID = -2895232598422218647L;
    private final Configuration conf;
    private final HttpClient http;
    private String consumerKey;
    private String consumerSecret;
    private OAuth2Token token;
    
    public OAuth2Authorization(final Configuration conf) {
        this.conf = conf;
        this.setOAuthConsumer(conf.getOAuthConsumerKey(), conf.getOAuthConsumerSecret());
        this.http = HttpClientFactory.getInstance(conf.getHttpClientConfiguration());
    }
    
    @Override
    public void setOAuthConsumer(final String consumerKey, final String consumerSecret) {
        this.consumerKey = ((consumerKey != null) ? consumerKey : "");
        this.consumerSecret = ((consumerSecret != null) ? consumerSecret : "");
    }
    
    @Override
    public OAuth2Token getOAuth2Token() throws TwitterException {
        if (this.token != null) {
            throw new IllegalStateException("OAuth 2 Bearer Token is already available.");
        }
        final HttpParameter[] params = new HttpParameter[(this.conf.getOAuth2Scope() == null) ? 1 : 2];
        params[0] = new HttpParameter("grant_type", "client_credentials");
        if (this.conf.getOAuth2Scope() != null) {
            params[1] = new HttpParameter("scope", this.conf.getOAuth2Scope());
        }
        final HttpResponse res = this.http.post(this.conf.getOAuth2TokenURL(), params, this, null);
        if (res.getStatusCode() != 200) {
            throw new TwitterException("Obtaining OAuth 2 Bearer Token failed.", res);
        }
        return this.token = new OAuth2Token(res);
    }
    
    @Override
    public void setOAuth2Token(final OAuth2Token oauth2Token) {
        this.token = oauth2Token;
    }
    
    @Override
    public void invalidateOAuth2Token() throws TwitterException {
        if (this.token == null) {
            throw new IllegalStateException("OAuth 2 Bearer Token is not available.");
        }
        final HttpParameter[] params = { new HttpParameter("access_token", this.token.getAccessToken()) };
        final OAuth2Token _token = this.token;
        boolean succeed = false;
        try {
            this.token = null;
            final HttpResponse res = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), params, this, null);
            if (res.getStatusCode() != 200) {
                throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", res);
            }
            succeed = true;
        }
        finally {
            if (!succeed) {
                this.token = _token;
            }
        }
        if (!succeed) {
            this.token = _token;
        }
    }
    
    @Override
    public String getAuthorizationHeader(final HttpRequest req) {
        if (this.token == null) {
            String credentials = "";
            try {
                credentials = String.valueOf(URLEncoder.encode(this.consumerKey, "UTF-8")) + ":" + URLEncoder.encode(this.consumerSecret, "UTF-8");
            }
            catch (UnsupportedEncodingException ex) {}
            return "Basic " + BASE64Encoder.encode(credentials.getBytes());
        }
        return this.token.generateAuthorizationHeader();
    }
    
    @Override
    public boolean isEnabled() {
        return this.token != null;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof OAuth2Authorization)) {
            return false;
        }
        final OAuth2Authorization that = (OAuth2Authorization)obj;
        Label_0051: {
            if (this.consumerKey != null) {
                if (this.consumerKey.equals(that.consumerKey)) {
                    break Label_0051;
                }
            }
            else if (that.consumerKey == null) {
                break Label_0051;
            }
            return false;
        }
        Label_0084: {
            if (this.consumerSecret != null) {
                if (this.consumerSecret.equals(that.consumerSecret)) {
                    break Label_0084;
                }
            }
            else if (that.consumerSecret == null) {
                break Label_0084;
            }
            return false;
        }
        if (this.token != null) {
            if (this.token.equals(that.token)) {
                return true;
            }
        }
        else if (that.token == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (this.consumerKey != null) ? this.consumerKey.hashCode() : 0;
        result = 31 * result + ((this.consumerSecret != null) ? this.consumerSecret.hashCode() : 0);
        result = 31 * result + ((this.token != null) ? this.token.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "OAuth2Authorization{consumerKey='" + this.consumerKey + '\'' + ", consumerSecret='******************************************'" + ", token=" + ((this.token == null) ? "null" : this.token.toString()) + '}';
    }
}
