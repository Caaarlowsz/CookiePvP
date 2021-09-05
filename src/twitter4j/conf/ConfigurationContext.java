package twitter4j.conf;

public final class ConfigurationContext
{
    private static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    private static final ConfigurationFactory factory;
    
    static {
        String CONFIG_IMPL;
        try {
            CONFIG_IMPL = System.getProperty("twitter4j.configurationFactory", "twitter4j.conf.PropertyConfigurationFactory");
        }
        catch (SecurityException ignore) {
            CONFIG_IMPL = "twitter4j.conf.PropertyConfigurationFactory";
        }
        try {
            factory = (ConfigurationFactory)Class.forName(CONFIG_IMPL).newInstance();
        }
        catch (ClassNotFoundException cnfe) {
            throw new AssertionError((Object)cnfe);
        }
        catch (InstantiationException ie) {
            throw new AssertionError((Object)ie);
        }
        catch (IllegalAccessException iae) {
            throw new AssertionError((Object)iae);
        }
    }
    
    public static Configuration getInstance() {
        return ConfigurationContext.factory.getInstance();
    }
    
    public static Configuration getInstance(final String configTreePath) {
        return ConfigurationContext.factory.getInstance(configTreePath);
    }
}
