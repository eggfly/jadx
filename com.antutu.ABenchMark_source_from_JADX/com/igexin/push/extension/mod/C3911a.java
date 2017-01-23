package com.igexin.push.extension.mod;

import com.igexin.p156a.C3652f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.extension.mod.a */
final class C3911a implements C3652f {
    C3911a() {
    }

    public void m16086a() {
        C3688a.m15097b(SecurityUtils.f13166a + "|load so by new success ^_^");
        SecurityUtils.f13167b = true;
        SecurityUtils.f13168c = BuildConfig.FLAVOR;
    }

    public void m16087a(Throwable th) {
        C3688a.m15097b(SecurityUtils.f13166a + "|load so by new error = " + th.getMessage());
        SecurityUtils.f13167b = false;
        SecurityUtils.f13168c += th.toString() + " + " + th.getMessage();
    }
}
