package twitter4j;

import java.util.logging.Level;

final class JULLogger extends Logger {
	private final java.util.logging.Logger LOGGER;

	JULLogger(final java.util.logging.Logger logger) {
		this.LOGGER = logger;
	}

	@Override
	public boolean isDebugEnabled() {
		return this.LOGGER.isLoggable(Level.FINE);
	}

	@Override
	public boolean isInfoEnabled() {
		return this.LOGGER.isLoggable(Level.INFO);
	}

	@Override
	public boolean isWarnEnabled() {
		return this.LOGGER.isLoggable(Level.WARNING);
	}

	@Override
	public boolean isErrorEnabled() {
		return this.LOGGER.isLoggable(Level.SEVERE);
	}

	@Override
	public void debug(final String message) {
		this.LOGGER.fine(message);
	}

	@Override
	public void debug(final String message, final String message2) {
		this.LOGGER.fine(String.valueOf(message) + message2);
	}

	@Override
	public void info(final String message) {
		this.LOGGER.info(message);
	}

	@Override
	public void info(final String message, final String message2) {
		this.LOGGER.info(String.valueOf(message) + message2);
	}

	@Override
	public void warn(final String message) {
		this.LOGGER.warning(message);
	}

	@Override
	public void warn(final String message, final String message2) {
		this.LOGGER.warning(String.valueOf(message) + message2);
	}

	@Override
	public void error(final String message) {
		this.LOGGER.severe(message);
	}

	@Override
	public void error(final String message, final Throwable th) {
		this.LOGGER.severe(String.valueOf(message) + th.getMessage());
	}
}
