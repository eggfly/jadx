package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v;
import java.util.Set;

public final class a<O extends a> {
    private final i<?, O> DW;
    private final g<?> FH;
    private final j<?> Hw;
    private final b<?, O> j6;
    private final String v5;

    public interface a {

        public interface a extends a {
        }

        public interface c extends a {
        }

        public interface d extends a, c {
        }

        public static final class b implements c {
            private b() {
            }
        }
    }

    public static abstract class e<T extends c, O> {
    }

    public static abstract class b<T extends f, O> extends e<T, O> {
        public abstract T j6(Context context, Looper looper, n nVar, O o, com.google.android.gms.common.api.GoogleApiClient.a aVar, com.google.android.gms.common.api.GoogleApiClient.b bVar);
    }

    public interface c {
    }

    public static class d<C extends c> {
    }

    public interface f extends c {
        boolean DW();

        boolean FH();

        boolean Hw();

        void j6();

        void j6(com.google.android.gms.common.internal.k.f fVar);

        void j6(v vVar, Set<Scope> set);

        IBinder v5();
    }

    public static final class g<C extends f> extends d<C> {
    }

    public interface h<T extends IInterface> extends c {
        String DW();

        T j6(IBinder iBinder);

        String j6();

        void j6(int i, T t);
    }

    public static abstract class i<T extends h, O> extends e<T, O> {
        public abstract int j6();

        public abstract T j6(O o);
    }

    public static final class j<C extends h> extends d<C> {
    }

    public <C extends f> a(String str, b<C, O> bVar, g<C> gVar) {
        com.google.android.gms.common.internal.b.j6((Object) bVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        com.google.android.gms.common.internal.b.j6((Object) gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.v5 = str;
        this.j6 = bVar;
        this.DW = null;
        this.FH = gVar;
        this.Hw = null;
    }

    public i<?, O> DW() {
        com.google.android.gms.common.internal.b.j6(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public d<?> FH() {
        if (this.FH != null) {
            return this.FH;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean Hw() {
        return false;
    }

    public b<?, O> j6() {
        com.google.android.gms.common.internal.b.j6(this.j6 != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.j6;
    }

    public String v5() {
        return this.v5;
    }
}
