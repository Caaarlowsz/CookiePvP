package twitter4j.api;

import twitter4j.Category;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.ResponseList;

public interface SuggestedUsersResources
{
    ResponseList<User> getUserSuggestions(final String p0) throws TwitterException;
    
    ResponseList<Category> getSuggestedUserCategories() throws TwitterException;
    
    ResponseList<User> getMemberSuggestions(final String p0) throws TwitterException;
}
