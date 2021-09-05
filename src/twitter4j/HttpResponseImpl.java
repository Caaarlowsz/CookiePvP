package twitter4j;

import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpResponseImpl extends HttpResponse
{
    private HttpURLConnection con;
    
    HttpResponseImpl(final HttpURLConnection con, final HttpClientConfiguration conf) throws IOException {
        super(conf);
        this.con = con;
        try {
            this.statusCode = con.getResponseCode();
        }
        catch (IOException e) {
            if (!"Received authentication challenge is null".equals(e.getMessage())) {
                throw e;
            }
            this.statusCode = con.getResponseCode();
        }
        final InputStream errorStream = con.getErrorStream();
        this.is = errorStream;
        if (errorStream == null) {
            this.is = con.getInputStream();
        }
        if (this.is != null && "gzip".equals(con.getContentEncoding())) {
            this.is = new StreamingGZIPInputStream(this.is);
        }
    }
    
    HttpResponseImpl(final String content) {
        this.responseAsString = content;
    }
    
    @Override
    public String getResponseHeader(final String name) {
        return this.con.getHeaderField(name);
    }
    
    @Override
    public Map<String, List<String>> getResponseHeaderFields() {
        return this.con.getHeaderFields();
    }
    
    @Override
    public void disconnect() {
        this.con.disconnect();
    }
}
