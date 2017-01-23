package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.util.client.b */
public class C2972b {
    public static void m11576a(String str) {
        if (C2972b.m11578a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void m11577a(String str, Throwable th) {
        if (C2972b.m11578a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean m11578a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void m11579b(String str) {
        if (C2972b.m11578a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void m11580b(String str, Throwable th) {
        if (C2972b.m11578a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void m11581c(String str) {
        if (C2972b.m11578a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void m11582c(String str, Throwable th) {
        if (C2972b.m11578a(4)) {
            Log.i("Ads", str, th);
        }
    }

    public static void m11583d(String str) {
        if (C2972b.m11578a(5)) {
            Log.w("Ads", str);
        }
    }

    public static void m11584d(String str, Throwable th) {
        if (C2972b.m11578a(5)) {
            Log.w("Ads", str, th);
        }
    }
}
