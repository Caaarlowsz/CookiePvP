package twitter4j.api;

import twitter4j.Paging;
import twitter4j.TwitterException;
import twitter4j.Status;
import twitter4j.ResponseList;

public interface TimelinesResources
{
    ResponseList<Status> getMentionsTimeline() throws TwitterException;
    
    ResponseList<Status> getMentionsTimeline(final Paging p0) throws TwitterException;
    
    ResponseList<Status> getUserTimeline(final String p0, final Paging p1) throws TwitterException;
    
    ResponseList<Status> getUserTimeline(final long p0, final Paging p1) throws TwitterException;
    
    ResponseList<Status> getUserTimeline(final String p0) throws TwitterException;
    
    ResponseList<Status> getUserTimeline(final long p0) throws TwitterException;
    
    ResponseList<Status> getUserTimeline() throws TwitterException;
    
    ResponseList<Status> getUserTimeline(final Paging p0) throws TwitterException;
    
    ResponseList<Status> getHomeTimeline() throws TwitterException;
    
    ResponseList<Status> getHomeTimeline(final Paging p0) throws TwitterException;
    
    ResponseList<Status> getRetweetsOfMe() throws TwitterException;
    
    ResponseList<Status> getRetweetsOfMe(final Paging p0) throws TwitterException;
}
