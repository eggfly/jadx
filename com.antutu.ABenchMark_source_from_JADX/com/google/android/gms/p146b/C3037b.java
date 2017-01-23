package com.google.android.gms.p146b;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.b.b */
public class C3037b extends ByteArrayOutputStream {
    private final ks f10351a;

    public C3037b(ks ksVar, int i) {
        this.f10351a = ksVar;
        this.buf = this.f10351a.m13736a(Math.max(i, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY));
    }

    private void m11860a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f10351a.m13736a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f10351a.m13735a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f10351a.m13735a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f10351a.m13735a(this.buf);
    }

    public synchronized void write(int i) {
        m11860a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m11860a(i2);
        super.write(bArr, i, i2);
    }
}
