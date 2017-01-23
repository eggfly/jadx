package com.xiaomi.mistatistic.sdk.network;

import java.io.OutputStream;

/* renamed from: com.xiaomi.mistatistic.sdk.network.f */
final class C0617f extends OutputStream {
    private OutputStream f4879a;
    private C0613c f4880b;
    private C0615d f4881c;
    private int f4882d;

    public C0617f(C0613c c0613c, OutputStream outputStream) {
        this.f4882d = 0;
        this.f4879a = outputStream;
        this.f4880b = c0613c;
    }

    public C0617f(C0615d c0615d, OutputStream outputStream) {
        this.f4882d = 0;
        this.f4879a = outputStream;
        this.f4881c = c0615d;
    }

    public void close() {
        try {
            this.f4879a.close();
        } catch (Exception e) {
            m6610a(e);
            throw e;
        }
    }

    public void flush() {
        try {
            this.f4879a.flush();
        } catch (Exception e) {
            m6610a(e);
            throw e;
        }
    }

    public void write(byte[] bArr) {
        try {
            this.f4879a.write(bArr);
            this.f4882d += bArr.length;
        } catch (Exception e) {
            m6610a(e);
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.f4879a.write(bArr, i, i2);
            this.f4882d += i2;
        } catch (Exception e) {
            m6610a(e);
            throw e;
        }
    }

    public void write(int i) {
        try {
            this.f4879a.write(i);
            this.f4882d++;
        } catch (Exception e) {
            m6610a(e);
            throw e;
        }
    }

    private void m6610a(Exception exception) {
        if (this.f4880b != null) {
            this.f4880b.m6595a(exception);
        }
        if (this.f4881c != null) {
            this.f4881c.m6606a(exception);
        }
    }

    public int m6611a() {
        return this.f4882d;
    }
}
