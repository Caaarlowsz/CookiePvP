package twitter4j;

import java.util.Date;
import java.io.Serializable;

public interface User extends Comparable<User>, TwitterResponse, Serializable
{
    long getId();
    
    String getName();
    
    String getScreenName();
    
    String getLocation();
    
    String getDescription();
    
    boolean isContributorsEnabled();
    
    String getProfileImageURL();
    
    String getBiggerProfileImageURL();
    
    String getMiniProfileImageURL();
    
    String getOriginalProfileImageURL();
    
    String getProfileImageURLHttps();
    
    String getBiggerProfileImageURLHttps();
    
    String getMiniProfileImageURLHttps();
    
    String getOriginalProfileImageURLHttps();
    
    boolean isDefaultProfileImage();
    
    String getURL();
    
    boolean isProtected();
    
    int getFollowersCount();
    
    Status getStatus();
    
    String getProfileBackgroundColor();
    
    String getProfileTextColor();
    
    String getProfileLinkColor();
    
    String getProfileSidebarFillColor();
    
    String getProfileSidebarBorderColor();
    
    boolean isProfileUseBackgroundImage();
    
    boolean isDefaultProfile();
    
    boolean isShowAllInlineMedia();
    
    int getFriendsCount();
    
    Date getCreatedAt();
    
    int getFavouritesCount();
    
    int getUtcOffset();
    
    String getTimeZone();
    
    String getProfileBackgroundImageURL();
    
    String getProfileBackgroundImageUrlHttps();
    
    String getProfileBannerURL();
    
    String getProfileBannerRetinaURL();
    
    String getProfileBannerIPadURL();
    
    String getProfileBannerIPadRetinaURL();
    
    String getProfileBannerMobileURL();
    
    String getProfileBannerMobileRetinaURL();
    
    boolean isProfileBackgroundTiled();
    
    String getLang();
    
    int getStatusesCount();
    
    boolean isGeoEnabled();
    
    boolean isVerified();
    
    boolean isTranslator();
    
    int getListedCount();
    
    boolean isFollowRequestSent();
    
    URLEntity[] getDescriptionURLEntities();
    
    URLEntity getURLEntity();
    
    String[] getWithheldInCountries();
}
