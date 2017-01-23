package com.igexin.push.p171a.p172a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.p180c.C3846j;
import com.igexin.push.p169f.C3716a;
import com.igexin.push.p169f.p179a.C3913c;
import com.igexin.push.util.C3926e;

/* renamed from: com.igexin.push.a.a.e */
class C3717e extends C3716a {
    final /* synthetic */ C3715d f12533a;

    C3717e(C3715d c3715d, Object obj) {
        this.f12533a = c3715d;
        super(obj);
    }

    protected Object m15233a(Object obj) {
        try {
            Object h = C3926e.m16173h();
            if (!TextUtils.isEmpty(h)) {
                C3685c.m15060b().m15053a(new C3913c(new C3846j(SDKUrlConfig.getBiUploadServiceUrl(), h.getBytes(), 10, false)), false, true);
            }
        } catch (Throwable th) {
            C3688a.m15097b("UploadBITask|" + th.toString());
        }
        return null;
    }

    protected void m15234a(Object obj, Object obj2) {
    }
}
