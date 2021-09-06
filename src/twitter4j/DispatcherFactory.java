package twitter4j;

import java.lang.reflect.InvocationTargetException;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

final class DispatcherFactory {
	private final String dispatcherImpl;
	private final Configuration conf;

	public DispatcherFactory(final Configuration conf) {
		this.dispatcherImpl = conf.getDispatcherImpl();
		this.conf = conf;
	}

	public DispatcherFactory() {
		this(ConfigurationContext.getInstance());
	}

	public Dispatcher getInstance() {
		try {
			return (Dispatcher) Class.forName(this.dispatcherImpl).getConstructor(Configuration.class)
					.newInstance(this.conf);
		} catch (InstantiationException e) {
			throw new AssertionError((Object) e);
		} catch (IllegalAccessException e2) {
			throw new AssertionError((Object) e2);
		} catch (ClassNotFoundException e3) {
			throw new AssertionError((Object) e3);
		} catch (ClassCastException e4) {
			throw new AssertionError((Object) e4);
		} catch (NoSuchMethodException e5) {
			throw new AssertionError((Object) e5);
		} catch (InvocationTargetException e6) {
			throw new AssertionError((Object) e6);
		}
	}
}
