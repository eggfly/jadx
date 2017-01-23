package com.google.android.gms.p146b;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.b.w */
public interface C3345w {

    /* renamed from: com.google.android.gms.b.w.a */
    public static class C3369a {
        public byte[] f11746a;
        public String f11747b;
        public long f11748c;
        public long f11749d;
        public long f11750e;
        public long f11751f;
        public Map<String, String> f11752g;

        public C3369a() {
            this.f11752g = Collections.emptyMap();
        }

        public boolean m13888a() {
            return this.f11750e < System.currentTimeMillis();
        }

        public boolean m13889b() {
            return this.f11751f < System.currentTimeMillis();
        }
    }

    C3369a m13741a(String str);

    void m13742a();

    void m13743a(String str, C3369a c3369a);
}
