package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface DirectMessage extends TwitterResponse, EntitySupport, Serializable {
	long getId();

	String getText();

	long getSenderId();

	long getRecipientId();

	Date getCreatedAt();

	String getSenderScreenName();

	String getRecipientScreenName();

	User getSender();

	User getRecipient();
}
