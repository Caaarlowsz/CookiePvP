package twitter4j;

import java.util.Date;
import java.io.Serializable;

public interface Trends extends TwitterResponse, Comparable<Trends>, Serializable
{
    Trend[] getTrends();
    
    Location getLocation();
    
    Date getAsOf();
    
    Date getTrendAt();
}
