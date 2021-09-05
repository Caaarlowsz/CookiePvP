package twitter4j.management;

import java.util.Map;

public interface APIStatisticsMBean extends InvocationStatistics
{
    Map<String, String> getMethodLevelSummariesAsString();
    
    String getMethodLevelSummary(final String p0);
    
    Iterable<? extends InvocationStatistics> getInvocationStatistics();
}
