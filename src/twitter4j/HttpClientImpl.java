package twitter4j;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import twitter4j.conf.ConfigurationContext;

class HttpClientImpl extends HttpClientBase implements HttpResponseCode, Serializable {
	private static final Logger logger;
	private static final long serialVersionUID = -403500272719330534L;
	private static final Map<HttpClientConfiguration, HttpClient> instanceMap;

	static {
		logger = Logger.getLogger(HttpClientImpl.class);
		try {
			if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get(null)) < 8) {
				System.setProperty("http.keepAlive", "false");
			}
		} catch (Exception ex) {
		}
		instanceMap = new HashMap<HttpClientConfiguration, HttpClient>(1);
	}

	public HttpClientImpl() {
		super(ConfigurationContext.getInstance().getHttpClientConfiguration());
	}

	public HttpClientImpl(final HttpClientConfiguration conf) {
		super(conf);
	}

	public static HttpClient getInstance(final HttpClientConfiguration conf) {
		HttpClient client = HttpClientImpl.instanceMap.get(conf);
		if (client == null) {
			client = new HttpClientImpl(conf);
			HttpClientImpl.instanceMap.put(conf, client);
		}
		return client;
	}

	@Override
	public HttpResponse get(final String url) throws TwitterException {
		return this.request(new HttpRequest(RequestMethod.GET, url, null, null, null));
	}

	public HttpResponse post(final String url, final HttpParameter[] params) throws TwitterException {
		return this.request(new HttpRequest(RequestMethod.POST, url, params, null, null));
	}

	public HttpResponse handleRequest(final HttpRequest req) throws TwitterException {
		final int retry = this.CONF.getHttpRetryCount() + 1;
		HttpResponse res = null;
		for (int retriedCount = 0; retriedCount < retry; ++retriedCount) {
			int responseCode = -1;
			try {
				OutputStream os = null;
				try {
					final HttpURLConnection con = this.getConnection(req.getURL());
					con.setDoInput(true);
					this.setHeaders(req, con);
					con.setRequestMethod(req.getMethod().name());
					if (req.getMethod() == RequestMethod.POST) {
						if (HttpParameter.containsFile(req.getParameters())) {
							String boundary = "----Twitter4J-upload" + System.currentTimeMillis();
							con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
							boundary = "--" + boundary;
							con.setDoOutput(true);
							os = con.getOutputStream();
							final DataOutputStream out = new DataOutputStream(os);
							HttpParameter[] parameters;
							for (int length2 = (parameters = req.getParameters()).length, i = 0; i < length2; ++i) {
								final HttpParameter param = parameters[i];
								if (param.isFile()) {
									this.write(out, String.valueOf(boundary) + "\r\n");
									this.write(out, "Content-Disposition: form-data; name=\"" + param.getName()
											+ "\"; filename=\"" + param.getFile().getName() + "\"\r\n");
									this.write(out, "Content-Type: " + param.getContentType() + "\r\n\r\n");
									final BufferedInputStream in = new BufferedInputStream(
											param.hasFileBody() ? param.getFileBody()
													: new FileInputStream(param.getFile()));
									final byte[] buff = new byte[1024];
									int length;
									while ((length = in.read(buff)) != -1) {
										out.write(buff, 0, length);
									}
									this.write(out, "\r\n");
									in.close();
								} else {
									this.write(out, String.valueOf(boundary) + "\r\n");
									this.write(out,
											"Content-Disposition: form-data; name=\"" + param.getName() + "\"\r\n");
									this.write(out, "Content-Type: text/plain; charset=UTF-8\r\n\r\n");
									HttpClientImpl.logger.debug(param.getValue());
									out.write(param.getValue().getBytes("UTF-8"));
									this.write(out, "\r\n");
								}
							}
							this.write(out, String.valueOf(boundary) + "--\r\n");
							this.write(out, "\r\n");
						} else {
							con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
							final String postParam = HttpParameter.encodeParameters(req.getParameters());
							HttpClientImpl.logger.debug("Post Params: ", postParam);
							final byte[] bytes = postParam.getBytes("UTF-8");
							con.setRequestProperty("Content-Length", Integer.toString(bytes.length));
							con.setDoOutput(true);
							os = con.getOutputStream();
							os.write(bytes);
						}
						os.flush();
						os.close();
					}
					res = new HttpResponseImpl(con, this.CONF);
					responseCode = con.getResponseCode();
					if (HttpClientImpl.logger.isDebugEnabled()) {
						HttpClientImpl.logger.debug("Response: ");
						final Map<String, List<String>> responseHeaders = con.getHeaderFields();
						for (final String key : responseHeaders.keySet()) {
							final List<String> values = responseHeaders.get(key);
							for (final String value : values) {
								if (key != null) {
									HttpClientImpl.logger.debug(String.valueOf(key) + ": " + value);
								} else {
									HttpClientImpl.logger.debug(value);
								}
							}
						}
					}
					if (responseCode < 200 || (responseCode != 302 && 300 <= responseCode)) {
						if (responseCode == 420 || responseCode == 400 || responseCode < 500
								|| retriedCount == this.CONF.getHttpRetryCount()) {
							throw new TwitterException(res.asString(), res);
						}
					}
				} finally {
					try {
						os.close();
					} catch (Exception ex) {
					}
				}
				try {
					os.close();
				} catch (Exception ex2) {
				}
			} catch (IOException ioe) {
				if (retriedCount == this.CONF.getHttpRetryCount()) {
					throw new TwitterException(ioe.getMessage(), ioe, responseCode);
				}
			}
			try {
				if (HttpClientImpl.logger.isDebugEnabled() && res != null) {
					res.asString();
				}
				HttpClientImpl.logger.debug(
						"Sleeping " + this.CONF.getHttpRetryIntervalSeconds() + " seconds until the next retry.");
				Thread.sleep(this.CONF.getHttpRetryIntervalSeconds() * 1000);
			} catch (InterruptedException ex3) {
			}
		}
		return res;
	}

	private void setHeaders(final HttpRequest req, final HttpURLConnection connection) {
		if (HttpClientImpl.logger.isDebugEnabled()) {
			HttpClientImpl.logger.debug("Request: ");
			HttpClientImpl.logger.debug(String.valueOf(req.getMethod().name()) + " ", req.getURL());
		}
		final String authorizationHeader;
		if (req.getAuthorization() != null
				&& (authorizationHeader = req.getAuthorization().getAuthorizationHeader(req)) != null) {
			if (HttpClientImpl.logger.isDebugEnabled()) {
				HttpClientImpl.logger.debug("Authorization: ", authorizationHeader.replaceAll(".", "*"));
			}
			connection.addRequestProperty("Authorization", authorizationHeader);
		}
		if (req.getRequestHeaders() != null) {
			for (final String key : req.getRequestHeaders().keySet()) {
				connection.addRequestProperty(key, req.getRequestHeaders().get(key));
				HttpClientImpl.logger.debug(String.valueOf(key) + ": " + req.getRequestHeaders().get(key));
			}
		}
	}

	HttpURLConnection getConnection(final String url) throws IOException {
		HttpURLConnection con;
		if (this.isProxyConfigured()) {
			if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
				if (HttpClientImpl.logger.isDebugEnabled()) {
					HttpClientImpl.logger.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
					HttpClientImpl.logger
							.debug("Proxy AuthPassword: " + this.CONF.getHttpProxyPassword().replaceAll(".", "*"));
				}
				Authenticator.setDefault(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						if (this.getRequestorType().equals(RequestorType.PROXY)) {
							return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(),
									HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
						}
						return null;
					}
				});
			}
			final Proxy proxy = new Proxy(Proxy.Type.HTTP,
					InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
			if (HttpClientImpl.logger.isDebugEnabled()) {
				HttpClientImpl.logger.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":"
						+ this.CONF.getHttpProxyPort() + ")");
			}
			con = (HttpURLConnection) new URL(url).openConnection(proxy);
		} else {
			con = (HttpURLConnection) new URL(url).openConnection();
		}
		if (this.CONF.getHttpConnectionTimeout() > 0) {
			con.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
		}
		if (this.CONF.getHttpReadTimeout() > 0) {
			con.setReadTimeout(this.CONF.getHttpReadTimeout());
		}
		con.setInstanceFollowRedirects(false);
		return con;
	}
}
