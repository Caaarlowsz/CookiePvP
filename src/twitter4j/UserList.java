package twitter4j;

import java.util.Date;
import java.net.URI;
import java.io.Serializable;

public interface UserList extends Comparable<UserList>, TwitterResponse, Serializable
{
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
