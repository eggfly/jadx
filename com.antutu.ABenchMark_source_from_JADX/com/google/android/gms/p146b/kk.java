package com.google.android.gms.p146b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.b.kk */
class kk implements Cloneable {
    private ki<?, ?> f11624a;
    private Object f11625b;
    private List<ko> f11626c;

    kk() {
        this.f11626c = new ArrayList();
    }

    private byte[] m13688c() {
        byte[] bArr = new byte[m13689a()];
        m13690a(kg.m13622a(bArr));
        return bArr;
    }

    int m13689a() {
        if (this.f11625b != null) {
            return this.f11624a.m13673a(this.f11625b);
        }
        int i = 0;
        for (ko a : this.f11626c) {
            i = a.m13707a() + i;
        }
        return i;
    }

    void m13690a(kg kgVar) {
        if (this.f11625b != null) {
            this.f11624a.m13674a(this.f11625b, kgVar);
            return;
        }
        for (ko a : this.f11626c) {
            a.m13708a(kgVar);
        }
    }

    public final kk m13691b() {
        int i = 0;
        kk kkVar = new kk();
        try {
            kkVar.f11624a = this.f11624a;
            if (this.f11626c == null) {
                kkVar.f11626c = null;
            } else {
                kkVar.f11626c.addAll(this.f11626c);
            }
            if (this.f11625b != null) {
                if (this.f11625b instanceof km) {
                    kkVar.f11625b = ((km) this.f11625b).d_();
                } else if (this.f11625b instanceof byte[]) {
                    kkVar.f11625b = ((byte[]) this.f11625b).clone();
                } else if (this.f11625b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f11625b;
                    Object obj = new byte[bArr.length][];
                    kkVar.f11625b = obj;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        obj[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.f11625b instanceof boolean[]) {
                    kkVar.f11625b = ((boolean[]) this.f11625b).clone();
                } else if (this.f11625b instanceof int[]) {
                    kkVar.f11625b = ((int[]) this.f11625b).clone();
                } else if (this.f11625b instanceof long[]) {
                    kkVar.f11625b = ((long[]) this.f11625b).clone();
                } else if (this.f11625b instanceof float[]) {
                    kkVar.f11625b = ((float[]) this.f11625b).clone();
                } else if (this.f11625b instanceof double[]) {
                    kkVar.f11625b = ((double[]) this.f11625b).clone();
                } else if (this.f11625b instanceof km[]) {
                    km[] kmVarArr = (km[]) this.f11625b;
                    Object obj2 = new km[kmVarArr.length];
                    kkVar.f11625b = obj2;
                    while (i < kmVarArr.length) {
                        obj2[i] = kmVarArr[i].d_();
                        i++;
                    }
                }
            }
            return kkVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m13691b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kk)) {
            return false;
        }
        kk kkVar = (kk) obj;
        if (this.f11625b != null && kkVar.f11625b != null) {
            return this.f11624a == kkVar.f11624a ? !this.f11624a.f11616b.isArray() ? this.f11625b.equals(kkVar.f11625b) : this.f11625b instanceof byte[] ? Arrays.equals((byte[]) this.f11625b, (byte[]) kkVar.f11625b) : this.f11625b instanceof int[] ? Arrays.equals((int[]) this.f11625b, (int[]) kkVar.f11625b) : this.f11625b instanceof long[] ? Arrays.equals((long[]) this.f11625b, (long[]) kkVar.f11625b) : this.f11625b instanceof float[] ? Arrays.equals((float[]) this.f11625b, (float[]) kkVar.f11625b) : this.f11625b instanceof double[] ? Arrays.equals((double[]) this.f11625b, (double[]) kkVar.f11625b) : this.f11625b instanceof boolean[] ? Arrays.equals((boolean[]) this.f11625b, (boolean[]) kkVar.f11625b) : Arrays.deepEquals((Object[]) this.f11625b, (Object[]) kkVar.f11625b) : false;
        } else {
            if (this.f11626c != null && kkVar.f11626c != null) {
                return this.f11626c.equals(kkVar.f11626c);
            }
            try {
                return Arrays.equals(m13688c(), kkVar.m13688c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m13688c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
