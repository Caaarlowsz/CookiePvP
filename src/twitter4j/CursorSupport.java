package twitter4j;

public interface CursorSupport
{
    public static final long START = -1L;
    
    boolean hasPrevious();
    
    long getPreviousCursor();
    
    boolean hasNext();
    
    long getNextCursor();
}
