package com.umeng.message.tag;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.umeng.message.common.UmLog;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.umeng.message.tag.a */
public class C4249a implements TagFilter {
    private static final String f14506a;
    private static int f14507b;

    static {
        f14506a = C4249a.class.getName();
        f14507b = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public boolean filter(String str) {
        if (str == null || BuildConfig.FLAVOR.equals(str.trim())) {
            return false;
        }
        if (str == null || str.length() <= f14507b) {
            return true;
        }
        UmLog.m17138e(f14506a, String.format("The length of %s exceeds allowed max length %i", new Object[]{str, Integer.valueOf(f14507b)}));
        return false;
    }
}
