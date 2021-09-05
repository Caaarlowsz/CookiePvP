package twitter4j;

import java.io.Serializable;

public interface Place extends TwitterResponse, Comparable<Place>, Serializable
{
    String getName();
    
    String getStreetAddress();
    
    String getCountryCode();
    
    String getId();
    
    String getCountry();
    
    String getPlaceType();
    
    String getURL();
    
    String getFullName();
    
    String getBoundingBoxType();
    
    GeoLocation[][] getBoundingBoxCoordinates();
    
    String getGeometryType();
    
    GeoLocation[][] getGeometryCoordinates();
    
    Place[] getContainedWithIn();
}
