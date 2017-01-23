package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.antutu.utils.widget.SystemBarTintManager;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.et.C2862a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.hm;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.ij.C2813a;
import com.umeng.message.util.HttpRequest;
import java.util.Collections;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.d */
public class C2864d extends C2862a implements C2863s {
    static final int f9696a;
    AdOverlayInfoParcel f9697b;
    ii f9698c;
    C2859c f9699d;
    C2873o f9700e;
    boolean f9701f;
    FrameLayout f9702g;
    CustomViewCallback f9703h;
    boolean f9704i;
    boolean f9705j;
    RelativeLayout f9706k;
    boolean f9707l;
    int f9708m;
    C2870l f9709n;
    private final Activity f9710o;
    private boolean f9711p;
    private boolean f9712q;
    private boolean f9713r;

    /* renamed from: com.google.android.gms.ads.internal.overlay.d.1 */
    class C28561 implements C2813a {
        final /* synthetic */ C2864d f9687a;

        C28561(C2864d c2864d) {
            this.f9687a = c2864d;
        }

        public void m11080a(ii iiVar, boolean z) {
            iiVar.m13240d();
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.overlay.d.a */
    private static final class C2857a extends Exception {
        public C2857a(String str) {
            super(str);
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.overlay.d.b */
    static final class C2858b extends RelativeLayout {
        hm f9688a;

        public C2858b(Context context, String str) {
            super(context);
            this.f9688a = new hm(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f9688a.m13125a(motionEvent);
            return false;
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.overlay.d.c */
    public static class C2859c {
        public final int f9689a;
        public final LayoutParams f9690b;
        public final ViewGroup f9691c;
        public final Context f9692d;

        public C2859c(ii iiVar) {
            this.f9690b = iiVar.getLayoutParams();
            ViewParent parent = iiVar.getParent();
            this.f9692d = iiVar.m13244g();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new C2857a("Could not get the parent of the WebView for an overlay.");
            }
            this.f9691c = (ViewGroup) parent;
            this.f9689a = this.f9691c.indexOfChild(iiVar.m13233b());
            this.f9691c.removeView(iiVar.m13233b());
            iiVar.m13232a(true);
        }
    }

    @gb
    /* renamed from: com.google.android.gms.ads.internal.overlay.d.d */
    private class C2861d extends he {
        final /* synthetic */ C2864d f9695a;

        /* renamed from: com.google.android.gms.ads.internal.overlay.d.d.1 */
        class C28601 implements Runnable {
            final /* synthetic */ Drawable f9693a;
            final /* synthetic */ C2861d f9694b;

            C28601(C2861d c2861d, Drawable drawable) {
                this.f9694b = c2861d;
                this.f9693a = drawable;
            }

            public void run() {
                this.f9694b.f9695a.f9710o.getWindow().setBackgroundDrawable(this.f9693a);
            }
        }

        private C2861d(C2864d c2864d) {
            this.f9695a = c2864d;
        }

        public void m11081a() {
            Bitmap b = C2968s.m11525e().m13052b(this.f9695a.f9710o, this.f9695a.f9697b.f9661q.f9290d);
            if (b != null) {
                hj.f11297a.post(new C28601(this, C2968s.m11527g().m13076a(this.f9695a.f9710o, b, this.f9695a.f9697b.f9661q.f9291e, this.f9695a.f9697b.f9661q.f9292f)));
            }
        }

        public void m11082b() {
        }
    }

    static {
        f9696a = Color.argb(0, 0, 0, 0);
    }

    public C2864d(Activity activity) {
        this.f9701f = false;
        this.f9704i = false;
        this.f9705j = false;
        this.f9707l = false;
        this.f9708m = 0;
        this.f9712q = false;
        this.f9713r = true;
        this.f9710o = activity;
        this.f9709n = new C2874q();
    }

    public void m11097a() {
        this.f9708m = 2;
        this.f9710o.finish();
    }

    public void m11098a(int i) {
        this.f9710o.setRequestedOrientation(i);
    }

    public void m11099a(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f9704i = z;
        try {
            this.f9697b = AdOverlayInfoParcel.m11035a(this.f9710o.getIntent());
            if (this.f9697b == null) {
                throw new C2857a("Could not get info for ad overlay.");
            }
            if (this.f9697b.f9658n.f10083d > 7500000) {
                this.f9708m = 3;
            }
            if (this.f9710o.getIntent() != null) {
                this.f9713r = this.f9710o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f9697b.f9661q != null) {
                this.f9705j = this.f9697b.f9661q.f9288b;
            } else {
                this.f9705j = false;
            }
            if (((Boolean) aq.aE.m11794c()).booleanValue() && this.f9705j && this.f9697b.f9661q.f9290d != null) {
                new C2861d().m10975g();
            }
            if (bundle == null) {
                if (this.f9697b.f9648d != null && this.f9713r) {
                    this.f9697b.f9648d.h_();
                }
                if (!(this.f9697b.f9656l == 1 || this.f9697b.f9647c == null)) {
                    this.f9697b.f9647c.m10223a();
                }
            }
            this.f9706k = new C2858b(this.f9710o, this.f9697b.f9660p);
            this.f9706k.setId(AdError.NETWORK_ERROR_CODE);
            switch (this.f9697b.f9656l) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m11107b(false);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f9699d = new C2859c(this.f9697b.f9649e);
                    m11107b(false);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m11107b(true);
                case SpdyProtocol.QUIC /*4*/:
                    if (this.f9704i) {
                        this.f9708m = 3;
                        this.f9710o.finish();
                    } else if (!C2968s.m11522b().m11044a(this.f9710o, this.f9697b.f9646b, this.f9697b.f9654j)) {
                        this.f9708m = 3;
                        this.f9710o.finish();
                    }
                default:
                    throw new C2857a("Could not determine ad overlay type.");
            }
        } catch (C2857a e) {
            C2972b.m11583d(e.getMessage());
            this.f9708m = 3;
            this.f9710o.finish();
        }
    }

    public void m11100a(View view, CustomViewCallback customViewCallback) {
        this.f9702g = new FrameLayout(this.f9710o);
        this.f9702g.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f9702g.addView(view, -1, -1);
        this.f9710o.setContentView(this.f9702g);
        m11117l();
        this.f9703h = customViewCallback;
        this.f9701f = true;
    }

    public void m11101a(ii iiVar, Map<String, String> map) {
        this.f9709n.m11164a(iiVar, map);
    }

    public void m11102a(boolean z) {
        this.f9700e = new C2873o(this.f9710o, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f9700e.m11171a(z, this.f9697b.f9652h);
        this.f9706k.addView(this.f9700e, layoutParams);
    }

    public void m11103a(boolean z, boolean z2) {
        if (this.f9700e != null) {
            this.f9700e.m11171a(z, z2);
        }
    }

    public void m11104b() {
        if (this.f9697b != null && this.f9701f) {
            m11098a(this.f9697b.f9655k);
        }
        if (this.f9702g != null) {
            this.f9710o.setContentView(this.f9706k);
            m11117l();
            this.f9702g.removeAllViews();
            this.f9702g = null;
        }
        if (this.f9703h != null) {
            this.f9703h.onCustomViewHidden();
            this.f9703h = null;
        }
        this.f9701f = false;
    }

    protected void m11105b(int i) {
        this.f9698c.m13223a(i);
    }

    public void m11106b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f9704i);
    }

    protected void m11107b(boolean z) {
        if (!this.f9711p) {
            this.f9710o.requestWindowFeature(1);
        }
        Window window = this.f9710o.getWindow();
        if (window == null) {
            throw new C2857a("Invalid activity, no window available.");
        }
        if (!this.f9705j || (this.f9697b.f9661q != null && this.f9697b.f9661q.f9289c)) {
            window.setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        }
        boolean b = this.f9697b.f9649e.m13249l().m13293b();
        this.f9707l = false;
        if (b) {
            if (this.f9697b.f9655k == C2968s.m11527g().m13075a()) {
                this.f9707l = this.f9710o.getResources().getConfiguration().orientation == 1;
            } else if (this.f9697b.f9655k == C2968s.m11527g().m13089b()) {
                this.f9707l = this.f9710o.getResources().getConfiguration().orientation == 2;
            }
        }
        C2972b.m11576a("Delay onShow to next orientation change: " + this.f9707l);
        m11098a(this.f9697b.f9655k);
        if (C2968s.m11527g().m13087a(window)) {
            C2972b.m11576a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.f9705j) {
            this.f9706k.setBackgroundColor(f9696a);
        } else {
            this.f9706k.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        }
        this.f9710o.setContentView(this.f9706k);
        m11117l();
        if (z) {
            this.f9698c = C2968s.m11526f().m13300a(this.f9710o, this.f9697b.f9649e.m13248k(), true, b, null, this.f9697b.f9658n, null, this.f9697b.f9649e.m13245h());
            this.f9698c.m13249l().m13281a(null, null, this.f9697b.f9650f, this.f9697b.f9654j, true, this.f9697b.f9659o, null, this.f9697b.f9649e.m13249l().m13277a(), null);
            this.f9698c.m13249l().m13285a(new C28561(this));
            if (this.f9697b.f9657m != null) {
                this.f9698c.loadUrl(this.f9697b.f9657m);
            } else if (this.f9697b.f9653i != null) {
                this.f9698c.loadDataWithBaseURL(this.f9697b.f9651g, this.f9697b.f9653i, "text/html", HttpRequest.f14548a, null);
            } else {
                throw new C2857a("No URL or HTML to display in ad overlay.");
            }
            if (this.f9697b.f9649e != null) {
                this.f9697b.f9649e.m13235b(this);
            }
        } else {
            this.f9698c = this.f9697b.f9649e;
            this.f9698c.m13224a(this.f9710o);
        }
        this.f9698c.m13227a(this);
        ViewParent parent = this.f9698c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f9698c.m13233b());
        }
        if (this.f9705j) {
            this.f9698c.setBackgroundColor(f9696a);
        }
        this.f9706k.addView(this.f9698c.m13233b(), -1, -1);
        if (!(z || this.f9707l)) {
            m11121p();
        }
        m11102a(b);
        if (this.f9698c.m13250m()) {
            m11103a(b, true);
        }
        C2795e h = this.f9698c.m13245h();
        C2871m c2871m = h != null ? h.f9479c : null;
        if (c2871m != null) {
            this.f9709n = c2871m.m11168a(this.f9710o, this.f9698c, this.f9706k);
        } else {
            C2972b.m11583d("Appstreaming controller is null.");
        }
    }

    public void m11108c() {
        this.f9708m = 1;
        this.f9710o.finish();
    }

    public void m11109d() {
        this.f9708m = 0;
    }

    public boolean m11110e() {
        boolean z = true;
        this.f9708m = 0;
        if (this.f9698c != null) {
            if (!(this.f9698c.m13257t() && this.f9709n.m11167d())) {
                z = false;
            }
            if (!z) {
                this.f9698c.m13230a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void m11111f() {
    }

    public void m11112g() {
    }

    public void m11113h() {
        if (this.f9697b != null && this.f9697b.f9656l == 4) {
            if (this.f9704i) {
                this.f9708m = 3;
                this.f9710o.finish();
            } else {
                this.f9704i = true;
            }
        }
        if (this.f9697b.f9648d != null) {
            this.f9697b.f9648d.m10465g();
        }
        if (this.f9698c == null || this.f9698c.m13255r()) {
            C2972b.m11583d("The webview does not exit. Ignoring action.");
        } else {
            C2968s.m11527g().m13091b(this.f9698c);
        }
        this.f9709n.m11165b();
    }

    public void m11114i() {
        this.f9709n.m11163a();
        m11104b();
        if (this.f9697b.f9648d != null) {
            this.f9697b.f9648d.i_();
        }
        if (this.f9698c != null && (!this.f9710o.isFinishing() || this.f9699d == null)) {
            C2968s.m11527g().m13088a(this.f9698c);
        }
        m11119n();
    }

    public void m11115j() {
        m11119n();
    }

    public void m11116k() {
        if (this.f9698c != null) {
            this.f9706k.removeView(this.f9698c.m13233b());
        }
        m11119n();
    }

    public void m11117l() {
        this.f9711p = true;
    }

    public void m11118m() {
        this.f9706k.removeView(this.f9700e);
        m11102a(true);
    }

    protected void m11119n() {
        if (this.f9710o.isFinishing() && !this.f9712q) {
            this.f9712q = true;
            if (this.f9698c != null) {
                m11105b(this.f9708m);
                this.f9706k.removeView(this.f9698c.m13233b());
                if (this.f9699d != null) {
                    this.f9698c.m13224a(this.f9699d.f9692d);
                    this.f9698c.m13232a(false);
                    this.f9699d.f9691c.addView(this.f9698c.m13233b(), this.f9699d.f9689a, this.f9699d.f9690b);
                    this.f9699d = null;
                } else if (this.f9710o.getApplicationContext() != null) {
                    this.f9698c.m13224a(this.f9710o.getApplicationContext());
                }
                this.f9698c = null;
            }
            if (!(this.f9697b == null || this.f9697b.f9648d == null)) {
                this.f9697b.f9648d.g_();
            }
            this.f9709n.m11166c();
        }
    }

    public void m11120o() {
        if (this.f9707l) {
            this.f9707l = false;
            m11121p();
        }
    }

    protected void m11121p() {
        this.f9698c.m13240d();
    }
}
