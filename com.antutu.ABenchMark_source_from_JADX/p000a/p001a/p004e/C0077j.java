package p000a.p001a.p004e;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import org.android.spdy.SpdyProtocol;
import p000a.p001a.C0037c;
import p000a.p001a.p004e.C0052d.C0051b;

/* renamed from: a.a.e.j */
final class C0077j implements Closeable {
    private static final Logger f309b;
    final C0051b f310a;
    private final BufferedSink f311c;
    private final boolean f312d;
    private final Buffer f313e;
    private int f314f;
    private boolean f315g;

    static {
        f309b = Logger.getLogger(C0053e.class.getName());
    }

    public C0077j(BufferedSink bufferedSink, boolean z) {
        this.f311c = bufferedSink;
        this.f312d = z;
        this.f313e = new Buffer();
        this.f310a = new C0051b(this.f313e);
        this.f314f = SpdyProtocol.SLIGHTSSL_L7E;
    }

    private static void m329a(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & MotionEventCompat.ACTION_MASK);
        bufferedSink.writeByte((i >>> 8) & MotionEventCompat.ACTION_MASK);
        bufferedSink.writeByte(i & MotionEventCompat.ACTION_MASK);
    }

    private void m330b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f314f, j);
            j -= (long) min;
            m333a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f311c.write(this.f313e, (long) min);
        }
    }

    public synchronized void m331a() {
        if (this.f315g) {
            throw new IOException("closed");
        } else if (this.f312d) {
            if (f309b.isLoggable(Level.FINE)) {
                f309b.fine(C0037c.m153a(">> CONNECTION %s", C0053e.f192a.hex()));
            }
            this.f311c.write(C0053e.f192a.toByteArray());
            this.f311c.flush();
        }
    }

    void m332a(int i, byte b, Buffer buffer, int i2) {
        m333a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f311c.write(buffer, (long) i2);
        }
    }

    public void m333a(int i, int i2, byte b, byte b2) {
        if (f309b.isLoggable(Level.FINE)) {
            f309b.fine(C0053e.m220a(false, i, i2, b, b2));
        }
        if (i2 > this.f314f) {
            throw C0053e.m218a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f314f), Integer.valueOf(i2));
        } else if ((LinearLayoutManager.INVALID_OFFSET & i) != 0) {
            throw C0053e.m218a("reserved bit set: %s", Integer.valueOf(i));
        } else {
            C0077j.m329a(this.f311c, i2);
            this.f311c.writeByte(b & MotionEventCompat.ACTION_MASK);
            this.f311c.writeByte(b2 & MotionEventCompat.ACTION_MASK);
            this.f311c.writeInt(Integer.MAX_VALUE & i);
        }
    }

    public synchronized void m334a(int i, int i2, List<C0049c> list) {
        if (this.f315g) {
            throw new IOException("closed");
        }
        this.f310a.m214a((List) list);
        long size = this.f313e.size();
        int min = (int) Math.min((long) (this.f314f - 4), size);
        m333a(i, min + 4, (byte) 5, size == ((long) min) ? (byte) 4 : (byte) 0);
        this.f311c.writeInt(Integer.MAX_VALUE & i2);
        this.f311c.write(this.f313e, (long) min);
        if (size > ((long) min)) {
            m330b(i, size - ((long) min));
        }
    }

    public synchronized void m335a(int i, long j) {
        if (this.f315g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw C0053e.m218a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            m333a(i, 4, (byte) 8, (byte) 0);
            this.f311c.writeInt((int) j);
            this.f311c.flush();
        }
    }

    public synchronized void m336a(int i, C0048b c0048b) {
        if (this.f315g) {
            throw new IOException("closed");
        } else if (c0048b.f162g == -1) {
            throw new IllegalArgumentException();
        } else {
            m333a(i, 4, (byte) 3, (byte) 0);
            this.f311c.writeInt(c0048b.f162g);
            this.f311c.flush();
        }
    }

    public synchronized void m337a(int i, C0048b c0048b, byte[] bArr) {
        if (this.f315g) {
            throw new IOException("closed");
        } else if (c0048b.f162g == -1) {
            throw C0053e.m218a("errorCode.httpCode == -1", new Object[0]);
        } else {
            m333a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f311c.writeInt(i);
            this.f311c.writeInt(c0048b.f162g);
            if (bArr.length > 0) {
                this.f311c.write(bArr);
            }
            this.f311c.flush();
        }
    }

    public synchronized void m338a(C0083n c0083n) {
        if (this.f315g) {
            throw new IOException("closed");
        }
        this.f314f = c0083n.m372d(this.f314f);
        if (c0083n.m369c() != -1) {
            this.f310a.m212a(c0083n.m369c());
        }
        m333a(0, 0, (byte) 4, (byte) 1);
        this.f311c.flush();
    }

    public synchronized void m339a(boolean z, int i, int i2) {
        byte b = (byte) 0;
        synchronized (this) {
            if (this.f315g) {
                throw new IOException("closed");
            }
            if (z) {
                b = (byte) 1;
            }
            m333a(0, 8, (byte) 6, b);
            this.f311c.writeInt(i);
            this.f311c.writeInt(i2);
            this.f311c.flush();
        }
    }

    public synchronized void m340a(boolean z, int i, int i2, List<C0049c> list) {
        if (this.f315g) {
            throw new IOException("closed");
        }
        m341a(z, i, (List) list);
    }

    void m341a(boolean z, int i, List<C0049c> list) {
        if (this.f315g) {
            throw new IOException("closed");
        }
        this.f310a.m214a((List) list);
        long size = this.f313e.size();
        int min = (int) Math.min((long) this.f314f, size);
        byte b = size == ((long) min) ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m333a(i, min, (byte) 1, b);
        this.f311c.write(this.f313e, (long) min);
        if (size > ((long) min)) {
            m330b(i, size - ((long) min));
        }
    }

    public synchronized void m342a(boolean z, int i, Buffer buffer, int i2) {
        if (this.f315g) {
            throw new IOException("closed");
        }
        byte b = (byte) 0;
        if (z) {
            b = (byte) 1;
        }
        m332a(i, b, buffer, i2);
    }

    public synchronized void m343b() {
        if (this.f315g) {
            throw new IOException("closed");
        }
        this.f311c.flush();
    }

    public synchronized void m344b(C0083n c0083n) {
        int i = 0;
        synchronized (this) {
            if (this.f315g) {
                throw new IOException("closed");
            }
            m333a(0, c0083n.m367b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (c0083n.m366a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.f311c.writeShort(i2);
                    this.f311c.writeInt(c0083n.m368b(i));
                }
                i++;
            }
            this.f311c.flush();
        }
    }

    public int m345c() {
        return this.f314f;
    }

    public synchronized void close() {
        this.f315g = true;
        this.f311c.close();
    }
}
