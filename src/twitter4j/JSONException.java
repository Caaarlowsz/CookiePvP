package twitter4j;

public class JSONException extends Exception
{
    private static final long serialVersionUID = -4144585377907783745L;
    private Throwable cause;
    
    public JSONException(final String message) {
        super(message);
    }
    
    public JSONException(final Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }
    
    @Override
    public Throwable getCause() {
        return this.cause;
    }
}
