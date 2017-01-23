package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.util.C2498g;

/* renamed from: com.facebook.ads.internal.adapters.a */
public abstract class C2299a {
    protected final C2268b f7958a;
    private final Context f7959b;
    private boolean f7960c;

    public C2299a(Context context, C2268b c2268b) {
        this.f7959b = context;
        this.f7958a = c2268b;
    }

    public final void m8719a() {
        if (!this.f7960c) {
            if (this.f7958a != null) {
                this.f7958a.m8578d();
            }
            m8720b();
            this.f7960c = true;
            C2498g.m9477a(this.f7959b, "Impression logged");
            if (this.f7958a != null) {
                this.f7958a.m8579e();
            }
        }
    }

    protected abstract void m8720b();
}
