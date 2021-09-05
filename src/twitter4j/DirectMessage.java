package twitter4j;

import java.util.Date;
import java.io.Serializable;

public interface DirectMessage extends TwitterResponse, EntitySupport, Serializable
{
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
