package twitter4j.api;

import twitter4j.Paging;
import twitter4j.TwitterException;
import twitter4j.Status;
import twitter4j.ResponseList;

public interface FavoritesResources
{
    ResponseList<Status> getFavorites() throws TwitterException;
    
    ResponseList<Status> getFavorites(final long p0) throws TwitterException;
    
    ResponseList<Status> getFavorites(final String p0) throws TwitterException;
    
    ResponseList<Status> getFavorites(final Paging p0) throws TwitterException;
    
    ResponseList<Status> getFavorites(final long p0, final Paging p1) throws TwitterException;
    
    ResponseList<Status> getFavorites(final String p0, final Paging p1) throws TwitterException;
    
    Status createFavorite(final long p0) throws TwitterException;
    
    Status destroyFavorite(final long p0) throws TwitterException;
}
