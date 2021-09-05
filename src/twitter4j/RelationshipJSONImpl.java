package twitter4j;

import twitter4j.conf.Configuration;
import java.io.Serializable;

class RelationshipJSONImpl extends TwitterResponseImpl implements Relationship, Serializable
{
    private static final long serialVersionUID = -2001484553401916448L;
    private final long targetUserId;
    private final String targetUserScreenName;
    private final boolean sourceBlockingTarget;
    private final boolean sourceNotificationsEnabled;
    private final boolean sourceFollowingTarget;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceCanDm;
    private final boolean sourceMutingTarget;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private boolean wantRetweets;
    
    RelationshipJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
        this(res, res.asJSONObject());
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
        }
    }
    
    RelationshipJSONImpl(final JSONObject json) throws TwitterException {
        this(null, json);
    }
    
    RelationshipJSONImpl(final HttpResponse res, final JSONObject json) throws TwitterException {
        super(res);
        try {
            final JSONObject relationship = json.getJSONObject("relationship");
            final JSONObject sourceJson = relationship.getJSONObject("source");
            final JSONObject targetJson = relationship.getJSONObject("target");
            this.sourceUserId = ParseUtil.getLong("id", sourceJson);
            this.targetUserId = ParseUtil.getLong("id", targetJson);
            this.sourceUserScreenName = ParseUtil.getUnescapedString("screen_name", sourceJson);
            this.targetUserScreenName = ParseUtil.getUnescapedString("screen_name", targetJson);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", sourceJson);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", sourceJson);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", sourceJson);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", sourceJson);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", sourceJson);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", sourceJson);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", sourceJson);
        }
        catch (JSONException jsone) {
            throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
        }
    }
    
    static ResponseList<Relationship> createRelationshipList(final HttpResponse res, final Configuration conf) throws TwitterException {
        try {
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            final JSONArray list = res.asJSONArray();
            final int size = list.length();
            final ResponseList<Relationship> relationships = new ResponseListImpl<Relationship>(size, res);
            for (int i = 0; i < size; ++i) {
                final JSONObject json = list.getJSONObject(i);
                final Relationship relationship = new RelationshipJSONImpl(json);
                if (conf.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(relationship, json);
                }
                relationships.add(relationship);
            }
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(relationships, list);
            }
            return relationships;
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public long getSourceUserId() {
        return this.sourceUserId;
    }
    
    @Override
    public long getTargetUserId() {
        return this.targetUserId;
    }
    
    @Override
    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }
    
    @Override
    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }
    
    @Override
    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }
    
    @Override
    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }
    
    @Override
    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }
    
    @Override
    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }
    
    @Override
    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }
    
    @Override
    public boolean canSourceDm() {
        return this.sourceCanDm;
    }
    
    @Override
    public boolean isSourceMutingTarget() {
        return this.sourceMutingTarget;
    }
    
    @Override
    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }
    
    @Override
    public boolean isSourceWantRetweets() {
        return this.wantRetweets;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final RelationshipJSONImpl that = (RelationshipJSONImpl)o;
        if (this.sourceBlockingTarget != that.sourceBlockingTarget) {
            return false;
        }
        if (this.sourceCanDm != that.sourceCanDm) {
            return false;
        }
        if (this.sourceFollowedByTarget != that.sourceFollowedByTarget) {
            return false;
        }
        if (this.sourceFollowingTarget != that.sourceFollowingTarget) {
            return false;
        }
        if (this.sourceMutingTarget != that.sourceMutingTarget) {
            return false;
        }
        if (this.sourceNotificationsEnabled != that.sourceNotificationsEnabled) {
            return false;
        }
        if (this.sourceUserId != that.sourceUserId) {
            return false;
        }
        if (this.targetUserId != that.targetUserId) {
            return false;
        }
        if (this.wantRetweets != that.wantRetweets) {
            return false;
        }
        Label_0181: {
            if (this.sourceUserScreenName != null) {
                if (this.sourceUserScreenName.equals(that.sourceUserScreenName)) {
                    break Label_0181;
                }
            }
            else if (that.sourceUserScreenName == null) {
                break Label_0181;
            }
            return false;
        }
        if (this.targetUserScreenName != null) {
            if (this.targetUserScreenName.equals(that.targetUserScreenName)) {
                return true;
            }
        }
        else if (that.targetUserScreenName == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (int)(this.targetUserId ^ this.targetUserId >>> 32);
        result = 31 * result + ((this.targetUserScreenName != null) ? this.targetUserScreenName.hashCode() : 0);
        result = 31 * result + (this.sourceBlockingTarget ? 1 : 0);
        result = 31 * result + (this.sourceNotificationsEnabled ? 1 : 0);
        result = 31 * result + (this.sourceFollowingTarget ? 1 : 0);
        result = 31 * result + (this.sourceFollowedByTarget ? 1 : 0);
        result = 31 * result + (this.sourceCanDm ? 1 : 0);
        result = 31 * result + (this.sourceMutingTarget ? 1 : 0);
        result = 31 * result + (int)(this.sourceUserId ^ this.sourceUserId >>> 32);
        result = 31 * result + ((this.sourceUserScreenName != null) ? this.sourceUserScreenName.hashCode() : 0);
        result = 31 * result + (this.wantRetweets ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "RelationshipJSONImpl{targetUserId=" + this.targetUserId + ", targetUserScreenName='" + this.targetUserScreenName + '\'' + ", sourceBlockingTarget=" + this.sourceBlockingTarget + ", sourceNotificationsEnabled=" + this.sourceNotificationsEnabled + ", sourceFollowingTarget=" + this.sourceFollowingTarget + ", sourceFollowedByTarget=" + this.sourceFollowedByTarget + ", sourceCanDm=" + this.sourceCanDm + ", sourceMutingTarget=" + this.sourceMutingTarget + ", sourceUserId=" + this.sourceUserId + ", sourceUserScreenName='" + this.sourceUserScreenName + '\'' + ", wantRetweets=" + this.wantRetweets + '}';
    }
}
