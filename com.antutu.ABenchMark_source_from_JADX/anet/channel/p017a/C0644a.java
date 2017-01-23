package anet.channel.p017a;

import anet.channel.p017a.C0646b.C0645a;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: anet.channel.a.a */
public class C0644a implements Comparable<C0644a> {
    final byte[] f2171a;
    int f2172b;
    int f2173c;

    private C0644a(byte[] bArr, int i) {
        if (bArr == null) {
            bArr = new byte[i];
        }
        this.f2171a = bArr;
        this.f2172b = this.f2171a.length;
        this.f2173c = i;
    }

    public static C0644a m2753a(int i) {
        return new C0644a(null, i);
    }

    public static C0644a m2754a(byte[] bArr) {
        return bArr == null ? null : C0644a.m2755a(bArr, bArr.length);
    }

    public static C0644a m2755a(byte[] bArr, int i) {
        return (bArr == null || i <= 0) ? null : new C0644a(bArr, i);
    }

    public int m2756a(C0644a c0644a) {
        return this.f2172b == c0644a.f2172b ? this.f2171a == null ? -1 : c0644a.f2171a == null ? 1 : hashCode() - c0644a.hashCode() : this.f2172b - c0644a.f2172b;
    }

    public int m2757a(InputStream inputStream) {
        int i = 0;
        int read = inputStream.read(this.f2171a, 0, this.f2172b);
        if (read != -1) {
            i = read;
        }
        this.f2173c = i;
        return read;
    }

    public void m2758a(OutputStream outputStream) {
        outputStream.write(this.f2171a, 0, this.f2173c);
    }

    public byte[] m2759a() {
        return this.f2171a;
    }

    public int m2760b() {
        return this.f2172b;
    }

    public int m2761c() {
        return this.f2173c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2756a((C0644a) obj);
    }

    public void m2762d() {
        if (this.f2172b != 0) {
            C0645a.f2174a.m2765a(this);
        }
    }
}
