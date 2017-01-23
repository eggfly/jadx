package p023b.p024a;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: b.a.by */
public class by extends ca {
    protected InputStream f2794a;
    protected OutputStream f2795b;

    protected by() {
        this.f2794a = null;
        this.f2795b = null;
    }

    public by(OutputStream outputStream) {
        this.f2794a = null;
        this.f2795b = null;
        this.f2795b = outputStream;
    }

    public int m3634a(byte[] bArr, int i, int i2) {
        if (this.f2794a == null) {
            throw new cb(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f2794a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new cb(4);
        } catch (Throwable e) {
            throw new cb(0, e);
        }
    }

    public void m3635b(byte[] bArr, int i, int i2) {
        if (this.f2795b == null) {
            throw new cb(1, "Cannot write to null outputStream");
        }
        try {
            this.f2795b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new cb(0, e);
        }
    }
}
