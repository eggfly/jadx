package com.igexin.push.p182d.p185c;

import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.d.c.q */
public class C3892q extends C3876e {
    public long f13120a;
    public String f13121b;
    public String f13122c;
    public String f13123d;

    public C3892q() {
        this.f13121b = BuildConfig.FLAVOR;
        this.f13122c = BuildConfig.FLAVOR;
        this.f13123d = BuildConfig.FLAVOR;
        this.i = 9;
    }

    private String m15994a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, HttpRequest.f14548a);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public void m15995a(byte[] bArr) {
        int i;
        int i2;
        this.f13120a = C3687f.m15093e(bArr, 0);
        if (bArr.length > 8) {
            i = 9;
            i2 = bArr[8] & MotionEventCompat.ACTION_MASK;
            if (i2 > 0) {
                this.f13121b = m15994a(bArr, 9, i2);
                i = i2 + 9;
            }
        } else {
            i = 8;
        }
        if (bArr.length > i) {
            i2 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (i > 0) {
                this.f13122c = m15994a(bArr, i2, i);
                i += i2;
            } else {
                i = i2;
            }
        }
        if (bArr.length > i) {
            i2 = i + 1;
            i = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (i > 0) {
                this.f13123d = m15994a(bArr, i2, i);
                i += i2;
            }
        }
    }

    public byte[] m15996d() {
        if (TextUtils.isEmpty(this.f13122c) || TextUtils.isEmpty(this.f13123d)) {
            Object bytes = this.f13121b.getBytes();
            byte[] bArr = new byte[((bytes.length + 8) + 1)];
            C3687f.m15075a(this.f13120a, bArr, 0);
            C3687f.m15088c(bytes.length, bArr, 8);
            System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        bytes = this.f13121b.getBytes();
        Object bytes2 = this.f13122c.getBytes();
        Object bytes3 = this.f13123d.getBytes();
        bArr = new byte[((((bytes.length + 8) + bytes2.length) + bytes3.length) + 3)];
        C3687f.m15075a(this.f13120a, bArr, 0);
        C3687f.m15088c(bytes.length, bArr, 8);
        System.arraycopy(bytes, 0, bArr, 9, bytes.length);
        int length = bytes.length + 9;
        int i = length + 1;
        C3687f.m15088c(bytes2.length, bArr, length);
        System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
        length = bytes2.length + i;
        int i2 = length + 1;
        C3687f.m15088c(bytes3.length, bArr, length);
        System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
        return bArr;
    }
}
