package com.igexin.push.p169f.p170b;

import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;

/* renamed from: com.igexin.push.f.b.b */
public class C3917b extends C3732h {
    private PushTaskBean f13179a;
    private String f13180b;

    public C3917b(PushTaskBean pushTaskBean, String str, long j) {
        super(j);
        this.o = false;
        this.f13179a = pushTaskBean;
        this.f13180b = str;
    }

    protected void m16114a() {
        C3777e.m15491a().m15538b(this.f13179a, this.f13180b);
    }

    public int m16115b() {
        return 0;
    }

    public void m16116c() {
        super.m14960c();
    }
}
