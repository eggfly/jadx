package com.xiaomi.smack.util;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.a */
public class C4491a extends Reader {
    Reader f15454a;
    List f15455b;

    public C4491a(Reader reader) {
        this.f15454a = null;
        this.f15455b = new ArrayList();
        this.f15454a = reader;
    }

    public void m18629a(C4332f c4332f) {
        if (c4332f != null) {
            synchronized (this.f15455b) {
                if (!this.f15455b.contains(c4332f)) {
                    this.f15455b.add(c4332f);
                }
            }
        }
    }

    public void m18630b(C4332f c4332f) {
        synchronized (this.f15455b) {
            this.f15455b.remove(c4332f);
        }
    }

    public void close() {
        this.f15454a.close();
    }

    public void mark(int i) {
        this.f15454a.mark(i);
    }

    public boolean markSupported() {
        return this.f15454a.markSupported();
    }

    public int read() {
        return this.f15454a.read();
    }

    public int read(char[] cArr) {
        return this.f15454a.read(cArr);
    }

    public int read(char[] cArr, int i, int i2) {
        int read = this.f15454a.read(cArr, i, i2);
        if (read > 0) {
            C4332f[] c4332fArr;
            String str = new String(cArr, i, read);
            synchronized (this.f15455b) {
                c4332fArr = new C4332f[this.f15455b.size()];
                this.f15455b.toArray(c4332fArr);
            }
            for (C4332f a : c4332fArr) {
                a.m17763a(str);
            }
        }
        return read;
    }

    public boolean ready() {
        return this.f15454a.ready();
    }

    public void reset() {
        this.f15454a.reset();
    }

    public long skip(long j) {
        return this.f15454a.skip(j);
    }
}
