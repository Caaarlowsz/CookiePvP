package twitter4j;

import java.io.Serializable;
import java.util.Map;

public interface TwitterAPIConfiguration extends TwitterResponse, Serializable {
	int getPhotoSizeLimit();

	int getShortURLLength();

	int getShortURLLengthHttps();

	int getCharactersReservedPerMedia();

	Map<Integer, MediaEntity.Size> getPhotoSizes();

	String[] getNonUsernamePaths();

	int getMaxMediaPerUpload();
}
