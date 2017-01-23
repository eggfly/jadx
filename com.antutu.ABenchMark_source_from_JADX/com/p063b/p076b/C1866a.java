package com.p063b.p076b;

/* renamed from: com.b.b.a */
public abstract class C1866a<T> extends C1865c<T, Float> {
    public C1866a(String str) {
        super(Float.class, str);
    }

    public abstract void m6999a(T t, float f);

    public final void m7000a(T t, Float f) {
        m6999a((Object) t, f.floatValue());
    }
}
