package twitter4j.api;

import twitter4j.TwitterException;
import twitter4j.QueryResult;
import twitter4j.Query;

public interface SearchResource
{
    QueryResult search(final Query p0) throws TwitterException;
}
