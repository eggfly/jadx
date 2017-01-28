import akd$a.b;

class akd$a$c extends b {
    final /* synthetic */ akd$a j6;

    akd$a$c(akd$a akd_a) {
        this.j6 = akd_a;
        super(akd_a);
    }

    final int j6(int i, int i2) {
        while (i2 < this.j6.Hw && i + i2 < this.j6.Zo && this.j6.gn.FH.j6(this.j6.gn.Hw, i2, this.j6.gn.v5, i + i2)) {
            i2++;
        }
        return i2;
    }

    final int j6(int i) {
        return i;
    }

    final int DW(int i) {
        return i + 1;
    }

    final boolean DW(int i, int i2) {
        return i > i2;
    }

    final void FH(int i, int i2) {
        if (i2 < this.j6.Hw && i + i2 < this.j6.Zo) {
            return;
        }
        if (i > this.j6.DW.Hw) {
            this.gn = i;
        } else {
            this.VH = i;
        }
    }

    final boolean j6(int i, int i2, int i3, long j) {
        if (i2 < this.j6.DW.DW || i2 > this.j6.DW.FH || (((i - 1) + i2) - this.j6.DW.Hw) % 2 != 0 || i3 < this.j6.DW.v5(i - 1, i2)) {
            return false;
        }
        j6(j, this.j6.DW.Zo(i - 1, i2));
        return true;
    }
}
