package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C4156a;
import com.umeng.analytics.C4164c;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.a.m */
public class C0884m {
    private List<C0882k> f2958a;
    private Context f2959b;

    public C0884m(Context context) {
        this.f2958a = new ArrayList();
        this.f2959b = null;
        this.f2959b = context;
    }

    private void m3917c(C0909w c0909w) {
        synchronized (this) {
            for (C0882k a : this.f2958a) {
                a.m3912a(c0909w);
            }
            SharedPreferences a2 = C0888r.m3932a(this.f2959b);
            if (a2 == null) {
                return;
            }
            Object string = a2.getString(C4156a.f13938A, BuildConfig.FLAVOR);
            if (!TextUtils.isEmpty(string)) {
                c0909w.f3095b.f3034j = string;
            }
            this.f2958a.clear();
            if (C0909w.f3093c != 0) {
                c0909w.f3095b.f3028d.f2990a = C0909w.f3093c;
            }
            ci.m3705a(this.f2959b).m3734a(c0909w);
            String[] a3 = C4164c.m17013a(this.f2959b);
            if (!(a3 == null || TextUtils.isEmpty(a3[0]) || TextUtils.isEmpty(a3[1]))) {
                c0909w.f3095b.f3031g.f2991a = a3[0];
                c0909w.f3095b.f3031g.f2992b = a3[1];
            }
            C0910x.m3983a(this.f2959b).m3989a(c0909w);
        }
    }

    public synchronized int m3918a() {
        int size;
        size = this.f2958a.size();
        if (C0909w.f3093c != 0) {
            size++;
        }
        return size;
    }

    public synchronized void m3919a(C0882k c0882k) {
        this.f2958a.add(c0882k);
    }

    public void m3920a(C0909w c0909w) {
        if (C0891t.m3953g(this.f2959b) != null) {
            m3921b(c0909w);
            m3917c(c0909w);
        }
    }

    void m3921b(C0909w c0909w) {
        String[] h;
        c0909w.f3094a.f3055a = AnalyticsConfig.getAppkey(this.f2959b);
        c0909w.f3094a.f3056b = AnalyticsConfig.getChannel(this.f2959b);
        c0909w.f3094a.f3057c = an.m3370a(AnalyticsConfig.getSecretKey(this.f2959b));
        c0909w.f3094a.f3067m = AnalyticsConfig.getVerticalType(this.f2959b);
        c0909w.f3094a.f3066l = AnalyticsConfig.getSDKVersion(this.f2959b);
        c0909w.f3094a.f3059e = am.m3360r(this.f2959b);
        SharedPreferences a = C0888r.m3932a(this.f2959b);
        a.edit();
        int parseInt = Integer.parseInt(am.m3332a(this.f2959b));
        String b = am.m3339b(this.f2959b);
        if (a == null) {
            c0909w.f3094a.f3062h = parseInt;
            c0909w.f3094a.f3058d = b;
        } else {
            c0909w.f3094a.f3062h = a.getInt(C4156a.f13963y, 0);
            c0909w.f3094a.f3058d = a.getString(C4156a.f13964z, BuildConfig.FLAVOR);
        }
        c0909w.f3094a.f3060f = am.m3361s(this.f2959b);
        c0909w.f3094a.f3061g = am.m3363u(this.f2959b);
        if (!(AnalyticsConfig.mWrapperType == null || AnalyticsConfig.mWrapperVersion == null)) {
            c0909w.f3094a.f3063i = AnalyticsConfig.mWrapperType;
            c0909w.f3094a.f3064j = AnalyticsConfig.mWrapperVersion;
        }
        c0909w.f3094a.f3079y = am.m3342c(this.f2959b);
        c0909w.f3094a.f3073s = am.m3344d(this.f2959b);
        c0909w.f3094a.f3078x = am.m3357o(this.f2959b);
        c0909w.f3094a.f3041G = am.m3364v(this.f2959b);
        c0909w.f3094a.f3042H = am.m3365w(this.f2959b);
        int[] p = am.m3358p(this.f2959b);
        if (p != null) {
            c0909w.f3094a.f3077w = p[1] + "*" + p[0];
        }
        if (AnalyticsConfig.GPU_RENDERER == null || AnalyticsConfig.GPU_VENDER != null) {
            h = am.m3350h(this.f2959b);
        } else {
            h = am.m3350h(this.f2959b);
        }
        if ("Wi-Fi".equals(h[0])) {
            c0909w.f3094a.f3047M = UtilityImpl.NET_TYPE_WIFI;
        } else if ("2G/3G".equals(h[0])) {
            c0909w.f3094a.f3047M = "2G/3G";
        } else {
            c0909w.f3094a.f3047M = "unknow";
        }
        if (!BuildConfig.FLAVOR.equals(h[1])) {
            c0909w.f3094a.f3048N = h[1];
        }
        Object e = am.m3345e(this.f2959b);
        if (!TextUtils.isEmpty(e)) {
            c0909w.f3094a.f3049O = e;
        }
        c0909w.f3094a.f3046L = am.m3349g(this.f2959b);
        h = am.m3355m(this.f2959b);
        c0909w.f3094a.f3045K = h[0];
        c0909w.f3094a.f3044J = h[1];
        c0909w.f3094a.f3043I = (long) am.m3353k(this.f2959b);
        C0892u.m3961a(this.f2959b, c0909w);
        try {
            aw b2 = cr.m3793a(this.f2959b).m3799b();
            if (b2 != null) {
                byte[] a2 = new bb().m3488a(b2);
                c0909w.f3094a.f3054T = Base64.encodeToString(a2, 0);
                try {
                    b2 = ct.m3820a(this.f2959b).m3824a();
                    if (b2 == null) {
                        ap.m3391d("trans the imprint is null");
                        return;
                    }
                    a2 = new bb().m3488a(b2);
                    c0909w.f3094a.f3053S = Base64.encodeToString(a2, 0);
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
    }
}
