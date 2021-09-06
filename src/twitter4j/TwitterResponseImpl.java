package twitter4j;

import java.io.Serializable;

abstract class TwitterResponseImpl implements TwitterResponse, Serializable {
	private static final long serialVersionUID = 7422171124869859808L;
	private transient RateLimitStatus rateLimitStatus;
	private final transient int accessLevel;

	public TwitterResponseImpl() {
		this.rateLimitStatus = null;
		this.accessLevel = 0;
	}

	public TwitterResponseImpl(final HttpResponse res) {
		this.rateLimitStatus = null;
		this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(res);
		this.accessLevel = ParseUtil.toAccessLevel(res);
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		return this.rateLimitStatus;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}
}
