package com.igexin.push.p182d.p185c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.d */
public class C3880d extends C3876e {
    public int f13058a;
    public int f13059b;
    public long f13060c;
    public String f13061d;
    public Object f13062e;
    public Object f13063f;
    public String f13064g;
    public String f13065h;

    public C3880d() {
        this.f13064g = BuildConfig.FLAVOR;
        this.f13065h = HttpRequest.f14548a;
        this.i = 25;
        this.j = (byte) 20;
    }

    public final void m15964a() {
        this.f13059b = SpdyProtocol.SLIGHTSSLV2;
    }

    public void m15965a(byte[] bArr) {
        this.f13058a = C3687f.m15089c(bArr, 0);
        this.f13059b = bArr[2] & Downloads.STATUS_RUNNING;
        this.f13065h = m15945a(bArr[2]);
        this.f13060c = C3687f.m15093e(bArr, 3);
        int i = bArr[11] & MotionEventCompat.ACTION_MASK;
        try {
            this.f13061d = new String(bArr, 12, i, this.f13065h);
        } catch (Exception e) {
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
            if (this.f13059b == Downloads.STATUS_RUNNING) {
                this.f13062e = new byte[i];
                System.arraycopy(bArr, i2, this.f13062e, 0, i);
            } else {
                try {
                    this.f13062e = new String(bArr, i2, i, this.f13065h);
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
            this.f13063f = new byte[i];
            System.arraycopy(bArr, i2, this.f13063f, 0, i);
        }
        i += i2;
        if (bArr.length > i) {
            int i3 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            try {
                this.f13064g = new String(bArr, i3, i, this.f13065h);
            } catch (Exception e3) {
            }
            i += i3;
        }
    }

    public byte[] m15966d() {
        byte[] bArr;
        int i = 0;
        try {
            byte[] bytes = this.f13061d.getBytes(this.f13065h);
            r5 = !BuildConfig.FLAVOR.equals(this.f13062e) ? this.f13059b == Downloads.STATUS_RUNNING ? (byte[]) this.f13062e : ((String) this.f13062e).getBytes(this.f13065h) : null;
            byte[] bArr2 = this.f13063f != null ? (byte[]) this.f13063f : null;
            byte[] bytes2 = this.f13064g.getBytes(this.f13065h);
            int length = r5 == null ? 0 : r5.length;
            if (bArr2 != null) {
                i = bArr2.length;
            }
            byte[] a = C3687f.m15081a(length);
            byte[] a2 = C3687f.m15081a(i);
            bArr = new byte[((((((bytes.length + 13) + a.length) + length) + a2.length) + i) + bytes2.length)];
            try {
                int b = C3687f.m15084b(this.f13058a, bArr, 0);
                b += C3687f.m15088c(this.f13059b | m15944a(this.f13065h), bArr, b);
                b += C3687f.m15075a(this.f13060c, bArr, b);
                b += C3687f.m15088c(bytes.length, bArr, b);
                b += C3687f.m15077a(bytes, 0, bArr, b, bytes.length);
                b += C3687f.m15077a(a, 0, bArr, b, a.length);
                if (length > 0) {
                    b += C3687f.m15077a(r5, 0, bArr, b, length);
                }
                b += C3687f.m15077a(a2, 0, bArr, b, a2.length);
                if (i > 0) {
                    b += C3687f.m15077a(bArr2, 0, bArr, b, i);
                }
                b += C3687f.m15088c(bytes2.length, bArr, b);
                b += C3687f.m15077a(bytes2, 0, bArr, b, bytes2.length);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            bArr = null;
        }
        if (bArr != null && bArr.length >= AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            this.j = (byte) (this.j | SpdyProtocol.SLIGHTSSLV2);
        }
        return bArr;
    }
}
