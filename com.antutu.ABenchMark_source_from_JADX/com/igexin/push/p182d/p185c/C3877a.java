package com.igexin.push.p182d.p185c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.a */
public class C3877a extends C3876e {
    public int f13037a;
    public int f13038b;
    public Object f13039c;
    public String f13040d;
    public String f13041e;
    private int f13042f;
    private int f13043g;

    public C3877a() {
        this.f13042f = 0;
        this.f13043g = 0;
        this.f13041e = HttpRequest.f14548a;
        this.i = 28;
    }

    public int m15949a() {
        return this.f13042f;
    }

    public void m15950a(int i) {
        this.f13042f = i;
    }

    public void m15951a(byte[] bArr) {
        this.f13037a = C3687f.m15089c(bArr, 0);
        this.f13038b = bArr[2] & Downloads.STATUS_RUNNING;
        this.f13041e = m15945a(bArr[2]);
        int i = 3;
        int i2 = 0;
        while (true) {
            i2 |= bArr[i] & TransportMediator.KEYCODE_MEDIA_PAUSE;
            if ((bArr[i] & SpdyProtocol.SLIGHTSSLV2) == 0) {
                break;
            }
            i2 <<= 7;
            i++;
        }
        i++;
        if (i2 > 0) {
            if (this.f13038b == Downloads.STATUS_RUNNING) {
                this.f13039c = new byte[i2];
                System.arraycopy(bArr, i, this.f13039c, 0, i2);
            } else {
                try {
                    this.f13039c = new String(bArr, i, i2, this.f13041e);
                } catch (Exception e) {
                }
            }
        }
        i2 += i;
        int i3 = bArr[i2] & MotionEventCompat.ACTION_MASK;
        i2++;
        if (bArr.length > i2) {
            try {
                this.f13040d = new String(bArr, i2, i3, this.f13041e);
            } catch (Exception e2) {
            }
            i2 += i3;
        }
    }

    public void m15952b(int i) {
        this.f13043g = i;
    }

    public int m15953c() {
        return this.f13043g;
    }

    public byte[] m15954d() {
        int i = 0;
        try {
            byte[] bytes = this.f13040d.getBytes(this.f13041e);
            r3 = !BuildConfig.FLAVOR.equals(this.f13039c) ? this.f13038b == Downloads.STATUS_RUNNING ? (byte[]) this.f13039c : ((String) this.f13039c).getBytes(this.f13041e) : null;
            if (r3 != null) {
                i = r3.length;
            }
            byte[] a = C3687f.m15081a(i);
            byte[] bArr = new byte[(((a.length + 4) + i) + bytes.length)];
            try {
                int b = C3687f.m15084b(this.f13037a, bArr, 0);
                b += C3687f.m15088c(this.f13038b | m15944a(this.f13041e), bArr, b);
                b += C3687f.m15077a(a, 0, bArr, b, a.length);
                if (i > 0) {
                    b += C3687f.m15077a(r3, 0, bArr, b, i);
                }
                b += C3687f.m15088c(bytes.length, bArr, b);
                b += C3687f.m15077a(bytes, 0, bArr, b, bytes.length);
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
