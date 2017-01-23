package com.github.mikephil.charting.p145i;

/* renamed from: com.github.mikephil.charting.i.a */
public final class C2615a {
    public final float f9065a;
    public final float f9066b;

    public C2615a(float f, float f2) {
        this.f9065a = f;
        this.f9066b = f2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2615a)) {
            return false;
        }
        C2615a c2615a = (C2615a) obj;
        if (!(this.f9065a == c2615a.f9065a && this.f9066b == c2615a.f9066b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f9065a) ^ Float.floatToIntBits(this.f9066b);
    }

    public String toString() {
        return this.f9065a + "x" + this.f9066b;
    }
}
