package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.im */
class im extends WebView implements OnGlobalLayoutListener, DownloadListener, ii {
    private int f11446A;
    private Map<String, cn> f11447B;
    private final WindowManager f11448C;
    private final C3288a f11449a;
    private final Object f11450b;
    private final C3326k f11451c;
    private final VersionInfoParcel f11452d;
    private final C2795e f11453e;
    private ij f11454f;
    private C2864d f11455g;
    private AdSizeParcel f11456h;
    private boolean f11457i;
    private boolean f11458j;
    private boolean f11459k;
    private boolean f11460l;
    private Boolean f11461m;
    private int f11462n;
    private boolean f11463o;
    private String f11464p;
    private aw f11465q;
    private aw f11466r;
    private aw f11467s;
    private ay f11468t;
    private WeakReference<OnClickListener> f11469u;
    private C2864d f11470v;
    private hv f11471w;
    private int f11472x;
    private int f11473y;
    private int f11474z;

    /* renamed from: com.google.android.gms.b.im.1 */
    class C32871 implements Runnable {
        final /* synthetic */ im f11442a;

        C32871(im imVar) {
            this.f11442a = imVar;
        }

        public void run() {
            super.destroy();
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.im.a */
    public static class C3288a extends MutableContextWrapper {
        private Activity f11443a;
        private Context f11444b;
        private Context f11445c;

        public C3288a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Activity m13350a() {
            return this.f11443a;
        }

        public Context m13351b() {
            return this.f11445c;
        }

        public Object getSystemService(String str) {
            return this.f11445c.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.f11444b = context.getApplicationContext();
            this.f11443a = context instanceof Activity ? (Activity) context : null;
            this.f11445c = context;
            super.setBaseContext(this.f11444b);
        }

        public void startActivity(Intent intent) {
            if (this.f11443a == null || jq.m13574g()) {
                intent.setFlags(268435456);
                this.f11444b.startActivity(intent);
                return;
            }
            this.f11443a.startActivity(intent);
        }
    }

    protected im(C3288a c3288a, AdSizeParcel adSizeParcel, boolean z, boolean z2, C3326k c3326k, VersionInfoParcel versionInfoParcel, az azVar, C2795e c2795e) {
        super(c3288a);
        this.f11450b = new Object();
        this.f11463o = true;
        this.f11464p = BuildConfig.FLAVOR;
        this.f11472x = -1;
        this.f11473y = -1;
        this.f11474z = -1;
        this.f11446A = -1;
        this.f11449a = c3288a;
        this.f11456h = adSizeParcel;
        this.f11459k = z;
        this.f11462n = -1;
        this.f11451c = c3326k;
        this.f11452d = versionInfoParcel;
        this.f11453e = c2795e;
        this.f11448C = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        C2968s.m11525e().m13034a((Context) c3288a, versionInfoParcel.f10081b, settings);
        C2968s.m11527g().m13085a(getContext(), settings);
        setDownloadListener(this);
        m13354H();
        if (jq.m13570c()) {
            addJavascriptInterface(new in(this), "googleAdsJsInterface");
        }
        this.f11471w = new hv(this.f11449a.m13350a(), this, null);
        m13360a(azVar);
    }

    private void m13352F() {
        synchronized (this.f11450b) {
            this.f11461m = C2968s.m11528h().m12953j();
            if (this.f11461m == null) {
                try {
                    m13376a("(function(){})()", null);
                    m13374a(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    m13374a(Boolean.valueOf(false));
                }
            }
        }
    }

    private void m13353G() {
        au.m11834a(this.f11468t.m11846a(), this.f11465q, "aeh");
    }

    private void m13354H() {
        synchronized (this.f11450b) {
            if (this.f11459k || this.f11456h.f9329e) {
                if (VERSION.SDK_INT < 14) {
                    C2972b.m11576a("Disabling hardware acceleration on an overlay.");
                    m13355I();
                } else {
                    C2972b.m11576a("Enabling hardware acceleration on an overlay.");
                    m13356J();
                }
            } else if (VERSION.SDK_INT < 18) {
                C2972b.m11576a("Disabling hardware acceleration on an AdView.");
                m13355I();
            } else {
                C2972b.m11576a("Enabling hardware acceleration on an AdView.");
                m13356J();
            }
        }
    }

    private void m13355I() {
        synchronized (this.f11450b) {
            if (!this.f11460l) {
                C2968s.m11527g().m13094c((View) this);
            }
            this.f11460l = true;
        }
    }

    private void m13356J() {
        synchronized (this.f11450b) {
            if (this.f11460l) {
                C2968s.m11527g().m13090b((View) this);
            }
            this.f11460l = false;
        }
    }

    private void m13357K() {
        synchronized (this.f11450b) {
            if (this.f11447B != null) {
                for (cn a : this.f11447B.values()) {
                    a.m12081a();
                }
            }
        }
    }

    private void m13358L() {
        if (this.f11468t != null) {
            az a = this.f11468t.m11846a();
            if (a != null && C2968s.m11528h().m12948e() != null) {
                C2968s.m11528h().m12948e().m11829a(a);
            }
        }
    }

    static im m13359a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, C3326k c3326k, VersionInfoParcel versionInfoParcel, az azVar, C2795e c2795e) {
        return new im(new C3288a(context), adSizeParcel, z, z2, c3326k, versionInfoParcel, azVar, c2795e);
    }

    private void m13360a(az azVar) {
        m13358L();
        this.f11468t = new ay(new az(true, "make_wv", this.f11456h.f9326b));
        this.f11468t.m11846a().m11851a(azVar);
        this.f11466r = au.m11831a(this.f11468t.m11846a());
        this.f11468t.m11847a("native:view_create", this.f11466r);
        this.f11467s = null;
        this.f11465q = null;
    }

    public OnClickListener m13362A() {
        return (OnClickListener) this.f11469u.get();
    }

    public void m13363B() {
        if (!m13408r()) {
            try {
                if (jq.m13567a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                C2972b.m11580b("Could not pause webview.", e);
            }
        }
    }

    public void m13364C() {
        if (!m13408r()) {
            try {
                if (jq.m13567a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                C2972b.m11580b("Could not resume webview.", e);
            }
        }
    }

    public boolean m13365D() {
        if (!m13402l().m13293b()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics a = C2968s.m11525e().m13020a(this.f11448C);
        int b = C2784w.m10741a().m11570b(a, a.widthPixels);
        int b2 = C2784w.m10741a().m11570b(a, a.heightPixels);
        Activity f = m13396f();
        if (f == null || f.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] a2 = C2968s.m11525e().m13049a(f);
            i2 = C2784w.m10741a().m11570b(a, a2[0]);
            i = C2784w.m10741a().m11570b(a, a2[1]);
        }
        if (this.f11473y == b && this.f11472x == b2 && this.f11474z == i2 && this.f11446A == i) {
            return false;
        }
        boolean z = (this.f11473y == b && this.f11472x == b2) ? false : true;
        this.f11473y = b;
        this.f11472x = b2;
        this.f11474z = i2;
        this.f11446A = i;
        new eq(this).m12587a(b, b2, i2, i, a.density, this.f11448C.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean m13366E() {
        Boolean bool;
        synchronized (this.f11450b) {
            bool = this.f11461m;
        }
        return bool;
    }

    public WebView m13367a() {
        return this;
    }

    public void m13368a(int i) {
        m13353G();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(Constants.SP_KEY_VERSION, this.f11452d.f10081b);
        m13379a("onhide", hashMap);
    }

    public void m13369a(Context context) {
        this.f11449a.setBaseContext(context);
        this.f11471w.m13164a(this.f11449a.m13350a());
    }

    public void m13370a(Context context, AdSizeParcel adSizeParcel, az azVar) {
        synchronized (this.f11450b) {
            this.f11471w.m13165b();
            m13369a(context);
            this.f11455g = null;
            this.f11456h = adSizeParcel;
            this.f11459k = false;
            this.f11457i = false;
            this.f11464p = BuildConfig.FLAVOR;
            this.f11462n = -1;
            C2968s.m11527g().m13091b((ii) this);
            loadUrl("about:blank");
            this.f11454f.m13297f();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.f11463o = true;
            m13360a(azVar);
        }
    }

    public void m13371a(AdSizeParcel adSizeParcel) {
        synchronized (this.f11450b) {
            this.f11456h = adSizeParcel;
            requestLayout();
        }
    }

    public void m13372a(C2864d c2864d) {
        synchronized (this.f11450b) {
            this.f11455g = c2864d;
        }
    }

    public void m13373a(C3364q c3364q, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
        m13379a("onAdVisibilityChanged", hashMap);
    }

    void m13374a(Boolean bool) {
        this.f11461m = bool;
        C2968s.m11528h().m12938a(bool);
    }

    public void m13375a(String str) {
        synchronized (this.f11450b) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                C2972b.m11583d("Could not call loadUrl. " + th);
            }
        }
    }

    @TargetApi(19)
    public void m13376a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    public void m13377a(String str, cb cbVar) {
        if (this.f11454f != null) {
            this.f11454f.m13287a(str, cbVar);
        }
    }

    public void m13378a(String str, String str2) {
        m13394d(str + C4233j.f14396s + str2 + ");");
    }

    public void m13379a(String str, Map<String, ?> map) {
        try {
            m13388b(str, C2968s.m11525e().m13030a((Map) map));
        } catch (JSONException e) {
            C2972b.m11583d("Could not convert parameters to JSON.");
        }
    }

    public void m13380a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        m13378a(str, jSONObject.toString());
    }

    public void m13381a(boolean z) {
        synchronized (this.f11450b) {
            this.f11459k = z;
            m13354H();
        }
    }

    public View m13382b() {
        return this;
    }

    public void m13383b(int i) {
        synchronized (this.f11450b) {
            this.f11462n = i;
            if (this.f11455g != null) {
                this.f11455g.m11098a(this.f11462n);
            }
        }
    }

    public void m13384b(C2864d c2864d) {
        synchronized (this.f11450b) {
            this.f11470v = c2864d;
        }
    }

    public void m13385b(String str) {
        synchronized (this.f11450b) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            this.f11464p = str;
        }
    }

    @TargetApi(19)
    protected void m13386b(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                m13376a(str, (ValueCallback) valueCallback);
            }
        }
    }

    public void m13387b(String str, cb cbVar) {
        if (this.f11454f != null) {
            this.f11454f.m13292b(str, cbVar);
        }
    }

    public void m13388b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        hf.m12982e("Dispatching AFMA event: " + stringBuilder.toString());
        m13394d(stringBuilder.toString());
    }

    public void m13389b(boolean z) {
        synchronized (this.f11450b) {
            if (this.f11455g != null) {
                this.f11455g.m11103a(this.f11454f.m13293b(), z);
            } else {
                this.f11457i = z;
            }
        }
    }

    public void m13390c() {
        m13353G();
        Map hashMap = new HashMap(1);
        hashMap.put(Constants.SP_KEY_VERSION, this.f11452d.f10081b);
        m13379a("onhide", hashMap);
    }

    protected void m13391c(String str) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void m13392c(boolean z) {
        synchronized (this.f11450b) {
            this.f11463o = z;
        }
    }

    public void m13393d() {
        if (this.f11465q == null) {
            au.m11834a(this.f11468t.m11846a(), this.f11467s, "aes");
            this.f11465q = au.m11831a(this.f11468t.m11846a());
            this.f11468t.m11847a("native:view_show", this.f11465q);
        }
        Map hashMap = new HashMap(1);
        hashMap.put(Constants.SP_KEY_VERSION, this.f11452d.f10081b);
        m13379a("onshow", hashMap);
    }

    protected void m13394d(String str) {
        if (jq.m13572e()) {
            if (m13366E() == null) {
                m13352F();
            }
            if (m13366E().booleanValue()) {
                m13386b(str, null);
                return;
            } else {
                m13391c("javascript:" + str);
                return;
            }
        }
        m13391c("javascript:" + str);
    }

    public void destroy() {
        synchronized (this.f11450b) {
            m13358L();
            this.f11471w.m13165b();
            if (this.f11455g != null) {
                this.f11455g.m11097a();
                this.f11455g.m11116k();
                this.f11455g = null;
            }
            this.f11454f.m13297f();
            if (this.f11458j) {
                return;
            }
            C2968s.m11540t().m12073a((ii) this);
            m13357K();
            this.f11458j = true;
            hf.m12982e("Initiating WebView self destruct sequence in 3...");
            this.f11454f.m13295d();
        }
    }

    public void m13395e() {
        Map hashMap = new HashMap(2);
        hashMap.put("app_volume", String.valueOf(C2968s.m11525e().m13068f()));
        hashMap.put("device_volume", String.valueOf(C2968s.m11525e().m13072i(getContext())));
        m13379a("volume", hashMap);
    }

    public Activity m13396f() {
        return this.f11449a.m13350a();
    }

    protected void finalize() {
        synchronized (this.f11450b) {
            if (!this.f11458j) {
                C2968s.m11540t().m12073a((ii) this);
                m13357K();
            }
        }
        super.finalize();
    }

    public Context m13397g() {
        return this.f11449a.m13351b();
    }

    public C2795e m13398h() {
        return this.f11453e;
    }

    public C2864d m13399i() {
        C2864d c2864d;
        synchronized (this.f11450b) {
            c2864d = this.f11455g;
        }
        return c2864d;
    }

    public C2864d m13400j() {
        C2864d c2864d;
        synchronized (this.f11450b) {
            c2864d = this.f11470v;
        }
        return c2864d;
    }

    public AdSizeParcel m13401k() {
        AdSizeParcel adSizeParcel;
        synchronized (this.f11450b) {
            adSizeParcel = this.f11456h;
        }
        return adSizeParcel;
    }

    public ij m13402l() {
        return this.f11454f;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f11450b) {
            if (m13408r()) {
                C2972b.m11583d("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    C2972b.m11583d("Could not call loadUrl. " + th);
                }
            }
        }
    }

    public boolean m13403m() {
        return this.f11457i;
    }

    public C3326k m13404n() {
        return this.f11451c;
    }

    public VersionInfoParcel m13405o() {
        return this.f11452d;
    }

    protected void onAttachedToWindow() {
        synchronized (this.f11450b) {
            super.onAttachedToWindow();
            if (!m13408r()) {
                this.f11471w.m13166c();
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f11450b) {
            if (!m13408r()) {
                this.f11471w.m13167d();
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            C2968s.m11525e().m13033a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            C2972b.m11576a("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!m13408r()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean D = m13365D();
        C2864d i = m13399i();
        if (i != null && D) {
            i.m11120o();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this.f11450b) {
            if (m13408r()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.f11459k || this.f11456h.f9333i || this.f11456h.f9334j) {
                super.onMeasure(i, i2);
            } else if (this.f11456h.f9329e) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.f11448C.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                int size2 = MeasureSpec.getSize(i2);
                mode = (mode == LinearLayoutManager.INVALID_OFFSET || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == LinearLayoutManager.INVALID_OFFSET || mode2 == 1073741824) {
                    i3 = size2;
                }
                if (this.f11456h.f9331g > mode || this.f11456h.f9328d > r0) {
                    float f = this.f11449a.getResources().getDisplayMetrics().density;
                    C2972b.m11583d("Not enough space to show ad. Needs " + ((int) (((float) this.f11456h.f9331g) / f)) + "x" + ((int) (((float) this.f11456h.f9328d) / f)) + " dp, but only has " + ((int) (((float) size) / f)) + "x" + ((int) (((float) size2) / f)) + " dp.");
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.f11456h.f9331g, this.f11456h.f9328d);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11451c != null) {
            this.f11451c.m13587a(motionEvent);
        }
        return m13408r() ? false : super.onTouchEvent(motionEvent);
    }

    public boolean m13406p() {
        boolean z;
        synchronized (this.f11450b) {
            z = this.f11459k;
        }
        return z;
    }

    public int m13407q() {
        int i;
        synchronized (this.f11450b) {
            i = this.f11462n;
        }
        return i;
    }

    public boolean m13408r() {
        boolean z;
        synchronized (this.f11450b) {
            z = this.f11458j;
        }
        return z;
    }

    public void m13409s() {
        synchronized (this.f11450b) {
            hf.m12982e("Destroying WebView!");
            hj.f11297a.post(new C32871(this));
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f11469u = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof ij) {
            this.f11454f = (ij) webViewClient;
        }
    }

    public void stopLoading() {
        if (!m13408r()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                C2972b.m11580b("Could not stop loading webview.", e);
            }
        }
    }

    public boolean m13410t() {
        boolean z;
        synchronized (this.f11450b) {
            au.m11834a(this.f11468t.m11846a(), this.f11465q, "aebb");
            z = this.f11463o;
        }
        return z;
    }

    public String m13411u() {
        String str;
        synchronized (this.f11450b) {
            str = this.f11464p;
        }
        return str;
    }

    public ih m13412v() {
        return null;
    }

    public aw m13413w() {
        return this.f11467s;
    }

    public ay m13414x() {
        return this.f11468t;
    }

    public void m13415y() {
        this.f11471w.m13163a();
    }

    public void m13416z() {
        if (this.f11467s == null) {
            this.f11467s = au.m11831a(this.f11468t.m11846a());
            this.f11468t.m11847a("native:view_load", this.f11467s);
        }
    }
}
