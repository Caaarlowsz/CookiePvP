package twitter4j;

final class JULLoggerFactory extends LoggerFactory
{
    @Override
    public Logger getLogger(final Class<?> clazz) {
        return new JULLogger(java.util.logging.Logger.getLogger(clazz.getName()));
    }
}
