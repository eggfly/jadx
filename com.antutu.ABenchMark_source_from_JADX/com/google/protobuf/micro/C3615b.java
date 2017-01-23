package com.google.protobuf.micro;

import android.support.v4.media.TransportMediator;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.protobuf.micro.b */
public final class C3615b {
    private final byte[] f12277a;
    private final int f12278b;
    private int f12279c;
    private final OutputStream f12280d;

    /* renamed from: com.google.protobuf.micro.b.a */
    public static class C3614a extends IOException {
        C3614a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C3615b(OutputStream outputStream, byte[] bArr) {
        this.f12280d = outputStream;
        this.f12277a = bArr;
        this.f12279c = 0;
        this.f12278b = bArr.length;
    }

    private C3615b(byte[] bArr, int i, int i2) {
        this.f12280d = null;
        this.f12277a = bArr;
        this.f12279c = i;
        this.f12278b = i + i2;
    }

    public static C3615b m14835a(OutputStream outputStream) {
        return C3615b.m14836a(outputStream, (int) SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
    }

    public static C3615b m14836a(OutputStream outputStream, int i) {
        return new C3615b(outputStream, new byte[i]);
    }

    public static C3615b m14837a(byte[] bArr, int i, int i2) {
        return new C3615b(bArr, i, i2);
    }

    public static int m14838b(int i, boolean z) {
        return C3615b.m14846f(i) + C3615b.m14840b(z);
    }

    public static int m14839b(String str) {
        try {
            byte[] bytes = str.getBytes(HttpRequest.f14548a);
            return bytes.length + C3615b.m14847h(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m14840b(boolean z) {
        return 1;
    }

    public static int m14841c(int i) {
        return i >= 0 ? C3615b.m14847h(i) : 10;
    }

    public static int m14842c(int i, int i2) {
        return C3615b.m14846f(i) + C3615b.m14841c(i2);
    }

    public static int m14843d(int i) {
        return C3615b.m14847h(i);
    }

    public static int m14844d(int i, int i2) {
        return C3615b.m14846f(i) + C3615b.m14843d(i2);
    }

    private void m14845d() {
        if (this.f12280d == null) {
            throw new C3614a();
        }
        this.f12280d.write(this.f12277a, 0, this.f12279c);
        this.f12279c = 0;
    }

    public static int m14846f(int i) {
        return C3615b.m14847h(C3618e.m14882a(i, 0));
    }

    public static int m14847h(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public void m14848a() {
        if (this.f12280d != null) {
            m14845d();
        }
    }

    public void m14849a(byte b) {
        if (this.f12279c == this.f12278b) {
            m14845d();
        }
        byte[] bArr = this.f12277a;
        int i = this.f12279c;
        this.f12279c = i + 1;
        bArr[i] = b;
    }

    public void m14850a(int i) {
        if (i >= 0) {
            m14865g(i);
        } else {
            m14854a((long) i);
        }
    }

    public void m14851a(int i, int i2) {
        m14864e(i, 0);
        m14850a(i2);
    }

    public void m14852a(int i, String str) {
        m14864e(i, 2);
        m14855a(str);
    }

    public void m14853a(int i, boolean z) {
        m14864e(i, 0);
        m14856a(z);
    }

    public void m14854a(long j) {
        while ((-128 & j) != 0) {
            m14863e((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
            j >>>= 7;
        }
        m14863e((int) j);
    }

    public void m14855a(String str) {
        byte[] bytes = str.getBytes(HttpRequest.f14548a);
        m14865g(bytes.length);
        m14857a(bytes);
    }

    public void m14856a(boolean z) {
        m14863e(z ? 1 : 0);
    }

    public void m14857a(byte[] bArr) {
        m14861b(bArr, 0, bArr.length);
    }

    public int m14858b() {
        if (this.f12280d == null) {
            return this.f12278b - this.f12279c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void m14859b(int i) {
        m14865g(i);
    }

    public void m14860b(int i, int i2) {
        m14864e(i, 0);
        m14859b(i2);
    }

    public void m14861b(byte[] bArr, int i, int i2) {
        if (this.f12278b - this.f12279c >= i2) {
            System.arraycopy(bArr, i, this.f12277a, this.f12279c, i2);
            this.f12279c += i2;
            return;
        }
        int i3 = this.f12278b - this.f12279c;
        System.arraycopy(bArr, i, this.f12277a, this.f12279c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f12279c = this.f12278b;
        m14845d();
        if (i3 <= this.f12278b) {
            System.arraycopy(bArr, i4, this.f12277a, 0, i3);
            this.f12279c = i3;
            return;
        }
        this.f12280d.write(bArr, i4, i3);
    }

    public void m14862c() {
        if (m14858b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m14863e(int i) {
        m14849a((byte) i);
    }

    public void m14864e(int i, int i2) {
        m14865g(C3618e.m14882a(i, i2));
    }

    public void m14865g(int i) {
        while ((i & -128) != 0) {
            m14863e((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
            i >>>= 7;
        }
        m14863e(i);
    }
}
