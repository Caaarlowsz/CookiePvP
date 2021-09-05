package twitter4j;

import java.io.Serializable;

public interface Location extends Serializable
{
    int getWoeid();
    
    String getCountryName();
    
    String getCountryCode();
    
    String getPlaceName();
    
    int getPlaceCode();
    
    String getName();
    
    String getURL();
}
