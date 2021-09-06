package twitter4j;

final class NullLoggerFactory extends LoggerFactory {
	private static final Logger SINGLETON;

	static {
		SINGLETON = new NullLogger();
	}

	@Override
	public Logger getLogger(final Class<?> clazz) {
		return NullLoggerFactory.SINGLETON;
	}
}
