package twitter4j;

import java.io.Serializable;
import java.util.Map;

import twitter4j.api.HelpResources;

interface ObjectFactory extends Serializable {
	Status createStatus(final JSONObject p0) throws TwitterException;

	User createUser(final JSONObject p0) throws TwitterException;

	UserList createAUserList(final JSONObject p0) throws TwitterException;

	Map<String, RateLimitStatus> createRateLimitStatuses(final HttpResponse p0) throws TwitterException;

	Status createStatus(final HttpResponse p0) throws TwitterException;

	ResponseList<Status> createStatusList(final HttpResponse p0) throws TwitterException;

	Trends createTrends(final HttpResponse p0) throws TwitterException;

	User createUser(final HttpResponse p0) throws TwitterException;

	ResponseList<User> createUserList(final HttpResponse p0) throws TwitterException;

	ResponseList<User> createUserListFromJSONArray(final HttpResponse p0) throws TwitterException;

	ResponseList<User> createUserListFromJSONArray_Users(final HttpResponse p0) throws TwitterException;

	QueryResult createQueryResult(final HttpResponse p0, final Query p1) throws TwitterException;

	IDs createIDs(final HttpResponse p0) throws TwitterException;

	PagableResponseList<User> createPagableUserList(final HttpResponse p0) throws TwitterException;

	UserList createAUserList(final HttpResponse p0) throws TwitterException;

	PagableResponseList<UserList> createPagableUserListList(final HttpResponse p0) throws TwitterException;

	ResponseList<UserList> createUserListList(final HttpResponse p0) throws TwitterException;

	ResponseList<Category> createCategoryList(final HttpResponse p0) throws TwitterException;

	DirectMessage createDirectMessage(final HttpResponse p0) throws TwitterException;

	ResponseList<DirectMessage> createDirectMessageList(final HttpResponse p0) throws TwitterException;

	Relationship createRelationship(final HttpResponse p0) throws TwitterException;

	ResponseList<Friendship> createFriendshipList(final HttpResponse p0) throws TwitterException;

	AccountTotals createAccountTotals(final HttpResponse p0) throws TwitterException;

	AccountSettings createAccountSettings(final HttpResponse p0) throws TwitterException;

	SavedSearch createSavedSearch(final HttpResponse p0) throws TwitterException;

	ResponseList<SavedSearch> createSavedSearchList(final HttpResponse p0) throws TwitterException;

	ResponseList<Location> createLocationList(final HttpResponse p0) throws TwitterException;

	Place createPlace(final HttpResponse p0) throws TwitterException;

	ResponseList<Place> createPlaceList(final HttpResponse p0) throws TwitterException;

	TwitterAPIConfiguration createTwitterAPIConfiguration(final HttpResponse p0) throws TwitterException;

	ResponseList<HelpResources.Language> createLanguageList(final HttpResponse p0) throws TwitterException;

	<T> ResponseList<T> createEmptyResponseList();

	OEmbed createOEmbed(final HttpResponse p0) throws TwitterException;
}
