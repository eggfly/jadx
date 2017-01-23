package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class m {
    private final ByteBuffer j6;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private m(ByteBuffer byteBuffer) {
        this.j6 = byteBuffer;
        this.j6.order(ByteOrder.LITTLE_ENDIAN);
    }

    private m(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int DW(double d) {
        return 8;
    }

    public static int DW(float f) {
        return 4;
    }

    public static int DW(int i) {
        return i >= 0 ? Zo(i) : 10;
    }

    public static int DW(int i, double d) {
        return Hw(i) + DW(d);
    }

    public static int DW(int i, float f) {
        return Hw(i) + DW(f);
    }

    public static int DW(int i, int i2) {
        return Hw(i) + DW(i2);
    }

    public static int DW(int i, t tVar) {
        return (Hw(i) * 2) + FH(tVar);
    }

    public static int DW(int i, String str) {
        return Hw(i) + DW(str);
    }

    public static int DW(int i, boolean z) {
        return Hw(i) + DW(z);
    }

    public static int DW(int i, byte[] bArr) {
        return Hw(i) + FH(bArr);
    }

    public static int DW(String str) {
        int j6 = j6((CharSequence) str);
        return j6 + Zo(j6);
    }

    public static int DW(boolean z) {
        return 1;
    }

    private static void DW(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '\ud800' || '\udfff' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int FH(int i, t tVar) {
        return Hw(i) + Hw(tVar);
    }

    public static int FH(t tVar) {
        return tVar.VH();
    }

    public static int FH(byte[] bArr) {
        return Zo(bArr.length) + bArr.length;
    }

    public static int Hw(int i) {
        return Zo(w.j6(i, 0));
    }

    public static int Hw(int i, long j) {
        return Hw(i) + v5(j);
    }

    public static int Hw(long j) {
        return gn(j);
    }

    public static int Hw(t tVar) {
        int VH = tVar.VH();
        return VH + Zo(VH);
    }

    public static int Zo(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int Zo(long j) {
        return gn(tp(j));
    }

    public static int gn(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private static int j6(CharSequence charSequence) {
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
                i += j6(charSequence, i2);
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

    private static int j6(CharSequence charSequence, int i) {
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
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int j6(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static m j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public static m j6(byte[] bArr, int i, int i2) {
        return new m(bArr, i, i2);
    }

    private static void j6(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(j6(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            DW(charSequence, byteBuffer);
        }
    }

    public static long tp(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int v5(int i, long j) {
        return Hw(i) + Zo(j);
    }

    public static int v5(long j) {
        return gn(j);
    }

    public void DW() {
        if (j6() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void DW(int i, long j) {
        FH(i, 0);
        DW(j);
    }

    public void DW(long j) {
        VH(j);
    }

    public void DW(t tVar) {
        v5(tVar.Zo());
        tVar.j6(this);
    }

    public void DW(byte[] bArr) {
        v5(bArr.length);
        Hw(bArr);
    }

    public void DW(byte[] bArr, int i, int i2) {
        if (this.j6.remaining() >= i2) {
            this.j6.put(bArr, i, i2);
            return;
        }
        throw new a(this.j6.position(), this.j6.limit());
    }

    public void FH(int i) {
        j6((byte) i);
    }

    public void FH(int i, int i2) {
        v5(w.j6(i, i2));
    }

    public void FH(int i, long j) {
        FH(i, 0);
        FH(j);
    }

    public void FH(long j) {
        VH(tp(j));
    }

    public void Hw(byte[] bArr) {
        DW(bArr, 0, bArr.length);
    }

    public void VH(int i) {
        if (this.j6.remaining() < 4) {
            throw new a(this.j6.position(), this.j6.limit());
        }
        this.j6.putInt(i);
    }

    public void VH(long j) {
        while ((-128 & j) != 0) {
            FH((((int) j) & 127) | 128);
            j >>>= 7;
        }
        FH((int) j);
    }

    public int j6() {
        return this.j6.remaining();
    }

    public void j6(byte b) {
        if (this.j6.hasRemaining()) {
            this.j6.put(b);
            return;
        }
        throw new a(this.j6.position(), this.j6.limit());
    }

    public void j6(double d) {
        u7(Double.doubleToLongBits(d));
    }

    public void j6(float f) {
        VH(Float.floatToIntBits(f));
    }

    public void j6(int i) {
        if (i >= 0) {
            v5(i);
        } else {
            VH((long) i);
        }
    }

    public void j6(int i, double d) {
        FH(i, 1);
        j6(d);
    }

    public void j6(int i, float f) {
        FH(i, 5);
        j6(f);
    }

    public void j6(int i, int i2) {
        FH(i, 0);
        j6(i2);
    }

    public void j6(int i, long j) {
        FH(i, 0);
        j6(j);
    }

    public void j6(int i, t tVar) {
        FH(i, 2);
        DW(tVar);
    }

    public void j6(int i, String str) {
        FH(i, 2);
        j6(str);
    }

    public void j6(int i, boolean z) {
        FH(i, 0);
        j6(z);
    }

    public void j6(int i, byte[] bArr) {
        FH(i, 2);
        DW(bArr);
    }

    public void j6(long j) {
        VH(j);
    }

    public void j6(t tVar) {
        tVar.j6(this);
    }

    public void j6(String str) {
        try {
            int Zo = Zo(str.length());
            if (Zo == Zo(str.length() * 3)) {
                int position = this.j6.position();
                if (this.j6.remaining() < Zo) {
                    throw new a(Zo + position, this.j6.limit());
                }
                this.j6.position(position + Zo);
                j6((CharSequence) str, this.j6);
                int position2 = this.j6.position();
                this.j6.position(position);
                v5((position2 - position) - Zo);
                this.j6.position(position2);
                return;
            }
            v5(j6((CharSequence) str));
            j6((CharSequence) str, this.j6);
        } catch (Throwable e) {
            a aVar = new a(this.j6.position(), this.j6.limit());
            aVar.initCause(e);
            throw aVar;
        }
    }

    public void j6(boolean z) {
        FH(z ? 1 : 0);
    }

    public void u7(long j) {
        if (this.j6.remaining() < 8) {
            throw new a(this.j6.position(), this.j6.limit());
        }
        this.j6.putLong(j);
    }

    public void v5(int i) {
        while ((i & -128) != 0) {
            FH((i & 127) | 128);
            i >>>= 7;
        }
        FH(i);
    }
}
