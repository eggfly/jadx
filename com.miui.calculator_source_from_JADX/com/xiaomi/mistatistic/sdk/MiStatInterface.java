package com.xiaomi.mistatistic.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0555d;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0557e;
import com.xiaomi.mistatistic.sdk.controller.C0559f;
import com.xiaomi.mistatistic.sdk.controller.C0583m;
import com.xiaomi.mistatistic.sdk.controller.C0588o;
import com.xiaomi.mistatistic.sdk.controller.C0596p;
import com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0542a;
import com.xiaomi.mistatistic.sdk.data.C0602b;
import com.xiaomi.mistatistic.sdk.data.C0604d;
import com.xiaomi.mistatistic.sdk.data.C0605f;
import com.xiaomi.mistatistic.sdk.data.C0606g;
import java.util.Map;

public abstract class MiStatInterface {
    private static boolean f4651a;
    private static boolean f4652b;

    /* renamed from: com.xiaomi.mistatistic.sdk.MiStatInterface.1 */
    final class C05261 implements C0523a {
        final /* synthetic */ Throwable f4650a;

        public void m6258a() {
            new C0534b().m6289a(Thread.currentThread(), this.f4650a);
        }
    }

    static {
        f4651a = false;
        f4652b = false;
    }

    public static final void m6263a(Context context, String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("appID or appKey is empty.");
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "mistats_default";
        }
        C0551c.m6353a(context, str, str2, str3);
        C0559f.m6375a();
        new C0557e().m6372a();
        C0596p.m6514a().m6518b();
        f4651a = true;
        if (z) {
            URLStatsRecorder.m6275a();
        }
    }

    public static final void m6260a(int i, long j) {
        m6274c();
        if (i != 4 || (j >= 60000 && j <= 86400000)) {
            C0596p.m6514a().m6517a(i, j);
            return;
        }
        throw new IllegalArgumentException("interval should be set between 1 minutes and 1 day");
    }

    private static final String m6259a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(",")) {
            return str.replace(",", "");
        }
        return str;
    }

    public static final void m6262a(Context context, String str, String str2) {
        m6274c();
        if (!TextUtils.isEmpty(str) || (context instanceof Activity)) {
            C0555d.m6362a().m6365a(new C0542a());
            C0583m.m6474a().m6486a(context, m6259a(str), m6259a(str2));
            if (context instanceof Activity) {
                C0588o a = C0588o.m6492a();
                if (a.m6498b()) {
                    a.m6496a((Activity) context);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("pageName should't be null");
    }

    public static final void m6261a(Context context, String str) {
        m6262a(context, str, "");
    }

    public static final void m6271b(Context context, String str) {
        m6274c();
        C0583m.m6474a().m6485a(context, str);
        C0588o a = C0588o.m6492a();
        if (a.m6501e()) {
            a.m6502f();
        }
    }

    public static final void m6268a(String str, String str2, Map<String, String> map) {
        m6274c();
        m6264a(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = "default_category";
        }
        LocalEventRecorder.m6297a(new C0604d(str, str2, map));
        C0542a.m6320b();
    }

    public static final void m6265a(String str, String str2, long j) {
        m6266a(str, str2, j, null);
    }

    public static final void m6266a(String str, String str2, long j, Map<String, String> map) {
        String str3;
        m6274c();
        m6264a(str, str2);
        if (TextUtils.isEmpty(str)) {
            str3 = "default_category";
        } else {
            str3 = str;
        }
        LocalEventRecorder.m6297a(new C0602b(str3, str2, j, map));
        C0542a.m6320b();
    }

    public static final void m6272b(String str, String str2, long j) {
        m6274c();
        m6264a(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = "default_category";
        }
        LocalEventRecorder.m6297a(new C0605f(str, str2, j));
        C0542a.m6320b();
    }

    public static final void m6267a(String str, String str2, String str3) {
        m6274c();
        m6264a(str, str2);
        if (TextUtils.isEmpty(str)) {
            str = "default_category";
        }
        LocalEventRecorder.m6297a(new C0606g(str, str2, str3));
        C0542a.m6320b();
    }

    private static void m6274c() {
        if (!f4651a) {
            throw new IllegalStateException("not initialized, do you forget to call initialize when application started?");
        }
    }

    private static void m6264a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.startsWith("mistat_")) {
            throw new IllegalArgumentException("category cannot start with mistat_");
        } else if (!TextUtils.isEmpty(str2) && str2.startsWith("mistat_")) {
            throw new IllegalArgumentException("key cannot start with mistat_");
        }
    }

    public static void m6269a(boolean z) {
        if (!m6270a()) {
            C0534b.m6285a(false);
        }
        C0534b.m6282a(z ? 2 : 3);
    }

    public static boolean m6270a() {
        return C0534b.m6288d() != 1;
    }

    public static boolean m6273b() {
        return C0534b.m6288d() == 2;
    }
}
