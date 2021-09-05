package twitter4j.conf;

import java.io.ObjectStreamException;
import java.lang.reflect.Field;
import twitter4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import twitter4j.HttpClientConfiguration;
import java.io.Serializable;

class ConfigurationBase implements Configuration, Serializable
{
    private static final long serialVersionUID = 6175546394599249696L;
    private boolean debug;
    private String user;
    private String password;
    private HttpClientConfiguration httpConf;
    private int httpStreamingReadTimeout;
    private int httpRetryCount;
    private int httpRetryIntervalSeconds;
    private String oAuthConsumerKey;
    private String oAuthConsumerSecret;
    private String oAuthAccessToken;
    private String oAuthAccessTokenSecret;
    private String oAuth2TokenType;
    private String oAuth2AccessToken;
    private String oAuth2Scope;
    private String oAuthRequestTokenURL;
    private String oAuthAuthorizationURL;
    private String oAuthAccessTokenURL;
    private String oAuthAuthenticationURL;
    private String oAuth2TokenURL;
    private String oAuth2InvalidateTokenURL;
    private String restBaseURL;
    private String streamBaseURL;
    private String userStreamBaseURL;
    private String siteStreamBaseURL;
    private String uploadBaseURL;
    private String dispatcherImpl;
    private int asyncNumThreads;
    private String loggerFactory;
    private long contributingTo;
    private boolean includeMyRetweetEnabled;
    private boolean includeEntitiesEnabled;
    private boolean trimUserEnabled;
    private boolean jsonStoreEnabled;
    private boolean mbeanEnabled;
    private boolean userStreamRepliesAllEnabled;
    private boolean userStreamWithFollowingsEnabled;
    private boolean stallWarningsEnabled;
    private boolean applicationOnlyAuthEnabled;
    private String mediaProvider;
    private String mediaProviderAPIKey;
    private Properties mediaProviderParameters;
    private boolean daemonEnabled;
    private static final List<ConfigurationBase> instances;
    
    static {
        instances = new ArrayList<ConfigurationBase>();
    }
    
    protected ConfigurationBase() {
        this.debug = false;
        this.user = null;
        this.password = null;
        this.httpStreamingReadTimeout = 40000;
        this.httpRetryCount = 0;
        this.httpRetryIntervalSeconds = 5;
        this.oAuthConsumerKey = null;
        this.oAuthConsumerSecret = null;
        this.oAuthAccessToken = null;
        this.oAuthAccessTokenSecret = null;
        this.oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
        this.oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
        this.oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
        this.oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
        this.oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
        this.oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";
        this.restBaseURL = "https://api.twitter.com/1.1/";
        this.streamBaseURL = "https://stream.twitter.com/1.1/";
        this.userStreamBaseURL = "https://userstream.twitter.com/1.1/";
        this.siteStreamBaseURL = "https://sitestream.twitter.com/1.1/";
        this.uploadBaseURL = "https://upload.twitter.com/1.1/";
        this.dispatcherImpl = "twitter4j.DispatcherImpl";
        this.asyncNumThreads = 1;
        this.loggerFactory = null;
        this.contributingTo = -1L;
        this.includeMyRetweetEnabled = true;
        this.includeEntitiesEnabled = true;
        this.trimUserEnabled = false;
        this.jsonStoreEnabled = false;
        this.mbeanEnabled = false;
        this.userStreamRepliesAllEnabled = false;
        this.userStreamWithFollowingsEnabled = true;
        this.stallWarningsEnabled = true;
        this.applicationOnlyAuthEnabled = false;
        this.mediaProvider = "TWITTER";
        this.mediaProviderAPIKey = null;
        this.mediaProviderParameters = null;
        this.daemonEnabled = true;
        this.httpConf = new MyHttpClientConfiguration(null, null, null, -1, 20000, 120000, false, true);
    }
    
    public void dumpConfiguration() {
        final Logger log = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            final Field[] fields = ConfigurationBase.class.getDeclaredFields();
            Field[] array;
            for (int length = (array = fields).length, i = 0; i < length; ++i) {
                final Field field = array[i];
                try {
                    final Object value = field.get(this);
                    String strValue = String.valueOf(value);
                    if (value != null && field.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                        strValue = String.valueOf(value).replaceAll(".", "*");
                    }
                    log.debug(String.valueOf(field.getName()) + ": " + strValue);
                }
                catch (IllegalAccessException ex) {}
            }
        }
    }
    
    @Override
    public final boolean isDebugEnabled() {
        return this.debug;
    }
    
    protected final void setDebug(final boolean debug) {
        this.debug = debug;
    }
    
    @Override
    public final String getUser() {
        return this.user;
    }
    
    protected final void setUser(final String user) {
        this.user = user;
    }
    
    @Override
    public final String getPassword() {
        return this.password;
    }
    
    @Override
    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
    }
    
    protected final void setPassword(final String password) {
        this.password = password;
    }
    
    protected final void setPrettyDebugEnabled(final boolean prettyDebug) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), prettyDebug, this.httpConf.isGZIPEnabled());
    }
    
    protected final void setGZIPEnabled(final boolean gzipEnabled) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), gzipEnabled);
    }
    
    protected final void setHttpProxyHost(final String proxyHost) {
        this.httpConf = new MyHttpClientConfiguration(proxyHost, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    protected final void setHttpProxyUser(final String proxyUser) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), proxyUser, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    protected final void setHttpProxyPassword(final String proxyPassword) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), proxyPassword, this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    protected final void setHttpProxyPort(final int proxyPort) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), proxyPort, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    protected final void setHttpConnectionTimeout(final int connectionTimeout) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), connectionTimeout, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    protected final void setHttpReadTimeout(final int readTimeout) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), readTimeout, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }
    
    @Override
    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }
    
    protected final void setHttpStreamingReadTimeout(final int httpStreamingReadTimeout) {
        this.httpStreamingReadTimeout = httpStreamingReadTimeout;
    }
    
    protected final void setHttpRetryCount(final int retryCount) {
        this.httpRetryCount = retryCount;
    }
    
    protected final void setHttpRetryIntervalSeconds(final int retryIntervalSeconds) {
        this.httpRetryIntervalSeconds = retryIntervalSeconds;
    }
    
    @Override
    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }
    
    protected final void setOAuthConsumerKey(final String oAuthConsumerKey) {
        this.oAuthConsumerKey = oAuthConsumerKey;
    }
    
    @Override
    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }
    
    protected final void setOAuthConsumerSecret(final String oAuthConsumerSecret) {
        this.oAuthConsumerSecret = oAuthConsumerSecret;
    }
    
    @Override
    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }
    
    protected final void setOAuthAccessToken(final String oAuthAccessToken) {
        this.oAuthAccessToken = oAuthAccessToken;
    }
    
    @Override
    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }
    
    protected final void setOAuthAccessTokenSecret(final String oAuthAccessTokenSecret) {
        this.oAuthAccessTokenSecret = oAuthAccessTokenSecret;
    }
    
    @Override
    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }
    
    protected final void setOAuth2TokenType(final String oAuth2TokenType) {
        this.oAuth2TokenType = oAuth2TokenType;
    }
    
    @Override
    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }
    
    @Override
    public String getOAuth2Scope() {
        return this.oAuth2Scope;
    }
    
    protected final void setOAuth2AccessToken(final String oAuth2AccessToken) {
        this.oAuth2AccessToken = oAuth2AccessToken;
    }
    
    protected final void setOAuth2Scope(final String oAuth2Scope) {
        this.oAuth2Scope = oAuth2Scope;
    }
    
    @Override
    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }
    
    protected final void setAsyncNumThreads(final int asyncNumThreads) {
        this.asyncNumThreads = asyncNumThreads;
    }
    
    @Override
    public final long getContributingTo() {
        return this.contributingTo;
    }
    
    protected final void setContributingTo(final long contributingTo) {
        this.contributingTo = contributingTo;
    }
    
    @Override
    public String getRestBaseURL() {
        return this.restBaseURL;
    }
    
    protected final void setRestBaseURL(final String restBaseURL) {
        this.restBaseURL = restBaseURL;
    }
    
    @Override
    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }
    
    protected final void setUploadBaseURL(final String uploadBaseURL) {
        this.uploadBaseURL = uploadBaseURL;
    }
    
    @Override
    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }
    
    protected final void setStreamBaseURL(final String streamBaseURL) {
        this.streamBaseURL = streamBaseURL;
    }
    
    @Override
    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }
    
    protected final void setUserStreamBaseURL(final String siteStreamBaseURL) {
        this.userStreamBaseURL = siteStreamBaseURL;
    }
    
    @Override
    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }
    
    protected final void setSiteStreamBaseURL(final String siteStreamBaseURL) {
        this.siteStreamBaseURL = siteStreamBaseURL;
    }
    
    @Override
    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }
    
    protected final void setOAuthRequestTokenURL(final String oAuthRequestTokenURL) {
        this.oAuthRequestTokenURL = oAuthRequestTokenURL;
    }
    
    @Override
    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }
    
    protected final void setOAuthAuthorizationURL(final String oAuthAuthorizationURL) {
        this.oAuthAuthorizationURL = oAuthAuthorizationURL;
    }
    
    @Override
    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }
    
    protected final void setOAuthAccessTokenURL(final String oAuthAccessTokenURL) {
        this.oAuthAccessTokenURL = oAuthAccessTokenURL;
    }
    
    @Override
    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }
    
    protected final void setOAuthAuthenticationURL(final String oAuthAuthenticationURL) {
        this.oAuthAuthenticationURL = oAuthAuthenticationURL;
    }
    
    @Override
    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }
    
    protected final void setOAuth2TokenURL(final String oAuth2TokenURL) {
        this.oAuth2TokenURL = oAuth2TokenURL;
    }
    
    @Override
    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }
    
    protected final void setOAuth2InvalidateTokenURL(final String oAuth2InvalidateTokenURL) {
        this.oAuth2InvalidateTokenURL = oAuth2InvalidateTokenURL;
    }
    
    @Override
    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }
    
    protected final void setDispatcherImpl(final String dispatcherImpl) {
        this.dispatcherImpl = dispatcherImpl;
    }
    
    @Override
    public String getLoggerFactory() {
        return this.loggerFactory;
    }
    
    @Override
    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }
    
    protected void setIncludeEntitiesEnabled(final boolean includeEntitiesEnabled) {
        this.includeEntitiesEnabled = includeEntitiesEnabled;
    }
    
    protected final void setLoggerFactory(final String loggerImpl) {
        this.loggerFactory = loggerImpl;
    }
    
    @Override
    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }
    
    public void setIncludeMyRetweetEnabled(final boolean enabled) {
        this.includeMyRetweetEnabled = enabled;
    }
    
    @Override
    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }
    
    @Override
    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }
    
    protected void setDaemonEnabled(final boolean daemonEnabled) {
        this.daemonEnabled = daemonEnabled;
    }
    
    public void setTrimUserEnabled(final boolean enabled) {
        this.trimUserEnabled = enabled;
    }
    
    @Override
    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }
    
    protected final void setJSONStoreEnabled(final boolean enabled) {
        this.jsonStoreEnabled = enabled;
    }
    
    @Override
    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }
    
    protected final void setMBeanEnabled(final boolean enabled) {
        this.mbeanEnabled = enabled;
    }
    
    @Override
    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }
    
    @Override
    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }
    
    protected final void setUserStreamRepliesAllEnabled(final boolean enabled) {
        this.userStreamRepliesAllEnabled = enabled;
    }
    
    protected final void setUserStreamWithFollowingsEnabled(final boolean enabled) {
        this.userStreamWithFollowingsEnabled = enabled;
    }
    
    @Override
    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }
    
    protected final void setStallWarningsEnabled(final boolean stallWarningsEnabled) {
        this.stallWarningsEnabled = stallWarningsEnabled;
    }
    
    @Override
    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }
    
    protected final void setApplicationOnlyAuthEnabled(final boolean applicationOnlyAuthEnabled) {
        this.applicationOnlyAuthEnabled = applicationOnlyAuthEnabled;
    }
    
    @Override
    public String getMediaProvider() {
        return this.mediaProvider;
    }
    
    protected final void setMediaProvider(final String mediaProvider) {
        this.mediaProvider = mediaProvider;
    }
    
    @Override
    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }
    
    protected final void setMediaProviderAPIKey(final String mediaProviderAPIKey) {
        this.mediaProviderAPIKey = mediaProviderAPIKey;
    }
    
    @Override
    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }
    
    protected final void setMediaProviderParameters(final Properties props) {
        this.mediaProviderParameters = props;
    }
    
    static String fixURL(final boolean useSSL, final String url) {
        if (url == null) {
            return null;
        }
        final int index = url.indexOf("://");
        if (-1 == index) {
            throw new IllegalArgumentException("url should contain '://'");
        }
        final String hostAndLater = url.substring(index + 3);
        if (useSSL) {
            return "https://" + hostAndLater;
        }
        return "http://" + hostAndLater;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ConfigurationBase that = (ConfigurationBase)o;
        if (this.applicationOnlyAuthEnabled != that.applicationOnlyAuthEnabled) {
            return false;
        }
        if (this.asyncNumThreads != that.asyncNumThreads) {
            return false;
        }
        if (this.contributingTo != that.contributingTo) {
            return false;
        }
        if (this.daemonEnabled != that.daemonEnabled) {
            return false;
        }
        if (this.debug != that.debug) {
            return false;
        }
        if (this.httpRetryCount != that.httpRetryCount) {
            return false;
        }
        if (this.httpRetryIntervalSeconds != that.httpRetryIntervalSeconds) {
            return false;
        }
        if (this.httpStreamingReadTimeout != that.httpStreamingReadTimeout) {
            return false;
        }
        if (this.includeEntitiesEnabled != that.includeEntitiesEnabled) {
            return false;
        }
        if (this.includeMyRetweetEnabled != that.includeMyRetweetEnabled) {
            return false;
        }
        if (this.jsonStoreEnabled != that.jsonStoreEnabled) {
            return false;
        }
        if (this.mbeanEnabled != that.mbeanEnabled) {
            return false;
        }
        if (this.stallWarningsEnabled != that.stallWarningsEnabled) {
            return false;
        }
        if (this.trimUserEnabled != that.trimUserEnabled) {
            return false;
        }
        if (this.userStreamRepliesAllEnabled != that.userStreamRepliesAllEnabled) {
            return false;
        }
        if (this.userStreamWithFollowingsEnabled != that.userStreamWithFollowingsEnabled) {
            return false;
        }
        Label_0271: {
            if (this.dispatcherImpl != null) {
                if (this.dispatcherImpl.equals(that.dispatcherImpl)) {
                    break Label_0271;
                }
            }
            else if (that.dispatcherImpl == null) {
                break Label_0271;
            }
            return false;
        }
        Label_0304: {
            if (this.httpConf != null) {
                if (this.httpConf.equals(that.httpConf)) {
                    break Label_0304;
                }
            }
            else if (that.httpConf == null) {
                break Label_0304;
            }
            return false;
        }
        Label_0337: {
            if (this.loggerFactory != null) {
                if (this.loggerFactory.equals(that.loggerFactory)) {
                    break Label_0337;
                }
            }
            else if (that.loggerFactory == null) {
                break Label_0337;
            }
            return false;
        }
        Label_0370: {
            if (this.mediaProvider != null) {
                if (this.mediaProvider.equals(that.mediaProvider)) {
                    break Label_0370;
                }
            }
            else if (that.mediaProvider == null) {
                break Label_0370;
            }
            return false;
        }
        Label_0403: {
            if (this.mediaProviderAPIKey != null) {
                if (this.mediaProviderAPIKey.equals(that.mediaProviderAPIKey)) {
                    break Label_0403;
                }
            }
            else if (that.mediaProviderAPIKey == null) {
                break Label_0403;
            }
            return false;
        }
        Label_0436: {
            if (this.mediaProviderParameters != null) {
                if (this.mediaProviderParameters.equals(that.mediaProviderParameters)) {
                    break Label_0436;
                }
            }
            else if (that.mediaProviderParameters == null) {
                break Label_0436;
            }
            return false;
        }
        Label_0469: {
            if (this.oAuth2AccessToken != null) {
                if (this.oAuth2AccessToken.equals(that.oAuth2AccessToken)) {
                    break Label_0469;
                }
            }
            else if (that.oAuth2AccessToken == null) {
                break Label_0469;
            }
            return false;
        }
        Label_0502: {
            if (this.oAuth2InvalidateTokenURL != null) {
                if (this.oAuth2InvalidateTokenURL.equals(that.oAuth2InvalidateTokenURL)) {
                    break Label_0502;
                }
            }
            else if (that.oAuth2InvalidateTokenURL == null) {
                break Label_0502;
            }
            return false;
        }
        Label_0535: {
            if (this.oAuth2TokenType != null) {
                if (this.oAuth2TokenType.equals(that.oAuth2TokenType)) {
                    break Label_0535;
                }
            }
            else if (that.oAuth2TokenType == null) {
                break Label_0535;
            }
            return false;
        }
        Label_0568: {
            if (this.oAuth2TokenURL != null) {
                if (this.oAuth2TokenURL.equals(that.oAuth2TokenURL)) {
                    break Label_0568;
                }
            }
            else if (that.oAuth2TokenURL == null) {
                break Label_0568;
            }
            return false;
        }
        Label_0601: {
            if (this.oAuth2Scope != null) {
                if (this.oAuth2Scope.equals(that.oAuth2Scope)) {
                    break Label_0601;
                }
            }
            else if (that.oAuth2Scope == null) {
                break Label_0601;
            }
            return false;
        }
        Label_0634: {
            if (this.oAuthAccessToken != null) {
                if (this.oAuthAccessToken.equals(that.oAuthAccessToken)) {
                    break Label_0634;
                }
            }
            else if (that.oAuthAccessToken == null) {
                break Label_0634;
            }
            return false;
        }
        Label_0667: {
            if (this.oAuthAccessTokenSecret != null) {
                if (this.oAuthAccessTokenSecret.equals(that.oAuthAccessTokenSecret)) {
                    break Label_0667;
                }
            }
            else if (that.oAuthAccessTokenSecret == null) {
                break Label_0667;
            }
            return false;
        }
        Label_0700: {
            if (this.oAuthAccessTokenURL != null) {
                if (this.oAuthAccessTokenURL.equals(that.oAuthAccessTokenURL)) {
                    break Label_0700;
                }
            }
            else if (that.oAuthAccessTokenURL == null) {
                break Label_0700;
            }
            return false;
        }
        Label_0733: {
            if (this.oAuthAuthenticationURL != null) {
                if (this.oAuthAuthenticationURL.equals(that.oAuthAuthenticationURL)) {
                    break Label_0733;
                }
            }
            else if (that.oAuthAuthenticationURL == null) {
                break Label_0733;
            }
            return false;
        }
        Label_0766: {
            if (this.oAuthAuthorizationURL != null) {
                if (this.oAuthAuthorizationURL.equals(that.oAuthAuthorizationURL)) {
                    break Label_0766;
                }
            }
            else if (that.oAuthAuthorizationURL == null) {
                break Label_0766;
            }
            return false;
        }
        Label_0799: {
            if (this.oAuthConsumerKey != null) {
                if (this.oAuthConsumerKey.equals(that.oAuthConsumerKey)) {
                    break Label_0799;
                }
            }
            else if (that.oAuthConsumerKey == null) {
                break Label_0799;
            }
            return false;
        }
        Label_0832: {
            if (this.oAuthConsumerSecret != null) {
                if (this.oAuthConsumerSecret.equals(that.oAuthConsumerSecret)) {
                    break Label_0832;
                }
            }
            else if (that.oAuthConsumerSecret == null) {
                break Label_0832;
            }
            return false;
        }
        Label_0865: {
            if (this.oAuthRequestTokenURL != null) {
                if (this.oAuthRequestTokenURL.equals(that.oAuthRequestTokenURL)) {
                    break Label_0865;
                }
            }
            else if (that.oAuthRequestTokenURL == null) {
                break Label_0865;
            }
            return false;
        }
        Label_0898: {
            if (this.password != null) {
                if (this.password.equals(that.password)) {
                    break Label_0898;
                }
            }
            else if (that.password == null) {
                break Label_0898;
            }
            return false;
        }
        Label_0931: {
            if (this.restBaseURL != null) {
                if (this.restBaseURL.equals(that.restBaseURL)) {
                    break Label_0931;
                }
            }
            else if (that.restBaseURL == null) {
                break Label_0931;
            }
            return false;
        }
        Label_0964: {
            if (this.uploadBaseURL != null) {
                if (this.uploadBaseURL.equals(that.uploadBaseURL)) {
                    break Label_0964;
                }
            }
            else if (that.uploadBaseURL == null) {
                break Label_0964;
            }
            return false;
        }
        Label_0997: {
            if (this.siteStreamBaseURL != null) {
                if (this.siteStreamBaseURL.equals(that.siteStreamBaseURL)) {
                    break Label_0997;
                }
            }
            else if (that.siteStreamBaseURL == null) {
                break Label_0997;
            }
            return false;
        }
        Label_1030: {
            if (this.streamBaseURL != null) {
                if (this.streamBaseURL.equals(that.streamBaseURL)) {
                    break Label_1030;
                }
            }
            else if (that.streamBaseURL == null) {
                break Label_1030;
            }
            return false;
        }
        Label_1063: {
            if (this.user != null) {
                if (this.user.equals(that.user)) {
                    break Label_1063;
                }
            }
            else if (that.user == null) {
                break Label_1063;
            }
            return false;
        }
        if (this.userStreamBaseURL != null) {
            if (this.userStreamBaseURL.equals(that.userStreamBaseURL)) {
                return true;
            }
        }
        else if (that.userStreamBaseURL == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = this.debug ? 1 : 0;
        result = 31 * result + ((this.user != null) ? this.user.hashCode() : 0);
        result = 31 * result + ((this.password != null) ? this.password.hashCode() : 0);
        result = 31 * result + ((this.httpConf != null) ? this.httpConf.hashCode() : 0);
        result = 31 * result + this.httpStreamingReadTimeout;
        result = 31 * result + this.httpRetryCount;
        result = 31 * result + this.httpRetryIntervalSeconds;
        result = 31 * result + ((this.oAuthConsumerKey != null) ? this.oAuthConsumerKey.hashCode() : 0);
        result = 31 * result + ((this.oAuthConsumerSecret != null) ? this.oAuthConsumerSecret.hashCode() : 0);
        result = 31 * result + ((this.oAuthAccessToken != null) ? this.oAuthAccessToken.hashCode() : 0);
        result = 31 * result + ((this.oAuthAccessTokenSecret != null) ? this.oAuthAccessTokenSecret.hashCode() : 0);
        result = 31 * result + ((this.oAuth2TokenType != null) ? this.oAuth2TokenType.hashCode() : 0);
        result = 31 * result + ((this.oAuth2AccessToken != null) ? this.oAuth2AccessToken.hashCode() : 0);
        result = 31 * result + ((this.oAuth2Scope != null) ? this.oAuth2Scope.hashCode() : 0);
        result = 31 * result + ((this.oAuthRequestTokenURL != null) ? this.oAuthRequestTokenURL.hashCode() : 0);
        result = 31 * result + ((this.oAuthAuthorizationURL != null) ? this.oAuthAuthorizationURL.hashCode() : 0);
        result = 31 * result + ((this.oAuthAccessTokenURL != null) ? this.oAuthAccessTokenURL.hashCode() : 0);
        result = 31 * result + ((this.oAuthAuthenticationURL != null) ? this.oAuthAuthenticationURL.hashCode() : 0);
        result = 31 * result + ((this.oAuth2TokenURL != null) ? this.oAuth2TokenURL.hashCode() : 0);
        result = 31 * result + ((this.oAuth2InvalidateTokenURL != null) ? this.oAuth2InvalidateTokenURL.hashCode() : 0);
        result = 31 * result + ((this.restBaseURL != null) ? this.restBaseURL.hashCode() : 0);
        result = 31 * result + ((this.uploadBaseURL != null) ? this.uploadBaseURL.hashCode() : 0);
        result = 31 * result + ((this.streamBaseURL != null) ? this.streamBaseURL.hashCode() : 0);
        result = 31 * result + ((this.userStreamBaseURL != null) ? this.userStreamBaseURL.hashCode() : 0);
        result = 31 * result + ((this.siteStreamBaseURL != null) ? this.siteStreamBaseURL.hashCode() : 0);
        result = 31 * result + ((this.dispatcherImpl != null) ? this.dispatcherImpl.hashCode() : 0);
        result = 31 * result + this.asyncNumThreads;
        result = 31 * result + ((this.loggerFactory != null) ? this.loggerFactory.hashCode() : 0);
        result = 31 * result + (int)(this.contributingTo ^ this.contributingTo >>> 32);
        result = 31 * result + (this.includeMyRetweetEnabled ? 1 : 0);
        result = 31 * result + (this.includeEntitiesEnabled ? 1 : 0);
        result = 31 * result + (this.trimUserEnabled ? 1 : 0);
        result = 31 * result + (this.jsonStoreEnabled ? 1 : 0);
        result = 31 * result + (this.mbeanEnabled ? 1 : 0);
        result = 31 * result + (this.userStreamRepliesAllEnabled ? 1 : 0);
        result = 31 * result + (this.userStreamWithFollowingsEnabled ? 1 : 0);
        result = 31 * result + (this.stallWarningsEnabled ? 1 : 0);
        result = 31 * result + (this.applicationOnlyAuthEnabled ? 1 : 0);
        result = 31 * result + ((this.mediaProvider != null) ? this.mediaProvider.hashCode() : 0);
        result = 31 * result + ((this.mediaProviderAPIKey != null) ? this.mediaProviderAPIKey.hashCode() : 0);
        result = 31 * result + ((this.mediaProviderParameters != null) ? this.mediaProviderParameters.hashCode() : 0);
        result = 31 * result + (this.daemonEnabled ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "ConfigurationBase{debug=" + this.debug + ", user='" + this.user + '\'' + ", password='" + this.password + '\'' + ", httpConf=" + this.httpConf + ", httpStreamingReadTimeout=" + this.httpStreamingReadTimeout + ", httpRetryCount=" + this.httpRetryCount + ", httpRetryIntervalSeconds=" + this.httpRetryIntervalSeconds + ", oAuthConsumerKey='" + this.oAuthConsumerKey + '\'' + ", oAuthConsumerSecret='" + this.oAuthConsumerSecret + '\'' + ", oAuthAccessToken='" + this.oAuthAccessToken + '\'' + ", oAuthAccessTokenSecret='" + this.oAuthAccessTokenSecret + '\'' + ", oAuth2TokenType='" + this.oAuth2TokenType + '\'' + ", oAuth2AccessToken='" + this.oAuth2AccessToken + '\'' + ", oAuth2Scope='" + this.oAuth2Scope + '\'' + ", oAuthRequestTokenURL='" + this.oAuthRequestTokenURL + '\'' + ", oAuthAuthorizationURL='" + this.oAuthAuthorizationURL + '\'' + ", oAuthAccessTokenURL='" + this.oAuthAccessTokenURL + '\'' + ", oAuthAuthenticationURL='" + this.oAuthAuthenticationURL + '\'' + ", oAuth2TokenURL='" + this.oAuth2TokenURL + '\'' + ", oAuth2InvalidateTokenURL='" + this.oAuth2InvalidateTokenURL + '\'' + ", restBaseURL='" + this.restBaseURL + '\'' + ", uploadBaseURL='" + this.uploadBaseURL + '\'' + ", streamBaseURL='" + this.streamBaseURL + '\'' + ", userStreamBaseURL='" + this.userStreamBaseURL + '\'' + ", siteStreamBaseURL='" + this.siteStreamBaseURL + '\'' + ", dispatcherImpl='" + this.dispatcherImpl + '\'' + ", asyncNumThreads=" + this.asyncNumThreads + ", loggerFactory='" + this.loggerFactory + '\'' + ", contributingTo=" + this.contributingTo + ", includeMyRetweetEnabled=" + this.includeMyRetweetEnabled + ", includeEntitiesEnabled=" + this.includeEntitiesEnabled + ", trimUserEnabled=" + this.trimUserEnabled + ", jsonStoreEnabled=" + this.jsonStoreEnabled + ", mbeanEnabled=" + this.mbeanEnabled + ", userStreamRepliesAllEnabled=" + this.userStreamRepliesAllEnabled + ", userStreamWithFollowingsEnabled=" + this.userStreamWithFollowingsEnabled + ", stallWarningsEnabled=" + this.stallWarningsEnabled + ", applicationOnlyAuthEnabled=" + this.applicationOnlyAuthEnabled + ", mediaProvider='" + this.mediaProvider + '\'' + ", mediaProviderAPIKey='" + this.mediaProviderAPIKey + '\'' + ", mediaProviderParameters=" + this.mediaProviderParameters + ", daemonEnabled=" + this.daemonEnabled + '}';
    }
    
    private static void cacheInstance(final ConfigurationBase conf) {
        if (!ConfigurationBase.instances.contains(conf)) {
            ConfigurationBase.instances.add(conf);
        }
    }
    
    protected void cacheInstance() {
        cacheInstance(this);
    }
    
    private static ConfigurationBase getInstance(final ConfigurationBase configurationBase) {
        final int index;
        if ((index = ConfigurationBase.instances.indexOf(configurationBase)) == -1) {
            ConfigurationBase.instances.add(configurationBase);
            return configurationBase;
        }
        return ConfigurationBase.instances.get(index);
    }
    
    protected Object readResolve() throws ObjectStreamException {
        return getInstance(this);
    }
    
    class MyHttpClientConfiguration implements HttpClientConfiguration, Serializable
    {
        private static final long serialVersionUID = 8226866124868861058L;
        private String httpProxyHost;
        private String httpProxyUser;
        private String httpProxyPassword;
        private int httpProxyPort;
        private int httpConnectionTimeout;
        private int httpReadTimeout;
        private boolean prettyDebug;
        private boolean gzipEnabled;
        
        MyHttpClientConfiguration(final String httpProxyHost, final String httpProxyUser, final String httpProxyPassword, final int httpProxyPort, final int httpConnectionTimeout, final int httpReadTimeout, final boolean prettyDebug, final boolean gzipEnabled) {
            this.httpProxyHost = null;
            this.httpProxyUser = null;
            this.httpProxyPassword = null;
            this.httpProxyPort = -1;
            this.httpConnectionTimeout = 20000;
            this.httpReadTimeout = 120000;
            this.prettyDebug = false;
            this.gzipEnabled = true;
            this.httpProxyHost = httpProxyHost;
            this.httpProxyUser = httpProxyUser;
            this.httpProxyPassword = httpProxyPassword;
            this.httpProxyPort = httpProxyPort;
            this.httpConnectionTimeout = httpConnectionTimeout;
            this.httpReadTimeout = httpReadTimeout;
            this.prettyDebug = prettyDebug;
            this.gzipEnabled = gzipEnabled;
        }
        
        @Override
        public String getHttpProxyHost() {
            return this.httpProxyHost;
        }
        
        @Override
        public int getHttpProxyPort() {
            return this.httpProxyPort;
        }
        
        @Override
        public String getHttpProxyUser() {
            return this.httpProxyUser;
        }
        
        @Override
        public String getHttpProxyPassword() {
            return this.httpProxyPassword;
        }
        
        @Override
        public int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }
        
        @Override
        public int getHttpReadTimeout() {
            return this.httpReadTimeout;
        }
        
        @Override
        public int getHttpRetryCount() {
            return ConfigurationBase.this.httpRetryCount;
        }
        
        @Override
        public int getHttpRetryIntervalSeconds() {
            return ConfigurationBase.this.httpRetryIntervalSeconds;
        }
        
        @Override
        public boolean isPrettyDebugEnabled() {
            return this.prettyDebug;
        }
        
        @Override
        public boolean isGZIPEnabled() {
            return this.gzipEnabled;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final MyHttpClientConfiguration that = (MyHttpClientConfiguration)o;
            if (this.gzipEnabled != that.gzipEnabled) {
                return false;
            }
            if (this.httpConnectionTimeout != that.httpConnectionTimeout) {
                return false;
            }
            if (this.httpProxyPort != that.httpProxyPort) {
                return false;
            }
            if (this.httpReadTimeout != that.httpReadTimeout) {
                return false;
            }
            if (this.prettyDebug != that.prettyDebug) {
                return false;
            }
            Label_0127: {
                if (this.httpProxyHost != null) {
                    if (this.httpProxyHost.equals(that.httpProxyHost)) {
                        break Label_0127;
                    }
                }
                else if (that.httpProxyHost == null) {
                    break Label_0127;
                }
                return false;
            }
            Label_0160: {
                if (this.httpProxyPassword != null) {
                    if (this.httpProxyPassword.equals(that.httpProxyPassword)) {
                        break Label_0160;
                    }
                }
                else if (that.httpProxyPassword == null) {
                    break Label_0160;
                }
                return false;
            }
            if (this.httpProxyUser != null) {
                if (this.httpProxyUser.equals(that.httpProxyUser)) {
                    return true;
                }
            }
            else if (that.httpProxyUser == null) {
                return true;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            int result = (this.httpProxyHost != null) ? this.httpProxyHost.hashCode() : 0;
            result = 31 * result + ((this.httpProxyUser != null) ? this.httpProxyUser.hashCode() : 0);
            result = 31 * result + ((this.httpProxyPassword != null) ? this.httpProxyPassword.hashCode() : 0);
            result = 31 * result + this.httpProxyPort;
            result = 31 * result + this.httpConnectionTimeout;
            result = 31 * result + this.httpReadTimeout;
            result = 31 * result + (this.prettyDebug ? 1 : 0);
            result = 31 * result + (this.gzipEnabled ? 1 : 0);
            return result;
        }
        
        @Override
        public String toString() {
            return "MyHttpClientConfiguration{httpProxyHost='" + this.httpProxyHost + '\'' + ", httpProxyUser='" + this.httpProxyUser + '\'' + ", httpProxyPassword='" + this.httpProxyPassword + '\'' + ", httpProxyPort=" + this.httpProxyPort + ", httpConnectionTimeout=" + this.httpConnectionTimeout + ", httpReadTimeout=" + this.httpReadTimeout + ", prettyDebug=" + this.prettyDebug + ", gzipEnabled=" + this.gzipEnabled + '}';
        }
    }
}
