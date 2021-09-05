package twitter4j.auth;

import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationContext;
import twitter4j.HttpResponse;
import twitter4j.conf.Configuration;
import java.io.Serializable;

public final class RequestToken extends OAuthToken implements Serializable
{
    private static final long serialVersionUID = -8806439091674811734L;
    private final Configuration conf;
    private OAuthSupport oauth;
    
    RequestToken(final HttpResponse res, final OAuthSupport oauth) throws TwitterException {
        super(res);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oauth;
    }
    
    public RequestToken(final String token, final String tokenSecret) {
        super(token, tokenSecret);
        this.conf = ConfigurationContext.getInstance();
    }
    
    RequestToken(final String token, final String tokenSecret, final OAuthSupport oauth) {
        super(token, tokenSecret);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oauth;
    }
    
    public String getAuthorizationURL() {
        return String.valueOf(this.conf.getOAuthAuthorizationURL()) + "?oauth_token=" + this.getToken();
    }
    
    public String getAuthenticationURL() {
        return String.valueOf(this.conf.getOAuthAuthenticationURL()) + "?oauth_token=" + this.getToken();
    }
}
