package twitter4j;

import java.util.Date;
import java.io.Serializable;

public interface Status extends Comparable<Status>, TwitterResponse, EntitySupport, Serializable
{
    Date getCreatedAt();
    
    long getId();
    
    String getText();
    
    String getSource();
    
    boolean isTruncated();
    
    long getInReplyToStatusId();
    
    long getInReplyToUserId();
    
    String getInReplyToScreenName();
    
    GeoLocation getGeoLocation();
    
    Place getPlace();
    
    boolean isFavorited();
    
    boolean isRetweeted();
    
    int getFavoriteCount();
    
    User getUser();
    
    boolean isRetweet();
    
    Status getRetweetedStatus();
    
    long[] getContributors();
    
    int getRetweetCount();
    
    boolean isRetweetedByMe();
    
    long getCurrentUserRetweetId();
    
    boolean isPossiblySensitive();
    
    String getLang();
    
    Scopes getScopes();
    
    String[] getWithheldInCountries();
    
    long getQuotedStatusId();
    
    Status getQuotedStatus();
}
