package twitter4j;

final class NullLogger extends Logger
{
    @Override
    public boolean isDebugEnabled() {
        return false;
    }
    
    @Override
    public boolean isInfoEnabled() {
        return false;
    }
    
    @Override
    public boolean isWarnEnabled() {
        return false;
    }
    
    @Override
    public boolean isErrorEnabled() {
        return false;
    }
    
    @Override
    public void debug(final String message) {
    }
    
    @Override
    public void debug(final String message, final String message2) {
    }
    
    @Override
    public void info(final String message) {
    }
    
    @Override
    public void info(final String message, final String message2) {
    }
    
    @Override
    public void warn(final String message) {
    }
    
    @Override
    public void warn(final String message, final String message2) {
    }
    
    @Override
    public void error(final String message) {
    }
    
    @Override
    public void error(final String message, final Throwable th) {
    }
}
