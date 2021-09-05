package twitter4j.conf;

class PropertyConfigurationFactory implements ConfigurationFactory
{
    private static final PropertyConfiguration ROOT_CONFIGURATION;
    
    static {
        ROOT_CONFIGURATION = new PropertyConfiguration();
    }
    
    @Override
    public Configuration getInstance() {
        return PropertyConfigurationFactory.ROOT_CONFIGURATION;
    }
    
    @Override
    public Configuration getInstance(final String configTreePath) {
        final PropertyConfiguration conf = new PropertyConfiguration(configTreePath);
        conf.dumpConfiguration();
        return conf;
    }
    
    @Override
    public void dispose() {
    }
}
