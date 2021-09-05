package twitter4j.auth;

import twitter4j.JSONException;
import java.net.URLEncoder;
import twitter4j.TwitterException;
import twitter4j.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import twitter4j.HttpResponse;
import java.io.Serializable;

public class OAuth2Token implements Serializable
{
    private static final long serialVersionUID = -8985359441959903216L;
    private String tokenType;
    private String accessToken;
    
    OAuth2Token(final HttpResponse res) throws TwitterException {
        final JSONObject json = res.asJSONObject();
        this.tokenType = getRawString("token_type", json);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", json), "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {}
    }
    
    public OAuth2Token(final String tokenType, final String accessToken) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }
    
    public String getTokenType() {
        return this.tokenType;
    }
    
    public String getAccessToken() {
        return this.accessToken;
    }
    
    String generateAuthorizationHeader() {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(this.accessToken, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {}
        return "Bearer " + encoded;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof OAuth2Token)) {
            return false;
        }
        final OAuth2Token that = (OAuth2Token)obj;
        Label_0051: {
            if (this.tokenType != null) {
                if (this.tokenType.equals(that.tokenType)) {
                    break Label_0051;
                }
            }
            else if (that.tokenType == null) {
                break Label_0051;
            }
            return false;
        }
        if (this.accessToken != null) {
            if (this.accessToken.equals(that.accessToken)) {
                return true;
            }
        }
        else if (that.accessToken == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = (this.tokenType != null) ? this.tokenType.hashCode() : 0;
        result = 31 * result + ((this.accessToken != null) ? this.accessToken.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "OAuth2Token{tokenType='" + this.tokenType + '\'' + ", accessToken='" + this.accessToken + '\'' + '}';
    }
    
    private static String getRawString(final String name, final JSONObject json) {
        try {
            if (json.isNull(name)) {
                return null;
            }
            return json.getString(name);
        }
        catch (JSONException jsone) {
            return null;
        }
    }
}
