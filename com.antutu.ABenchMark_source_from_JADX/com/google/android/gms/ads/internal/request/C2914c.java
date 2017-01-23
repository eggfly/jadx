package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.request.C2919d.C2920a;
import com.google.android.gms.ads.internal.request.C2919d.C2923b;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hl;
import com.google.android.gms.p146b.ib;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.c */
public final class C2914c {

    /* renamed from: com.google.android.gms.ads.internal.request.c.a */
    public interface C2910a {
        void m11304a(AdResponseParcel adResponseParcel);
    }

    /* renamed from: com.google.android.gms.ads.internal.request.c.b */
    interface C2912b {
        boolean m11316a(VersionInfoParcel versionInfoParcel);
    }

    /* renamed from: com.google.android.gms.ads.internal.request.c.1 */
    static class C29131 implements C2912b {
        final /* synthetic */ Context f9938a;

        C29131(Context context) {
            this.f9938a = context;
        }

        public boolean m11317a(VersionInfoParcel versionInfoParcel) {
            return versionInfoParcel.f10084e || (C3465h.m14301f(this.f9938a) && !((Boolean) aq.f10262B.m11794c()).booleanValue());
        }
    }

    public static hl m11318a(Context context, VersionInfoParcel versionInfoParcel, ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
        return C2914c.m11319a(context, versionInfoParcel, ibVar, c2910a, new C29131(context));
    }

    static hl m11319a(Context context, VersionInfoParcel versionInfoParcel, ib<AdRequestInfoParcel> ibVar, C2910a c2910a, C2912b c2912b) {
        return c2912b.m11316a(versionInfoParcel) ? C2914c.m11320a(context, ibVar, c2910a) : C2914c.m11321b(context, versionInfoParcel, ibVar, c2910a);
    }

    private static hl m11320a(Context context, ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
        C2972b.m11576a("Fetching ad response from local ad request service.");
        hl c2920a = new C2920a(context, ibVar, c2910a);
        c2920a.m11331c();
        return c2920a;
    }

    private static hl m11321b(Context context, VersionInfoParcel versionInfoParcel, ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
        C2972b.m11576a("Fetching ad response from remote ad request service.");
        if (C2784w.m10741a().m11572b(context)) {
            return new C2923b(context, versionInfoParcel, ibVar, c2910a);
        }
        C2972b.m11583d("Failed to connect to remote ad request service.");
        return null;
    }
}
