package twitter4j.api;

import twitter4j.RateLimitStatus;
import java.util.Map;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.TwitterAPIConfiguration;

public interface HelpResources
{
    TwitterAPIConfiguration getAPIConfiguration() throws TwitterException;
    
    ResponseList<Language> getLanguages() throws TwitterException;
    
    String getPrivacyPolicy() throws TwitterException;
    
    String getTermsOfService() throws TwitterException;
    
    Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException;
    
    Map<String, RateLimitStatus> getRateLimitStatus(final String... p0) throws TwitterException;
    
    public interface Language
    {
        String getName();
        
        String getCode();
        
        String getStatus();
    }
}
