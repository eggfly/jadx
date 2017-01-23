package com.google.android.gms.common.api.p155a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3427c.C3406d;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3430j.C3400a;
import com.google.android.gms.common.internal.C3468n;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3477g.C3476a;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import com.google.android.gms.signin.internal.C3415b;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.common.api.a.f */
public class C3418f implements C3403i {
    private final C3430j f11870a;
    private final Lock f11871b;
    private final Context f11872c;
    private final C3457f f11873d;
    private ConnectionResult f11874e;
    private int f11875f;
    private int f11876g;
    private int f11877h;
    private final Bundle f11878i;
    private final Set<C3388d> f11879j;
    private kc f11880k;
    private int f11881l;
    private boolean f11882m;
    private boolean f11883n;
    private C3468n f11884o;
    private boolean f11885p;
    private boolean f11886q;
    private final C3477g f11887r;
    private final Map<C3444a<?>, Integer> f11888s;
    private final C3327b<? extends kc, kd> f11889t;
    private ArrayList<Future<?>> f11890u;

    /* renamed from: com.google.android.gms.common.api.a.f.1 */
    class C34051 implements Runnable {
        final /* synthetic */ C3418f f11854a;

        C34051(C3418f c3418f) {
            this.f11854a = c3418f;
        }

        public void run() {
            this.f11854a.f11873d.m14277b(this.f11854a.f11872c);
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.a */
    private static class C3407a implements C3406d {
        private final WeakReference<C3418f> f11855a;
        private final C3444a<?> f11856b;
        private final int f11857c;

        public C3407a(C3418f c3418f, C3444a<?> c3444a, int i) {
            this.f11855a = new WeakReference(c3418f);
            this.f11856b = c3444a;
            this.f11857c = i;
        }

        public void m14050a(ConnectionResult connectionResult) {
            boolean z = false;
            C3418f c3418f = (C3418f) this.f11855a.get();
            if (c3418f != null) {
                if (Looper.myLooper() == c3418f.f11870a.f11934g.m14151a()) {
                    z = true;
                }
                C3512u.m14585a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                c3418f.f11871b.lock();
                try {
                    if (c3418f.m14082b(0)) {
                        if (!connectionResult.m13952b()) {
                            c3418f.m14081b(connectionResult, this.f11856b, this.f11857c);
                        }
                        if (c3418f.m14089d()) {
                            c3418f.m14090e();
                        }
                        c3418f.f11871b.unlock();
                    }
                } finally {
                    c3418f.f11871b.unlock();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.f */
    private abstract class C3409f implements Runnable {
        final /* synthetic */ C3418f f11860b;

        private C3409f(C3418f c3418f) {
            this.f11860b = c3418f;
        }

        protected abstract void m14052a();

        public void run() {
            this.f11860b.f11871b.lock();
            try {
                if (!Thread.interrupted()) {
                    m14052a();
                    this.f11860b.f11871b.unlock();
                }
            } catch (RuntimeException e) {
                this.f11860b.f11870a.m14184a(e);
            } finally {
                this.f11860b.f11871b.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.b */
    private class C3410b extends C3409f {
        final /* synthetic */ C3418f f11861a;
        private final Map<C2924c, C3406d> f11862c;

        /* renamed from: com.google.android.gms.common.api.a.f.b.1 */
        class C34081 extends C3400a {
            final /* synthetic */ ConnectionResult f11858a;
            final /* synthetic */ C3410b f11859b;

            C34081(C3410b c3410b, C3403i c3403i, ConnectionResult connectionResult) {
                this.f11859b = c3410b;
                this.f11858a = connectionResult;
                super(c3403i);
            }

            public void m14051a() {
                this.f11859b.f11861a.m14087c(this.f11858a);
            }
        }

        public C3410b(C3418f c3418f, Map<C2924c, C3406d> map) {
            this.f11861a = c3418f;
            super(null);
            this.f11862c = map;
        }

        public void m14053a() {
            int a = this.f11861a.f11873d.m14271a(this.f11861a.f11872c);
            if (a != 0) {
                this.f11861a.f11870a.m14183a(new C34081(this, this.f11861a, new ConnectionResult(a, null)));
                return;
            }
            if (this.f11861a.f11882m) {
                this.f11861a.f11880k.m13602j();
            }
            for (C2924c c2924c : this.f11862c.keySet()) {
                c2924c.m11348a((C3406d) this.f11862c.get(c2924c));
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.c */
    private class C3411c extends C3409f {
        final /* synthetic */ C3418f f11863a;
        private final ArrayList<C2924c> f11864c;

        public C3411c(C3418f c3418f, ArrayList<C2924c> arrayList) {
            this.f11863a = c3418f;
            super(null);
            this.f11864c = arrayList;
        }

        public void m14054a() {
            this.f11863a.f11870a.f11934g.f11904d = this.f11863a.m14100j();
            Iterator it = this.f11864c.iterator();
            while (it.hasNext()) {
                ((C2924c) it.next()).m11349a(this.f11863a.f11884o, this.f11863a.f11870a.f11934g.f11904d);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.d */
    private static class C3416d extends C3415b {
        private final WeakReference<C3418f> f11868a;

        /* renamed from: com.google.android.gms.common.api.a.f.d.1 */
        class C34121 extends C3400a {
            final /* synthetic */ C3418f f11865a;
            final /* synthetic */ SignInResponse f11866b;
            final /* synthetic */ C3416d f11867c;

            C34121(C3416d c3416d, C3403i c3403i, C3418f c3418f, SignInResponse signInResponse) {
                this.f11867c = c3416d;
                this.f11865a = c3418f;
                this.f11866b = signInResponse;
                super(c3403i);
            }

            public void m14055a() {
                this.f11865a.m14075a(this.f11866b);
            }
        }

        C3416d(C3418f c3418f) {
            this.f11868a = new WeakReference(c3418f);
        }

        public void m14067a(SignInResponse signInResponse) {
            C3418f c3418f = (C3418f) this.f11868a.get();
            if (c3418f != null) {
                c3418f.f11870a.m14183a(new C34121(this, c3418f, c3418f, signInResponse));
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.f.e */
    private class C3417e implements C2921b, C2922c {
        final /* synthetic */ C3418f f11869a;

        private C3417e(C3418f c3418f) {
            this.f11869a = c3418f;
        }

        public void m14068a(int i) {
        }

        public void m14069a(Bundle bundle) {
            this.f11869a.f11880k.m13600a(new C3416d(this.f11869a));
        }

        public void m14070a(ConnectionResult connectionResult) {
            this.f11869a.f11871b.lock();
            try {
                if (this.f11869a.m14083b(connectionResult)) {
                    this.f11869a.m14097h();
                    this.f11869a.m14090e();
                } else {
                    this.f11869a.m14087c(connectionResult);
                }
                this.f11869a.f11871b.unlock();
            } catch (Throwable th) {
                this.f11869a.f11871b.unlock();
            }
        }
    }

    public C3418f(C3430j c3430j, C3477g c3477g, Map<C3444a<?>, Integer> map, C3457f c3457f, C3327b<? extends kc, kd> c3327b, Lock lock, Context context) {
        this.f11876g = 0;
        this.f11878i = new Bundle();
        this.f11879j = new HashSet();
        this.f11890u = new ArrayList();
        this.f11870a = c3430j;
        this.f11887r = c3477g;
        this.f11888s = map;
        this.f11873d = c3457f;
        this.f11889t = c3327b;
        this.f11871b = lock;
        this.f11872c = context;
    }

    private void m14075a(SignInResponse signInResponse) {
        if (m14082b(0)) {
            ConnectionResult a = signInResponse.m14761a();
            if (a.m13952b()) {
                ResolveAccountResponse b = signInResponse.m14762b();
                ConnectionResult b2 = b.m14320b();
                if (b2.m13952b()) {
                    this.f11883n = true;
                    this.f11884o = b.m14319a();
                    this.f11885p = b.m14321c();
                    this.f11886q = b.m14322d();
                    m14090e();
                    return;
                }
                Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + b2, new Exception());
                m14087c(b2);
            } else if (m14083b(a)) {
                m14097h();
                m14090e();
            } else {
                m14087c(a);
            }
        }
    }

    private void m14076a(boolean z) {
        if (this.f11880k != null) {
            if (this.f11880k.m11352e() && z) {
                this.f11880k.m13601c();
            }
            this.f11880k.m11351d();
            this.f11884o = null;
        }
    }

    private boolean m14077a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m14078a(connectionResult)) ? this.f11874e == null || i < this.f11875f : false;
    }

    private boolean m14078a(ConnectionResult connectionResult) {
        return connectionResult.m13951a() || this.f11873d.m14276b(connectionResult.m13953c()) != null;
    }

    private void m14081b(ConnectionResult connectionResult, C3444a<?> c3444a, int i) {
        if (i != 2) {
            int a = c3444a.m14238a().m13591a();
            if (m14077a(a, i, connectionResult)) {
                this.f11874e = connectionResult;
                this.f11875f = a;
            }
        }
        this.f11870a.f11929b.put(c3444a.m14240c(), connectionResult);
    }

    private boolean m14082b(int i) {
        if (this.f11876g == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.f11870a.f11934g.m14173j());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + m14085c(this.f11876g) + " but received callback for step " + m14085c(i), new Exception());
        m14087c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m14083b(ConnectionResult connectionResult) {
        return this.f11881l != 2 ? this.f11881l == 1 && !connectionResult.m13951a() : true;
    }

    private String m14085c(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m14087c(ConnectionResult connectionResult) {
        m14098i();
        m14076a(!connectionResult.m13951a());
        this.f11870a.m14181a(connectionResult);
        this.f11870a.f11935h.m13982a(connectionResult);
    }

    private boolean m14089d() {
        this.f11877h--;
        if (this.f11877h > 0) {
            return false;
        }
        if (this.f11877h < 0) {
            Log.i("GoogleApiClientConnecting", this.f11870a.f11934g.m14173j());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m14087c(new ConnectionResult(8, null));
            return false;
        } else if (this.f11874e == null) {
            return true;
        } else {
            this.f11870a.f11933f = this.f11875f;
            m14087c(this.f11874e);
            return false;
        }
    }

    private void m14090e() {
        if (this.f11877h == 0) {
            if (!this.f11882m || this.f11883n) {
                m14093f();
            }
        }
    }

    private void m14093f() {
        ArrayList arrayList = new ArrayList();
        this.f11876g = 1;
        this.f11877h = this.f11870a.f11928a.size();
        for (C3388d c3388d : this.f11870a.f11928a.keySet()) {
            if (!this.f11870a.f11929b.containsKey(c3388d)) {
                arrayList.add(this.f11870a.f11928a.get(c3388d));
            } else if (m14089d()) {
                m14095g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f11890u.add(C3431k.m14193a().submit(new C3411c(this, arrayList)));
        }
    }

    private void m14095g() {
        this.f11870a.m14191f();
        C3431k.m14193a().execute(new C34051(this));
        if (this.f11880k != null) {
            if (this.f11885p) {
                this.f11880k.m13599a(this.f11884o, this.f11886q);
            }
            m14076a(false);
        }
        for (C3388d c3388d : this.f11870a.f11929b.keySet()) {
            ((C2924c) this.f11870a.f11928a.get(c3388d)).m11351d();
        }
        this.f11870a.f11935h.m13981a(this.f11878i.isEmpty() ? null : this.f11878i);
    }

    private void m14097h() {
        this.f11882m = false;
        this.f11870a.f11934g.f11904d = Collections.emptySet();
        for (C3388d c3388d : this.f11879j) {
            if (!this.f11870a.f11929b.containsKey(c3388d)) {
                this.f11870a.f11929b.put(c3388d, new ConnectionResult(17, null));
            }
        }
    }

    private void m14098i() {
        Iterator it = this.f11890u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f11890u.clear();
    }

    private Set<Scope> m14100j() {
        if (this.f11887r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f11887r.m14347c());
        Map e = this.f11887r.m14349e();
        for (C3444a c3444a : e.keySet()) {
            if (!this.f11870a.f11929b.containsKey(c3444a.m14240c())) {
                hashSet.addAll(((C3476a) e.get(c3444a)).f12056a);
            }
        }
        return hashSet;
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14103a(T t) {
        this.f11870a.f11934g.f11901a.add(t);
        return t;
    }

    public void m14104a() {
        this.f11870a.f11929b.clear();
        this.f11882m = false;
        this.f11874e = null;
        this.f11876g = 0;
        this.f11881l = 2;
        this.f11883n = false;
        this.f11885p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C3444a c3444a : this.f11888s.keySet()) {
            C2924c c2924c = (C2924c) this.f11870a.f11928a.get(c3444a.m14240c());
            int intValue = ((Integer) this.f11888s.get(c3444a)).intValue();
            int i2 = (c3444a.m14238a().m13591a() == 1 ? 1 : 0) | i;
            if (c2924c.m11353f()) {
                this.f11882m = true;
                if (intValue < this.f11881l) {
                    this.f11881l = intValue;
                }
                if (intValue != 0) {
                    this.f11879j.add(c3444a.m14240c());
                }
            }
            hashMap.put(c2924c, new C3407a(this, c3444a, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f11882m = false;
        }
        if (this.f11882m) {
            this.f11887r.m14345a(Integer.valueOf(this.f11870a.f11934g.m14174k()));
            C2921b c3417e = new C3417e();
            this.f11880k = (kc) this.f11889t.m13592a(this.f11872c, this.f11870a.f11934g.m14151a(), this.f11887r, this.f11887r.m14352h(), c3417e, c3417e);
        }
        this.f11877h = this.f11870a.f11928a.size();
        this.f11890u.add(C3431k.m14193a().submit(new C3410b(this, hashMap)));
    }

    public void m14105a(int i) {
        m14087c(new ConnectionResult(8, null));
    }

    public void m14106a(Bundle bundle) {
        if (m14082b(1)) {
            if (bundle != null) {
                this.f11878i.putAll(bundle);
            }
            if (m14089d()) {
                m14095g();
            }
        }
    }

    public void m14107a(ConnectionResult connectionResult, C3444a<?> c3444a, int i) {
        if (m14082b(1)) {
            m14081b(connectionResult, c3444a, i);
            if (m14089d()) {
                m14095g();
            }
        }
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14108b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean m14109b() {
        m14098i();
        m14076a(true);
        this.f11870a.m14181a(null);
        return true;
    }

    public void m14110c() {
    }
}
