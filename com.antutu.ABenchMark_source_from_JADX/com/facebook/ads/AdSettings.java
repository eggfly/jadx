package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2498g.C2497a;
import com.facebook.ads.internal.util.C2510r;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings {
    public static final boolean DEBUG = false;
    static volatile boolean f7755a;
    private static final String f7756b;
    private static final Collection<String> f7757c;
    private static final Collection<String> f7758d;
    private static String f7759e;
    private static boolean f7760f;
    private static String f7761g;
    private static boolean f7762h;
    private static String f7763i;

    static {
        f7756b = AdSettings.class.getSimpleName();
        f7757c = new HashSet();
        f7758d = new HashSet();
        f7758d.add("sdk");
        f7758d.add("google_sdk");
        f7758d.add("vbox86p");
        f7758d.add("vbox86tp");
        f7755a = false;
    }

    private static void m8515a(String str) {
        if (!f7755a) {
            f7755a = true;
            Log.d(f7756b, "Test mode device hash: " + str);
            Log.d(f7756b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
    }

    public static void addTestDevice(String str) {
        f7757c.add(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        f7757c.addAll(collection);
    }

    public static void clearTestDevices() {
        f7757c.clear();
    }

    public static String getMediationService() {
        return f7761g;
    }

    public static String getUrlPrefix() {
        return f7759e;
    }

    public static boolean isChildDirected() {
        return f7762h;
    }

    public static boolean isTestMode(Context context) {
        if (AdInternalSettings.f8548a || f7758d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f7763i == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            f7763i = sharedPreferences.getString("deviceIdHash", null);
            if (C2510r.m9516a(f7763i)) {
                C2497a a = C2498g.m9469a(context.getContentResolver());
                if (!C2510r.m9516a(a.f8582b)) {
                    f7763i = C2510r.m9517b(a.f8582b);
                } else if (C2510r.m9516a(a.f8581a)) {
                    f7763i = C2510r.m9517b(UUID.randomUUID().toString());
                } else {
                    f7763i = C2510r.m9517b(a.f8581a);
                }
                sharedPreferences.edit().putString("deviceIdHash", f7763i).apply();
            }
        }
        if (f7757c.contains(f7763i)) {
            return true;
        }
        m8515a(f7763i);
        return false;
    }

    public static boolean isVideoAutoplay() {
        return f7760f;
    }

    public static void setIsChildDirected(boolean z) {
        f7762h = z;
    }

    public static void setMediationService(String str) {
        f7761g = str;
    }

    public static void setUrlPrefix(String str) {
        f7759e = str;
    }

    public static void setVideoAutoplay(boolean z) {
        f7760f = z;
    }
}
