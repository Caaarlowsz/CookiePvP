package twitter4j.management;

public interface InvocationStatistics {
	String getName();

	long getCallCount();

	long getErrorCount();

	long getTotalTime();

	long getAverageTime();

	void reset();
}
