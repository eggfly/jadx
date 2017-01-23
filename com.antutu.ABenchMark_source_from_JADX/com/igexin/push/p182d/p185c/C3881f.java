package com.igexin.push.p182d.p185c;

import com.igexin.p158b.p159a.p161b.C3687f;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.d.c.f */
public class C3881f extends C3876e {
    String f13066a;
    String f13067b;
    String f13068c;
    String f13069d;

    public C3881f() {
        this.i = 6;
        this.j = (byte) 20;
        this.f13066a = BuildConfig.FLAVOR;
        this.f13067b = BuildConfig.FLAVOR;
        this.f13068c = BuildConfig.FLAVOR;
        this.f13069d = BuildConfig.FLAVOR;
    }

    public C3881f(String str, String str2, String str3, String str4) {
        this.i = 6;
        this.j = (byte) 20;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f13066a = str;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        this.f13067b = str2;
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        this.f13068c = str3;
        if (str4 == null) {
            str4 = BuildConfig.FLAVOR;
        }
        this.f13069d = str4;
    }

    public String m15967a() {
        return this.f13068c;
    }

    public void m15968a(byte[] bArr) {
        try {
            int a = C3687f.m15076a(bArr, 0);
            this.f13066a = new String(bArr, 1, a, "utf-8");
            a++;
            int a2 = C3687f.m15076a(bArr, a);
            a++;
            this.f13067b = new String(bArr, a, a2, "utf-8");
            a += a2;
            a2 = C3687f.m15076a(bArr, a);
            a++;
            this.f13068c = new String(bArr, a, a2, "utf-8");
            a += a2;
            a2 = C3687f.m15076a(bArr, a);
            a++;
            this.f13069d = new String(bArr, a, a2, "utf-8");
            a += a2;
        } catch (Exception e) {
        }
    }

    public byte[] m15969d() {
        Object bytes = this.f13067b.getBytes();
        Object bytes2 = this.f13066a.getBytes();
        Object bytes3 = this.f13068c.getBytes();
        Object bytes4 = this.f13069d.getBytes();
        Object obj = new byte[((((bytes.length + bytes2.length) + bytes3.length) + bytes4.length) + 4)];
        C3687f.m15088c(bytes.length, obj, 0);
        System.arraycopy(bytes, 0, obj, 1, bytes.length);
        int length = bytes.length + 1;
        int i = length + 1;
        C3687f.m15088c(bytes2.length, obj, length);
        System.arraycopy(bytes2, 0, obj, i, bytes2.length);
        length = bytes2.length + i;
        int i2 = length + 1;
        C3687f.m15088c(bytes3.length, obj, length);
        System.arraycopy(bytes3, 0, obj, i2, bytes3.length);
        length = bytes3.length + i2;
        int i3 = length + 1;
        C3687f.m15088c(bytes4.length, obj, length);
        System.arraycopy(bytes4, 0, obj, i3, bytes4.length);
        length = bytes4.length + i3;
        return obj;
    }
}
