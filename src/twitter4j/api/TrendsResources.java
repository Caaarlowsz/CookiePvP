package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.Trends;

public interface TrendsResources
{
    Trends getPlaceTrends(final int p0) throws TwitterException;
    
    ResponseList<Location> getAvailableTrends() throws TwitterException;
    
    ResponseList<Location> getClosestTrends(final GeoLocation p0) throws TwitterException;
}
