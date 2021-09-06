package twitter4j;

import java.io.Serializable;

public interface OEmbed extends TwitterResponse, Serializable {
	String getHtml();

	String getAuthorName();

	String getURL();

	String getVersion();

	long getCacheAge();

	String getAuthorURL();

	int getWidth();
}
