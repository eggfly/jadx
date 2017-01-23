package com.google.android.gms.p146b;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.kg */
public final class kg {
    private final ByteBuffer f11613a;

    /* renamed from: com.google.android.gms.b.kg.a */
    public static class C3335a extends IOException {
        C3335a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private kg(ByteBuffer byteBuffer) {
        this.f11613a = byteBuffer;
        this.f11613a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private kg(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m13619a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '\u0080') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= '\u0800') {
                i += kg.m13620a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m13620a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) < AccessibilityNodeInfoCompat.ACTION_CUT) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m13621a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '\u0080') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '\u0080' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < '\u0800' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | SpdyProtocol.SLIGHTSSLV2);
            } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | SpdyProtocol.SLIGHTSSLV2);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | SpdyProtocol.SLIGHTSSLV2);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | SpdyProtocol.SLIGHTSSLV2);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('\ud800' > charAt2 || charAt2 > '\udfff' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static kg m13622a(byte[] bArr) {
        return kg.m13623a(bArr, 0, bArr.length);
    }

    public static kg m13623a(byte[] bArr, int i, int i2) {
        return new kg(bArr, i, i2);
    }

    private static void m13624a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(kg.m13621a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            kg.m13633b(charSequence, byteBuffer);
        }
    }

    public static int m13625b(int i) {
        return i >= 0 ? kg.m13643f(i) : 10;
    }

    public static int m13626b(int i, int i2) {
        return kg.m13639d(i) + kg.m13625b(i2);
    }

    public static int m13627b(int i, km kmVar) {
        return (kg.m13639d(i) * 2) + kg.m13637c(kmVar);
    }

    public static int m13628b(int i, String str) {
        return kg.m13639d(i) + kg.m13631b(str);
    }

    public static int m13629b(int i, boolean z) {
        return kg.m13639d(i) + kg.m13632b(z);
    }

    public static int m13630b(int i, byte[] bArr) {
        return kg.m13639d(i) + kg.m13638c(bArr);
    }

    public static int m13631b(String str) {
        int a = kg.m13619a((CharSequence) str);
        return a + kg.m13643f(a);
    }

    public static int m13632b(boolean z) {
        return 1;
    }

    private static void m13633b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | SpdyProtocol.SLIGHTSSLV2));
            } else if (charAt < '\ud800' || '\udfff' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | SpdyProtocol.SLIGHTSSLV2));
                byteBuffer.put((byte) ((charAt & 63) | SpdyProtocol.SLIGHTSSLV2));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | SpdyProtocol.SLIGHTSSLV2));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | SpdyProtocol.SLIGHTSSLV2));
                        byteBuffer.put((byte) ((toCodePoint & 63) | SpdyProtocol.SLIGHTSSLV2));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m13634c(int i, long j) {
        return kg.m13639d(i) + kg.m13636c(j);
    }

    public static int m13635c(int i, km kmVar) {
        return kg.m13639d(i) + kg.m13642d(kmVar);
    }

    public static int m13636c(long j) {
        return kg.m13644f(j);
    }

    public static int m13637c(km kmVar) {
        return kmVar.m10120e();
    }

    public static int m13638c(byte[] bArr) {
        return kg.m13643f(bArr.length) + bArr.length;
    }

    public static int m13639d(int i) {
        return kg.m13643f(kp.m13710a(i, 0));
    }

    public static int m13640d(int i, long j) {
        return kg.m13639d(i) + kg.m13641d(j);
    }

    public static int m13641d(long j) {
        return kg.m13644f(kg.m13645g(j));
    }

    public static int m13642d(km kmVar) {
        int e = kmVar.m10120e();
        return e + kg.m13643f(e);
    }

    public static int m13643f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m13644f(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m13645g(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public int m13646a() {
        return this.f11613a.remaining();
    }

    public void m13647a(byte b) {
        if (this.f11613a.hasRemaining()) {
            this.f11613a.put(b);
            return;
        }
        throw new C3335a(this.f11613a.position(), this.f11613a.limit());
    }

    public void m13648a(int i) {
        if (i >= 0) {
            m13668e(i);
        } else {
            m13669e((long) i);
        }
    }

    public void m13649a(int i, int i2) {
        m13666c(i, 0);
        m13648a(i2);
    }

    public void m13650a(int i, long j) {
        m13666c(i, 0);
        m13655a(j);
    }

    public void m13651a(int i, km kmVar) {
        m13666c(i, 2);
        m13662b(kmVar);
    }

    public void m13652a(int i, String str) {
        m13666c(i, 2);
        m13657a(str);
    }

    public void m13653a(int i, boolean z) {
        m13666c(i, 0);
        m13658a(z);
    }

    public void m13654a(int i, byte[] bArr) {
        m13666c(i, 2);
        m13663b(bArr);
    }

    public void m13655a(long j) {
        m13669e(j);
    }

    public void m13656a(km kmVar) {
        kmVar.m10117a(this);
    }

    public void m13657a(String str) {
        try {
            int f = kg.m13643f(str.length());
            if (f == kg.m13643f(str.length() * 3)) {
                int position = this.f11613a.position();
                if (this.f11613a.remaining() < f) {
                    throw new C3335a(f + position, this.f11613a.limit());
                }
                this.f11613a.position(position + f);
                kg.m13624a((CharSequence) str, this.f11613a);
                int position2 = this.f11613a.position();
                this.f11613a.position(position);
                m13668e((position2 - position) - f);
                this.f11613a.position(position2);
                return;
            }
            m13668e(kg.m13619a((CharSequence) str));
            kg.m13624a((CharSequence) str, this.f11613a);
        } catch (Throwable e) {
            C3335a c3335a = new C3335a(this.f11613a.position(), this.f11613a.limit());
            c3335a.initCause(e);
            throw c3335a;
        }
    }

    public void m13658a(boolean z) {
        m13665c(z ? 1 : 0);
    }

    public void m13659b() {
        if (m13646a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m13660b(int i, long j) {
        m13666c(i, 0);
        m13661b(j);
    }

    public void m13661b(long j) {
        m13669e(kg.m13645g(j));
    }

    public void m13662b(km kmVar) {
        m13668e(kmVar.m10119d());
        kmVar.m10117a(this);
    }

    public void m13663b(byte[] bArr) {
        m13668e(bArr.length);
        m13667d(bArr);
    }

    public void m13664b(byte[] bArr, int i, int i2) {
        if (this.f11613a.remaining() >= i2) {
            this.f11613a.put(bArr, i, i2);
            return;
        }
        throw new C3335a(this.f11613a.position(), this.f11613a.limit());
    }

    public void m13665c(int i) {
        m13647a((byte) i);
    }

    public void m13666c(int i, int i2) {
        m13668e(kp.m13710a(i, i2));
    }

    public void m13667d(byte[] bArr) {
        m13664b(bArr, 0, bArr.length);
    }

    public void m13668e(int i) {
        while ((i & -128) != 0) {
            m13665c((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
            i >>>= 7;
        }
        m13665c(i);
    }

    public void m13669e(long j) {
        while ((-128 & j) != 0) {
            m13665c((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | SpdyProtocol.SLIGHTSSLV2);
            j >>>= 7;
        }
        m13665c((int) j);
    }
}
