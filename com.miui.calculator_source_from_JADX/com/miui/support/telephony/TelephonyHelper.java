package com.miui.support.telephony;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.miui.support.net.ConnectivityHelper;
import com.miui.support.os.SystemProperties;
import com.miui.support.util.AppConstants;
import com.miui.support.util.SoftReferenceSingleton;

public class TelephonyHelper {
    private static final SoftReferenceSingleton<TelephonyHelper> f3546a;
    private Context f3547b;
    private TelephonyManager f3548c;
    private String f3549d;

    /* renamed from: com.miui.support.telephony.TelephonyHelper.1 */
    final class C04161 extends SoftReferenceSingleton<TelephonyHelper> {
        C04161() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5237a();
        }

        protected TelephonyHelper m5237a() {
            return new TelephonyHelper();
        }
    }

    static {
        f3546a = new C04161();
    }

    public static TelephonyHelper m5238a() {
        return (TelephonyHelper) f3546a.get();
    }

    private TelephonyHelper() {
        this.f3547b = AppConstants.m4227a();
        this.f3548c = (TelephonyManager) this.f3547b.getSystemService("phone");
    }

    public String m5239b() {
        if (this.f3549d != null) {
            return this.f3549d;
        }
        this.f3549d = this.f3548c.getDeviceId();
        if (this.f3549d != null) {
            return this.f3549d;
        }
        this.f3549d = SystemProperties.m5189a("ro.ril.miui.imei", null);
        if (!TextUtils.isEmpty(this.f3549d)) {
            return this.f3549d;
        }
        if (ConnectivityHelper.m5082a().m5084c()) {
            this.f3549d = ConnectivityHelper.m5082a().m5083b();
        }
        return this.f3549d;
    }
}
