import java.util.Comparator;

public class dm<E extends bs> {
    private int DW;
    private final bt FH;
    private int[] j6;

    public dm(bt btVar) {
        this.FH = btVar;
        this.j6 = null;
        this.DW = 0;
    }

    public dm(bt btVar, int i) {
        this.FH = btVar;
        this.j6 = new int[i];
        this.DW = i;
    }

    public dm(bt btVar, ee eeVar) {
        this.FH = btVar;
        this.DW = eeVar.readInt();
        if (this.DW > 0) {
            this.j6 = new int[this.DW];
            for (int i = 0; i < this.j6.length; i++) {
                this.j6[i] = eeVar.readInt();
            }
        }
    }

    public void j6(dm<E> dmVar) {
        for (int i = 0; i < dmVar.Hw(); i++) {
            FH(dmVar.j6(i));
        }
    }

    public boolean j6(bs bsVar) {
        for (int i = 0; i < Hw(); i++) {
            if (j6(i) == bsVar) {
                return true;
            }
        }
        return false;
    }

    public void j6(ef efVar) {
        int i = 0;
        if (this.j6 == null) {
            efVar.writeInt(0);
            return;
        }
        efVar.writeInt(this.DW);
        while (i < this.DW) {
            efVar.writeInt(this.j6[i]);
            i++;
        }
    }

    public void j6() {
        this.DW = 0;
    }

    public void DW(E e) {
        FH(e);
    }

    public E DW() {
        if (this.DW == 0) {
            return null;
        }
        int[] iArr = this.j6;
        int i = this.DW - 1;
        this.DW = i;
        return this.FH.FH(iArr[i]);
    }

    public E FH() {
        if (this.DW == 0) {
            return null;
        }
        return j6(this.DW - 1);
    }

    public void FH(E e) {
        if (this.j6 == null) {
            this.j6 = new int[10];
        } else if (this.DW >= this.j6.length) {
            Object obj = new int[((this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        int[] iArr = this.j6;
        int i = this.DW;
        this.DW = i + 1;
        iArr[i] = this.FH.j6((bs) e);
    }

    public E j6(int i) {
        if (this.j6 == null || i >= this.j6.length || i >= this.DW) {
            return null;
        }
        return this.FH.FH(this.j6[i]);
    }

    public void DW(int i) {
        this.DW = i;
    }

    public void j6(int i, E e) {
        if (this.j6 == null) {
            this.j6 = new int[Math.max(10, i + 1)];
        } else if (i >= this.j6.length) {
            Object obj = new int[Math.max(i + 1, (this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        if (i >= this.DW) {
            this.DW = i + 1;
        }
        this.j6[i] = this.FH.j6((bs) e);
    }

    public int Hw() {
        return this.DW;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.DW; i++) {
            str = str + this.FH.FH(this.j6[i]).iW() + ", ";
        }
        return str + "}";
    }

    public void j6(Comparator<? super E> comparator) {
        j6(0, this.DW - 1, comparator);
    }

    private void j6(int i, int i2, Comparator<? super E> comparator) {
        if (i < i2) {
            bs FH = this.FH.FH(this.j6[((i2 - i) / 2) + i]);
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                while (comparator.compare(this.FH.FH(this.j6[i4]), FH) < 0) {
                    i4++;
                }
                while (comparator.compare(FH, this.FH.FH(this.j6[i3])) < 0) {
                    i3--;
                }
                if (i4 <= i3) {
                    int i5 = this.j6[i3];
                    this.j6[i3] = this.j6[i4];
                    this.j6[i4] = i5;
                    i4++;
                    i3--;
                }
            }
            j6(i, i3, comparator);
            j6(i4, i2, comparator);
        }
    }
}
