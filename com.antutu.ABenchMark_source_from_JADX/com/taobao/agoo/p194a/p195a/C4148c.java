package com.taobao.agoo.p194a.p195a;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4139d.C4138a;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;

/* renamed from: com.taobao.agoo.a.a.c */
public class C4148c extends C4146b {
    public static final String JSON_CMD_REGISTER = "register";
    public String f13907a;
    public String f13908b;
    public String f13909c;
    public String f13910d;
    public String f13911f;
    public String f13912g;
    public String f13913h;
    public String f13914i;
    public String f13915j;
    public String f13916k;
    public String f13917l;
    public String f13918m;
    public String f13919n;

    public C4148c() {
        this.f13910d = String.valueOf(Constants.SDK_VERSION_CODE);
    }

    public static byte[] m16951a(Context context, String str, String str2) {
        C4148c c4148c;
        Throwable th;
        C4148c c4148c2 = null;
        byte[] a;
        try {
            Object deviceId = UtilityImpl.getDeviceId(context);
            String packageName = context.getPackageName();
            Object obj = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(deviceId) || TextUtils.isEmpty(obj)) {
                ALog.m16903e("RegisterDO", "buildRegister param null", Constants.KEY_APP_KEY, str, MsgConstant.KEY_UTDID, deviceId, Constants.KEY_APP_VERSION, obj);
                if (c4148c2 == null) {
                    return c4148c2;
                }
                c4148c2.m16952a();
                return c4148c2;
            }
            c4148c = new C4148c();
            try {
                String subscriberId;
                c4148c.e = JSON_CMD_REGISTER;
                c4148c.f13907a = str;
                c4148c.f13908b = deviceId;
                c4148c.f13909c = obj;
                c4148c.f13911f = str2;
                c4148c.f13912g = packageName;
                c4148c.f13913h = Build.BRAND;
                c4148c.f13914i = Build.MODEL;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    packageName = telephonyManager.getDeviceId();
                } else {
                    Object obj2 = c4148c2;
                }
                c4148c.f13915j = packageName;
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                } else {
                    deviceId = c4148c2;
                }
                c4148c.f13916k = subscriberId;
                if (c4148c != null) {
                    a = c4148c.m16952a();
                    return a;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.m16902e("RegisterDO", "buildRegister", th, new Object[0]);
                    if (c4148c != null) {
                        a = c4148c.m16952a();
                        return a;
                    }
                    a = c4148c2;
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    c4148c2 = c4148c;
                    if (c4148c2 != null) {
                        c4148c2.m16952a();
                    }
                    throw th;
                }
            }
            a = c4148c2;
            return a;
        } catch (Throwable th4) {
            th = th4;
            if (c4148c2 != null) {
                c4148c2.m16952a();
            }
            throw th;
        }
    }

    public byte[] m16952a() {
        byte[] bArr = null;
        try {
            ALog.m16904i("RegisterDO", "buildData", Constants.KEY_DATA, new C4138a().m16922a(C4146b.JSON_CMD, this.e).m16922a(Constants.KEY_APP_KEY, this.f13907a).m16922a(MsgConstant.KEY_UTDID, this.f13908b).m16922a(Constants.KEY_APP_VERSION, this.f13909c).m16922a(Constants.KEY_SDK_VERSION, this.f13910d).m16922a(Constants.KEY_TTID, this.f13911f).m16922a(Constants.KEY_PACKAGE_NAME, this.f13912g).m16922a("c0", this.f13913h).m16922a("c1", this.f13914i).m16922a("c2", this.f13915j).m16922a("c3", this.f13916k).m16922a("c4", this.f13917l).m16922a("c5", this.f13918m).m16922a("c6", this.f13919n).m16924a().toString());
            bArr = r1.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m16902e("RegisterDO", "buildData", th, new Object[0]);
        }
        return bArr;
    }
}
