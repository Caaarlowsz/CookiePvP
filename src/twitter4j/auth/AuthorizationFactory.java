package twitter4j.auth;

import twitter4j.conf.Configuration;

public final class AuthorizationFactory {
	public static Authorization getInstance(final Configuration conf) {
		Authorization auth = null;
		final String consumerKey = conf.getOAuthConsumerKey();
		final String consumerSecret = conf.getOAuthConsumerSecret();
		if (consumerKey != null && consumerSecret != null) {
			if (conf.isApplicationOnlyAuthEnabled()) {
				final OAuth2Authorization oauth2 = new OAuth2Authorization(conf);
				final String tokenType = conf.getOAuth2TokenType();
				final String accessToken = conf.getOAuth2AccessToken();
				if (tokenType != null && accessToken != null) {
					oauth2.setOAuth2Token(new OAuth2Token(tokenType, accessToken));
				}
				auth = oauth2;
			} else {
				final OAuthAuthorization oauth3 = new OAuthAuthorization(conf);
				final String accessToken2 = conf.getOAuthAccessToken();
				final String accessTokenSecret = conf.getOAuthAccessTokenSecret();
				if (accessToken2 != null && accessTokenSecret != null) {
					oauth3.setOAuthAccessToken(new AccessToken(accessToken2, accessTokenSecret));
				}
				auth = oauth3;
			}
		} else {
			final String screenName = conf.getUser();
			final String password = conf.getPassword();
			if (screenName != null && password != null) {
				auth = new BasicAuthorization(screenName, password);
			}
		}
		if (auth == null) {
			auth = NullAuthorization.getInstance();
		}
		return auth;
	}
}
