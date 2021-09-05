package twitter4j.api;

import twitter4j.TwitterException;
import twitter4j.SavedSearch;
import twitter4j.ResponseList;

public interface SavedSearchesResources
{
    ResponseList<SavedSearch> getSavedSearches() throws TwitterException;
    
    SavedSearch showSavedSearch(final long p0) throws TwitterException;
    
    SavedSearch createSavedSearch(final String p0) throws TwitterException;
    
    SavedSearch destroySavedSearch(final long p0) throws TwitterException;
}
