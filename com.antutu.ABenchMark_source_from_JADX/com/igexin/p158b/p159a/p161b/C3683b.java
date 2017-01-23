package com.igexin.p158b.p159a.p161b;

/* renamed from: com.igexin.b.a.b.b */
public abstract class C3683b {
    protected String f12409c;
    protected C3683b f12410d;
    protected C3683b f12411e;
    protected boolean f12412f;

    public C3683b(String str, boolean z) {
        this.f12409c = str;
        this.f12412f = z;
    }

    public abstract Object m15042a(C3667e c3667e, C3686d c3686d, Object obj);

    protected final void m15043a(C3683b c3683b) {
        if (c3683b != null) {
            C3683b c3683b2 = c3683b.f12410d;
            c3683b.f12410d = this;
            this.f12411e = c3683b;
            this.f12410d = c3683b2;
        }
    }

    public void m15044a(boolean z) {
        if (!this.f12412f || z) {
            while (this.f12410d != null) {
                C3683b c3683b = this.f12410d.f12410d;
                this.f12410d.f12410d = null;
                this.f12410d = c3683b;
            }
        }
    }

    public abstract Object m15045c(C3667e c3667e, C3686d c3686d, Object obj);

    public final Object m15046d(C3667e c3667e, C3686d c3686d, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Nothing to encode!");
        }
        if (this.f12410d != null) {
            obj = this.f12410d.m15046d(c3667e, c3686d, obj);
        }
        return m15042a(c3667e, c3686d, obj);
    }
}
