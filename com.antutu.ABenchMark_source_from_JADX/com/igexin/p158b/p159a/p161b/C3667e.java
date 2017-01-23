package com.igexin.p158b.p159a.p161b;

import com.igexin.p158b.p159a.p165d.C3666d;

/* renamed from: com.igexin.b.a.b.e */
public abstract class C3667e extends C3666d {
    public String f12354a;
    public C3683b f12355b;
    public Object f12356c;
    public C3686d f12357d;

    public C3667e(int i, String str, C3683b c3683b) {
        super(i);
        if (str != null) {
            this.f12354a = m14973a(str);
        }
        this.f12355b = c3683b;
    }

    public C3667e(String str, C3683b c3683b) {
        this(0, str, c3683b);
    }

    private String m14973a(String str) {
        return C3687f.m15078a(C3687f.m15083a(str));
    }

    public void m14974f() {
        if (this.f12355b != null) {
            this.f12355b.m15044a(false);
        }
        this.f12355b = null;
        this.f12357d = null;
        this.f12356c = null;
        this.f12354a = null;
        super.m14963f();
    }
}
