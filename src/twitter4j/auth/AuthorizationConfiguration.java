package twitter4j.auth;

public interface AuthorizationConfiguration
{
    String getUser();
    
    String getPassword();
    
    String getOAuthConsumerKey();
    
    String getOAuthConsumerSecret();
    
    String getOAuthAccessToken();
    
    String getOAuthAccessTokenSecret();
    
    String getOAuth2TokenType();
    
    String getOAuth2AccessToken();
}
