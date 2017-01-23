package com.facebook.ads.internal.p127e.p128a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.e.a.g */
public class C2366g implements C2365q {
    private void m9118a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    m9120a(str + ":" + str2);
                }
            }
        }
    }

    public void m9119a(C2373n c2373n) {
        if (c2373n != null) {
            m9120a("=== HTTP Response ===");
            m9120a("Receive url: " + c2373n.m9135b());
            m9120a("Status: " + c2373n.m9134a());
            m9118a(c2373n.m9136c());
            m9120a("Content:\n" + c2373n.m9138e());
        }
    }

    public void m9120a(String str) {
        System.out.println(str);
    }

    public void m9121a(HttpURLConnection httpURLConnection, Object obj) {
        m9120a("=== HTTP Request ===");
        m9120a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            m9120a("Content: " + ((String) obj));
        }
        m9118a(httpURLConnection.getRequestProperties());
    }

    public boolean m9122a() {
        return false;
    }
}
