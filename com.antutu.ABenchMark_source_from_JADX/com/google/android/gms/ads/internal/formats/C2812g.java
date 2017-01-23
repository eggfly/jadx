package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.C2900q;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.C3326k;
import com.google.android.gms.p146b.dz;
import com.google.android.gms.p146b.ea;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p151a.C2690b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.g */
public class C2812g extends C2811i {
    private dz f9545a;
    private ea f9546b;
    private final C2900q f9547c;
    private C2810h f9548d;
    private boolean f9549e;
    private Object f9550f;

    private C2812g(Context context, C2900q c2900q, C3326k c3326k) {
        super(context, c2900q, null, c3326k, null, null, null);
        this.f9549e = false;
        this.f9550f = new Object();
        this.f9547c = c2900q;
    }

    public C2812g(Context context, C2900q c2900q, C3326k c3326k, dz dzVar) {
        this(context, c2900q, c3326k);
        this.f9545a = dzVar;
    }

    public C2812g(Context context, C2900q c2900q, C3326k c3326k, ea eaVar) {
        this(context, c2900q, c3326k);
        this.f9546b = eaVar;
    }

    public C2800b m10887a(OnClickListener onClickListener) {
        return null;
    }

    public void m10888a() {
        C3512u.m14587b("recordImpression must be called on the main UI thread.");
        synchronized (this.f9550f) {
            m10880a(true);
            if (this.f9548d != null) {
                this.f9548d.m10862a();
            } else {
                try {
                    if (this.f9545a != null && !this.f9545a.m12428j()) {
                        this.f9545a.m12427i();
                    } else if (!(this.f9546b == null || this.f9546b.m12459h())) {
                        this.f9546b.m12458g();
                    }
                } catch (Throwable e) {
                    C2972b.m11584d("Failed to call recordImpression", e);
                }
            }
            this.f9547c.m10497y();
        }
    }

    public void m10889a(View view) {
        synchronized (this.f9550f) {
            this.f9549e = true;
            try {
                if (this.f9545a != null) {
                    this.f9545a.m12420b(C2690b.m10262a((Object) view));
                } else if (this.f9546b != null) {
                    this.f9546b.m12453b(C2690b.m10262a((Object) view));
                }
            } catch (Throwable e) {
                C2972b.m11584d("Failed to call prepareAd", e);
            }
            this.f9549e = false;
        }
    }

    public void m10890a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C3512u.m14587b("performClick must be called on the main UI thread.");
        synchronized (this.f9550f) {
            if (this.f9548d != null) {
                this.f9548d.m10864a(view, map, jSONObject, jSONObject2, jSONObject3);
                this.f9547c.m10474a();
            } else {
                try {
                    if (!(this.f9545a == null || this.f9545a.m12429k())) {
                        this.f9545a.m12418a(C2690b.m10262a((Object) view));
                        this.f9547c.m10474a();
                    }
                    if (!(this.f9546b == null || this.f9546b.m12460i())) {
                        this.f9546b.m12451a(C2690b.m10262a((Object) view));
                        this.f9547c.m10474a();
                    }
                } catch (Throwable e) {
                    C2972b.m11584d("Failed to call performClick", e);
                }
            }
        }
    }

    public void m10891a(C2810h c2810h) {
        synchronized (this.f9550f) {
            this.f9548d = c2810h;
        }
    }

    public boolean m10892b() {
        boolean z;
        synchronized (this.f9550f) {
            z = this.f9549e;
        }
        return z;
    }

    public C2810h m10893c() {
        C2810h c2810h;
        synchronized (this.f9550f) {
            c2810h = this.f9548d;
        }
        return c2810h;
    }

    public ii m10894d() {
        return null;
    }
}
