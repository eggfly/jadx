package com.mob.commons.logcollector;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;

/* renamed from: com.mob.commons.logcollector.d */
public class C4000d {
    private static C4000d f13374a;
    private SharePrefrenceHelper f13375b;

    private C4000d(Context context) {
        this.f13375b = new SharePrefrenceHelper(context.getApplicationContext());
        this.f13375b.open("mob_sdk_exception", 1);
    }

    public static C4000d m16487a(Context context) {
        if (f13374a == null) {
            f13374a = new C4000d(context);
        }
        return f13374a;
    }

    public long m16488a() {
        return this.f13375b.getLong("service_time");
    }

    public void m16489a(int i) {
        this.f13375b.putInt("is_upload_crash", Integer.valueOf(i));
    }

    public void m16490a(long j) {
        this.f13375b.putLong("service_time", Long.valueOf(j));
    }

    public void m16491a(String str) {
        this.f13375b.putString("err_log_filter", str);
    }

    public void m16492a(boolean z) {
        this.f13375b.putInt("is_upload_err_log", Integer.valueOf(z ? 0 : 1));
    }

    public void m16493b(int i) {
        this.f13375b.putInt("is_upload_sdkerr", Integer.valueOf(i));
    }

    public boolean m16494b() {
        return this.f13375b.getInt("is_upload_err_log") == 0;
    }

    public int m16495c() {
        return this.f13375b.getInt("is_upload_crash");
    }

    public void m16496c(int i) {
        this.f13375b.putInt("is_upload_apperr", Integer.valueOf(i));
    }

    public int m16497d() {
        return this.f13375b.getInt("is_upload_sdkerr");
    }

    public int m16498e() {
        return this.f13375b.getInt("is_upload_apperr");
    }

    public String m16499f() {
        return this.f13375b.getString("err_log_filter");
    }
}
