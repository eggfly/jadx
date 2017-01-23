package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.client.C2757d;
import com.google.android.gms.ads.p149d.C2639b;

/* renamed from: com.google.android.gms.ads.h */
public final class C2725h {
    private final C2757d f9286a;

    public C2725h(Context context) {
        this.f9286a = new C2757d(context);
    }

    public void m10373a() {
        this.f9286a.m10637a();
    }

    public void m10374a(C2301a c2301a) {
        this.f9286a.m10638a(c2301a);
        if (c2301a != null && (c2301a instanceof C2646a)) {
            this.f9286a.m10640a((C2646a) c2301a);
        } else if (c2301a == null) {
            this.f9286a.m10640a(null);
        }
    }

    public void m10375a(C2716c c2716c) {
        this.f9286a.m10641a(c2716c.m10333a());
    }

    public void m10376a(C2639b c2639b) {
        this.f9286a.m10639a(c2639b);
    }

    public void m10377a(String str) {
        this.f9286a.m10642a(str);
    }

    public void m10378a(boolean z) {
        this.f9286a.m10643a(z);
    }

    public void m10379b(String str) {
        this.f9286a.m10644b(str);
    }
}
