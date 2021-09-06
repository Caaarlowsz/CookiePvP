package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public final class HttpParameter implements Comparable<HttpParameter>, Serializable {
	private static final long serialVersionUID = 4046908449190454692L;
	private String name;
	private String value;
	private File file;
	private InputStream fileBody;

	public HttpParameter(final String name, final String value) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.value = value;
	}

	public HttpParameter(final String name, final File file) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.file = file;
	}

	public HttpParameter(final String name, final String fileName, final InputStream fileBody) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.file = new File(fileName);
		this.fileBody = fileBody;
	}

	public HttpParameter(final String name, final int value) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.value = String.valueOf(value);
	}

	public HttpParameter(final String name, final long value) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.value = String.valueOf(value);
	}

	public HttpParameter(final String name, final double value) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.value = String.valueOf(value);
	}

	public HttpParameter(final String name, final boolean value) {
		this.name = null;
		this.value = null;
		this.file = null;
		this.fileBody = null;
		this.name = name;
		this.value = String.valueOf(value);
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	public File getFile() {
		return this.file;
	}

	public InputStream getFileBody() {
		return this.fileBody;
	}

	public boolean isFile() {
		return this.file != null;
	}

	public boolean hasFileBody() {
		return this.fileBody != null;
	}

	public String getContentType() {
		if (!this.isFile()) {
			throw new IllegalStateException("not a file");
		}
		String extensions = this.file.getName();
		final int index = extensions.lastIndexOf(".");
		String contentType;
		if (-1 == index) {
			contentType = "application/octet-stream";
		} else {
			extensions = extensions.substring(extensions.lastIndexOf(".") + 1).toLowerCase();
			if (extensions.length() == 3) {
				if ("gif".equals(extensions)) {
					contentType = "image/gif";
				} else if ("png".equals(extensions)) {
					contentType = "image/png";
				} else if ("jpg".equals(extensions)) {
					contentType = "image/jpeg";
				} else {
					contentType = "application/octet-stream";
				}
			} else if (extensions.length() == 4) {
				if ("jpeg".equals(extensions)) {
					contentType = "image/jpeg";
				} else {
					contentType = "application/octet-stream";
				}
			} else {
				contentType = "application/octet-stream";
			}
		}
		return contentType;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof HttpParameter)) {
			return false;
		}
		final HttpParameter that = (HttpParameter) o;
		Label_0054: {
			if (this.file != null) {
				if (this.file.equals(that.file)) {
					break Label_0054;
				}
			} else if (that.file == null) {
				break Label_0054;
			}
			return false;
		}
		Label_0087: {
			if (this.fileBody != null) {
				if (this.fileBody.equals(that.fileBody)) {
					break Label_0087;
				}
			} else if (that.fileBody == null) {
				break Label_0087;
			}
			return false;
		}
		if (!this.name.equals(that.name)) {
			return false;
		}
		if (this.value != null) {
			if (this.value.equals(that.value)) {
				return true;
			}
		} else if (that.value == null) {
			return true;
		}
		return false;
	}

	public static boolean containsFile(final HttpParameter[] params) {
		boolean containsFile = false;
		if (params == null) {
			return false;
		}
		for (final HttpParameter param : params) {
			if (param.isFile()) {
				containsFile = true;
				break;
			}
		}
		return containsFile;
	}

	static boolean containsFile(final List<HttpParameter> params) {
		boolean containsFile = false;
		for (final HttpParameter param : params) {
			if (param.isFile()) {
				containsFile = true;
				break;
			}
		}
		return containsFile;
	}

	public static HttpParameter[] getParameterArray(final String name, final String value) {
		return new HttpParameter[] { new HttpParameter(name, value) };
	}

	public static HttpParameter[] getParameterArray(final String name, final int value) {
		return getParameterArray(name, String.valueOf(value));
	}

	public static HttpParameter[] getParameterArray(final String name1, final String value1, final String name2,
			final String value2) {
		return new HttpParameter[] { new HttpParameter(name1, value1), new HttpParameter(name2, value2) };
	}

	public static HttpParameter[] getParameterArray(final String name1, final int value1, final String name2,
			final int value2) {
		return getParameterArray(name1, String.valueOf(value1), name2, String.valueOf(value2));
	}

	@Override
	public int hashCode() {
		int result = this.name.hashCode();
		result = 31 * result + ((this.value != null) ? this.value.hashCode() : 0);
		result = 31 * result + ((this.file != null) ? this.file.hashCode() : 0);
		result = 31 * result + ((this.fileBody != null) ? this.fileBody.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "PostParameter{name='" + this.name + '\'' + ", value='" + this.value + '\'' + ", file=" + this.file
				+ ", fileBody=" + this.fileBody + '}';
	}

	@Override
	public int compareTo(final HttpParameter o) {
		int compared = this.name.compareTo(o.name);
		if (compared == 0) {
			compared = this.value.compareTo(o.value);
		}
		return compared;
	}

	public static String encodeParameters(final HttpParameter[] httpParams) {
		if (httpParams == null) {
			return "";
		}
		final StringBuilder buf = new StringBuilder();
		for (int j = 0; j < httpParams.length; ++j) {
			if (httpParams[j].isFile()) {
				throw new IllegalArgumentException("parameter [" + httpParams[j].name + "]should be text");
			}
			if (j != 0) {
				buf.append("&");
			}
			buf.append(encode(httpParams[j].name)).append("=").append(encode(httpParams[j].value));
		}
		return buf.toString();
	}

	public static String encode(final String value) {
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
		final StringBuilder buf = new StringBuilder(encoded.length());
		for (int i = 0; i < encoded.length(); ++i) {
			final char focus = encoded.charAt(i);
			if (focus == '*') {
				buf.append("%2A");
			} else if (focus == '+') {
				buf.append("%20");
			} else if (focus == '%' && i + 1 < encoded.length() && encoded.charAt(i + 1) == '7'
					&& encoded.charAt(i + 2) == 'E') {
				buf.append('~');
				i += 2;
			} else {
				buf.append(focus);
			}
		}
		return buf.toString();
	}

	public static String decode(String value) {
		value = value.replace("%2A", "*");
		value = value.replace("%2a", "*");
		value = value.replace("%20", " ");
		String decoded = null;
		try {
			decoded = URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
		return decoded;
	}

	public static List<HttpParameter> decodeParameters(final String queryParameters) {
		final List<HttpParameter> result = new ArrayList<HttpParameter>();
		String[] split;
		for (int length = (split = queryParameters.split("&")).length, i = 0; i < length; ++i) {
			final String pair = split[i];
			final String[] parts = pair.split("=", 2);
			if (parts.length == 2) {
				final String name = decode(parts[0]);
				final String value = decode(parts[1]);
				if (!name.equals("") && !value.equals("")) {
					result.add(new HttpParameter(name, value));
				}
			}
		}
		return result;
	}
}
