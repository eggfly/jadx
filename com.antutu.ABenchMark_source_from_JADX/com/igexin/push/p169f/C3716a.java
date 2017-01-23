package com.igexin.push.p169f;

import com.igexin.p158b.p159a.p165d.C3666d;

/* renamed from: com.igexin.push.f.a */
public abstract class C3716a extends C3666d {
    private Object f12531a;
    private Object f12532b;

    public C3716a(Object obj) {
        super(20160818);
        this.f12531a = obj;
    }

    protected abstract Object m15227a(Object obj);

    protected abstract void m15228a(Object obj, Object obj2);

    public void a_() {
        super.a_();
        this.f12532b = m15227a(this.f12531a);
    }

    public int m15229b() {
        return 20160818;
    }

    public void m15230c() {
        super.m14960c();
        m15228a(this.f12531a, this.f12532b);
    }

    public void m15231d() {
        this.n = true;
    }

    protected void m15232e() {
    }
}
