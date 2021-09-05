package twitter4j.conf;

public interface ConfigurationFactory
{
    Configuration getInstance();
    
    Configuration getInstance(final String p0);
    
    void dispose();
}
