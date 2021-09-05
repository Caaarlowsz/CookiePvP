package twitter4j;

import twitter4j.conf.Configuration;
import twitter4j.api.HelpResources;

public class LanguageJSONImpl implements HelpResources.Language
{
    private String name;
    private String code;
    private String status;
    
    LanguageJSONImpl(final JSONObject json) throws TwitterException {
        this.init(json);
    }
    
    private void init(final JSONObject json) throws TwitterException {
        try {
            this.name = json.getString("name");
            this.code = json.getString("code");
            this.status = json.getString("status");
        }
        catch (JSONException jsone) {
            throw new TwitterException(String.valueOf(jsone.getMessage()) + ":" + json.toString(), jsone);
        }
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public String getCode() {
        return this.code;
    }
    
    @Override
    public String getStatus() {
        return this.status;
    }
    
    static ResponseList<HelpResources.Language> createLanguageList(final HttpResponse res, final Configuration conf) throws TwitterException {
        return createLanguageList(res.asJSONArray(), res, conf);
    }
    
    static ResponseList<HelpResources.Language> createLanguageList(final JSONArray list, final HttpResponse res, final Configuration conf) throws TwitterException {
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            final int size = list.length();
            final ResponseList<HelpResources.Language> languages = new ResponseListImpl<HelpResources.Language>(size, res);
            for (int i = 0; i < size; ++i) {
                final JSONObject json = list.getJSONObject(i);
                final HelpResources.Language language = new LanguageJSONImpl(json);
                languages.add(language);
                if (conf.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(language, json);
                }
            }
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(languages, list);
            }
            return languages;
        }
        catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }
}
