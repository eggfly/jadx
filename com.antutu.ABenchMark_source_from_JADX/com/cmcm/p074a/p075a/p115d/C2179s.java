package com.cmcm.p074a.p075a.p115d;

import com.cmcm.p074a.p075a.p112a.C2133z;
import java.io.File;
import java.util.List;

/* renamed from: com.cmcm.a.a.d.s */
class C2179s implements C2178x {
    final /* synthetic */ File f7564a;
    final /* synthetic */ List f7565b;
    final /* synthetic */ C2169j f7566c;

    C2179s(C2169j c2169j, File file, List list) {
        this.f7566c = c2169j;
        this.f7564a = file;
        this.f7565b = list;
    }

    public void m8206a(boolean z) {
        if (C2133z.f7482a) {
            C2169j.m8180b(50, "result: %s", Boolean.valueOf(z));
        }
        if (z) {
            boolean delete = this.f7564a.delete();
            if (C2133z.f7482a && !delete) {
                C2169j.m8180b(50, "failed to delete the temp file", new Object[0]);
            }
            this.f7566c.f7540e.m8166a(this.f7565b);
            return;
        }
        this.f7566c.f7540e.m8167a(this.f7565b, false);
    }
}
