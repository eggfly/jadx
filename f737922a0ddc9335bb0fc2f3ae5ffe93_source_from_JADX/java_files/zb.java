import com.aide.uidesigner.ProxyTextView;
import java.io.UTFDataFormatException;

public class zb {
    private byte[] DW;
    private int FH;
    private StringBuffer Hw;
    private yz j6;
    private StringBuffer v5;

    public zb() {
        this.j6 = new yz();
        this.DW = new byte[8192];
        this.Hw = new StringBuffer();
        this.v5 = new StringBuffer();
    }

    public int j6(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            int i5 = bArr[i3] & 255;
            i3 = (i2 * 37) + i5;
            if ((i5 & 128) != 128) {
                break;
            }
            i2 = i3;
            i3 = i4;
        }
        i2 = i3;
        while (true) {
            i3 = i4 + 1;
            byte b = bArr[i4];
            if (b == null) {
                return j6(bArr, i, i3 - i, i2);
            }
            i2 = b + (i2 * 37);
            i4 = i3;
        }
    }

    private int j6(byte[] bArr, int i, int i2, int i3) {
        if (i2 == 0) {
            throw new IllegalArgumentException();
        }
        int Hw;
        byte[] bArr2 = this.DW;
        this.j6.j6.j6(i3);
        while (this.j6.j6.DW()) {
            Hw = this.j6.j6.Hw();
            if (Hw + i2 <= this.FH) {
                int i4 = 0;
                while (i4 < i2) {
                    if (bArr2[Hw + i4] == bArr[i + i4]) {
                        i4++;
                    }
                }
                return Hw;
            }
        }
        j6(this.FH + i2);
        Object obj = this.DW;
        Hw = this.FH;
        System.arraycopy(bArr, i, obj, this.FH, i2);
        this.FH += i2;
        this.j6.DW(i3, Hw);
        return Hw;
    }

    private void j6(int i) {
        if (this.DW.length < i) {
            int length = this.DW.length * 2;
            while (length < i) {
                length *= 2;
            }
            Object obj = new byte[length];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
    }

    public byte[] j6() {
        return this.DW;
    }

    public int DW() {
        return this.FH;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j6(int r13, int r14) {
        /*
        r12 = this;
        r11 = 5;
        r10 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = 0;
        r6 = r12.DW;
        r0 = r1;
        r2 = r1;
    L_0x0008:
        r3 = r13 + 1;
        r4 = r6[r13];
        r4 = r4 & 255;
        r5 = r4 & 127;
        r7 = r0 * 7;
        r5 = r5 << r7;
        r2 = r2 | r5;
        r0 = r0 + 1;
        r5 = r4 & 128;
        if (r5 != r10) goto L_0x001c;
    L_0x001a:
        if (r0 < r11) goto L_0x00a1;
    L_0x001c:
        r0 = r4 & 128;
        if (r0 != r10) goto L_0x0029;
    L_0x0020:
        r0 = new acz;
        r1 = "invalid LEB128 sequence";
        r0.<init>(r1);
        throw r0;
    L_0x0029:
        r0 = r1;
        r4 = r1;
    L_0x002b:
        r5 = r14 + 1;
        r7 = r6[r14];
        r7 = r7 & 255;
        r8 = r7 & 127;
        r9 = r0 * 7;
        r8 = r8 << r9;
        r4 = r4 | r8;
        r0 = r0 + 1;
        r8 = r7 & 128;
        if (r8 != r10) goto L_0x003f;
    L_0x003d:
        if (r0 < r11) goto L_0x009f;
    L_0x003f:
        r0 = r7 & 128;
        if (r0 != r10) goto L_0x004c;
    L_0x0043:
        r0 = new acz;
        r1 = "invalid LEB128 sequence";
        r0.<init>(r1);
        throw r0;
    L_0x004c:
        r0 = r2 + 1;
        r2 = r4 + 1;
        r4 = java.lang.Math.min(r0, r2);
        r2 = r1;
    L_0x0055:
        if (r2 >= r4) goto L_0x009d;
    L_0x0057:
        r0 = r3 + r2;
        r0 = r6[r0];
        r0 = r0 & 255;
        r7 = r5 + r2;
        r7 = r6[r7];
        r7 = r7 & 255;
        r8 = r0 & 128;
        if (r8 != 0) goto L_0x006b;
    L_0x0067:
        r8 = r7 & 128;
        if (r8 == 0) goto L_0x006f;
    L_0x006b:
        r0 = 1;
    L_0x006c:
        if (r0 != 0) goto L_0x0078;
    L_0x006e:
        return r1;
    L_0x006f:
        r0 = r0 - r7;
        if (r0 == 0) goto L_0x0074;
    L_0x0072:
        r1 = r0;
        goto L_0x006e;
    L_0x0074:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0055;
    L_0x0078:
        r0 = r12.Hw;
        r0.setLength(r1);
        r0 = r12.Hw;
        r12.j6(r3, r0);
        r0 = r12.v5;
        r0.setLength(r1);
        r0 = r12.v5;
        r12.j6(r5, r0);
        r0 = r12.Hw;
        r0 = r0.toString();
        r1 = r12.v5;
        r1 = r1.toString();
        r1 = r12.j6(r0, r1);
        goto L_0x006e;
    L_0x009d:
        r0 = r1;
        goto L_0x006c;
    L_0x009f:
        r14 = r5;
        goto L_0x002b;
    L_0x00a1:
        r13 = r3;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.j6(int, int):int");
    }

    public int j6(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int min = Math.min(length, length2);
        for (int i = 0; i < min; i++) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2) {
                return charAt - charAt2;
            }
        }
        return length - length2;
    }

    private void j6(int i, StringBuffer stringBuffer) {
        byte[] bArr = this.DW;
        while (i < bArr.length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 != 0) {
                switch (i3 >> 4) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                        stringBuffer.append((char) i3);
                        i = i2;
                        break;
                    case 12:
                    case 13:
                        if (i2 < bArr.length) {
                            i = i2 + 1;
                            stringBuffer.append((char) (((bArr[i2] & 255) & 63) | ((i3 & 31) << 6)));
                            break;
                        }
                        throw new RuntimeException(new UTFDataFormatException("End index not on boundary"));
                    case 14:
                        if (i2 + 1 < bArr.length) {
                            int i4 = i2 + 1;
                            i = i4 + 1;
                            stringBuffer.append((char) (((((bArr[i2] & 255) & 63) << 6) | ((i3 & 15) << 12)) | (((bArr[i4] & 255) & 63) << 0)));
                            break;
                        }
                        throw new RuntimeException(new UTFDataFormatException("End index not on boundary"));
                    default:
                        throw new RuntimeException(new UTFDataFormatException("Malformed input"));
                }
            }
            return;
        }
    }

    public int FH() {
        return this.j6.FH();
    }
}
