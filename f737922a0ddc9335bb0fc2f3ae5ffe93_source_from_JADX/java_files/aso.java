class aso {
    final long[] DW;
    final int[] FH;
    final int Hw;
    final int[] j6;
    private int v5;

    aso(byte[] bArr, int i) {
        int i2 = i - (i % 16);
        int i3 = i2 / 16;
        if (i3 < 1) {
            this.j6 = new int[0];
            this.Hw = 0;
            this.DW = new long[0];
            this.FH = new int[0];
            return;
        }
        this.j6 = new int[j6(i3)];
        this.Hw = this.j6.length - 1;
        this.DW = new long[(i3 + 1)];
        this.FH = new int[this.DW.length];
        j6(bArr, i2);
    }

    private void j6(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = i - 16;
        while (true) {
            int j6 = asn.j6(bArr, i3);
            int i4 = this.Hw & j6;
            int i5 = this.j6[i4];
            if (i5 == 0 || r1 != j6) {
                i2 = this.v5 + 1;
                this.v5 = i2;
                this.DW[i2] = (((long) j6) << 32) | ((long) i3);
                this.FH[i2] = i5;
                this.j6[i4] = i2;
            } else {
                this.DW[i5] = (((long) j6) << 32) | ((long) i3);
            }
            i3 -= 16;
            if (i3 >= 0) {
                i2 = j6;
            } else {
                return;
            }
        }
    }

    private static int j6(int i) {
        int numberOfLeadingZeros = 1 << ((32 - Integer.numberOfLeadingZeros(i)) - 1);
        if (numberOfLeadingZeros < i) {
            return numberOfLeadingZeros << 1;
        }
        return numberOfLeadingZeros;
    }
}
