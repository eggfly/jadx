package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C2755b;
import com.google.android.gms.ads.internal.client.C2774l;
import com.google.android.gms.ads.internal.client.C2775m;
import com.google.android.gms.ads.internal.client.C2779q;
import com.google.android.gms.ads.internal.client.aa;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p124b.C2704b;
import com.google.android.gms.ads.p124b.C2706d.C2303a;
import com.google.android.gms.ads.p124b.C2708f.C2305a;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.bt;
import com.google.android.gms.p146b.bu;
import com.google.android.gms.p146b.dt;

/* renamed from: com.google.android.gms.ads.b */
public class C2710b {
    private final C2779q f9238a;
    private final Context f9239b;
    private final aa f9240c;

    /* renamed from: com.google.android.gms.ads.b.a */
    public static class C2699a {
        private final Context f9228a;
        private final ab f9229b;

        C2699a(Context context, ab abVar) {
            this.f9228a = context;
            this.f9229b = abVar;
        }

        public C2699a(Context context, String str) {
            this((Context) C3512u.m14581a((Object) context, (Object) "context cannot be null"), C2775m.m10712a(context, str, new dt()));
        }

        public C2699a m10269a(C2301a c2301a) {
            try {
                this.f9229b.m10514a(new C2774l(c2301a));
            } catch (Throwable e) {
                C2972b.m11584d("Failed to set AdListener.", e);
            }
            return this;
        }

        public C2699a m10270a(C2704b c2704b) {
            try {
                this.f9229b.m10515a(new NativeAdOptionsParcel(c2704b));
            } catch (Throwable e) {
                C2972b.m11584d("Failed to specify native ad options", e);
            }
            return this;
        }

        public C2699a m10271a(C2303a c2303a) {
            try {
                this.f9229b.m10516a(new bt(c2303a));
            } catch (Throwable e) {
                C2972b.m11584d("Failed to add app install ad listener", e);
            }
            return this;
        }

        public C2699a m10272a(C2305a c2305a) {
            try {
                this.f9229b.m10517a(new bu(c2305a));
            } catch (Throwable e) {
                C2972b.m11584d("Failed to add content ad listener", e);
            }
            return this;
        }

        public C2710b m10273a() {
            try {
                return new C2710b(this.f9228a, this.f9229b.m10512a());
            } catch (Throwable e) {
                C2972b.m11580b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    C2710b(Context context, aa aaVar) {
        this(context, aaVar, C2779q.m10726a());
    }

    C2710b(Context context, aa aaVar, C2779q c2779q) {
        this.f9239b = context;
        this.f9240c = aaVar;
        this.f9238a = c2779q;
    }

    private void m10307a(C2755b c2755b) {
        try {
            this.f9240c.m10505a(this.f9238a.m10727a(this.f9239b, c2755b));
        } catch (Throwable e) {
            C2972b.m11580b("Failed to load ad.", e);
        }
    }

    public void m10308a(C2716c c2716c) {
        m10307a(c2716c.m10333a());
    }
}
