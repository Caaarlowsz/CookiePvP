package twitter4j;

public class TimeZoneJSONImpl implements TimeZone
{
    private static final long serialVersionUID = 81958969762484144L;
    private final String NAME;
    private final String TZINFO_NAME;
    private final int UTC_OFFSET;
    
    TimeZoneJSONImpl(final JSONObject jSONObject) throws TwitterException {
        try {
            this.UTC_OFFSET = ParseUtil.getInt("utc_offset", jSONObject);
            this.NAME = jSONObject.getString("name");
            this.TZINFO_NAME = jSONObject.getString("tzinfo_name");
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
    
    @Override
    public String getName() {
        return this.NAME;
    }
    
    @Override
    public String tzinfoName() {
        return this.TZINFO_NAME;
    }
    
    @Override
    public int utcOffset() {
        return this.UTC_OFFSET;
    }
}
