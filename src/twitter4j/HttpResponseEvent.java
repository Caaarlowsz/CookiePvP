package twitter4j;

public final class HttpResponseEvent
{
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;
    
    HttpResponseEvent(final HttpRequest request, final HttpResponse response, final TwitterException te) {
        this.request = request;
        this.response = response;
        this.twitterException = te;
    }
    
    public HttpRequest getRequest() {
        return this.request;
    }
    
    public HttpResponse getResponse() {
        return this.response;
    }
    
    public TwitterException getTwitterException() {
        return this.twitterException;
    }
    
    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final HttpResponseEvent that = (HttpResponseEvent)o;
        Label_0062: {
            if (this.request != null) {
                if (this.request.equals(that.request)) {
                    break Label_0062;
                }
            }
            else if (that.request == null) {
                break Label_0062;
            }
            return false;
        }
        if (this.response != null) {
            if (this.response.equals(that.response)) {
                return true;
            }
        }
        else if (that.response == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (this.request != null) ? this.request.hashCode() : 0;
        result = 31 * result + ((this.response != null) ? this.response.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "HttpResponseEvent{request=" + this.request + ", response=" + this.response + '}';
    }
}
