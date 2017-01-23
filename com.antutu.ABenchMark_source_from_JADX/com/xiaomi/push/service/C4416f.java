package com.xiaomi.push.service;

import android.content.Context;
import com.qq.p035e.comm.pi.ACTD;
import com.xiaomi.push.service.C4450y.C4448b;
import java.util.Locale;

/* renamed from: com.xiaomi.push.service.f */
public class C4416f {
    public final String f15074a;
    public final String f15075b;
    public final String f15076c;
    public final String f15077d;
    public final String f15078e;
    public final String f15079f;
    public final int f15080g;

    public C4416f(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f15074a = str;
        this.f15075b = str2;
        this.f15076c = str3;
        this.f15077d = str4;
        this.f15078e = str5;
        this.f15079f = str6;
        this.f15080g = i;
    }

    public static boolean m18226a() {
        try {
            return Class.forName("miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m18227a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && C4416f.m18226a();
    }

    private static boolean m18228b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public C4448b m18229a(XMPushService xMPushService) {
        C4448b c4448b = new C4448b(xMPushService);
        m18230a(c4448b, xMPushService, xMPushService.m18100d(), "c");
        return c4448b;
    }

    public C4448b m18230a(C4448b c4448b, Context context, C4407b c4407b, String str) {
        c4448b.f15169a = context.getPackageName();
        c4448b.f15170b = this.f15074a;
        c4448b.f15177i = this.f15076c;
        c4448b.f15171c = this.f15075b;
        c4448b.f15176h = "5";
        c4448b.f15172d = "XMPUSH-PASS";
        c4448b.f15173e = false;
        c4448b.f15174f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s", new Object[]{"sdk_ver", Integer.valueOf(21), "cpvn", "3_1_2", "cpvc", Integer.valueOf(30102)});
        String str2 = C4416f.m18228b(context) ? "1000271" : this.f15077d;
        c4448b.f15175g = String.format("%1$s:%2$s,%3$s:%4$s,sync:1", new Object[]{ACTD.APPID_KEY, str2, "locale", Locale.getDefault().toString()});
        if (C4416f.m18227a(context)) {
            c4448b.f15175g += String.format(",%1$s:%2$s", new Object[]{"ab", str});
        }
        c4448b.f15179k = c4407b;
        return c4448b;
    }
}
