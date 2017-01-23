package com.google.android.gms.p146b;

import com.google.android.gms.p146b.C3345w.C3369a;

/* renamed from: com.google.android.gms.b.jb */
public class jb<T> {
    public final T f11557a;
    public final C3369a f11558b;
    public final jz f11559c;
    public boolean f11560d;

    /* renamed from: com.google.android.gms.b.jb.a */
    public interface C3268a {
        void m13139a(jz jzVar);
    }

    /* renamed from: com.google.android.gms.b.jb.b */
    public interface C3273b<T> {
        void m13146a(T t);
    }

    private jb(jz jzVar) {
        this.f11560d = false;
        this.f11557a = null;
        this.f11558b = null;
        this.f11559c = jzVar;
    }

    private jb(T t, C3369a c3369a) {
        this.f11560d = false;
        this.f11557a = t;
        this.f11558b = c3369a;
        this.f11559c = null;
    }

    public static <T> jb<T> m13528a(jz jzVar) {
        return new jb(jzVar);
    }

    public static <T> jb<T> m13529a(T t, C3369a c3369a) {
        return new jb(t, c3369a);
    }

    public boolean m13530a() {
        return this.f11559c == null;
    }
}
