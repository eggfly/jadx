package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import p023b.p024a.at;

/* renamed from: com.umeng.analytics.c */
public class C4164c {
    private static String[] f13989a;

    static {
        f13989a = new String[2];
    }

    public static void m17012a(Context context, String str, String str2) {
        f13989a[0] = str;
        f13989a[1] = str2;
        if (context != null) {
            at.m3424a(context).m3437a(str, str2);
        }
    }

    public static String[] m17013a(Context context) {
        if (!TextUtils.isEmpty(f13989a[0]) && !TextUtils.isEmpty(f13989a[1])) {
            return f13989a;
        }
        if (context != null) {
            String[] a = at.m3424a(context).m3439a();
            if (a != null) {
                f13989a[0] = a[0];
                f13989a[1] = a[1];
                return f13989a;
            }
        }
        return null;
    }

    public static void m17014b(Context context) {
        f13989a[0] = null;
        f13989a[1] = null;
        if (context != null) {
            at.m3424a(context).m3440b();
        }
    }
}
