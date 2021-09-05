package twitter4j;

import twitter4j.api.HelpResources;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.TrendsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.ListsResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.UsersResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.TweetsResources;
import twitter4j.api.TimelinesResources;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuthSupport;
import java.io.Serializable;

public interface Twitter extends Serializable, OAuthSupport, OAuth2Support, TwitterBase, TimelinesResources, TweetsResources, SearchResource, DirectMessagesResources, FriendsFollowersResources, UsersResources, SuggestedUsersResources, FavoritesResources, ListsResources, SavedSearchesResources, PlacesGeoResources, TrendsResources, SpamReportingResource, HelpResources
{
    TimelinesResources timelines();
    
    TweetsResources tweets();
    
    SearchResource search();
    
    DirectMessagesResources directMessages();
    
    FriendsFollowersResources friendsFollowers();
    
    UsersResources users();
    
    SuggestedUsersResources suggestedUsers();
    
    FavoritesResources favorites();
    
    ListsResources list();
    
    SavedSearchesResources savedSearches();
    
    PlacesGeoResources placesGeo();
    
    TrendsResources trends();
    
    SpamReportingResource spamReporting();
    
    HelpResources help();
}
