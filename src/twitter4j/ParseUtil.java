package twitter4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;

final class ParseUtil {
	private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue;

	static {
		formatMapQueue = new HashMap<String, LinkedBlockingQueue<SimpleDateFormat>>();
	}

	private ParseUtil() {
		throw new AssertionError();
	}

	static String getUnescapedString(final String str, final JSONObject json) {
		return HTMLEntity.unescape(getRawString(str, json));
	}

	public static String getRawString(final String name, final JSONObject json) {
		try {
			if (json.isNull(name)) {
				return null;
			}
			return json.getString(name);
		} catch (JSONException jsone) {
			return null;
		}
	}

	static String getURLDecodedString(final String name, final JSONObject json) {
		String returnValue = getRawString(name, json);
		if (returnValue != null) {
			try {
				returnValue = URLDecoder.decode(returnValue, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
			}
		}
		return returnValue;
	}

	public static Date parseTrendsDate(final String asOfStr) throws TwitterException {
		Date parsed = null;
		switch (asOfStr.length()) {
		case 10: {
			parsed = new Date(Long.parseLong(asOfStr) * 1000L);
			break;
		}
		case 20: {
			parsed = getDate(asOfStr, "yyyy-MM-dd'T'HH:mm:ss'Z'");
			break;
		}
		default: {
			parsed = getDate(asOfStr, "EEE, d MMM yyyy HH:mm:ss z");
			break;
		}
		}
		return parsed;
	}

	public static Date getDate(final String name, final JSONObject json) throws TwitterException {
		return getDate(name, json, "EEE MMM d HH:mm:ss z yyyy");
	}

	public static Date getDate(final String name, final JSONObject json, final String format) throws TwitterException {
		final String dateStr = getUnescapedString(name, json);
		if ("null".equals(dateStr) || dateStr == null) {
			return null;
		}
		return getDate(dateStr, format);
	}

	public static Date getDate(final String dateString, final String format) throws TwitterException {
		LinkedBlockingQueue<SimpleDateFormat> simpleDateFormats = ParseUtil.formatMapQueue.get(format);
		if (simpleDateFormats == null) {
			simpleDateFormats = new LinkedBlockingQueue<SimpleDateFormat>();
			ParseUtil.formatMapQueue.put(format, simpleDateFormats);
		}
		SimpleDateFormat sdf = simpleDateFormats.poll();
		if (sdf == null) {
			sdf = new SimpleDateFormat(format, Locale.US);
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		}
		try {
			return sdf.parse(dateString);
		} catch (ParseException pe) {
			throw new TwitterException("Unexpected date format(" + dateString + ") returned from twitter.com", pe);
		} finally {
			try {
				simpleDateFormats.put(sdf);
			} catch (InterruptedException ex) {
			}
		}
	}

	public static int getInt(final String name, final JSONObject json) {
		return getInt(getRawString(name, json));
	}

	public static int getInt(final String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return -1;
		}
		try {
			return Integer.valueOf(str);
		} catch (NumberFormatException nfe) {
			return -1;
		}
	}

	public static long getLong(final String name, final JSONObject json) {
		return getLong(getRawString(name, json));
	}

	public static long getLong(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return -1L;
		}
		if (str.endsWith("+")) {
			str = str.substring(0, str.length() - 1);
			return Long.valueOf(str) + 1L;
		}
		return Long.valueOf(str);
	}

	public static double getDouble(final String name, final JSONObject json) {
		final String str2 = getRawString(name, json);
		if (str2 == null || "".equals(str2) || "null".equals(str2)) {
			return -1.0;
		}
		return Double.valueOf(str2);
	}

	public static boolean getBoolean(final String name, final JSONObject json) {
		final String str = getRawString(name, json);
		return str != null && !"null".equals(str) && Boolean.valueOf(str);
	}

	public static int toAccessLevel(final HttpResponse res) {
		if (res == null) {
			return -1;
		}
		final String xAccessLevel = res.getResponseHeader("X-Access-Level");
		int accessLevel = 0;
		if (xAccessLevel == null) {
			accessLevel = 0;
		} else {
			switch (xAccessLevel.length()) {
			case 4: {
				accessLevel = 1;
				break;
			}
			case 10: {
				accessLevel = 2;
				break;
			}
			case 25: {
				accessLevel = 3;
				break;
			}
			case 26: {
				accessLevel = 3;
				break;
			}
			default: {
				accessLevel = 0;
				break;
			}
			}
		}
		return accessLevel;
	}
}
