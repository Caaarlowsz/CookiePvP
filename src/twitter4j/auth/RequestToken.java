package twitter4j.auth;

import java.io.Serializable;

import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class RequestToken extends OAuthToken implements Serializable {
	private static final long serialVersionUID = -8806439091674811734L;
	private final Configuration conf;

	RequestToken(final HttpResponse res, final OAuthSupport oauth) throws TwitterException {
		super(res);
		this.conf = ConfigurationContext.getInstance();
	}

	public RequestToken(final String token, final String tokenSecret) {
		super(token, tokenSecret);
		this.conf = ConfigurationContext.getInstance();
	}

	RequestToken(final String token, final String tokenSecret, final OAuthSupport oauth) {
		super(token, tokenSecret);
		this.conf = ConfigurationContext.getInstance();
	}

	public String getAuthorizationURL() {
		return String.valueOf(this.conf.getOAuthAuthorizationURL()) + "?oauth_token=" + this.getToken();
	}

	public String getAuthenticationURL() {
		return String.valueOf(this.conf.getOAuthAuthenticationURL()) + "?oauth_token=" + this.getToken();
	}
}
