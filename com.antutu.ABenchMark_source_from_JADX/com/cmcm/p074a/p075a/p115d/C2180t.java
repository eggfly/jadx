package com.cmcm.p074a.p075a.p115d;

import com.cmcm.p074a.p075a.p112a.C2108b;
import com.cmcm.p074a.p075a.p112a.C2131x;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.util.List;

/* renamed from: com.cmcm.a.a.d.t */
class C2180t implements C2178x {
    final /* synthetic */ C2169j f7567a;
    private int f7568b;
    private boolean f7569c;
    private File f7570d;
    private List f7571e;

    private C2180t(C2169j c2169j) {
        this.f7567a = c2169j;
    }

    private void m8208b() {
        if (this.f7570d != null) {
            boolean delete = this.f7570d.delete();
            if (C2133z.f7482a && !delete) {
                C2169j.m8180b(10, "failed to delete the temp file", new Object[0]);
            }
            this.f7570d = null;
        }
        this.f7568b = 0;
        this.f7569c = false;
    }

    public void m8211a(File file, List list) {
        this.f7570d = file;
        this.f7571e = list;
        this.f7569c = true;
        this.f7567a.f7540e.m8167a(this.f7571e, true);
        this.f7567a.m8176a(C2131x.m8050a().m8055d(), this.f7570d, (C2178x) this);
    }

    public void m8212a(boolean z) {
        if (z) {
            m8208b();
            this.f7567a.f7540e.m8166a(this.f7571e);
            C2108b.m7936a().m7940c().putLong("report_timestamp", System.currentTimeMillis()).apply();
            this.f7567a.f7539d.postDelayed(new C2181u(this), 300000);
            if (C2133z.f7482a) {
                C2169j.m8180b(10, MsgConstant.KEY_SUCCESS, new Object[0]);
                return;
            }
            return;
        }
        int i = this.f7568b;
        this.f7568b = i + 1;
        if (i == 3) {
            m8208b();
            this.f7567a.f7540e.m8167a(this.f7571e, false);
            if (C2133z.f7482a) {
                C2169j.m8180b(10, "failed", new Object[0]);
                return;
            }
            return;
        }
        this.f7567a.f7539d.postDelayed(new C2182v(this), 300000);
        if (C2133z.f7482a) {
            C2169j.m8180b(10, "trying", new Object[0]);
        }
    }

    public boolean m8213a() {
        return this.f7569c;
    }
}
