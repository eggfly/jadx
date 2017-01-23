package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.client.C2769y;
import com.google.android.gms.ads.internal.client.C2772z;
import com.google.android.gms.ads.internal.client.C2777o;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.ad.C2729a;
import com.google.android.gms.ads.internal.client.af;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.overlay.C2730p;
import com.google.android.gms.ads.internal.request.C2906a.C2731a;
import com.google.android.gms.ads.internal.reward.client.C2956c;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.C3367t;
import com.google.android.gms.p146b.C3377z;
import com.google.android.gms.p146b.ac;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.aw;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.bx;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gr;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.gy;
import com.google.android.gms.p146b.hb;
import com.google.android.gms.p146b.hc;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashSet;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.ads.internal.b */
public abstract class C2733b extends C2729a implements C2646a, C2730p, C2731a, bx, C2732a, hb {
    protected az f9293a;
    protected aw f9294b;
    protected aw f9295c;
    protected boolean f9296d;
    protected final C2903r f9297e;
    protected final C2970t f9298f;
    protected transient AdRequestParcel f9299g;
    protected final C3367t f9300h;
    protected final C2795e f9301i;

    C2733b(C2970t c2970t, C2903r c2903r, C2795e c2795e) {
        this.f9296d = false;
        this.f9298f = c2970t;
        if (c2903r == null) {
            c2903r = new C2903r(this);
        }
        this.f9297e = c2903r;
        this.f9301i = c2795e;
        C2968s.m11525e().m13056b(this.f9298f.f10056c);
        C2968s.m11528h().m12935a(this.f9298f.f10056c, this.f9298f.f10058e);
        this.f9300h = C2968s.m11528h().m12954k();
    }

    private AdRequestParcel m10421d(AdRequestParcel adRequestParcel) {
        return (!C3465h.m14301f(this.f9298f.f10056c) || adRequestParcel.f9317k == null) ? adRequestParcel : new C2777o(adRequestParcel).m10722a(null).m10721a();
    }

    Bundle m10422a(ac acVar) {
        Bundle bundle = null;
        if (acVar != null) {
            String b;
            String c;
            if (acVar.m11751f()) {
                acVar.m11749d();
            }
            C3377z c2 = acVar.m11748c();
            if (c2 != null) {
                b = c2.m13910b();
                c = c2.m13912c();
                C2972b.m11576a("In AdManager: loadAd, " + c2.toString());
                if (b != null) {
                    C2968s.m11528h().m12934a(b);
                }
            } else {
                b = C2968s.m11528h().m12952i();
                c = null;
            }
            if (b != null) {
                bundle = new Bundle(1);
                bundle.putString("fingerprint", b);
                if (!b.equals(c)) {
                    bundle.putString("v_fp", c);
                }
            }
        }
        return bundle;
    }

    public void m10423a() {
        if (this.f9298f.f10063j == null) {
            C2972b.m11583d("Ad state was null when trying to ping click URLs.");
            return;
        }
        C2972b.m11576a("Pinging click URLs.");
        this.f9298f.f10065l.m12923b();
        if (this.f9298f.f10063j.f11180c != null) {
            C2968s.m11525e().m13037a(this.f9298f.f10056c, this.f9298f.f10058e.f10081b, this.f9298f.f10063j.f11180c);
        }
        if (this.f9298f.f10066m != null) {
            try {
                this.f9298f.f10066m.m10698a();
            } catch (Throwable e) {
                C2972b.m11584d("Could not notify onAdClicked event.", e);
            }
        }
    }

    protected void m10424a(int i) {
        C2972b.m11583d("Failed to load ad: " + i);
        this.f9296d = false;
        if (this.f9298f.f10067n != null) {
            try {
                this.f9298f.f10067n.m10702a(i);
            } catch (Throwable e) {
                C2972b.m11584d("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11458a(i);
            } catch (Throwable e2) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    protected void m10425a(View view) {
        this.f9298f.f10059f.addView(view, C2968s.m11527g().m13095d());
    }

    public void m10426a(AdSizeParcel adSizeParcel) {
        C3512u.m14587b("setAdSize must be called on the main UI thread.");
        this.f9298f.f10062i = adSizeParcel;
        if (!(this.f9298f.f10063j == null || this.f9298f.f10063j.f11179b == null || this.f9298f.f10043D != 0)) {
            this.f9298f.f10063j.f11179b.m13226a(adSizeParcel);
        }
        if (this.f9298f.f10059f != null) {
            if (this.f9298f.f10059f.getChildCount() > 1) {
                this.f9298f.f10059f.removeView(this.f9298f.f10059f.getNextView());
            }
            this.f9298f.f10059f.setMinimumWidth(adSizeParcel.f9331g);
            this.f9298f.f10059f.setMinimumHeight(adSizeParcel.f9328d);
            this.f9298f.f10059f.requestLayout();
        }
    }

    public void m10427a(af afVar) {
        C3512u.m14587b("setAppEventListener must be called on the main UI thread.");
        this.f9298f.f10068o = afVar;
    }

    public void m10428a(ag agVar) {
        C3512u.m14587b("setCorrelationIdProvider must be called on the main UI thread");
        this.f9298f.f10069p = agVar;
    }

    public void m10429a(C2769y c2769y) {
        C3512u.m14587b("setAdListener must be called on the main UI thread.");
        this.f9298f.f10066m = c2769y;
    }

    public void m10430a(C2772z c2772z) {
        C3512u.m14587b("setAdListener must be called on the main UI thread.");
        this.f9298f.f10067n = c2772z;
    }

    public void m10431a(C2956c c2956c) {
        C3512u.m14587b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f9298f.f10078y = c2956c;
    }

    protected void m10432a(RewardItemParcel rewardItemParcel) {
        if (this.f9298f.f10078y != null) {
            try {
                String str = BuildConfig.FLAVOR;
                int i = 0;
                if (rewardItemParcel != null) {
                    str = rewardItemParcel.f10012b;
                    i = rewardItemParcel.f10013c;
                }
                this.f9298f.f10078y.m11459a(new gr(str, i));
            } catch (Throwable e) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void m10433a(bd bdVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void m10434a(fc fcVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void m10435a(fg fgVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void m10436a(C3232a c3232a) {
        if (!(c3232a.f11167b.f9898n == -1 || TextUtils.isEmpty(c3232a.f11167b.f9910z))) {
            long b = m10446b(c3232a.f11167b.f9910z);
            if (b != -1) {
                aw a = this.f9293a.m11850a(b + c3232a.f11167b.f9898n);
                this.f9293a.m11855a(a, "stc");
            }
        }
        this.f9293a.m11852a(c3232a.f11167b.f9910z);
        this.f9293a.m11855a(this.f9294b, "arf");
        this.f9295c = this.f9293a.m11849a();
        this.f9293a.m11853a("gqi", c3232a.f11167b.f9877A);
        this.f9298f.f10060g = null;
        this.f9298f.f10064k = c3232a;
        m10437a(c3232a, this.f9293a);
    }

    protected abstract void m10437a(C3232a c3232a, az azVar);

    public void m10438a(String str) {
        C3512u.m14587b("setUserId must be called on the main UI thread.");
        this.f9298f.m11547a(str);
    }

    public void m10439a(String str, String str2) {
        if (this.f9298f.f10068o != null) {
            try {
                this.f9298f.f10068o.m10556a(str, str2);
            } catch (Throwable e) {
                C2972b.m11584d("Could not call the AppEventListener.", e);
            }
        }
    }

    public void m10440a(HashSet<gy> hashSet) {
        this.f9298f.m11548a((HashSet) hashSet);
    }

    public void m10441a(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public boolean m10442a(AdRequestParcel adRequestParcel) {
        C3512u.m14587b("loadAd must be called on the main UI thread.");
        AdRequestParcel d = m10421d(adRequestParcel);
        if (this.f9298f.f10060g == null && this.f9298f.f10061h == null) {
            C2972b.m11581c("Starting ad request.");
            m10459m();
            this.f9294b = this.f9293a.m11849a();
            if (!d.f9312f) {
                C2972b.m11581c("Use AdRequest.Builder.addTestDevice(\"" + C2784w.m10741a().m11562a(this.f9298f.f10056c) + "\") to get test ads on this device.");
            }
            this.f9296d = m10443a(d, this.f9293a);
            return this.f9296d;
        }
        if (this.f9299g != null) {
            C2972b.m11583d("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            C2972b.m11583d("Loading already in progress, saving this object for future refreshes.");
        }
        this.f9299g = d;
        return false;
    }

    protected abstract boolean m10443a(AdRequestParcel adRequestParcel, az azVar);

    boolean m10444a(gx gxVar) {
        return false;
    }

    protected abstract boolean m10445a(gx gxVar, gx gxVar2);

    long m10446b(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            C2972b.m11583d("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            C2972b.m11583d("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }

    public void m10447b() {
        C3512u.m14587b("destroy must be called on the main UI thread.");
        this.f9297e.m11292a();
        this.f9300h.m13881c(this.f9298f.f10063j);
        this.f9298f.m11558j();
    }

    public void m10448b(gx gxVar) {
        this.f9293a.m11855a(this.f9295c, "awr");
        this.f9298f.f10061h = null;
        if (!(gxVar.f11181d == -2 || gxVar.f11181d == 3)) {
            C2968s.m11528h().m12942a(this.f9298f.m11546a());
        }
        if (gxVar.f11181d == -1) {
            this.f9296d = false;
            return;
        }
        if (m10444a(gxVar)) {
            C2972b.m11576a("Ad refresh scheduled.");
        }
        if (gxVar.f11181d != -2) {
            m10424a(gxVar.f11181d);
            return;
        }
        if (this.f9298f.f10041B == null) {
            this.f9298f.f10041B = new hc(this.f9298f.f10055b);
        }
        this.f9300h.m13880b(this.f9298f.f10063j);
        if (m10445a(this.f9298f.f10063j, gxVar)) {
            this.f9298f.f10063j = gxVar;
            this.f9298f.m11557i();
            this.f9293a.m11853a("is_mraid", this.f9298f.f10063j.m12914a() ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            this.f9293a.m11853a("is_mediation", this.f9298f.f10063j.f11190m ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            if (!(this.f9298f.f10063j.f11179b == null || this.f9298f.f10063j.f11179b.m13249l() == null)) {
                this.f9293a.m11853a("is_video", this.f9298f.f10063j.f11179b.m13249l().m13294c() ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            }
            this.f9293a.m11855a(this.f9294b, "ttc");
            if (C2968s.m11528h().m12948e() != null) {
                C2968s.m11528h().m12948e().m11829a(this.f9293a);
            }
            if (this.f9298f.m11553e()) {
                m10463q();
            }
        }
    }

    protected boolean m10449b(AdRequestParcel adRequestParcel) {
        ViewParent parent = this.f9298f.f10059f.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && C2968s.m11525e().m13042a();
    }

    public void m10450c(AdRequestParcel adRequestParcel) {
        if (m10449b(adRequestParcel)) {
            m10442a(adRequestParcel);
            return;
        }
        C2972b.m11581c("Ad is not visible. Not refreshing ad.");
        this.f9297e.m11293a(adRequestParcel);
    }

    protected void m10451c(gx gxVar) {
        if (gxVar == null) {
            C2972b.m11583d("Ad state was null when trying to ping impression URLs.");
            return;
        }
        C2972b.m11576a("Pinging Impression URLs.");
        this.f9298f.f10065l.m12919a();
        if (gxVar.f11182e != null && !gxVar.f11176C) {
            C2968s.m11525e().m13037a(this.f9298f.f10056c, this.f9298f.f10058e.f10081b, gxVar.f11182e);
            gxVar.f11176C = true;
        }
    }

    public boolean m10452c() {
        C3512u.m14587b("isLoaded must be called on the main UI thread.");
        return this.f9298f.f10060g == null && this.f9298f.f10061h == null && this.f9298f.f10063j != null;
    }

    public void m10453d() {
        C3512u.m14587b("pause must be called on the main UI thread.");
    }

    public void m10454e() {
        C3512u.m14587b("resume must be called on the main UI thread.");
    }

    public C2687a f_() {
        C3512u.m14587b("getAdFrame must be called on the main UI thread.");
        return C2690b.m10262a(this.f9298f.f10059f);
    }

    public void m10455h() {
        C3512u.m14587b("recordManualImpression must be called on the main UI thread.");
        if (this.f9298f.f10063j == null) {
            C2972b.m11583d("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        C2972b.m11576a("Pinging manual tracking URLs.");
        if (this.f9298f.f10063j.f11183f != null && !this.f9298f.f10063j.f11177D) {
            C2968s.m11525e().m13037a(this.f9298f.f10056c, this.f9298f.f10058e.f10081b, this.f9298f.f10063j.f11183f);
            this.f9298f.f10063j.f11177D = true;
        }
    }

    public AdSizeParcel m10456i() {
        C3512u.m14587b("getAdSize must be called on the main UI thread.");
        return this.f9298f.f10062i == null ? null : new ThinAdSizeParcel(this.f9298f.f10062i);
    }

    public void j_() {
        C3512u.m14587b("stopLoading must be called on the main UI thread.");
        this.f9296d = false;
        this.f9298f.m11549a(true);
    }

    public boolean m10457k() {
        return this.f9296d;
    }

    public void m10458l() {
        m10461o();
    }

    void m10459m() {
        this.f9293a = new az(((Boolean) aq.f10267G.m11794c()).booleanValue(), "load_ad", this.f9298f.f10062i.f9326b);
        this.f9294b = new aw(-1, null, null);
        this.f9295c = new aw(-1, null, null);
    }

    protected void m10460n() {
        C2972b.m11581c("Ad closing.");
        if (this.f9298f.f10067n != null) {
            try {
                this.f9298f.f10067n.m10701a();
            } catch (Throwable e) {
                C2972b.m11584d("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11462d();
            } catch (Throwable e2) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void m10461o() {
        C2972b.m11581c("Ad leaving application.");
        if (this.f9298f.f10067n != null) {
            try {
                this.f9298f.f10067n.m10703b();
            } catch (Throwable e) {
                C2972b.m11584d("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11463e();
            } catch (Throwable e2) {
                C2972b.m11584d("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void m10462p() {
        C2972b.m11581c("Ad opening.");
        if (this.f9298f.f10067n != null) {
            try {
                this.f9298f.f10067n.m10705d();
            } catch (Throwable e) {
                C2972b.m11584d("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11460b();
            } catch (Throwable e2) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void m10463q() {
        C2972b.m11581c("Ad finished loading.");
        this.f9296d = false;
        if (this.f9298f.f10067n != null) {
            try {
                this.f9298f.f10067n.m10704c();
            } catch (Throwable e) {
                C2972b.m11584d("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11457a();
            } catch (Throwable e2) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void m10464r() {
        if (this.f9298f.f10078y != null) {
            try {
                this.f9298f.f10078y.m11461c();
            } catch (Throwable e) {
                C2972b.m11584d("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }
}
