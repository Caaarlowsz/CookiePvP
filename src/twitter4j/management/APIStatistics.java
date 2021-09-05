package twitter4j.management;

import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class APIStatistics implements APIStatisticsMBean
{
    private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
    private final Map<String, InvocationStatisticsCalculator> METHOD_STATS_MAP;
    private final int HISTORY_SIZE;
    
    public APIStatistics(final int historySize) {
        this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator("API", historySize);
        this.METHOD_STATS_MAP = new HashMap<String, InvocationStatisticsCalculator>(100);
        this.HISTORY_SIZE = historySize;
    }
    
    public synchronized void methodCalled(final String method, final long time, final boolean success) {
        this.getMethodStatistics(method).increment(time, success);
        this.API_STATS_CALCULATOR.increment(time, success);
    }
    
    private synchronized InvocationStatisticsCalculator getMethodStatistics(final String method) {
        InvocationStatisticsCalculator methodStats = this.METHOD_STATS_MAP.get(method);
        if (methodStats == null) {
            methodStats = new InvocationStatisticsCalculator(method, this.HISTORY_SIZE);
            this.METHOD_STATS_MAP.put(method, methodStats);
        }
        return methodStats;
    }
    
    @Override
    public synchronized Iterable<? extends InvocationStatistics> getInvocationStatistics() {
        return this.METHOD_STATS_MAP.values();
    }
    
    @Override
    public synchronized void reset() {
        this.API_STATS_CALCULATOR.reset();
        this.METHOD_STATS_MAP.clear();
    }
    
    @Override
    public String getName() {
        return this.API_STATS_CALCULATOR.getName();
    }
    
    @Override
    public long getCallCount() {
        return this.API_STATS_CALCULATOR.getCallCount();
    }
    
    @Override
    public long getErrorCount() {
        return this.API_STATS_CALCULATOR.getErrorCount();
    }
    
    @Override
    public long getTotalTime() {
        return this.API_STATS_CALCULATOR.getTotalTime();
    }
    
    @Override
    public long getAverageTime() {
        return this.API_STATS_CALCULATOR.getAverageTime();
    }
    
    @Override
    public synchronized Map<String, String> getMethodLevelSummariesAsString() {
        final Map<String, String> summariesMap = new HashMap<String, String>();
        final Collection<InvocationStatisticsCalculator> allMethodStats = this.METHOD_STATS_MAP.values();
        for (final InvocationStatisticsCalculator methodStats : allMethodStats) {
            summariesMap.put(methodStats.getName(), methodStats.toString());
        }
        return summariesMap;
    }
    
    @Override
    public synchronized String getMethodLevelSummary(final String methodName) {
        return this.METHOD_STATS_MAP.get(methodName).toString();
    }
}
