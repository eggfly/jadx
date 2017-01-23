package com.google.android.gms.p146b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C2810h;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.q */
public abstract class C3364q implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object f11711a;
    protected final C3365s f11712b;
    BroadcastReceiver f11713c;
    private final WeakReference<gx> f11714d;
    private WeakReference<ViewTreeObserver> f11715e;
    private final C3359y f11716f;
    private final Context f11717g;
    private final WindowManager f11718h;
    private final PowerManager f11719i;
    private final KeyguardManager f11720j;
    private C3366u f11721k;
    private boolean f11722l;
    private boolean f11723m;
    private boolean f11724n;
    private boolean f11725o;
    private boolean f11726p;
    private boolean f11727q;
    private final HashSet<C3283r> f11728r;
    private hr f11729s;
    private final cb f11730t;
    private final cb f11731u;
    private final cb f11732v;

    /* renamed from: com.google.android.gms.b.q.1 */
    class C33551 extends BroadcastReceiver {
        final /* synthetic */ C3364q f11701a;

        C33551(C3364q c3364q) {
            this.f11701a = c3364q;
        }

        public void onReceive(Context context, Intent intent) {
            this.f11701a.m13851b(false);
        }
    }

    /* renamed from: com.google.android.gms.b.q.2 */
    class C33562 implements cb {
        final /* synthetic */ C3364q f11702a;

        C33562(C3364q c3364q) {
            this.f11702a = c3364q;
        }

        public void m13820a(ii iiVar, Map<String, String> map) {
            if (this.f11702a.m13847a((Map) map)) {
                this.f11702a.m13841a(iiVar.m13233b(), (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.q.3 */
    class C33573 implements cb {
        final /* synthetic */ C3364q f11703a;

        C33573(C3364q c3364q) {
            this.f11703a = c3364q;
        }

        public void m13821a(ii iiVar, Map<String, String> map) {
            if (this.f11703a.m13847a((Map) map)) {
                C2972b.m11576a("Received request to untrack: " + this.f11703a.f11712b.m13869d());
                this.f11703a.m13852c();
            }
        }
    }

    /* renamed from: com.google.android.gms.b.q.4 */
    class C33584 implements cb {
        final /* synthetic */ C3364q f11704a;

        C33584(C3364q c3364q) {
            this.f11704a = c3364q;
        }

        public void m13822a(ii iiVar, Map<String, String> map) {
            if (this.f11704a.m13847a((Map) map) && map.containsKey("isVisible")) {
                boolean z = MessageService.MSG_DB_NOTIFY_REACHED.equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.f11704a.m13846a(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    /* renamed from: com.google.android.gms.b.q.a */
    public static class C3360a implements C3359y {
        private WeakReference<C2810h> f11705a;

        public C3360a(C2810h c2810h) {
            this.f11705a = new WeakReference(c2810h);
        }

        public View m13826a() {
            C2810h c2810h = (C2810h) this.f11705a.get();
            return c2810h != null ? c2810h.m10868e() : null;
        }

        public boolean m13827b() {
            return this.f11705a.get() == null;
        }

        public C3359y m13828c() {
            return new C3361b((C2810h) this.f11705a.get());
        }
    }

    /* renamed from: com.google.android.gms.b.q.b */
    public static class C3361b implements C3359y {
        private C2810h f11706a;

        public C3361b(C2810h c2810h) {
            this.f11706a = c2810h;
        }

        public View m13829a() {
            return this.f11706a.m10868e();
        }

        public boolean m13830b() {
            return this.f11706a == null;
        }

        public C3359y m13831c() {
            return this;
        }
    }

    /* renamed from: com.google.android.gms.b.q.c */
    public static class C3362c implements C3359y {
        private final View f11707a;
        private final gx f11708b;

        public C3362c(View view, gx gxVar) {
            this.f11707a = view;
            this.f11708b = gxVar;
        }

        public View m13832a() {
            return this.f11707a;
        }

        public boolean m13833b() {
            return this.f11708b == null || this.f11707a == null;
        }

        public C3359y m13834c() {
            return this;
        }
    }

    /* renamed from: com.google.android.gms.b.q.d */
    public static class C3363d implements C3359y {
        private final WeakReference<View> f11709a;
        private final WeakReference<gx> f11710b;

        public C3363d(View view, gx gxVar) {
            this.f11709a = new WeakReference(view);
            this.f11710b = new WeakReference(gxVar);
        }

        public View m13835a() {
            return (View) this.f11709a.get();
        }

        public boolean m13836b() {
            return this.f11709a.get() == null || this.f11710b.get() == null;
        }

        public C3359y m13837c() {
            return new C3362c((View) this.f11709a.get(), (gx) this.f11710b.get());
        }
    }

    public C3364q(Context context, AdSizeParcel adSizeParcel, gx gxVar, VersionInfoParcel versionInfoParcel, C3359y c3359y) {
        this.f11711a = new Object();
        this.f11723m = false;
        this.f11724n = false;
        this.f11728r = new HashSet();
        this.f11730t = new C33562(this);
        this.f11731u = new C33573(this);
        this.f11732v = new C33584(this);
        this.f11714d = new WeakReference(gxVar);
        this.f11716f = c3359y;
        this.f11715e = new WeakReference(null);
        this.f11725o = true;
        this.f11727q = false;
        this.f11729s = new hr(200);
        this.f11712b = new C3365s(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.f9326b, gxVar.f11187j, gxVar.m12914a(), adSizeParcel.f9333i);
        this.f11718h = (WindowManager) context.getSystemService("window");
        this.f11719i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f11720j = (KeyguardManager) context.getSystemService("keyguard");
        this.f11717g = context;
    }

    protected int m13838a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected JSONObject m13839a(View view) {
        if (view == null) {
            return m13860k();
        }
        boolean a = C2968s.m11527g().m13086a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            C2972b.m11580b("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f11718h.getDefaultDisplay().getWidth();
        rect2.bottom = this.f11718h.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject i = m13858i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", m13838a(rect2.top, displayMetrics)).put("bottom", m13838a(rect2.bottom, displayMetrics)).put("left", m13838a(rect2.left, displayMetrics)).put("right", m13838a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m13838a(rect.top, displayMetrics)).put("bottom", m13838a(rect.bottom, displayMetrics)).put("left", m13838a(rect.left, displayMetrics)).put("right", m13838a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m13838a(rect3.top, displayMetrics)).put("bottom", m13838a(rect3.bottom, displayMetrics)).put("left", m13838a(rect3.left, displayMetrics)).put("right", m13838a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m13838a(rect4.top, displayMetrics)).put("bottom", m13838a(rect4.bottom, displayMetrics)).put("left", m13838a(rect4.left, displayMetrics)).put("right", m13838a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m13838a(rect5.top, displayMetrics)).put("bottom", m13838a(rect5.bottom, displayMetrics)).put("left", m13838a(rect5.left, displayMetrics)).put("right", m13838a(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", C2968s.m11525e().m13047a(view, this.f11719i, this.f11720j));
        return i;
    }

    protected void m13840a() {
        synchronized (this.f11711a) {
            if (this.f11713c != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f11713c = new C33551(this);
            this.f11717g.registerReceiver(this.f11713c, intentFilter);
        }
    }

    protected void m13841a(View view, Map<String, String> map) {
        m13851b(false);
    }

    protected void m13842a(de deVar) {
        deVar.m12202a("/updateActiveView", this.f11730t);
        deVar.m12202a("/untrackActiveViewUnit", this.f11731u);
        deVar.m12202a("/visibilityChanged", this.f11732v);
    }

    public void m13843a(C3283r c3283r) {
        this.f11728r.add(c3283r);
    }

    public void m13844a(C3366u c3366u) {
        synchronized (this.f11711a) {
            this.f11721k = c3366u;
        }
    }

    protected void m13845a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            m13850b(jSONObject2);
        } catch (Throwable th) {
            C2972b.m11580b("Skipping active view message.", th);
        }
    }

    protected void m13846a(boolean z) {
        Iterator it = this.f11728r.iterator();
        while (it.hasNext()) {
            ((C3283r) it.next()).m13218a(this, z);
        }
    }

    protected boolean m13847a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.f11712b.m13869d());
        return z;
    }

    protected void m13848b() {
        synchronized (this.f11711a) {
            if (this.f11713c != null) {
                try {
                    this.f11717g.unregisterReceiver(this.f11713c);
                } catch (Throwable e) {
                    C2972b.m11580b("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    C2968s.m11528h().m12941a(e2, true);
                }
                this.f11713c = null;
            }
        }
    }

    protected void m13849b(de deVar) {
        deVar.m12205b("/visibilityChanged", this.f11732v);
        deVar.m12205b("/untrackActiveViewUnit", this.f11731u);
        deVar.m12205b("/updateActiveView", this.f11730t);
    }

    protected abstract void m13850b(JSONObject jSONObject);

    protected void m13851b(boolean z) {
        synchronized (this.f11711a) {
            if (m13859j() && this.f11725o) {
                View a = this.f11716f.m13823a();
                boolean z2 = a != null && C2968s.m11525e().m13047a(a, this.f11719i, this.f11720j) && a.getGlobalVisibleRect(new Rect(), null);
                if (z && !this.f11729s.m13157a() && z2 == this.f11727q) {
                    return;
                }
                this.f11727q = z2;
                if (this.f11716f.m13824b()) {
                    m13853d();
                    return;
                }
                try {
                    m13845a(m13839a(a));
                } catch (JSONException e) {
                    Throwable e2 = e;
                    C2972b.m11577a("Active view update failed.", e2);
                    m13856g();
                    m13854e();
                    return;
                } catch (RuntimeException e3) {
                    e2 = e3;
                    C2972b.m11577a("Active view update failed.", e2);
                    m13856g();
                    m13854e();
                    return;
                }
                m13856g();
                m13854e();
                return;
            }
        }
    }

    protected void m13852c() {
        synchronized (this.f11711a) {
            m13857h();
            m13848b();
            this.f11725o = false;
            m13854e();
        }
    }

    public void m13853d() {
        synchronized (this.f11711a) {
            if (this.f11725o) {
                this.f11726p = true;
                try {
                    m13845a(m13862m());
                } catch (Throwable e) {
                    C2972b.m11580b("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    C2972b.m11580b("Failure while processing active view data.", e2);
                }
                C2972b.m11576a("Untracking ad unit: " + this.f11712b.m13869d());
            }
        }
    }

    protected void m13854e() {
        if (this.f11721k != null) {
            this.f11721k.m13872a(this);
        }
    }

    public boolean m13855f() {
        boolean z;
        synchronized (this.f11711a) {
            z = this.f11725o;
        }
        return z;
    }

    protected void m13856g() {
        View a = this.f11716f.m13825c().m13823a();
        if (a != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f11715e.get();
            ViewTreeObserver viewTreeObserver2 = a.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                m13857h();
                if (!this.f11722l || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.f11722l = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.f11715e = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void m13857h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f11715e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject m13858i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f11712b.m13867b()).put("activeViewJSON", this.f11712b.m13868c()).put("timestamp", C2968s.m11529i().m13544b()).put("adFormat", this.f11712b.m13866a()).put("hashCode", this.f11712b.m13869d()).put("isMraid", this.f11712b.m13870e()).put("isStopped", this.f11724n).put("isPaused", this.f11723m).put("isScreenOn", m13861l()).put("isNative", this.f11712b.m13871f());
        return jSONObject;
    }

    protected abstract boolean m13859j();

    protected JSONObject m13860k() {
        return m13858i().put("isAttachedToWindow", false).put("isScreenOn", m13861l()).put("isVisible", false);
    }

    boolean m13861l() {
        return this.f11719i.isScreenOn();
    }

    protected JSONObject m13862m() {
        JSONObject i = m13858i();
        i.put("doneReasonCode", "u");
        return i;
    }

    public void m13863n() {
        synchronized (this.f11711a) {
            this.f11724n = true;
            m13851b(false);
        }
    }

    public void m13864o() {
        synchronized (this.f11711a) {
            this.f11723m = true;
            m13851b(false);
        }
    }

    public void onGlobalLayout() {
        m13851b(false);
    }

    public void onScrollChanged() {
        m13851b(true);
    }

    public void m13865p() {
        synchronized (this.f11711a) {
            this.f11723m = false;
            m13851b(false);
        }
    }
}
