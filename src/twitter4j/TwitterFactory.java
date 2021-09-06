package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

@SuppressWarnings("unchecked")
public final class TwitterFactory implements Serializable {
	private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
	static final Authorization DEFAULT_AUTHORIZATION;
	private static final Twitter SINGLETON;
	private static final long serialVersionUID = -563983536986910054L;
	private final Configuration conf;

	static {
		DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
		boolean gaeDetected;
		try {
			Class.forName("com.google.appengine.api.urlfetch.URLFetchService");
			gaeDetected = true;
		} catch (ClassNotFoundException cnfe) {
			gaeDetected = false;
		}
		String className = null;
		if (gaeDetected) {
			try {
				Class.forName("twitter4j.AppEngineTwitterImpl");
				className = "twitter4j.AppEngineTwitterImpl";
			} catch (ClassNotFoundException ex) {
			}
		}
		if (className == null) {
			className = "twitter4j.TwitterImpl";
		}
		Constructor<Twitter> constructor;
		try {
			final Class<?> clazz = Class.forName(className);
			constructor = (Constructor<Twitter>) clazz.getDeclaredConstructor(Configuration.class, Authorization.class);
		} catch (NoSuchMethodException e) {
			throw new AssertionError((Object) e);
		} catch (ClassNotFoundException e2) {
			throw new AssertionError((Object) e2);
		}
		TWITTER_CONSTRUCTOR = constructor;
		try {
			SINGLETON = TwitterFactory.TWITTER_CONSTRUCTOR.newInstance(ConfigurationContext.getInstance(),
					TwitterFactory.DEFAULT_AUTHORIZATION);
		} catch (InstantiationException e3) {
			throw new AssertionError((Object) e3);
		} catch (IllegalAccessException e4) {
			throw new AssertionError((Object) e4);
		} catch (InvocationTargetException e5) {
			throw new AssertionError((Object) e5);
		}
	}

	public TwitterFactory() {
		this(ConfigurationContext.getInstance());
	}

	public TwitterFactory(final Configuration conf) {
		if (conf == null) {
			throw new NullPointerException("configuration cannot be null");
		}
		this.conf = conf;
	}

	public TwitterFactory(final String configTreePath) {
		this(ConfigurationContext.getInstance(configTreePath));
	}

	public Twitter getInstance() {
		return this.getInstance(AuthorizationFactory.getInstance(this.conf));
	}

	public Twitter getInstance(final AccessToken accessToken) {
		final String consumerKey = this.conf.getOAuthConsumerKey();
		final String consumerSecret = this.conf.getOAuthConsumerSecret();
		if (consumerKey == null && consumerSecret == null) {
			throw new IllegalStateException("Consumer key and Consumer secret not supplied.");
		}
		final OAuthAuthorization oauth = new OAuthAuthorization(this.conf);
		oauth.setOAuthAccessToken(accessToken);
		return this.getInstance(oauth);
	}

	public Twitter getInstance(final Authorization auth) {
		try {
			return TwitterFactory.TWITTER_CONSTRUCTOR.newInstance(this.conf, auth);
		} catch (InstantiationException e) {
			throw new AssertionError((Object) e);
		} catch (IllegalAccessException e2) {
			throw new AssertionError((Object) e2);
		} catch (InvocationTargetException e3) {
			throw new AssertionError((Object) e3);
		}
	}

	public static Twitter getSingleton() {
		return TwitterFactory.SINGLETON;
	}
}
