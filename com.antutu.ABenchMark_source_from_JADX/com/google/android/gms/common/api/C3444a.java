package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3427c.C3406d;
import com.google.android.gms.common.internal.C3468n;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3512u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.a */
public final class C3444a<O extends C3000a> {
    private final C3327b<?, O> f11972a;
    private final C3390f<?, O> f11973b;
    private final C3388d<?> f11974c;
    private final C3391g<?> f11975d;
    private final String f11976e;

    /* renamed from: com.google.android.gms.common.api.a.c */
    public interface C2924c {
        void m11348a(C3406d c3406d);

        void m11349a(C3468n c3468n, Set<Scope> set);

        void m11350a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        void m11351d();

        boolean m11352e();

        boolean m11353f();

        boolean m11354g();

        Intent m11355h();

        IBinder m11356i();
    }

    /* renamed from: com.google.android.gms.common.api.a.a */
    public interface C3000a {

        /* renamed from: com.google.android.gms.common.api.a.a.a */
        public interface C3001a extends C3000a {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.c */
        public interface C3002c extends C3000a {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.d */
        public interface C3003d extends C3001a, C3002c {
        }

        /* renamed from: com.google.android.gms.common.api.a.a.b */
        public static final class C3387b implements C3002c {
            private C3387b() {
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static abstract class C3327b<T extends C2924c, O> {
        public int m13591a() {
            return Integer.MAX_VALUE;
        }

        public abstract T m13592a(Context context, Looper looper, C3477g c3477g, O o, C2921b c2921b, C2922c c2922c);

        public List<Scope> m13593a(O o) {
            return Collections.emptyList();
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.d */
    public static final class C3388d<C extends C2924c> {
    }

    /* renamed from: com.google.android.gms.common.api.a.e */
    public interface C3389e<T extends IInterface> {
        T m13965a(IBinder iBinder);

        String m13966a();

        void m13967a(int i, T t);

        String m13968b();
    }

    /* renamed from: com.google.android.gms.common.api.a.f */
    public interface C3390f<T extends C3389e, O> {
        int m13969a();

        T m13970a(O o);

        int m13971b();
    }

    /* renamed from: com.google.android.gms.common.api.a.g */
    public static final class C3391g<C extends C3389e> {
    }

    public <C extends C2924c> C3444a(String str, C3327b<C, O> c3327b, C3388d<C> c3388d) {
        C3512u.m14581a((Object) c3327b, (Object) "Cannot construct an Api with a null ClientBuilder");
        C3512u.m14581a((Object) c3388d, (Object) "Cannot construct an Api with a null ClientKey");
        this.f11976e = str;
        this.f11972a = c3327b;
        this.f11973b = null;
        this.f11974c = c3388d;
        this.f11975d = null;
    }

    public C3327b<?, O> m14238a() {
        C3512u.m14585a(this.f11972a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f11972a;
    }

    public C3390f<?, O> m14239b() {
        C3512u.m14585a(this.f11973b != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.f11973b;
    }

    public C3388d<?> m14240c() {
        C3512u.m14585a(this.f11974c != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.f11974c;
    }

    public boolean m14241d() {
        return this.f11975d != null;
    }

    public String m14242e() {
        return this.f11976e;
    }
}
