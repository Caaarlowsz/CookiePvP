package twitter4j;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

public interface UserList extends Comparable<UserList>, TwitterResponse, Serializable {
	long getId();

	String getName();

	String getFullName();

	String getSlug();

	String getDescription();

	int getSubscriberCount();

	int getMemberCount();

	URI getURI();

	boolean isPublic();

	User getUser();

	boolean isFollowing();

	Date getCreatedAt();
}
