package com.igexin.push.p169f.p170b;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.push.core.p176a.C3777e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.a */
public class C3916a extends C3732h {
    private static C3916a f13177b;
    private List f13178a;

    private C3916a() {
        super(360000);
        this.o = true;
        this.f13178a = new ArrayList();
    }

    public static C3916a m16109g() {
        if (f13177b == null) {
            f13177b = new C3916a();
        }
        return f13177b;
    }

    private void m16110h() {
        m14954a(360000, TimeUnit.MILLISECONDS);
    }

    protected void m16111a() {
        C3777e.m15491a().m15506B();
        for (C3711d c3711d : this.f13178a) {
            if (c3711d.m15211b()) {
                c3711d.m15209a();
                c3711d.m15210a(System.currentTimeMillis());
            }
        }
        m16110h();
        C3685c.m15060b().m15055a((Object) this);
    }

    public boolean m16112a(C3711d c3711d) {
        return (this.f13178a == null || this.f13178a.contains(c3711d) || !this.f13178a.add(c3711d)) ? false : true;
    }

    public int m16113b() {
        return 0;
    }
}
