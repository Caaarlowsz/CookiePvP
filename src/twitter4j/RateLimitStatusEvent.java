package twitter4j;

import java.util.EventObject;

public final class RateLimitStatusEvent extends EventObject {
	private static final long serialVersionUID = 3749366911109722414L;
	private final RateLimitStatus rateLimitStatus;
	private final boolean isAccountRateLimitStatus;

	RateLimitStatusEvent(final Object source, final RateLimitStatus rateLimitStatus,
			final boolean isAccountRateLimitStatus) {
		super(source);
		this.rateLimitStatus = rateLimitStatus;
		this.isAccountRateLimitStatus = isAccountRateLimitStatus;
	}

	public RateLimitStatus getRateLimitStatus() {
		return this.rateLimitStatus;
	}

	public boolean isAccountRateLimitStatus() {
		return this.isAccountRateLimitStatus;
	}

	public boolean isIPRateLimitStatus() {
		return !this.isAccountRateLimitStatus;
	}
}
