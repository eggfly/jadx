public abstract class akf extends aki<ake> {
    public static final akf DW;
    public static final akf FH;
    public static final akf Hw;
    public static final akf j6;
    public static final akf v5;

    protected abstract int j6(byte[] bArr, int i, int i2);

    static {
        j6 = new akf$1();
        DW = new akf$2();
        FH = new akf$3();
        Hw = new akf$4();
        v5 = new akf$5();
    }

    public int j6(ake ake, int i) {
        return j6(ake.DW, ake.FH.j6(i + 1), ake.FH.j6(i + 2));
    }

    public ajv j6(ake ake, ake ake2, ajv ajv) {
        if (ajv.j6 == ajv.DW || ajv.FH == ajv.Hw) {
            return ajv;
        }
        byte[] bArr = ake.DW;
        byte[] bArr2 = ake2.DW;
        int j6 = ake.FH.j6(ajv.j6 + 1);
        int j62 = ake.FH.j6(ajv.FH + 1);
        int j63 = ake.FH.j6(ajv.DW + 1);
        int j64 = ake2.FH.j6(ajv.Hw + 1);
        if (j6 < 0 || j62 < 0 || j63 > bArr.length || j64 > bArr2.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = j6;
        j6 = j62;
        while (i < j63 && j6 < j64) {
            if (bArr[i] != bArr2[j6]) {
                j62 = j63;
                break;
            }
            i++;
            j6++;
        }
        j62 = j63;
        while (i < j62 && j6 < j64 && bArr[j62 - 1] == bArr2[j64 - 1]) {
            j64--;
            j62--;
        }
        ajv.j6 = j6(ake.FH, ajv.j6, i);
        ajv.FH = j6(ake2.FH, ajv.FH, j6);
        ajv.DW = DW(ake.FH, ajv.DW, j62);
        Object obj = j62 < ake.FH.j6(ajv.DW + 1) ? 1 : null;
        if (obj != null) {
            j64 += ake.FH.j6(ajv.DW + 1) - j62;
        }
        ajv.Hw = DW(ake2.FH, ajv.Hw, j64);
        if (obj == null && j64 < ake2.FH.j6(ajv.Hw + 1)) {
            ajv.DW++;
        }
        return super.j6(ake, ake2, ajv);
    }

    private static int j6(awy awy, int i, int i2) {
        int j6 = awy.j6() - 2;
        while (i < j6 && awy.j6(i + 2) < i2) {
            i++;
        }
        return i;
    }

    private static int DW(awy awy, int i, int i2) {
        while (i > 0 && i2 <= awy.j6(i)) {
            i--;
        }
        return i;
    }
}
