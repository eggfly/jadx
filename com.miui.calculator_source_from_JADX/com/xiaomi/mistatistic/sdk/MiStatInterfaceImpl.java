package com.xiaomi.mistatistic.sdk;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiStatInterfaceImpl extends MiStatInterface {
    private static MiStatInterfaceImpl f4653a;

    static {
        f4653a = null;
    }

    @JavascriptInterface
    public void trackCountEvent(String str, String str2) {
        MiStatInterface.m6268a(str, str2, null);
    }

    @JavascriptInterface
    public void trackCountEvent(String str, String str2, String str3) {
        JSONException jSONException;
        Map map = null;
        if (!TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Map hashMap = new HashMap();
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str4 = (String) keys.next();
                        hashMap.put(str4, jSONObject.optString(str4));
                    }
                    map = hashMap;
                } catch (JSONException e) {
                    JSONException jSONException2 = e;
                    map = hashMap;
                    jSONException = jSONException2;
                    jSONException.printStackTrace();
                    MiStatInterface.m6268a(str, str2, map);
                }
            } catch (JSONException e2) {
                jSONException = e2;
                jSONException.printStackTrace();
                MiStatInterface.m6268a(str, str2, map);
            }
        }
        MiStatInterface.m6268a(str, str2, map);
    }

    @JavascriptInterface
    public void trackCalculateEvent(String str, String str2, long j) {
        MiStatInterface.m6266a(str, str2, j, null);
    }

    @JavascriptInterface
    public void trackNumericPropertyEvent(String str, String str2, long j) {
        MiStatInterface.m6272b(str, str2, j);
    }

    @JavascriptInterface
    public void trackStringPropertyEvent(String str, String str2, String str3) {
        MiStatInterface.m6267a(str, str2, str3);
    }
}
