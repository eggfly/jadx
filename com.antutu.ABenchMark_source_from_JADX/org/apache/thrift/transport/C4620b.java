package org.apache.thrift.transport;

import org.apache.thrift.C4595d;

/* renamed from: org.apache.thrift.transport.b */
public class C4620b extends C4618d {
    private C4595d f16495a;
    private int f16496b;

    public C4620b(int i) {
        this.f16495a = new C4595d(i);
    }

    public int m19394a(byte[] bArr, int i, int i2) {
        Object a = this.f16495a.m19297a();
        if (i2 > this.f16495a.m19298b() - this.f16496b) {
            i2 = this.f16495a.m19298b() - this.f16496b;
        }
        if (i2 > 0) {
            System.arraycopy(a, this.f16496b, bArr, i, i2);
            this.f16496b += i2;
        }
        return i2;
    }

    public int a_() {
        return this.f16495a.size();
    }

    public void m19395b(byte[] bArr, int i, int i2) {
        this.f16495a.write(bArr, i, i2);
    }
}
