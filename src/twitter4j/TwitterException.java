package twitter4j;

import java.io.IOException;
import java.util.List;

public class TwitterException extends Exception implements TwitterResponse, HttpResponseCode
{
    private static final long serialVersionUID = 6006561839051121336L;
    private int statusCode;
    private int errorCode;
    private ExceptionDiagnosis exceptionDiagnosis;
    private HttpResponse response;
    private String errorMessage;
    private static final String[] FILTER;
    private boolean nested;
    
    static {
        FILTER = new String[] { "twitter4j" };
    }
    
    public TwitterException(final String message, final Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
        this.errorCode = -1;
        this.exceptionDiagnosis = null;
        this.errorMessage = null;
        this.nested = false;
        this.decode(message);
    }
    
    public TwitterException(final String message) {
        this(message, (Throwable)null);
    }
    
    public TwitterException(final Exception cause) {
        this(cause.getMessage(), cause);
        if (cause instanceof TwitterException) {
            ((TwitterException)cause).setNested();
        }
    }
    
    public TwitterException(final String message, final HttpResponse res) {
        this(message);
        this.response = res;
        this.statusCode = res.getStatusCode();
    }
    
    public TwitterException(final String message, final Exception cause, final int statusCode) {
        this(message, cause);
        this.statusCode = statusCode;
    }
    
    @Override
    public String getMessage() {
        final StringBuilder value = new StringBuilder();
        if (this.errorMessage != null && this.errorCode != -1) {
            value.append("message - ").append(this.errorMessage).append("\n");
            value.append("code - ").append(this.errorCode).append("\n");
        }
        else {
            value.append(super.getMessage());
        }
        if (this.statusCode != -1) {
            return String.valueOf(getCause(this.statusCode)) + "\n" + value.toString();
        }
        return value.toString();
    }
    
    private void decode(final String str) {
        if (str != null && str.startsWith("{")) {
            try {
                final JSONObject json = new JSONObject(str);
                if (!json.isNull("errors")) {
                    final JSONObject error = json.getJSONArray("errors").getJSONObject(0);
                    this.errorMessage = error.getString("message");
                    this.errorCode = ParseUtil.getInt("code", error);
                }
            }
            catch (JSONException ex) {}
        }
    }
    
    public int getStatusCode() {
        return this.statusCode;
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getResponseHeader(final String name) {
        String value = null;
        if (this.response != null) {
            final List<String> header = this.response.getResponseHeaderFields().get(name);
            if (header.size() > 0) {
                value = header.get(0);
            }
        }
        return value;
    }
    
    @Override
    public RateLimitStatus getRateLimitStatus() {
        if (this.response == null) {
            return null;
        }
        return JSONImplFactory.createRateLimitStatusFromResponseHeader(this.response);
    }
    
    @Override
    public int getAccessLevel() {
        return ParseUtil.toAccessLevel(this.response);
    }
    
    public int getRetryAfter() {
        int retryAfter = -1;
        if (this.statusCode == 400) {
            final RateLimitStatus rateLimitStatus = this.getRateLimitStatus();
            if (rateLimitStatus != null) {
                retryAfter = rateLimitStatus.getSecondsUntilReset();
            }
        }
        else if (this.statusCode == 420) {
            try {
                final String retryAfterStr = this.response.getResponseHeader("Retry-After");
                if (retryAfterStr != null) {
                    retryAfter = Integer.valueOf(retryAfterStr);
                }
            }
            catch (NumberFormatException ex) {}
        }
        return retryAfter;
    }
    
    public boolean isCausedByNetworkIssue() {
        return this.getCause() instanceof IOException;
    }
    
    public boolean exceededRateLimitation() {
        return (this.statusCode == 400 && this.getRateLimitStatus() != null) || this.statusCode == 420 || this.statusCode == 429;
    }
    
    public boolean resourceNotFound() {
        return this.statusCode == 404;
    }
    
    public String getExceptionCode() {
        return this.getExceptionDiagnosis().asHexString();
    }
    
    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, TwitterException.FILTER);
        }
        return this.exceptionDiagnosis;
    }
    
    void setNested() {
        this.nested = true;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
    public boolean isErrorMessageAvailable() {
        return this.errorMessage != null;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final TwitterException that = (TwitterException)o;
        if (this.errorCode != that.errorCode) {
            return false;
        }
        if (this.nested != that.nested) {
            return false;
        }
        if (this.statusCode != that.statusCode) {
            return false;
        }
        Label_0101: {
            if (this.errorMessage != null) {
                if (this.errorMessage.equals(that.errorMessage)) {
                    break Label_0101;
                }
            }
            else if (that.errorMessage == null) {
                break Label_0101;
            }
            return false;
        }
        Label_0134: {
            if (this.exceptionDiagnosis != null) {
                if (this.exceptionDiagnosis.equals(that.exceptionDiagnosis)) {
                    break Label_0134;
                }
            }
            else if (that.exceptionDiagnosis == null) {
                break Label_0134;
            }
            return false;
        }
        if (this.response != null) {
            if (this.response.equals(that.response)) {
                return true;
            }
        }
        else if (that.response == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = this.statusCode;
        result = 31 * result + this.errorCode;
        result = 31 * result + ((this.exceptionDiagnosis != null) ? this.exceptionDiagnosis.hashCode() : 0);
        result = 31 * result + ((this.response != null) ? this.response.hashCode() : 0);
        result = 31 * result + ((this.errorMessage != null) ? this.errorMessage.hashCode() : 0);
        result = 31 * result + (this.nested ? 1 : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getMessage()) + (this.nested ? "" : ("\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=" + this.getExceptionDiagnosis().getStackLineHashAsHex() + " or\n\thttp://www.google.co.jp/search?q=" + this.getExceptionDiagnosis().getLineNumberHashAsHex())) + "\nTwitterException{" + (this.nested ? "" : ("exceptionCode=[" + this.getExceptionCode() + "], ")) + "statusCode=" + this.statusCode + ", message=" + this.errorMessage + ", code=" + this.errorCode + ", retryAfter=" + this.getRetryAfter() + ", rateLimitStatus=" + this.getRateLimitStatus() + ", version=" + Version.getVersion() + '}';
    }
    
    private static String getCause(final int statusCode) {
        String cause = null;
        switch (statusCode) {
            case 304: {
                cause = "There was no new data to return.";
                break;
            }
            case 400: {
                cause = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
                break;
            }
            case 401: {
                cause = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
                break;
            }
            case 403: {
                cause = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
                break;
            }
            case 404: {
                cause = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
                break;
            }
            case 406: {
                cause = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
                break;
            }
            case 420: {
                cause = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
                break;
            }
            case 422: {
                cause = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
                break;
            }
            case 429: {
                cause = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
                break;
            }
            case 500: {
                cause = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
                break;
            }
            case 502: {
                cause = "Twitter is down or being upgraded.";
                break;
            }
            case 503: {
                cause = "The Twitter servers are up, but overloaded with requests. Try again later.";
                break;
            }
            case 504: {
                cause = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
                break;
            }
            default: {
                cause = "";
                break;
            }
        }
        return String.valueOf(statusCode) + ":" + cause;
    }
}
