package com.igexin.push.p182d.p185c;

import android.support.v4.view.MotionEventCompat;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.push.util.EncryptUtils;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.d.c.i */
public class C3884i extends C3876e {
    public String f13087a;
    public byte[] f13088b;
    public byte f13089c;
    public String f13090d;

    public C3884i() {
        this.i = 96;
        this.j = (byte) 4;
        this.k = (byte) (this.k | 16);
    }

    private String m15975a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, HttpRequest.f14548a);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public void m15976a(byte[] bArr) {
        try {
            this.f13089c = bArr[0];
            int i = bArr[1] & MotionEventCompat.ACTION_MASK;
            this.f13087a = m15975a(bArr, 2, i);
            int i2 = i + 2;
            i = i2 + 1;
            i2 = bArr[i2] & MotionEventCompat.ACTION_MASK;
            this.f13088b = new byte[i2];
            System.arraycopy(bArr, i, this.f13088b, 0, i2);
            i2 += i;
            this.f13090d = m15975a(bArr, i2 + 1, bArr[i2] & MotionEventCompat.ACTION_MASK);
        } catch (Exception e) {
        }
    }

    public byte[] m15977d() {
        byte[] bytes = this.f13087a.getBytes();
        byte[] iv = EncryptUtils.getIV(C3687f.m15086b((int) (System.currentTimeMillis() / 1000)));
        byte[] socketAESKey = EncryptUtils.getSocketAESKey();
        byte[] bArr = new byte[(((((bytes.length + 2) + 2) + socketAESKey.length) + 1) + iv.length)];
        int c = C3687f.m15088c(0, bArr, 0);
        c += C3687f.m15088c((byte) bytes.length, bArr, c);
        int a = C3687f.m15077a(bytes, 0, bArr, c, bytes.length) + c;
        a += C3687f.m15084b((short) socketAESKey.length, bArr, a);
        a += C3687f.m15077a(socketAESKey, 0, bArr, a, socketAESKey.length);
        a += C3687f.m15088c((byte) iv.length, bArr, a);
        a += C3687f.m15077a(iv, 0, bArr, a, iv.length);
        return bArr;
    }
}
