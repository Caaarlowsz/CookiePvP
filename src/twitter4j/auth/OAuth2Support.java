package twitter4j.auth;

import twitter4j.TwitterException;

public interface OAuth2Support {
	void setOAuthConsumer(final String p0, final String p1);

	OAuth2Token getOAuth2Token() throws TwitterException;

	void setOAuth2Token(final OAuth2Token p0);

	void invalidateOAuth2Token() throws TwitterException;
}
