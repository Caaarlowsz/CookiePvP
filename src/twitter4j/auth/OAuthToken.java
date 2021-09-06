package twitter4j.auth;

import java.io.Serializable;

import javax.crypto.spec.SecretKeySpec;

import twitter4j.HttpResponse;
import twitter4j.TwitterException;

abstract class OAuthToken implements Serializable {
	private static final long serialVersionUID = -7841506492508140600L;
	private final String token;
	private final String tokenSecret;
	private transient SecretKeySpec secretKeySpec;
	private String[] responseStr;

	public OAuthToken(final String token, final String tokenSecret) {
		this.responseStr = null;
		if (token == null) {
			throw new IllegalArgumentException("Token can't be null");
		}
		if (tokenSecret == null) {
			throw new IllegalArgumentException("TokenSecret can't be null");
		}
		this.token = token;
		this.tokenSecret = tokenSecret;
	}

	OAuthToken(final HttpResponse response) throws TwitterException {
		this(response.asString());
	}

	OAuthToken(final String string) {
		this.responseStr = null;
		this.responseStr = string.split("&");
		this.tokenSecret = this.getParameter("oauth_token_secret");
		this.token = this.getParameter("oauth_token");
	}

	public String getToken() {
		return this.token;
	}

	public String getTokenSecret() {
		return this.tokenSecret;
	}

	void setSecretKeySpec(final SecretKeySpec secretKeySpec) {
		this.secretKeySpec = secretKeySpec;
	}

	SecretKeySpec getSecretKeySpec() {
		return this.secretKeySpec;
	}

	public String getParameter(final String parameter) {
		String value = null;
		String[] responseStr;
		for (int length = (responseStr = this.responseStr).length, i = 0; i < length; ++i) {
			final String str = responseStr[i];
			if (str.startsWith(String.valueOf(parameter) + '=')) {
				value = str.split("=")[1].trim();
				break;
			}
		}
		return value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof OAuthToken)) {
			return false;
		}
		final OAuthToken that = (OAuthToken) o;
		return this.token.equals(that.token) && this.tokenSecret.equals(that.tokenSecret);
	}

	@Override
	public int hashCode() {
		int result = this.token.hashCode();
		result = 31 * result + this.tokenSecret.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "OAuthToken{token='" + this.token + '\'' + ", tokenSecret='" + this.tokenSecret + '\''
				+ ", secretKeySpec=" + this.secretKeySpec + '}';
	}
}
