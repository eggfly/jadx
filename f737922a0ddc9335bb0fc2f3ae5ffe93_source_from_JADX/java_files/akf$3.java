class akf$3 extends akf {
    akf$3() {
    }

    public boolean j6(ake ake, int i, ake ake2, int i2) {
        int i3 = i + 1;
        int i4 = i2 + 1;
        int j6 = ake.FH.j6(i3);
        int j62 = ake2.FH.j6(i4);
        int j63 = ake.FH.j6(i3 + 1);
        int j64 = ake2.FH.j6(i4 + 1);
        i4 = axd.DW(ake.DW, j6, j63);
        i3 = axd.DW(ake2.DW, j62, j64);
        if (j63 - i4 != j64 - i3) {
            return false;
        }
        while (i4 < j63) {
            j6 = i4 + 1;
            byte b = ake.DW[i4];
            i4 = i3 + 1;
            if (b != ake2.DW[i3]) {
                return false;
            }
            i3 = i4;
            i4 = j6;
        }
        return true;
    }

    protected int j6(byte[] bArr, int i, int i2) {
        int i3 = 5381;
        for (int DW = axd.DW(bArr, i, i2); DW < i2; DW++) {
            i3 = (i3 + (i3 << 5)) + (bArr[DW] & 255);
        }
        return i3;
    }
}
