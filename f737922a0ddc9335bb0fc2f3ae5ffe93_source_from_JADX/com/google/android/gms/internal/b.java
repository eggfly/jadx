package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;

public class b extends ByteArrayOutputStream {
    private final hz j6;

    public b(hz hzVar, int i) {
        this.j6 = hzVar;
        this.buf = this.j6.j6(Math.max(i, 256));
    }

    private void j6(int i) {
        if (this.count + i > this.buf.length) {
            Object j6 = this.j6.j6((this.count + i) * 2);
            System.arraycopy(this.buf, 0, j6, 0, this.count);
            this.j6.j6(this.buf);
            this.buf = j6;
        }
    }

    public void close() {
        this.j6.j6(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.j6.j6(this.buf);
    }

    public synchronized void write(int i) {
        j6(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        j6(i2);
        super.write(bArr, i, i2);
    }
}
