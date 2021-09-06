package twitter4j.auth;

import twitter4j.TwitterException;

public interface OAuthSupport {
	void setOAuthConsumer(final String p0, final String p1);

	RequestToken getOAuthRequestToken() throws TwitterException;

	RequestToken getOAuthRequestToken(final String p0) throws TwitterException;

	RequestToken getOAuthRequestToken(final String p0, final String p1) throws TwitterException;

	RequestToken getOAuthRequestToken(final String p0, final String p1, final String p2) throws TwitterException;

	AccessToken getOAuthAccessToken() throws TwitterException;

	AccessToken getOAuthAccessToken(final String p0) throws TwitterException;

	AccessToken getOAuthAccessToken(final RequestToken p0) throws TwitterException;

	AccessToken getOAuthAccessToken(final RequestToken p0, final String p1) throws TwitterException;

	AccessToken getOAuthAccessToken(final String p0, final String p1) throws TwitterException;

	void setOAuthAccessToken(final AccessToken p0);
}
