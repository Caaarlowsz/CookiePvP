package twitter4j.auth;

import twitter4j.HttpRequest;
import twitter4j.BASE64Encoder;
import java.io.Serializable;

public class BasicAuthorization implements Authorization, Serializable
{
    private static final long serialVersionUID = 7420629998989177351L;
    private final String userId;
    private final String password;
    private final String basic;
    
    public BasicAuthorization(final String userId, final String password) {
        this.userId = userId;
        this.password = password;
        this.basic = this.encodeBasicAuthenticationString();
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    private String encodeBasicAuthenticationString() {
        if (this.userId != null && this.password != null) {
            return "Basic " + BASE64Encoder.encode((String.valueOf(this.userId) + ":" + this.password).getBytes());
        }
        return null;
    }
    
    @Override
    public String getAuthorizationHeader(final HttpRequest req) {
        return this.basic;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BasicAuthorization)) {
            return false;
        }
        final BasicAuthorization that = (BasicAuthorization)o;
        return this.basic.equals(that.basic);
    }
    
    @Override
    public int hashCode() {
        return this.basic.hashCode();
    }
    
    @Override
    public String toString() {
        return "BasicAuthorization{userId='" + this.userId + '\'' + ", password='**********''" + '}';
    }
}
