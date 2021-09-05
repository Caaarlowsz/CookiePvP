package twitter4j.api;

import twitter4j.ResponseList;
import twitter4j.IDs;
import twitter4j.PagableResponseList;
import java.io.InputStream;
import java.io.File;
import twitter4j.User;
import twitter4j.TwitterException;
import twitter4j.AccountSettings;

public interface UsersResources
{
    AccountSettings getAccountSettings() throws TwitterException;
    
    User verifyCredentials() throws TwitterException;
    
    AccountSettings updateAccountSettings(final Integer p0, final Boolean p1, final String p2, final String p3, final String p4, final String p5) throws TwitterException;
    
    User updateProfile(final String p0, final String p1, final String p2, final String p3) throws TwitterException;
    
    User updateProfileBackgroundImage(final File p0, final boolean p1) throws TwitterException;
    
    User updateProfileBackgroundImage(final InputStream p0, final boolean p1) throws TwitterException;
    
    User updateProfileColors(final String p0, final String p1, final String p2, final String p3, final String p4) throws TwitterException;
    
    User updateProfileImage(final File p0) throws TwitterException;
    
    User updateProfileImage(final InputStream p0) throws TwitterException;
    
    PagableResponseList<User> getBlocksList() throws TwitterException;
    
    PagableResponseList<User> getBlocksList(final long p0) throws TwitterException;
    
    IDs getBlocksIDs() throws TwitterException;
    
    IDs getBlocksIDs(final long p0) throws TwitterException;
    
    User createBlock(final long p0) throws TwitterException;
    
    User createBlock(final String p0) throws TwitterException;
    
    User destroyBlock(final long p0) throws TwitterException;
    
    User destroyBlock(final String p0) throws TwitterException;
    
    PagableResponseList<User> getMutesList(final long p0) throws TwitterException;
    
    IDs getMutesIDs(final long p0) throws TwitterException;
    
    User createMute(final long p0) throws TwitterException;
    
    User createMute(final String p0) throws TwitterException;
    
    User destroyMute(final long p0) throws TwitterException;
    
    User destroyMute(final String p0) throws TwitterException;
    
    ResponseList<User> lookupUsers(final long... p0) throws TwitterException;
    
    ResponseList<User> lookupUsers(final String... p0) throws TwitterException;
    
    User showUser(final long p0) throws TwitterException;
    
    User showUser(final String p0) throws TwitterException;
    
    ResponseList<User> searchUsers(final String p0, final int p1) throws TwitterException;
    
    ResponseList<User> getContributees(final long p0) throws TwitterException;
    
    ResponseList<User> getContributees(final String p0) throws TwitterException;
    
    ResponseList<User> getContributors(final long p0) throws TwitterException;
    
    ResponseList<User> getContributors(final String p0) throws TwitterException;
    
    void removeProfileBanner() throws TwitterException;
    
    void updateProfileBanner(final File p0) throws TwitterException;
    
    void updateProfileBanner(final InputStream p0) throws TwitterException;
}
