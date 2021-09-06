package twitter4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import twitter4j.conf.ConfigurationContext;

public final class HttpClientFactory {
	private static final Constructor<?> HTTP_CLIENT_CONSTRUCTOR;
	private static final HashMap<HttpClientConfiguration, HttpClient> confClientMap;

	static {
		Class<?> clazz = null;
		final String httpClientImpl = System.getProperty("twitter4j.http.httpClient");
		if (httpClientImpl != null) {
			try {
				clazz = Class.forName(httpClientImpl);
			} catch (ClassNotFoundException ex) {
			}
		}
		if (clazz == null) {
			try {
				clazz = Class.forName("twitter4j.AlternativeHttpClientImpl");
			} catch (ClassNotFoundException ex2) {
			}
		}
		if (clazz == null) {
			try {
				clazz = Class.forName("twitter4j.HttpClientImpl");
			} catch (ClassNotFoundException cnfe) {
				throw new AssertionError((Object) cnfe);
			}
		}
		try {
			HTTP_CLIENT_CONSTRUCTOR = clazz.getConstructor(HttpClientConfiguration.class);
		} catch (NoSuchMethodException nsme) {
			throw new AssertionError((Object) nsme);
		}
		confClientMap = new HashMap<HttpClientConfiguration, HttpClient>();
	}

	public static HttpClient getInstance() {
		return getInstance(ConfigurationContext.getInstance().getHttpClientConfiguration());
	}

	public static HttpClient getInstance(final HttpClientConfiguration conf) {
		HttpClient client = HttpClientFactory.confClientMap.get(conf);
		try {
			if (client == null) {
				client = (HttpClient) HttpClientFactory.HTTP_CLIENT_CONSTRUCTOR.newInstance(conf);
				HttpClientFactory.confClientMap.put(conf, client);
			}
		} catch (InstantiationException e) {
			throw new AssertionError((Object) e);
		} catch (IllegalAccessException e2) {
			throw new AssertionError((Object) e2);
		} catch (InvocationTargetException e3) {
			throw new AssertionError((Object) e3);
		}
		return client;
	}
}
