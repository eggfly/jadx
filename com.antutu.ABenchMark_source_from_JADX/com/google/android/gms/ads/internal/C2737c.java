package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.overlay.C2735g;
import com.google.android.gms.ads.internal.purchase.C2736j;
import com.google.android.gms.ads.internal.purchase.C2882c;
import com.google.android.gms.ads.internal.purchase.C2884d;
import com.google.android.gms.ads.internal.purchase.C2887f;
import com.google.android.gms.ads.internal.purchase.C2889g;
import com.google.android.gms.ads.internal.purchase.C2894k;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C2904a;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.cd;
import com.google.android.gms.p146b.dm;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.ez;
import com.google.android.gms.p146b.fb;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gy;
import com.google.android.gms.p146b.hj;
import com.umeng.message.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.android.agoo.common.C4575b;

@gb
/* renamed from: com.google.android.gms.ads.internal.c */
public abstract class C2737c extends C2733b implements C2735g, C2736j, cd, dm {
    protected final du f9304j;
    protected transient boolean f9305k;
    private final Messenger f9306l;

    /* renamed from: com.google.android.gms.ads.internal.c.1 */
    class C27341 implements Runnable {
        final /* synthetic */ Intent f9302a;
        final /* synthetic */ C2737c f9303b;

        C27341(C2737c c2737c, Intent intent) {
            this.f9303b = c2737c;
            this.f9302a = intent;
        }

        public void run() {
            int a = C2968s.m11535o().m11253a(this.f9302a);
            C2968s.m11535o();
            if (!(a != 0 || this.f9303b.f.f10063j == null || this.f9303b.f.f10063j.f11179b == null || this.f9303b.f.f10063j.f11179b.m13246i() == null)) {
                this.f9303b.f.f10063j.f11179b.m13246i().m11097a();
            }
            this.f9303b.f.f10044E = false;
        }
    }

    public C2737c(Context context, AdSizeParcel adSizeParcel, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        this(new C2970t(context, adSizeParcel, str, versionInfoParcel), duVar, null, c2795e);
    }

    C2737c(C2970t c2970t, du duVar, C2903r c2903r, C2795e c2795e) {
        super(c2970t, c2903r, c2795e);
        this.f9304j = duVar;
        this.f9306l = new Messenger(new ez(this.f.f10056c));
        this.f9305k = false;
    }

    private C2904a m10473a(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        int i;
        ApplicationInfo applicationInfo = this.f.f10056c.getApplicationInfo();
        try {
            packageInfo = this.f.f10056c.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.f.f10056c.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.f.f10059f == null || this.f.f10059f.getParent() == null)) {
            int[] iArr = new int[2];
            this.f.f10059f.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.f.f10059f.getWidth();
            int height = this.f.f10059f.getHeight();
            i = 0;
            if (this.f.f10059f.isShown() && i2 + width > 0 && i3 + height > 0 && i2 <= displayMetrics.widthPixels && i3 <= displayMetrics.heightPixels) {
                i = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i3);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i);
        }
        String c = C2968s.m11528h().m12946c();
        this.f.f10065l = new gy(c, this.f.f10055b);
        this.f.f10065l.m12921a(adRequestParcel);
        String a = C2968s.m11525e().m13022a(this.f.f10056c, this.f.f10059f, this.f.f10062i);
        long j = 0;
        if (this.f.f10069p != null) {
            try {
                j = this.f.f10069p.m10559a();
            } catch (RemoteException e2) {
                C2972b.m11583d("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle a2 = C2968s.m11528h().m12929a(this.f.f10056c, this, c);
        List arrayList = new ArrayList();
        for (i = 0; i < this.f.f10075v.size(); i++) {
            arrayList.add(this.f.f10075v.keyAt(i));
        }
        boolean z = this.f.f10070q != null;
        boolean z2 = this.f.f10071r != null && C2968s.m11528h().m12956m();
        return new C2904a(bundle2, adRequestParcel, this.f.f10062i, this.f.f10055b, applicationInfo, packageInfo, c, C2968s.m11528h().m12931a(), this.f.f10058e, a2, this.f.f10079z, arrayList, bundle, C2968s.m11528h().m12950g(), this.f9306l, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, a, j, uuid, aq.m11813a(), this.f.f10054a, this.f.f10076w, new CapabilityParcel(z, z2, this.i.f9479c.m11169a()), this.f.m11556h(), C2968s.m11525e().m13068f(), C2968s.m11525e().m13073j(this.f.f10056c), C2968s.m11525e().m13050b(this.f.f10059f));
    }

    public void m10474a() {
        if (this.f.f10063j == null) {
            C2972b.m11583d("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.f.f10063j.f11194q == null || this.f.f10063j.f11194q.f10652c == null)) {
            C2968s.m11538r().m12343a(this.f.f10056c, this.f.f10058e.f10081b, this.f.f10063j, this.f.f10055b, false, this.f.f10063j.f11194q.f10652c);
        }
        if (!(this.f.f10063j.f11191n == null || this.f.f10063j.f11191n.f10640f == null)) {
            C2968s.m11538r().m12343a(this.f.f10056c, this.f.f10058e.f10081b, this.f.f10063j, this.f.f10055b, false, this.f.f10063j.f11191n.f10640f);
        }
        super.m10423a();
    }

    public void m10475a(fc fcVar) {
        C3512u.m14587b("setInAppPurchaseListener must be called on the main UI thread.");
        this.f.f10070q = fcVar;
    }

    public void m10476a(fg fgVar, String str) {
        C3512u.m14587b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f.f10040A = new C2894k(str);
        this.f.f10071r = fgVar;
        if (!C2968s.m11528h().m12949f() && fgVar != null) {
            new C2882c(this.f.f10056c, this.f.f10071r, this.f.f10040A).m10975g();
        }
    }

    protected void m10477a(gx gxVar, boolean z) {
        if (gxVar == null) {
            C2972b.m11583d("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.m10451c(gxVar);
        if (!(gxVar.f11194q == null || gxVar.f11194q.f10653d == null)) {
            C2968s.m11538r().m12343a(this.f.f10056c, this.f.f10058e.f10081b, gxVar, this.f.f10055b, z, gxVar.f11194q.f10653d);
        }
        if (gxVar.f11191n != null && gxVar.f11191n.f10641g != null) {
            C2968s.m11538r().m12343a(this.f.f10056c, this.f.f10058e.f10081b, gxVar, this.f.f10055b, z, gxVar.f11191n.f10641g);
        }
    }

    public void m10478a(String str, ArrayList<String> arrayList) {
        fb c2884d = new C2884d(str, arrayList, this.f.f10056c, this.f.f10058e.f10081b);
        if (this.f.f10070q == null) {
            C2972b.m11583d("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!C2784w.m10741a().m11572b(this.f.f10056c)) {
                C2972b.m11583d("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.f.f10071r == null) {
                C2972b.m11583d("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.f.f10040A == null) {
                C2972b.m11583d("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.f.f10044E) {
                C2972b.m11583d("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.f.f10044E = true;
                try {
                    if (this.f.f10071r.m12697a(str)) {
                        C2968s.m11535o().m11257a(this.f.f10056c, this.f.f10058e.f10084e, new GInAppPurchaseManagerInfoParcel(this.f.f10056c, this.f.f10040A, c2884d, this));
                        return;
                    } else {
                        this.f.f10044E = false;
                        return;
                    }
                } catch (RemoteException e) {
                    C2972b.m11583d("Could not start In-App purchase.");
                    this.f.f10044E = false;
                    return;
                }
            }
        }
        try {
            this.f.f10070q.m12112a(c2884d);
        } catch (RemoteException e2) {
            C2972b.m11583d("Could not start In-App purchase.");
        }
    }

    public void m10479a(String str, boolean z, int i, Intent intent, C2887f c2887f) {
        try {
            if (this.f.f10071r != null) {
                this.f.f10071r.m12696a(new C2889g(this.f.f10056c, str, z, i, intent, c2887f));
            }
        } catch (RemoteException e) {
            C2972b.m11583d("Fail to invoke PlayStorePurchaseListener.");
        }
        hj.f11297a.postDelayed(new C27341(this, intent), 500);
    }

    public boolean m10480a(AdRequestParcel adRequestParcel, az azVar) {
        if (!m10491s()) {
            return false;
        }
        Bundle a = m10422a(C2968s.m11528h().m12930a(this.f.f10056c));
        this.e.m11292a();
        this.f.f10043D = 0;
        C2904a a2 = m10473a(adRequestParcel, a);
        azVar.m11853a("seq_num", a2.f9824g);
        azVar.m11853a("request_id", a2.f9839v);
        azVar.m11853a("session_id", a2.f9825h);
        if (a2.f9823f != null) {
            azVar.m11853a(C4575b.PROPERTY_APP_VERSION, String.valueOf(a2.f9823f.versionCode));
        }
        this.f.f10060g = C2968s.m11520a().m11302a(this.f.f10056c, a2, this.f.f10057d, this);
        return true;
    }

    protected boolean m10481a(AdRequestParcel adRequestParcel, gx gxVar, boolean z) {
        if (!z && this.f.m11553e()) {
            if (gxVar.f11185h > 0) {
                this.e.m11294a(adRequestParcel, gxVar.f11185h);
            } else if (gxVar.f11194q != null && gxVar.f11194q.f10656g > 0) {
                this.e.m11294a(adRequestParcel, gxVar.f11194q.f10656g);
            } else if (!gxVar.f11190m && gxVar.f11181d == 2) {
                this.e.m11293a(adRequestParcel);
            }
        }
        return this.e.m11297d();
    }

    boolean m10482a(gx gxVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.g != null) {
            adRequestParcel = this.g;
            this.g = null;
        } else {
            adRequestParcel = gxVar.f11178a;
            if (adRequestParcel.f9309c != null) {
                z = adRequestParcel.f9309c.getBoolean("_noRefresh", false);
            }
        }
        return m10481a(adRequestParcel, gxVar, z);
    }

    protected boolean m10483a(gx gxVar, gx gxVar2) {
        int i;
        int i2 = 0;
        if (!(gxVar == null || gxVar.f11195r == null)) {
            gxVar.f11195r.m12304a(null);
        }
        if (gxVar2.f11195r != null) {
            gxVar2.f11195r.m12304a((dm) this);
        }
        if (gxVar2.f11194q != null) {
            i = gxVar2.f11194q.f10661l;
            i2 = gxVar2.f11194q.f10662m;
        } else {
            i = 0;
        }
        this.f.f10041B.m12976a(i, i2);
        return true;
    }

    public void m10484b(gx gxVar) {
        super.m10448b(gxVar);
        if (gxVar.f11181d == 3 && gxVar.f11194q != null && gxVar.f11194q.f10654e != null) {
            C2972b.m11576a("Pinging no fill URLs.");
            C2968s.m11538r().m12343a(this.f.f10056c, this.f.f10058e.f10081b, gxVar, this.f.f10055b, false, gxVar.f11194q.f10654e);
        }
    }

    protected boolean m10485b(AdRequestParcel adRequestParcel) {
        return super.m10449b(adRequestParcel) && !this.f9305k;
    }

    public void m10486d() {
        C3512u.m14587b("pause must be called on the main UI thread.");
        if (!(this.f.f10063j == null || this.f.f10063j.f11179b == null || !this.f.m11553e())) {
            C2968s.m11527g().m13088a(this.f.f10063j.f11179b);
        }
        if (!(this.f.f10063j == null || this.f.f10063j.f11192o == null)) {
            try {
                this.f.f10063j.f11192o.m12378d();
            } catch (RemoteException e) {
                C2972b.m11583d("Could not pause mediation adapter.");
            }
        }
        this.h.m13882d(this.f.f10063j);
        this.e.m11295b();
    }

    public void m10487e() {
        C3512u.m14587b("resume must be called on the main UI thread.");
        if (!(this.f.f10063j == null || this.f.f10063j.f11179b == null || !this.f.m11553e())) {
            C2968s.m11527g().m13091b(this.f.f10063j.f11179b);
        }
        if (!(this.f.f10063j == null || this.f.f10063j.f11192o == null)) {
            try {
                this.f.f10063j.f11192o.m12379e();
            } catch (RemoteException e) {
                C2972b.m11583d("Could not resume mediation adapter.");
            }
        }
        this.e.m11296c();
        this.h.m13883e(this.f.f10063j);
    }

    public void m10488f() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void m10489g() {
        this.h.m13883e(this.f.f10063j);
    }

    public void g_() {
        this.h.m13880b(this.f.f10063j);
        this.f9305k = false;
        m10460n();
        this.f.f10065l.m12926c();
    }

    public void h_() {
        this.f9305k = true;
        m10462p();
    }

    public void i_() {
        this.h.m13882d(this.f.f10063j);
    }

    public String m10490j() {
        return this.f.f10063j == null ? null : this.f.f10063j.f11193p;
    }

    protected boolean m10491s() {
        return C2968s.m11525e().m13045a(this.f.f10056c.getPackageManager(), this.f.f10056c.getPackageName(), MsgConstant.PERMISSION_INTERNET) && C2968s.m11525e().m13043a(this.f.f10056c);
    }

    public void m10492t() {
        m10474a();
    }

    public void m10493u() {
        g_();
    }

    public void m10494v() {
        m10458l();
    }

    public void m10495w() {
        h_();
    }

    public void m10496x() {
        if (this.f.f10063j != null) {
            C2972b.m11583d("Mediation adapter " + this.f.f10063j.f11193p + " refreshed, but mediation adapters should never refresh.");
        }
        m10477a(this.f.f10063j, true);
        m10463q();
    }

    public void m10497y() {
        m10477a(this.f.f10063j, false);
    }
}
