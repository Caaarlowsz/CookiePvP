package twitter4j.auth;

import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import twitter4j.BASE64Encoder;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import twitter4j.HttpResponseListener;
import java.util.ArrayList;
import twitter4j.TwitterException;
import twitter4j.HttpRequest;
import twitter4j.HttpClientFactory;
import java.util.Random;
import twitter4j.Logger;
import twitter4j.HttpParameter;
import twitter4j.HttpClient;
import twitter4j.conf.Configuration;
import java.io.Serializable;

public class OAuthAuthorization implements Authorization, Serializable, OAuthSupport
{
    private static final long serialVersionUID = -886869424811858868L;
    private final Configuration conf;
    private static transient HttpClient http;
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final HttpParameter OAUTH_SIGNATURE_METHOD;
    private static final Logger logger;
    private String consumerKey;
    private String consumerSecret;
    private String realm;
    private OAuthToken oauthToken;
    private static final Random RAND;
    
    static {
        OAUTH_SIGNATURE_METHOD = new HttpParameter("oauth_signature_method", "HMAC-SHA1");
        logger = Logger.getLogger(OAuthAuthorization.class);
        RAND = new Random();
    }
    
    public OAuthAuthorization(final Configuration conf) {
        this.consumerKey = "";
        this.realm = null;
        this.oauthToken = null;
        this.conf = conf;
        OAuthAuthorization.http = HttpClientFactory.getInstance(conf.getHttpClientConfiguration());
        this.setOAuthConsumer(conf.getOAuthConsumerKey(), conf.getOAuthConsumerSecret());
        if (conf.getOAuthAccessToken() != null && conf.getOAuthAccessTokenSecret() != null) {
            this.setOAuthAccessToken(new AccessToken(conf.getOAuthAccessToken(), conf.getOAuthAccessTokenSecret()));
        }
    }
    
    @Override
    public String getAuthorizationHeader(final HttpRequest req) {
        return this.generateAuthorizationHeader(req.getMethod().name(), req.getURL(), req.getParameters(), this.oauthToken);
    }
    
    private void ensureTokenIsAvailable() {
        if (this.oauthToken == null) {
            throw new IllegalStateException("No Token available.");
        }
    }
    
    @Override
    public boolean isEnabled() {
        return this.oauthToken != null && this.oauthToken instanceof AccessToken;
    }
    
    @Override
    public RequestToken getOAuthRequestToken() throws TwitterException {
        return this.getOAuthRequestToken(null, null, null);
    }
    
    @Override
    public RequestToken getOAuthRequestToken(final String callbackURL) throws TwitterException {
        return this.getOAuthRequestToken(callbackURL, null, null);
    }
    
    @Override
    public RequestToken getOAuthRequestToken(final String callbackURL, final String xAuthAccessType) throws TwitterException {
        return this.getOAuthRequestToken(callbackURL, xAuthAccessType, null);
    }
    
    @Override
    public RequestToken getOAuthRequestToken(final String callbackURL, final String xAuthAccessType, final String xAuthMode) throws TwitterException {
        if (this.oauthToken instanceof AccessToken) {
            throw new IllegalStateException("Access token already available.");
        }
        final List<HttpParameter> params = new ArrayList<HttpParameter>();
        if (callbackURL != null) {
            params.add(new HttpParameter("oauth_callback", callbackURL));
        }
        if (xAuthAccessType != null) {
            params.add(new HttpParameter("x_auth_access_type", xAuthAccessType));
        }
        if (xAuthMode != null) {
            params.add(new HttpParameter("x_auth_mode", xAuthMode));
        }
        this.oauthToken = new RequestToken(OAuthAuthorization.http.post(this.conf.getOAuthRequestTokenURL(), params.toArray(new HttpParameter[params.size()]), this, null), this);
        return (RequestToken)this.oauthToken;
    }
    
    @Override
    public AccessToken getOAuthAccessToken() throws TwitterException {
        this.ensureTokenIsAvailable();
        if (this.oauthToken instanceof AccessToken) {
            return (AccessToken)this.oauthToken;
        }
        this.oauthToken = new AccessToken(OAuthAuthorization.http.post(this.conf.getOAuthAccessTokenURL(), null, this, null));
        return (AccessToken)this.oauthToken;
    }
    
    @Override
    public AccessToken getOAuthAccessToken(final String oauthVerifier) throws TwitterException {
        this.ensureTokenIsAvailable();
        this.oauthToken = new AccessToken(OAuthAuthorization.http.post(this.conf.getOAuthAccessTokenURL(), new HttpParameter[] { new HttpParameter("oauth_verifier", oauthVerifier) }, this, null));
        return (AccessToken)this.oauthToken;
    }
    
    @Override
    public AccessToken getOAuthAccessToken(final RequestToken requestToken) throws TwitterException {
        this.oauthToken = requestToken;
        return this.getOAuthAccessToken();
    }
    
    @Override
    public AccessToken getOAuthAccessToken(final RequestToken requestToken, final String oauthVerifier) throws TwitterException {
        this.oauthToken = requestToken;
        return this.getOAuthAccessToken(oauthVerifier);
    }
    
    @Override
    public AccessToken getOAuthAccessToken(final String screenName, final String password) throws TwitterException {
        try {
            String url = this.conf.getOAuthAccessTokenURL();
            if (url.indexOf("http://") == 0) {
                url = "https://" + url.substring(7);
            }
            this.oauthToken = new AccessToken(OAuthAuthorization.http.post(url, new HttpParameter[] { new HttpParameter("x_auth_username", screenName), new HttpParameter("x_auth_password", password), new HttpParameter("x_auth_mode", "client_auth") }, this, null));
            return (AccessToken)this.oauthToken;
        }
        catch (TwitterException te) {
            throw new TwitterException("The screen name / password combination seems to be invalid.", te, te.getStatusCode());
        }
    }
    
    @Override
    public void setOAuthAccessToken(final AccessToken accessToken) {
        this.oauthToken = accessToken;
    }
    
    public void setOAuthRealm(final String realm) {
        this.realm = realm;
    }
    
    String generateAuthorizationHeader(final String method, final String url, HttpParameter[] params, final String nonce, final String timestamp, final OAuthToken otoken) {
        if (params == null) {
            params = new HttpParameter[0];
        }
        final List<HttpParameter> oauthHeaderParams = new ArrayList<HttpParameter>(5);
        oauthHeaderParams.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
        oauthHeaderParams.add(OAuthAuthorization.OAUTH_SIGNATURE_METHOD);
        oauthHeaderParams.add(new HttpParameter("oauth_timestamp", timestamp));
        oauthHeaderParams.add(new HttpParameter("oauth_nonce", nonce));
        oauthHeaderParams.add(new HttpParameter("oauth_version", "1.0"));
        if (otoken != null) {
            oauthHeaderParams.add(new HttpParameter("oauth_token", otoken.getToken()));
        }
        final List<HttpParameter> signatureBaseParams = new ArrayList<HttpParameter>(oauthHeaderParams.size() + params.length);
        signatureBaseParams.addAll(oauthHeaderParams);
        if (!HttpParameter.containsFile(params)) {
            signatureBaseParams.addAll(toParamList(params));
        }
        this.parseGetParameters(url, signatureBaseParams);
        final StringBuilder base = new StringBuilder(method).append("&").append(HttpParameter.encode(constructRequestURL(url))).append("&");
        base.append(HttpParameter.encode(normalizeRequestParameters(signatureBaseParams)));
        final String oauthBaseString = base.toString();
        OAuthAuthorization.logger.debug("OAuth base string: ", oauthBaseString);
        final String signature = this.generateSignature(oauthBaseString, otoken);
        OAuthAuthorization.logger.debug("OAuth signature: ", signature);
        oauthHeaderParams.add(new HttpParameter("oauth_signature", signature));
        if (this.realm != null) {
            oauthHeaderParams.add(new HttpParameter("realm", this.realm));
        }
        return "OAuth " + encodeParameters(oauthHeaderParams, ",", true);
    }
    
    private void parseGetParameters(final String url, final List<HttpParameter> signatureBaseParams) {
        final int queryStart = url.indexOf("?");
        if (-1 != queryStart) {
            url.split("&");
            final String[] queryStrs = url.substring(queryStart + 1).split("&");
            try {
                String[] array;
                for (int length = (array = queryStrs).length, i = 0; i < length; ++i) {
                    final String query = array[i];
                    final String[] split = query.split("=");
                    if (split.length == 2) {
                        signatureBaseParams.add(new HttpParameter(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8")));
                    }
                    else {
                        signatureBaseParams.add(new HttpParameter(URLDecoder.decode(split[0], "UTF-8"), ""));
                    }
                }
            }
            catch (UnsupportedEncodingException ex) {}
        }
    }
    
    String generateAuthorizationHeader(final String method, final String url, final HttpParameter[] params, final OAuthToken token) {
        final long timestamp = System.currentTimeMillis() / 1000L;
        final long nonce = timestamp + OAuthAuthorization.RAND.nextInt();
        return this.generateAuthorizationHeader(method, url, params, String.valueOf(nonce), String.valueOf(timestamp), token);
    }
    
    public List<HttpParameter> generateOAuthSignatureHttpParams(final String method, final String url) {
        final long timestamp = System.currentTimeMillis() / 1000L;
        final long nonce = timestamp + OAuthAuthorization.RAND.nextInt();
        final List<HttpParameter> oauthHeaderParams = new ArrayList<HttpParameter>(5);
        oauthHeaderParams.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
        oauthHeaderParams.add(OAuthAuthorization.OAUTH_SIGNATURE_METHOD);
        oauthHeaderParams.add(new HttpParameter("oauth_timestamp", timestamp));
        oauthHeaderParams.add(new HttpParameter("oauth_nonce", nonce));
        oauthHeaderParams.add(new HttpParameter("oauth_version", "1.0"));
        if (this.oauthToken != null) {
            oauthHeaderParams.add(new HttpParameter("oauth_token", this.oauthToken.getToken()));
        }
        final List<HttpParameter> signatureBaseParams = new ArrayList<HttpParameter>(oauthHeaderParams.size());
        signatureBaseParams.addAll(oauthHeaderParams);
        this.parseGetParameters(url, signatureBaseParams);
        final StringBuilder base = new StringBuilder(method).append("&").append(HttpParameter.encode(constructRequestURL(url))).append("&");
        base.append(HttpParameter.encode(normalizeRequestParameters(signatureBaseParams)));
        final String oauthBaseString = base.toString();
        final String signature = this.generateSignature(oauthBaseString, this.oauthToken);
        oauthHeaderParams.add(new HttpParameter("oauth_signature", signature));
        return oauthHeaderParams;
    }
    
    String generateSignature(final String data, final OAuthToken token) {
        byte[] byteHMAC = null;
        try {
            final Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec spec;
            if (token == null) {
                final String oauthSignature = String.valueOf(HttpParameter.encode(this.consumerSecret)) + "&";
                spec = new SecretKeySpec(oauthSignature.getBytes(), "HmacSHA1");
            }
            else {
                spec = token.getSecretKeySpec();
                if (spec == null) {
                    final String oauthSignature = String.valueOf(HttpParameter.encode(this.consumerSecret)) + "&" + HttpParameter.encode(token.getTokenSecret());
                    spec = new SecretKeySpec(oauthSignature.getBytes(), "HmacSHA1");
                    token.setSecretKeySpec(spec);
                }
            }
            mac.init(spec);
            byteHMAC = mac.doFinal(data.getBytes());
        }
        catch (InvalidKeyException ike) {
            OAuthAuthorization.logger.error("Failed initialize \"Message Authentication Code\" (MAC)", ike);
            throw new AssertionError((Object)ike);
        }
        catch (NoSuchAlgorithmException nsae) {
            OAuthAuthorization.logger.error("Failed to get HmacSHA1 \"Message Authentication Code\" (MAC)", nsae);
            throw new AssertionError((Object)nsae);
        }
        return BASE64Encoder.encode(byteHMAC);
    }
    
    String generateSignature(final String data) {
        return this.generateSignature(data, null);
    }
    
    static String normalizeRequestParameters(final HttpParameter[] params) {
        return normalizeRequestParameters(toParamList(params));
    }
    
    private static String normalizeRequestParameters(final List<HttpParameter> params) {
        Collections.sort(params);
        return encodeParameters(params);
    }
    
    private static List<HttpParameter> toParamList(final HttpParameter[] params) {
        final List<HttpParameter> paramList = new ArrayList<HttpParameter>(params.length);
        paramList.addAll(Arrays.asList(params));
        return paramList;
    }
    
    public static String encodeParameters(final List<HttpParameter> httpParams) {
        return encodeParameters(httpParams, "&", false);
    }
    
    public static String encodeParameters(final List<HttpParameter> httpParams, final String splitter, final boolean quot) {
        final StringBuilder buf = new StringBuilder();
        for (final HttpParameter param : httpParams) {
            if (!param.isFile()) {
                if (buf.length() != 0) {
                    if (quot) {
                        buf.append("\"");
                    }
                    buf.append(splitter);
                }
                buf.append(HttpParameter.encode(param.getName())).append("=");
                if (quot) {
                    buf.append("\"");
                }
                buf.append(HttpParameter.encode(param.getValue()));
            }
        }
        if (buf.length() != 0 && quot) {
            buf.append("\"");
        }
        return buf.toString();
    }
    
    static String constructRequestURL(String url) {
        final int index = url.indexOf("?");
        if (-1 != index) {
            url = url.substring(0, index);
        }
        final int slashIndex = url.indexOf("/", 8);
        String baseURL = url.substring(0, slashIndex).toLowerCase();
        final int colonIndex = baseURL.indexOf(":", 8);
        if (-1 != colonIndex) {
            if (baseURL.startsWith("http://") && baseURL.endsWith(":80")) {
                baseURL = baseURL.substring(0, colonIndex);
            }
            else if (baseURL.startsWith("https://") && baseURL.endsWith(":443")) {
                baseURL = baseURL.substring(0, colonIndex);
            }
        }
        url = String.valueOf(baseURL) + url.substring(slashIndex);
        return url;
    }
    
    @Override
    public void setOAuthConsumer(final String consumerKey, final String consumerSecret) {
        this.consumerKey = ((consumerKey != null) ? consumerKey : "");
        this.consumerSecret = ((consumerSecret != null) ? consumerSecret : "");
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OAuthSupport)) {
            return false;
        }
        final OAuthAuthorization that = (OAuthAuthorization)o;
        Label_0054: {
            if (this.consumerKey != null) {
                if (this.consumerKey.equals(that.consumerKey)) {
                    break Label_0054;
                }
            }
            else if (that.consumerKey == null) {
                break Label_0054;
            }
            return false;
        }
        Label_0087: {
            if (this.consumerSecret != null) {
                if (this.consumerSecret.equals(that.consumerSecret)) {
                    break Label_0087;
                }
            }
            else if (that.consumerSecret == null) {
                break Label_0087;
            }
            return false;
        }
        if (this.oauthToken != null) {
            if (this.oauthToken.equals(that.oauthToken)) {
                return true;
            }
        }
        else if (that.oauthToken == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (this.consumerKey != null) ? this.consumerKey.hashCode() : 0;
        result = 31 * result + ((this.consumerSecret != null) ? this.consumerSecret.hashCode() : 0);
        result = 31 * result + ((this.oauthToken != null) ? this.oauthToken.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "OAuthAuthorization{consumerKey='" + this.consumerKey + '\'' + ", consumerSecret='******************************************'" + ", oauthToken=" + this.oauthToken + '}';
    }
}
