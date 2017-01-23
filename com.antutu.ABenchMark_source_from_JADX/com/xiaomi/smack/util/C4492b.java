package com.xiaomi.smack.util;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.b */
public class C4492b extends Writer {
    Writer f15456a;
    List f15457b;

    public C4492b(Writer writer) {
        this.f15456a = null;
        this.f15457b = new ArrayList();
        this.f15456a = writer;
    }

    private void m18631a(String str) {
        synchronized (this.f15457b) {
            C4334l[] c4334lArr = new C4334l[this.f15457b.size()];
            this.f15457b.toArray(c4334lArr);
        }
        for (C4334l a : c4334lArr) {
            a.m17765a(str);
        }
    }

    public void m18632a(C4334l c4334l) {
        if (c4334l != null) {
            synchronized (this.f15457b) {
                if (!this.f15457b.contains(c4334l)) {
                    this.f15457b.add(c4334l);
                }
            }
        }
    }

    public void m18633b(C4334l c4334l) {
        synchronized (this.f15457b) {
            this.f15457b.remove(c4334l);
        }
    }

    public void close() {
        this.f15456a.close();
    }

    public void flush() {
        this.f15456a.flush();
    }

    public void write(int i) {
        this.f15456a.write(i);
    }

    public void write(String str) {
        this.f15456a.write(str);
        m18631a(str);
    }

    public void write(String str, int i, int i2) {
        this.f15456a.write(str, i, i2);
        m18631a(str.substring(i, i + i2));
    }

    public void write(char[] cArr) {
        this.f15456a.write(cArr);
        m18631a(new String(cArr));
    }

    public void write(char[] cArr, int i, int i2) {
        this.f15456a.write(cArr, i, i2);
        m18631a(new String(cArr, i, i2));
    }
}
