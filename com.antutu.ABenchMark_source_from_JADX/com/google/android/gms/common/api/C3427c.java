package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3000a;
import com.google.android.gms.common.api.C3444a.C3000a.C3002c;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.C3444a.C3389e;
import com.google.android.gms.common.api.C3444a.C3390f;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3394c;
import com.google.android.gms.common.api.p155a.C3428h;
import com.google.android.gms.common.api.p155a.C3438r;
import com.google.android.gms.common.api.p155a.C3443s;
import com.google.android.gms.common.internal.C3471b;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3477g.C3476a;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.ka;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.c */
public abstract class C3427c {
    private static final Set<C3427c> f11900a;

    /* renamed from: com.google.android.gms.common.api.c.b */
    public interface C2921b {
        void m11337a(int i);

        void m11338a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.api.c.c */
    public interface C2922c {
        void m11339a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.api.c.d */
    public interface C3406d {
        void m14049a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.api.c.a */
    public static final class C3447a {
        private Account f11979a;
        private final Set<Scope> f11980b;
        private final Set<Scope> f11981c;
        private int f11982d;
        private View f11983e;
        private String f11984f;
        private String f11985g;
        private final Map<C3444a<?>, C3476a> f11986h;
        private final Context f11987i;
        private final Map<C3444a<?>, C3000a> f11988j;
        private FragmentActivity f11989k;
        private int f11990l;
        private C2922c f11991m;
        private Looper f11992n;
        private C3457f f11993o;
        private C3327b<? extends kc, kd> f11994p;
        private final ArrayList<C2921b> f11995q;
        private final ArrayList<C2922c> f11996r;

        /* renamed from: com.google.android.gms.common.api.c.a.1 */
        class C34461 implements Runnable {
            final /* synthetic */ C3427c f11977a;
            final /* synthetic */ C3447a f11978b;

            C34461(C3447a c3447a, C3427c c3427c) {
                this.f11978b = c3447a;
                this.f11977a = c3427c;
            }

            public void run() {
                if (!this.f11978b.f11989k.isFinishing() && !this.f11978b.f11989k.getSupportFragmentManager().isDestroyed()) {
                    this.f11978b.m14247a(C3438r.m14211b(this.f11978b.f11989k), this.f11977a);
                }
            }
        }

        public C3447a(Context context) {
            this.f11980b = new HashSet();
            this.f11981c = new HashSet();
            this.f11986h = new ArrayMap();
            this.f11988j = new ArrayMap();
            this.f11990l = -1;
            this.f11993o = C3457f.m14269a();
            this.f11994p = ka.f11582c;
            this.f11995q = new ArrayList();
            this.f11996r = new ArrayList();
            this.f11987i = context;
            this.f11992n = context.getMainLooper();
            this.f11984f = context.getPackageName();
            this.f11985g = context.getClass().getName();
        }

        private static <C extends C2924c, O> C m14245a(C3327b<C, O> c3327b, Object obj, Context context, Looper looper, C3477g c3477g, C2921b c2921b, C2922c c2922c) {
            return c3327b.m13592a(context, looper, c3477g, obj, c2921b, c2922c);
        }

        private static <C extends C3389e, O> C3471b m14246a(C3390f<C, O> c3390f, Object obj, Context context, Looper looper, C3477g c3477g, C2921b c2921b, C2922c c2922c) {
            return new C3471b(context, looper, c3390f.m13971b(), c2921b, c2922c, c3477g, c3390f.m13970a(obj));
        }

        private void m14247a(C3438r c3438r, C3427c c3427c) {
            c3438r.m14219a(this.f11990l, c3427c, this.f11991m);
        }

        private void m14249a(C3427c c3427c) {
            C3438r a = C3438r.m14206a(this.f11989k);
            if (a == null) {
                new Handler(this.f11987i.getMainLooper()).post(new C34461(this, c3427c));
            } else {
                m14247a(a, c3427c);
            }
        }

        private C3427c m14250c() {
            C3477g a = m14252a();
            C3444a c3444a = null;
            Map e = a.m14349e();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            C3444a c3444a2 = null;
            for (C3444a c3444a3 : this.f11988j.keySet()) {
                C3444a c3444a32;
                C2924c a2;
                C3444a c3444a4;
                Object obj = this.f11988j.get(c3444a32);
                int i = 0;
                if (e.get(c3444a32) != null) {
                    i = ((C3476a) e.get(c3444a32)).f12057b ? 1 : 2;
                }
                arrayMap.put(c3444a32, Integer.valueOf(i));
                C2921b c3394c = new C3394c(c3444a32, i);
                arrayList.add(c3394c);
                C3444a c3444a5;
                if (c3444a32.m14241d()) {
                    C3390f b = c3444a32.m14239b();
                    c3444a5 = b.m13969a() == 1 ? c3444a32 : c3444a2;
                    a2 = C3447a.m14246a(b, obj, this.f11987i, this.f11992n, a, c3394c, (C2922c) c3394c);
                    c3444a4 = c3444a5;
                } else {
                    C3327b a3 = c3444a32.m14238a();
                    c3444a5 = a3.m13591a() == 1 ? c3444a32 : c3444a2;
                    a2 = C3447a.m14245a(a3, obj, this.f11987i, this.f11992n, a, c3394c, (C2922c) c3394c);
                    c3444a4 = c3444a5;
                }
                arrayMap2.put(c3444a32.m14240c(), a2);
                if (!a2.m11354g()) {
                    c3444a32 = c3444a;
                } else if (c3444a != null) {
                    throw new IllegalStateException(c3444a32.m14242e() + " cannot be used with " + c3444a.m14242e());
                }
                c3444a2 = c3444a4;
                c3444a = c3444a32;
            }
            if (c3444a != null) {
                if (c3444a2 != null) {
                    throw new IllegalStateException(c3444a.m14242e() + " cannot be used with " + c3444a2.m14242e());
                }
                C3512u.m14586a(this.f11979a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c3444a.m14242e());
                C3512u.m14586a(this.f11980b.equals(this.f11981c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c3444a.m14242e());
            }
            return new C3428h(this.f11987i, new ReentrantLock(), this.f11992n, a, this.f11993o, this.f11994p, arrayMap, this.f11995q, this.f11996r, arrayMap2, this.f11990l, C3428h.m14141a(arrayMap2.values(), true), arrayList);
        }

        public C3447a m14251a(C3444a<? extends C3002c> c3444a) {
            C3512u.m14581a((Object) c3444a, (Object) "Api must not be null");
            this.f11988j.put(c3444a, null);
            Collection a = c3444a.m14238a().m13593a(null);
            this.f11981c.addAll(a);
            this.f11980b.addAll(a);
            return this;
        }

        public C3477g m14252a() {
            kd kdVar = kd.f11595a;
            if (this.f11988j.containsKey(ka.f11586g)) {
                kdVar = (kd) this.f11988j.get(ka.f11586g);
            }
            return new C3477g(this.f11979a, this.f11980b, this.f11986h, this.f11982d, this.f11983e, this.f11984f, this.f11985g, kdVar);
        }

        public C3427c m14253b() {
            C3512u.m14589b(!this.f11988j.isEmpty(), "must call addApi() to add at least one API");
            C3427c c = m14250c();
            synchronized (C3427c.f11900a) {
                C3427c.f11900a.add(c);
            }
            if (this.f11990l >= 0) {
                m14249a(c);
            }
            return c;
        }
    }

    static {
        f11900a = Collections.newSetFromMap(new WeakHashMap());
    }

    public Looper m14129a() {
        throw new UnsupportedOperationException();
    }

    public <C extends C2924c> C m14130a(C3388d<C> c3388d) {
        throw new UnsupportedOperationException();
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14131a(T t) {
        throw new UnsupportedOperationException();
    }

    public void m14132a(int i) {
        throw new UnsupportedOperationException();
    }

    public void m14133a(C3443s c3443s) {
        throw new UnsupportedOperationException();
    }

    public abstract void m14134a(C2922c c2922c);

    public abstract void m14135a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14136b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void m14137b();

    public void m14138b(C3443s c3443s) {
        throw new UnsupportedOperationException();
    }

    public abstract void m14139b(C2922c c2922c);

    public abstract void m14140c();
}
