package twitter4j.auth;

import twitter4j.HttpRequest;
import java.io.Serializable;

public interface Authorization extends Serializable
{
    String getAuthorizationHeader(final HttpRequest p0);
    
    boolean isEnabled();
}
