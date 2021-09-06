package twitter4j;

import java.util.Map;

import twitter4j.auth.Authorization;

public interface HttpClient {
	void addDefaultRequestHeader(final String p0, final String p1);

	Map<String, String> getRequestHeaders();

	HttpResponse request(final HttpRequest p0) throws TwitterException;

	HttpResponse request(final HttpRequest p0, final HttpResponseListener p1) throws TwitterException;

	HttpResponse get(final String p0, final HttpParameter[] p1, final Authorization p2, final HttpResponseListener p3)
			throws TwitterException;

	HttpResponse get(final String p0) throws TwitterException;

	HttpResponse post(final String p0, final HttpParameter[] p1, final Authorization p2, final HttpResponseListener p3)
			throws TwitterException;

	HttpResponse post(final String p0) throws TwitterException;

	HttpResponse delete(final String p0, final HttpParameter[] p1, final Authorization p2,
			final HttpResponseListener p3) throws TwitterException;

	HttpResponse delete(final String p0) throws TwitterException;

	HttpResponse head(final String p0) throws TwitterException;

	HttpResponse put(final String p0, final HttpParameter[] p1, final Authorization p2, final HttpResponseListener p3)
			throws TwitterException;

	HttpResponse put(final String p0) throws TwitterException;
}
