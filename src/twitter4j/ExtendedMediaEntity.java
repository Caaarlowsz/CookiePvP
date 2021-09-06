package twitter4j;

import java.io.Serializable;

public interface ExtendedMediaEntity extends MediaEntity {
	int getVideoAspectRatioWidth();

	int getVideoAspectRatioHeight();

	long getVideoDurationMillis();

	Variant[] getVideoVariants();

	public interface Variant extends Serializable {
		int getBitrate();

		String getContentType();

		String getUrl();
	}
}
