package twitter4j.management;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.management.openmbean.OpenMBeanInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfo;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfo;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

public class APIStatisticsOpenMBean implements DynamicMBean {
	private static final String[] ITEM_NAMES;
	@SuppressWarnings("rawtypes")
	private static final OpenType[] ITEM_TYPES;
	private static final String[] ITEM_DESCRIPTIONS;
	private final CompositeType METHOD_STATS_TYPE;
	private final APIStatisticsMBean API_STATISTICS;
	private final TabularType API_STATISTICS_TYPE;

	static {
		ITEM_NAMES = new String[] { "methodName", "callCount", "errorCount", "totalTime", "avgTime" };
		ITEM_TYPES = new OpenType[] { SimpleType.STRING, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG,
				SimpleType.LONG };
		ITEM_DESCRIPTIONS = new String[] { "The method name", "The number of times this method has been called",
				"The number of calls that failed",
				"The total amount of time spent invoking this method in milliseconds",
				"The average amount of time spent invoking this method in milliseconds" };
	}

	public APIStatisticsOpenMBean(final APIStatistics apiStatistics) {
		this.API_STATISTICS = apiStatistics;
		try {
			this.METHOD_STATS_TYPE = new CompositeType("method statistics", "method statistics",
					APIStatisticsOpenMBean.ITEM_NAMES, APIStatisticsOpenMBean.ITEM_DESCRIPTIONS,
					APIStatisticsOpenMBean.ITEM_TYPES);
			final String[] index = { "methodName" };
			this.API_STATISTICS_TYPE = new TabularType("API statistics", "list of methods", this.METHOD_STATS_TYPE,
					index);
		} catch (OpenDataException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		final OpenMBeanAttributeInfoSupport[] attributes = new OpenMBeanAttributeInfoSupport[5];
		final OpenMBeanConstructorInfoSupport[] constructors = { null };
		final OpenMBeanOperationInfoSupport[] operations = { null };
		final MBeanNotificationInfo[] notifications = new MBeanNotificationInfo[0];
		int attrIdx = 0;
		attributes[attrIdx++] = new OpenMBeanAttributeInfoSupport("callCount", "Total number of API calls",
				SimpleType.LONG, true, false, false);
		attributes[attrIdx++] = new OpenMBeanAttributeInfoSupport("errorCount", "The number of failed API calls",
				SimpleType.LONG, true, false, false);
		attributes[attrIdx++] = new OpenMBeanAttributeInfoSupport("averageTime",
				"Average time spent invoking any API method", SimpleType.LONG, true, false, false);
		attributes[attrIdx++] = new OpenMBeanAttributeInfoSupport("totalTime",
				"Average time spent invoking any API method", SimpleType.LONG, true, false, false);
		attributes[attrIdx++] = new OpenMBeanAttributeInfoSupport("statisticsTable",
				"Table of statisics for all API methods", this.API_STATISTICS_TYPE, true, false, false);
		constructors[0] = new OpenMBeanConstructorInfoSupport("APIStatisticsOpenMBean",
				"Constructs an APIStatisticsOpenMBean instance",
				(OpenMBeanParameterInfo[]) new OpenMBeanParameterInfoSupport[0]);
		final OpenMBeanParameterInfo[] params = new OpenMBeanParameterInfoSupport[0];
		operations[0] = new OpenMBeanOperationInfoSupport("reset", "reset the statistics", params, SimpleType.VOID, 0);
		final OpenMBeanInfoSupport info = new OpenMBeanInfoSupport(this.getClass().getName(),
				"API Statistics Open MBean", attributes, constructors, (OpenMBeanOperationInfo[]) operations,
				notifications);
		return info;
	}

	public synchronized TabularDataSupport getStatistics() {
		final TabularDataSupport apiStatisticsTable = new TabularDataSupport(this.API_STATISTICS_TYPE);
		for (final InvocationStatistics methodStats : this.API_STATISTICS.getInvocationStatistics()) {
			final Object[] itemValues = { methodStats.getName(), methodStats.getCallCount(),
					methodStats.getErrorCount(), methodStats.getTotalTime(), methodStats.getAverageTime() };
			try {
				final CompositeData result = new CompositeDataSupport(this.METHOD_STATS_TYPE,
						APIStatisticsOpenMBean.ITEM_NAMES, itemValues);
				apiStatisticsTable.put(result);
			} catch (OpenDataException e) {
				throw new RuntimeException(e);
			}
		}
		return apiStatisticsTable;
	}

	public void reset() {
		this.API_STATISTICS.reset();
	}

	@Override
	public Object getAttribute(final String attribute)
			throws AttributeNotFoundException, MBeanException, ReflectionException {
		if (attribute.equals("statisticsTable")) {
			return this.getStatistics();
		}
		if (attribute.equals("callCount")) {
			return this.API_STATISTICS.getCallCount();
		}
		if (attribute.equals("errorCount")) {
			return this.API_STATISTICS.getErrorCount();
		}
		if (attribute.equals("totalTime")) {
			return this.API_STATISTICS.getTotalTime();
		}
		if (attribute.equals("averageTime")) {
			return this.API_STATISTICS.getAverageTime();
		}
		throw new AttributeNotFoundException("Cannot find " + attribute + " attribute ");
	}

	@Override
	public AttributeList getAttributes(final String[] attributeNames) {
		final AttributeList resultList = new AttributeList();
		if (attributeNames.length == 0) {
			return resultList;
		}
		for (final String attributeName : attributeNames) {
			try {
				final Object value = this.getAttribute(attributeName);
				resultList.add(new Attribute(attributeName, value));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

	@Override
	public Object invoke(final String actionName, final Object[] params, final String[] signature)
			throws MBeanException, ReflectionException {
		if (actionName.equals("reset")) {
			this.reset();
			return "Statistics reset";
		}
		throw new ReflectionException(new NoSuchMethodException(actionName), "Cannot find the operation " + actionName);
	}

	@Override
	public void setAttribute(final Attribute attribute)
			throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
		throw new AttributeNotFoundException("No attributes can be set in this MBean");
	}

	@Override
	public AttributeList setAttributes(final AttributeList attributes) {
		return new AttributeList();
	}
}
