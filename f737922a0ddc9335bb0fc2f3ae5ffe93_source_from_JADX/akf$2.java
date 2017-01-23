class akf$2 extends akf {
    akf$2() {
    }

    public boolean j6(ake ake, int i, ake ake2, int i2) {
        int i3 = i + 1;
        int i4 = i2 + 1;
        int j6 = ake.FH.j6(i3);
        int j62 = ake2.FH.j6(i4);
        i3 = ake.FH.j6(i3 + 1);
        i4 = ake2.FH.j6(i4 + 1);
        int j63 = axd.j6(ake.DW, j6, i3);
        int j64 = axd.j6(ake2.DW, j62, i4);
        while (j6 < j63 && j62 < j64) {
            byte b = ake.DW[j6];
            byte b2 = ake2.DW[j62];
            while (j6 < j63 - 1 && axd.j6(b)) {
                j6++;
                b = ake.DW[j6];
            }
            while (j62 < j64 - 1 && axd.j6(b2)) {
                j62++;
                b2 = ake2.DW[j62];
            }
            if (b != b2) {
                return false;
            }
            j6++;
            j62++;
        }
        if (j6 == j63 && j62 == j64) {
            return true;
        }
        return false;
    }

    protected int j6(byte[] bArr, int i, int i2) {
        int i3 = 5381;
        while (i < i2) {
            byte b = bArr[i];
            if (!axd.j6(b)) {
                i3 = (i3 + (i3 << 5)) + (b & 255);
            }
            i++;
        }
        return i3;
    }
}
