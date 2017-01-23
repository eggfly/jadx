package com.igexin.push.p182d.p185c;

import com.igexin.p158b.p159a.p161b.C3687f;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.o */
public class C3890o extends C3876e {
    public boolean f13106a;
    public boolean f13107b;
    public String f13108c;
    public String f13109d;
    public long f13110e;

    public C3890o() {
        this.i = 37;
    }

    public void m15989a(byte[] bArr) {
        int i = 1;
        boolean z = false;
        byte b = bArr[0];
        this.f13106a = (b & 64) != 0;
        if ((b & SpdyProtocol.SLIGHTSSLV2) != 0) {
            z = true;
        }
        this.f13107b = z;
        if (this.f13107b) {
            this.f13108c = m15945a(b);
            int c = C3687f.m15089c(bArr, 1);
            i = (c + 2) + 1;
            try {
                this.f13109d = new String(bArr, 3, c, this.f13108c);
            } catch (Exception e) {
            }
        }
        if (bArr.length > i) {
            this.f13110e = C3687f.m15093e(bArr, i);
            c = i + 8;
        }
    }

    public byte[] m15990d() {
        int i;
        byte[] bytes;
        int i2;
        byte a;
        int i3;
        byte[] bArr;
        int i4 = this.f13106a ? (byte) 64 : 0;
        if (this.f13107b) {
            byte b = (byte) (i4 | SpdyProtocol.SLIGHTSSLV2);
            i = 3;
            try {
                bytes = this.f13109d.getBytes(this.f13108c);
                try {
                    i = bytes.length;
                    i2 = i + 3;
                } catch (Exception e) {
                    i2 = i;
                    i = 0;
                    a = (byte) (b | m15944a(this.f13108c));
                    i3 = i2;
                    i2 = a;
                    bArr = new byte[(i3 + 8)];
                    i2 = C3687f.m15088c(i2, bArr, 0);
                    if (this.f13107b) {
                        i2 = C3687f.m15084b(i, bArr, i2);
                        if (bytes != null) {
                            i4 = C3687f.m15077a(bytes, 0, bArr, i2, i) + i2;
                            i4 += C3687f.m15075a(this.f13110e, bArr, i4);
                            return bArr;
                        }
                    }
                    i4 = i2;
                    i4 += C3687f.m15075a(this.f13110e, bArr, i4);
                    return bArr;
                }
            } catch (Exception e2) {
                bytes = null;
                i2 = i;
                i = 0;
                a = (byte) (b | m15944a(this.f13108c));
                i3 = i2;
                i2 = a;
                bArr = new byte[(i3 + 8)];
                i2 = C3687f.m15088c(i2, bArr, 0);
                if (this.f13107b) {
                    i2 = C3687f.m15084b(i, bArr, i2);
                    if (bytes != null) {
                        i4 = C3687f.m15077a(bytes, 0, bArr, i2, i) + i2;
                        i4 += C3687f.m15075a(this.f13110e, bArr, i4);
                        return bArr;
                    }
                }
                i4 = i2;
                i4 += C3687f.m15075a(this.f13110e, bArr, i4);
                return bArr;
            }
            a = (byte) (b | m15944a(this.f13108c));
            i3 = i2;
            i2 = a;
        } else {
            i3 = 1;
            i = 0;
            int i5 = i4;
            bytes = null;
            i2 = i5;
        }
        bArr = new byte[(i3 + 8)];
        i2 = C3687f.m15088c(i2, bArr, 0);
        if (this.f13107b) {
            i2 = C3687f.m15084b(i, bArr, i2);
            if (bytes != null) {
                i4 = C3687f.m15077a(bytes, 0, bArr, i2, i) + i2;
                i4 += C3687f.m15075a(this.f13110e, bArr, i4);
                return bArr;
            }
        }
        i4 = i2;
        i4 += C3687f.m15075a(this.f13110e, bArr, i4);
        return bArr;
    }
}
