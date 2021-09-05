package twitter4j;

import java.lang.reflect.Method;
import twitter4j.conf.Configuration;
import java.lang.reflect.InvocationTargetException;
import twitter4j.conf.ConfigurationContext;

public abstract class Logger
{
    private static final LoggerFactory LOGGER_FACTORY;
    private static final String LOGGER_FACTORY_IMPLEMENTATION = "twitter4j.loggerFactory";
    
    static {
        LoggerFactory loggerFactory = null;
        String loggerFactoryImpl = System.getProperty("twitter4j.loggerFactory");
        if (loggerFactoryImpl != null) {
            loggerFactory = getLoggerFactoryIfAvailable(loggerFactoryImpl, loggerFactoryImpl);
        }
        final Configuration conf = ConfigurationContext.getInstance();
        loggerFactoryImpl = conf.getLoggerFactory();
        if (loggerFactoryImpl != null) {
            loggerFactory = getLoggerFactoryIfAvailable(loggerFactoryImpl, loggerFactoryImpl);
        }
        if (loggerFactory == null) {
            loggerFactory = getLoggerFactoryIfAvailable("org.slf4j.impl.StaticLoggerBinder", "twitter4j.SLF4JLoggerFactory");
        }
        if (loggerFactory == null) {
            loggerFactory = getLoggerFactoryIfAvailable("org.apache.commons.logging.Log", "twitter4j.CommonsLoggingLoggerFactory");
        }
        if (loggerFactory == null) {
            loggerFactory = getLoggerFactoryIfAvailable("org.apache.log4j.Logger", "twitter4j.Log4JLoggerFactory");
        }
        if (loggerFactory == null) {
            loggerFactory = getLoggerFactoryIfAvailable("com.google.appengine.api.urlfetch.URLFetchService", "twitter4j.JULLoggerFactory");
        }
        if (loggerFactory == null) {
            loggerFactory = new StdOutLoggerFactory();
        }
        LOGGER_FACTORY = loggerFactory;
        try {
            final Method method = conf.getClass().getMethod("dumpConfiguration", (Class<?>[])new Class[0]);
            method.setAccessible(true);
            method.invoke(conf, new Object[0]);
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {}
        catch (NoSuchMethodException ex3) {}
    }
    
    private static LoggerFactory getLoggerFactoryIfAvailable(final String checkClassName, final String implementationClass) {
        try {
            Class.forName(checkClassName);
            return (LoggerFactory)Class.forName(implementationClass).newInstance();
        }
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException e) {
            throw new AssertionError((Object)e);
        }
        catch (SecurityException ex2) {}
        catch (IllegalAccessException e2) {
            throw new AssertionError((Object)e2);
        }
        return null;
    }
    
    public static Logger getLogger(final Class<?> clazz) {
        return Logger.LOGGER_FACTORY.getLogger(clazz);
    }
    
    public abstract boolean isDebugEnabled();
    
    public abstract boolean isInfoEnabled();
    
    public abstract boolean isWarnEnabled();
    
    public abstract boolean isErrorEnabled();
    
    public abstract void debug(final String p0);
    
    public abstract void debug(final String p0, final String p1);
    
    public abstract void info(final String p0);
    
    public abstract void info(final String p0, final String p1);
    
    public abstract void warn(final String p0);
    
    public abstract void warn(final String p0, final String p1);
    
    public abstract void error(final String p0);
    
    public abstract void error(final String p0, final Throwable p1);
}
