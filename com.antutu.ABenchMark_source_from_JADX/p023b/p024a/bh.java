package p023b.p024a;

import android.support.v4.view.MotionEventCompat;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: b.a.bh */
public class bh extends bm {
    private static final bs f2755f;
    protected boolean f2756a;
    protected boolean f2757b;
    protected int f2758c;
    protected boolean f2759d;
    private byte[] f2760g;
    private byte[] f2761h;
    private byte[] f2762i;
    private byte[] f2763j;
    private byte[] f2764k;
    private byte[] f2765l;
    private byte[] f2766m;
    private byte[] f2767n;

    /* renamed from: b.a.bh.a */
    public static class C0842a implements bo {
        protected boolean f2751a;
        protected boolean f2752b;
        protected int f2753c;

        public C0842a() {
            this(false, true);
        }

        public C0842a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C0842a(boolean z, boolean z2, int i) {
            this.f2751a = false;
            this.f2752b = true;
            this.f2751a = z;
            this.f2752b = z2;
            this.f2753c = i;
        }

        public bm m3491a(ca caVar) {
            bm bhVar = new bh(caVar, this.f2751a, this.f2752b);
            if (this.f2753c != 0) {
                bhVar.m3540c(this.f2753c);
            }
            return bhVar;
        }
    }

    static {
        f2755f = new bs();
    }

    public bh(ca caVar, boolean z, boolean z2) {
        super(caVar);
        this.f2756a = false;
        this.f2757b = true;
        this.f2759d = false;
        this.f2760g = new byte[1];
        this.f2761h = new byte[2];
        this.f2762i = new byte[4];
        this.f2763j = new byte[8];
        this.f2764k = new byte[1];
        this.f2765l = new byte[2];
        this.f2766m = new byte[4];
        this.f2767n = new byte[8];
        this.f2756a = z;
        this.f2757b = z2;
    }

    private int m3525a(byte[] bArr, int i, int i2) {
        m3542d(i2);
        return this.e.m3633d(bArr, i, i2);
    }

    public void m3526a() {
    }

    public void m3527a(byte b) {
        this.f2760g[0] = b;
        this.e.m3629b(this.f2760g, 0, 1);
    }

    public void m3528a(int i) {
        this.f2762i[0] = (byte) ((i >> 24) & MotionEventCompat.ACTION_MASK);
        this.f2762i[1] = (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK);
        this.f2762i[2] = (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK);
        this.f2762i[3] = (byte) (i & MotionEventCompat.ACTION_MASK);
        this.e.m3629b(this.f2762i, 0, 4);
    }

    public void m3529a(long j) {
        this.f2763j[0] = (byte) ((int) ((j >> 56) & 255));
        this.f2763j[1] = (byte) ((int) ((j >> 48) & 255));
        this.f2763j[2] = (byte) ((int) ((j >> 40) & 255));
        this.f2763j[3] = (byte) ((int) ((j >> 32) & 255));
        this.f2763j[4] = (byte) ((int) ((j >> 24) & 255));
        this.f2763j[5] = (byte) ((int) ((j >> 16) & 255));
        this.f2763j[6] = (byte) ((int) ((j >> 8) & 255));
        this.f2763j[7] = (byte) ((int) (255 & j));
        this.e.m3629b(this.f2763j, 0, 8);
    }

    public void m3530a(bj bjVar) {
        m3527a(bjVar.f2782b);
        m3536a(bjVar.f2783c);
    }

    public void m3531a(bk bkVar) {
        m3527a(bkVar.f2784a);
        m3528a(bkVar.f2785b);
    }

    public void m3532a(bl blVar) {
        m3527a(blVar.f2786a);
        m3527a(blVar.f2787b);
        m3528a(blVar.f2788c);
    }

    public void m3533a(bs bsVar) {
    }

    public void m3534a(String str) {
        try {
            byte[] bytes = str.getBytes(HttpRequest.f14548a);
            m3528a(bytes.length);
            this.e.m3629b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new ba("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void m3535a(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        m3528a(limit);
        this.e.m3629b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void m3536a(short s) {
        this.f2761h[0] = (byte) ((s >> 8) & MotionEventCompat.ACTION_MASK);
        this.f2761h[1] = (byte) (s & MotionEventCompat.ACTION_MASK);
        this.e.m3629b(this.f2761h, 0, 2);
    }

    public String m3537b(int i) {
        try {
            m3542d(i);
            byte[] bArr = new byte[i];
            this.e.m3633d(bArr, 0, i);
            return new String(bArr, HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            throw new ba("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void m3538b() {
    }

    public void m3539c() {
        m3527a((byte) 0);
    }

    public void m3540c(int i) {
        this.f2758c = i;
        this.f2759d = true;
    }

    public void m3541d() {
    }

    protected void m3542d(int i) {
        if (i < 0) {
            throw new bn("Negative length: " + i);
        } else if (this.f2759d) {
            this.f2758c -= i;
            if (this.f2758c < 0) {
                throw new bn("Message length exceeded: " + i);
            }
        }
    }

    public void m3543e() {
    }

    public bs m3544f() {
        return f2755f;
    }

    public void m3545g() {
    }

    public bj m3546h() {
        byte q = m3555q();
        return new bj(BuildConfig.FLAVOR, q, q == null ? (short) 0 : m3556r());
    }

    public void m3547i() {
    }

    public bl m3548j() {
        return new bl(m3555q(), m3555q(), m3557s());
    }

    public void m3549k() {
    }

    public bk m3550l() {
        return new bk(m3555q(), m3557s());
    }

    public void m3551m() {
    }

    public bq m3552n() {
        return new bq(m3555q(), m3557s());
    }

    public void m3553o() {
    }

    public boolean m3554p() {
        return m3555q() == (byte) 1;
    }

    public byte m3555q() {
        if (this.e.m3632d() >= 1) {
            byte b = this.e.m3630b()[this.e.m3631c()];
            this.e.m3627a(1);
            return b;
        }
        m3525a(this.f2764k, 0, 1);
        return this.f2764k[0];
    }

    public short m3556r() {
        int i = 0;
        byte[] bArr = this.f2765l;
        if (this.e.m3632d() >= 2) {
            bArr = this.e.m3630b();
            i = this.e.m3631c();
            this.e.m3627a(2);
        } else {
            m3525a(this.f2765l, 0, 2);
        }
        return (short) ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) | ((bArr[i] & MotionEventCompat.ACTION_MASK) << 8));
    }

    public int m3557s() {
        int i = 0;
        byte[] bArr = this.f2766m;
        if (this.e.m3632d() >= 4) {
            bArr = this.e.m3630b();
            i = this.e.m3631c();
            this.e.m3627a(4);
        } else {
            m3525a(this.f2766m, 0, 4);
        }
        return (bArr[i + 3] & MotionEventCompat.ACTION_MASK) | ((((bArr[i] & MotionEventCompat.ACTION_MASK) << 24) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 8));
    }

    public long m3558t() {
        int i = 0;
        byte[] bArr = this.f2767n;
        if (this.e.m3632d() >= 8) {
            bArr = this.e.m3630b();
            i = this.e.m3631c();
            this.e.m3627a(8);
        } else {
            m3525a(this.f2767n, 0, 8);
        }
        return ((long) (bArr[i + 7] & MotionEventCompat.ACTION_MASK)) | (((((((((long) (bArr[i] & MotionEventCompat.ACTION_MASK)) << 56) | (((long) (bArr[i + 1] & MotionEventCompat.ACTION_MASK)) << 48)) | (((long) (bArr[i + 2] & MotionEventCompat.ACTION_MASK)) << 40)) | (((long) (bArr[i + 3] & MotionEventCompat.ACTION_MASK)) << 32)) | (((long) (bArr[i + 4] & MotionEventCompat.ACTION_MASK)) << 24)) | (((long) (bArr[i + 5] & MotionEventCompat.ACTION_MASK)) << 16)) | (((long) (bArr[i + 6] & MotionEventCompat.ACTION_MASK)) << 8));
    }

    public double m3559u() {
        return Double.longBitsToDouble(m3558t());
    }

    public String m3560v() {
        int s = m3557s();
        if (this.e.m3632d() < s) {
            return m3537b(s);
        }
        try {
            String str = new String(this.e.m3630b(), this.e.m3631c(), s, HttpRequest.f14548a);
            this.e.m3627a(s);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new ba("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ByteBuffer m3561w() {
        int s = m3557s();
        m3542d(s);
        if (this.e.m3632d() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.m3630b(), this.e.m3631c(), s);
            this.e.m3627a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.e.m3633d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }
}
