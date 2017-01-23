package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.C2635c;
import com.google.android.gms.ads.mediation.C2636g;
import com.google.android.gms.ads.mediation.C2637e;
import com.google.android.gms.ads.mediation.C2974a;
import com.google.android.gms.ads.mediation.C2987d;
import com.google.android.gms.ads.mediation.C2988f;
import com.google.android.gms.ads.mediation.C2989h;
import com.google.android.gms.ads.mediation.C2990l;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements C2635c, C2637e, C2636g {
    C2983b f10100a;
    C2985e f10101b;
    C2986g f10102c;
    private View f10103d;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.a */
    static final class C2977a implements C2976c {
        private final CustomEventAdapter f10093a;
        private final C2987d f10094b;

        public C2977a(CustomEventAdapter customEventAdapter, C2987d c2987d) {
            this.f10093a = customEventAdapter;
            this.f10094b = c2987d;
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.b */
    class C2979b implements C2978f {
        final /* synthetic */ CustomEventAdapter f10095a;
        private final CustomEventAdapter f10096b;
        private final C2988f f10097c;

        public C2979b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C2988f c2988f) {
            this.f10095a = customEventAdapter;
            this.f10096b = customEventAdapter2;
            this.f10097c = c2988f;
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.c */
    static class C2981c implements C2980h {
        private final CustomEventAdapter f10098a;
        private final C2989h f10099b;

        public C2981c(CustomEventAdapter customEventAdapter, C2989h c2989h) {
            this.f10098a = customEventAdapter;
            this.f10099b = c2989h;
        }
    }

    private static <T> T m11597a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C2972b.m11583d("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    C2979b m11598a(C2988f c2988f) {
        return new C2979b(this, this, c2988f);
    }

    public void m11599a() {
        if (this.f10100a != null) {
            this.f10100a.m11607a();
        }
        if (this.f10101b != null) {
            this.f10101b.m11607a();
        }
        if (this.f10102c != null) {
            this.f10102c.m11607a();
        }
    }

    public void m11600a(Context context, C2987d c2987d, Bundle bundle, C2719d c2719d, C2974a c2974a, Bundle bundle2) {
        this.f10100a = (C2983b) m11597a(bundle.getString("class_name"));
        if (this.f10100a == null) {
            c2987d.m11616a(this, 0);
            return;
        }
        this.f10100a.m11610a(context, new C2977a(this, c2987d), bundle.getString("parameter"), c2719d, c2974a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void m11601a(Context context, C2988f c2988f, Bundle bundle, C2974a c2974a, Bundle bundle2) {
        this.f10101b = (C2985e) m11597a(bundle.getString("class_name"));
        if (this.f10101b == null) {
            c2988f.m11622a(this, 0);
            return;
        }
        this.f10101b.m11612a(context, m11598a(c2988f), bundle.getString("parameter"), c2974a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void m11602a(Context context, C2989h c2989h, Bundle bundle, C2990l c2990l, Bundle bundle2) {
        this.f10102c = (C2986g) m11597a(bundle.getString("class_name"));
        if (this.f10102c == null) {
            c2989h.m11628a((C2636g) this, 0);
            return;
        }
        this.f10102c.m11614a(context, new C2981c(this, c2989h), bundle.getString("parameter"), c2990l, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void m11603b() {
        if (this.f10100a != null) {
            this.f10100a.m11608b();
        }
        if (this.f10101b != null) {
            this.f10101b.m11608b();
        }
        if (this.f10102c != null) {
            this.f10102c.m11608b();
        }
    }

    public void m11604c() {
        if (this.f10100a != null) {
            this.f10100a.m11609c();
        }
        if (this.f10101b != null) {
            this.f10101b.m11609c();
        }
        if (this.f10102c != null) {
            this.f10102c.m11609c();
        }
    }

    public View m11605d() {
        return this.f10103d;
    }

    public void m11606e() {
        this.f10101b.m11613d();
    }
}
