package com.google.android.gms.p146b;

import com.google.android.gms.p146b.dp.C3145a;
import com.google.android.gms.p146b.dw.C3141a;

@gb
/* renamed from: com.google.android.gms.b.dn */
public final class dn extends C3141a {
    private final Object f10663a;
    private C3145a f10664b;
    private dm f10665c;

    public dn() {
        this.f10663a = new Object();
    }

    public void m12302a() {
        synchronized (this.f10663a) {
            if (this.f10665c != null) {
                this.f10665c.m10468t();
            }
        }
    }

    public void m12303a(int i) {
        synchronized (this.f10663a) {
            if (this.f10664b != null) {
                this.f10664b.m12314a(i == 3 ? 1 : 2);
                this.f10664b = null;
            }
        }
    }

    public void m12304a(dm dmVar) {
        synchronized (this.f10663a) {
            this.f10665c = dmVar;
        }
    }

    public void m12305a(C3145a c3145a) {
        synchronized (this.f10663a) {
            this.f10664b = c3145a;
        }
    }

    public void m12306a(dy dyVar) {
        synchronized (this.f10663a) {
            if (this.f10664b != null) {
                this.f10664b.m12315a(0, dyVar);
                this.f10664b = null;
                return;
            }
            if (this.f10665c != null) {
                this.f10665c.m10472x();
            }
        }
    }

    public void m12307b() {
        synchronized (this.f10663a) {
            if (this.f10665c != null) {
                this.f10665c.m10469u();
            }
        }
    }

    public void m12308c() {
        synchronized (this.f10663a) {
            if (this.f10665c != null) {
                this.f10665c.m10470v();
            }
        }
    }

    public void m12309d() {
        synchronized (this.f10663a) {
            if (this.f10665c != null) {
                this.f10665c.m10471w();
            }
        }
    }

    public void m12310e() {
        synchronized (this.f10663a) {
            if (this.f10664b != null) {
                this.f10664b.m12314a(0);
                this.f10664b = null;
                return;
            }
            if (this.f10665c != null) {
                this.f10665c.m10472x();
            }
        }
    }
}
