import java.io.Serializable;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public final class amz implements Serializable {
    final int DW;
    final int FH;
    final int Hw;
    final int Zo;
    final int j6;
    final int v5;

    public static final boolean j6(String str) {
        if (str.length() < 2 || 40 < str.length()) {
            return false;
        }
        int i = 0;
        while (i < str.length()) {
            try {
                axe.j6((byte) str.charAt(i));
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }

    public static final amz j6(byte[] bArr, int i, int i2) {
        if (i2 - i <= 40) {
            return DW(bArr, i, i2);
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidIdLength, new Object[]{Integer.valueOf(i2 - i), Integer.valueOf(40)}));
    }

    public static final amz j6(anb anb) {
        return new amz(40, anb.j6, anb.DW, anb.FH, anb.Hw, anb.v5);
    }

    public static final amz DW(String str) {
        if (str.length() > 40) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().invalidId, new Object[]{str}));
        }
        byte[] j6 = anj.j6(str);
        return DW(j6, 0, j6.length);
    }

    private static final amz DW(byte[] bArr, int i, int i2) {
        try {
            return new amz(i2 - i, FH(bArr, i, i2), FH(bArr, i + 8, i2), FH(bArr, i + 16, i2), FH(bArr, i + 24, i2), FH(bArr, i + 32, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ald(bArr, i, i2 - i);
        }
    }

    private static final int FH(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (8 <= i2 - i) {
            return axe.DW(bArr, i);
        }
        int i4 = 0;
        while (i3 < 8 && i < i2) {
            i4 = (i4 << 4) | axe.j6(bArr[i]);
            i3++;
            i++;
        }
        return i4 << ((8 - i3) * 4);
    }

    static int j6(int i, int i2, int i3) {
        int i4 = (i2 - 1) * 8;
        if (i4 + 8 <= i) {
            return i3;
        }
        if (i <= i4) {
            return 0;
        }
        i4 = 32 - ((i - i4) * 4);
        return (i3 >>> i4) << i4;
    }

    amz(int i, int i2, int i3, int i4, int i5, int i6) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = i4;
        this.v5 = i5;
        this.Zo = i6;
    }

    public int j6() {
        return this.j6;
    }

    public boolean DW() {
        return j6() == 40;
    }

    public ans FH() {
        return DW() ? new ans(this.DW, this.FH, this.Hw, this.v5, this.Zo) : null;
    }

    public final int DW(anb anb) {
        int j6 = axb.j6(this.DW, j6(1, anb.j6));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, j6(2, anb.DW));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, j6(3, anb.FH));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.v5, j6(4, anb.Hw));
        return j6 == 0 ? axb.j6(this.Zo, j6(5, anb.v5)) : j6;
    }

    public final int j6(byte[] bArr, int i) {
        int j6 = axb.j6(this.DW, j6(1, axb.DW(bArr, i)));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, j6(2, axb.DW(bArr, i + 4)));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, j6(3, axb.DW(bArr, i + 8)));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.v5, j6(4, axb.DW(bArr, i + 12)));
        return j6 == 0 ? axb.j6(this.Zo, j6(5, axb.DW(bArr, i + 16))) : j6;
    }

    public final int j6(int[] iArr, int i) {
        int j6 = axb.j6(this.DW, j6(1, iArr[i]));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.FH, j6(2, iArr[i + 1]));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.Hw, j6(3, iArr[i + 2]));
        if (j6 != 0) {
            return j6;
        }
        j6 = axb.j6(this.v5, j6(4, iArr[i + 3]));
        return j6 == 0 ? axb.j6(this.Zo, j6(5, iArr[i + 4])) : j6;
    }

    public final int Hw() {
        return this.DW >>> 24;
    }

    private int j6(int i, int i2) {
        return j6(this.j6, i, i2);
    }

    public int hashCode() {
        return this.FH;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof amz)) {
            return false;
        }
        amz amz = (amz) obj;
        if (this.j6 == amz.j6 && this.DW == amz.DW && this.FH == amz.FH && this.Hw == amz.Hw && this.v5 == amz.v5 && this.Zo == amz.Zo) {
            return true;
        }
        return false;
    }

    public final String v5() {
        char[] cArr = new char[40];
        anb.j6(cArr, 0, this.DW);
        if (this.j6 <= 8) {
            return new String(cArr, 0, this.j6);
        }
        anb.j6(cArr, 8, this.FH);
        if (this.j6 <= 16) {
            return new String(cArr, 0, this.j6);
        }
        anb.j6(cArr, 16, this.Hw);
        if (this.j6 <= 24) {
            return new String(cArr, 0, this.j6);
        }
        anb.j6(cArr, 24, this.v5);
        if (this.j6 <= 32) {
            return new String(cArr, 0, this.j6);
        }
        anb.j6(cArr, 32, this.Zo);
        return new String(cArr, 0, this.j6);
    }

    public String toString() {
        return "AbbreviatedObjectId[" + v5() + "]";
    }
}
