package twitter4j;

import twitter4j.conf.Configuration;
import java.util.Date;

final class SavedSearchJSONImpl extends TwitterResponseImpl implements SavedSearch
{
    private static final long serialVersionUID = -2281949861485441692L;
    private Date createdAt;
    private String query;
    private int position;
    private String name;
    private long id;
    
    SavedSearchJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
        super(res);
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        final JSONObject json = res.asJSONObject();
        this.init(json);
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, json);
        }
    }
    
    SavedSearchJSONImpl(final JSONObject savedSearch) throws TwitterException {
        this.init(savedSearch);
    }
    
    static ResponseList<SavedSearch> createSavedSearchList(final HttpResponse res, final Configuration conf) throws TwitterException {
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        final JSONArray json = res.asJSONArray();
        try {
            final ResponseList<SavedSearch> savedSearches = new ResponseListImpl<SavedSearch>(json.length(), res);
            for (int i = 0; i < json.length(); ++i) {
                final JSONObject savedSearchesJSON = json.getJSONObject(i);
                final SavedSearch savedSearch = new SavedSearchJSONImpl(savedSearchesJSON);
                savedSearches.add(savedSearch);
                if (conf.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(savedSearch, savedSearchesJSON);
                }
            }
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(savedSearches, json);
            }
            return savedSearches;
        }
        catch (JSONException jsone) {
            throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + res.asString(), jsone);
        }
    }
    
    private void init(final JSONObject savedSearch) throws TwitterException {
        this.createdAt = ParseUtil.getDate("created_at", savedSearch, "EEE MMM dd HH:mm:ss z yyyy");
        this.query = ParseUtil.getUnescapedString("query", savedSearch);
        this.position = ParseUtil.getInt("position", savedSearch);
        this.name = ParseUtil.getUnescapedString("name", savedSearch);
        this.id = ParseUtil.getLong("id", savedSearch);
    }
    
    @Override
    public int compareTo(final SavedSearch that) {
        return (int)(this.id - that.getId());
    }
    
    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    @Override
    public String getQuery() {
        return this.query;
    }
    
    @Override
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public long getId() {
        return this.id;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SavedSearch)) {
            return false;
        }
        final SavedSearch that = (SavedSearch)o;
        return this.id == that.getId();
    }
    
    @Override
    public int hashCode() {
        int result = this.createdAt.hashCode();
        result = 31 * result + this.query.hashCode();
        result = 31 * result + this.position;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + (int)this.id;
        return result;
    }
    
    @Override
    public String toString() {
        return "SavedSearchJSONImpl{createdAt=" + this.createdAt + ", query='" + this.query + '\'' + ", position=" + this.position + ", name='" + this.name + '\'' + ", id=" + this.id + '}';
    }
}
