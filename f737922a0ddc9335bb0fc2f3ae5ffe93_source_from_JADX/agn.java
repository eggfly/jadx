public final class agn implements ago {
    private static int[] DW;
    private int j6;

    public agn() {
        this.j6 = 0;
    }

    static {
        DW = null;
        DW = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = 8;
            int i3 = i;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                } else if ((i3 & 1) != 0) {
                    i3 = (i3 >>> 1) ^ -306674912;
                } else {
                    i3 >>>= 1;
                }
            }
            DW[i] = i3;
        }
    }

    public void j6(byte[] bArr, int i, int i2) {
        int i3 = this.j6 ^ -1;
        while (true) {
            i2--;
            if (i2 < 0) {
                this.j6 = i3 ^ -1;
                return;
            }
            i3 = (i3 >>> 8) ^ DW[(bArr[i] ^ i3) & 255];
            i++;
        }
    }

    public void j6() {
        this.j6 = 0;
    }

    public void j6(long j) {
        this.j6 = (int) (4294967295L & j);
    }

    public long DW() {
        return ((long) this.j6) & 4294967295L;
    }
}
