import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.jgit.JGitText;

public class arx {
    private final int[] DW;
    private final long[] FH;
    private final int[] Hw;
    private final arp j6;
    private final int[] v5;

    public arx(arp arp) {
        int i = 0;
        this.j6 = arp;
        long j6 = this.j6.j6();
        long DW = this.j6.DW();
        long j = j6 - DW;
        if (j > 2147483647L || DW > 2147483647L || j6 > 4294967295L) {
            throw new IllegalArgumentException(JGitText.j6().hugeIndexesAreNotSupportedByJgitYet);
        }
        int i2;
        this.DW = new int[((int) j)];
        this.FH = new long[((int) DW)];
        this.Hw = new int[this.DW.length];
        this.v5 = new int[this.FH.length];
        Iterator it = this.j6.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            j = ((arp$b) it.next()).j6();
            if (j < 2147483647L) {
                i2 = i4 + 1;
                this.DW[i4] = (int) j;
                i4 = i2;
            } else {
                i2 = i3 + 1;
                this.FH[i3] = j;
                i3 = i2;
            }
        }
        Arrays.sort(this.DW);
        Arrays.sort(this.FH);
        Iterator it2 = this.j6.iterator();
        while (it2.hasNext()) {
            DW = ((arp$b) it2.next()).j6();
            if (DW < 2147483647L) {
                i2 = i + 1;
                this.Hw[Arrays.binarySearch(this.DW, (int) DW)] = i;
                i = i2;
            } else {
                i2 = i + 1;
                this.v5[Arrays.binarySearch(this.FH, DW)] = i;
                i = i2;
            }
        }
    }

    public ans j6(long j) {
        int binarySearch;
        if (j <= 2147483647L) {
            binarySearch = Arrays.binarySearch(this.DW, (int) j);
            if (binarySearch < 0) {
                return null;
            }
            return this.j6.j6(this.Hw[binarySearch]);
        }
        binarySearch = Arrays.binarySearch(this.FH, j);
        if (binarySearch >= 0) {
            return this.j6.j6(this.v5[binarySearch]);
        }
        return null;
    }

    public long j6(long j, long j2) {
        int binarySearch;
        if (j <= 2147483647L) {
            binarySearch = Arrays.binarySearch(this.DW, (int) j);
            if (binarySearch < 0) {
                throw new ala(MessageFormat.format(JGitText.j6().cantFindObjectInReversePackIndexForTheSpecifiedOffset, new Object[]{Long.valueOf(j)}));
            } else if (binarySearch + 1 == this.DW.length) {
                return this.FH.length > 0 ? this.FH[0] : j2;
            } else {
                return (long) this.DW[binarySearch + 1];
            }
        }
        binarySearch = Arrays.binarySearch(this.FH, j);
        if (binarySearch >= 0) {
            return binarySearch + 1 != this.FH.length ? this.FH[binarySearch + 1] : j2;
        } else {
            throw new ala(MessageFormat.format(JGitText.j6().cantFindObjectInReversePackIndexForTheSpecifiedOffset, new Object[]{Long.valueOf(j)}));
        }
    }
}
