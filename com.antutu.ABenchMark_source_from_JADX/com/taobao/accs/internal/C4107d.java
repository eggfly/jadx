package com.taobao.accs.internal;

import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.internal.d */
class C4107d implements Runnable {
    final /* synthetic */ String f13748a;
    final /* synthetic */ C4103b f13749b;

    C4107d(C4103b c4103b, String str) {
        this.f13749b = c4103b;
        this.f13748a = str;
    }

    public void run() {
        ALog.m16904i("ElectionServiceImpl", "tryElection", "isPing", Boolean.valueOf(C4103b.f13718f));
        if (C4103b.f13718f) {
            ALog.m16904i("ElectionServiceImpl", "no need election, stop self", new Object[0]);
            this.f13749b.m16791a(true);
            return;
        }
        ALog.m16903e("ElectionServiceImpl", "tryElection curr host unreceive ping, try selectAppToElection", "curr host", this.f13748a);
        this.f13749b.m16781b(this.f13749b.f13719a, "host invaid");
    }
}
