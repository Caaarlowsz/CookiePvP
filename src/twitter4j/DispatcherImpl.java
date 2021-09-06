package twitter4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import twitter4j.conf.Configuration;

final class DispatcherImpl implements Dispatcher {
	private final ExecutorService executorService;
	private static final Logger logger;

	static {
		logger = Logger.getLogger(DispatcherImpl.class);
	}

	public DispatcherImpl(final Configuration conf) {
		this.executorService = Executors.newFixedThreadPool(conf.getAsyncNumThreads(), new ThreadFactory() {
			int count = 0;

			@Override
			public Thread newThread(final Runnable r) {
				final Thread thread = new Thread(r);
				thread.setName(String.format("Twitter4J Async Dispatcher[%d]", this.count++));
				thread.setDaemon(conf.isDaemonEnabled());
				return thread;
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				DispatcherImpl.this.executorService.shutdown();
			}
		});
	}

	@Override
	public synchronized void invokeLater(final Runnable task) {
		this.executorService.execute(task);
	}

	@Override
	public synchronized void shutdown() {
		this.executorService.shutdown();
		try {
			if (!this.executorService.awaitTermination(5000L, TimeUnit.MILLISECONDS)) {
				this.executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			DispatcherImpl.logger.warn(e.getMessage());
		}
	}
}
