package org.apache.thrift.protocol;

import android.support.v4.view.MotionEventCompat;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.C4597f;
import org.apache.thrift.transport.C4618d;

/* renamed from: org.apache.thrift.protocol.a */
public class C4608a extends C4607e {
    private static final C4615j f16462f;
    protected boolean f16463a;
    protected boolean f16464b;
    protected int f16465c;
    protected boolean f16466d;
    private byte[] f16467g;
    private byte[] f16468h;
    private byte[] f16469i;
    private byte[] f16470j;
    private byte[] f16471k;
    private byte[] f16472l;
    private byte[] f16473m;
    private byte[] f16474n;

    /* renamed from: org.apache.thrift.protocol.a.a */
    public static class C4606a implements C4605g {
        protected boolean f16458a;
        protected boolean f16459b;
        protected int f16460c;

        public C4606a() {
            this(false, true);
        }

        public C4606a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C4606a(boolean z, boolean z2, int i) {
            this.f16458a = false;
            this.f16459b = true;
            this.f16458a = z;
            this.f16459b = z2;
            this.f16460c = i;
        }

        public C4607e m19303a(C4618d c4618d) {
            C4607e c4608a = new C4608a(c4618d, this.f16458a, this.f16459b);
            if (this.f16460c != 0) {
                c4608a.m19355c(this.f16460c);
            }
            return c4608a;
        }
    }

    static {
        f16462f = new C4615j();
    }

    public C4608a(C4618d c4618d, boolean z, boolean z2) {
        super(c4618d);
        this.f16463a = false;
        this.f16464b = true;
        this.f16466d = false;
        this.f16467g = new byte[1];
        this.f16468h = new byte[2];
        this.f16469i = new byte[4];
        this.f16470j = new byte[8];
        this.f16471k = new byte[1];
        this.f16472l = new byte[2];
        this.f16473m = new byte[4];
        this.f16474n = new byte[8];
        this.f16463a = z;
        this.f16464b = z2;
    }

    private int m19339a(byte[] bArr, int i, int i2) {
        m19357d(i2);
        return this.e.m19391d(bArr, i, i2);
    }

    public void m19340a() {
    }

    public void m19341a(byte b) {
        this.f16467g[0] = b;
        this.e.m19389b(this.f16467g, 0, 1);
    }

    public void m19342a(int i) {
        this.f16469i[0] = (byte) ((i >> 24) & MotionEventCompat.ACTION_MASK);
        this.f16469i[1] = (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK);
        this.f16469i[2] = (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK);
        this.f16469i[3] = (byte) (i & MotionEventCompat.ACTION_MASK);
        this.e.m19389b(this.f16469i, 0, 4);
    }

    public void m19343a(long j) {
        this.f16470j[0] = (byte) ((int) ((j >> 56) & 255));
        this.f16470j[1] = (byte) ((int) ((j >> 48) & 255));
        this.f16470j[2] = (byte) ((int) ((j >> 40) & 255));
        this.f16470j[3] = (byte) ((int) ((j >> 32) & 255));
        this.f16470j[4] = (byte) ((int) ((j >> 24) & 255));
        this.f16470j[5] = (byte) ((int) ((j >> 16) & 255));
        this.f16470j[6] = (byte) ((int) ((j >> 8) & 255));
        this.f16470j[7] = (byte) ((int) (255 & j));
        this.e.m19389b(this.f16470j, 0, 8);
    }

    public void m19344a(String str) {
        try {
            byte[] bytes = str.getBytes(HttpRequest.f14548a);
            m19342a(bytes.length);
            this.e.m19389b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C4597f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void m19345a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        m19342a(limit);
        this.e.m19389b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void m19346a(C4609b c4609b) {
        m19341a(c4609b.f16476b);
        m19350a(c4609b.f16477c);
    }

    public void m19347a(C4610c c4610c) {
        m19341a(c4610c.f16478a);
        m19342a(c4610c.f16479b);
    }

    public void m19348a(C4611d c4611d) {
        m19341a(c4611d.f16480a);
        m19341a(c4611d.f16481b);
        m19342a(c4611d.f16482c);
    }

    public void m19349a(C4615j c4615j) {
    }

    public void m19350a(short s) {
        this.f16468h[0] = (byte) ((s >> 8) & MotionEventCompat.ACTION_MASK);
        this.f16468h[1] = (byte) (s & MotionEventCompat.ACTION_MASK);
        this.e.m19389b(this.f16468h, 0, 2);
    }

    public void m19351a(boolean z) {
        m19341a(z ? (byte) 1 : (byte) 0);
    }

    public String m19352b(int i) {
        try {
            m19357d(i);
            byte[] bArr = new byte[i];
            this.e.m19391d(bArr, 0, i);
            return new String(bArr, HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            throw new C4597f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void m19353b() {
    }

    public void m19354c() {
        m19341a((byte) 0);
    }

    public void m19355c(int i) {
        this.f16465c = i;
        this.f16466d = true;
    }

    public void m19356d() {
    }

    protected void m19357d(int i) {
        if (i < 0) {
            throw new C4597f("Negative length: " + i);
        } else if (this.f16466d) {
            this.f16465c -= i;
            if (this.f16465c < 0) {
                throw new C4597f("Message length exceeded: " + i);
            }
        }
    }

    public void m19358e() {
    }

    public C4615j m19359f() {
        return f16462f;
    }

    public void m19360g() {
    }

    public C4609b m19361h() {
        byte q = m19370q();
        return new C4609b(BuildConfig.FLAVOR, q, q == null ? (short) 0 : m19371r());
    }

    public void m19362i() {
    }

    public C4611d m19363j() {
        return new C4611d(m19370q(), m19370q(), m19372s());
    }

    public void m19364k() {
    }

    public C4610c m19365l() {
        return new C4610c(m19370q(), m19372s());
    }

    public void m19366m() {
    }

    public C4614i m19367n() {
        return new C4614i(m19370q(), m19372s());
    }

    public void m19368o() {
    }

    public boolean m19369p() {
        return m19370q() == (byte) 1;
    }

    public byte m19370q() {
        if (this.e.m19390c() >= 1) {
            byte b = this.e.m19387a()[this.e.m19388b()];
            this.e.m19386a(1);
            return b;
        }
        m19339a(this.f16471k, 0, 1);
        return this.f16471k[0];
    }

    public short m19371r() {
        int i = 0;
        byte[] bArr = this.f16472l;
        if (this.e.m19390c() >= 2) {
            bArr = this.e.m19387a();
            i = this.e.m19388b();
            this.e.m19386a(2);
        } else {
            m19339a(this.f16472l, 0, 2);
        }
        return (short) ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) | ((bArr[i] & MotionEventCompat.ACTION_MASK) << 8));
    }

    public int m19372s() {
        int i = 0;
        byte[] bArr = this.f16473m;
        if (this.e.m19390c() >= 4) {
            bArr = this.e.m19387a();
            i = this.e.m19388b();
            this.e.m19386a(4);
        } else {
            m19339a(this.f16473m, 0, 4);
        }
        return (bArr[i + 3] & MotionEventCompat.ACTION_MASK) | ((((bArr[i] & MotionEventCompat.ACTION_MASK) << 24) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 8));
    }

    public long m19373t() {
        int i = 0;
        byte[] bArr = this.f16474n;
        if (this.e.m19390c() >= 8) {
            bArr = this.e.m19387a();
            i = this.e.m19388b();
            this.e.m19386a(8);
        } else {
            m19339a(this.f16474n, 0, 8);
        }
        return ((long) (bArr[i + 7] & MotionEventCompat.ACTION_MASK)) | (((((((((long) (bArr[i] & MotionEventCompat.ACTION_MASK)) << 56) | (((long) (bArr[i + 1] & MotionEventCompat.ACTION_MASK)) << 48)) | (((long) (bArr[i + 2] & MotionEventCompat.ACTION_MASK)) << 40)) | (((long) (bArr[i + 3] & MotionEventCompat.ACTION_MASK)) << 32)) | (((long) (bArr[i + 4] & MotionEventCompat.ACTION_MASK)) << 24)) | (((long) (bArr[i + 5] & MotionEventCompat.ACTION_MASK)) << 16)) | (((long) (bArr[i + 6] & MotionEventCompat.ACTION_MASK)) << 8));
    }

    public double m19374u() {
        return Double.longBitsToDouble(m19373t());
    }

    public String m19375v() {
        int s = m19372s();
        if (this.e.m19390c() < s) {
            return m19352b(s);
        }
        try {
            String str = new String(this.e.m19387a(), this.e.m19388b(), s, HttpRequest.f14548a);
            this.e.m19386a(s);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C4597f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ByteBuffer m19376w() {
        int s = m19372s();
        m19357d(s);
        if (this.e.m19390c() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.m19387a(), this.e.m19388b(), s);
            this.e.m19386a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.e.m19391d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }
}
