package twitter4j;

import java.io.Serializable;

public interface Relationship extends TwitterResponse, Serializable {
	long getSourceUserId();

	long getTargetUserId();

	boolean isSourceBlockingTarget();

	boolean isSourceMutingTarget();

	String getSourceUserScreenName();

	String getTargetUserScreenName();

	boolean isSourceFollowingTarget();

	boolean isTargetFollowingSource();

	boolean isSourceFollowedByTarget();

	boolean isTargetFollowedBySource();

	boolean canSourceDm();

	boolean isSourceNotificationsEnabled();

	boolean isSourceWantRetweets();
}
