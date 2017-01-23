package com.google.android.gms.p146b;

import android.view.View;
import com.google.android.gms.ads.internal.C2793h;
import com.google.android.gms.p146b.bc.C3038a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;

@gb
/* renamed from: com.google.android.gms.b.ba */
public final class ba extends C3038a {
    private final C2793h f10352a;
    private final String f10353b;
    private final String f10354c;

    public ba(C2793h c2793h, String str, String str2) {
        this.f10352a = c2793h;
        this.f10353b = str;
        this.f10354c = str2;
    }

    public String m11867a() {
        return this.f10353b;
    }

    public void m11868a(C2687a c2687a) {
        if (c2687a != null) {
            this.f10352a.m10757b((View) C2690b.m10263a(c2687a));
        }
    }

    public String m11869b() {
        return this.f10354c;
    }

    public void m11870c() {
        this.f10352a.m10758z();
    }

    public void m11871d() {
        this.f10352a.m10756A();
    }
}
