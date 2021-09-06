package twitter4j.auth;

import java.io.Serializable;

import twitter4j.HttpRequest;

public interface Authorization extends Serializable {
	String getAuthorizationHeader(final HttpRequest p0);

	boolean isEnabled();
}
