package com.google.android.gms.p146b;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.C2869k;
import com.google.android.gms.common.internal.C3512u;

@gb
/* renamed from: com.google.android.gms.b.ih */
public class ih {
    private final ii f11408a;
    private final Context f11409b;
    private final ViewGroup f11410c;
    private C2869k f11411d;

    public ih(Context context, ViewGroup viewGroup, ii iiVar) {
        this(context, viewGroup, iiVar, null);
    }

    ih(Context context, ViewGroup viewGroup, ii iiVar, C2869k c2869k) {
        this.f11409b = context;
        this.f11410c = viewGroup;
        this.f11408a = iiVar;
        this.f11411d = c2869k;
    }

    public C2869k m13213a() {
        C3512u.m14587b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f11411d;
    }

    public void m13214a(int i, int i2, int i3, int i4) {
        C3512u.m14587b("The underlay may only be modified from the UI thread.");
        if (this.f11411d != null) {
            this.f11411d.m11146a(i, i2, i3, i4);
        }
    }

    public void m13215a(int i, int i2, int i3, int i4, int i5) {
        if (this.f11411d == null) {
            au.m11834a(this.f11408a.m13261x().m11846a(), this.f11408a.m13260w(), "vpr");
            aw a = au.m11831a(this.f11408a.m13261x().m11846a());
            this.f11411d = new C2869k(this.f11409b, this.f11408a, i5, this.f11408a.m13261x().m11846a(), a);
            this.f11410c.addView(this.f11411d, 0, new LayoutParams(-1, -1));
            this.f11411d.m11146a(i, i2, i3, i4);
            this.f11408a.m13249l().m13288a(false);
        }
    }

    public void m13216b() {
        C3512u.m14587b("onPause must be called from the UI thread.");
        if (this.f11411d != null) {
            this.f11411d.m11156h();
        }
    }

    public void m13217c() {
        C3512u.m14587b("onDestroy must be called from the UI thread.");
        if (this.f11411d != null) {
            this.f11411d.m11161m();
        }
    }
}
