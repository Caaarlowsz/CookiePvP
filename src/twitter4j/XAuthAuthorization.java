package twitter4j;

import java.io.Serializable;

import twitter4j.auth.Authorization;
import twitter4j.auth.BasicAuthorization;

public class XAuthAuthorization implements Authorization, Serializable {
	private static final long serialVersionUID = -7260372598870697494L;
	private final BasicAuthorization basic;
	private String consumerKey;
	private String consumerSecret;

	public XAuthAuthorization(final BasicAuthorization basic) {
		this.basic = basic;
	}

	@Override
	public String getAuthorizationHeader(final HttpRequest req) {
		return this.basic.getAuthorizationHeader(req);
	}

	public String getUserId() {
		return this.basic.getUserId();
	}

	public String getPassword() {
		return this.basic.getPassword();
	}

	public String getConsumerKey() {
		return this.consumerKey;
	}

	public String getConsumerSecret() {
		return this.consumerSecret;
	}

	public synchronized void setOAuthConsumer(final String consumerKey, final String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	@Override
	public boolean isEnabled() {
		return this.basic.isEnabled();
	}
}
