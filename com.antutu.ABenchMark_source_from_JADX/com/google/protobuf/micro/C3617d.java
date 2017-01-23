package com.google.protobuf.micro;

import java.io.IOException;

/* renamed from: com.google.protobuf.micro.d */
public abstract class C3617d {
    public abstract int m14873a();

    public abstract C3617d m14874a(C3613a c3613a);

    public C3617d m14875a(byte[] bArr) {
        return m14879b(bArr, 0, bArr.length);
    }

    public abstract void m14876a(C3615b c3615b);

    public void m14877a(byte[] bArr, int i, int i2) {
        try {
            C3615b a = C3615b.m14837a(bArr, i, i2);
            m14876a(a);
            a.m14862c();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    protected boolean m14878a(C3613a c3613a, int i) {
        return c3613a.m14823b(i);
    }

    public C3617d m14879b(byte[] bArr, int i, int i2) {
        try {
            C3613a a = C3613a.m14817a(bArr, i, i2);
            m14874a(a);
            a.m14821a(0);
            return this;
        } catch (C3616c e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public byte[] m14880b() {
        byte[] bArr = new byte[m14873a()];
        m14877a(bArr, 0, bArr.length);
        return bArr;
    }
}
