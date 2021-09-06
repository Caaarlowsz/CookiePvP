package twitter4j;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class JSONObject {
	@SuppressWarnings("rawtypes")
	private final Map map;
	public static final Object NULL;

	static {
		NULL = new Null();
	}

	public JSONObject() {
		this.map = new HashMap<>();
	}

	public JSONObject(final JSONObject jo, final String[] names) {
		this();
		for (final String name : names) {
			try {
				this.putOnce(name, jo.opt(name));
			} catch (Exception ex) {
			}
		}
	}

	public JSONObject(final JSONTokener x) throws JSONException {
		this();
		if (x.nextClean() != '{') {
			throw x.syntaxError("A JSONObject text must begin with '{' found:" + x.nextClean());
		}
		while (true) {
			char c = x.nextClean();
			switch (c) {
			case '\0': {
				throw x.syntaxError("A JSONObject text must end with '}'");
			}
			case '}': {
			}
			default: {
				x.back();
				final String key = x.nextValue().toString();
				c = x.nextClean();
				if (c == '=') {
					if (x.next() != '>') {
						x.back();
					}
				} else if (c != ':') {
					throw x.syntaxError("Expected a ':' after a key");
				}
				this.putOnce(key, x.nextValue());
				switch (x.nextClean()) {
				case ',':
				case ';': {
					if (x.nextClean() == '}') {
						return;
					}
					x.back();
					continue;
				}
				case '}': {
					return;
				}
				default: {
					throw x.syntaxError("Expected a ',' or '}'");
				}
				}
			}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONObject(final Map<?, ?> map) {
		this.map = new HashMap<Object, Object>();
		if (map != null) {
			for (final Object o : map.entrySet()) {
				final Map.Entry e = (Map.Entry) o;
				final Object value = e.getValue();
				if (value != null) {
					this.map.put(e.getKey(), wrap(value));
				}
			}
		}
	}

	public JSONObject(final Object bean) {
		this();
		this.populateMap(bean);
	}

	public JSONObject(final Object object, final String[] names) {
		this();
		final Class<? extends Object> c = object.getClass();
		for (final String name : names) {
			try {
				this.putOpt(name, c.getField(name).get(object));
			} catch (Exception ex) {
			}
		}
	}

	public JSONObject(final String source) throws JSONException {
		this(new JSONTokener(source));
	}

	public JSONObject(final String baseName, final Locale locale) throws JSONException {
		this();
		final ResourceBundle r = ResourceBundle.getBundle(baseName, locale,
				Thread.currentThread().getContextClassLoader());
		final Enumeration<String> keys = r.getKeys();
		while (keys.hasMoreElements()) {
			final Object key = keys.nextElement();
			if (key instanceof String) {
				final String[] path = ((String) key).split("\\.");
				final int last = path.length - 1;
				JSONObject target = this;
				for (final String segment : path) {
					final Object object = target.opt(segment);
					JSONObject nextTarget = (object instanceof JSONObject) ? ((JSONObject) object) : null;
					if (nextTarget == null) {
						nextTarget = new JSONObject();
						target.put(segment, nextTarget);
					}
					target = nextTarget;
				}
				target.put(path[last], r.getString((String) key));
			}
		}
	}

	public JSONObject append(final String key, final Object value) throws JSONException {
		testValidity(value);
		final Object object = this.opt(key);
		if (object == null) {
			this.put(key, new JSONArray().put(value));
		} else {
			if (!(object instanceof JSONArray)) {
				throw new JSONException("JSONObject[" + key + "] is not a JSONArray.");
			}
			this.put(key, ((JSONArray) object).put(value));
		}
		return this;
	}

	public Object get(final String key) throws JSONException {
		if (key == null) {
			throw new JSONException("Null key.");
		}
		final Object object = this.opt(key);
		if (object == null) {
			throw new JSONException("JSONObject[" + quote(key) + "] not found.");
		}
		return object;
	}

	public boolean getBoolean(final String key) throws JSONException {
		final Object object = this.get(key);
		if (object.equals(Boolean.FALSE) || (object instanceof String && ((String) object).equalsIgnoreCase("false"))) {
			return false;
		}
		if (object.equals(Boolean.TRUE) || (object instanceof String && ((String) object).equalsIgnoreCase("true"))) {
			return true;
		}
		throw new JSONException("JSONObject[" + quote(key) + "] is not a Boolean.");
	}

	public int getInt(final String key) throws JSONException {
		final Object object = this.get(key);
		try {
			return (object instanceof Number) ? ((Number) object).intValue() : Integer.parseInt((String) object);
		} catch (Exception e) {
			throw new JSONException("JSONObject[" + quote(key) + "] is not an int.");
		}
	}

	public JSONArray getJSONArray(final String key) throws JSONException {
		final Object object = this.get(key);
		if (object instanceof JSONArray) {
			return (JSONArray) object;
		}
		throw new JSONException("JSONObject[" + quote(key) + "] is not a JSONArray.");
	}

	public JSONObject getJSONObject(final String key) throws JSONException {
		final Object object = this.get(key);
		if (object instanceof JSONObject) {
			return (JSONObject) object;
		}
		throw new JSONException("JSONObject[" + quote(key) + "] is not a JSONObject.");
	}

	public long getLong(final String key) throws JSONException {
		final Object object = this.get(key);
		try {
			return (object instanceof Number) ? ((Number) object).longValue() : Long.parseLong((String) object);
		} catch (Exception e) {
			throw new JSONException("JSONObject[" + quote(key) + "] is not a long.");
		}
	}

	public String getString(final String key) throws JSONException {
		final Object object = this.get(key);
		return (object == JSONObject.NULL) ? null : object.toString();
	}

	public boolean has(final String key) {
		return this.map.containsKey(key);
	}

	public boolean isNull(final String key) {
		return JSONObject.NULL.equals(this.opt(key));
	}

	@SuppressWarnings("unchecked")
	public Iterator<String> keys() {
		return this.map.keySet().iterator();
	}

	public int length() {
		return this.map.size();
	}

	public JSONArray names() {
		final JSONArray ja = new JSONArray();
		final Iterator<String> keys = this.keys();
		while (keys.hasNext()) {
			ja.put(keys.next());
		}
		return (ja.length() == 0) ? null : ja;
	}

	public static String numberToString(final Number number) throws JSONException {
		if (number == null) {
			throw new JSONException("Null pointer");
		}
		testValidity(number);
		String string = number.toString();
		if (string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
			while (string.endsWith("0")) {
				string = string.substring(0, string.length() - 1);
			}
			if (string.endsWith(".")) {
				string = string.substring(0, string.length() - 1);
			}
		}
		return string;
	}

	public Object opt(final String key) {
		return (key == null) ? null : this.map.get(key);
	}

	@SuppressWarnings("unchecked")
	private void populateMap(final Object bean) {
		final Class<? extends Object> klass = bean.getClass();
		final boolean includeSuperClass = klass.getClassLoader() != null;
		final Method[] methods = includeSuperClass ? klass.getMethods() : klass.getDeclaredMethods();
		Method[] array;
		for (int length = (array = methods).length, i = 0; i < length; ++i) {
			final Method method1 = array[i];
			try {
				if (Modifier.isPublic(method1.getModifiers())) {
					final String name = method1.getName();
					String key = "";
					if (name.startsWith("get")) {
						if (name.equals("getClass") || name.equals("getDeclaringClass")) {
							key = "";
						} else {
							key = name.substring(3);
						}
					} else if (name.startsWith("is")) {
						key = name.substring(2);
					}
					if (key.length() > 0 && Character.isUpperCase(key.charAt(0))
							&& method1.getParameterTypes().length == 0) {
						if (key.length() == 1) {
							key = key.toLowerCase();
						} else if (!Character.isUpperCase(key.charAt(1))) {
							key = String.valueOf(key.substring(0, 1).toLowerCase()) + key.substring(1);
						}
						final Object result = method1.invoke(bean, (Object[]) null);
						if (result != null) {
							this.map.put(key, wrap(result));
						}
					}
				}
			} catch (Exception ex) {
			}
		}
	}

	public JSONObject put(final String key, final boolean value) throws JSONException {
		this.put(key, value ? Boolean.TRUE : Boolean.FALSE);
		return this;
	}

	public JSONObject put(final String key, final Collection<?> value) throws JSONException {
		this.put(key, new JSONArray(value));
		return this;
	}

	public JSONObject put(final String key, final double value) throws JSONException {
		this.put(key, new Double(value));
		return this;
	}

	public JSONObject put(final String key, final int value) throws JSONException {
		this.put(key, new Integer(value));
		return this;
	}

	public JSONObject put(final String key, final long value) throws JSONException {
		this.put(key, new Long(value));
		return this;
	}

	public JSONObject put(final String key, final Map<?, ?> value) throws JSONException {
		this.put(key, new JSONObject(value));
		return this;
	}

	@SuppressWarnings("unchecked")
	public JSONObject put(final String key, final Object value) throws JSONException {
		if (key == null) {
			throw new JSONException("Null key.");
		}
		if (value != null) {
			testValidity(value);
			this.map.put(key, value);
		} else {
			this.remove(key);
		}
		return this;
	}

	public JSONObject putOnce(final String key, final Object value) throws JSONException {
		if (key != null && value != null) {
			if (this.opt(key) != null) {
				throw new JSONException("Duplicate key \"" + key + "\"");
			}
			this.put(key, value);
		}
		return this;
	}

	public JSONObject putOpt(final String key, final Object value) throws JSONException {
		if (key != null && value != null) {
			this.put(key, value);
		}
		return this;
	}

	public static String quote(final String string) {
		if (string == null || string.length() == 0) {
			return "\"\"";
		}
		char c = '\0';
		final int len = string.length();
		final StringBuilder sb = new StringBuilder(len + 4);
		sb.append('\"');
		for (int i = 0; i < len; ++i) {
			final char b = c;
			c = string.charAt(i);
			switch (c) {
			case '\"':
			case '\\': {
				sb.append('\\');
				sb.append(c);
				break;
			}
			case '/': {
				if (b == '<') {
					sb.append('\\');
				}
				sb.append(c);
				break;
			}
			case '\b': {
				sb.append("\\b");
				break;
			}
			case '\t': {
				sb.append("\\t");
				break;
			}
			case '\n': {
				sb.append("\\n");
				break;
			}
			case '\f': {
				sb.append("\\f");
				break;
			}
			case '\r': {
				sb.append("\\r");
				break;
			}
			default: {
				if (c < ' ' || (c >= '\u0080' && c < ' ') || (c >= '\u2000' && c < '\u2100')) {
					final String hhhh = "000" + Integer.toHexString(c);
					sb.append("\\u").append(hhhh.substring(hhhh.length() - 4));
					break;
				}
				sb.append(c);
				break;
			}
			}
		}
		sb.append('\"');
		return sb.toString();
	}

	public Object remove(final String key) {
		return this.map.remove(key);
	}

	@SuppressWarnings("unchecked")
	public Iterator<Object> sortedKeys() {
		return new TreeSet<Object>(this.map.keySet()).iterator();
	}

	public static Object stringToValue(final String string) {
		if (string.equals("")) {
			return string;
		}
		if (string.equalsIgnoreCase("true")) {
			return Boolean.TRUE;
		}
		if (string.equalsIgnoreCase("false")) {
			return Boolean.FALSE;
		}
		if (string.equalsIgnoreCase("null")) {
			return JSONObject.NULL;
		}
		final char b = string.charAt(0);
		if ((b >= '0' && b <= '9') || b == '.' || b == '-' || b == '+') {
			Label_0139: {
				if (b == '0' && string.length() > 2) {
					if (string.charAt(1) != 'x') {
						if (string.charAt(1) != 'X') {
							break Label_0139;
						}
					}
					try {
						return Integer.parseInt(string.substring(2), 16);
					} catch (Exception ex) {
					}
				}
				try {
					if (string.indexOf(46) > -1 || string.indexOf(101) > -1 || string.indexOf(69) > -1) {
						return Double.valueOf(string);
					}
					final Long myLong = new Long(string);
					if (myLong == myLong.intValue()) {
						return myLong.intValue();
					}
					return myLong;
				} catch (Exception ex2) {
				}
			}
		}
		return string;
	}

	public static void testValidity(final Object o) throws JSONException {
		if (o != null) {
			if (o instanceof Double) {
				if (((Double) o).isInfinite() || ((Double) o).isNaN()) {
					throw new JSONException("JSON does not allow non-finite numbers.");
				}
			} else if (o instanceof Float && (((Float) o).isInfinite() || ((Float) o).isNaN())) {
				throw new JSONException("JSON does not allow non-finite numbers.");
			}
		}
	}

	@Override
	public String toString() {
		try {
			final Iterator<?> keys = this.keys();
			final StringBuilder sb = new StringBuilder("{");
			while (keys.hasNext()) {
				if (sb.length() > 1) {
					sb.append(',');
				}
				final Object o = keys.next();
				sb.append(quote(o.toString()));
				sb.append(':');
				sb.append(valueToString(this.map.get(o)));
			}
			sb.append('}');
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public String toString(final int indentFactor) throws JSONException {
		return this.toString(indentFactor, 0);
	}

	String toString(final int indentFactor, final int indent) throws JSONException {
		final int length = this.length();
		if (length == 0) {
			return "{}";
		}
		final Iterator<?> keys = this.sortedKeys();
		final int newindent = indent + indentFactor;
		final StringBuilder sb = new StringBuilder("{");
		if (length == 1) {
			final Object object = keys.next();
			sb.append(quote(object.toString()));
			sb.append(": ");
			sb.append(valueToString(this.map.get(object), indentFactor, indent));
		} else {
			while (keys.hasNext()) {
				final Object object = keys.next();
				if (sb.length() > 1) {
					sb.append(",\n");
				} else {
					sb.append('\n');
				}
				for (int i = 0; i < newindent; ++i) {
					sb.append(' ');
				}
				sb.append(quote(object.toString()));
				sb.append(": ");
				sb.append(valueToString(this.map.get(object), indentFactor, newindent));
			}
			if (sb.length() > 1) {
				sb.append('\n');
				for (int i = 0; i < indent; ++i) {
					sb.append(' ');
				}
			}
		}
		sb.append('}');
		return sb.toString();
	}

	public static String valueToString(final Object value) throws JSONException {
		if (value == null || value.equals(null)) {
			return "null";
		}
		if (value instanceof Number) {
			return numberToString((Number) value);
		}
		if (value instanceof Boolean || value instanceof JSONObject || value instanceof JSONArray) {
			return value.toString();
		}
		if (value instanceof Map) {
			return new JSONObject((Map<?, ?>) value).toString();
		}
		if (value instanceof Collection) {
			return new JSONArray((Collection<?>) value).toString();
		}
		if (value.getClass().isArray()) {
			return new JSONArray(value).toString();
		}
		return quote(value.toString());
	}

	static String valueToString(final Object value, final int indentFactor, final int indent) throws JSONException {
		if (value == null || value.equals(null)) {
			return "null";
		}
		if (value instanceof Number) {
			return numberToString((Number) value);
		}
		if (value instanceof Boolean) {
			return value.toString();
		}
		if (value instanceof JSONObject) {
			return ((JSONObject) value).toString(indentFactor, indent);
		}
		if (value instanceof JSONArray) {
			return ((JSONArray) value).toString(indentFactor, indent);
		}
		if (value instanceof Map) {
			return new JSONObject((Map<?, ?>) value).toString(indentFactor, indent);
		}
		if (value instanceof Collection) {
			return new JSONArray((Collection<?>) value).toString(indentFactor, indent);
		}
		if (value.getClass().isArray()) {
			return new JSONArray(value).toString(indentFactor, indent);
		}
		return quote(value.toString());
	}

	public static Object wrap(final Object object) {
		try {
			if (object == null) {
				return JSONObject.NULL;
			}
			if (object instanceof JSONObject || object instanceof JSONArray || JSONObject.NULL.equals(object)
					|| object instanceof Byte || object instanceof Character || object instanceof Short
					|| object instanceof Integer || object instanceof Long || object instanceof Boolean
					|| object instanceof Float || object instanceof Double || object instanceof String) {
				return object;
			}
			if (object instanceof Collection) {
				return new JSONArray((Collection<?>) object);
			}
			if (object.getClass().isArray()) {
				return new JSONArray(object);
			}
			if (object instanceof Map) {
				return new JSONObject((Map<?, ?>) object);
			}
			final Package objectPackage = object.getClass().getPackage();
			final String objectPackageName = (objectPackage != null) ? objectPackage.getName() : "";
			if (objectPackageName.startsWith("java.") || objectPackageName.startsWith("javax.")
					|| object.getClass().getClassLoader() == null) {
				return object.toString();
			}
			return new JSONObject(object);
		} catch (Exception exception) {
			return null;
		}
	}

	public Writer write(final Writer writer) throws JSONException {
		try {
			boolean commanate = false;
			final Iterator<?> keys = this.keys();
			writer.write(123);
			while (keys.hasNext()) {
				if (commanate) {
					writer.write(44);
				}
				final Object key = keys.next();
				writer.write(quote(key.toString()));
				writer.write(58);
				final Object value = this.map.get(key);
				if (value instanceof JSONObject) {
					((JSONObject) value).write(writer);
				} else if (value instanceof JSONArray) {
					((JSONArray) value).write(writer);
				} else {
					writer.write(valueToString(value));
				}
				commanate = true;
			}
			writer.write(125);
			return writer;
		} catch (IOException exception) {
			throw new JSONException(exception);
		}
	}

	private static final class Null {
		@Override
		protected final Object clone() {
			return this;
		}

		@Override
		public boolean equals(final Object object) {
			return object == null || object == this;
		}

		@Override
		public String toString() {
			return "null";
		}
	}
}
