package twitter4j;

import java.util.ArrayList;

class ResponseListImpl<T> extends ArrayList<T> implements ResponseList<T>
{
    private static final long serialVersionUID = 9105950888010803544L;
    private transient RateLimitStatus rateLimitStatus;
    private transient int accessLevel;
    
    ResponseListImpl(final HttpResponse res) {
        this.rateLimitStatus = null;
        this.init(res);
    }
    
    ResponseListImpl(final int size, final HttpResponse res) {
        super(size);
        this.rateLimitStatus = null;
        this.init(res);
    }
    
    ResponseListImpl(final RateLimitStatus rateLimitStatus, final int accessLevel) {
        this.rateLimitStatus = null;
        this.rateLimitStatus = rateLimitStatus;
        this.accessLevel = accessLevel;
    }
    
    private void init(final HttpResponse res) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(res);
        this.accessLevel = ParseUtil.toAccessLevel(res);
    }
    
    @Override
    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }
    
    @Override
    public int getAccessLevel() {
        return this.accessLevel;
    }
}
