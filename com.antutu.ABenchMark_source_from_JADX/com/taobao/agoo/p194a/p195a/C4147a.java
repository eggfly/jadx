package com.taobao.agoo.p194a.p195a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4139d.C4138a;
import com.umeng.message.proguard.C4233j;
import org.android.agoo.common.C4575b;

/* renamed from: com.taobao.agoo.a.a.a */
public class C4147a extends C4146b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";
    public String f13903a;
    public String f13904b;
    public String f13905c;
    public String f13906d;

    public static byte[] m16948a(String str, String str2, String str3) {
        C4147a c4147a = new C4147a();
        c4147a.f13903a = str;
        c4147a.f13904b = str2;
        c4147a.f13905c = str3;
        c4147a.e = JSON_CMD_SETALIAS;
        return c4147a.m16950a();
    }

    public static byte[] m16949b(String str, String str2, String str3) {
        C4147a c4147a = new C4147a();
        c4147a.f13903a = str;
        c4147a.f13904b = str2;
        c4147a.f13906d = str3;
        c4147a.e = JSON_CMD_REMOVEALIAS;
        return c4147a.m16950a();
    }

    public byte[] m16950a() {
        byte[] bArr = null;
        try {
            ALog.m16904i("AliasDO", "buildData", Constants.KEY_DATA, new C4138a().m16922a(C4146b.JSON_CMD, this.e).m16922a(Constants.KEY_APP_KEY, this.f13903a).m16922a(C4575b.KEY_DEVICE_TOKEN, this.f13904b).m16922a(C4233j.f14403z, this.f13905c).m16922a(JSON_PUSH_USER_TOKEN, this.f13906d).m16924a().toString());
            bArr = r1.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m16902e("AliasDO", "buildData", th, new Object[0]);
        }
        return bArr;
    }
}
