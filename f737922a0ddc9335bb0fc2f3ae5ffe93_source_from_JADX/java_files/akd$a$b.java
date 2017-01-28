import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

abstract class akd$a$b {
    int DW;
    int FH;
    int Hw;
    int VH;
    int Zo;
    int gn;
    private awy j6;
    private awz tp;
    final /* synthetic */ akd$a u7;
    int v5;

    abstract int DW(int i);

    abstract boolean DW(int i, int i2);

    abstract void FH(int i, int i2);

    abstract int j6(int i);

    abstract int j6(int i, int i2);

    abstract boolean j6(int i, int i2, int i3, long j);

    akd$a$b(akd$a akd_a) {
        this.u7 = akd_a;
        this.j6 = new awy();
        this.tp = new awz();
    }

    final int Hw(int i, int i2) {
        if (((i + i2) - this.Hw) % 2 == 0) {
            return ((i + i2) - this.Hw) / 2;
        }
        throw new RuntimeException(MessageFormat.format(JGitText.j6().unexpectedOddResult, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.Hw)}));
    }

    final int v5(int i, int i2) {
        if (i2 >= this.DW && i2 <= this.FH) {
            return this.j6.j6(Hw(i, i2));
        }
        throw new RuntimeException(MessageFormat.format(JGitText.j6().kNotInRange, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.DW), Integer.valueOf(this.FH)}));
    }

    final long Zo(int i, int i2) {
        if (i2 >= this.DW && i2 <= this.FH) {
            return this.tp.j6(Hw(i, i2));
        }
        throw new RuntimeException(MessageFormat.format(JGitText.j6().kNotInRange, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.DW), Integer.valueOf(this.FH)}));
    }

    private int Hw(int i) {
        if (i < this.VH) {
            return this.VH + ((this.VH ^ i) & 1);
        }
        if (i > this.gn) {
            return this.gn - ((this.gn ^ i) & 1);
        }
        return i;
    }

    void j6(int i, int i2, int i3, int i4) {
        this.VH = i3;
        this.gn = i4;
        this.Hw = i;
        this.FH = i;
        this.DW = i;
        this.j6.DW();
        this.j6.DW(i2);
        this.tp.j6();
        this.tp.DW(VH(i, i2));
    }

    final long VH(int i, int i2) {
        return ((long) (i + i2)) | (((long) i2) << 32);
    }

    final int j6(long j) {
        return (int) (j >>> 32);
    }

    final int DW(long j) {
        return (int) j;
    }

    final boolean j6(long j, long j2) {
        int j6 = j6(j);
        int j62 = j6(j2);
        int DW = DW(j);
        int DW2 = DW(j2);
        if (j6 > j62 || DW > DW2) {
            DW = DW2;
            j6 = j62;
        }
        this.u7.VH = new ajv(j6, j62, DW, DW2);
        return true;
    }

    boolean FH(int i) {
        this.v5 = this.DW;
        this.Zo = this.FH;
        this.DW = Hw(this.Hw - i);
        this.FH = Hw(this.Hw + i);
        int i2 = this.FH;
        while (i2 >= this.DW) {
            int Hw;
            int j6;
            int j62;
            long VH;
            long j;
            int j63;
            if (i2 > this.v5) {
                Hw = Hw(i - 1, i2 - 1);
                j6 = this.j6.j6(Hw);
                j62 = j6(i2 - 1, j6);
                if (j6 != j62) {
                    VH = VH(i2 - 1, j62);
                } else {
                    VH = this.tp.j6(Hw);
                }
                if (j6(i, i2 - 1, j62, VH)) {
                    return true;
                }
                j = VH;
                j63 = j6(j62);
            } else {
                j = -1;
                j63 = -1;
            }
            if (i2 < this.Zo) {
                Hw = Hw(i - 1, i2 + 1);
                j6 = this.j6.j6(Hw);
                j62 = j6(i2 + 1, j6);
                if (j6 != j62) {
                    VH = VH(i2 + 1, j62);
                } else {
                    VH = this.tp.j6(Hw);
                }
                if (j6(i, i2 + 1, j62, VH)) {
                    return true;
                }
                Hw = DW(j62);
            } else {
                VH = -1;
                Hw = -1;
            }
            if (i2 >= this.Zo || (i2 > this.v5 && DW(j63, Hw))) {
                VH = j;
                j62 = j63;
            } else {
                j62 = Hw;
            }
            if (j6(i, i2, j62, VH)) {
                return true;
            }
            FH(i2, j62);
            Hw = Hw(i, i2);
            this.j6.j6(Hw, j62);
            this.tp.j6(Hw, VH);
            i2 -= 2;
        }
        return false;
    }
}
