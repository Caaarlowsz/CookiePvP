package twitter4j;

public enum RequestMethod
{
    GET("GET", 0), 
    POST("POST", 1), 
    DELETE("DELETE", 2), 
    HEAD("HEAD", 3), 
    PUT("PUT", 4);
    
    private RequestMethod(final String s, final int n) {
    }
}
