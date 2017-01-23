import com.aide.uidesigner.ProxyTextView;
import java.io.OutputStream;

public class asm {
    private final byte[] DW;
    private final int FH;
    private int Hw;
    private final OutputStream j6;

    public asm(OutputStream outputStream, long j, long j2, int i) {
        this.DW = new byte[32];
        this.j6 = outputStream;
        this.FH = i;
        j6(j);
        j6(j2);
    }

    private void j6(long j) {
        int i = 0;
        while (j >= 128) {
            int i2 = i + 1;
            this.DW[i] = (byte) ((((int) j) & 127) | 128);
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.DW[i] = (byte) (((int) j) & 127);
        this.Hw += i3;
        if (this.FH <= 0 || this.Hw < this.FH) {
            this.j6.write(this.DW, 0, i3);
        }
    }

    public boolean j6(byte[] bArr) {
        return j6(bArr, 0, bArr.length);
    }

    public boolean j6(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return true;
        }
        int i3;
        if (this.FH > 0) {
            i3 = i2 / 127;
            if (i2 % 127 != 0) {
                i3++;
            }
            if (this.FH < (i3 + this.Hw) + i2) {
                return false;
            }
        }
        do {
            i3 = Math.min(127, i2);
            this.j6.write((byte) i3);
            this.j6.write(bArr, i, i3);
            i += i3;
            i2 -= i3;
            this.Hw = (i3 + 1) + this.Hw;
        } while (i2 > 0);
        return true;
    }

    public boolean j6(long j, int i) {
        if (i == 0) {
            return true;
        }
        int i2 = 0;
        while (65536 < i) {
            i2 = j6(i2, j, 65536);
            j += 65536;
            i -= 65536;
            if (this.DW.length < i2 + 8) {
                if (this.FH > 0 && this.FH < this.Hw + i2) {
                    return false;
                }
                this.j6.write(this.DW, 0, i2);
                this.Hw = i2 + this.Hw;
                i2 = 0;
            }
        }
        i2 = j6(i2, j, i);
        if (this.FH > 0 && this.FH < this.Hw + i2) {
            return false;
        }
        this.j6.write(this.DW, 0, i2);
        this.Hw += i2;
        return true;
    }

    private int j6(int i, long j, int i2) {
        int i3;
        int i4 = 128;
        int i5 = i + 1;
        if ((j & 255) != 0) {
            i4 = ProxyTextView.INPUTTYPE_textPassword;
            i3 = i5 + 1;
            this.DW[i5] = (byte) ((int) (j & 255));
        } else {
            i3 = i5;
        }
        if ((65280 & j) != 0) {
            i4 |= 2;
            i5 = i3 + 1;
            this.DW[i3] = (byte) ((int) ((j >>> 8) & 255));
        } else {
            i5 = i3;
        }
        if ((16711680 & j) != 0) {
            i4 |= 4;
            i3 = i5 + 1;
            this.DW[i5] = (byte) ((int) ((j >>> 16) & 255));
        } else {
            i3 = i5;
        }
        if ((-16777216 & j) != 0) {
            i4 |= 8;
            i5 = i3 + 1;
            this.DW[i3] = (byte) ((int) ((j >>> 24) & 255));
        } else {
            i5 = i3;
        }
        if (i2 != 65536) {
            if ((i2 & 255) != 0) {
                i4 |= 16;
                i3 = i5 + 1;
                this.DW[i5] = (byte) (i2 & 255);
                i5 = i3;
            }
            if ((65280 & i2) != 0) {
                i4 |= 32;
                i3 = i5 + 1;
                this.DW[i5] = (byte) ((i2 >>> 8) & 255);
            } else {
                i3 = i5;
            }
            if ((16711680 & i2) != 0) {
                i4 |= 64;
                i5 = i3 + 1;
                this.DW[i3] = (byte) ((i2 >>> 16) & 255);
            } else {
                i5 = i3;
            }
        }
        this.DW[i] = (byte) i4;
        return i5;
    }
}
