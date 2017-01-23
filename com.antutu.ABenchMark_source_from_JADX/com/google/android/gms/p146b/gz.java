package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.p146b.hh.C3234b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

@gb
/* renamed from: com.google.android.gms.b.gz */
public class gz implements C3234b {
    private final Object f11218a;
    private final String f11219b;
    private final ha f11220c;
    private C3367t f11221d;
    private BigInteger f11222e;
    private final HashSet<gy> f11223f;
    private final HashMap<String, hc> f11224g;
    private boolean f11225h;
    private boolean f11226i;
    private int f11227j;
    private boolean f11228k;
    private Context f11229l;
    private VersionInfoParcel f11230m;
    private as f11231n;
    private boolean f11232o;
    private ab f11233p;
    private ac f11234q;
    private aa f11235r;
    private String f11236s;
    private final LinkedList<Thread> f11237t;
    private final ga f11238u;
    private Boolean f11239v;
    private String f11240w;
    private boolean f11241x;
    private boolean f11242y;

    public gz(hj hjVar) {
        this.f11218a = new Object();
        this.f11222e = BigInteger.ONE;
        this.f11223f = new HashSet();
        this.f11224g = new HashMap();
        this.f11225h = false;
        this.f11226i = true;
        this.f11227j = 0;
        this.f11228k = false;
        this.f11231n = null;
        this.f11232o = true;
        this.f11233p = null;
        this.f11234q = null;
        this.f11235r = null;
        this.f11237t = new LinkedList();
        this.f11238u = null;
        this.f11239v = null;
        this.f11241x = false;
        this.f11242y = false;
        this.f11219b = hjVar.m13058c();
        this.f11220c = new ha(this.f11219b);
    }

    public Bundle m12929a(Context context, hb hbVar, String str) {
        Bundle bundle;
        synchronized (this.f11218a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f11220c.m12971a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f11224g.keySet()) {
                bundle2.putBundle(str2, ((hc) this.f11224g.get(str2)).m12975a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f11223f.iterator();
            while (it.hasNext()) {
                arrayList.add(((gy) it.next()).m12927d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            hbVar.m10420a(this.f11223f);
            this.f11223f.clear();
        }
        return bundle;
    }

    public ac m12930a(Context context) {
        if (!((Boolean) aq.f10270J.m11794c()).booleanValue() || !jq.m13569b() || m12945b()) {
            return null;
        }
        synchronized (this.f11218a) {
            if (this.f11233p == null) {
                if (context instanceof Activity) {
                    this.f11233p = new ab((Application) context.getApplicationContext(), (Activity) context);
                } else {
                    return null;
                }
            }
            if (this.f11235r == null) {
                this.f11235r = new aa();
            }
            if (this.f11234q == null) {
                this.f11234q = new ac(this.f11233p, this.f11235r, new ga(this.f11229l, this.f11230m, null, null));
            }
            this.f11234q.m11739a();
            ac acVar = this.f11234q;
            return acVar;
        }
    }

    public String m12931a() {
        return this.f11219b;
    }

    public String m12932a(int i, String str) {
        Resources resources = this.f11230m.f10084e ? this.f11229l.getResources() : C3465h.m14298c(this.f11229l);
        return resources == null ? str : resources.getString(i);
    }

    public Future m12933a(Context context, boolean z) {
        Future a;
        synchronized (this.f11218a) {
            if (z != this.f11226i) {
                this.f11226i = z;
                a = hh.m12996a(context, z);
            } else {
                a = null;
            }
        }
        return a;
    }

    public Future m12934a(String str) {
        Future a;
        synchronized (this.f11218a) {
            if (str != null) {
                if (!str.equals(this.f11236s)) {
                    this.f11236s = str;
                    a = hh.m12995a(this.f11229l, str);
                }
            }
            a = null;
        }
        return a;
    }

    @TargetApi(23)
    public void m12935a(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.f11218a) {
            if (!this.f11228k) {
                this.f11229l = context.getApplicationContext();
                this.f11230m = versionInfoParcel;
                hh.m12994a(context, (C3234b) this);
                hh.m12997b(context, (C3234b) this);
                hh.m12999c(context, this);
                hh.m13000d(context, this);
                m12940a(Thread.currentThread());
                this.f11240w = C2968s.m11525e().m13024a(context, versionInfoParcel.f10081b);
                if (jq.m13576i() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f11242y = true;
                }
                this.f11221d = new C3367t(context.getApplicationContext(), this.f11230m, new dd(context.getApplicationContext(), this.f11230m, (String) aq.f10288b.m11794c()));
                m12957n();
                C2968s.m11535o().m11256a(this.f11229l);
                this.f11228k = true;
            }
        }
    }

    public void m12936a(Bundle bundle) {
        synchronized (this.f11218a) {
            this.f11226i = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.f11226i;
            this.f11227j = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.f11227j;
            if (bundle.containsKey("content_url_opted_out")) {
                m12943a(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f11236s = bundle.getString("content_url_hashes");
            }
        }
    }

    public void m12937a(gy gyVar) {
        synchronized (this.f11218a) {
            this.f11223f.add(gyVar);
        }
    }

    public void m12938a(Boolean bool) {
        synchronized (this.f11218a) {
            this.f11239v = bool;
        }
    }

    public void m12939a(String str, hc hcVar) {
        synchronized (this.f11218a) {
            this.f11224g.put(str, hcVar);
        }
    }

    public void m12940a(Thread thread) {
        ga.m12802a(this.f11229l, thread, this.f11230m);
    }

    public void m12941a(Throwable th, boolean z) {
        new ga(this.f11229l, this.f11230m, null, null).m12806a(th, z);
    }

    public void m12942a(HashSet<gy> hashSet) {
        synchronized (this.f11218a) {
            this.f11223f.addAll(hashSet);
        }
    }

    public void m12943a(boolean z) {
        synchronized (this.f11218a) {
            if (this.f11232o != z) {
                hh.m12998b(this.f11229l, z);
            }
            this.f11232o = z;
            ac a = m12930a(this.f11229l);
            if (!(a == null || a.isAlive())) {
                C2972b.m11581c("start fetching content...");
                a.m11739a();
            }
        }
    }

    public void m12944b(boolean z) {
        synchronized (this.f11218a) {
            this.f11241x = z;
        }
    }

    public boolean m12945b() {
        boolean z;
        synchronized (this.f11218a) {
            z = this.f11232o;
        }
        return z;
    }

    public String m12946c() {
        String bigInteger;
        synchronized (this.f11218a) {
            bigInteger = this.f11222e.toString();
            this.f11222e = this.f11222e.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public ha m12947d() {
        ha haVar;
        synchronized (this.f11218a) {
            haVar = this.f11220c;
        }
        return haVar;
    }

    public as m12948e() {
        as asVar;
        synchronized (this.f11218a) {
            asVar = this.f11231n;
        }
        return asVar;
    }

    public boolean m12949f() {
        boolean z;
        synchronized (this.f11218a) {
            z = this.f11225h;
            this.f11225h = true;
        }
        return z;
    }

    public boolean m12950g() {
        boolean z;
        synchronized (this.f11218a) {
            z = this.f11226i || this.f11242y;
        }
        return z;
    }

    public String m12951h() {
        String str;
        synchronized (this.f11218a) {
            str = this.f11240w;
        }
        return str;
    }

    public String m12952i() {
        String str;
        synchronized (this.f11218a) {
            str = this.f11236s;
        }
        return str;
    }

    public Boolean m12953j() {
        Boolean bool;
        synchronized (this.f11218a) {
            bool = this.f11239v;
        }
        return bool;
    }

    public C3367t m12954k() {
        return this.f11221d;
    }

    public boolean m12955l() {
        boolean z;
        synchronized (this.f11218a) {
            if (this.f11227j < ((Integer) aq.aa.m11794c()).intValue()) {
                this.f11227j = ((Integer) aq.aa.m11794c()).intValue();
                hh.m12993a(this.f11229l, this.f11227j);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m12956m() {
        boolean z;
        synchronized (this.f11218a) {
            z = this.f11241x;
        }
        return z;
    }

    void m12957n() {
        try {
            this.f11231n = C2968s.m11530j().m11830a(new ar(this.f11229l, this.f11230m.f10081b));
        } catch (Throwable e) {
            C2972b.m11584d("Cannot initialize CSI reporter.", e);
        }
    }
}
