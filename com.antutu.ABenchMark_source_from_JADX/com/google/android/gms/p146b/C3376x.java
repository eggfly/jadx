package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.dd.C3135d;
import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import com.google.android.gms.p146b.ib.C3280b;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.x */
public class C3376x extends C3364q {
    private C3135d f11761d;
    private boolean f11762e;

    /* renamed from: com.google.android.gms.b.x.1 */
    class C33701 implements C2915c<de> {
        final /* synthetic */ JSONObject f11753a;
        final /* synthetic */ C3376x f11754b;

        C33701(C3376x c3376x, JSONObject jSONObject) {
            this.f11754b = c3376x;
            this.f11753a = jSONObject;
        }

        public void m13890a(de deVar) {
            this.f11754b.m13845a(this.f11753a);
        }

        public /* synthetic */ void m13891a(Object obj) {
            m13890a((de) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.x.2 */
    class C33712 implements C2917a {
        final /* synthetic */ C3376x f11755a;

        C33712(C3376x c3376x) {
            this.f11755a = c3376x;
        }

        public void m13892a() {
        }
    }

    /* renamed from: com.google.android.gms.b.x.3 */
    class C33723 implements C2915c<de> {
        final /* synthetic */ C3376x f11756a;

        C33723(C3376x c3376x) {
            this.f11756a = c3376x;
        }

        public void m13893a(de deVar) {
            this.f11756a.f11762e = true;
            this.f11756a.m13842a(deVar);
            this.f11756a.m13840a();
            this.f11756a.m13851b(false);
        }

        public /* synthetic */ void m13894a(Object obj) {
            m13893a((de) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.x.4 */
    class C33734 implements C2917a {
        final /* synthetic */ C3376x f11757a;

        C33734(C3376x c3376x) {
            this.f11757a = c3376x;
        }

        public void m13895a() {
            this.f11757a.m13902c();
        }
    }

    /* renamed from: com.google.android.gms.b.x.5 */
    class C33745 implements C2915c<de> {
        final /* synthetic */ JSONObject f11758a;
        final /* synthetic */ C3376x f11759b;

        C33745(C3376x c3376x, JSONObject jSONObject) {
            this.f11759b = c3376x;
            this.f11758a = jSONObject;
        }

        public void m13896a(de deVar) {
            deVar.m12204a("AFMA_updateActiveView", this.f11758a);
        }

        public /* synthetic */ void m13897a(Object obj) {
            m13896a((de) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.x.6 */
    class C33756 implements C2915c<de> {
        final /* synthetic */ C3376x f11760a;

        C33756(C3376x c3376x) {
            this.f11760a = c3376x;
        }

        public void m13898a(de deVar) {
            this.f11760a.m13849b(deVar);
        }

        public /* synthetic */ void m13899a(Object obj) {
            m13898a((de) obj);
        }
    }

    public C3376x(Context context, AdSizeParcel adSizeParcel, gx gxVar, VersionInfoParcel versionInfoParcel, C3359y c3359y, dd ddVar) {
        super(context, adSizeParcel, gxVar, versionInfoParcel, c3359y);
        this.f11761d = ddVar.m12279b();
        try {
            this.f11761d.m12251a(new C33701(this, m13839a(c3359y.m13825c().m13823a())), new C33712(this));
        } catch (JSONException e) {
        } catch (Throwable e2) {
            C2972b.m11580b("Failure while processing active view data.", e2);
        }
        this.f11761d.m12251a(new C33723(this), new C33734(this));
        C2972b.m11576a("Tracking ad unit: " + this.b.m13869d());
    }

    protected void m13901b(JSONObject jSONObject) {
        this.f11761d.m12251a(new C33745(this, jSONObject), new C3280b());
    }

    protected void m13902c() {
        synchronized (this.a) {
            super.m13852c();
            this.f11761d.m12251a(new C33756(this), new C3280b());
            this.f11761d.m12256a();
        }
    }

    protected boolean m13903j() {
        return this.f11762e;
    }
}
