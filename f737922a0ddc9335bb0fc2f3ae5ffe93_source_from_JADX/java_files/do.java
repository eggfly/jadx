public class do {
    private int DW;
    private int[] j6;

    public do() {
        this.j6 = null;
        this.DW = 0;
    }

    public do(int i) {
        this.j6 = new int[i];
        this.DW = i;
    }

    public do(ee eeVar) {
        this.DW = eeVar.readInt();
        if (this.DW > 0) {
            this.j6 = new int[this.DW];
            for (int i = 0; i < this.j6.length; i++) {
                this.j6[i] = eeVar.readInt();
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof do)) {
            return false;
        }
        do doVar = (do) obj;
        if (this.DW != doVar.DW) {
            return false;
        }
        for (int i = 0; i < this.DW; i++) {
            if (FH(i) != doVar.FH(i)) {
                return false;
            }
        }
        return true;
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

    public void j6(int i) {
        DW(i);
    }

    public void DW(int i) {
        if (this.j6 == null) {
            this.j6 = new int[10];
        } else if (this.DW >= this.j6.length) {
            Object obj = new int[((this.j6.length * 2) + 1)];
            System.arraycopy(this.j6, 0, obj, 0, this.j6.length);
            this.j6 = obj;
        }
        int[] iArr = this.j6;
        int i2 = this.DW;
        this.DW = i2 + 1;
        iArr[i2] = i;
    }

    public int DW() {
        if (this.DW == 0) {
            return -1;
        }
        int[] iArr = this.j6;
        int i = this.DW - 1;
        this.DW = i;
        return iArr[i];
    }

    public int FH() {
        if (this.DW == 0) {
            return -1;
        }
        return FH(this.DW - 1);
    }

    public int FH(int i) {
        if (this.j6 != null && i < this.j6.length && i < this.DW) {
            return this.j6[i];
        }
        return -1;
    }

    public void Hw(int i) {
        this.DW = i;
    }

    public void j6(int i, int i2) {
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
        this.j6[i] = i2;
    }

    public void v5(int i) {
        if (this.j6 != null && i < this.DW) {
            System.arraycopy(this.j6, i + 1, this.j6, i, (this.DW - i) - 1);
            this.DW--;
        }
    }

    public int Hw() {
        return this.DW;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.DW; i++) {
            str = str + this.j6[i] + ", ";
        }
        return str + "}";
    }

    public void v5() {
        DW(0, this.DW - 1);
    }

    private void DW(int i, int i2) {
        if (i < i2) {
            int i3 = this.j6[((i2 - i) / 2) + i];
            int i4 = i2;
            int i5 = i;
            while (i5 <= i4) {
                while (this.j6[i5] < i3) {
                    i5++;
                }
                while (i3 < this.j6[i4]) {
                    i4--;
                }
                if (i5 <= i4) {
                    int i6 = this.j6[i4];
                    this.j6[i4] = this.j6[i5];
                    this.j6[i5] = i6;
                    i5++;
                    i4--;
                }
            }
            DW(i, i4);
            DW(i5, i2);
        }
    }
}
