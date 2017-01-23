package com.igexin.p158b.p159a.p161b.p162a.p163a;

import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.C3683b;

/* renamed from: com.igexin.b.a.b.a.a.a */
public abstract class C3668a extends C3667e {
    protected boolean f12358e;
    protected C3669b f12359f;
    protected String f12360g;
    protected boolean f12361h;

    public C3668a(int i, String str, C3683b c3683b) {
        super(i, str, c3683b);
        this.f12359f = C3669b.NORMAL;
        this.f12361h = true;
    }

    public final void m14975d() {
        super.m14961d();
        this.n = true;
    }

    protected void m14976e() {
    }

    protected boolean m14977g() {
        return this.f12359f == C3669b.INTERRUPT;
    }
}
