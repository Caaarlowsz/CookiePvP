package twitter4j.api;

import twitter4j.TwitterException;
import twitter4j.User;

public interface SpamReportingResource
{
    User reportSpam(final long p0) throws TwitterException;
    
    User reportSpam(final String p0) throws TwitterException;
}
