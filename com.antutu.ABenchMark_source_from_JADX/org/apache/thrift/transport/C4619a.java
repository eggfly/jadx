package org.apache.thrift.transport;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: org.apache.thrift.transport.a */
public class C4619a extends C4618d {
    protected InputStream f16493a;
    protected OutputStream f16494b;

    protected C4619a() {
        this.f16493a = null;
        this.f16494b = null;
    }

    public C4619a(OutputStream outputStream) {
        this.f16493a = null;
        this.f16494b = null;
        this.f16494b = outputStream;
    }

    public int m19392a(byte[] bArr, int i, int i2) {
        if (this.f16493a == null) {
            throw new C4622e(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f16493a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C4622e(4);
        } catch (Throwable e) {
            throw new C4622e(0, e);
        }
    }

    public void m19393b(byte[] bArr, int i, int i2) {
        if (this.f16494b == null) {
            throw new C4622e(1, "Cannot write to null outputStream");
        }
        try {
            this.f16494b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new C4622e(0, e);
        }
    }
}
