import akd$a.b;

class akd$a$a extends b {
    final /* synthetic */ akd$a j6;

    akd$a$a(akd$a akd_a) {
        this.j6 = akd_a;
        super(akd_a);
    }

    final int j6(int i, int i2) {
        while (i2 > this.j6.FH && i + i2 > this.j6.v5 && this.j6.gn.FH.j6(this.j6.gn.Hw, i2 - 1, this.j6.gn.v5, (i + i2) - 1)) {
            i2--;
        }
        return i2;
    }

    final int j6(int i) {
        return i - 1;
    }

    final int DW(int i) {
        return i;
    }

    final boolean DW(int i, int i2) {
        return i < i2;
    }

    final void FH(int i, int i2) {
        if (i2 > this.j6.FH && i + i2 > this.j6.v5) {
            return;
        }
        if (i > this.j6.j6.Hw) {
            this.gn = i;
        } else {
            this.VH = i;
        }
    }

    final boolean j6(int i, int i2, int i3, long j) {
        if (i2 < this.j6.j6.DW || i2 > this.j6.j6.FH || ((i + i2) - this.j6.j6.Hw) % 2 != 0 || i3 > this.j6.j6.v5(i, i2)) {
            return false;
        }
        j6(this.j6.j6.Zo(i, i2), j);
        return true;
    }
}
