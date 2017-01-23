package com.cmcm.support;

import com.cmcm.support.p116a.C2194g;

/* renamed from: com.cmcm.support.n */
public class C2245n extends C2194g {
    protected String f7736a;
    protected C2233f f7737b;

    public C2245n(C2233f c2233f, String str) {
        this.f7737b = null;
        this.f7736a = str;
        this.f7737b = c2233f;
    }

    public void m8494a() {
        if (this.f7737b != null) {
            String a = C2194g.m8253a(this.c);
            if (a.length() > 0 && this.f7736a != null && this.f7736a.length() > 0) {
                this.f7737b.m8415a(a, this.f7736a);
            }
        }
    }
}
