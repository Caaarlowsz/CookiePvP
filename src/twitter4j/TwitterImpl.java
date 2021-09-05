package twitter4j;

import twitter4j.api.SpamReportingResource;
import twitter4j.api.TrendsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.ListsResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.UsersResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.TweetsResources;
import twitter4j.api.TimelinesResources;
import java.util.Map;
import twitter4j.api.HelpResources;
import java.util.Collection;
import java.util.Collections;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import java.util.concurrent.ConcurrentHashMap;

class TwitterImpl extends TwitterBaseImpl implements Twitter
{
    private static final long serialVersionUID = 9170943084096085770L;
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final HttpParameter INCLUDE_MY_RETWEET;
    private static final ConcurrentHashMap<Configuration, HttpParameter[]> implicitParamsMap;
    private static final ConcurrentHashMap<Configuration, String> implicitParamsStrMap;
    
    static {
        implicitParamsMap = new ConcurrentHashMap<Configuration, HttpParameter[]>();
        implicitParamsStrMap = new ConcurrentHashMap<Configuration, String>();
    }
    
    TwitterImpl(final Configuration conf, final Authorization auth) {
        super(conf, auth);
        this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", conf.isIncludeMyRetweetEnabled());
        if (TwitterImpl.implicitParamsMap.containsKey(conf)) {
            this.IMPLICIT_PARAMS = TwitterImpl.implicitParamsMap.get(conf);
            this.IMPLICIT_PARAMS_STR = TwitterImpl.implicitParamsStrMap.get(conf);
        }
        else {
            String implicitParamsStr = conf.isIncludeEntitiesEnabled() ? "include_entities=true" : "";
            final boolean contributorsEnabled = conf.getContributingTo() != -1L;
            if (contributorsEnabled) {
                if (!"".equals(implicitParamsStr)) {
                    implicitParamsStr = String.valueOf(implicitParamsStr) + "?";
                }
                implicitParamsStr = String.valueOf(implicitParamsStr) + "contributingto=" + conf.getContributingTo();
            }
            final List<HttpParameter> params = new ArrayList<HttpParameter>(3);
            if (conf.isIncludeEntitiesEnabled()) {
                params.add(new HttpParameter("include_entities", "true"));
            }
            if (contributorsEnabled) {
                params.add(new HttpParameter("contributingto", conf.getContributingTo()));
            }
            if (conf.isTrimUserEnabled()) {
                params.add(new HttpParameter("trim_user", "1"));
            }
            final HttpParameter[] implicitParams = params.toArray(new HttpParameter[params.size()]);
            TwitterImpl.implicitParamsStrMap.putIfAbsent(conf, implicitParamsStr);
            TwitterImpl.implicitParamsMap.putIfAbsent(conf, implicitParams);
            this.IMPLICIT_PARAMS = implicitParams;
            this.IMPLICIT_PARAMS_STR = implicitParamsStr;
        }
    }
    
    @Override
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/mentions_timeline.json"));
    }
    
    @Override
    public ResponseList<Status> getMentionsTimeline(final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/mentions_timeline.json", paging.asPostParameterArray()));
    }
    
    @Override
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/home_timeline.json", this.INCLUDE_MY_RETWEET));
    }
    
    @Override
    public ResponseList<Status> getHomeTimeline(final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/home_timeline.json", this.mergeParameters(paging.asPostParameterArray(), new HttpParameter[] { this.INCLUDE_MY_RETWEET })));
    }
    
    @Override
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/retweets_of_me.json"));
    }
    
    @Override
    public ResponseList<Status> getRetweetsOfMe(final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/retweets_of_me.json", paging.asPostParameterArray()));
    }
    
    @Override
    public ResponseList<Status> getUserTimeline(final String screenName, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/user_timeline.json", this.mergeParameters(new HttpParameter[] { new HttpParameter("screen_name", screenName), this.INCLUDE_MY_RETWEET }, paging.asPostParameterArray())));
    }
    
    @Override
    public ResponseList<Status> getUserTimeline(final long userId, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/user_timeline.json", this.mergeParameters(new HttpParameter[] { new HttpParameter("user_id", userId), this.INCLUDE_MY_RETWEET }, paging.asPostParameterArray())));
    }
    
    @Override
    public ResponseList<Status> getUserTimeline(final String screenName) throws TwitterException {
        return this.getUserTimeline(screenName, new Paging());
    }
    
    @Override
    public ResponseList<Status> getUserTimeline(final long userId) throws TwitterException {
        return this.getUserTimeline(userId, new Paging());
    }
    
    @Override
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return this.getUserTimeline(new Paging());
    }
    
    @Override
    public ResponseList<Status> getUserTimeline(final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/user_timeline.json", this.mergeParameters(new HttpParameter[] { this.INCLUDE_MY_RETWEET }, paging.asPostParameterArray())));
    }
    
    @Override
    public ResponseList<Status> getRetweets(final long statusId) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/retweets/" + statusId + ".json?count=100"));
    }
    
    @Override
    public IDs getRetweeterIds(final long statusId, final long cursor) throws TwitterException {
        return this.getRetweeterIds(statusId, 100, cursor);
    }
    
    @Override
    public IDs getRetweeterIds(final long statusId, final int count, final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/retweeters/ids.json?id=" + statusId + "&cursor=" + cursor + "&count=" + count));
    }
    
    @Override
    public Status showStatus(final long id) throws TwitterException {
        return this.factory.createStatus(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/show/" + id + ".json", this.INCLUDE_MY_RETWEET));
    }
    
    @Override
    public Status destroyStatus(final long statusId) throws TwitterException {
        return this.factory.createStatus(this.post(String.valueOf(this.conf.getRestBaseURL()) + "statuses/destroy/" + statusId + ".json"));
    }
    
    @Override
    public Status updateStatus(final String status) throws TwitterException {
        return this.factory.createStatus(this.post(String.valueOf(this.conf.getRestBaseURL()) + "statuses/update.json", new HttpParameter("status", status)));
    }
    
    @Override
    public Status updateStatus(final StatusUpdate status) throws TwitterException {
        final String url = String.valueOf(this.conf.getRestBaseURL()) + (status.isForUpdateWithMedia() ? "statuses/update_with_media.json" : "statuses/update.json");
        return this.factory.createStatus(this.post(url, status.asHttpParameterArray()));
    }
    
    @Override
    public Status retweetStatus(final long statusId) throws TwitterException {
        return this.factory.createStatus(this.post(String.valueOf(this.conf.getRestBaseURL()) + "statuses/retweet/" + statusId + ".json"));
    }
    
    @Override
    public OEmbed getOEmbed(final OEmbedRequest req) throws TwitterException {
        return this.factory.createOEmbed(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/oembed.json", req.asHttpParameterArray()));
    }
    
    @Override
    public ResponseList<Status> lookup(final long... ids) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "statuses/lookup.json?id=" + StringUtil.join(ids)));
    }
    
    @Override
    public UploadedMedia uploadMedia(final File image) throws TwitterException {
        this.checkFileValidity(image);
        return new UploadedMedia(this.post(String.valueOf(this.conf.getUploadBaseURL()) + "media/upload.json", new HttpParameter("media", image)).asJSONObject());
    }
    
    @Override
    public UploadedMedia uploadMedia(final String fileName, final InputStream image) throws TwitterException {
        return new UploadedMedia(this.post(String.valueOf(this.conf.getUploadBaseURL()) + "media/upload.json", new HttpParameter("media", fileName, image)).asJSONObject());
    }
    
    @Override
    public QueryResult search(final Query query) throws TwitterException {
        if (query.nextPage() != null) {
            return this.factory.createQueryResult(this.get(String.valueOf(this.conf.getRestBaseURL()) + "search/tweets.json" + query.nextPage()), query);
        }
        return this.factory.createQueryResult(this.get(String.valueOf(this.conf.getRestBaseURL()) + "search/tweets.json", query.asHttpParameterArray()), query);
    }
    
    @Override
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        return this.factory.createDirectMessageList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages.json?full_text=true"));
    }
    
    @Override
    public ResponseList<DirectMessage> getDirectMessages(final Paging paging) throws TwitterException {
        return this.factory.createDirectMessageList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages.json", this.mergeParameters(paging.asPostParameterArray(), new HttpParameter("full_text", true))));
    }
    
    @Override
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        return this.factory.createDirectMessageList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/sent.json?full_text=true"));
    }
    
    @Override
    public ResponseList<DirectMessage> getSentDirectMessages(final Paging paging) throws TwitterException {
        return this.factory.createDirectMessageList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/sent.json", this.mergeParameters(paging.asPostParameterArray(), new HttpParameter("full_text", true))));
    }
    
    @Override
    public DirectMessage showDirectMessage(final long id) throws TwitterException {
        return this.factory.createDirectMessage(this.get(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/show.json?id=" + id + "&full_text=true"));
    }
    
    @Override
    public DirectMessage destroyDirectMessage(final long id) throws TwitterException {
        return this.factory.createDirectMessage(this.post(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/destroy.json?id=" + id + "&full_text=true"));
    }
    
    @Override
    public DirectMessage sendDirectMessage(final long userId, final String text) throws TwitterException {
        return this.factory.createDirectMessage(this.post(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/new.json", new HttpParameter("user_id", userId), new HttpParameter("text", text), new HttpParameter("full_text", true)));
    }
    
    @Override
    public DirectMessage sendDirectMessage(final String screenName, final String text) throws TwitterException {
        return this.factory.createDirectMessage(this.post(String.valueOf(this.conf.getRestBaseURL()) + "direct_messages/new.json", new HttpParameter("screen_name", screenName), new HttpParameter("text", text), new HttpParameter("full_text", true)));
    }
    
    @Override
    public InputStream getDMImageAsStream(final String url) throws TwitterException {
        return this.get(url).asStream();
    }
    
    @Override
    public IDs getNoRetweetsFriendships() throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/no_retweets/ids.json"));
    }
    
    @Override
    public IDs getFriendsIDs(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/ids.json?cursor=" + cursor));
    }
    
    @Override
    public IDs getFriendsIDs(final long userId, final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/ids.json?user_id=" + userId + "&cursor=" + cursor));
    }
    
    @Override
    public IDs getFriendsIDs(final long userId, final long cursor, final int count) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/ids.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count));
    }
    
    @Override
    public IDs getFriendsIDs(final String screenName, final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/ids.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public IDs getFriendsIDs(final String screenName, final long cursor, final int count) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/ids.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count)));
    }
    
    @Override
    public IDs getFollowersIDs(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/ids.json?cursor=" + cursor));
    }
    
    @Override
    public IDs getFollowersIDs(final long userId, final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/ids.json?user_id=" + userId + "&cursor=" + cursor));
    }
    
    @Override
    public IDs getFollowersIDs(final long userId, final long cursor, final int count) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/ids.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count));
    }
    
    @Override
    public IDs getFollowersIDs(final String screenName, final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/ids.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public IDs getFollowersIDs(final String screenName, final long cursor, final int count) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/ids.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count)));
    }
    
    @Override
    public ResponseList<Friendship> lookupFriendships(final long... ids) throws TwitterException {
        return this.factory.createFriendshipList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/lookup.json?user_id=" + StringUtil.join(ids)));
    }
    
    @Override
    public ResponseList<Friendship> lookupFriendships(final String... screenNames) throws TwitterException {
        return this.factory.createFriendshipList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/lookup.json?screen_name=" + StringUtil.join(screenNames)));
    }
    
    @Override
    public IDs getIncomingFriendships(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/incoming.json?cursor=" + cursor));
    }
    
    @Override
    public IDs getOutgoingFriendships(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/outgoing.json?cursor=" + cursor));
    }
    
    @Override
    public User createFriendship(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/create.json?user_id=" + userId));
    }
    
    @Override
    public User createFriendship(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/create.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public User createFriendship(final long userId, final boolean follow) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/create.json?user_id=" + userId + "&follow=" + follow));
    }
    
    @Override
    public User createFriendship(final String screenName, final boolean follow) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/create.json", new HttpParameter("screen_name", screenName), new HttpParameter("follow", follow)));
    }
    
    @Override
    public User destroyFriendship(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/destroy.json?user_id=" + userId));
    }
    
    @Override
    public User destroyFriendship(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/destroy.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public Relationship updateFriendship(final long userId, final boolean enableDeviceNotification, final boolean retweets) throws TwitterException {
        return this.factory.createRelationship(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/update.json", new HttpParameter("user_id", userId), new HttpParameter("device", enableDeviceNotification), new HttpParameter("retweets", retweets)));
    }
    
    @Override
    public Relationship updateFriendship(final String screenName, final boolean enableDeviceNotification, final boolean retweets) throws TwitterException {
        return this.factory.createRelationship(this.post(String.valueOf(this.conf.getRestBaseURL()) + "friendships/update.json", new HttpParameter("screen_name", screenName), new HttpParameter("device", enableDeviceNotification), new HttpParameter("retweets", retweets)));
    }
    
    @Override
    public Relationship showFriendship(final long sourceId, final long targetId) throws TwitterException {
        return this.factory.createRelationship(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/show.json", new HttpParameter("source_id", sourceId), new HttpParameter("target_id", targetId)));
    }
    
    @Override
    public Relationship showFriendship(final String sourceScreenName, final String targetScreenName) throws TwitterException {
        return this.factory.createRelationship(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friendships/show.json", HttpParameter.getParameterArray("source_screen_name", sourceScreenName, "target_screen_name", targetScreenName)));
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final long userId, final long cursor) throws TwitterException {
        return this.getFriendsList(userId, cursor, 20);
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final long userId, final long cursor, final int count) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/list.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count));
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final String screenName, final long cursor) throws TwitterException {
        return this.getFriendsList(screenName, cursor, 20);
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final String screenName, final long cursor, final int count) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/list.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count)));
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final long userId, final long cursor, final int count, final boolean skipStatus, final boolean includeUserEntities) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/list.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count + "&skip_status=" + skipStatus + "&include_user_entities=" + includeUserEntities));
    }
    
    @Override
    public PagableResponseList<User> getFriendsList(final String screenName, final long cursor, final int count, final boolean skipStatus, final boolean includeUserEntities) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "friends/list.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count), new HttpParameter("skip_status", skipStatus), new HttpParameter("include_user_entities", includeUserEntities)));
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final long userId, final long cursor) throws TwitterException {
        return this.getFollowersList(userId, cursor, 20);
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final String screenName, final long cursor) throws TwitterException {
        return this.getFollowersList(screenName, cursor, 20);
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final long userId, final long cursor, final int count) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/list.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count));
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final String screenName, final long cursor, final int count) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/list.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count)));
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final long userId, final long cursor, final int count, final boolean skipStatus, final boolean includeUserEntities) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/list.json?user_id=" + userId + "&cursor=" + cursor + "&count=" + count + "&skip_status=" + skipStatus + "&include_user_entities=" + includeUserEntities));
    }
    
    @Override
    public PagableResponseList<User> getFollowersList(final String screenName, final long cursor, final int count, final boolean skipStatus, final boolean includeUserEntities) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "followers/list.json", new HttpParameter("screen_name", screenName), new HttpParameter("cursor", cursor), new HttpParameter("count", count), new HttpParameter("skip_status", skipStatus), new HttpParameter("include_user_entities", includeUserEntities)));
    }
    
    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        return this.factory.createAccountSettings(this.get(String.valueOf(this.conf.getRestBaseURL()) + "account/settings.json"));
    }
    
    @Override
    public User verifyCredentials() throws TwitterException {
        return super.fillInIDAndScreenName();
    }
    
    @Override
    public AccountSettings updateAccountSettings(final Integer trend_locationWoeid, final Boolean sleep_timeEnabled, final String start_sleepTime, final String end_sleepTime, final String time_zone, final String lang) throws TwitterException {
        final List<HttpParameter> profile = new ArrayList<HttpParameter>(6);
        if (trend_locationWoeid != null) {
            profile.add(new HttpParameter("trend_location_woeid", trend_locationWoeid));
        }
        if (sleep_timeEnabled != null) {
            profile.add(new HttpParameter("sleep_time_enabled", sleep_timeEnabled.toString()));
        }
        if (start_sleepTime != null) {
            profile.add(new HttpParameter("start_sleep_time", start_sleepTime));
        }
        if (end_sleepTime != null) {
            profile.add(new HttpParameter("end_sleep_time", end_sleepTime));
        }
        if (time_zone != null) {
            profile.add(new HttpParameter("time_zone", time_zone));
        }
        if (lang != null) {
            profile.add(new HttpParameter("lang", lang));
        }
        return this.factory.createAccountSettings(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/settings.json", (HttpParameter[])profile.toArray(new HttpParameter[profile.size()])));
    }
    
    @Override
    public User updateProfile(final String name, final String url, final String location, final String description) throws TwitterException {
        final List<HttpParameter> profile = new ArrayList<HttpParameter>(4);
        this.addParameterToList(profile, "name", name);
        this.addParameterToList(profile, "url", url);
        this.addParameterToList(profile, "location", location);
        this.addParameterToList(profile, "description", description);
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile.json", (HttpParameter[])profile.toArray(new HttpParameter[profile.size()])));
    }
    
    @Override
    public User updateProfileBackgroundImage(final File image, final boolean tile) throws TwitterException {
        this.checkFileValidity(image);
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_background_image.json", new HttpParameter("image", image), new HttpParameter("tile", tile)));
    }
    
    @Override
    public User updateProfileBackgroundImage(final InputStream image, final boolean tile) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_background_image.json", new HttpParameter("image", "image", image), new HttpParameter("tile", tile)));
    }
    
    @Override
    public User updateProfileColors(final String profileBackgroundColor, final String profileTextColor, final String profileLinkColor, final String profileSidebarFillColor, final String profileSidebarBorderColor) throws TwitterException {
        final List<HttpParameter> colors = new ArrayList<HttpParameter>(6);
        this.addParameterToList(colors, "profile_background_color", profileBackgroundColor);
        this.addParameterToList(colors, "profile_text_color", profileTextColor);
        this.addParameterToList(colors, "profile_link_color", profileLinkColor);
        this.addParameterToList(colors, "profile_sidebar_fill_color", profileSidebarFillColor);
        this.addParameterToList(colors, "profile_sidebar_border_color", profileSidebarBorderColor);
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_colors.json", (HttpParameter[])colors.toArray(new HttpParameter[colors.size()])));
    }
    
    private void addParameterToList(final List<HttpParameter> colors, final String paramName, final String color) {
        if (color != null) {
            colors.add(new HttpParameter(paramName, color));
        }
    }
    
    @Override
    public User updateProfileImage(final File image) throws TwitterException {
        this.checkFileValidity(image);
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_image.json", new HttpParameter("image", image)));
    }
    
    @Override
    public User updateProfileImage(final InputStream image) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_image.json", new HttpParameter("image", "image", image)));
    }
    
    private void checkFileValidity(final File image) throws TwitterException {
        if (!image.exists()) {
            throw new TwitterException(new FileNotFoundException(image + " is not found."));
        }
        if (!image.isFile()) {
            throw new TwitterException(new IOException(image + " is not a file."));
        }
    }
    
    @Override
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return this.getBlocksList(-1L);
    }
    
    @Override
    public PagableResponseList<User> getBlocksList(final long cursor) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "blocks/list.json?cursor=" + cursor));
    }
    
    @Override
    public IDs getBlocksIDs() throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "blocks/ids.json"));
    }
    
    @Override
    public IDs getBlocksIDs(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "blocks/ids.json?cursor=" + cursor));
    }
    
    @Override
    public User createBlock(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "blocks/create.json?user_id=" + userId));
    }
    
    @Override
    public User createBlock(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "blocks/create.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public User destroyBlock(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "blocks/destroy.json?user_id=" + userId));
    }
    
    @Override
    public User destroyBlock(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "blocks/destroy.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public PagableResponseList<User> getMutesList(final long cursor) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/list.json?cursor=" + cursor));
    }
    
    @Override
    public IDs getMutesIDs(final long cursor) throws TwitterException {
        return this.factory.createIDs(this.get(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/ids.json?cursor=" + cursor));
    }
    
    @Override
    public User createMute(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/create.json?user_id=" + userId));
    }
    
    @Override
    public User createMute(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/create.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public User destroyMute(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/destroy.json?user_id=" + userId));
    }
    
    @Override
    public User destroyMute(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "mutes/users/destroy.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public ResponseList<User> lookupUsers(final long... ids) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/lookup.json", new HttpParameter("user_id", StringUtil.join(ids))));
    }
    
    @Override
    public ResponseList<User> lookupUsers(final String... screenNames) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/lookup.json", new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public User showUser(final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/show.json?user_id=" + userId));
    }
    
    @Override
    public User showUser(final String screenName) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/show.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public ResponseList<User> searchUsers(final String query, final int page) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/search.json", new HttpParameter("q", query), new HttpParameter("per_page", 20), new HttpParameter("page", page)));
    }
    
    @Override
    public ResponseList<User> getContributees(final long userId) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/contributees.json?user_id=" + userId));
    }
    
    @Override
    public ResponseList<User> getContributees(final String screenName) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/contributees.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public ResponseList<User> getContributors(final long userId) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/contributors.json?user_id=" + userId));
    }
    
    @Override
    public ResponseList<User> getContributors(final String screenName) throws TwitterException {
        return this.factory.createUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/contributors.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public void removeProfileBanner() throws TwitterException {
        this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/remove_profile_banner.json");
    }
    
    @Override
    public void updateProfileBanner(final File image) throws TwitterException {
        this.checkFileValidity(image);
        this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_banner.json", new HttpParameter("banner", image));
    }
    
    @Override
    public void updateProfileBanner(final InputStream image) throws TwitterException {
        this.post(String.valueOf(this.conf.getRestBaseURL()) + "account/update_profile_banner.json", new HttpParameter("banner", "banner", image));
    }
    
    @Override
    public ResponseList<User> getUserSuggestions(final String categorySlug) throws TwitterException {
        HttpResponse res;
        try {
            res = this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/suggestions/" + URLEncoder.encode(categorySlug, "UTF-8") + ".json");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return this.factory.createUserListFromJSONArray_Users(res);
    }
    
    @Override
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return this.factory.createCategoryList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/suggestions.json"));
    }
    
    @Override
    public ResponseList<User> getMemberSuggestions(final String categorySlug) throws TwitterException {
        HttpResponse res;
        try {
            res = this.get(String.valueOf(this.conf.getRestBaseURL()) + "users/suggestions/" + URLEncoder.encode(categorySlug, "UTF-8") + "/members.json");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return this.factory.createUserListFromJSONArray(res);
    }
    
    @Override
    public ResponseList<Status> getFavorites() throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json"));
    }
    
    @Override
    public ResponseList<Status> getFavorites(final long userId) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json?user_id=" + userId));
    }
    
    @Override
    public ResponseList<Status> getFavorites(final String screenName) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public ResponseList<Status> getFavorites(final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json", paging.asPostParameterArray()));
    }
    
    @Override
    public ResponseList<Status> getFavorites(final long userId, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json", this.mergeParameters(new HttpParameter[] { new HttpParameter("user_id", userId) }, paging.asPostParameterArray())));
    }
    
    @Override
    public ResponseList<Status> getFavorites(final String screenName, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "favorites/list.json", this.mergeParameters(new HttpParameter[] { new HttpParameter("screen_name", screenName) }, paging.asPostParameterArray())));
    }
    
    @Override
    public Status destroyFavorite(final long id) throws TwitterException {
        return this.factory.createStatus(this.post(String.valueOf(this.conf.getRestBaseURL()) + "favorites/destroy.json?id=" + id));
    }
    
    @Override
    public Status createFavorite(final long id) throws TwitterException {
        return this.factory.createStatus(this.post(String.valueOf(this.conf.getRestBaseURL()) + "favorites/create.json?id=" + id));
    }
    
    @Override
    public ResponseList<UserList> getUserLists(final String listOwnerScreenName) throws TwitterException {
        return this.getUserLists(listOwnerScreenName, false);
    }
    
    @Override
    public ResponseList<UserList> getUserLists(final String listOwnerScreenName, final boolean reverse) throws TwitterException {
        return this.factory.createUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/list.json", new HttpParameter("screen_name", listOwnerScreenName), new HttpParameter("reverse", reverse)));
    }
    
    @Override
    public ResponseList<UserList> getUserLists(final long listOwnerUserId) throws TwitterException {
        return this.getUserLists(listOwnerUserId, false);
    }
    
    @Override
    public ResponseList<UserList> getUserLists(final long listOwnerUserId, final boolean reverse) throws TwitterException {
        return this.factory.createUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/list.json", new HttpParameter("user_id", listOwnerUserId), new HttpParameter("reverse", reverse)));
    }
    
    @Override
    public ResponseList<Status> getUserListStatuses(final long listId, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/statuses.json", this.mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter("list_id", listId))));
    }
    
    @Override
    public ResponseList<Status> getUserListStatuses(final long ownerId, final String slug, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/statuses.json", this.mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[] { new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug) })));
    }
    
    @Override
    public ResponseList<Status> getUserListStatuses(final String ownerScreenName, final String slug, final Paging paging) throws TwitterException {
        return this.factory.createStatusList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/statuses.json", this.mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[] { new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug) })));
    }
    
    @Override
    public UserList destroyUserListMember(final long listId, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy.json", new HttpParameter("list_id", listId), new HttpParameter("user_id", userId)));
    }
    
    @Override
    public UserList destroyUserListMember(final long ownerId, final String slug, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug), new HttpParameter("user_id", userId)));
    }
    
    @Override
    public UserList destroyUserListMember(final long listId, final String screenName) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy.json", new HttpParameter("list_id", listId), new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public UserList destroyUserListMember(final String ownerScreenName, final String slug, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("user_id", userId)));
    }
    
    @Override
    public UserList destroyUserListMembers(final long listId, final String[] screenNames) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy_all.json", new HttpParameter("list_id", listId), new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public UserList destroyUserListMembers(final long listId, final long[] userIds) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy_all.json", new HttpParameter("list_id", listId), new HttpParameter("user_id", StringUtil.join(userIds))));
    }
    
    @Override
    public UserList destroyUserListMembers(final String ownerScreenName, final String slug, final String[] screenNames) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/destroy_all.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final long cursor) throws TwitterException {
        return this.getUserListMemberships(20, cursor);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final int count, final long cursor) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/memberships.json", new HttpParameter("cursor", cursor), new HttpParameter("count", count)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final String listMemberScreenName, final long cursor) throws TwitterException {
        return this.getUserListMemberships(listMemberScreenName, cursor, false);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final String listMemberScreenName, final int count, final long cursor) throws TwitterException {
        return this.getUserListMemberships(listMemberScreenName, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final String listMemberScreenName, final long cursor, final boolean filterToOwnedLists) throws TwitterException {
        return this.getUserListMemberships(listMemberScreenName, 20, cursor, filterToOwnedLists);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final String listMemberScreenName, final int count, final long cursor, final boolean filterToOwnedLists) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/memberships.json", new HttpParameter("screen_name", listMemberScreenName), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("filter_to_owned_lists", filterToOwnedLists)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final long listMemberId, final long cursor) throws TwitterException {
        return this.getUserListMemberships(listMemberId, cursor, false);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final long listMemberId, final int count, final long cursor) throws TwitterException {
        return this.getUserListMemberships(listMemberId, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final long listMemberId, final long cursor, final boolean filterToOwnedLists) throws TwitterException {
        return this.getUserListMemberships(listMemberId, 20, cursor, filterToOwnedLists);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListMemberships(final long listMemberId, final int count, final long cursor, final boolean filterToOwnedLists) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/memberships.json", new HttpParameter("user_id", listMemberId), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("filter_to_owned_lists", filterToOwnedLists)));
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long listId, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(listId, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long listId, final int count, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(listId, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long listId, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers.json", new HttpParameter("list_id", listId), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long ownerId, final String slug, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(ownerId, slug, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long ownerId, final String slug, final int count, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(ownerId, slug, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final long ownerId, final String slug, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final String ownerScreenName, final String slug, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(ownerScreenName, slug, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final String ownerScreenName, final String slug, final int count, final long cursor) throws TwitterException {
        return this.getUserListSubscribers(ownerScreenName, slug, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListSubscribers(final String ownerScreenName, final String slug, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public UserList createUserListSubscription(final long listId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/create.json", new HttpParameter("list_id", listId)));
    }
    
    @Override
    public UserList createUserListSubscription(final long ownerId, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/create.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList createUserListSubscription(final String ownerScreenName, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/create.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug)));
    }
    
    @Override
    public User showUserListSubscription(final long listId, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/show.json?list_id=" + listId + "&user_id=" + userId));
    }
    
    @Override
    public User showUserListSubscription(final long ownerId, final String slug, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/show.json?owner_id=" + ownerId + "&slug=" + slug + "&user_id=" + userId));
    }
    
    @Override
    public User showUserListSubscription(final String ownerScreenName, final String slug, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/show.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("user_id", userId)));
    }
    
    @Override
    public UserList destroyUserListSubscription(final long listId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/destroy.json", new HttpParameter("list_id", listId)));
    }
    
    @Override
    public UserList destroyUserListSubscription(final long ownerId, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/destroy.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList destroyUserListSubscription(final String ownerScreenName, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscribers/destroy.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList createUserListMembers(final long listId, final long... userIds) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("list_id", listId), new HttpParameter("user_id", StringUtil.join(userIds))));
    }
    
    @Override
    public UserList createUserListMembers(final long ownerId, final String slug, final long... userIds) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug), new HttpParameter("user_id", StringUtil.join(userIds))));
    }
    
    @Override
    public UserList createUserListMembers(final String ownerScreenName, final String slug, final long... userIds) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("user_id", StringUtil.join(userIds))));
    }
    
    @Override
    public UserList createUserListMembers(final long listId, final String... screenNames) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("list_id", listId), new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public UserList createUserListMembers(final long ownerId, final String slug, final String... screenNames) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug), new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public UserList createUserListMembers(final String ownerScreenName, final String slug, final String... screenNames) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create_all.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("screen_name", StringUtil.join(screenNames))));
    }
    
    @Override
    public User showUserListMembership(final long listId, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/show.json?list_id=" + listId + "&user_id=" + userId));
    }
    
    @Override
    public User showUserListMembership(final long ownerId, final String slug, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/show.json?owner_id=" + ownerId + "&slug=" + slug + "&user_id=" + userId));
    }
    
    @Override
    public User showUserListMembership(final String ownerScreenName, final String slug, final long userId) throws TwitterException {
        return this.factory.createUser(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/show.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("user_id", userId)));
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long listId, final long cursor) throws TwitterException {
        return this.getUserListMembers(listId, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long listId, final int count, final long cursor) throws TwitterException {
        return this.getUserListMembers(listId, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long listId, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members.json", new HttpParameter("list_id", listId), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long ownerId, final String slug, final long cursor) throws TwitterException {
        return this.getUserListMembers(ownerId, slug, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long ownerId, final String slug, final int count, final long cursor) throws TwitterException {
        return this.getUserListMembers(ownerId, slug, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final long ownerId, final String slug, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final String ownerScreenName, final String slug, final long cursor) throws TwitterException {
        return this.getUserListMembers(ownerScreenName, slug, 20, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final String ownerScreenName, final String slug, final int count, final long cursor) throws TwitterException {
        return this.getUserListMembers(ownerScreenName, slug, count, cursor, false);
    }
    
    @Override
    public PagableResponseList<User> getUserListMembers(final String ownerScreenName, final String slug, final int count, final long cursor, final boolean skipStatus) throws TwitterException {
        return this.factory.createPagableUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/members.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug), new HttpParameter("count", count), new HttpParameter("cursor", cursor), new HttpParameter("skip_status", skipStatus)));
    }
    
    @Override
    public UserList createUserListMember(final long listId, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create.json", new HttpParameter("user_id", userId), new HttpParameter("list_id", listId)));
    }
    
    @Override
    public UserList createUserListMember(final long ownerId, final String slug, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create.json", new HttpParameter("user_id", userId), new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList createUserListMember(final String ownerScreenName, final String slug, final long userId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/members/create.json", new HttpParameter("user_id", userId), new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList destroyUserList(final long listId) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/destroy.json", new HttpParameter("list_id", listId)));
    }
    
    @Override
    public UserList destroyUserList(final long ownerId, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/destroy.json", new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList destroyUserList(final String ownerScreenName, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/destroy.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug)));
    }
    
    @Override
    public UserList updateUserList(final long listId, final String newListName, final boolean isPublicList, final String newDescription) throws TwitterException {
        return this.updateUserList(newListName, isPublicList, newDescription, new HttpParameter("list_id", listId));
    }
    
    @Override
    public UserList updateUserList(final long ownerId, final String slug, final String newListName, final boolean isPublicList, final String newDescription) throws TwitterException {
        return this.updateUserList(newListName, isPublicList, newDescription, new HttpParameter("owner_id", ownerId), new HttpParameter("slug", slug));
    }
    
    @Override
    public UserList updateUserList(final String ownerScreenName, final String slug, final String newListName, final boolean isPublicList, final String newDescription) throws TwitterException {
        return this.updateUserList(newListName, isPublicList, newDescription, new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug));
    }
    
    private UserList updateUserList(final String newListName, final boolean isPublicList, final String newDescription, final HttpParameter... params) throws TwitterException {
        final List<HttpParameter> httpParams = new ArrayList<HttpParameter>();
        Collections.addAll(httpParams, params);
        if (newListName != null) {
            httpParams.add(new HttpParameter("name", newListName));
        }
        httpParams.add(new HttpParameter("mode", isPublicList ? "public" : "private"));
        if (newDescription != null) {
            httpParams.add(new HttpParameter("description", newDescription));
        }
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/update.json", (HttpParameter[])httpParams.toArray(new HttpParameter[httpParams.size()])));
    }
    
    @Override
    public UserList createUserList(final String listName, final boolean isPublicList, final String description) throws TwitterException {
        final List<HttpParameter> httpParams = new ArrayList<HttpParameter>();
        httpParams.add(new HttpParameter("name", listName));
        httpParams.add(new HttpParameter("mode", isPublicList ? "public" : "private"));
        if (description != null) {
            httpParams.add(new HttpParameter("description", description));
        }
        return this.factory.createAUserList(this.post(String.valueOf(this.conf.getRestBaseURL()) + "lists/create.json", (HttpParameter[])httpParams.toArray(new HttpParameter[httpParams.size()])));
    }
    
    @Override
    public UserList showUserList(final long listId) throws TwitterException {
        return this.factory.createAUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/show.json?list_id=" + listId));
    }
    
    @Override
    public UserList showUserList(final long ownerId, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/show.json?owner_id=" + ownerId + "&slug=" + slug));
    }
    
    @Override
    public UserList showUserList(final String ownerScreenName, final String slug) throws TwitterException {
        return this.factory.createAUserList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/show.json", new HttpParameter("owner_screen_name", ownerScreenName), new HttpParameter("slug", slug)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(final String listSubscriberScreenName, final long cursor) throws TwitterException {
        return this.getUserListSubscriptions(listSubscriberScreenName, 20, cursor);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(final String listSubscriberScreenName, final int count, final long cursor) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscriptions.json", new HttpParameter("screen_name", listSubscriberScreenName), new HttpParameter("count", count), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(final long listSubscriberId, final long cursor) throws TwitterException {
        return this.getUserListSubscriptions(listSubscriberId, 20, cursor);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(final long listSubscriberId, final int count, final long cursor) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/subscriptions.json", new HttpParameter("user_id", listSubscriberId), new HttpParameter("count", count), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(final String listOwnerScreenName, final long cursor) throws TwitterException {
        return this.getUserListsOwnerships(listOwnerScreenName, 20, cursor);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(final String listOwnerScreenName, final int count, final long cursor) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/ownerships.json", new HttpParameter("screen_name", listOwnerScreenName), new HttpParameter("count", count), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(final long listOwnerId, final long cursor) throws TwitterException {
        return this.getUserListsOwnerships(listOwnerId, 20, cursor);
    }
    
    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(final long listOwnerId, final int count, final long cursor) throws TwitterException {
        return this.factory.createPagableUserListList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "lists/ownerships.json", new HttpParameter("user_id", listOwnerId), new HttpParameter("count", count), new HttpParameter("cursor", cursor)));
    }
    
    @Override
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return this.factory.createSavedSearchList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "saved_searches/list.json"));
    }
    
    @Override
    public SavedSearch showSavedSearch(final long id) throws TwitterException {
        return this.factory.createSavedSearch(this.get(String.valueOf(this.conf.getRestBaseURL()) + "saved_searches/show/" + id + ".json"));
    }
    
    @Override
    public SavedSearch createSavedSearch(final String query) throws TwitterException {
        return this.factory.createSavedSearch(this.post(String.valueOf(this.conf.getRestBaseURL()) + "saved_searches/create.json", new HttpParameter("query", query)));
    }
    
    @Override
    public SavedSearch destroySavedSearch(final long id) throws TwitterException {
        return this.factory.createSavedSearch(this.post(String.valueOf(this.conf.getRestBaseURL()) + "saved_searches/destroy/" + id + ".json"));
    }
    
    @Override
    public Place getGeoDetails(final String placeId) throws TwitterException {
        return this.factory.createPlace(this.get(String.valueOf(this.conf.getRestBaseURL()) + "geo/id/" + placeId + ".json"));
    }
    
    @Override
    public ResponseList<Place> reverseGeoCode(final GeoQuery query) throws TwitterException {
        try {
            return this.factory.createPlaceList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "geo/reverse_geocode.json", query.asHttpParameterArray()));
        }
        catch (TwitterException te) {
            if (te.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw te;
        }
    }
    
    @Override
    public ResponseList<Place> searchPlaces(final GeoQuery query) throws TwitterException {
        return this.factory.createPlaceList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "geo/search.json", query.asHttpParameterArray()));
    }
    
    @Override
    public ResponseList<Place> getSimilarPlaces(final GeoLocation location, final String name, final String containedWithin, final String streetAddress) throws TwitterException {
        final List<HttpParameter> params = new ArrayList<HttpParameter>(3);
        params.add(new HttpParameter("lat", location.getLatitude()));
        params.add(new HttpParameter("long", location.getLongitude()));
        params.add(new HttpParameter("name", name));
        if (containedWithin != null) {
            params.add(new HttpParameter("contained_within", containedWithin));
        }
        if (streetAddress != null) {
            params.add(new HttpParameter("attribute:street_address", streetAddress));
        }
        return this.factory.createPlaceList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "geo/similar_places.json", (HttpParameter[])params.toArray(new HttpParameter[params.size()])));
    }
    
    @Override
    public Trends getPlaceTrends(final int woeid) throws TwitterException {
        return this.factory.createTrends(this.get(String.valueOf(this.conf.getRestBaseURL()) + "trends/place.json?id=" + woeid));
    }
    
    @Override
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return this.factory.createLocationList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "trends/available.json"));
    }
    
    @Override
    public ResponseList<Location> getClosestTrends(final GeoLocation location) throws TwitterException {
        return this.factory.createLocationList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "trends/closest.json", new HttpParameter("lat", location.getLatitude()), new HttpParameter("long", location.getLongitude())));
    }
    
    @Override
    public User reportSpam(final long userId) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "users/report_spam.json?user_id=" + userId));
    }
    
    @Override
    public User reportSpam(final String screenName) throws TwitterException {
        return this.factory.createUser(this.post(String.valueOf(this.conf.getRestBaseURL()) + "users/report_spam.json", new HttpParameter("screen_name", screenName)));
    }
    
    @Override
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return this.factory.createTwitterAPIConfiguration(this.get(String.valueOf(this.conf.getRestBaseURL()) + "help/configuration.json"));
    }
    
    @Override
    public ResponseList<HelpResources.Language> getLanguages() throws TwitterException {
        return this.factory.createLanguageList(this.get(String.valueOf(this.conf.getRestBaseURL()) + "help/languages.json"));
    }
    
    @Override
    public String getPrivacyPolicy() throws TwitterException {
        try {
            return this.get(String.valueOf(this.conf.getRestBaseURL()) + "help/privacy.json").asJSONObject().getString("privacy");
        }
        catch (JSONException e) {
            throw new TwitterException(e);
        }
    }
    
    @Override
    public String getTermsOfService() throws TwitterException {
        try {
            return this.get(String.valueOf(this.conf.getRestBaseURL()) + "help/tos.json").asJSONObject().getString("tos");
        }
        catch (JSONException e) {
            throw new TwitterException(e);
        }
    }
    
    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        return this.factory.createRateLimitStatuses(this.get(String.valueOf(this.conf.getRestBaseURL()) + "application/rate_limit_status.json"));
    }
    
    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus(final String... resources) throws TwitterException {
        return this.factory.createRateLimitStatuses(this.get(String.valueOf(this.conf.getRestBaseURL()) + "application/rate_limit_status.json?resources=" + StringUtil.join(resources)));
    }
    
    @Override
    public TimelinesResources timelines() {
        return this;
    }
    
    @Override
    public TweetsResources tweets() {
        return this;
    }
    
    @Override
    public SearchResource search() {
        return this;
    }
    
    @Override
    public DirectMessagesResources directMessages() {
        return this;
    }
    
    @Override
    public FriendsFollowersResources friendsFollowers() {
        return this;
    }
    
    @Override
    public UsersResources users() {
        return this;
    }
    
    @Override
    public SuggestedUsersResources suggestedUsers() {
        return this;
    }
    
    @Override
    public FavoritesResources favorites() {
        return this;
    }
    
    @Override
    public ListsResources list() {
        return this;
    }
    
    @Override
    public SavedSearchesResources savedSearches() {
        return this;
    }
    
    @Override
    public PlacesGeoResources placesGeo() {
        return this;
    }
    
    @Override
    public TrendsResources trends() {
        return this;
    }
    
    @Override
    public SpamReportingResource spamReporting() {
        return this;
    }
    
    @Override
    public HelpResources help() {
        return this;
    }
    
    private HttpResponse get(String url) throws TwitterException {
        this.ensureAuthorizationEnabled();
        if (this.IMPLICIT_PARAMS_STR.length() > 0) {
            if (url.contains("?")) {
                url = String.valueOf(url) + "&" + this.IMPLICIT_PARAMS_STR;
            }
            else {
                url = String.valueOf(url) + "?" + this.IMPLICIT_PARAMS_STR;
            }
        }
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(url, null, this.auth, this);
        }
        HttpResponse response = null;
        final long start = System.currentTimeMillis();
        try {
            response = this.http.get(url, null, this.auth, this);
        }
        finally {
            final long elapsedTime = System.currentTimeMillis() - start;
            TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        }
        final long elapsedTime = System.currentTimeMillis() - start;
        TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        return response;
    }
    
    private HttpResponse get(final String url, final HttpParameter... params) throws TwitterException {
        this.ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(url, this.mergeImplicitParams(params), this.auth, this);
        }
        HttpResponse response = null;
        final long start = System.currentTimeMillis();
        try {
            response = this.http.get(url, this.mergeImplicitParams(params), this.auth, this);
        }
        finally {
            final long elapsedTime = System.currentTimeMillis() - start;
            TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        }
        final long elapsedTime = System.currentTimeMillis() - start;
        TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        return response;
    }
    
    private HttpResponse post(final String url) throws TwitterException {
        this.ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(url, this.IMPLICIT_PARAMS, this.auth, this);
        }
        HttpResponse response = null;
        final long start = System.currentTimeMillis();
        try {
            response = this.http.post(url, this.IMPLICIT_PARAMS, this.auth, this);
        }
        finally {
            final long elapsedTime = System.currentTimeMillis() - start;
            TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        }
        final long elapsedTime = System.currentTimeMillis() - start;
        TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        return response;
    }
    
    private HttpResponse post(final String url, final HttpParameter... params) throws TwitterException {
        this.ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(url, this.mergeImplicitParams(params), this.auth, this);
        }
        HttpResponse response = null;
        final long start = System.currentTimeMillis();
        try {
            response = this.http.post(url, this.mergeImplicitParams(params), this.auth, this);
        }
        finally {
            final long elapsedTime = System.currentTimeMillis() - start;
            TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        }
        final long elapsedTime = System.currentTimeMillis() - start;
        TwitterAPIMonitor.getInstance().methodCalled(url, elapsedTime, this.isOk(response));
        return response;
    }
    
    private HttpParameter[] mergeParameters(final HttpParameter[] params1, final HttpParameter[] params2) {
        if (params1 != null && params2 != null) {
            final HttpParameter[] params3 = new HttpParameter[params1.length + params2.length];
            System.arraycopy(params1, 0, params3, 0, params1.length);
            System.arraycopy(params2, 0, params3, params1.length, params2.length);
            return params3;
        }
        if (params1 == null && params2 == null) {
            return new HttpParameter[0];
        }
        if (params1 != null) {
            return params1;
        }
        return params2;
    }
    
    private HttpParameter[] mergeParameters(final HttpParameter[] params1, final HttpParameter params2) {
        if (params1 != null && params2 != null) {
            final HttpParameter[] params3 = new HttpParameter[params1.length + 1];
            System.arraycopy(params1, 0, params3, 0, params1.length);
            params3[params3.length - 1] = params2;
            return params3;
        }
        if (params1 == null && params2 == null) {
            return new HttpParameter[0];
        }
        if (params1 != null) {
            return params1;
        }
        return new HttpParameter[] { params2 };
    }
    
    private HttpParameter[] mergeImplicitParams(final HttpParameter... params) {
        return this.mergeParameters(params, this.IMPLICIT_PARAMS);
    }
    
    private boolean isOk(final HttpResponse response) {
        return response != null && response.getStatusCode() < 300;
    }
    
    @Override
    public String toString() {
        return "TwitterImpl{INCLUDE_MY_RETWEET=" + this.INCLUDE_MY_RETWEET + '}';
    }
}
