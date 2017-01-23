package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.C2836l;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2769y;
import com.google.android.gms.ads.internal.client.C2772z;
import com.google.android.gms.ads.internal.client.ad.C2729a;
import com.google.android.gms.ads.internal.client.af;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.reward.client.C2956c;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.cx.C3108a;
import com.google.android.gms.p151a.C2687a;

@gb
/* renamed from: com.google.android.gms.b.cy */
public class cy extends C2729a {
    private String f10546a;
    private cr f10547b;
    private C2836l f10548c;
    private ct f10549d;
    private fg f10550e;
    private String f10551f;

    public cy(Context context, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        this(str, new cr(context.getApplicationContext(), duVar, versionInfoParcel, c2795e));
    }

    public cy(String str, cr crVar) {
        this.f10546a = str;
        this.f10547b = crVar;
        this.f10549d = new ct();
        C2968s.m11536p().m12147a(crVar);
    }

    private void m12174m() {
        if (this.f10548c != null && this.f10550e != null) {
            this.f10548c.m10476a(this.f10550e, this.f10551f);
        }
    }

    public void m12175a(AdSizeParcel adSizeParcel) {
        if (this.f10548c != null) {
            this.f10548c.m10426a(adSizeParcel);
        }
    }

    public void m12176a(af afVar) {
        this.f10549d.f10518b = afVar;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12177a(ag agVar) {
        m12197l();
        if (this.f10548c != null) {
            this.f10548c.m10428a(agVar);
        }
    }

    public void m12178a(C2769y c2769y) {
        this.f10549d.f10521e = c2769y;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12179a(C2772z c2772z) {
        this.f10549d.f10517a = c2772z;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12180a(C2956c c2956c) {
        this.f10549d.f10522f = c2956c;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12181a(bd bdVar) {
        this.f10549d.f10520d = bdVar;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12182a(fc fcVar) {
        this.f10549d.f10519c = fcVar;
        if (this.f10548c != null) {
            this.f10549d.m12141a(this.f10548c);
        }
    }

    public void m12183a(fg fgVar, String str) {
        this.f10550e = fgVar;
        this.f10551f = str;
        m12174m();
    }

    public void m12184a(String str) {
    }

    public void m12185a(boolean z) {
        m12197l();
        if (this.f10548c != null) {
            this.f10548c.m10441a(z);
        }
    }

    public boolean m12186a(AdRequestParcel adRequestParcel) {
        if (m12188b(adRequestParcel)) {
            m12197l();
        }
        if (adRequestParcel.f9316j != null) {
            m12197l();
        }
        if (this.f10548c != null) {
            return this.f10548c.m10442a(adRequestParcel);
        }
        C3108a a = C2968s.m11536p().m12145a(adRequestParcel, this.f10546a);
        if (a != null) {
            if (!a.f10539e) {
                a.m12162a(adRequestParcel);
            }
            this.f10548c = a.f10535a;
            a.m12163a(this.f10547b);
            a.f10537c.m12135a(this.f10549d);
            this.f10549d.m12141a(this.f10548c);
            m12174m();
            return a.f10540f;
        }
        this.f10548c = this.f10547b.m12095a(this.f10546a);
        this.f10549d.m12141a(this.f10548c);
        m12174m();
        return this.f10548c.m10442a(adRequestParcel);
    }

    public void m12187b() {
        if (this.f10548c != null) {
            this.f10548c.m10447b();
        }
    }

    boolean m12188b(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.f9319m;
        if (bundle == null) {
            return false;
        }
        bundle = bundle.getBundle(AdMobAdapter.class.getCanonicalName());
        if (bundle == null) {
            return false;
        }
        return bundle.keySet().contains("gw");
    }

    public boolean m12189c() {
        return this.f10548c != null && this.f10548c.m10452c();
    }

    public void m12190d() {
        if (this.f10548c != null) {
            this.f10548c.m10486d();
        }
    }

    public void m12191e() {
        if (this.f10548c != null) {
            this.f10548c.m10487e();
        }
    }

    public void m12192f() {
        if (this.f10548c != null) {
            this.f10548c.m10997f();
        } else {
            C2972b.m11583d("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public C2687a f_() {
        return this.f10548c != null ? this.f10548c.f_() : null;
    }

    public void m12193h() {
        if (this.f10548c != null) {
            this.f10548c.m10455h();
        } else {
            C2972b.m11583d("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public AdSizeParcel m12194i() {
        return this.f10548c != null ? this.f10548c.m10456i() : null;
    }

    public String m12195j() {
        return this.f10548c != null ? this.f10548c.m10490j() : null;
    }

    public void j_() {
        if (this.f10548c != null) {
            this.f10548c.j_();
        }
    }

    public boolean m12196k() {
        return this.f10548c != null && this.f10548c.m10457k();
    }

    void m12197l() {
        if (this.f10548c == null) {
            this.f10548c = this.f10547b.m12095a(this.f10546a);
            this.f10549d.m12141a(this.f10548c);
            m12174m();
        }
    }
}
