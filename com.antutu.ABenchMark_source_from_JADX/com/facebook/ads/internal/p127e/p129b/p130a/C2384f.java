package com.facebook.ads.internal.p127e.p129b.p130a;

import android.text.TextUtils;
import com.facebook.ads.internal.p127e.p129b.C2407m;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.facebook.ads.internal.e.b.a.f */
public class C2384f implements C2378c {
    private String m9174b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? BuildConfig.FLAVOR : str.substring(lastIndexOf + 1, str.length());
    }

    public String m9175a(String str) {
        Object b = m9174b(str);
        String d = C2407m.m9258d(str);
        return TextUtils.isEmpty(b) ? d : d + "." + b;
    }
}
