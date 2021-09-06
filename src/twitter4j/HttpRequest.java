package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

import twitter4j.auth.Authorization;

public final class HttpRequest implements Serializable {
	private static final long serialVersionUID = 3365496352032493020L;
	private final RequestMethod method;
	private final String url;
	private final HttpParameter[] parameters;
	private final Authorization authorization;
	private final Map<String, String> requestHeaders;
	private static final HttpParameter[] NULL_PARAMETERS;

	static {
		NULL_PARAMETERS = new HttpParameter[0];
	}

	public HttpRequest(final RequestMethod method, final String url, final HttpParameter[] parameters,
			final Authorization authorization, final Map<String, String> requestHeaders) {
		this.method = method;
		if (method != RequestMethod.POST && parameters != null && parameters.length != 0) {
			this.url = String.valueOf(url) + "?" + HttpParameter.encodeParameters(parameters);
			this.parameters = HttpRequest.NULL_PARAMETERS;
		} else {
			this.url = url;
			this.parameters = parameters;
		}
		this.authorization = authorization;
		this.requestHeaders = requestHeaders;
	}

	public RequestMethod getMethod() {
		return this.method;
	}

	public HttpParameter[] getParameters() {
		return this.parameters;
	}

	public String getURL() {
		return this.url;
	}

	public Authorization getAuthorization() {
		return this.authorization;
	}

	public Map<String, String> getRequestHeaders() {
		return this.requestHeaders;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final HttpRequest that = (HttpRequest) o;
		Label_0062: {
			if (this.authorization != null) {
				if (this.authorization.equals(that.authorization)) {
					break Label_0062;
				}
			} else if (that.authorization == null) {
				break Label_0062;
			}
			return false;
		}
		if (!Arrays.equals(this.parameters, that.parameters)) {
			return false;
		}
		Label_0113: {
			if (this.requestHeaders != null) {
				if (this.requestHeaders.equals(that.requestHeaders)) {
					break Label_0113;
				}
			} else if (that.requestHeaders == null) {
				break Label_0113;
			}
			return false;
		}
		Label_0146: {
			if (this.method != null) {
				if (this.method.equals(that.method)) {
					break Label_0146;
				}
			} else if (that.method == null) {
				break Label_0146;
			}
			return false;
		}
		if (this.url != null) {
			if (this.url.equals(that.url)) {
				return true;
			}
		} else if (that.url == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = (this.method != null) ? this.method.hashCode() : 0;
		result = 31 * result + ((this.url != null) ? this.url.hashCode() : 0);
		result = 31 * result + ((this.parameters != null) ? Arrays.hashCode(this.parameters) : 0);
		result = 31 * result + ((this.authorization != null) ? this.authorization.hashCode() : 0);
		result = 31 * result + ((this.requestHeaders != null) ? this.requestHeaders.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "HttpRequest{requestMethod=" + this.method + ", url='" + this.url + '\'' + ", postParams="
				+ ((this.parameters == null) ? null : Arrays.asList(this.parameters)) + ", authentication="
				+ this.authorization + ", requestHeaders=" + this.requestHeaders + '}';
	}
}
