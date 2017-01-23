package com.cmcm.p074a.p075a.p114c;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.w */
public class C2158w extends C2136b {
    public static String m8141c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.KEY_PACKAGE_NAME, str);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void m8142b(String str) {
        String c = C2158w.m8141c(str);
        if (c != null) {
            m8069a(c);
        }
    }

    public String m8143f() {
        return "uninst_app";
    }
}
