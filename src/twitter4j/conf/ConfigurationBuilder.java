package twitter4j.conf;

import java.util.Properties;

public final class ConfigurationBuilder {
	private ConfigurationBase configurationBean;

	public ConfigurationBuilder() {
		this.configurationBean = new PropertyConfiguration();
	}

	public ConfigurationBuilder setPrettyDebugEnabled(final boolean prettyDebugEnabled) {
		this.checkNotBuilt();
		this.configurationBean.setPrettyDebugEnabled(prettyDebugEnabled);
		return this;
	}

	public ConfigurationBuilder setGZIPEnabled(final boolean gzipEnabled) {
		this.checkNotBuilt();
		this.configurationBean.setGZIPEnabled(gzipEnabled);
		return this;
	}

	public ConfigurationBuilder setDebugEnabled(final boolean debugEnabled) {
		this.checkNotBuilt();
		this.configurationBean.setDebug(debugEnabled);
		return this;
	}

	public ConfigurationBuilder setApplicationOnlyAuthEnabled(final boolean applicationOnlyAuthEnabled) {
		this.checkNotBuilt();
		this.configurationBean.setApplicationOnlyAuthEnabled(applicationOnlyAuthEnabled);
		return this;
	}

	public ConfigurationBuilder setUser(final String user) {
		this.checkNotBuilt();
		this.configurationBean.setUser(user);
		return this;
	}

	public ConfigurationBuilder setPassword(final String password) {
		this.checkNotBuilt();
		this.configurationBean.setPassword(password);
		return this;
	}

	public ConfigurationBuilder setHttpProxyHost(final String httpProxyHost) {
		this.checkNotBuilt();
		this.configurationBean.setHttpProxyHost(httpProxyHost);
		return this;
	}

	public ConfigurationBuilder setHttpProxyUser(final String httpProxyUser) {
		this.checkNotBuilt();
		this.configurationBean.setHttpProxyUser(httpProxyUser);
		return this;
	}

	public ConfigurationBuilder setHttpProxyPassword(final String httpProxyPassword) {
		this.checkNotBuilt();
		this.configurationBean.setHttpProxyPassword(httpProxyPassword);
		return this;
	}

	public ConfigurationBuilder setHttpProxyPort(final int httpProxyPort) {
		this.checkNotBuilt();
		this.configurationBean.setHttpProxyPort(httpProxyPort);
		return this;
	}

	public ConfigurationBuilder setHttpConnectionTimeout(final int httpConnectionTimeout) {
		this.checkNotBuilt();
		this.configurationBean.setHttpConnectionTimeout(httpConnectionTimeout);
		return this;
	}

	public ConfigurationBuilder setHttpReadTimeout(final int httpReadTimeout) {
		this.checkNotBuilt();
		this.configurationBean.setHttpReadTimeout(httpReadTimeout);
		return this;
	}

	public ConfigurationBuilder setHttpStreamingReadTimeout(final int httpStreamingReadTimeout) {
		this.checkNotBuilt();
		this.configurationBean.setHttpStreamingReadTimeout(httpStreamingReadTimeout);
		return this;
	}

	public ConfigurationBuilder setHttpRetryCount(final int httpRetryCount) {
		this.checkNotBuilt();
		this.configurationBean.setHttpRetryCount(httpRetryCount);
		return this;
	}

	public ConfigurationBuilder setHttpRetryIntervalSeconds(final int httpRetryIntervalSeconds) {
		this.checkNotBuilt();
		this.configurationBean.setHttpRetryIntervalSeconds(httpRetryIntervalSeconds);
		return this;
	}

	public ConfigurationBuilder setOAuthConsumerKey(final String oAuthConsumerKey) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthConsumerKey(oAuthConsumerKey);
		return this;
	}

	public ConfigurationBuilder setOAuthConsumerSecret(final String oAuthConsumerSecret) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthConsumerSecret(oAuthConsumerSecret);
		return this;
	}

	public ConfigurationBuilder setOAuthAccessToken(final String oAuthAccessToken) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthAccessToken(oAuthAccessToken);
		return this;
	}

	public ConfigurationBuilder setOAuthAccessTokenSecret(final String oAuthAccessTokenSecret) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
		return this;
	}

	public ConfigurationBuilder setOAuth2TokenType(final String oAuth2TokenType) {
		this.checkNotBuilt();
		this.configurationBean.setOAuth2TokenType(oAuth2TokenType);
		return this;
	}

	public ConfigurationBuilder setOAuth2AccessToken(final String oAuth2AccessToken) {
		this.checkNotBuilt();
		this.configurationBean.setOAuth2AccessToken(oAuth2AccessToken);
		return this;
	}

	public ConfigurationBuilder setOAuth2Scope(final String oAuth2Scope) {
		this.checkNotBuilt();
		this.configurationBean.setOAuth2Scope(oAuth2Scope);
		return this;
	}

	public ConfigurationBuilder setOAuthRequestTokenURL(final String oAuthRequestTokenURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthRequestTokenURL(oAuthRequestTokenURL);
		return this;
	}

	public ConfigurationBuilder setOAuthAuthorizationURL(final String oAuthAuthorizationURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthAuthorizationURL(oAuthAuthorizationURL);
		return this;
	}

	public ConfigurationBuilder setOAuthAccessTokenURL(final String oAuthAccessTokenURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthAccessTokenURL(oAuthAccessTokenURL);
		return this;
	}

	public ConfigurationBuilder setOAuthAuthenticationURL(final String oAuthAuthenticationURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuthAuthenticationURL(oAuthAuthenticationURL);
		return this;
	}

	public ConfigurationBuilder setOAuth2TokenURL(final String oAuth2TokenURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuth2TokenURL(oAuth2TokenURL);
		return this;
	}

	public ConfigurationBuilder setOAuth2InvalidateTokenURL(final String invalidateTokenURL) {
		this.checkNotBuilt();
		this.configurationBean.setOAuth2InvalidateTokenURL(invalidateTokenURL);
		return this;
	}

	public ConfigurationBuilder setRestBaseURL(final String restBaseURL) {
		this.checkNotBuilt();
		this.configurationBean.setRestBaseURL(restBaseURL);
		return this;
	}

	public ConfigurationBuilder setStreamBaseURL(final String streamBaseURL) {
		this.checkNotBuilt();
		this.configurationBean.setStreamBaseURL(streamBaseURL);
		return this;
	}

	public ConfigurationBuilder setUserStreamBaseURL(final String userStreamBaseURL) {
		this.checkNotBuilt();
		this.configurationBean.setUserStreamBaseURL(userStreamBaseURL);
		return this;
	}

	public ConfigurationBuilder setSiteStreamBaseURL(final String siteStreamBaseURL) {
		this.checkNotBuilt();
		this.configurationBean.setSiteStreamBaseURL(siteStreamBaseURL);
		return this;
	}

	public ConfigurationBuilder setAsyncNumThreads(final int asyncNumThreads) {
		this.checkNotBuilt();
		this.configurationBean.setAsyncNumThreads(asyncNumThreads);
		return this;
	}

	public ConfigurationBuilder setDaemonEnabled(final boolean daemonEnabled) {
		this.checkNotBuilt();
		this.configurationBean.setDaemonEnabled(daemonEnabled);
		return this;
	}

	public ConfigurationBuilder setContributingTo(final long contributingTo) {
		this.checkNotBuilt();
		this.configurationBean.setContributingTo(contributingTo);
		return this;
	}

	public ConfigurationBuilder setDispatcherImpl(final String dispatcherImpl) {
		this.checkNotBuilt();
		this.configurationBean.setDispatcherImpl(dispatcherImpl);
		return this;
	}

	public ConfigurationBuilder setTrimUserEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setTrimUserEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setIncludeMyRetweetEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setIncludeMyRetweetEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setIncludeEntitiesEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setIncludeEntitiesEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setJSONStoreEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setJSONStoreEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setMBeanEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setMBeanEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setUserStreamRepliesAllEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setUserStreamRepliesAllEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setUserStreamWithFollowingsEnabled(final boolean enabled) {
		this.checkNotBuilt();
		this.configurationBean.setUserStreamWithFollowingsEnabled(enabled);
		return this;
	}

	public ConfigurationBuilder setMediaProvider(final String mediaProvider) {
		this.checkNotBuilt();
		this.configurationBean.setMediaProvider(mediaProvider);
		return this;
	}

	public ConfigurationBuilder setMediaProviderAPIKey(final String mediaProviderAPIKey) {
		this.checkNotBuilt();
		this.configurationBean.setMediaProviderAPIKey(mediaProviderAPIKey);
		return this;
	}

	public ConfigurationBuilder setMediaProviderParameters(final Properties props) {
		this.checkNotBuilt();
		this.configurationBean.setMediaProviderParameters(props);
		return this;
	}

	public Configuration build() {
		this.checkNotBuilt();
		this.configurationBean.cacheInstance();
		try {
			return this.configurationBean;
		} finally {
			this.configurationBean = null;
		}
	}

	private void checkNotBuilt() {
		if (this.configurationBean == null) {
			throw new IllegalStateException("Cannot use this builder any longer, build() has already been called");
		}
	}
}
