package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p080j.C1989j;
import com.baidu.mobads.p091f.C1933a;
import com.baidu.mobads.p093h.C1960g.C1959c;

/* renamed from: com.baidu.mobads.production.f */
class C2055f implements C1959c {
    final /* synthetic */ C2028a f7161a;

    C2055f(C2028a c2028a) {
        this.f7161a = c2028a;
    }

    public void m7732a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    C2028a.f7072a = BaiduXAdSDKContext.mApkLoader.m7354g();
                    BaiduXAdSDKContext.isRemoteLoadSuccess = Boolean.valueOf(true);
                    this.f7161a.m7572a("XAdMouldeLoader load success");
                    return;
                }
            } catch (Throwable e) {
                C1989j.m7430a().m7439e(e);
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        this.f7161a.dispatchEvent(new C1933a(IXAdEvent.AD_ERROR));
    }
}
