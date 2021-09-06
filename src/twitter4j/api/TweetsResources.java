package twitter4j.api;

import java.io.File;
import java.io.InputStream;

import twitter4j.IDs;
import twitter4j.OEmbed;
import twitter4j.OEmbedRequest;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.UploadedMedia;

public interface TweetsResources {
	ResponseList<Status> getRetweets(final long p0) throws TwitterException;

	IDs getRetweeterIds(final long p0, final long p1) throws TwitterException;

	IDs getRetweeterIds(final long p0, final int p1, final long p2) throws TwitterException;

	Status showStatus(final long p0) throws TwitterException;

	Status destroyStatus(final long p0) throws TwitterException;

	Status updateStatus(final String p0) throws TwitterException;

	Status updateStatus(final StatusUpdate p0) throws TwitterException;

	Status retweetStatus(final long p0) throws TwitterException;

	OEmbed getOEmbed(final OEmbedRequest p0) throws TwitterException;

	ResponseList<Status> lookup(final long... p0) throws TwitterException;

	UploadedMedia uploadMedia(final File p0) throws TwitterException;

	UploadedMedia uploadMedia(final String p0, final InputStream p1) throws TwitterException;
}
