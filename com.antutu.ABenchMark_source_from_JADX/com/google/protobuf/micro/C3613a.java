package com.google.protobuf.micro;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.umeng.message.util.HttpRequest;
import java.io.InputStream;
import java.util.Vector;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.protobuf.micro.a */
public final class C3613a {
    private final byte[] f12267a;
    private int f12268b;
    private int f12269c;
    private int f12270d;
    private final InputStream f12271e;
    private int f12272f;
    private int f12273g;
    private int f12274h;
    private int f12275i;
    private int f12276j;

    private C3613a(InputStream inputStream) {
        this.f12274h = Integer.MAX_VALUE;
        this.f12275i = 64;
        this.f12276j = 67108864;
        this.f12267a = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        this.f12268b = 0;
        this.f12270d = 0;
        this.f12271e = inputStream;
    }

    private C3613a(byte[] bArr, int i, int i2) {
        this.f12274h = Integer.MAX_VALUE;
        this.f12275i = 64;
        this.f12276j = 67108864;
        this.f12267a = bArr;
        this.f12268b = i + i2;
        this.f12270d = i;
        this.f12271e = null;
    }

    public static C3613a m14816a(InputStream inputStream) {
        return new C3613a(inputStream);
    }

    public static C3613a m14817a(byte[] bArr, int i, int i2) {
        return new C3613a(bArr, i, i2);
    }

    private boolean m14818a(boolean z) {
        if (this.f12270d < this.f12268b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.f12273g + this.f12268b != this.f12274h) {
            this.f12273g += this.f12268b;
            this.f12270d = 0;
            this.f12268b = this.f12271e == null ? -1 : this.f12271e.read(this.f12267a);
            if (this.f12268b == 0 || this.f12268b < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f12268b + "\nThe InputStream implementation is buggy.");
            } else if (this.f12268b == -1) {
                this.f12268b = 0;
                if (!z) {
                    return false;
                }
                throw C3616c.m14866a();
            } else {
                m14819l();
                int i = (this.f12273g + this.f12268b) + this.f12269c;
                if (i <= this.f12276j && i >= 0) {
                    return true;
                }
                throw C3616c.m14872g();
            }
        } else if (!z) {
            return false;
        } else {
            throw C3616c.m14866a();
        }
    }

    private void m14819l() {
        this.f12268b += this.f12269c;
        int i = this.f12273g + this.f12268b;
        if (i > this.f12274h) {
            this.f12269c = i - this.f12274h;
            this.f12268b -= this.f12269c;
            return;
        }
        this.f12269c = 0;
    }

    public int m14820a() {
        if (m14833j()) {
            this.f12272f = 0;
            return 0;
        }
        this.f12272f = m14830g();
        if (this.f12272f != 0) {
            return this.f12272f;
        }
        throw C3616c.m14869d();
    }

    public void m14821a(int i) {
        if (this.f12272f != i) {
            throw C3616c.m14870e();
        }
    }

    public void m14822b() {
        int a;
        do {
            a = m14820a();
            if (a == 0) {
                return;
            }
        } while (m14823b(a));
    }

    public boolean m14823b(int i) {
        switch (C3618e.m14881a(i)) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                m14824c();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m14832i();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m14826d(m14830g());
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m14822b();
                m14821a(C3618e.m14882a(C3618e.m14883b(i), 4));
                return true;
            case SpdyProtocol.QUIC /*4*/:
                return false;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                m14831h();
                return true;
            default:
                throw C3616c.m14871f();
        }
    }

    public int m14824c() {
        return m14830g();
    }

    public byte[] m14825c(int i) {
        if (i < 0) {
            throw C3616c.m14867b();
        } else if ((this.f12273g + this.f12270d) + i > this.f12274h) {
            m14826d((this.f12274h - this.f12273g) - this.f12270d);
            throw C3616c.m14866a();
        } else if (i <= this.f12268b - this.f12270d) {
            Object obj = new byte[i];
            System.arraycopy(this.f12267a, this.f12270d, obj, 0, i);
            this.f12270d += i;
            return obj;
        } else if (i < SpdyProtocol.SLIGHTSSL_0_RTT_MODE) {
            Object obj2 = new byte[i];
            r0 = this.f12268b - this.f12270d;
            System.arraycopy(this.f12267a, this.f12270d, obj2, 0, r0);
            this.f12270d = this.f12268b;
            m14818a(true);
            while (i - r0 > this.f12268b) {
                System.arraycopy(this.f12267a, 0, obj2, r0, this.f12268b);
                r0 += this.f12268b;
                this.f12270d = this.f12268b;
                m14818a(true);
            }
            System.arraycopy(this.f12267a, 0, obj2, r0, i - r0);
            this.f12270d = i - r0;
            return obj2;
        } else {
            int read;
            int i2 = this.f12270d;
            int i3 = this.f12268b;
            this.f12273g += this.f12268b;
            this.f12270d = 0;
            this.f12268b = 0;
            r0 = i - (i3 - i2);
            Vector vector = new Vector();
            int i4 = r0;
            while (i4 > 0) {
                Object obj3 = new byte[Math.min(i4, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)];
                r0 = 0;
                while (r0 < obj3.length) {
                    read = this.f12271e == null ? -1 : this.f12271e.read(obj3, r0, obj3.length - r0);
                    if (read == -1) {
                        throw C3616c.m14866a();
                    }
                    this.f12273g += read;
                    r0 += read;
                }
                r0 = i4 - obj3.length;
                vector.addElement(obj3);
                i4 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i3 - i2;
            System.arraycopy(this.f12267a, i2, obj4, 0, r0);
            int i5 = r0;
            for (read = 0; read < vector.size(); read++) {
                byte[] bArr = (byte[]) vector.elementAt(read);
                System.arraycopy(bArr, 0, obj4, i5, bArr.length);
                i5 += bArr.length;
            }
            return obj4;
        }
    }

    public void m14826d(int i) {
        if (i < 0) {
            throw C3616c.m14867b();
        } else if ((this.f12273g + this.f12270d) + i > this.f12274h) {
            m14826d((this.f12274h - this.f12273g) - this.f12270d);
            throw C3616c.m14866a();
        } else if (i <= this.f12268b - this.f12270d) {
            this.f12270d += i;
        } else {
            int i2 = this.f12268b - this.f12270d;
            this.f12273g += this.f12268b;
            this.f12270d = 0;
            this.f12268b = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.f12271e == null ? -1 : (int) this.f12271e.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw C3616c.m14866a();
                }
                i3 += i2;
                this.f12273g = i2 + this.f12273g;
            }
        }
    }

    public boolean m14827d() {
        return m14830g() != 0;
    }

    public String m14828e() {
        int g = m14830g();
        if (g > this.f12268b - this.f12270d || g <= 0) {
            return new String(m14825c(g), HttpRequest.f14548a);
        }
        String str = new String(this.f12267a, this.f12270d, g, HttpRequest.f14548a);
        this.f12270d = g + this.f12270d;
        return str;
    }

    public int m14829f() {
        return m14830g();
    }

    public int m14830g() {
        byte k = m14834k();
        if (k >= null) {
            return k;
        }
        int i = k & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte k2 = m14834k();
        if (k2 >= null) {
            return i | (k2 << 7);
        }
        i |= (k2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        k2 = m14834k();
        if (k2 >= null) {
            return i | (k2 << 14);
        }
        i |= (k2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        k2 = m14834k();
        if (k2 >= null) {
            return i | (k2 << 21);
        }
        i |= (k2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        k2 = m14834k();
        i |= k2 << 28;
        if (k2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m14834k() >= null) {
                return i;
            }
        }
        throw C3616c.m14868c();
    }

    public int m14831h() {
        return (((m14834k() & MotionEventCompat.ACTION_MASK) | ((m14834k() & MotionEventCompat.ACTION_MASK) << 8)) | ((m14834k() & MotionEventCompat.ACTION_MASK) << 16)) | ((m14834k() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long m14832i() {
        byte k = m14834k();
        byte k2 = m14834k();
        return ((((((((((long) k2) & 255) << 8) | (((long) k) & 255)) | ((((long) m14834k()) & 255) << 16)) | ((((long) m14834k()) & 255) << 24)) | ((((long) m14834k()) & 255) << 32)) | ((((long) m14834k()) & 255) << 40)) | ((((long) m14834k()) & 255) << 48)) | ((((long) m14834k()) & 255) << 56);
    }

    public boolean m14833j() {
        return this.f12270d == this.f12268b && !m14818a(false);
    }

    public byte m14834k() {
        if (this.f12270d == this.f12268b) {
            m14818a(true);
        }
        byte[] bArr = this.f12267a;
        int i = this.f12270d;
        this.f12270d = i + 1;
        return bArr[i];
    }
}
