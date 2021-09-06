package twitter4j.auth;

import java.io.Serializable;

import twitter4j.HttpResponse;
import twitter4j.TwitterException;

public class AccessToken extends OAuthToken implements Serializable {
	private static final long serialVersionUID = 2470022129505774772L;
	private String screenName;
	private long userId;

	AccessToken(final HttpResponse res) throws TwitterException {
		this(res.asString());
	}

	AccessToken(final String str) {
		super(str);
		this.userId = -1L;
		this.screenName = this.getParameter("screen_name");
		final String sUserId = this.getParameter("user_id");
		if (sUserId != null) {
			this.userId = Long.parseLong(sUserId);
		}
	}

	public AccessToken(final String token, final String tokenSecret) {
		super(token, tokenSecret);
		this.userId = -1L;
		final int dashIndex = token.indexOf("-");
		if (dashIndex != -1) {
			final String sUserId = token.substring(0, dashIndex);
			try {
				this.userId = Long.parseLong(sUserId);
			} catch (NumberFormatException ex) {
			}
		}
	}

	public AccessToken(final String token, final String tokenSecret, final long userId) {
		super(token, tokenSecret);
		this.userId = -1L;
		this.userId = userId;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public long getUserId() {
		return this.userId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		final AccessToken that = (AccessToken) o;
		if (this.userId != that.userId) {
			return false;
		}
		if (this.screenName != null) {
			if (this.screenName.equals(that.screenName)) {
				return true;
			}
		} else if (that.screenName == null) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + ((this.screenName != null) ? this.screenName.hashCode() : 0);
		result = 31 * result + (int) (this.userId ^ this.userId >>> 32);
		return result;
	}

	@Override
	public String toString() {
		return "AccessToken{screenName='" + this.screenName + '\'' + ", userId=" + this.userId + '}';
	}
}
