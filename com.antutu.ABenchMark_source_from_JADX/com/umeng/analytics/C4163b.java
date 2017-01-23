package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.analytics.MobclickAgent.UMAnalyticsConfig;
import com.umeng.analytics.social.C4188e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;
import p023b.p024a.C0867e;
import p023b.p024a.C0877g;
import p023b.p024a.C0878h;
import p023b.p024a.C0881i;
import p023b.p024a.C0882k;
import p023b.p024a.C0887p;
import p023b.p024a.C0888r;
import p023b.p024a.C0891t;
import p023b.p024a.C0893v;
import p023b.p024a.C0909w.C0901h;
import p023b.p024a.ak;
import p023b.p024a.am;
import p023b.p024a.ao;
import p023b.p024a.ap;
import p023b.p024a.aq;
import p023b.p024a.as;
import p023b.p024a.cd;
import p023b.p024a.ci;

/* renamed from: com.umeng.analytics.b */
public class C4163b implements C0887p {
    private static final String f13975j = "sp";
    private Context f13976a;
    private ao f13977b;
    private C0878h f13978c;
    private C0893v f13979d;
    private C0891t f13980e;
    private C0881i f13981f;
    private C0877g f13982g;
    private C0867e f13983h;
    private ci f13984i;
    private boolean f13985k;
    private boolean f13986l;
    private JSONObject f13987m;
    private boolean f13988n;

    /* renamed from: com.umeng.analytics.b.1 */
    class C41581 extends as {
        final /* synthetic */ C4163b f13966a;

        /* renamed from: com.umeng.analytics.b.1.1 */
        class C41571 extends cd {
            final /* synthetic */ C41581 f13965a;

            C41571(C41581 c41581) {
                this.f13965a = c41581;
            }

            public void m16959a(Object obj, boolean z) {
                this.f13965a.f13966a.f13986l = true;
            }
        }

        C41581(C4163b c4163b) {
            this.f13966a = c4163b;
        }

        public void m16960a() {
            this.f13966a.f13984i.m3732a(new C41571(this));
        }
    }

    /* renamed from: com.umeng.analytics.b.2 */
    class C41592 extends as {
        final /* synthetic */ Context f13967a;
        final /* synthetic */ C4163b f13968b;

        C41592(C4163b c4163b, Context context) {
            this.f13968b = c4163b;
            this.f13967a = context;
        }

        public void m16961a() {
            this.f13968b.m16971h(this.f13967a.getApplicationContext());
        }
    }

    /* renamed from: com.umeng.analytics.b.3 */
    class C41603 extends as {
        final /* synthetic */ Context f13969a;
        final /* synthetic */ C4163b f13970b;

        C41603(C4163b c4163b, Context context) {
            this.f13970b = c4163b;
            this.f13969a = context;
        }

        public void m16962a() {
            this.f13970b.m16972i(this.f13969a.getApplicationContext());
            this.f13970b.f13984i.m3738c();
        }
    }

    /* renamed from: com.umeng.analytics.b.4 */
    class C41614 extends as {
        final /* synthetic */ String f13971a;
        final /* synthetic */ String f13972b;
        final /* synthetic */ C4163b f13973c;

        C41614(C4163b c4163b, String str, String str2) {
            this.f13973c = c4163b;
            this.f13971a = str;
            this.f13972b = str2;
        }

        public void m16963a() {
            String[] a = C4164c.m17013a(this.f13973c.f13976a);
            if (a == null || !this.f13971a.equals(a[0]) || !this.f13972b.equals(a[1])) {
                boolean e = this.f13973c.m16974a().m3958e(this.f13973c.f13976a);
                C0877g.m3887b(this.f13973c.f13976a).m3893c();
                if (e) {
                    this.f13973c.m16974a().m3959f(this.f13973c.f13976a);
                }
                C4164c.m17012a(this.f13973c.f13976a, this.f13971a, this.f13972b);
            }
        }
    }

    /* renamed from: com.umeng.analytics.b.5 */
    class C41625 extends as {
        final /* synthetic */ C4163b f13974a;

        C41625(C4163b c4163b) {
            this.f13974a = c4163b;
        }

        public void m16964a() {
            String[] a = C4164c.m17013a(this.f13974a.f13976a);
            if (a != null && !TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
                boolean e = this.f13974a.m16974a().m3958e(this.f13974a.f13976a);
                C0877g.m3887b(this.f13974a.f13976a).m3893c();
                if (e) {
                    this.f13974a.m16974a().m3959f(this.f13974a.f13976a);
                }
                C4164c.m17014b(this.f13974a.f13976a);
            }
        }
    }

    C4163b() {
        this.f13976a = null;
        this.f13978c = new C0878h();
        this.f13979d = new C0893v();
        this.f13980e = new C0891t();
        this.f13981f = null;
        this.f13982g = null;
        this.f13983h = null;
        this.f13984i = null;
        this.f13985k = false;
        this.f13986l = false;
        this.f13987m = null;
        this.f13988n = false;
        this.f13978c.m3895a((C0887p) this);
    }

    private void m16970g(Context context) {
        if (context != null) {
            try {
                if (VERSION.SDK_INT > 13 && !this.f13988n && (context instanceof Activity)) {
                    this.f13983h = new C0867e((Activity) context);
                    this.f13988n = true;
                }
                if (!this.f13985k) {
                    this.f13976a = context.getApplicationContext();
                    this.f13981f = new C0881i(this.f13976a);
                    this.f13982g = C0877g.m3887b(this.f13976a);
                    this.f13985k = true;
                    if (this.f13984i == null) {
                        this.f13984i = ci.m3705a(this.f13976a);
                    }
                    if (!this.f13986l) {
                        aq.m3396b(new C41581(this));
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void m16971h(Context context) {
        this.f13980e.m3956c(context);
        if (this.f13977b != null) {
            this.f13977b.m3378a();
        }
    }

    private void m16972i(Context context) {
        this.f13980e.m3957d(context);
        this.f13979d.m3976a(context);
        this.f13983h.m3844a(context);
        if (this.f13977b != null) {
            this.f13977b.m3379b();
        }
        this.f13982g.m3891b();
    }

    private JSONObject m16973j(Context context) {
        try {
            Object string = C0888r.m3932a(context).getString(f13975j, null);
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public C0891t m16974a() {
        return this.f13980e;
    }

    void m16975a(double d, double d2) {
        if (AnalyticsConfig.f13927a == null) {
            AnalyticsConfig.f13927a = new double[2];
        }
        AnalyticsConfig.f13927a[0] = d;
        AnalyticsConfig.f13927a[1] = d2;
    }

    void m16976a(long j) {
        AnalyticsConfig.sLatentWindow = ((int) j) * AdError.NETWORK_ERROR_CODE;
    }

    void m16977a(Context context) {
        if (context == null) {
            ap.m3391d("unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f13979d.m3977a(context.getClass().getName());
        }
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            aq.m3394a(new C41592(this, context));
        } catch (Throwable e) {
            ap.m3383a("Exception occurred in Mobclick.onResume(). ", e);
        }
    }

    public void m16978a(Context context, int i) {
        AnalyticsConfig.m16954a(context, i);
    }

    void m16979a(Context context, EScenarioType eScenarioType) {
        if (context != null) {
            this.f13976a = context.getApplicationContext();
        }
        if (eScenarioType != null) {
            m16978a(context, eScenarioType.toValue());
        }
    }

    void m16980a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                ap.m3391d("unexpected null context in reportError");
                return;
            }
            try {
                if (!(this.f13985k && this.f13988n)) {
                    m16970g(context);
                }
                C0882k c0901h = new C0901h();
                c0901h.f3008a = System.currentTimeMillis();
                c0901h.f3009b = 2;
                c0901h.f3010c = str;
                this.f13982g.m3890a(c0901h);
            } catch (Throwable e) {
                ap.m3385a(e);
            }
        }
    }

    public void m16981a(Context context, String str, Object obj) {
    }

    public void m16982a(Context context, String str, String str2, long j, int i) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13981f.m3908a(str, str2, j, i);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    public void m16983a(Context context, String str, HashMap<String, Object> hashMap) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13981f.m3909a(str, (Map) hashMap);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    public void m16984a(Context context, String str, Map<String, Object> map) {
    }

    void m16985a(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13981f.m3910a(str, (Map) map, j);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    void m16986a(Context context, Throwable th) {
        if (context != null && th != null) {
            try {
                m16980a(context, ak.m3321a(th));
            } catch (Throwable e) {
                ap.m3385a(e);
            }
        }
    }

    public void m16987a(Context context, List<String> list) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13981f.m3907a(context, (List) list);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    public void m16988a(Context context, List<String> list, int i, String str) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13981f.m3911a((List) list, i, str);
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    public void m16989a(ao aoVar) {
        this.f13977b = aoVar;
    }

    void m16990a(UMAnalyticsConfig uMAnalyticsConfig) {
        if (uMAnalyticsConfig.mContext != null) {
            this.f13976a = uMAnalyticsConfig.mContext.getApplicationContext();
        }
        if (TextUtils.isEmpty(uMAnalyticsConfig.mAppkey)) {
            ap.m3391d("the appkey is null!");
            return;
        }
        AnalyticsConfig.m16955a(uMAnalyticsConfig.mContext, uMAnalyticsConfig.mAppkey);
        if (!TextUtils.isEmpty(uMAnalyticsConfig.mChannelId)) {
            AnalyticsConfig.m16956a(uMAnalyticsConfig.mChannelId);
        }
        AnalyticsConfig.CATCH_EXCEPTION = uMAnalyticsConfig.mIsCrashEnable;
        m16979a(this.f13976a, uMAnalyticsConfig.mType);
    }

    void m16991a(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f13979d.m3977a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m16992a(String str, String str2) {
        AnalyticsConfig.mWrapperType = str;
        AnalyticsConfig.mWrapperVersion = str2;
    }

    public void m16993a(Throwable th) {
        try {
            this.f13979d.m3975a();
            if (this.f13976a != null) {
                if (!(th == null || this.f13982g == null)) {
                    C0882k c0901h = new C0901h();
                    c0901h.f3008a = System.currentTimeMillis();
                    c0901h.f3009b = 1;
                    c0901h.f3010c = ak.m3321a(th);
                    this.f13982g.m3890a(c0901h);
                }
                this.f13983h.m3845b(this.f13976a);
                this.f13984i.m3736b();
                m16972i(this.f13976a);
                C0888r.m3932a(this.f13976a).edit().commit();
            }
            aq.m3393a();
        } catch (Throwable e) {
            ap.m3383a("Exception in onAppCrash", e);
        }
    }

    void m16994a(GL10 gl10) {
        String[] a = am.m3337a(gl10);
        if (a.length == 2) {
            AnalyticsConfig.GPU_VENDER = a[0];
            AnalyticsConfig.GPU_RENDERER = a[1];
        }
    }

    void m16995a(boolean z) {
        AnalyticsConfig.CATCH_EXCEPTION = z;
    }

    void m16996b() {
        try {
            aq.m3394a(new C41625(this));
        } catch (Throwable e) {
            ap.m3383a(" Excepthon  in  onProfileSignOff", e);
        }
    }

    void m16997b(long j) {
        AnalyticsConfig.kContinueSessionMillis = j;
    }

    void m16998b(Context context) {
        if (context == null) {
            ap.m3391d("unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f13979d.m3978b(context.getClass().getName());
        }
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            aq.m3394a(new C41603(this, context));
        } catch (Throwable e) {
            ap.m3383a("Exception occurred in Mobclick.onRause(). ", e);
        }
    }

    void m16999b(Context context, String str) {
        if (context != null) {
            this.f13976a = context.getApplicationContext();
        }
        AnalyticsConfig.m16958b(context, str);
    }

    void m17000b(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f13979d.m3978b(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void m17001b(String str, String str2) {
        try {
            aq.m3394a(new C41614(this, str, str2));
        } catch (Throwable e) {
            ap.m3383a(" Excepthon  in  onProfileSignIn", e);
        }
    }

    void m17002b(boolean z) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = z;
    }

    void m17003c(Context context) {
        try {
            if (!(this.f13985k && this.f13988n)) {
                m16970g(context);
            }
            this.f13982g.m3889a();
        } catch (Throwable e) {
            ap.m3385a(e);
        }
    }

    public void m17004c(Context context, String str) {
    }

    void m17005c(boolean z) {
        C4156a.f13943e = z;
    }

    public Object m17006d(Context context, String str) {
        return null;
    }

    void m17007d(Context context) {
        try {
            this.f13983h.m3845b(context);
            this.f13979d.m3975a();
            m16972i(context);
            C0888r.m3932a(context).edit().commit();
            this.f13984i.m3730a();
            aq.m3393a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void m17008d(boolean z) {
        ap.f2680a = z;
        C4188e.f14079v = z;
    }

    public String m17009e(Context context) {
        return null;
    }

    void m17010e(boolean z) {
        AnalyticsConfig.m16957a(z);
    }

    public void m17011f(Context context) {
    }
}
