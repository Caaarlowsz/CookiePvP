package twitter4j;

public interface EntitySupport {
	UserMentionEntity[] getUserMentionEntities();

	URLEntity[] getURLEntities();

	HashtagEntity[] getHashtagEntities();

	MediaEntity[] getMediaEntities();

	ExtendedMediaEntity[] getExtendedMediaEntities();

	SymbolEntity[] getSymbolEntities();
}
