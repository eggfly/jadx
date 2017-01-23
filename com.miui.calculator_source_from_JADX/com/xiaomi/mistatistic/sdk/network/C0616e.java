package com.xiaomi.mistatistic.sdk.network;

import java.io.InputStream;

/* renamed from: com.xiaomi.mistatistic.sdk.network.e */
final class C0616e extends InputStream {
    private InputStream f4875a;
    private C0613c f4876b;
    private C0615d f4877c;
    private int f4878d;

    public C0616e(C0613c c0613c, InputStream inputStream) {
        this.f4878d = 0;
        this.f4876b = c0613c;
        this.f4875a = inputStream;
    }

    public C0616e(C0615d c0615d, InputStream inputStream) {
        this.f4878d = 0;
        this.f4877c = c0615d;
        this.f4875a = inputStream;
    }

    public int available() {
        try {
            return this.f4875a.available();
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public void close() {
        if (this.f4876b != null) {
            this.f4876b.m6593a();
        }
        if (this.f4877c != null) {
            this.f4877c.m6604a();
        }
        try {
            this.f4875a.close();
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public void mark(int i) {
        this.f4875a.mark(i);
    }

    public boolean markSupported() {
        return this.f4875a.markSupported();
    }

    public int read() {
        try {
            int read = this.f4875a.read();
            if (read != -1) {
                this.f4878d++;
            }
            return read;
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public int read(byte[] bArr) {
        try {
            int read = this.f4875a.read(bArr);
            if (read != -1) {
                this.f4878d += read;
            }
            return read;
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            int read = this.f4875a.read(bArr, i, i2);
            if (read != -1) {
                this.f4878d += read;
            }
            return read;
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public synchronized void reset() {
        try {
            this.f4875a.reset();
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    public long skip(long j) {
        try {
            return this.f4875a.skip(j);
        } catch (Exception e) {
            m6608a(e);
            throw e;
        }
    }

    private void m6608a(Exception exception) {
        if (this.f4876b != null) {
            this.f4876b.m6595a(exception);
        }
        if (this.f4877c != null) {
            this.f4877c.m6606a(exception);
        }
    }

    public int m6609a() {
        return this.f4878d;
    }
}
