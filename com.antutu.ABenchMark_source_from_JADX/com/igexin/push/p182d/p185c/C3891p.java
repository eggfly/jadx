package com.igexin.push.p182d.p185c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.p */
public class C3891p extends C3876e {
    private static final String f13111m;
    public int f13112a;
    public int f13113b;
    public long f13114c;
    public String f13115d;
    public Object f13116e;
    public Object f13117f;
    public String f13118g;
    public String f13119h;

    static {
        f13111m = C3891p.class.getName();
    }

    public C3891p() {
        this.f13119h = HttpRequest.f14548a;
        this.i = 26;
    }

    public void m15991a(byte[] bArr) {
        this.f13112a = C3687f.m15089c(bArr, 0);
        this.f13113b = bArr[2] & Downloads.STATUS_RUNNING;
        this.f13119h = m15945a(bArr[2]);
        this.f13114c = C3687f.m15093e(bArr, 3);
        int i = bArr[11] & MotionEventCompat.ACTION_MASK;
        try {
            this.f13115d = new String(bArr, 12, i, this.f13119h);
        } catch (Exception e) {
            this.f13115d = BuildConfig.FLAVOR;
        }
        int i2 = i + 12;
        i = 0;
        while (true) {
            i |= bArr[i2] & TransportMediator.KEYCODE_MEDIA_PAUSE;
            if ((bArr[i2] & SpdyProtocol.SLIGHTSSLV2) == 0) {
                break;
            }
            i <<= 7;
            i2++;
        }
        i2++;
        if (i > 0) {
            if (this.f13113b == Downloads.STATUS_RUNNING) {
                this.f13116e = new byte[i];
                System.arraycopy(bArr, i2, this.f13116e, 0, i);
            } else {
                try {
                    this.f13116e = new String(bArr, i2, i, this.f13119h);
                } catch (Exception e2) {
                }
            }
        }
        i2 = i + i2;
        i = 0;
        while (true) {
            i |= bArr[i2] & TransportMediator.KEYCODE_MEDIA_PAUSE;
            if ((bArr[i2] & SpdyProtocol.SLIGHTSSLV2) == 0) {
                break;
            }
            i <<= 7;
            i2++;
        }
        i2++;
        if (i > 0) {
            this.f13117f = new byte[i];
            System.arraycopy(bArr, i2, this.f13117f, 0, i);
        }
        i += i2;
        if (bArr.length > i) {
            int i3 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            try {
                this.f13118g = new String(bArr, i3, i, this.f13119h);
            } catch (Exception e3) {
            }
            i += i3;
        }
    }

    public final boolean m15992a() {
        return this.f13113b == SpdyProtocol.SLIGHTSSLV2;
    }

    public byte[] m15993d() {
        int i = 0;
        try {
            byte[] bytes = this.f13115d.getBytes(this.f13119h);
            byte[] bytes2 = this.f13118g.getBytes(this.f13119h);
            r5 = !BuildConfig.FLAVOR.equals(this.f13116e) ? this.f13113b == Downloads.STATUS_RUNNING ? (byte[]) this.f13116e : ((String) this.f13116e).getBytes(this.f13119h) : null;
            byte[] bArr = this.f13117f != null ? (byte[]) this.f13117f : null;
            int length = r5 == null ? 0 : r5.length;
            if (bArr != null) {
                i = bArr.length;
            }
            byte[] a = C3687f.m15081a(length);
            byte[] a2 = C3687f.m15081a(i);
            byte[] bArr2 = new byte[((((((bytes.length + 13) + a.length) + length) + a2.length) + i) + bytes2.length)];
            try {
                int b = C3687f.m15084b(this.f13112a, bArr2, 0);
                b += C3687f.m15088c(this.f13113b | m15944a(this.f13119h), bArr2, b);
                b += C3687f.m15075a(this.f13114c, bArr2, b);
                b += C3687f.m15088c(bytes.length, bArr2, b);
                b += C3687f.m15077a(bytes, 0, bArr2, b, bytes.length);
                b += C3687f.m15077a(a, 0, bArr2, b, a.length);
                if (length > 0) {
                    b += C3687f.m15077a(r5, 0, bArr2, b, length);
                }
                b += C3687f.m15077a(a2, 0, bArr2, b, a2.length);
                if (i > 0) {
                    b += C3687f.m15077a(bArr, 0, bArr2, b, i);
                }
                b += C3687f.m15088c(bytes2.length, bArr2, b);
                b += C3687f.m15077a(bytes2, 0, bArr2, b, bytes2.length);
                return bArr2;
            } catch (Exception e) {
                return bArr2;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
