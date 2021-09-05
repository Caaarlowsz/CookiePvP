package twitter4j.auth;

import java.io.ObjectStreamException;
import twitter4j.HttpRequest;
import java.io.Serializable;

public class NullAuthorization implements Authorization, Serializable
{
    private static final long serialVersionUID = -7704668493278727510L;
    private static final NullAuthorization SINGLETON;
    
    static {
        SINGLETON = new NullAuthorization();
    }
    
    private NullAuthorization() {
    }
    
    public static NullAuthorization getInstance() {
        return NullAuthorization.SINGLETON;
    }
    
    @Override
    public String getAuthorizationHeader(final HttpRequest req) {
        return null;
    }
    
    @Override
    public boolean isEnabled() {
        return false;
    }
    
    @Override
    public boolean equals(final Object o) {
        return NullAuthorization.SINGLETON == o;
    }
    
    @Override
    public String toString() {
        return "NullAuthentication{SINGLETON}";
    }
    
    private Object readResolve() throws ObjectStreamException {
        return NullAuthorization.SINGLETON;
    }
}
