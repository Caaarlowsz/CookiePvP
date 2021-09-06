package twitter4j;

public interface Dispatcher {
	void invokeLater(final Runnable p0);

	void shutdown();
}
