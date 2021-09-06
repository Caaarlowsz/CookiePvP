package twitter4j.api;

import twitter4j.Friendship;
import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

public interface FriendsFollowersResources {
	IDs getNoRetweetsFriendships() throws TwitterException;

	IDs getFriendsIDs(final long p0) throws TwitterException;

	IDs getFriendsIDs(final long p0, final long p1) throws TwitterException;

	IDs getFriendsIDs(final long p0, final long p1, final int p2) throws TwitterException;

	IDs getFriendsIDs(final String p0, final long p1) throws TwitterException;

	IDs getFriendsIDs(final String p0, final long p1, final int p2) throws TwitterException;

	IDs getFollowersIDs(final long p0) throws TwitterException;

	IDs getFollowersIDs(final long p0, final long p1) throws TwitterException;

	IDs getFollowersIDs(final long p0, final long p1, final int p2) throws TwitterException;

	IDs getFollowersIDs(final String p0, final long p1) throws TwitterException;

	IDs getFollowersIDs(final String p0, final long p1, final int p2) throws TwitterException;

	ResponseList<Friendship> lookupFriendships(final long... p0) throws TwitterException;

	ResponseList<Friendship> lookupFriendships(final String... p0) throws TwitterException;

	IDs getIncomingFriendships(final long p0) throws TwitterException;

	IDs getOutgoingFriendships(final long p0) throws TwitterException;

	User createFriendship(final long p0) throws TwitterException;

	User createFriendship(final String p0) throws TwitterException;

	User createFriendship(final long p0, final boolean p1) throws TwitterException;

	User createFriendship(final String p0, final boolean p1) throws TwitterException;

	User destroyFriendship(final long p0) throws TwitterException;

	User destroyFriendship(final String p0) throws TwitterException;

	Relationship updateFriendship(final long p0, final boolean p1, final boolean p2) throws TwitterException;

	Relationship updateFriendship(final String p0, final boolean p1, final boolean p2) throws TwitterException;

	Relationship showFriendship(final long p0, final long p1) throws TwitterException;

	Relationship showFriendship(final String p0, final String p1) throws TwitterException;

	PagableResponseList<User> getFriendsList(final long p0, final long p1) throws TwitterException;

	PagableResponseList<User> getFriendsList(final long p0, final long p1, final int p2) throws TwitterException;

	PagableResponseList<User> getFriendsList(final String p0, final long p1) throws TwitterException;

	PagableResponseList<User> getFriendsList(final String p0, final long p1, final int p2) throws TwitterException;

	PagableResponseList<User> getFriendsList(final long p0, final long p1, final int p2, final boolean p3,
			final boolean p4) throws TwitterException;

	PagableResponseList<User> getFriendsList(final String p0, final long p1, final int p2, final boolean p3,
			final boolean p4) throws TwitterException;

	PagableResponseList<User> getFollowersList(final long p0, final long p1) throws TwitterException;

	PagableResponseList<User> getFollowersList(final String p0, final long p1) throws TwitterException;

	PagableResponseList<User> getFollowersList(final long p0, final long p1, final int p2) throws TwitterException;

	PagableResponseList<User> getFollowersList(final String p0, final long p1, final int p2) throws TwitterException;

	PagableResponseList<User> getFollowersList(final long p0, final long p1, final int p2, final boolean p3,
			final boolean p4) throws TwitterException;

	PagableResponseList<User> getFollowersList(final String p0, final long p1, final int p2, final boolean p3,
			final boolean p4) throws TwitterException;
}
