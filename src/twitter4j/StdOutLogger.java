package twitter4j;

import java.util.Date;

import twitter4j.conf.ConfigurationContext;

final class StdOutLogger extends Logger {
	private static final boolean DEBUG;

	static {
		DEBUG = ConfigurationContext.getInstance().isDebugEnabled();
	}

	@Override
	public boolean isDebugEnabled() {
		return StdOutLogger.DEBUG;
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public void debug(final String message) {
		if (StdOutLogger.DEBUG) {
			System.out.println("[" + new Date() + "]" + message);
		}
	}

	@Override
	public void debug(final String message, final String message2) {
		if (StdOutLogger.DEBUG) {
			this.debug(String.valueOf(message) + message2);
		}
	}

	@Override
	public void info(final String message) {
		System.out.println("[" + new Date() + "]" + message);
	}

	@Override
	public void info(final String message, final String message2) {
		this.info(String.valueOf(message) + message2);
	}

	@Override
	public void warn(final String message) {
		System.out.println("[" + new Date() + "]" + message);
	}

	@Override
	public void warn(final String message, final String message2) {
		this.warn(String.valueOf(message) + message2);
	}

	@Override
	public void error(final String message) {
		System.out.println("[" + new Date() + "]" + message);
	}

	@Override
	public void error(final String message, final Throwable th) {
		System.out.println(message);
		th.printStackTrace(System.err);
	}
}
