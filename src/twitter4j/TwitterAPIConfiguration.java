package twitter4j;

import java.util.Map;
import java.io.Serializable;

public interface TwitterAPIConfiguration extends TwitterResponse, Serializable
{
    int getPhotoSizeLimit();
    
    int getShortURLLength();
    
    int getShortURLLengthHttps();
    
    int getCharactersReservedPerMedia();
    
    Map<Integer, MediaEntity.Size> getPhotoSizes();
    
    String[] getNonUsernamePaths();
    
    int getMaxMediaPerUpload();
}
