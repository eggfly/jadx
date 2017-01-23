package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.request.C2914c.C2910a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.p146b.aj;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gc;
import com.google.android.gms.p146b.gd;
import com.google.android.gms.p146b.hl;
import com.google.android.gms.p146b.ib;
import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import com.igexin.sdk.PushConsts;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.d */
public abstract class C2919d implements C2910a, hl<Void> {
    private final ib<AdRequestInfoParcel> f9942a;
    private final C2910a f9943b;
    private final Object f9944c;

    /* renamed from: com.google.android.gms.ads.internal.request.d.1 */
    class C29161 implements C2915c<AdRequestInfoParcel> {
        final /* synthetic */ C2934j f9939a;
        final /* synthetic */ C2919d f9940b;

        C29161(C2919d c2919d, C2934j c2934j) {
            this.f9940b = c2919d;
            this.f9939a = c2934j;
        }

        public void m11323a(AdRequestInfoParcel adRequestInfoParcel) {
            if (!this.f9940b.m11329a(this.f9939a, adRequestInfoParcel)) {
                this.f9940b.m11327a();
            }
        }

        public /* synthetic */ void m11324a(Object obj) {
            m11323a((AdRequestInfoParcel) obj);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.request.d.2 */
    class C29182 implements C2917a {
        final /* synthetic */ C2919d f9941a;

        C29182(C2919d c2919d) {
            this.f9941a = c2919d;
        }

        public void m11326a() {
            this.f9941a.m11327a();
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.request.d.a */
    public static final class C2920a extends C2919d {
        private final Context f9945a;

        public C2920a(Context context, ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
            super(ibVar, c2910a);
            this.f9945a = context;
        }

        public void m11334a() {
        }

        public C2934j m11335b() {
            return gd.m12820a(this.f9945a, new aj((String) aq.f10288b.m11794c()), gc.m12810a());
        }

        public /* synthetic */ Object m11336e() {
            return super.m11331c();
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.request.d.b */
    public static class C2923b extends C2919d implements C2921b, C2922c {
        protected C2927e f9946a;
        private Context f9947b;
        private VersionInfoParcel f9948c;
        private ib<AdRequestInfoParcel> f9949d;
        private final C2910a f9950e;
        private final Object f9951f;
        private boolean f9952g;

        public C2923b(Context context, VersionInfoParcel versionInfoParcel, ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
            Looper a;
            super(ibVar, c2910a);
            this.f9951f = new Object();
            this.f9947b = context;
            this.f9948c = versionInfoParcel;
            this.f9949d = ibVar;
            this.f9950e = c2910a;
            if (((Boolean) aq.f10261A.m11794c()).booleanValue()) {
                this.f9952g = true;
                a = C2968s.m11537q().m13153a();
            } else {
                a = context.getMainLooper();
            }
            this.f9946a = new C2927e(context, a, this, this, this.f9948c.f10083d);
            m11346f();
        }

        public void m11340a() {
            synchronized (this.f9951f) {
                if (this.f9946a.m11387e() || this.f9946a.m11393l()) {
                    this.f9946a.m11386d();
                }
                Binder.flushPendingCommands();
                if (this.f9952g) {
                    C2968s.m11537q().m13154b();
                    this.f9952g = false;
                }
            }
        }

        public void m11341a(int i) {
            C2972b.m11576a("Disconnected from remote ad request service.");
        }

        public void m11342a(Bundle bundle) {
            m11331c();
        }

        public void m11343a(ConnectionResult connectionResult) {
            C2972b.m11576a("Cannot connect to remote service, fallback to local instance.");
            m11347g().m10969e();
            Bundle bundle = new Bundle();
            bundle.putString(PushConsts.CMD_ACTION, "gms_connection_failed_fallback_to_local");
            C2968s.m11525e().m13055b(this.f9947b, this.f9948c.f10081b, "gmob-apps", bundle, true);
        }

        public C2934j m11344b() {
            C2934j c;
            synchronized (this.f9951f) {
                try {
                    c = this.f9946a.m11404c();
                } catch (IllegalStateException e) {
                    c = null;
                    return c;
                } catch (DeadObjectException e2) {
                    c = null;
                    return c;
                }
            }
            return c;
        }

        public /* synthetic */ Object m11345e() {
            return super.m11331c();
        }

        protected void m11346f() {
            this.f9946a.m11392k();
        }

        hl m11347g() {
            return new C2920a(this.f9947b, this.f9949d, this.f9950e);
        }
    }

    public C2919d(ib<AdRequestInfoParcel> ibVar, C2910a c2910a) {
        this.f9944c = new Object();
        this.f9942a = ibVar;
        this.f9943b = c2910a;
    }

    public abstract void m11327a();

    public void m11328a(AdResponseParcel adResponseParcel) {
        synchronized (this.f9944c) {
            this.f9943b.m11304a(adResponseParcel);
            m11327a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m11329a(com.google.android.gms.ads.internal.request.C2934j r5, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = 1;
        r2 = new com.google.android.gms.ads.internal.request.g;	 Catch:{ RemoteException -> 0x000b, NullPointerException -> 0x0024, SecurityException -> 0x0032, Throwable -> 0x0040 }
        r2.<init>(r4);	 Catch:{ RemoteException -> 0x000b, NullPointerException -> 0x0024, SecurityException -> 0x0032, Throwable -> 0x0040 }
        r5.m11418a(r6, r2);	 Catch:{ RemoteException -> 0x000b, NullPointerException -> 0x0024, SecurityException -> 0x0032, Throwable -> 0x0040 }
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = move-exception;
        r3 = "Could not fetch ad response from ad request service.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r3, r2);
        r3 = com.google.android.gms.ads.internal.C2968s.m11528h();
        r3.m12941a(r2, r0);
    L_0x0018:
        r0 = r4.f9943b;
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r2.<init>(r1);
        r0.m11304a(r2);
        r0 = r1;
        goto L_0x000a;
    L_0x0024:
        r2 = move-exception;
        r3 = "Could not fetch ad response from ad request service due to an Exception.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r3, r2);
        r3 = com.google.android.gms.ads.internal.C2968s.m11528h();
        r3.m12941a(r2, r0);
        goto L_0x0018;
    L_0x0032:
        r2 = move-exception;
        r3 = "Could not fetch ad response from ad request service due to an Exception.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r3, r2);
        r3 = com.google.android.gms.ads.internal.C2968s.m11528h();
        r3.m12941a(r2, r0);
        goto L_0x0018;
    L_0x0040:
        r2 = move-exception;
        r3 = "Could not fetch ad response from ad request service due to an Exception.";
        com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r3, r2);
        r3 = com.google.android.gms.ads.internal.C2968s.m11528h();
        r3.m12941a(r2, r0);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.d.a(com.google.android.gms.ads.internal.request.j, com.google.android.gms.ads.internal.request.AdRequestInfoParcel):boolean");
    }

    public abstract C2934j m11330b();

    public Void m11331c() {
        C2934j b = m11330b();
        if (b == null) {
            this.f9943b.m11304a(new AdResponseParcel(0));
            m11327a();
        } else {
            this.f9942a.m12249a(new C29161(this, b), new C29182(this));
        }
        return null;
    }

    public void m11332d() {
        m11327a();
    }

    public /* synthetic */ Object m11333e() {
        return m11331c();
    }
}
