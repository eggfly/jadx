package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.C2510r;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2710b.C2699a;
import com.google.android.gms.ads.C2716c.C2712a;
import com.google.android.gms.ads.p124b.C2701a;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.ads.p124b.C2705c;
import com.google.android.gms.ads.p124b.C2706d;
import com.google.android.gms.ads.p124b.C2706d.C2303a;
import com.google.android.gms.ads.p124b.C2707e;
import com.google.android.gms.ads.p124b.C2708f;
import com.google.android.gms.ads.p124b.C2708f.C2305a;
import com.google.android.gms.ads.p124b.C2709g;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.common.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.d */
public class C2308d extends C2307r {
    private static final String f7969a;
    private View f7970b;
    private C2701a f7971c;
    private C2288s f7972d;
    private C2705c f7973e;
    private boolean f7974f;
    private Uri f7975g;
    private Uri f7976h;
    private String f7977i;
    private String f7978j;
    private String f7979k;
    private String f7980l;

    /* renamed from: com.facebook.ads.internal.adapters.d.1 */
    class C23021 extends C2301a {
        final /* synthetic */ C2288s f7965a;
        final /* synthetic */ C2308d f7966b;

        C23021(C2308d c2308d, C2288s c2288s) {
            this.f7966b = c2308d;
            this.f7965a = c2288s;
        }

        public void onAdFailedToLoad(int i) {
            Log.e(C2308d.f7969a, "Ad failed: " + i);
            this.f7965a.m8648a(this.f7966b, AdError.NO_FILL);
        }

        public void onAdOpened() {
            Log.e(C2308d.f7969a, "Ad opened");
            this.f7965a.m8650c(this.f7966b);
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.d.2 */
    class C23042 implements C2303a {
        final /* synthetic */ C2308d f7967a;

        C23042(C2308d c2308d) {
            this.f7967a = c2308d;
        }

        public void onAppInstallAdLoaded(C2706d c2706d) {
            Uri uri = null;
            Log.e(C2308d.f7969a, "Ad loaded: " + c2706d.m10293b());
            this.f7967a.f7971c = c2706d;
            this.f7967a.f7974f = true;
            this.f7967a.f7977i = c2706d.m10293b() != null ? c2706d.m10293b().toString() : null;
            this.f7967a.f7978j = c2706d.m10295d() != null ? c2706d.m10295d().toString() : null;
            this.f7967a.f7980l = c2706d.m10299h() != null ? c2706d.m10299h().toString() : null;
            this.f7967a.f7979k = c2706d.m10297f() != null ? c2706d.m10297f().toString() : null;
            List c = c2706d.m10294c();
            C2308d c2308d = this.f7967a;
            Uri b = (c == null || c.size() <= 0) ? null : ((C2700a) c.get(0)).m10275b();
            c2308d.f7975g = b;
            C2308d c2308d2 = this.f7967a;
            if (c2706d.m10296e() != null) {
                uri = c2706d.m10296e().m10275b();
            }
            c2308d2.f7976h = uri;
            if (this.f7967a.f7972d != null) {
                this.f7967a.f7972d.m8647a(this.f7967a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.d.3 */
    class C23063 implements C2305a {
        final /* synthetic */ C2308d f7968a;

        C23063(C2308d c2308d) {
            this.f7968a = c2308d;
        }

        public void onContentAdLoaded(C2708f c2708f) {
            Uri uri = null;
            Log.e(C2308d.f7969a, "Ad loaded: " + c2708f.m10301b());
            this.f7968a.f7971c = c2708f;
            this.f7968a.f7974f = true;
            this.f7968a.f7977i = c2708f.m10301b() != null ? c2708f.m10301b().toString() : null;
            this.f7968a.f7978j = c2708f.m10303d() != null ? c2708f.m10303d().toString() : null;
            this.f7968a.f7980l = c2708f.m10306g() != null ? c2708f.m10306g().toString() : null;
            this.f7968a.f7979k = c2708f.m10305f() != null ? c2708f.m10305f().toString() : null;
            List c = c2708f.m10302c();
            C2308d c2308d = this.f7968a;
            Uri b = (c == null || c.size() <= 0) ? null : ((C2700a) c.get(0)).m10275b();
            c2308d.f7975g = b;
            C2308d c2308d2 = this.f7968a;
            if (c2708f.m10304e() != null) {
                uri = c2708f.m10304e().m10275b();
            }
            c2308d2.f7976h = uri;
            if (this.f7968a.f7972d != null) {
                this.f7968a.f7972d.m8647a(this.f7968a);
            }
        }
    }

    static {
        f7969a = C2308d.class.getSimpleName();
    }

    private void m8761a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public AdExtras m8767A() {
        return null;
    }

    public List<NativeAd> m8768B() {
        return null;
    }

    public void m8769a() {
        if (this.f7970b != null) {
            View view = (ViewGroup) this.f7970b.getParent();
            if ((view instanceof C2709g) || (view instanceof C2707e)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    int indexOfChild = viewGroup.indexOfChild(view);
                    m8761a(this.f7970b);
                    m8761a(view);
                    viewGroup.addView(this.f7970b, indexOfChild);
                }
            }
            this.f7970b = null;
        }
        this.f7973e = null;
    }

    public void m8770a(int i) {
    }

    public void m8771a(Context context, C2288s c2288s, Map<String, Object> map) {
        String optString = ((JSONObject) map.get(Constants.KEY_DATA)).optString("ad_unit_id");
        if (C2510r.m9516a(optString)) {
            c2288s.m8648a(this, AdError.SERVER_ERROR);
            return;
        }
        this.f7972d = c2288s;
        new C2699a(context, optString).m10272a(new C23063(this)).m10271a(new C23042(this)).m10269a(new C23021(this, c2288s)).m10273a().m10308a(new C2712a().m10316a());
    }

    public void m8772a(View view, List<View> list) {
        this.f7970b = view;
        if (m8775b() && view != null) {
            ViewGroup viewGroup;
            int i;
            int i2 = -1;
            ViewGroup viewGroup2 = null;
            while (true) {
                ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                if (viewGroup3 == null) {
                    Log.e(f7969a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                    return;
                }
                if (viewGroup3 instanceof C2705c) {
                    viewGroup = (ViewGroup) viewGroup3.getParent();
                    if (viewGroup == null) {
                        Log.e(f7969a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                        return;
                    }
                    int indexOfChild = viewGroup.indexOfChild(viewGroup3);
                    viewGroup3.removeView(view);
                    viewGroup.removeView(viewGroup3);
                    viewGroup.addView(view, indexOfChild);
                    i = i2;
                    viewGroup = viewGroup2;
                } else {
                    viewGroup = viewGroup3;
                    i = viewGroup3.indexOfChild(view);
                }
                if (viewGroup != null) {
                    break;
                }
                i2 = i;
                viewGroup2 = viewGroup;
            }
            View c2709g = this.f7971c instanceof C2708f ? new C2709g(view.getContext()) : new C2707e(view.getContext());
            if (view instanceof ViewGroup) {
                c2709g.setLayoutParams(view.getLayoutParams());
            }
            m8761a(view);
            c2709g.addView(view);
            viewGroup.removeView(c2709g);
            viewGroup.addView(c2709g, i);
            this.f7973e = c2709g;
            this.f7973e.setNativeAd(this.f7971c);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            View view2 = new View(view.getContext());
            view2.setBackgroundResource(17170445);
            view2.setLayoutParams(layoutParams);
            this.f7973e.addView(view2);
            view2.bringToFront();
            if (this.f7973e instanceof C2709g) {
                ((C2709g) this.f7973e).setCallToActionView(view2);
            } else if (this.f7973e instanceof C2707e) {
                ((C2707e) this.f7973e).setCallToActionView(view2);
            }
        }
    }

    public void m8773a(Map<String, Object> map) {
        if (m8775b() && this.f7972d != null) {
            this.f7972d.m8649b(this);
        }
    }

    public void m8774b(Map<String, Object> map) {
    }

    public boolean m8775b() {
        return this.f7974f && this.f7971c != null;
    }

    public boolean m8776c() {
        return false;
    }

    public boolean m8777d() {
        return false;
    }

    public boolean m8778e() {
        return false;
    }

    public boolean m8779f() {
        return false;
    }

    public boolean m8780g() {
        return false;
    }

    public int m8781h() {
        return 0;
    }

    public int m8782i() {
        return 0;
    }

    public int m8783j() {
        return 0;
    }

    public Image m8784k() {
        return (!m8775b() || this.f7976h == null) ? null : new Image(this.f7976h.toString(), 50, 50);
    }

    public Image m8785l() {
        return (!m8775b() || this.f7975g == null) ? null : new Image(this.f7975g.toString(), 1200, OtherError.CONTAINER_INVISIBLE_ERROR);
    }

    public NativeAdViewAttributes m8786m() {
        return null;
    }

    public String m8787n() {
        return this.f7977i;
    }

    public String m8788o() {
        return null;
    }

    public void onDestroy() {
        m8769a();
        this.f7972d = null;
        this.f7971c = null;
        this.f7974f = false;
        this.f7975g = null;
        this.f7976h = null;
        this.f7977i = null;
        this.f7978j = null;
        this.f7979k = null;
        this.f7980l = null;
    }

    public String m8789p() {
        return this.f7978j;
    }

    public String m8790q() {
        return this.f7979k;
    }

    public String m8791r() {
        return this.f7980l;
    }

    public Rating m8792s() {
        return null;
    }

    public Image m8793t() {
        return null;
    }

    public String m8794u() {
        return null;
    }

    public String m8795v() {
        return null;
    }

    public String m8796w() {
        return null;
    }

    public int m8797x() {
        return 0;
    }

    public String m8798y() {
        return null;
    }

    public String m8799z() {
        return null;
    }
}
