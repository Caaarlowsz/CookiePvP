package twitter4j;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsMBean;
import twitter4j.management.APIStatisticsOpenMBean;

public class TwitterAPIMonitor {
	private static final Logger logger;
	private static final Pattern pattern;
	private static final TwitterAPIMonitor SINGLETON;
	private static final APIStatistics STATISTICS;

	static {
		logger = Logger.getLogger(TwitterAPIMonitor.class);
		pattern = Pattern.compile("https?://[^/]+/[0-9.]*/([a-zA-Z_\\.]*).*");
		SINGLETON = new TwitterAPIMonitor();
		STATISTICS = new APIStatistics(100);
		try {
			final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			final ObjectName oName = new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean");
			final APIStatisticsOpenMBean openMBean = new APIStatisticsOpenMBean(TwitterAPIMonitor.STATISTICS);
			mbs.registerMBean(openMBean, oName);
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
			TwitterAPIMonitor.logger.error(e.getMessage());
		} catch (MBeanRegistrationException e2) {
			e2.printStackTrace();
			TwitterAPIMonitor.logger.error(e2.getMessage());
		} catch (NotCompliantMBeanException e3) {
			e3.printStackTrace();
			TwitterAPIMonitor.logger.error(e3.getMessage());
		} catch (MalformedObjectNameException e4) {
			e4.printStackTrace();
			TwitterAPIMonitor.logger.error(e4.getMessage());
		}
	}

	private TwitterAPIMonitor() {
	}

	public static TwitterAPIMonitor getInstance() {
		return TwitterAPIMonitor.SINGLETON;
	}

	public APIStatisticsMBean getStatistics() {
		return TwitterAPIMonitor.STATISTICS;
	}

	void methodCalled(final String twitterUrl, final long elapsedTime, final boolean success) {
		final Matcher matcher = TwitterAPIMonitor.pattern.matcher(twitterUrl);
		if (matcher.matches() && matcher.groupCount() > 0) {
			final String method = matcher.group(1);
			TwitterAPIMonitor.STATISTICS.methodCalled(method, elapsedTime, success);
		}
	}
}
