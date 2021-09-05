package twitter4j.management;

public class InvocationStatisticsCalculator implements InvocationStatistics
{
    private final String name;
    private long[] times;
    private int index;
    private long callCount;
    private long errorCount;
    private long totalTime;
    
    public InvocationStatisticsCalculator(final String name, final int historySize) {
        this.name = name;
        this.times = new long[historySize];
    }
    
    void increment(final long time, final boolean success) {
        ++this.callCount;
        this.errorCount += (success ? 0 : 1);
        this.totalTime += time;
        this.times[this.index] = time;
        if (++this.index >= this.times.length) {
            this.index = 0;
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public long getCallCount() {
        return this.callCount;
    }
    
    @Override
    public long getErrorCount() {
        return this.errorCount;
    }
    
    @Override
    public long getTotalTime() {
        return this.totalTime;
    }
    
    @Override
    public synchronized long getAverageTime() {
        final int stopIndex = Math.min(Math.abs((int)this.callCount), this.times.length);
        if (stopIndex == 0) {
            return 0L;
        }
        long totalTime = 0L;
        for (int i = 0; i < stopIndex; ++i) {
            totalTime += this.times[i];
        }
        return totalTime / stopIndex;
    }
    
    @Override
    public synchronized void reset() {
        this.callCount = 0L;
        this.errorCount = 0L;
        this.totalTime = 0L;
        this.times = new long[this.times.length];
        this.index = 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("calls=").append(this.getCallCount()).append(",").append("errors=").append(this.getErrorCount()).append(",").append("totalTime=").append(this.getTotalTime()).append(",").append("avgTime=").append(this.getAverageTime());
        return sb.toString();
    }
}
