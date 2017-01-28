import java.io.Serializable;

public class ans extends anb implements Serializable {
    private static final String VH;
    private static final ans Zo;

    static {
        Zo = new ans(0, 0, 0, 0, 0);
        VH = Zo.DW();
    }

    public static final ans Zo() {
        return Zo;
    }

    public static final boolean j6(String str) {
        if (str.length() != 40) {
            return false;
        }
        int i = 0;
        while (i < 40) {
            try {
                axe.j6((byte) str.charAt(i));
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }

    public static final String j6(ans ans) {
        return ans != null ? ans.DW() : VH;
    }

    public static boolean j6(byte[] bArr, int i, byte[] bArr2, int i2) {
        return bArr[i] == bArr2[i2] && bArr[i + 1] == bArr2[i2 + 1] && bArr[i + 2] == bArr2[i2 + 2] && bArr[i + 3] == bArr2[i2 + 3] && bArr[i + 4] == bArr2[i2 + 4] && bArr[i + 5] == bArr2[i2 + 5] && bArr[i + 6] == bArr2[i2 + 6] && bArr[i + 7] == bArr2[i2 + 7] && bArr[i + 8] == bArr2[i2 + 8] && bArr[i + 9] == bArr2[i2 + 9] && bArr[i + 10] == bArr2[i2 + 10] && bArr[i + 11] == bArr2[i2 + 11] && bArr[i + 12] == bArr2[i2 + 12] && bArr[i + 13] == bArr2[i2 + 13] && bArr[i + 14] == bArr2[i2 + 14] && bArr[i + 15] == bArr2[i2 + 15] && bArr[i + 16] == bArr2[i2 + 16] && bArr[i + 17] == bArr2[i2 + 17] && bArr[i + 18] == bArr2[i2 + 18] && bArr[i + 19] == bArr2[i2 + 19];
    }

    public static final ans j6(byte[] bArr) {
        return Hw(bArr, 0);
    }

    public static final ans Hw(byte[] bArr, int i) {
        return new ans(axb.DW(bArr, i), axb.DW(bArr, i + 4), axb.DW(bArr, i + 8), axb.DW(bArr, i + 12), axb.DW(bArr, i + 16));
    }

    public static final ans DW(int[] iArr, int i) {
        return new ans(iArr[i], iArr[i + 1], iArr[i + 2], iArr[i + 3], iArr[i + 4]);
    }

    public static final ans v5(byte[] bArr, int i) {
        return Zo(bArr, i);
    }

    public static ans DW(String str) {
        if (str.length() == 40) {
            return Zo(anj.j6(str), 0);
        }
        throw new IllegalArgumentException("Invalid id: " + str);
    }

    private static final ans Zo(byte[] bArr, int i) {
        try {
            return new ans(axe.DW(bArr, i), axe.DW(bArr, i + 8), axe.DW(bArr, i + 16), axe.DW(bArr, i + 24), axe.DW(bArr, i + 32));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ald(bArr, i, 40);
        }
    }

    ans(int i, int i2, int i3, int i4, int i5) {
        this.j6 = i;
        this.DW = i2;
        this.FH = i3;
        this.Hw = i4;
        this.v5 = i5;
    }

    protected ans(anb anb) {
        this.j6 = anb.j6;
        this.DW = anb.DW;
        this.FH = anb.FH;
        this.Hw = anb.Hw;
        this.v5 = anb.v5;
    }

    public ans v5() {
        return this;
    }
}
