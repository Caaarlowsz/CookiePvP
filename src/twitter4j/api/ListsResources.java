package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

public interface ListsResources {
	ResponseList<UserList> getUserLists(final String p0) throws TwitterException;

	ResponseList<UserList> getUserLists(final String p0, final boolean p1) throws TwitterException;

	ResponseList<UserList> getUserLists(final long p0) throws TwitterException;

	ResponseList<UserList> getUserLists(final long p0, final boolean p1) throws TwitterException;

	ResponseList<Status> getUserListStatuses(final long p0, final Paging p1) throws TwitterException;

	ResponseList<Status> getUserListStatuses(final long p0, final String p1, final Paging p2) throws TwitterException;

	ResponseList<Status> getUserListStatuses(final String p0, final String p1, final Paging p2) throws TwitterException;

	UserList destroyUserListMember(final long p0, final long p1) throws TwitterException;

	UserList destroyUserListMember(final long p0, final String p1) throws TwitterException;

	UserList destroyUserListMembers(final long p0, final String[] p1) throws TwitterException;

	UserList destroyUserListMembers(final long p0, final long[] p1) throws TwitterException;

	UserList destroyUserListMembers(final String p0, final String p1, final String[] p2) throws TwitterException;

	UserList destroyUserListMember(final long p0, final String p1, final long p2) throws TwitterException;

	UserList destroyUserListMember(final String p0, final String p1, final long p2) throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final long p0) throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final int p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final long p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final long p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final String p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final String p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final String p0, final long p1, final boolean p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final String p0, final int p1, final long p2, final boolean p3)
			throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final long p0, final long p1, final boolean p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListMemberships(final long p0, final int p1, final long p2, final boolean p3)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final long p1) throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final int p1, final long p2, final boolean p3)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final String p1, final long p2)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final String p1, final int p2, final long p3)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final long p0, final String p1, final int p2, final long p3,
			final boolean p4) throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final String p0, final String p1, final long p2)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final String p0, final String p1, final int p2, final long p3)
			throws TwitterException;

	PagableResponseList<User> getUserListSubscribers(final String p0, final String p1, final int p2, final long p3,
			final boolean p4) throws TwitterException;

	UserList createUserListSubscription(final long p0) throws TwitterException;

	UserList createUserListSubscription(final long p0, final String p1) throws TwitterException;

	UserList createUserListSubscription(final String p0, final String p1) throws TwitterException;

	User showUserListSubscription(final long p0, final long p1) throws TwitterException;

	User showUserListSubscription(final long p0, final String p1, final long p2) throws TwitterException;

	User showUserListSubscription(final String p0, final String p1, final long p2) throws TwitterException;

	UserList destroyUserListSubscription(final long p0) throws TwitterException;

	UserList destroyUserListSubscription(final long p0, final String p1) throws TwitterException;

	UserList destroyUserListSubscription(final String p0, final String p1) throws TwitterException;

	UserList createUserListMembers(final long p0, final long... p1) throws TwitterException;

	UserList createUserListMembers(final long p0, final String p1, final long... p2) throws TwitterException;

	UserList createUserListMembers(final String p0, final String p1, final long... p2) throws TwitterException;

	UserList createUserListMembers(final long p0, final String... p1) throws TwitterException;

	UserList createUserListMembers(final long p0, final String p1, final String... p2) throws TwitterException;

	UserList createUserListMembers(final String p0, final String p1, final String... p2) throws TwitterException;

	User showUserListMembership(final long p0, final long p1) throws TwitterException;

	User showUserListMembership(final long p0, final String p1, final long p2) throws TwitterException;

	User showUserListMembership(final String p0, final String p1, final long p2) throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final long p1) throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final int p1, final long p2) throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final int p1, final long p2, final boolean p3)
			throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final String p1, final long p2) throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final String p1, final int p2, final long p3)
			throws TwitterException;

	PagableResponseList<User> getUserListMembers(final long p0, final String p1, final int p2, final long p3,
			final boolean p4) throws TwitterException;

	PagableResponseList<User> getUserListMembers(final String p0, final String p1, final long p2)
			throws TwitterException;

	PagableResponseList<User> getUserListMembers(final String p0, final String p1, final int p2, final long p3)
			throws TwitterException;

	PagableResponseList<User> getUserListMembers(final String p0, final String p1, final int p2, final long p3,
			final boolean p4) throws TwitterException;

	UserList createUserListMember(final long p0, final long p1) throws TwitterException;

	UserList createUserListMember(final long p0, final String p1, final long p2) throws TwitterException;

	UserList createUserListMember(final String p0, final String p1, final long p2) throws TwitterException;

	UserList destroyUserList(final long p0) throws TwitterException;

	UserList destroyUserList(final long p0, final String p1) throws TwitterException;

	UserList destroyUserList(final String p0, final String p1) throws TwitterException;

	UserList updateUserList(final long p0, final String p1, final boolean p2, final String p3) throws TwitterException;

	UserList updateUserList(final long p0, final String p1, final String p2, final boolean p3, final String p4)
			throws TwitterException;

	UserList updateUserList(final String p0, final String p1, final String p2, final boolean p3, final String p4)
			throws TwitterException;

	UserList createUserList(final String p0, final boolean p1, final String p2) throws TwitterException;

	UserList showUserList(final long p0) throws TwitterException;

	UserList showUserList(final long p0, final String p1) throws TwitterException;

	UserList showUserList(final String p0, final String p1) throws TwitterException;

	PagableResponseList<UserList> getUserListSubscriptions(final String p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListSubscriptions(final String p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListSubscriptions(final long p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListSubscriptions(final long p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListsOwnerships(final String p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListsOwnerships(final String p0, final int p1, final long p2)
			throws TwitterException;

	PagableResponseList<UserList> getUserListsOwnerships(final long p0, final long p1) throws TwitterException;

	PagableResponseList<UserList> getUserListsOwnerships(final long p0, final int p1, final long p2)
			throws TwitterException;
}
