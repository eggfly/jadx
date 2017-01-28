class akf$4 extends akf {
    akf$4() {
    }

    public boolean j6(ake ake, int i, ake ake2, int i2) {
        int i3 = i + 1;
        int i4 = i2 + 1;
        int j6 = ake.FH.j6(i3);
        int j62 = ake2.FH.j6(i4);
        i3 = ake.FH.j6(i3 + 1);
        i4 = ake2.FH.j6(i4 + 1);
        int j63 = axd.j6(ake.DW, j6, i3);
        if (j63 - j6 != axd.j6(ake2.DW, j62, i4) - j62) {
            return false;
        }
        while (j6 < j63) {
            i3 = j6 + 1;
            byte b = ake.DW[j6];
            j6 = j62 + 1;
            if (b != ake2.DW[j62]) {
                return false;
            }
            j62 = j6;
            j6 = i3;
        }
        return true;
    }

    protected int j6(byte[] bArr, int i, int i2) {
        int i3 = 5381;
        int j6 = axd.j6(bArr, i, i2);
        while (i < j6) {
            i3 = (i3 + (i3 << 5)) + (bArr[i] & 255);
            i++;
        }
        return i3;
    }
}
