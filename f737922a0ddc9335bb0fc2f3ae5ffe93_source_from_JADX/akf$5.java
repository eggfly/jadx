class akf$5 extends akf {
    akf$5() {
    }

    public boolean j6(ake ake, int i, ake ake2, int i2) {
        int i3 = i + 1;
        int i4 = i2 + 1;
        int j6 = ake.FH.j6(i3);
        int j62 = ake2.FH.j6(i4);
        i3 = ake.FH.j6(i3 + 1);
        i4 = ake2.FH.j6(i4 + 1);
        i3 = axd.j6(ake.DW, j6, i3);
        i4 = axd.j6(ake2.DW, j62, i4);
        int i5 = j62;
        j62 = j6;
        j6 = i5;
        while (j62 < i3 && j6 < i4) {
            byte b = ake.DW[j62];
            byte b2 = ake2.DW[j6];
            if (b != b2) {
                return false;
            }
            if (axd.j6(b)) {
                j62 = axd.DW(ake.DW, j62, i3);
            } else {
                j62++;
            }
            if (axd.j6(b2)) {
                j6 = axd.DW(ake2.DW, j6, i4);
            } else {
                j6++;
            }
        }
        if (j62 == i3 && j6 == i4) {
            return true;
        }
        return false;
    }

    protected int j6(byte[] bArr, int i, int i2) {
        int i3 = 5381;
        int j6 = axd.j6(bArr, i, i2);
        while (i < j6) {
            byte b = bArr[i];
            i3 = (i3 + (i3 << 5)) + (b & 255);
            if (axd.j6(b)) {
                i = axd.DW(bArr, i, j6);
            } else {
                i++;
            }
        }
        return i3;
    }
}
