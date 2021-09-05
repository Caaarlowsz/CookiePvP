package twitter4j;

import java.util.Arrays;
import twitter4j.conf.Configuration;
import java.util.Date;
import java.io.Serializable;

final class DirectMessageJSONImpl extends TwitterResponseImpl implements DirectMessage, Serializable
{
    private static final long serialVersionUID = 7092906238192790921L;
    private long id;
    private String text;
    private long senderId;
    private long recipientId;
    private Date createdAt;
    private String senderScreenName;
    private String recipientScreenName;
    private UserMentionEntity[] userMentionEntities;
    private URLEntity[] urlEntities;
    private HashtagEntity[] hashtagEntities;
    private MediaEntity[] mediaEntities;
    private ExtendedMediaEntity[] extendedMediaEntities;
    private SymbolEntity[] symbolEntities;
    private User sender;
    private User recipient;
    
    DirectMessageJSONImpl(final HttpResponse res, final Configuration conf) throws TwitterException {
        super(res);
        final JSONObject json = res.asJSONObject();
        this.init(json);
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, json);
        }
    }
    
    DirectMessageJSONImpl(final JSONObject json) throws TwitterException {
        this.init(json);
    }
    
    private void init(final JSONObject json) throws TwitterException {
        this.id = ParseUtil.getLong("id", json);
        this.senderId = ParseUtil.getLong("sender_id", json);
        this.recipientId = ParseUtil.getLong("recipient_id", json);
        this.createdAt = ParseUtil.getDate("created_at", json);
        this.senderScreenName = ParseUtil.getUnescapedString("sender_screen_name", json);
        this.recipientScreenName = ParseUtil.getUnescapedString("recipient_screen_name", json);
        try {
            this.sender = new UserJSONImpl(json.getJSONObject("sender"));
            this.recipient = new UserJSONImpl(json.getJSONObject("recipient"));
            if (!json.isNull("entities")) {
                final JSONObject entities = json.getJSONObject("entities");
                if (!entities.isNull("user_mentions")) {
                    final JSONArray userMentionsArray = entities.getJSONArray("user_mentions");
                    final int len = userMentionsArray.length();
                    this.userMentionEntities = new UserMentionEntity[len];
                    for (int i = 0; i < len; ++i) {
                        this.userMentionEntities[i] = new UserMentionEntityJSONImpl(userMentionsArray.getJSONObject(i));
                    }
                }
                if (!entities.isNull("urls")) {
                    final JSONArray urlsArray = entities.getJSONArray("urls");
                    final int len = urlsArray.length();
                    this.urlEntities = new URLEntity[len];
                    for (int i = 0; i < len; ++i) {
                        this.urlEntities[i] = new URLEntityJSONImpl(urlsArray.getJSONObject(i));
                    }
                }
                if (!entities.isNull("hashtags")) {
                    final JSONArray hashtagsArray = entities.getJSONArray("hashtags");
                    final int len = hashtagsArray.length();
                    this.hashtagEntities = new HashtagEntity[len];
                    for (int i = 0; i < len; ++i) {
                        this.hashtagEntities[i] = new HashtagEntityJSONImpl(hashtagsArray.getJSONObject(i));
                    }
                }
                if (!entities.isNull("symbols")) {
                    final JSONArray symbolsArray = entities.getJSONArray("symbols");
                    final int len = symbolsArray.length();
                    this.symbolEntities = new SymbolEntity[len];
                    for (int i = 0; i < len; ++i) {
                        this.symbolEntities[i] = new HashtagEntityJSONImpl(symbolsArray.getJSONObject(i));
                    }
                }
                if (!entities.isNull("media")) {
                    final JSONArray mediaArray = entities.getJSONArray("media");
                    final int len = mediaArray.length();
                    this.mediaEntities = new MediaEntity[len];
                    for (int i = 0; i < len; ++i) {
                        this.mediaEntities[i] = new MediaEntityJSONImpl(mediaArray.getJSONObject(i));
                    }
                }
            }
            this.userMentionEntities = ((this.userMentionEntities == null) ? new UserMentionEntity[0] : this.userMentionEntities);
            this.urlEntities = ((this.urlEntities == null) ? new URLEntity[0] : this.urlEntities);
            this.hashtagEntities = ((this.hashtagEntities == null) ? new HashtagEntity[0] : this.hashtagEntities);
            this.symbolEntities = ((this.symbolEntities == null) ? new SymbolEntity[0] : this.symbolEntities);
            this.mediaEntities = ((this.mediaEntities == null) ? new MediaEntity[0] : this.mediaEntities);
            this.extendedMediaEntities = ((this.extendedMediaEntities == null) ? new ExtendedMediaEntity[0] : this.extendedMediaEntities);
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(json.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public long getId() {
        return this.id;
    }
    
    @Override
    public String getText() {
        return this.text;
    }
    
    @Override
    public long getSenderId() {
        return this.senderId;
    }
    
    @Override
    public long getRecipientId() {
        return this.recipientId;
    }
    
    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    @Override
    public String getSenderScreenName() {
        return this.senderScreenName;
    }
    
    @Override
    public String getRecipientScreenName() {
        return this.recipientScreenName;
    }
    
    @Override
    public User getSender() {
        return this.sender;
    }
    
    @Override
    public User getRecipient() {
        return this.recipient;
    }
    
    @Override
    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }
    
    @Override
    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }
    
    @Override
    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }
    
    @Override
    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }
    
    @Override
    public ExtendedMediaEntity[] getExtendedMediaEntities() {
        return this.extendedMediaEntities;
    }
    
    @Override
    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }
    
    static ResponseList<DirectMessage> createDirectMessageList(final HttpResponse res, final Configuration conf) throws TwitterException {
        try {
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            final JSONArray list = res.asJSONArray();
            final int size = list.length();
            final ResponseList<DirectMessage> directMessages = new ResponseListImpl<DirectMessage>(size, res);
            for (int i = 0; i < size; ++i) {
                final JSONObject json = list.getJSONObject(i);
                final DirectMessage directMessage = new DirectMessageJSONImpl(json);
                directMessages.add(directMessage);
                if (conf.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(directMessage, json);
                }
            }
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(directMessages, list);
            }
            return directMessages;
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public int hashCode() {
        return (int)this.id;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj != null && (this == obj || (obj instanceof DirectMessage && ((DirectMessage)obj).getId() == this.id));
    }
    
    @Override
    public String toString() {
        return "DirectMessageJSONImpl{id=" + this.id + ", text='" + this.text + '\'' + ", sender_id=" + this.senderId + ", recipient_id=" + this.recipientId + ", created_at=" + this.createdAt + ", userMentionEntities=" + ((this.userMentionEntities == null) ? null : Arrays.asList(this.userMentionEntities)) + ", urlEntities=" + ((this.urlEntities == null) ? null : Arrays.asList(this.urlEntities)) + ", hashtagEntities=" + ((this.hashtagEntities == null) ? null : Arrays.asList(this.hashtagEntities)) + ", sender_screen_name='" + this.senderScreenName + '\'' + ", recipient_screen_name='" + this.recipientScreenName + '\'' + ", sender=" + this.sender + ", recipient=" + this.recipient + ", userMentionEntities=" + ((this.userMentionEntities == null) ? null : Arrays.asList(this.userMentionEntities)) + ", urlEntities=" + ((this.urlEntities == null) ? null : Arrays.asList(this.urlEntities)) + ", hashtagEntities=" + ((this.hashtagEntities == null) ? null : Arrays.asList(this.hashtagEntities)) + '}';
    }
}
