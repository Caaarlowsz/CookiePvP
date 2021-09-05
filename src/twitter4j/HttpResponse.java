package twitter4j;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;
import java.io.InputStream;

public abstract class HttpResponse
{
    private static final Logger logger;
    protected final HttpClientConfiguration CONF;
    protected int statusCode;
    protected String responseAsString;
    protected InputStream is;
    private boolean streamConsumed;
    private JSONObject json;
    private JSONArray jsonArray;
    
    static {
        logger = Logger.getLogger(HttpResponseImpl.class);
    }
    
    HttpResponse() {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = ConfigurationContext.getInstance().getHttpClientConfiguration();
    }
    
    public HttpResponse(final HttpClientConfiguration conf) {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = conf;
    }
    
    public int getStatusCode() {
        return this.statusCode;
    }
    
    public abstract String getResponseHeader(final String p0);
    
    public abstract Map<String, List<String>> getResponseHeaderFields();
    
    public InputStream asStream() {
        if (this.streamConsumed) {
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return this.is;
    }
    
    public String asString() throws TwitterException {
        if (this.responseAsString == null) {
            BufferedReader br = null;
            InputStream stream = null;
            try {
                stream = this.asStream();
                if (stream == null) {
                    return null;
                }
                br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                final StringBuilder buf = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    buf.append(line).append("\n");
                }
                this.responseAsString = buf.toString();
                HttpResponse.logger.debug(this.responseAsString);
                stream.close();
                this.streamConsumed = true;
            }
            catch (IOException ioe) {
                throw new TwitterException(ioe.getMessage(), ioe);
            }
            finally {
                if (stream != null) {
                    try {
                        stream.close();
                    }
                    catch (IOException ex) {}
                }
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (IOException ex2) {}
                }
                this.disconnectForcibly();
            }
            if (stream != null) {
                try {
                    stream.close();
                }
                catch (IOException ex3) {}
            }
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException ex4) {}
            }
            this.disconnectForcibly();
        }
        return this.responseAsString;
    }
    
    public JSONObject asJSONObject() throws TwitterException {
        if (this.json == null) {
            Reader reader = null;
            try {
                if (this.responseAsString == null) {
                    reader = this.asReader();
                    this.json = new JSONObject(new JSONTokener(reader));
                }
                else {
                    this.json = new JSONObject(this.responseAsString);
                }
                if (this.CONF.isPrettyDebugEnabled()) {
                    HttpResponse.logger.debug(this.json.toString(1));
                }
                else {
                    HttpResponse.logger.debug((this.responseAsString != null) ? this.responseAsString : this.json.toString());
                }
            }
            catch (JSONException jsone) {
                if (this.responseAsString == null) {
                    throw new TwitterException(jsone.getMessage(), jsone);
                }
                throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + this.responseAsString, jsone);
            }
            finally {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException ex) {}
                }
                this.disconnectForcibly();
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException ex2) {}
            }
            this.disconnectForcibly();
        }
        return this.json;
    }
    
    public JSONArray asJSONArray() throws TwitterException {
        if (this.jsonArray == null) {
            Reader reader = null;
            try {
                if (this.responseAsString == null) {
                    reader = this.asReader();
                    this.jsonArray = new JSONArray(new JSONTokener(reader));
                }
                else {
                    this.jsonArray = new JSONArray(this.responseAsString);
                }
                if (this.CONF.isPrettyDebugEnabled()) {
                    HttpResponse.logger.debug(this.jsonArray.toString(1));
                }
                else {
                    HttpResponse.logger.debug((this.responseAsString != null) ? this.responseAsString : this.jsonArray.toString());
                }
            }
            catch (JSONException jsone) {
                if (HttpResponse.logger.isDebugEnabled()) {
                    throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + this.responseAsString, jsone);
                }
                throw new TwitterException(jsone.getMessage(), jsone);
            }
            finally {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException ex) {}
                }
                this.disconnectForcibly();
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException ex2) {}
            }
            this.disconnectForcibly();
        }
        return this.jsonArray;
    }
    
    public Reader asReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.is, "UTF-8"));
        }
        catch (UnsupportedEncodingException uee) {
            return new InputStreamReader(this.is);
        }
    }
    
    private void disconnectForcibly() {
        try {
            this.disconnect();
        }
        catch (Exception ex) {}
    }
    
    public abstract void disconnect() throws IOException;
    
    @Override
    public String toString() {
        return "HttpResponse{statusCode=" + this.statusCode + ", responseAsString='" + this.responseAsString + '\'' + ", is=" + this.is + ", streamConsumed=" + this.streamConsumed + '}';
    }
}
