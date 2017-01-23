package com.igexin.push.p182d.p185c;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.igexin.download.Downloads;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.p169f.p170b.C3917b;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.c */
public class C3879c extends C3876e {
    public int f13051a;
    public int f13052b;
    public Object f13053c;
    public String f13054d;
    public String f13055e;
    public int f13056f;
    public C3917b f13057g;

    public C3879c() {
        this.f13055e = HttpRequest.f14548a;
        this.f13056f = 1;
        this.i = 27;
        this.j = (byte) 20;
    }

    public final void m15957a() {
        this.f13052b = 64;
    }

    public void m15958a(int i) {
        this.f13056f = i;
    }

    public void m15959a(C3917b c3917b) {
        this.f13057g = c3917b;
    }

    public void m15960a(byte[] bArr) {
        this.f13051a = C3687f.m15089c(bArr, 0);
        this.f13052b = bArr[2] & Downloads.STATUS_RUNNING;
        this.f13055e = m15945a(bArr[2]);
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
            if (this.f13052b == Downloads.STATUS_RUNNING) {
                this.f13053c = new byte[i2];
                System.arraycopy(bArr, i, this.f13053c, 0, i2);
            } else {
                try {
                    this.f13053c = new String(bArr, i, i2, this.f13055e);
                } catch (Exception e) {
                }
            }
        }
        i2 += i;
        int i3 = bArr[i2] & MotionEventCompat.ACTION_MASK;
        i2++;
        if (bArr.length > i2) {
            try {
                this.f13054d = new String(bArr, i2, i3, this.f13055e);
            } catch (Exception e2) {
            }
            i2 += i3;
        }
    }

    public int m15961c() {
        return this.f13056f;
    }

    public byte[] m15962d() {
        byte[] bArr;
        int i = 0;
        try {
            byte[] bytes = this.f13054d.getBytes(this.f13055e);
            r3 = !BuildConfig.FLAVOR.equals(this.f13053c) ? this.f13052b == Downloads.STATUS_RUNNING ? (byte[]) this.f13053c : ((String) this.f13053c).getBytes(this.f13055e) : null;
            if (r3 != null) {
                i = r3.length;
            }
            byte[] a = C3687f.m15081a(i);
            bArr = new byte[(((a.length + 4) + i) + bytes.length)];
            try {
                int b = C3687f.m15084b(this.f13051a, bArr, 0);
                b += C3687f.m15088c(this.f13052b | m15944a(this.f13055e), bArr, b);
                b += C3687f.m15077a(a, 0, bArr, b, a.length);
                if (i > 0) {
                    b += C3687f.m15077a(r3, 0, bArr, b, i);
                }
                b += C3687f.m15088c(bytes.length, bArr, b);
                b += C3687f.m15077a(bytes, 0, bArr, b, bytes.length);
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

    public C3917b m15963e() {
        return this.f13057g;
    }
}
