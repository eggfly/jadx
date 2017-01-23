package com.miui.support.internal.hybrid;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonConfigParser implements ConfigParser {
    private JSONObject f2463a;

    private JsonConfigParser(JSONObject jSONObject) {
        this.f2463a = jSONObject;
    }

    public static JsonConfigParser m4060a(String str) {
        try {
            return m4061a(new JSONObject(str));
        } catch (JSONException e) {
            throw new HybridException(201, e.getMessage());
        }
    }

    public static JsonConfigParser m4061a(JSONObject jSONObject) {
        return new JsonConfigParser(jSONObject);
    }

    public Config m4064a(Map<String, Object> map) {
        Config config = new Config();
        try {
            JSONObject jSONObject = this.f2463a;
            Security security = new Security();
            security.m4074a(jSONObject.getString("signature"));
            security.m4073a(jSONObject.getLong("timestamp"));
            config.m3997a(security);
            config.m3998a(jSONObject.getString("vendor"));
            config.m4001b(jSONObject.optString("content"));
            m4062a(config, jSONObject);
            m4063b(config, jSONObject);
            return m4059a(config, (Map) map);
        } catch (JSONException e) {
            throw new HybridException(201, e.getMessage());
        }
    }

    private void m4062a(Config config, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("features");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                Feature feature = new Feature();
                feature.m4015a(jSONObject2.getString("name"));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("params");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        feature.m4016a(jSONObject3.getString("name"), jSONObject3.getString("value"));
                    }
                }
                config.m3995a(feature);
            }
        }
    }

    private void m4063b(Config config, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("permissions");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                Permission permission = new Permission();
                permission.m4066a(jSONObject2.getString("origin"));
                permission.m4067a(jSONObject2.optBoolean("subdomains"));
                config.m3996a(permission);
            }
        }
    }

    private Config m4059a(Config config, Map<String, Object> map) {
        return config;
    }
}
