package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.ResponseList;
import twitter4j.GeoQuery;
import twitter4j.TwitterException;
import twitter4j.Place;

public interface PlacesGeoResources
{
    Place getGeoDetails(final String p0) throws TwitterException;
    
    ResponseList<Place> reverseGeoCode(final GeoQuery p0) throws TwitterException;
    
    ResponseList<Place> searchPlaces(final GeoQuery p0) throws TwitterException;
    
    ResponseList<Place> getSimilarPlaces(final GeoLocation p0, final String p1, final String p2, final String p3) throws TwitterException;
}
