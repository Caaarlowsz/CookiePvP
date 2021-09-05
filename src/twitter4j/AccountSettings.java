package twitter4j;

import java.io.Serializable;

public interface AccountSettings extends TwitterResponse, Serializable
{
    boolean isSleepTimeEnabled();
    
    String getSleepStartTime();
    
    String getSleepEndTime();
    
    Location[] getTrendLocations();
    
    boolean isGeoEnabled();
    
    TimeZone getTimeZone();
    
    String getLanguage();
    
    boolean isDiscoverableByEmail();
    
    boolean isAlwaysUseHttps();
    
    String getScreenName();
}
