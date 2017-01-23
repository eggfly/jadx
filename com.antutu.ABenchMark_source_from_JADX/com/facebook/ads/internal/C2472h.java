package com.facebook.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.h */
public class C2472h {
    private static C2472h f8506a;
    private final SharedPreferences f8507b;

    public C2472h(Context context) {
        this.f8507b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    public static boolean m9399a(Context context) {
        return C2472h.m9403e(context).m9406a("enable_overlapping_view_check", false);
    }

    public static boolean m9400b(Context context) {
        return C2472h.m9403e(context).m9406a("enable_parallel_image_downloads", false);
    }

    public static long m9401c(Context context) {
        return C2472h.m9403e(context).m9404a("ad_clickability_threshold_ms", 0);
    }

    public static boolean m9402d(Context context) {
        return C2472h.m9403e(context).m9406a("adnw_android_video_caching_enabled", false);
    }

    private static C2472h m9403e(Context context) {
        if (f8506a == null) {
            synchronized (C2472h.class) {
                if (f8506a == null) {
                    f8506a = new C2472h(context);
                }
            }
        }
        return f8506a;
    }

    public long m9404a(String str, long j) {
        String string = this.f8507b.getString(str, String.valueOf(j));
        return (string == null || string.equals("null")) ? j : Long.valueOf(string).longValue();
    }

    public void m9405a(String str) {
        if (str != null && !str.isEmpty() && !str.equals("[]")) {
            Editor edit = this.f8507b.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                edit.putString(str2, jSONObject.getString(str2));
            }
            edit.commit();
        }
    }

    public boolean m9406a(String str, boolean z) {
        String string = this.f8507b.getString(str, String.valueOf(z));
        return (string == null || string.equals("null")) ? z : Boolean.valueOf(string).booleanValue();
    }
}
