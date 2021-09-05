package twitter4j.api;

import java.io.InputStream;
import twitter4j.Paging;
import twitter4j.TwitterException;
import twitter4j.DirectMessage;
import twitter4j.ResponseList;

public interface DirectMessagesResources
{
    ResponseList<DirectMessage> getDirectMessages() throws TwitterException;
    
    ResponseList<DirectMessage> getDirectMessages(final Paging p0) throws TwitterException;
    
    ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException;
    
    ResponseList<DirectMessage> getSentDirectMessages(final Paging p0) throws TwitterException;
    
    DirectMessage showDirectMessage(final long p0) throws TwitterException;
    
    DirectMessage destroyDirectMessage(final long p0) throws TwitterException;
    
    DirectMessage sendDirectMessage(final long p0, final String p1) throws TwitterException;
    
    DirectMessage sendDirectMessage(final String p0, final String p1) throws TwitterException;
    
    InputStream getDMImageAsStream(final String p0) throws TwitterException;
}
