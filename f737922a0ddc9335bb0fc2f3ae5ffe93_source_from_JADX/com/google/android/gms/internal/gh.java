package com.google.android.gms.internal;

public class gh<T> {
    public final com.google.android.gms.internal.aa.a DW;
    public final hp FH;
    public boolean Hw;
    public final T j6;

    public interface a {
        void j6(hp hpVar);
    }

    public interface b<T> {
        void j6(T t);
    }

    private gh(hp hpVar) {
        this.Hw = false;
        this.j6 = null;
        this.DW = null;
        this.FH = hpVar;
    }

    private gh(T t, com.google.android.gms.internal.aa.a aVar) {
        this.Hw = false;
        this.j6 = t;
        this.DW = aVar;
        this.FH = null;
    }

    public static <T> gh<T> j6(hp hpVar) {
        return new gh(hpVar);
    }

    public static <T> gh<T> j6(T t, com.google.android.gms.internal.aa.a aVar) {
        return new gh(t, aVar);
    }

    public boolean j6() {
        return this.FH == null;
    }
}
