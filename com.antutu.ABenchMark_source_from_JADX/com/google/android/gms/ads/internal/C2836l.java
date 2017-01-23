package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.cf;
import com.google.android.gms.p146b.cj;
import com.google.android.gms.p146b.cj.C2835a;
import com.google.android.gms.p146b.de;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.ii;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;

@gb
/* renamed from: com.google.android.gms.ads.internal.l */
public class C2836l extends C2794d implements cf, C2835a {
    protected transient boolean f9616l;
    private boolean f9617m;
    private float f9618n;
    private String f9619o;

    @gb
    /* renamed from: com.google.android.gms.ads.internal.l.a */
    private class C2832a extends he {
        final /* synthetic */ C2836l f9609a;
        private final String f9610b;

        public C2832a(C2836l c2836l, String str) {
            this.f9609a = c2836l;
            this.f9610b = str;
        }

        public void m10976a() {
            C2968s.m11525e().m13060c(this.f9609a.f.f10056c, this.f9610b);
        }

        public void m10977b() {
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.l.b */
    private class C2834b extends he {
        final /* synthetic */ C2836l f9613a;
        private final Bitmap f9614b;
        private final String f9615c;

        /* renamed from: com.google.android.gms.ads.internal.l.b.1 */
        class C28331 implements Runnable {
            final /* synthetic */ AdOverlayInfoParcel f9611a;
            final /* synthetic */ C2834b f9612b;

            C28331(C2834b c2834b, AdOverlayInfoParcel adOverlayInfoParcel) {
                this.f9612b = c2834b;
                this.f9611a = adOverlayInfoParcel;
            }

            public void run() {
                C2968s.m11523c().m11122a(this.f9612b.f9613a.f.f10056c, this.f9611a);
            }
        }

        public C2834b(C2836l c2836l, Bitmap bitmap, String str) {
            this.f9613a = c2836l;
            this.f9614b = bitmap;
            this.f9615c = str;
        }

        public void m10978a() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f9613a.f.f10045F, this.f9613a.m10987C(), this.f9613a.f.f10045F ? C2968s.m11525e().m13044a(this.f9613a.f.f10056c, this.f9614b, this.f9615c) : false ? this.f9615c : null, this.f9613a.f9617m, this.f9613a.f9618n);
            int q = this.f9613a.f.f10063j.f11179b.m13254q();
            if (q == -1) {
                q = this.f9613a.f.f10063j.f11184g;
            }
            hj.f11297a.post(new C28331(this, new AdOverlayInfoParcel(this.f9613a, this.f9613a, this.f9613a, this.f9613a.f.f10063j.f11179b, q, this.f9613a.f.f10058e, this.f9613a.f.f10063j.f11174A, interstitialAdParameterParcel)));
        }

        public void m10979b() {
        }
    }

    public C2836l(Context context, AdSizeParcel adSizeParcel, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        super(context, adSizeParcel, str, duVar, versionInfoParcel, c2795e);
        this.f9616l = false;
        this.f9619o = "background" + hashCode() + "." + "png";
    }

    private void m10984a(Bundle bundle) {
        C2968s.m11525e().m13055b(this.f.f10056c, this.f.f10058e.f10081b, "gmob-apps", bundle, false);
    }

    protected boolean m10987C() {
        if (!(this.f.f10056c instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.f.f10056c).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void m10988D() {
        new C2832a(this, this.f9619o).m10975g();
        if (this.f.m11553e()) {
            this.f.m11550b();
            this.f.f10063j = null;
            this.f.f10045F = false;
            this.f9616l = false;
        }
    }

    public void m10989E() {
        if (!(this.f.f10063j == null || this.f.f10063j.f11200w == null)) {
            C2968s.m11525e().m13037a(this.f.f10056c, this.f.f10058e.f10081b, this.f.f10063j.f11200w);
        }
        m10464r();
    }

    protected ii m10990a(C3232a c3232a, C2798f c2798f) {
        ii a = C2968s.m11526f().m13300a(this.f.f10056c, this.f.f10062i, false, false, this.f.f10057d, this.f.f10058e, this.a, this.i);
        a.m13249l().m13281a(this, null, this, this, ((Boolean) aq.f10282V.m11794c()).booleanValue(), this, this, c2798f, null);
        m10766a((de) a);
        a.m13236b(c3232a.f11166a.f9873w);
        cj.m12063a(a, (C2835a) this);
        return a;
    }

    public void m10991a(boolean z, float f) {
        this.f9617m = z;
        this.f9618n = f;
    }

    public boolean m10992a(AdRequestParcel adRequestParcel, az azVar) {
        if (this.f.f10063j == null) {
            return super.m10480a(adRequestParcel, azVar);
        }
        C2972b.m11583d("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean m10993a(AdRequestParcel adRequestParcel, gx gxVar, boolean z) {
        if (this.f.m11553e() && gxVar.f11179b != null) {
            C2968s.m11527g().m13088a(gxVar.f11179b);
        }
        return this.e.m11297d();
    }

    public boolean m10994a(gx gxVar, gx gxVar2) {
        if (!super.m10768a(gxVar, gxVar2)) {
            return false;
        }
        if (!(this.f.m11553e() || this.f.f10042C == null || gxVar2.f11187j == null)) {
            this.h.m13874a(this.f.f10062i, gxVar2, this.f.f10042C);
        }
        return true;
    }

    public void m10995b(RewardItemParcel rewardItemParcel) {
        if (this.f.f10063j != null) {
            if (this.f.f10063j.f11201x != null) {
                C2968s.m11525e().m13037a(this.f.f10056c, this.f.f10058e.f10081b, this.f.f10063j.f11201x);
            }
            if (this.f.f10063j.f11199v != null) {
                rewardItemParcel = this.f.f10063j.f11199v;
            }
        }
        m10432a(rewardItemParcel);
    }

    public void m10996b(boolean z) {
        this.f.f10045F = z;
    }

    public void m10997f() {
        C3512u.m14587b("showInterstitial must be called on the main UI thread.");
        if (this.f.f10063j == null) {
            C2972b.m11583d("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) aq.an.m11794c()).booleanValue()) {
            Bundle bundle;
            String packageName = this.f.f10056c.getApplicationContext() != null ? this.f.f10056c.getApplicationContext().getPackageName() : this.f.f10056c.getPackageName();
            if (!this.f9616l) {
                C2972b.m11583d("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString(ACTD.APPID_KEY, packageName);
                bundle.putString(PushConsts.CMD_ACTION, "show_interstitial_before_load_finish");
                m10984a(bundle);
            }
            if (!C2968s.m11525e().m13070g(this.f.f10056c)) {
                C2972b.m11583d("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString(ACTD.APPID_KEY, packageName);
                bundle.putString(PushConsts.CMD_ACTION, "show_interstitial_app_not_in_foreground");
                m10984a(bundle);
            }
        }
        if (!this.f.m11554f()) {
            if (this.f.f10063j.f11190m) {
                try {
                    this.f.f10063j.f11192o.m12376b();
                } catch (Throwable e) {
                    C2972b.m11584d("Could not show interstitial.", e);
                    m10988D();
                }
            } else if (this.f.f10063j.f11179b == null) {
                C2972b.m11583d("The interstitial failed to load.");
            } else if (this.f.f10063j.f11179b.m13253p()) {
                C2972b.m11583d("The interstitial is already showing.");
            } else {
                this.f.f10063j.f11179b.m13232a(true);
                if (this.f.f10063j.f11187j != null) {
                    this.h.m13873a(this.f.f10062i, this.f.f10063j);
                }
                Bitmap h = this.f.f10045F ? C2968s.m11525e().m13071h(this.f.f10056c) : null;
                if (!((Boolean) aq.aE.m11794c()).booleanValue() || h == null) {
                    InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f.f10045F, m10987C(), null, false, 0.0f);
                    int q = this.f.f10063j.f11179b.m13254q();
                    if (q == -1) {
                        q = this.f.f10063j.f11184g;
                    }
                    C2968s.m11523c().m11122a(this.f.f10056c, new AdOverlayInfoParcel(this, this, this, this.f.f10063j.f11179b, q, this.f.f10058e, this.f.f10063j.f11174A, interstitialAdParameterParcel));
                    return;
                }
                new C2834b(this, h, this.f9619o).m10975g();
            }
        }
    }

    public void h_() {
        m10497y();
        super.h_();
    }

    protected void m10998n() {
        m10988D();
        super.m10460n();
    }

    protected void m10999q() {
        super.m10463q();
        this.f9616l = true;
    }
}
