package twitter4j;

import java.io.Serializable;

public interface UserMentionEntity extends TweetEntity, Serializable {
	String getText();

	String getName();

	String getScreenName();

	long getId();

	int getStart();

	int getEnd();
}
