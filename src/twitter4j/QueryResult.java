package twitter4j;

import java.util.List;
import java.io.Serializable;

public interface QueryResult extends TwitterResponse, Serializable
{
    long getSinceId();
    
    long getMaxId();
    
    String getRefreshURL();
    
    int getCount();
    
    double getCompletedIn();
    
    String getQuery();
    
    List<Status> getTweets();
    
    Query nextQuery();
    
    boolean hasNext();
}
