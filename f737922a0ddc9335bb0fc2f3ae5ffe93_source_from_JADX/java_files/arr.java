import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jgit.JGitText;

class arr extends arp {
    private static final int[] DW;
    private static final byte[] FH;
    private long Hw;
    private byte[][] VH;
    private int[][] Zo;
    private byte[][] gn;
    private byte[] u7;
    private final long[] v5;

    static {
        DW = new int[0];
        FH = new byte[0];
    }

    arr(InputStream inputStream) {
        int i;
        byte[] bArr = new byte[1024];
        awx.j6(inputStream, bArr, 0, bArr.length);
        this.v5 = new long[256];
        for (i = 0; i < 256; i++) {
            this.v5[i] = axb.FH(bArr, i * 4);
        }
        this.Hw = this.v5[255];
        this.Zo = new int[256][];
        this.VH = new byte[256][];
        this.gn = new byte[256][];
        for (int i2 = 0; i2 < 256; i2++) {
            long j;
            if (i2 == 0) {
                j = this.v5[i2];
            } else {
                j = this.v5[i2] - this.v5[i2 - 1];
            }
            if (j == 0) {
                this.Zo[i2] = DW;
                this.VH[i2] = FH;
                this.gn[i2] = FH;
            } else {
                long j2 = 20 * j;
                if (j2 > 2147483647L) {
                    throw new IOException(JGitText.j6().indexFileIsTooLargeForJgit);
                }
                i = (int) j2;
                byte[] bArr2 = new byte[i];
                int[] iArr = new int[(i >>> 2)];
                awx.j6(inputStream, bArr2, 0, bArr2.length);
                for (i = 0; i < iArr.length; i++) {
                    iArr[i] = axb.DW(bArr2, i << 2);
                }
                this.Zo[i2] = iArr;
                this.VH[i2] = new byte[((int) (j * 4))];
                this.gn[i2] = new byte[((int) (j * 4))];
            }
        }
        for (i = 0; i < 256; i++) {
            awx.j6(inputStream, this.gn[i], 0, this.gn[i].length);
        }
        int i3 = 0;
        i = 0;
        while (i3 < 256) {
            byte[] bArr3 = this.VH[i3];
            awx.j6(inputStream, bArr3, 0, bArr3.length);
            int i4 = i;
            for (i = 0; i < bArr3.length; i += 4) {
                if (bArr3[i] < null) {
                    i4++;
                }
            }
            i3++;
            i = i4;
        }
        if (i > 0) {
            this.u7 = new byte[(i * 8)];
            awx.j6(inputStream, this.u7, 0, this.u7.length);
        } else {
            this.u7 = FH;
        }
        this.j6 = new byte[20];
        awx.j6(inputStream, this.j6, 0, this.j6.length);
    }

    public long j6() {
        return this.Hw;
    }

    public long DW() {
        return (long) (this.u7.length / 8);
    }

    public ans j6(long j) {
        int i;
        int binarySearch = Arrays.binarySearch(this.v5, 1 + j);
        if (binarySearch >= 0) {
            long j2 = this.v5[binarySearch];
            while (binarySearch > 0) {
                if (j2 != this.v5[binarySearch - 1]) {
                    i = binarySearch;
                    break;
                }
                binarySearch--;
            }
            i = binarySearch;
        } else {
            i = -(binarySearch + 1);
        }
        binarySearch = (int) (j - (i > 0 ? this.v5[i - 1] : 0));
        return ans.DW(this.Zo[i], binarySearch + (binarySearch << 2));
    }

    public long DW(anb anb) {
        int j6 = anb.j6();
        int j62 = j6(anb, j6);
        if (j62 == -1) {
            return -1;
        }
        long FH = axb.FH(this.VH[j6], j62 << 2);
        if ((2147483648L & FH) != 0) {
            return axb.Hw(this.u7, ((int) (FH & -2147483649L)) * 8);
        }
        return FH;
    }

    public long FH(anb anb) {
        int j6 = anb.j6();
        int j62 = j6(anb, j6);
        if (j62 != -1) {
            return axb.FH(this.gn[j6], j62 << 2);
        }
        throw new ali(anb.Hw(), "unknown");
    }

    public boolean FH() {
        return true;
    }

    public Iterator<arp$b> iterator() {
        return new arr$a();
    }

    public void j6(Set<ans> set, amz amz, int i) {
        int[] iArr = this.Zo[amz.Hw()];
        int length = this.VH[amz.Hw()].length >>> 2;
        if (length != 0) {
            int i2 = 0;
            int i3 = length;
            do {
                int i4 = (i2 + i3) >>> 1;
                int j6 = amz.j6(iArr, DW(i4));
                if (j6 < 0) {
                    i3 = i4;
                    continue;
                } else if (j6 == 0) {
                    i2 = i4;
                    while (i2 > 0 && amz.j6(iArr, DW(i2 - 1)) == 0) {
                        i2--;
                    }
                    while (i2 < length && amz.j6(iArr, DW(i2)) == 0) {
                        set.add(ans.DW(iArr, DW(i2)));
                        if (set.size() <= i) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    return;
                } else {
                    i2 = i4 + 1;
                    continue;
                }
            } while (i2 < i3);
        }
    }

    private static int DW(int i) {
        return (i << 2) + i;
    }

    private int j6(anb anb, int i) {
        int[] iArr = this.Zo[i];
        int length = this.VH[i].length >>> 2;
        if (length == 0) {
            return -1;
        }
        int i2 = 0;
        do {
            int i3 = (i2 + length) >>> 1;
            int j6 = anb.j6(iArr, (i3 << 2) + i3);
            if (j6 < 0) {
                length = i3;
                continue;
            } else if (j6 == 0) {
                return i3;
            } else {
                i2 = i3 + 1;
                continue;
            }
        } while (i2 < length);
        return -1;
    }
}
