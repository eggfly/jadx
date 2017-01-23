package com.xiaomi.mistatistic.sdk.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.e */
public class C0557e {
    private static String f4724a;
    private static String f4725b;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.e.a */
    private static class C0556a implements C0523a {
        private Context f4723a;

        public C0556a(Context context) {
            this.f4723a = context;
        }

        public void m6367a() {
            String a = C0573k.m6446a(this.f4723a, "device_id", "");
            if (TextUtils.isEmpty(a)) {
                C0557e.f4724a = C0557e.m6368a(this.f4723a);
                C0573k.m6452b(this.f4723a, "device_id", C0557e.f4724a);
                return;
            }
            C0557e.f4724a = a;
        }
    }

    static {
        f4724a = null;
        f4725b = null;
    }

    public String m6372a() {
        if (f4724a != null) {
            return f4724a;
        }
        C0555d.m6362a().m6365a(new C0556a(C0551c.m6352a()));
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String m6368a(Context context) {
        if (null != null) {
            return null;
        }
        String b = C0557e.m6371b(context);
        String c = C0597q.m6532c(context);
        return C0597q.m6533c(b + c + C0597q.m6524a());
    }

    @TargetApi(9)
    public static String m6371b(Context context) {
        try {
            if (TextUtils.isEmpty(f4725b)) {
                f4725b = C0573k.m6446a(context, "imei", "");
                if (TextUtils.isEmpty(f4725b)) {
                    if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0) {
                        C0566h.m6419b("get READ_PHONE_STATE permission");
                        f4725b = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        C0573k.m6452b(context, "imei", f4725b);
                    } else {
                        C0566h.m6425d("cannot get READ_PHONE_STATE permission");
                    }
                }
            }
        } catch (Throwable th) {
            C0566h.m6418a("getImei exception:", th);
        }
        if (TextUtils.isEmpty(f4725b)) {
            C0566h.m6423c("Imei is empty");
            f4725b = "";
        }
        return f4725b;
    }
}
