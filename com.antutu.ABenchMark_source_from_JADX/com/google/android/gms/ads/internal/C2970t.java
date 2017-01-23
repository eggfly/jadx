package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2769y;
import com.google.android.gms.ads.internal.client.C2772z;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.client.af;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.C2894k;
import com.google.android.gms.ads.internal.reward.client.C2956c;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.C3326k;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.br;
import com.google.android.gms.p146b.fc;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.gy;
import com.google.android.gms.p146b.hc;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.hf;
import com.google.android.gms.p146b.hl;
import com.google.android.gms.p146b.hm;
import com.google.android.gms.p146b.hr;
import com.google.android.gms.p146b.hv;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.ij;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@gb
/* renamed from: com.google.android.gms.ads.internal.t */
public final class C2970t implements OnGlobalLayoutListener, OnScrollChangedListener {
    C2894k f10040A;
    public hc f10041B;
    View f10042C;
    public int f10043D;
    boolean f10044E;
    boolean f10045F;
    private String f10046G;
    private HashSet<gy> f10047H;
    private int f10048I;
    private int f10049J;
    private hr f10050K;
    private boolean f10051L;
    private boolean f10052M;
    private boolean f10053N;
    final String f10054a;
    public String f10055b;
    public final Context f10056c;
    final C3326k f10057d;
    public final VersionInfoParcel f10058e;
    C2969a f10059f;
    public he f10060g;
    public hl f10061h;
    public AdSizeParcel f10062i;
    public gx f10063j;
    public C3232a f10064k;
    public gy f10065l;
    C2769y f10066m;
    C2772z f10067n;
    af f10068o;
    ag f10069p;
    fc f10070q;
    fg f10071r;
    bo f10072s;
    bp f10073t;
    SimpleArrayMap<String, bq> f10074u;
    SimpleArrayMap<String, br> f10075v;
    NativeAdOptionsParcel f10076w;
    bd f10077x;
    C2956c f10078y;
    List<String> f10079z;

    /* renamed from: com.google.android.gms.ads.internal.t.a */
    public static class C2969a extends ViewSwitcher {
        private final hm f10038a;
        private final hv f10039b;

        public C2969a(Context context, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f10038a = new hm(context);
            if (context instanceof Activity) {
                this.f10039b = new hv((Activity) context, onGlobalLayoutListener, onScrollChangedListener);
                this.f10039b.m13163a();
                return;
            }
            this.f10039b = null;
        }

        public hm m11542a() {
            return this.f10038a;
        }

        public void m11543b() {
            hf.m12982e("Disable position monitoring on adFrame.");
            if (this.f10039b != null) {
                this.f10039b.m13165b();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f10039b != null) {
                this.f10039b.m13166c();
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f10039b != null) {
                this.f10039b.m13167d();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f10038a.m13125a(motionEvent);
            return false;
        }

        public void removeAllViews() {
            List<ii> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof ii)) {
                    arrayList.add((ii) childAt);
                }
            }
            super.removeAllViews();
            for (ii destroy : arrayList) {
                destroy.destroy();
            }
        }
    }

    public C2970t(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    C2970t(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, C3326k c3326k) {
        this.f10041B = null;
        this.f10042C = null;
        this.f10043D = 0;
        this.f10044E = false;
        this.f10045F = false;
        this.f10047H = null;
        this.f10048I = -1;
        this.f10049J = -1;
        this.f10051L = true;
        this.f10052M = true;
        this.f10053N = false;
        aq.m11814a(context);
        if (C2968s.m11528h().m12948e() != null) {
            List b = aq.m11815b();
            if (versionInfoParcel.f10082c != 0) {
                b.add(Integer.toString(versionInfoParcel.f10082c));
            }
            C2968s.m11528h().m12948e().m11828a(b);
        }
        this.f10054a = UUID.randomUUID().toString();
        if (adSizeParcel.f9329e || adSizeParcel.f9333i) {
            this.f10059f = null;
        } else {
            this.f10059f = new C2969a(context, this, this);
            this.f10059f.setMinimumWidth(adSizeParcel.f9331g);
            this.f10059f.setMinimumHeight(adSizeParcel.f9328d);
            this.f10059f.setVisibility(4);
        }
        this.f10062i = adSizeParcel;
        this.f10055b = str;
        this.f10056c = context;
        this.f10058e = versionInfoParcel;
        if (c3326k == null) {
            c3326k = new C3326k(new C2828i(this));
        }
        this.f10057d = c3326k;
        this.f10050K = new hr(200);
        this.f10075v = new SimpleArrayMap();
    }

    private void m11544b(boolean z) {
        boolean z2 = true;
        if (this.f10059f != null && this.f10063j != null && this.f10063j.f11179b != null) {
            if (!z || this.f10050K.m13157a()) {
                if (this.f10063j.f11179b.m13249l().m13293b()) {
                    int[] iArr = new int[2];
                    this.f10059f.getLocationOnScreen(iArr);
                    int b = C2784w.m10741a().m11569b(this.f10056c, iArr[0]);
                    int b2 = C2784w.m10741a().m11569b(this.f10056c, iArr[1]);
                    if (!(b == this.f10048I && b2 == this.f10049J)) {
                        this.f10048I = b;
                        this.f10049J = b2;
                        ij l = this.f10063j.f11179b.m13249l();
                        b = this.f10048I;
                        int i = this.f10049J;
                        if (z) {
                            z2 = false;
                        }
                        l.m13279a(b, i, z2);
                    }
                }
                m11545k();
            }
        }
    }

    private void m11545k() {
        View findViewById = this.f10059f.getRootView().findViewById(16908290);
        if (findViewById != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.f10059f.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.f10051L = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.f10052M = false;
            }
        }
    }

    public HashSet<gy> m11546a() {
        return this.f10047H;
    }

    void m11547a(String str) {
        this.f10046G = str;
    }

    public void m11548a(HashSet<gy> hashSet) {
        this.f10047H = hashSet;
    }

    public void m11549a(boolean z) {
        if (this.f10043D == 0) {
            m11551c();
        }
        if (this.f10060g != null) {
            this.f10060g.m10973d();
        }
        if (this.f10061h != null) {
            this.f10061h.m10968d();
        }
        if (z) {
            this.f10063j = null;
        }
    }

    public void m11550b() {
        if (this.f10063j != null && this.f10063j.f11179b != null) {
            this.f10063j.f11179b.destroy();
        }
    }

    public void m11551c() {
        if (this.f10063j != null && this.f10063j.f11179b != null) {
            this.f10063j.f11179b.stopLoading();
        }
    }

    public void m11552d() {
        if (this.f10063j != null && this.f10063j.f11192o != null) {
            try {
                this.f10063j.f11192o.m12377c();
            } catch (RemoteException e) {
                C2972b.m11583d("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean m11553e() {
        return this.f10043D == 0;
    }

    public boolean m11554f() {
        return this.f10043D == 1;
    }

    public void m11555g() {
        if (this.f10059f != null) {
            this.f10059f.m11543b();
        }
    }

    public String m11556h() {
        return (this.f10051L && this.f10052M) ? BuildConfig.FLAVOR : this.f10051L ? this.f10053N ? "top-scrollable" : "top-locked" : this.f10052M ? this.f10053N ? "bottom-scrollable" : "bottom-locked" : BuildConfig.FLAVOR;
    }

    public void m11557i() {
        this.f10065l.m12920a(this.f10063j.f11202y);
        this.f10065l.m12924b(this.f10063j.f11203z);
        this.f10065l.m12922a(this.f10062i.f9329e);
        this.f10065l.m12925b(this.f10063j.f11190m);
    }

    public void m11558j() {
        m11555g();
        this.f10067n = null;
        this.f10068o = null;
        this.f10071r = null;
        this.f10070q = null;
        this.f10077x = null;
        this.f10069p = null;
        m11549a(false);
        if (this.f10059f != null) {
            this.f10059f.removeAllViews();
        }
        m11550b();
        m11552d();
        this.f10063j = null;
    }

    public void onGlobalLayout() {
        m11544b(false);
    }

    public void onScrollChanged() {
        m11544b(true);
        this.f10053N = true;
    }
}
