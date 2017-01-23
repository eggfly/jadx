package com.p063b.p076b;

/* renamed from: com.b.b.c */
public abstract class C1865c<T, V> {
    private final String f6391a;
    private final Class<V> f6392b;

    public C1865c(Class<V> cls, String str) {
        this.f6391a = str;
        this.f6392b = cls;
    }

    public abstract V m6996a(T t);

    public String m6997a() {
        return this.f6391a;
    }

    public void m6998a(T t, V v) {
        throw new UnsupportedOperationException("Property " + m6997a() + " is read-only");
    }
}
