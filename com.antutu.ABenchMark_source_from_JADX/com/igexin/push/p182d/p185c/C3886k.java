package com.igexin.push.p182d.p185c;

import android.support.v4.view.MotionEventCompat;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.d.c.k */
public class C3886k extends C3876e {
    public long f13093a;
    public byte f13094b;
    public int f13095c;
    public String f13096d;
    public List f13097e;

    public C3886k() {
        this.i = 4;
        this.j = (byte) 20;
    }

    private String m15980a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, HttpRequest.f14548a);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public void m15981a(byte[] bArr) {
        int i;
        this.f13093a = C3687f.m15093e(bArr, 0);
        this.f13094b = bArr[8];
        this.f13095c = C3687f.m15091d(bArr, 9) & -1;
        if (bArr.length > 13) {
            i = 14;
            int i2 = bArr[13] & MotionEventCompat.ACTION_MASK;
            if (i2 > 0) {
                this.f13097e = new ArrayList();
                i2 += 14;
                while (i < i2) {
                    C3887l c3887l = new C3887l();
                    this.f13097e.add(c3887l);
                    int i3 = i + 1;
                    i = C3687f.m15076a(bArr, i) & MotionEventCompat.ACTION_MASK;
                    int i4 = i3 + 1;
                    i3 = C3687f.m15076a(bArr, i3) & MotionEventCompat.ACTION_MASK;
                    c3887l.f13098a = (byte) i;
                    if ((i == 1 || i == 4) && i3 > 0) {
                        try {
                            c3887l.f13099b = new String(bArr, i4, i3, HttpRequest.f14548a);
                        } catch (Exception e) {
                        }
                    }
                    i = i4 + i3;
                }
            }
        } else {
            i = 13;
        }
        if (bArr.length > i) {
            this.f13096d = m15980a(bArr, i + 1, bArr[i] & MotionEventCompat.ACTION_MASK);
        }
    }

    public byte[] m15982d() {
        byte[] bArr;
        int length;
        int i;
        byte[] bArr2 = null;
        if (this.f13097e == null || this.f13097e.size() <= 0) {
            bArr = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (C3887l d : this.f13097e) {
                byte[] toByteArray;
                try {
                    byteArrayOutputStream.write(d.m15984d());
                    toByteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    toByteArray = bArr2;
                }
                bArr2 = toByteArray;
            }
            try {
                byteArrayOutputStream.close();
                bArr = bArr2;
            } catch (IOException e2) {
                bArr = bArr2;
            }
        }
        if (bArr != null) {
            length = bArr.length;
            i = length + 1;
        } else {
            i = 1;
            length = 0;
        }
        byte[] bArr3 = new byte[(((i + 12) + this.f13096d.getBytes().length) + 1)];
        i = C3687f.m15075a(this.f13093a, bArr3, 0);
        i += C3687f.m15074a(((this.f13094b & MotionEventCompat.ACTION_MASK) << 24) | this.f13095c, bArr3, i);
        i += C3687f.m15088c(length, bArr3, i);
        length = length > 0 ? C3687f.m15077a(bArr, 0, bArr3, i, length) + i : i;
        Object bytes = this.f13096d.getBytes();
        int i2 = length + 1;
        C3687f.m15088c(bytes.length, bArr3, length);
        System.arraycopy(bytes, 0, bArr3, i2, bytes.length);
        length = bytes.length + i2;
        return bArr3;
    }
}
