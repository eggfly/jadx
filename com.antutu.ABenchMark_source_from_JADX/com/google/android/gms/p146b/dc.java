package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2798f;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.overlay.C2730p;
import com.google.android.gms.ads.internal.overlay.C2735g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.da.C3110a;
import com.google.android.gms.p146b.ij.C2813a;
import com.umeng.message.util.HttpRequest;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.dc */
public class dc implements da {
    private final ii f10583a;

    /* renamed from: com.google.android.gms.b.dc.1 */
    class C31141 implements Runnable {
        final /* synthetic */ String f10569a;
        final /* synthetic */ JSONObject f10570b;
        final /* synthetic */ dc f10571c;

        C31141(dc dcVar, String str, JSONObject jSONObject) {
            this.f10571c = dcVar;
            this.f10569a = str;
            this.f10570b = jSONObject;
        }

        public void run() {
            this.f10571c.f10583a.m13231a(this.f10569a, this.f10570b);
        }
    }

    /* renamed from: com.google.android.gms.b.dc.2 */
    class C31152 implements Runnable {
        final /* synthetic */ String f10572a;
        final /* synthetic */ String f10573b;
        final /* synthetic */ dc f10574c;

        C31152(dc dcVar, String str, String str2) {
            this.f10574c = dcVar;
            this.f10572a = str;
            this.f10573b = str2;
        }

        public void run() {
            this.f10574c.f10583a.m13229a(this.f10572a, this.f10573b);
        }
    }

    /* renamed from: com.google.android.gms.b.dc.3 */
    class C31163 implements Runnable {
        final /* synthetic */ String f10575a;
        final /* synthetic */ dc f10576b;

        C31163(dc dcVar, String str) {
            this.f10576b = dcVar;
            this.f10575a = str;
        }

        public void run() {
            this.f10576b.f10583a.loadData(this.f10575a, "text/html", HttpRequest.f14548a);
        }
    }

    /* renamed from: com.google.android.gms.b.dc.4 */
    class C31174 implements Runnable {
        final /* synthetic */ String f10577a;
        final /* synthetic */ dc f10578b;

        C31174(dc dcVar, String str) {
            this.f10578b = dcVar;
            this.f10577a = str;
        }

        public void run() {
            this.f10578b.f10583a.loadData(this.f10577a, "text/html", HttpRequest.f14548a);
        }
    }

    /* renamed from: com.google.android.gms.b.dc.5 */
    class C31185 implements Runnable {
        final /* synthetic */ String f10579a;
        final /* synthetic */ dc f10580b;

        C31185(dc dcVar, String str) {
            this.f10580b = dcVar;
            this.f10579a = str;
        }

        public void run() {
            this.f10580b.f10583a.loadUrl(this.f10579a);
        }
    }

    /* renamed from: com.google.android.gms.b.dc.6 */
    class C31196 implements C2813a {
        final /* synthetic */ C3110a f10581a;
        final /* synthetic */ dc f10582b;

        C31196(dc dcVar, C3110a c3110a) {
            this.f10582b = dcVar;
            this.f10581a = c3110a;
        }

        public void m12222a(ii iiVar, boolean z) {
            this.f10581a.m12201a();
        }
    }

    public dc(Context context, VersionInfoParcel versionInfoParcel, C3326k c3326k) {
        this.f10583a = C2968s.m11526f().m13299a(context, new AdSizeParcel(), false, false, c3326k, versionInfoParcel);
        this.f10583a.m13222a().setWillNotDraw(true);
    }

    private void m12224a(Runnable runnable) {
        if (C2784w.m10741a().m11571b()) {
            runnable.run();
        } else {
            hj.f11297a.post(runnable);
        }
    }

    public void m12225a() {
        this.f10583a.destroy();
    }

    public void m12226a(C2646a c2646a, C2735g c2735g, bx bxVar, C2730p c2730p, boolean z, cd cdVar, cf cfVar, C2798f c2798f, er erVar) {
        this.f10583a.m13249l().m13281a(c2646a, c2735g, bxVar, c2730p, z, cdVar, cfVar, new C2798f(false), erVar);
    }

    public void m12227a(C3110a c3110a) {
        this.f10583a.m13249l().m13285a(new C31196(this, c3110a));
    }

    public void m12228a(String str) {
        m12224a(new C31163(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void m12229a(String str, cb cbVar) {
        this.f10583a.m13249l().m13287a(str, cbVar);
    }

    public void m12230a(String str, String str2) {
        m12224a(new C31152(this, str, str2));
    }

    public void m12231a(String str, JSONObject jSONObject) {
        m12224a(new C31141(this, str, jSONObject));
    }

    public df m12232b() {
        return new dg(this);
    }

    public void m12233b(String str) {
        m12224a(new C31185(this, str));
    }

    public void m12234b(String str, cb cbVar) {
        this.f10583a.m13249l().m13292b(str, cbVar);
    }

    public void m12235b(String str, JSONObject jSONObject) {
        this.f10583a.m12206b(str, jSONObject);
    }

    public void m12236c(String str) {
        m12224a(new C31174(this, str));
    }
}
