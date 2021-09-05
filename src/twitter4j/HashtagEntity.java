package twitter4j;

import java.io.Serializable;

public interface HashtagEntity extends TweetEntity, Serializable
{
    String getText();
    
    int getStart();
    
    int getEnd();
}
