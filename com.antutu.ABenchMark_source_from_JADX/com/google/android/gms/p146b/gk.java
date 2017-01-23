package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.p146b.gj.C3229a;
import java.util.WeakHashMap;

@gb
/* renamed from: com.google.android.gms.b.gk */
public final class gk {
    private WeakHashMap<Context, C3230a> f11155a;

    /* renamed from: com.google.android.gms.b.gk.a */
    private class C3230a {
        public final long f11152a;
        public final gj f11153b;
        final /* synthetic */ gk f11154c;

        public C3230a(gk gkVar, gj gjVar) {
            this.f11154c = gkVar;
            this.f11152a = C2968s.m11529i().m13543a();
            this.f11153b = gjVar;
        }

        public boolean m12896a() {
            return ((Long) aq.am.m11794c()).longValue() + this.f11152a < C2968s.m11529i().m13543a();
        }
    }

    public gk() {
        this.f11155a = new WeakHashMap();
    }

    public gj m12897a(Context context) {
        C3230a c3230a = (C3230a) this.f11155a.get(context);
        gj a = (c3230a == null || c3230a.m12896a() || !((Boolean) aq.al.m11794c()).booleanValue()) ? new C3229a(context).m12895a() : new C3229a(context, c3230a.f11153b).m12895a();
        this.f11155a.put(context, new C3230a(this, a));
        return a;
    }
}
