package com.google.android.gms.p146b;

import java.util.Arrays;

/* renamed from: com.google.android.gms.b.ko */
final class ko {
    final int f11628a;
    final byte[] f11629b;

    int m13707a() {
        return (0 + kg.m13643f(this.f11628a)) + this.f11629b.length;
    }

    void m13708a(kg kgVar) {
        kgVar.m13668e(this.f11628a);
        kgVar.m13667d(this.f11629b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ko)) {
            return false;
        }
        ko koVar = (ko) obj;
        return this.f11628a == koVar.f11628a && Arrays.equals(this.f11629b, koVar.f11629b);
    }

    public int hashCode() {
        return ((this.f11628a + 527) * 31) + Arrays.hashCode(this.f11629b);
    }
}
