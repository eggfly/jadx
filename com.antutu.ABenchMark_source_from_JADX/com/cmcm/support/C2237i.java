package com.cmcm.support;

import android.content.Context;
import com.cmcm.support.p116a.C2192e;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

/* renamed from: com.cmcm.support.i */
public class C2237i {
    private final String f7703a;
    private C2192e f7704b;
    private boolean f7705c;

    public C2237i(Context context, String str) {
        this.f7703a = "http://helpshoujikong0.ksmobile.com/nep/v1/";
        this.f7705c = false;
        try {
            this.f7704b = new C2192e(C2246o.m8496a(context).getAbsolutePath() + File.separatorChar + str);
            this.f7705c = true;
        } catch (Exception e) {
            this.f7705c = false;
            e.printStackTrace();
        }
    }

    public int m8445a() {
        return this.f7705c ? this.f7704b.m8241a("common", "product", 0) : 0;
    }

    public int m8446a(String str) {
        return this.f7705c ? this.f7704b.m8241a(str, "p", 10000) : 10000;
    }

    public String m8447a(int i) {
        if (!this.f7705c) {
            return "http://helpshoujikong0.ksmobile.com/nep/v1/";
        }
        return this.f7704b.m8242a("common", "server" + i, "http://helpshoujikong0.ksmobile.com/nep/v1/");
    }

    public int m8448b() {
        return this.f7705c ? this.f7704b.m8241a("common", "validity", 0) : 0;
    }

    public int m8449b(String str) {
        return this.f7705c ? this.f7704b.m8241a(str, "up", 10000) : 10000;
    }

    public int m8450c(String str) {
        return this.f7705c ? this.f7704b.m8241a(str, "wifionly", 1) : 1;
    }

    public String m8451c() {
        return this.f7705c ? this.f7704b.m8242a("common", "publictable", BuildConfig.FLAVOR) : BuildConfig.FLAVOR;
    }

    public int m8452d(String str) {
        return this.f7705c ? this.f7704b.m8241a(str, Constants.KEY_SID, 1) : 1;
    }
}
