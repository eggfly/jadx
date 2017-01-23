package com.igexin.push.core.p175b;

import com.igexin.push.core.C3855g;
import com.igexin.push.p173b.C3721d;
import com.igexin.push.util.C3926e;
import com.igexin.push.util.EncryptUtils;

/* renamed from: com.igexin.push.core.b.t */
class C3813t extends C3721d {
    final /* synthetic */ C3799f f12769a;

    C3813t(C3799f c3799f) {
        this.f12769a = c3799f;
    }

    public void m15677a() {
        C3799f.m15623a().m15625a(this.c, 1, EncryptUtils.getBytesEncrypted(String.valueOf(C3855g.f12981s).getBytes()));
        C3799f.m15623a().m15625a(this.c, 20, this.f12769a.m15634e(C3855g.f12982t));
        C3926e.m16156a();
    }
}
