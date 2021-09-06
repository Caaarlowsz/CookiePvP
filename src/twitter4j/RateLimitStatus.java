package twitter4j;

import java.io.Serializable;

public interface RateLimitStatus extends Serializable {
	int getRemaining();

	int getLimit();

	int getResetTimeInSeconds();

	int getSecondsUntilReset();
}
