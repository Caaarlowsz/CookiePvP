package twitter4j;

import java.io.Serializable;

public interface URLEntity extends TweetEntity, Serializable {
	String getText();

	String getURL();

	String getExpandedURL();

	String getDisplayURL();

	int getStart();

	int getEnd();
}
