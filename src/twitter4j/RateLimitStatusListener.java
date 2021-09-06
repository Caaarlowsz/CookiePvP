package twitter4j;

public interface RateLimitStatusListener {
	void onRateLimitStatus(final RateLimitStatusEvent p0);

	void onRateLimitReached(final RateLimitStatusEvent p0);
}
