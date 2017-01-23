package p023b.p024a;

import android.support.v4.media.TransportMediator;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: b.a.bi */
public class bi extends bm {
    private static final bs f2769d;
    private static final bj f2770f;
    private static final byte[] f2771g;
    byte[] f2772a;
    byte[] f2773b;
    byte[] f2774c;
    private av f2775h;
    private short f2776i;
    private bj f2777j;
    private Boolean f2778k;
    private final long f2779l;
    private byte[] f2780m;

    /* renamed from: b.a.bi.a */
    public static class C0843a implements bo {
        private final long f2768a;

        public C0843a() {
            this.f2768a = -1;
        }

        public bm m3562a(ca caVar) {
            return new bi(caVar, this.f2768a);
        }
    }

    static {
        f2769d = new bs(BuildConfig.FLAVOR);
        f2770f = new bj(BuildConfig.FLAVOR, (byte) 0, (short) 0);
        f2771g = new byte[16];
        f2771g[0] = (byte) 0;
        f2771g[2] = (byte) 1;
        f2771g[3] = (byte) 3;
        f2771g[6] = (byte) 4;
        f2771g[8] = (byte) 5;
        f2771g[10] = (byte) 6;
        f2771g[4] = (byte) 7;
        f2771g[11] = (byte) 8;
        f2771g[15] = (byte) 9;
        f2771g[14] = (byte) 10;
        f2771g[13] = (byte) 11;
        f2771g[12] = (byte) 12;
    }

    public bi(ca caVar, long j) {
        super(caVar);
        this.f2775h = new av(15);
        this.f2776i = (short) 0;
        this.f2777j = null;
        this.f2778k = null;
        this.f2772a = new byte[5];
        this.f2773b = new byte[10];
        this.f2780m = new byte[1];
        this.f2774c = new byte[1];
        this.f2779l = j;
    }

    private long m3563A() {
        long j = null;
        long j2 = 0;
        if (this.e.m3632d() >= 10) {
            int i;
            byte[] b = this.e.m3630b();
            int c = this.e.m3631c();
            long j3 = 0;
            while (true) {
                byte b2 = b[c + i];
                j2 |= ((long) (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE)) << j3;
                if ((b2 & SpdyProtocol.SLIGHTSSLV2) != SpdyProtocol.SLIGHTSSLV2) {
                    break;
                }
                j3 += 7;
                i++;
            }
            this.e.m3627a(i + 1);
        } else {
            while (true) {
                byte q = m3608q();
                j2 |= ((long) (q & TransportMediator.KEYCODE_MEDIA_PAUSE)) << j;
                if ((q & SpdyProtocol.SLIGHTSSLV2) != SpdyProtocol.SLIGHTSSLV2) {
                    break;
                }
                j += 7;
            }
        }
        return j2;
    }

    private long m3564a(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    private void m3565a(bj bjVar, byte b) {
        if (b == -1) {
            b = m3576e(bjVar.f2782b);
        }
        if (bjVar.f2783c <= this.f2776i || bjVar.f2783c - this.f2776i > 15) {
            m3567b(b);
            m3592a(bjVar.f2783c);
        } else {
            m3575d(((bjVar.f2783c - this.f2776i) << 4) | b);
        }
        this.f2776i = bjVar.f2783c;
    }

    private void m3566a(byte[] bArr, int i, int i2) {
        m3568b(i2);
        this.e.m3629b(bArr, i, i2);
    }

    private void m3567b(byte b) {
        this.f2780m[0] = b;
        this.e.m3628b(this.f2780m);
    }

    private void m3568b(int i) {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.f2772a[i2] = (byte) ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.f2772a[i2] = (byte) i;
        this.e.m3629b(this.f2772a, 0, i4);
    }

    private void m3569b(long j) {
        int i = 0;
        while ((-128 & j) != 0) {
            int i2 = i + 1;
            this.f2773b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.f2773b[i] = (byte) ((int) j);
        this.e.m3629b(this.f2773b, 0, i3);
    }

    private int m3570c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private long m3571c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private boolean m3572c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    private byte m3573d(byte b) {
        switch ((byte) (b & 15)) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return (byte) 0;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return (byte) 2;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return (byte) 3;
            case SpdyProtocol.QUIC /*4*/:
                return (byte) 6;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return (byte) 8;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return (byte) 10;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return (byte) 4;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return (byte) 11;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return (byte) 15;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return (byte) 14;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return (byte) 13;
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return (byte) 12;
            default:
                throw new bn("don't know what type: " + ((byte) (b & 15)));
        }
    }

    private long m3574d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private void m3575d(int i) {
        m3567b((byte) i);
    }

    private byte m3576e(byte b) {
        return f2771g[b];
    }

    private byte[] m3577e(int i) {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.e.m3633d(bArr, 0, i);
        return bArr;
    }

    private void m3578f(int i) {
        if (i < 0) {
            throw new bn("Negative length: " + i);
        } else if (this.f2779l != -1 && ((long) i) > this.f2779l) {
            throw new bn("Length exceeded max allowed: " + i);
        }
    }

    private int m3579g(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private int m3580z() {
        int i = 0;
        int i2;
        if (this.e.m3632d() >= 5) {
            byte[] b = this.e.m3630b();
            int c = this.e.m3631c();
            i2 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = b[c + i];
                i3 |= (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << i2;
                if ((b2 & SpdyProtocol.SLIGHTSSLV2) != SpdyProtocol.SLIGHTSSLV2) {
                    this.e.m3627a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            i2 = 0;
            while (true) {
                byte q = m3608q();
                i2 |= (q & TransportMediator.KEYCODE_MEDIA_PAUSE) << i;
                if ((q & SpdyProtocol.SLIGHTSSLV2) != SpdyProtocol.SLIGHTSSLV2) {
                    return i2;
                }
                i += 7;
            }
        }
    }

    public void m3581a() {
        this.f2776i = this.f2775h.m3456a();
    }

    public void m3582a(byte b) {
        m3567b(b);
    }

    protected void m3583a(byte b, int i) {
        if (i <= 14) {
            m3575d((i << 4) | m3576e(b));
            return;
        }
        m3575d(m3576e(b) | 240);
        m3568b(i);
    }

    public void m3584a(int i) {
        m3568b(m3570c(i));
    }

    public void m3585a(long j) {
        m3569b(m3571c(j));
    }

    public void m3586a(bj bjVar) {
        if (bjVar.f2782b == 2) {
            this.f2777j = bjVar;
        } else {
            m3565a(bjVar, (byte) -1);
        }
    }

    public void m3587a(bk bkVar) {
        m3583a(bkVar.f2784a, bkVar.f2785b);
    }

    public void m3588a(bl blVar) {
        if (blVar.f2788c == 0) {
            m3575d(0);
            return;
        }
        m3568b(blVar.f2788c);
        m3575d((m3576e(blVar.f2786a) << 4) | m3576e(blVar.f2787b));
    }

    public void m3589a(bs bsVar) {
        this.f2775h.m3457a(this.f2776i);
        this.f2776i = (short) 0;
    }

    public void m3590a(String str) {
        try {
            byte[] bytes = str.getBytes(HttpRequest.f14548a);
            m3566a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new ba("UTF-8 not supported!");
        }
    }

    public void m3591a(ByteBuffer byteBuffer) {
        m3566a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    public void m3592a(short s) {
        m3568b(m3570c((int) s));
    }

    public void m3593b() {
    }

    public void m3594c() {
        m3567b((byte) 0);
    }

    public void m3595d() {
    }

    public void m3596e() {
    }

    public bs m3597f() {
        this.f2775h.m3457a(this.f2776i);
        this.f2776i = (short) 0;
        return f2769d;
    }

    public void m3598g() {
        this.f2776i = this.f2775h.m3456a();
    }

    public bj m3599h() {
        byte q = m3608q();
        if (q == null) {
            return f2770f;
        }
        short s = (short) ((q & 240) >> 4);
        bj bjVar = new bj(BuildConfig.FLAVOR, m3573d((byte) (q & 15)), s == (short) 0 ? m3609r() : (short) (s + this.f2776i));
        if (m3572c(q)) {
            this.f2778k = ((byte) (q & 15)) == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f2776i = bjVar.f2783c;
        return bjVar;
    }

    public void m3600i() {
    }

    public bl m3601j() {
        int z = m3580z();
        int q = z == 0 ? 0 : m3608q();
        return new bl(m3573d((byte) (q >> 4)), m3573d((byte) (q & 15)), z);
    }

    public void m3602k() {
    }

    public bk m3603l() {
        byte q = m3608q();
        int i = (q >> 4) & 15;
        if (i == 15) {
            i = m3580z();
        }
        return new bk(m3573d(q), i);
    }

    public void m3604m() {
    }

    public bq m3605n() {
        return new bq(m3603l());
    }

    public void m3606o() {
    }

    public boolean m3607p() {
        if (this.f2778k == null) {
            return m3608q() == (byte) 1;
        } else {
            boolean booleanValue = this.f2778k.booleanValue();
            this.f2778k = null;
            return booleanValue;
        }
    }

    public byte m3608q() {
        if (this.e.m3632d() > 0) {
            byte b = this.e.m3630b()[this.e.m3631c()];
            this.e.m3627a(1);
            return b;
        }
        this.e.m3633d(this.f2774c, 0, 1);
        return this.f2774c[0];
    }

    public short m3609r() {
        return (short) m3579g(m3580z());
    }

    public int m3610s() {
        return m3579g(m3580z());
    }

    public long m3611t() {
        return m3574d(m3563A());
    }

    public double m3612u() {
        byte[] bArr = new byte[8];
        this.e.m3633d(bArr, 0, 8);
        return Double.longBitsToDouble(m3564a(bArr));
    }

    public String m3613v() {
        int z = m3580z();
        m3578f(z);
        if (z == 0) {
            return BuildConfig.FLAVOR;
        }
        try {
            if (this.e.m3632d() < z) {
                return new String(m3577e(z), HttpRequest.f14548a);
            }
            String str = new String(this.e.m3630b(), this.e.m3631c(), z, HttpRequest.f14548a);
            this.e.m3627a(z);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new ba("UTF-8 not supported!");
        }
    }

    public ByteBuffer m3614w() {
        int z = m3580z();
        m3578f(z);
        if (z == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[z];
        this.e.m3633d(bArr, 0, z);
        return ByteBuffer.wrap(bArr);
    }

    public void m3615x() {
        this.f2775h.m3458b();
        this.f2776i = (short) 0;
    }
}
