package twitter4j.conf;

import java.util.Hashtable;
import twitter4j.HttpClientConfiguration;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;
import java.io.InputStream;
import java.io.Serializable;

public final class PropertyConfiguration extends ConfigurationBase implements Serializable
{
    private static final String DEBUG = "debug";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
    private static final String HTTP_GZIP = "http.gzip";
    private static final String HTTP_PROXY_HOST = "http.proxyHost";
    private static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
    private static final String HTTP_PROXY_USER = "http.proxyUser";
    private static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    private static final String HTTP_PROXY_PORT = "http.proxyPort";
    private static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
    private static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
    private static final String HTTP_READ_TIMEOUT = "http.readTimeout";
    private static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
    private static final String HTTP_RETRY_COUNT = "http.retryCount";
    private static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
    private static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
    private static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
    private static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
    private static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
    private static final String OAUTH2_TOKEN_TYPE = "oauth2.tokenType";
    private static final String OAUTH2_ACCESS_TOKEN = "oauth2.accessToken";
    private static final String OAUTH2_SCOPE = "oauth2.scope";
    private static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
    private static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
    private static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
    private static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
    private static final String OAUTH2_TOKEN_URL = "oauth2.tokenURL";
    private static final String OAUTH2_INVALIDATE_TOKEN_URL = "oauth2.invalidateTokenURL";
    private static final String REST_BASE_URL = "restBaseURL";
    private static final String STREAM_BASE_URL = "streamBaseURL";
    private static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
    private static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
    private static final String ASYNC_NUM_THREADS = "async.numThreads";
    private static final String ASYNC_DAEMON_ENABLED = "async.daemonEnabled";
    private static final String CONTRIBUTING_TO = "contributingTo";
    private static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
    private static final String INCLUDE_MY_RETWEET = "includeMyRetweet";
    private static final String INCLUDE_ENTITIES = "includeEntities";
    private static final String LOGGER_FACTORY = "loggerFactory";
    private static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
    private static final String MBEAN_ENABLED = "mbeanEnabled";
    private static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
    private static final String STREAM_USER_WITH_FOLLOWINGS = "stream.user.withFollowings";
    private static final String STREAM_STALL_WARNINGS_ENABLED = "stream.enableStallWarnings";
    private static final String APPLICATION_ONLY_AUTH_ENABLED = "enableApplicationOnlyAuth";
    private static final String MEDIA_PROVIDER = "media.provider";
    private static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
    private static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
    private static final long serialVersionUID = -7262615247923693252L;
    private String OAuth2Scope;
    
    public PropertyConfiguration(final InputStream is) {
        final Properties props = new Properties();
        this.loadProperties(props, is);
        this.setFieldsWithTreePath(props, "/");
    }
    
    public PropertyConfiguration(final Properties props) {
        this(props, "/");
    }
    
    public PropertyConfiguration(final Properties props, final String treePath) {
        this.setFieldsWithTreePath(props, treePath);
    }
    
    PropertyConfiguration(final String treePath) {
        Properties props;
        try {
            props = (Properties)System.getProperties().clone();
            try {
                final Map<String, String> envMap = System.getenv();
                for (final String key : envMap.keySet()) {
                    props.setProperty(key, envMap.get(key));
                }
            }
            catch (SecurityException ex) {}
            this.normalize(props);
        }
        catch (SecurityException ignore) {
            props = new Properties();
        }
        final String TWITTER4J_PROPERTIES = "twitter4j.properties";
        this.loadProperties(props, "." + File.separatorChar + "twitter4j.properties");
        this.loadProperties(props, Configuration.class.getResourceAsStream("/twitter4j.properties"));
        this.loadProperties(props, Configuration.class.getResourceAsStream("/WEB-INF/twitter4j.properties"));
        try {
            this.loadProperties(props, new FileInputStream("WEB-INF/twitter4j.properties"));
        }
        catch (SecurityException ex2) {}
        catch (FileNotFoundException ex3) {}
        this.setFieldsWithTreePath(props, treePath);
    }
    
    PropertyConfiguration() {
        this("/");
    }
    
    private boolean notNull(final Properties props, final String prefix, final String name) {
        return props.getProperty(String.valueOf(prefix) + name) != null;
    }
    
    private boolean loadProperties(final Properties props, final String path) {
        FileInputStream fis = null;
        try {
            final File file = new File(path);
            if (file.exists() && file.isFile()) {
                fis = new FileInputStream(file);
                props.load(fis);
                this.normalize(props);
                return true;
            }
        }
        catch (Exception ex) {}
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }
            catch (IOException ex2) {}
        }
        try {
            if (fis != null) {
                fis.close();
            }
        }
        catch (IOException ex3) {}
        return false;
    }
    
    private boolean loadProperties(final Properties props, final InputStream is) {
        try {
            props.load(is);
            this.normalize(props);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    private void normalize(final Properties props) {
        final ArrayList<String> toBeNormalized = new ArrayList<String>(10);
        for (final Object key : ((Hashtable<Object, V>)props).keySet()) {
            final String keyStr = (String)key;
            if (-1 != keyStr.indexOf("twitter4j.")) {
                toBeNormalized.add(keyStr);
            }
        }
        for (final String keyStr2 : toBeNormalized) {
            final String property = props.getProperty(keyStr2);
            final int index = keyStr2.indexOf("twitter4j.");
            final String newKey = String.valueOf(keyStr2.substring(0, index)) + keyStr2.substring(index + 10);
            props.setProperty(newKey, property);
        }
    }
    
    private void setFieldsWithTreePath(final Properties props, final String treePath) {
        this.setFieldsWithPrefix(props, "");
        final String[] splitArray = treePath.split("/");
        String prefix = null;
        String[] array;
        for (int length = (array = splitArray).length, i = 0; i < length; ++i) {
            final String split = array[i];
            if (!"".equals(split)) {
                if (prefix == null) {
                    prefix = String.valueOf(split) + ".";
                }
                else {
                    prefix = String.valueOf(prefix) + split + ".";
                }
                this.setFieldsWithPrefix(props, prefix);
            }
        }
    }
    
    private void setFieldsWithPrefix(final Properties props, final String prefix) {
        if (this.notNull(props, prefix, "debug")) {
            this.setDebug(this.getBoolean(props, prefix, "debug"));
        }
        if (this.notNull(props, prefix, "user")) {
            this.setUser(this.getString(props, prefix, "user"));
        }
        if (this.notNull(props, prefix, "password")) {
            this.setPassword(this.getString(props, prefix, "password"));
        }
        if (this.notNull(props, prefix, "http.prettyDebug")) {
            this.setPrettyDebugEnabled(this.getBoolean(props, prefix, "http.prettyDebug"));
        }
        if (this.notNull(props, prefix, "http.gzip")) {
            this.setGZIPEnabled(this.getBoolean(props, prefix, "http.gzip"));
        }
        if (this.notNull(props, prefix, "http.proxyHost")) {
            this.setHttpProxyHost(this.getString(props, prefix, "http.proxyHost"));
        }
        else if (this.notNull(props, prefix, "http.proxyHost")) {
            this.setHttpProxyHost(this.getString(props, prefix, "http.proxyHost"));
        }
        if (this.notNull(props, prefix, "http.proxyUser")) {
            this.setHttpProxyUser(this.getString(props, prefix, "http.proxyUser"));
        }
        if (this.notNull(props, prefix, "http.proxyPassword")) {
            this.setHttpProxyPassword(this.getString(props, prefix, "http.proxyPassword"));
        }
        if (this.notNull(props, prefix, "http.proxyPort")) {
            this.setHttpProxyPort(this.getIntProperty(props, prefix, "http.proxyPort"));
        }
        else if (this.notNull(props, prefix, "http.proxyPort")) {
            this.setHttpProxyPort(this.getIntProperty(props, prefix, "http.proxyPort"));
        }
        if (this.notNull(props, prefix, "http.connectionTimeout")) {
            this.setHttpConnectionTimeout(this.getIntProperty(props, prefix, "http.connectionTimeout"));
        }
        if (this.notNull(props, prefix, "http.readTimeout")) {
            this.setHttpReadTimeout(this.getIntProperty(props, prefix, "http.readTimeout"));
        }
        if (this.notNull(props, prefix, "http.streamingReadTimeout")) {
            this.setHttpStreamingReadTimeout(this.getIntProperty(props, prefix, "http.streamingReadTimeout"));
        }
        if (this.notNull(props, prefix, "http.retryCount")) {
            this.setHttpRetryCount(this.getIntProperty(props, prefix, "http.retryCount"));
        }
        if (this.notNull(props, prefix, "http.retryIntervalSecs")) {
            this.setHttpRetryIntervalSeconds(this.getIntProperty(props, prefix, "http.retryIntervalSecs"));
        }
        if (this.notNull(props, prefix, "oauth.consumerKey")) {
            this.setOAuthConsumerKey(this.getString(props, prefix, "oauth.consumerKey"));
        }
        if (this.notNull(props, prefix, "oauth.consumerSecret")) {
            this.setOAuthConsumerSecret(this.getString(props, prefix, "oauth.consumerSecret"));
        }
        if (this.notNull(props, prefix, "oauth.accessToken")) {
            this.setOAuthAccessToken(this.getString(props, prefix, "oauth.accessToken"));
        }
        if (this.notNull(props, prefix, "oauth.accessTokenSecret")) {
            this.setOAuthAccessTokenSecret(this.getString(props, prefix, "oauth.accessTokenSecret"));
        }
        if (this.notNull(props, prefix, "oauth2.tokenType")) {
            this.setOAuth2TokenType(this.getString(props, prefix, "oauth2.tokenType"));
        }
        if (this.notNull(props, prefix, "oauth2.accessToken")) {
            this.setOAuth2AccessToken(this.getString(props, prefix, "oauth2.accessToken"));
        }
        if (this.notNull(props, prefix, "oauth2.scope")) {
            this.setOAuth2Scope(this.getString(props, prefix, "oauth2.scope"));
        }
        if (this.notNull(props, prefix, "async.numThreads")) {
            this.setAsyncNumThreads(this.getIntProperty(props, prefix, "async.numThreads"));
        }
        if (this.notNull(props, prefix, "async.daemonEnabled")) {
            this.setDaemonEnabled(this.getBoolean(props, prefix, "async.daemonEnabled"));
        }
        if (this.notNull(props, prefix, "contributingTo")) {
            this.setContributingTo(this.getLongProperty(props, prefix, "contributingTo"));
        }
        if (this.notNull(props, prefix, "async.dispatcherImpl")) {
            this.setDispatcherImpl(this.getString(props, prefix, "async.dispatcherImpl"));
        }
        if (this.notNull(props, prefix, "oauth.requestTokenURL")) {
            this.setOAuthRequestTokenURL(this.getString(props, prefix, "oauth.requestTokenURL"));
        }
        if (this.notNull(props, prefix, "oauth.authorizationURL")) {
            this.setOAuthAuthorizationURL(this.getString(props, prefix, "oauth.authorizationURL"));
        }
        if (this.notNull(props, prefix, "oauth.accessTokenURL")) {
            this.setOAuthAccessTokenURL(this.getString(props, prefix, "oauth.accessTokenURL"));
        }
        if (this.notNull(props, prefix, "oauth.authenticationURL")) {
            this.setOAuthAuthenticationURL(this.getString(props, prefix, "oauth.authenticationURL"));
        }
        if (this.notNull(props, prefix, "oauth2.tokenURL")) {
            this.setOAuth2TokenURL(this.getString(props, prefix, "oauth2.tokenURL"));
        }
        if (this.notNull(props, prefix, "oauth2.invalidateTokenURL")) {
            this.setOAuth2InvalidateTokenURL(this.getString(props, prefix, "oauth2.invalidateTokenURL"));
        }
        if (this.notNull(props, prefix, "restBaseURL")) {
            this.setRestBaseURL(this.getString(props, prefix, "restBaseURL"));
        }
        if (this.notNull(props, prefix, "streamBaseURL")) {
            this.setStreamBaseURL(this.getString(props, prefix, "streamBaseURL"));
        }
        if (this.notNull(props, prefix, "userStreamBaseURL")) {
            this.setUserStreamBaseURL(this.getString(props, prefix, "userStreamBaseURL"));
        }
        if (this.notNull(props, prefix, "siteStreamBaseURL")) {
            this.setSiteStreamBaseURL(this.getString(props, prefix, "siteStreamBaseURL"));
        }
        if (this.notNull(props, prefix, "includeMyRetweet")) {
            this.setIncludeMyRetweetEnabled(this.getBoolean(props, prefix, "includeMyRetweet"));
        }
        if (this.notNull(props, prefix, "includeEntities")) {
            this.setIncludeEntitiesEnabled(this.getBoolean(props, prefix, "includeEntities"));
        }
        if (this.notNull(props, prefix, "loggerFactory")) {
            this.setLoggerFactory(this.getString(props, prefix, "loggerFactory"));
        }
        if (this.notNull(props, prefix, "jsonStoreEnabled")) {
            this.setJSONStoreEnabled(this.getBoolean(props, prefix, "jsonStoreEnabled"));
        }
        if (this.notNull(props, prefix, "mbeanEnabled")) {
            this.setMBeanEnabled(this.getBoolean(props, prefix, "mbeanEnabled"));
        }
        if (this.notNull(props, prefix, "stream.user.repliesAll")) {
            this.setUserStreamRepliesAllEnabled(this.getBoolean(props, prefix, "stream.user.repliesAll"));
        }
        if (this.notNull(props, prefix, "stream.user.withFollowings")) {
            this.setUserStreamWithFollowingsEnabled(this.getBoolean(props, prefix, "stream.user.withFollowings"));
        }
        if (this.notNull(props, prefix, "stream.enableStallWarnings")) {
            this.setStallWarningsEnabled(this.getBoolean(props, prefix, "stream.enableStallWarnings"));
        }
        if (this.notNull(props, prefix, "enableApplicationOnlyAuth")) {
            this.setApplicationOnlyAuthEnabled(this.getBoolean(props, prefix, "enableApplicationOnlyAuth"));
        }
        if (this.notNull(props, prefix, "media.provider")) {
            this.setMediaProvider(this.getString(props, prefix, "media.provider"));
        }
        if (this.notNull(props, prefix, "media.providerAPIKey")) {
            this.setMediaProviderAPIKey(this.getString(props, prefix, "media.providerAPIKey"));
        }
        if (this.notNull(props, prefix, "media.providerParameters")) {
            final String[] propsAry = this.getString(props, prefix, "media.providerParameters").split("&");
            final Properties p = new Properties();
            String[] array;
            for (int length = (array = propsAry).length, i = 0; i < length; ++i) {
                final String str = array[i];
                final String[] parameter = str.split("=");
                p.setProperty(parameter[0], parameter[1]);
            }
            this.setMediaProviderParameters(p);
        }
        this.cacheInstance();
    }
    
    boolean getBoolean(final Properties props, final String prefix, final String name) {
        final String value = props.getProperty(String.valueOf(prefix) + name);
        return Boolean.valueOf(value);
    }
    
    int getIntProperty(final Properties props, final String prefix, final String name) {
        final String value = props.getProperty(String.valueOf(prefix) + name);
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException nfe) {
            return -1;
        }
    }
    
    long getLongProperty(final Properties props, final String prefix, final String name) {
        final String value = props.getProperty(String.valueOf(prefix) + name);
        try {
            return Long.parseLong(value);
        }
        catch (NumberFormatException nfe) {
            return -1L;
        }
    }
    
    String getString(final Properties props, final String prefix, final String name) {
        return props.getProperty(String.valueOf(prefix) + name);
    }
    
    @Override
    protected Object readResolve() throws ObjectStreamException {
        return super.readResolve();
    }
}
