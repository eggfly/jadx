package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.id;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.ij.C2823b;
import com.umeng.message.MsgConstant;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.g */
public class C2826g extends C2794d implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f9572l;

    /* renamed from: com.google.android.gms.ads.internal.g.1 */
    class C28241 implements C2823b {
        final /* synthetic */ gx f9569a;
        final /* synthetic */ C2826g f9570b;

        C28241(C2826g c2826g, gx gxVar) {
            this.f9570b = c2826g;
            this.f9569a = gxVar;
        }

        public void m10918a() {
            this.f9570b.h.m13873a(this.f9570b.f.f10062i, this.f9569a).m13843a(this.f9569a.f11179b);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.g.a */
    public class C2825a {
        final /* synthetic */ C2826g f9571a;

        public C2825a(C2826g c2826g) {
            this.f9571a = c2826g;
        }

        public void m10919a() {
            this.f9571a.m10474a();
        }
    }

    public C2826g(Context context, AdSizeParcel adSizeParcel, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        super(context, adSizeParcel, str, duVar, versionInfoParcel, c2795e);
    }

    private AdSizeParcel m10920b(C3232a c3232a) {
        if (c3232a.f11167b.f9878B) {
            return this.f.f10062i;
        }
        C2719d c2719d;
        String str = c3232a.f11167b.f9897m;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            c2719d = new C2719d(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            c2719d = this.f.f10062i.m10504b();
        }
        return new AdSizeParcel(this.f.f10056c, c2719d);
    }

    private boolean m10921b(gx gxVar, gx gxVar2) {
        if (gxVar2.f11190m) {
            View a = C2843n.m11008a(gxVar2);
            if (a == null) {
                C2972b.m11583d("Could not get mediation view");
                return false;
            }
            View nextView = this.f.f10059f.getNextView();
            if (nextView != null) {
                if (nextView instanceof ii) {
                    ((ii) nextView).destroy();
                }
                this.f.f10059f.removeView(nextView);
            }
            if (!C2843n.m11028b(gxVar2)) {
                try {
                    m10425a(a);
                } catch (Throwable th) {
                    C2972b.m11584d("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(gxVar2.f11197t == null || gxVar2.f11179b == null)) {
            gxVar2.f11179b.m13226a(gxVar2.f11197t);
            this.f.f10059f.removeAllViews();
            this.f.f10059f.setMinimumWidth(gxVar2.f11197t.f9331g);
            this.f.f10059f.setMinimumHeight(gxVar2.f11197t.f9328d);
            m10425a(gxVar2.f11179b.m13233b());
        }
        if (this.f.f10059f.getChildCount() > 1) {
            this.f.f10059f.showNext();
        }
        if (gxVar != null) {
            View nextView2 = this.f.f10059f.getNextView();
            if (nextView2 instanceof ii) {
                ((ii) nextView2).m13225a(this.f.f10056c, this.f.f10062i, this.a);
            } else if (nextView2 != null) {
                this.f.f10059f.removeView(nextView2);
            }
            this.f.m11552d();
        }
        this.f.f10059f.setVisibility(0);
        return true;
    }

    private void m10922e(gx gxVar) {
        if (this.f.m11553e()) {
            if (gxVar.f11179b != null) {
                if (gxVar.f11187j != null) {
                    this.h.m13873a(this.f.f10062i, gxVar);
                }
                if (gxVar.m12914a()) {
                    this.h.m13873a(this.f.f10062i, gxVar).m13843a(gxVar.f11179b);
                } else {
                    gxVar.f11179b.m13249l().m13286a(new C28241(this, gxVar));
                }
            }
        } else if (this.f.f10042C != null && gxVar.f11187j != null) {
            this.h.m13874a(this.f.f10062i, gxVar, this.f.f10042C);
        }
    }

    protected ii m10923a(C3232a c3232a, C2798f c2798f) {
        if (this.f.f10062i.f9334j) {
            this.f.f10062i = m10920b(c3232a);
        }
        return super.m10763a(c3232a, c2798f);
    }

    protected void m10924a(gx gxVar, boolean z) {
        super.m10477a(gxVar, z);
        if (C2843n.m11028b(gxVar)) {
            C2843n.m11017a(gxVar, new C2825a(this));
        }
    }

    public void m10925a(boolean z) {
        C3512u.m14587b("setManualImpressionsEnabled must be called from the main thread.");
        this.f9572l = z;
    }

    public boolean m10926a(AdRequestParcel adRequestParcel) {
        return super.m10442a(m10928d(adRequestParcel));
    }

    public boolean m10927a(gx gxVar, gx gxVar2) {
        if (!super.m10768a(gxVar, gxVar2)) {
            return false;
        }
        if (!this.f.m11553e() || m10921b(gxVar, gxVar2)) {
            if (gxVar2.f11188k) {
                m10929d(gxVar2);
                id.m13202a(this.f.f10059f, (OnGlobalLayoutListener) this);
                id.m13203a(this.f.f10059f, (OnScrollChangedListener) this);
            } else if (!this.f.m11554f() || ((Boolean) aq.aG.m11794c()).booleanValue()) {
                m10924a(gxVar2, false);
            }
            m10922e(gxVar2);
            return true;
        }
        m10424a(0);
        return false;
    }

    AdRequestParcel m10928d(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.f9314h == this.f9572l) {
            return adRequestParcel;
        }
        int i = adRequestParcel.f9307a;
        long j = adRequestParcel.f9308b;
        Bundle bundle = adRequestParcel.f9309c;
        int i2 = adRequestParcel.f9310d;
        List list = adRequestParcel.f9311e;
        boolean z = adRequestParcel.f9312f;
        int i3 = adRequestParcel.f9313g;
        boolean z2 = adRequestParcel.f9314h || this.f9572l;
        return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, adRequestParcel.f9315i, adRequestParcel.f9316j, adRequestParcel.f9317k, adRequestParcel.f9318l, adRequestParcel.f9319m, adRequestParcel.f9320n, adRequestParcel.f9321o, adRequestParcel.f9322p, adRequestParcel.f9323q, adRequestParcel.f9324r);
    }

    void m10929d(gx gxVar) {
        if (gxVar != null && !gxVar.f11189l && this.f.f10059f != null && C2968s.m11525e().m13046a(this.f.f10059f, this.f.f10056c) && this.f.f10059f.getGlobalVisibleRect(new Rect(), null)) {
            m10924a(gxVar, false);
            gxVar.f11189l = true;
        }
    }

    public void m10930f() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public void onGlobalLayout() {
        m10929d(this.f.f10063j);
    }

    public void onScrollChanged() {
        m10929d(this.f.f10063j);
    }

    protected boolean m10931s() {
        boolean z = true;
        if (!C2968s.m11525e().m13045a(this.f.f10056c.getPackageManager(), this.f.f10056c.getPackageName(), MsgConstant.PERMISSION_INTERNET)) {
            C2784w.m10741a().m11567a(this.f.f10059f, this.f.f10062i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!C2968s.m11525e().m13043a(this.f.f10056c)) {
            C2784w.m10741a().m11567a(this.f.f10059f, this.f.f10062i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.f.f10059f == null)) {
            this.f.f10059f.setVisibility(0);
        }
        return z;
    }
}
