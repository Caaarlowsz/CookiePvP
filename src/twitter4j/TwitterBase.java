package twitter4j;

import twitter4j.conf.Configuration;
import twitter4j.auth.Authorization;
import twitter4j.util.function.Consumer;

public interface TwitterBase
{
    String getScreenName() throws TwitterException, IllegalStateException;
    
    long getId() throws TwitterException, IllegalStateException;
    
    void addRateLimitStatusListener(final RateLimitStatusListener p0);
    
    void onRateLimitStatus(final Consumer<RateLimitStatusEvent> p0);
    
    void onRateLimitReached(final Consumer<RateLimitStatusEvent> p0);
    
    Authorization getAuthorization();
    
    Configuration getConfiguration();
}
