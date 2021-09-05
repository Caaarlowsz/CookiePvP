package twitter4j;

import twitter4j.auth.Authorization;
import java.io.IOException;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public abstract class HttpClientBase implements HttpClient, Serializable
{
    private static final Logger logger;
    private static final long serialVersionUID = -8016974810651763053L;
    protected final HttpClientConfiguration CONF;
    private final Map<String, String> requestHeaders;
    
    static {
        logger = Logger.getLogger(HttpClientBase.class);
    }
    
    public HttpClientBase(final HttpClientConfiguration conf) {
        this.CONF = conf;
        (this.requestHeaders = new HashMap<String, String>()).put("X-Twitter-Client-Version", Version.getVersion());
        this.requestHeaders.put("X-Twitter-Client-URL", "http://twitter4j.org/en/twitter4j-" + Version.getVersion() + ".xml");
        this.requestHeaders.put("X-Twitter-Client", "Twitter4J");
        this.requestHeaders.put("User-Agent", "twitter4j http://twitter4j.org/ /" + Version.getVersion());
        if (conf.isGZIPEnabled()) {
            this.requestHeaders.put("Accept-Encoding", "gzip");
        }
    }
    
    protected boolean isProxyConfigured() {
        return this.CONF.getHttpProxyHost() != null && !this.CONF.getHttpProxyHost().equals("");
    }
    
    public void write(final DataOutputStream out, final String outStr) throws IOException {
        out.writeBytes(outStr);
        HttpClientBase.logger.debug(outStr);
    }
    
    @Override
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }
    
    @Override
    public void addDefaultRequestHeader(final String name, final String value) {
        this.requestHeaders.put(name, value);
    }
    
    @Override
    public final HttpResponse request(final HttpRequest req) throws TwitterException {
        return this.handleRequest(req);
    }
    
    @Override
    public final HttpResponse request(final HttpRequest req, final HttpResponseListener listener) throws TwitterException {
        try {
            final HttpResponse res = this.handleRequest(req);
            if (listener != null) {
                listener.httpResponseReceived(new HttpResponseEvent(req, res, null));
            }
            return res;
        }
        catch (TwitterException te) {
            if (listener != null) {
                listener.httpResponseReceived(new HttpResponseEvent(req, null, te));
            }
            throw te;
        }
    }
    
    abstract HttpResponse handleRequest(final HttpRequest p0) throws TwitterException;
    
    @Override
    public HttpResponse get(final String url, final HttpParameter[] parameters, final Authorization authorization, final HttpResponseListener listener) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.GET, url, parameters, authorization, this.requestHeaders), listener);
    }
    
    @Override
    public HttpResponse get(final String url) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.GET, url, null, null, this.requestHeaders));
    }
    
    @Override
    public HttpResponse post(final String url, final HttpParameter[] parameters, final Authorization authorization, final HttpResponseListener listener) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.POST, url, parameters, authorization, this.requestHeaders), listener);
    }
    
    @Override
    public HttpResponse post(final String url) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.POST, url, null, null, this.requestHeaders));
    }
    
    @Override
    public HttpResponse delete(final String url, final HttpParameter[] parameters, final Authorization authorization, final HttpResponseListener listener) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.DELETE, url, parameters, authorization, this.requestHeaders), listener);
    }
    
    @Override
    public HttpResponse delete(final String url) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.DELETE, url, null, null, this.requestHeaders));
    }
    
    @Override
    public HttpResponse head(final String url) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.HEAD, url, null, null, this.requestHeaders));
    }
    
    @Override
    public HttpResponse put(final String url, final HttpParameter[] parameters, final Authorization authorization, final HttpResponseListener listener) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.PUT, url, parameters, authorization, this.requestHeaders), listener);
    }
    
    @Override
    public HttpResponse put(final String url) throws TwitterException {
        return this.request(new HttpRequest(RequestMethod.PUT, url, null, null, this.requestHeaders));
    }
}
