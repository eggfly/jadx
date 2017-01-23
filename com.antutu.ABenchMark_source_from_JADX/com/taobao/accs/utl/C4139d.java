package com.taobao.accs.utl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.taobao.accs.utl.d */
public class C4139d {

    /* renamed from: com.taobao.accs.utl.d.a */
    public static class C4138a {
        JSONObject f13896a;

        public C4138a() {
            this.f13896a = new JSONObject();
        }

        public C4138a m16921a(String str, Integer num) {
            if (num != null) {
                try {
                    this.f13896a.put(str, num);
                } catch (JSONException e) {
                }
            }
            return this;
        }

        public C4138a m16922a(String str, String str2) {
            if (!(str2 == null || str == null)) {
                try {
                    this.f13896a.put(str, str2);
                } catch (JSONException e) {
                }
            }
            return this;
        }

        public C4138a m16923a(String str, JSONArray jSONArray) {
            if (jSONArray != null) {
                try {
                    this.f13896a.put(str, jSONArray);
                } catch (JSONException e) {
                }
            }
            return this;
        }

        public JSONObject m16924a() {
            return this.f13896a;
        }
    }

    public static String m16925a(JSONObject jSONObject, String str, String str2) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : str2;
    }
}
