package twitter4j;

import java.util.Date;
import java.io.Serializable;

public interface SavedSearch extends Comparable<SavedSearch>, TwitterResponse, Serializable
{
    Date getCreatedAt();
    
    String getQuery();
    
    int getPosition();
    
    String getName();
    
    long getId();
}
