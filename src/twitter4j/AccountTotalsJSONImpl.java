package twitter4j;

import twitter4j.conf.Configuration;
import java.io.Serializable;

class AccountTotalsJSONImpl extends TwitterResponseImpl implements AccountTotals, Serializable
{
    private static final long serialVersionUID = 4199733699237229892L;
    private final int updates;
    private final int followers;
    private final int favorites;
    private final int friends;
    
    private AccountTotalsJSONImpl(final HttpResponse res, final JSONObject json) {
        super(res);
        this.updates = ParseUtil.getInt("updates", json);
        this.followers = ParseUtil.getInt("followers", json);
        this.favorites = ParseUtil.getInt("favorites", json);
        this.friends = ParseUtil.getInt("friends", json);
    }
    
    AccountTotalsJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
        this(res, res.asJSONObject());
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
        }
    }
    
    AccountTotalsJSONImpl(final JSONObject json) throws TwitterException {
        this(null, json);
    }
    
    @Override
    public int getUpdates() {
        return this.updates;
    }
    
    @Override
    public int getFollowers() {
        return this.followers;
    }
    
    @Override
    public int getFavorites() {
        return this.favorites;
    }
    
    @Override
    public int getFriends() {
        return this.friends;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final AccountTotalsJSONImpl that = (AccountTotalsJSONImpl)o;
        return this.favorites == that.favorites && this.followers == that.followers && this.friends == that.friends && this.updates == that.updates;
    }
    
    @Override
    public int hashCode() {
        int result = this.updates;
        result = 31 * result + this.followers;
        result = 31 * result + this.favorites;
        result = 31 * result + this.friends;
        return result;
    }
    
    @Override
    public String toString() {
        return "AccountTotalsJSONImpl{updates=" + this.updates + ", followers=" + this.followers + ", favorites=" + this.favorites + ", friends=" + this.friends + '}';
    }
}
