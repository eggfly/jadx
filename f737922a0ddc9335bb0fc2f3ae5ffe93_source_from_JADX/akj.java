import java.io.InputStream;
import java.util.Arrays;

class akj {
    private static final akj$a j6;
    private long DW;
    private int FH;
    private int Hw;
    private int Zo;
    private long[] v5;

    static {
        j6 = new akj$a();
    }

    akj() {
        this.Zo = 8;
        this.v5 = new long[(1 << this.Zo)];
        this.Hw = FH(this.Zo);
    }

    void j6(long j) {
        this.DW = j;
    }

    void j6(anx anx) {
        if (anx.Hw()) {
            InputStream FH = anx.FH();
            try {
                j6(FH.j6());
                j6(FH, this.DW);
            } finally {
                FH.close();
            }
        } else {
            byte[] v5 = anx.v5();
            j6((long) v5.length);
            j6(v5, 0, v5.length);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(byte[] r6, int r7, int r8) {
        /*
        r5 = this;
        r2 = r7;
    L_0x0001:
        if (r2 < r8) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        r0 = 5381; // 0x1505 float:7.54E-42 double:2.6586E-320;
        r1 = r2;
    L_0x0007:
        r3 = r1 + 1;
        r1 = r6[r1];
        r1 = r1 & 255;
        r4 = 10;
        if (r1 != r4) goto L_0x0018;
    L_0x0011:
        r1 = r3 - r2;
        r5.j6(r0, r1);
        r2 = r3;
        goto L_0x0001;
    L_0x0018:
        r4 = r0 << 5;
        r0 = r0 + r4;
        r0 = r0 + r1;
        if (r3 >= r8) goto L_0x0011;
    L_0x001e:
        r1 = r3 - r2;
        r4 = 64;
        if (r1 >= r4) goto L_0x0011;
    L_0x0024:
        r1 = r3;
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: akj.j6(byte[], int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(java.io.InputStream r11, long r12) {
        /*
        r10 = this;
        r2 = 0;
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r6 = new byte[r0];
        r0 = r2;
        r1 = r2;
    L_0x0007:
        r4 = 0;
        r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r3 = 5381; // 0x1505 float:7.54E-42 double:2.6586E-320;
        r4 = r2;
    L_0x0011:
        if (r1 != r0) goto L_0x0021;
    L_0x0013:
        r0 = r6.length;
        r0 = r11.read(r6, r2, r0);
        if (r0 > 0) goto L_0x0020;
    L_0x001a:
        r0 = new java.io.EOFException;
        r0.<init>();
        throw r0;
    L_0x0020:
        r1 = r2;
    L_0x0021:
        r4 = r4 + 1;
        r5 = r1 + 1;
        r1 = r6[r1];
        r1 = r1 & 255;
        r7 = 10;
        if (r1 != r7) goto L_0x0035;
    L_0x002d:
        r1 = r3;
    L_0x002e:
        r10.j6(r1, r4);
        r8 = (long) r4;
        r12 = r12 - r8;
        r1 = r5;
        goto L_0x0007;
    L_0x0035:
        r7 = r3 << 5;
        r3 = r3 + r7;
        r1 = r1 + r3;
        r3 = 64;
        if (r4 >= r3) goto L_0x002e;
    L_0x003d:
        r8 = (long) r4;
        r3 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r3 >= 0) goto L_0x002e;
    L_0x0042:
        r3 = r1;
        r1 = r5;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: akj.j6(java.io.InputStream, long):void");
    }

    void j6() {
        Arrays.sort(this.v5);
    }

    int j6(akj akj, int i) {
        long max = Math.max(this.DW, akj.DW);
        return max == 0 ? i : (int) ((j6(akj) * ((long) i)) / max);
    }

    long j6(akj akj) {
        return j6(this, akj);
    }

    private static long j6(akj akj, akj akj2) {
        return j6(akj.v5, akj.j6(0), akj2.v5, akj2.j6(0));
    }

    private static long j6(long[] jArr, int i, long[] jArr2, int i2) {
        long j = 0;
        if (!(i == jArr.length || i2 == jArr2.length)) {
            int DW = DW(jArr[i]);
            int DW2 = DW(jArr2[i2]);
            while (true) {
                if (DW != DW2) {
                    if (DW >= DW2) {
                        i2++;
                        if (i2 == jArr2.length) {
                            break;
                        }
                        DW2 = DW(jArr2[i2]);
                    } else {
                        i++;
                        if (i == jArr.length) {
                            break;
                        }
                        DW = DW(jArr[i]);
                    }
                } else {
                    j += Math.min(FH(jArr[i]), FH(jArr2[i2]));
                    i++;
                    if (i == jArr.length) {
                        break;
                    }
                    DW = DW(jArr[i]);
                    i2++;
                    if (i2 == jArr2.length) {
                        break;
                    }
                    DW2 = DW(jArr2[i2]);
                }
            }
        }
        return j;
    }

    private int j6(int i) {
        return (this.v5.length - this.FH) + i;
    }

    void j6(int i, int i2) {
        int i3 = (-1640562687 * i) >>> 1;
        int DW = DW(i3);
        while (true) {
            long j = this.v5[DW];
            if (j == 0) {
                if (this.Hw <= this.FH) {
                    DW();
                    DW = DW(i3);
                } else {
                    this.v5[DW] = j6(i3, (long) i2);
                    this.FH++;
                    return;
                }
            } else if (DW(j) == i3) {
                this.v5[DW] = j6(i3, FH(j) + ((long) i2));
                return;
            } else {
                DW++;
                if (DW >= this.v5.length) {
                    DW = 0;
                }
            }
        }
    }

    private static long j6(int i, long j) {
        if (4294967295L >= j) {
            return (((long) i) << 32) | j;
        }
        throw new akj$a();
    }

    private int DW(int i) {
        return i >>> (31 - this.Zo);
    }

    private static int FH(int i) {
        return ((1 << i) * (i - 3)) / i;
    }

    private void DW() {
        if (this.Zo == 30) {
            throw new akj$a();
        }
        long[] jArr = this.v5;
        int length = this.v5.length;
        this.Zo++;
        this.Hw = FH(this.Zo);
        try {
            this.v5 = new long[(1 << this.Zo)];
            for (int i = 0; i < length; i++) {
                long j = jArr[i];
                if (j != 0) {
                    int DW = DW(DW(j));
                    while (this.v5[DW] != 0) {
                        DW++;
                        if (DW >= this.v5.length) {
                            DW = 0;
                        }
                    }
                    this.v5[DW] = j;
                }
            }
        } catch (OutOfMemoryError e) {
            throw j6;
        }
    }

    private static int DW(long j) {
        return (int) (j >>> 32);
    }

    private static long FH(long j) {
        return 4294967295L & j;
    }
}
