package twitter4j;

import java.io.Serializable;

public interface SymbolEntity extends TweetEntity, Serializable
{
    int getStart();
    
    int getEnd();
}
