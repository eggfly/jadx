package p000a.p001a.p004e;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import p000a.p001a.C0037c;
import p000a.p001a.p004e.C0052d.C0050a;

/* renamed from: a.a.e.h */
final class C0072h implements Closeable {
    static final Logger f279a;
    final C0050a f280b;
    private final BufferedSource f281c;
    private final C0071a f282d;
    private final boolean f283e;

    /* renamed from: a.a.e.h.b */
    interface C0068b {
        void m243a();

        void m244a(int i, int i2, int i3, boolean z);

        void m245a(int i, int i2, List<C0049c> list);

        void m246a(int i, long j);

        void m247a(int i, C0048b c0048b);

        void m248a(int i, C0048b c0048b, ByteString byteString);

        void m249a(boolean z, int i, int i2);

        void m250a(boolean z, int i, int i2, List<C0049c> list);

        void m251a(boolean z, int i, BufferedSource bufferedSource, int i2);

        void m252a(boolean z, C0083n c0083n);
    }

    /* renamed from: a.a.e.h.a */
    static final class C0071a implements Source {
        int f273a;
        byte f274b;
        int f275c;
        int f276d;
        short f277e;
        private final BufferedSource f278f;

        public C0071a(BufferedSource bufferedSource) {
            this.f278f = bufferedSource;
        }

        private void m289a() {
            int i = this.f275c;
            int a = C0072h.m291a(this.f278f);
            this.f276d = a;
            this.f273a = a;
            byte readByte = (byte) (this.f278f.readByte() & MotionEventCompat.ACTION_MASK);
            this.f274b = (byte) (this.f278f.readByte() & MotionEventCompat.ACTION_MASK);
            if (C0072h.f279a.isLoggable(Level.FINE)) {
                C0072h.f279a.fine(C0053e.m220a(true, this.f275c, this.f273a, readByte, this.f274b));
            }
            this.f275c = this.f278f.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                throw C0053e.m221b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (this.f275c != i) {
                throw C0053e.m221b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j) {
            while (this.f276d == 0) {
                this.f278f.skip((long) this.f277e);
                this.f277e = (short) 0;
                if ((this.f274b & 4) != 0) {
                    return -1;
                }
                m289a();
            }
            long read = this.f278f.read(buffer, Math.min(j, (long) this.f276d));
            if (read == -1) {
                return -1;
            }
            this.f276d = (int) (((long) this.f276d) - read);
            return read;
        }

        public Timeout timeout() {
            return this.f278f.timeout();
        }
    }

    static {
        f279a = Logger.getLogger(C0053e.class.getName());
    }

    public C0072h(BufferedSource bufferedSource, boolean z) {
        this.f281c = bufferedSource;
        this.f283e = z;
        this.f282d = new C0071a(this.f281c);
        this.f280b = new C0050a(SpdyProtocol.SLIGHTSSL_0_RTT_MODE, this.f282d);
    }

    static int m290a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw C0053e.m221b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(s2));
    }

    static int m291a(BufferedSource bufferedSource) {
        return (((bufferedSource.readByte() & MotionEventCompat.ACTION_MASK) << 16) | ((bufferedSource.readByte() & MotionEventCompat.ACTION_MASK) << 8)) | (bufferedSource.readByte() & MotionEventCompat.ACTION_MASK);
    }

    private List<C0049c> m292a(int i, short s, byte b, int i2) {
        C0071a c0071a = this.f282d;
        this.f282d.f276d = i;
        c0071a.f273a = i;
        this.f282d.f277e = s;
        this.f282d.f274b = b;
        this.f282d.f275c = i2;
        this.f280b.m205a();
        return this.f280b.m206b();
    }

    private void m293a(C0068b c0068b, int i) {
        int readInt = this.f281c.readInt();
        c0068b.m244a(i, readInt & Integer.MAX_VALUE, (this.f281c.readByte() & MotionEventCompat.ACTION_MASK) + 1, (LinearLayoutManager.INVALID_OFFSET & readInt) != 0);
    }

    private void m294a(C0068b c0068b, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 == 0) {
            throw C0053e.m221b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 8) != 0) {
            s = (short) (this.f281c.readByte() & MotionEventCompat.ACTION_MASK);
        }
        if ((b & 32) != 0) {
            m293a(c0068b, i2);
            i -= 5;
        }
        c0068b.m250a(z, i2, -1, m292a(C0072h.m290a(i, b, s), s, b, i2));
    }

    private void m295b(C0068b c0068b, int i, byte b, int i2) {
        short s = (short) 1;
        short s2 = (short) 0;
        boolean z = (b & 1) != 0;
        if ((b & 32) == 0) {
            s = (short) 0;
        }
        if (s != (short) 0) {
            throw C0053e.m221b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        if ((b & 8) != 0) {
            s2 = (short) (this.f281c.readByte() & MotionEventCompat.ACTION_MASK);
        }
        c0068b.m251a(z, i2, this.f281c, C0072h.m290a(i, b, s2));
        this.f281c.skip((long) s2);
    }

    private void m296c(C0068b c0068b, int i, byte b, int i2) {
        if (i != 5) {
            throw C0053e.m221b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw C0053e.m221b("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else {
            m293a(c0068b, i2);
        }
    }

    private void m297d(C0068b c0068b, int i, byte b, int i2) {
        if (i != 4) {
            throw C0053e.m221b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw C0053e.m221b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        } else {
            C0048b a = C0048b.m190a(this.f281c.readInt());
            if (a == null) {
                throw C0053e.m221b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
            } else {
                c0068b.m247a(i2, a);
            }
        }
    }

    private void m298e(C0068b c0068b, int i, byte b, int i2) {
        if (i2 != 0) {
            throw C0053e.m221b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i != 0) {
                throw C0053e.m221b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            c0068b.m243a();
        } else if (i % 6 != 0) {
            throw C0053e.m221b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            C0083n c0083n = new C0083n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int readShort = this.f281c.readShort();
                int readInt = this.f281c.readInt();
                switch (readShort) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (!(readInt == 0 || readInt == 1)) {
                            throw C0053e.m221b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        readShort = 4;
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        }
                        throw C0053e.m221b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        if (readInt >= SpdyProtocol.SLIGHTSSL_L7E && readInt <= ViewCompat.MEASURED_SIZE_MASK) {
                            break;
                        }
                        throw C0053e.m221b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    default:
                        break;
                }
                c0083n.m363a(readShort, readInt);
            }
            c0068b.m252a(false, c0083n);
        }
    }

    private void m299f(C0068b c0068b, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 == 0) {
            throw C0053e.m221b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        if ((b & 8) != 0) {
            s = (short) (this.f281c.readByte() & MotionEventCompat.ACTION_MASK);
        }
        c0068b.m245a(i2, this.f281c.readInt() & Integer.MAX_VALUE, m292a(C0072h.m290a(i - 4, b, s), s, b, i2));
    }

    private void m300g(C0068b c0068b, int i, byte b, int i2) {
        boolean z = true;
        if (i != 8) {
            throw C0053e.m221b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw C0053e.m221b("TYPE_PING streamId != 0", new Object[0]);
        } else {
            int readInt = this.f281c.readInt();
            int readInt2 = this.f281c.readInt();
            if ((b & 1) == 0) {
                z = false;
            }
            c0068b.m249a(z, readInt, readInt2);
        }
    }

    private void m301h(C0068b c0068b, int i, byte b, int i2) {
        if (i < 8) {
            throw C0053e.m221b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw C0053e.m221b("TYPE_GOAWAY streamId != 0", new Object[0]);
        } else {
            int readInt = this.f281c.readInt();
            int i3 = i - 8;
            C0048b a = C0048b.m190a(this.f281c.readInt());
            if (a == null) {
                throw C0053e.m221b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
            }
            ByteString byteString = ByteString.EMPTY;
            if (i3 > 0) {
                byteString = this.f281c.readByteString((long) i3);
            }
            c0068b.m248a(readInt, a, byteString);
        }
    }

    private void m302i(C0068b c0068b, int i, byte b, int i2) {
        if (i != 4) {
            throw C0053e.m221b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = ((long) this.f281c.readInt()) & 2147483647L;
        if (readInt == 0) {
            throw C0053e.m221b("windowSizeIncrement was 0", Long.valueOf(readInt));
        } else {
            c0068b.m246a(i2, readInt);
        }
    }

    public void m303a() {
        if (!this.f283e) {
            ByteString readByteString = this.f281c.readByteString((long) C0053e.f192a.size());
            if (f279a.isLoggable(Level.FINE)) {
                f279a.fine(C0037c.m153a("<< CONNECTION %s", readByteString.hex()));
            }
            if (!C0053e.f192a.equals(readByteString)) {
                throw C0053e.m221b("Expected a connection header but was %s", readByteString.utf8());
            }
        }
    }

    public boolean m304a(C0068b c0068b) {
        try {
            this.f281c.require(9);
            int a = C0072h.m291a(this.f281c);
            if (a < 0 || a > SpdyProtocol.SLIGHTSSL_L7E) {
                throw C0053e.m221b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte readByte = (byte) (this.f281c.readByte() & MotionEventCompat.ACTION_MASK);
            byte readByte2 = (byte) (this.f281c.readByte() & MotionEventCompat.ACTION_MASK);
            int readInt = this.f281c.readInt() & Integer.MAX_VALUE;
            if (f279a.isLoggable(Level.FINE)) {
                f279a.fine(C0053e.m220a(true, readInt, a, readByte, readByte2));
            }
            switch (readByte) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m295b(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m294a(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    m296c(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m297d(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    m298e(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    m299f(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    m300g(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    m301h(c0068b, a, readByte2, readInt);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    m302i(c0068b, a, readByte2, readInt);
                    return true;
                default:
                    this.f281c.skip((long) a);
                    return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    public void close() {
        this.f281c.close();
    }
}
