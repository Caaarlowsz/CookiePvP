package twitter4j;

final class StdOutLoggerFactory extends LoggerFactory {
	private static final Logger SINGLETON;

	static {
		SINGLETON = new StdOutLogger();
	}

	@Override
	public Logger getLogger(final Class<?> clazz) {
		return StdOutLoggerFactory.SINGLETON;
	}
}
