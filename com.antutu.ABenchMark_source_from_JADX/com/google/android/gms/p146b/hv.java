package com.google.android.gms.p146b;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.hv */
public final class hv {
    private Activity f11353a;
    private boolean f11354b;
    private boolean f11355c;
    private boolean f11356d;
    private OnGlobalLayoutListener f11357e;
    private OnScrollChangedListener f11358f;

    public hv(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f11353a = activity;
        this.f11357e = onGlobalLayoutListener;
        this.f11358f = onScrollChangedListener;
    }

    private void m13161e() {
        if (this.f11353a != null && !this.f11354b) {
            if (this.f11357e != null) {
                C2968s.m11525e().m13031a(this.f11353a, this.f11357e);
            }
            if (this.f11358f != null) {
                C2968s.m11525e().m13032a(this.f11353a, this.f11358f);
            }
            this.f11354b = true;
        }
    }

    private void m13162f() {
        if (this.f11353a != null && this.f11354b) {
            if (this.f11357e != null) {
                C2968s.m11527g().m13081a(this.f11353a, this.f11357e);
            }
            if (this.f11358f != null) {
                C2968s.m11525e().m13054b(this.f11353a, this.f11358f);
            }
            this.f11354b = false;
        }
    }

    public void m13163a() {
        this.f11356d = true;
        if (this.f11355c) {
            m13161e();
        }
    }

    public void m13164a(Activity activity) {
        this.f11353a = activity;
    }

    public void m13165b() {
        this.f11356d = false;
        m13162f();
    }

    public void m13166c() {
        this.f11355c = true;
        if (this.f11356d) {
            m13161e();
        }
    }

    public void m13167d() {
        this.f11355c = false;
        m13162f();
    }
}
