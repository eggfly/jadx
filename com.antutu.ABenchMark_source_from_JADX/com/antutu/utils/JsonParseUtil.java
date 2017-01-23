package com.antutu.utils;

import com.google.gson.Gson;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParseUtil {
    public static final long getLongValue(String str, String str2) {
        try {
            return getLongValue(new JSONObject(str), str2);
        } catch (JSONException e) {
            return 0;
        }
    }

    public static final long getLongValue(JSONObject jSONObject, String str) {
        return getLongValue(jSONObject, str, 0);
    }

    public static final long getLongValue(JSONObject jSONObject, String str, long j) {
        try {
            j = jSONObject.getLong(str);
        } catch (JSONException e) {
        }
        return j;
    }

    public static final String getStringValue(String str, String str2) {
        try {
            return getStringValue(new JSONObject(str), str2, null);
        } catch (JSONException e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static final String getStringValue(JSONObject jSONObject, String str) {
        return getStringValue(jSONObject, str, null);
    }

    public static final String getStringValue(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    public static <T> T parse(String str, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            if (!(str == null || BuildConfig.FLAVOR.equals(str))) {
                t = gson.fromJson(str, (Class) cls);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public static String toJsonString(Object obj) {
        return new Gson().toJson(obj);
    }
}
