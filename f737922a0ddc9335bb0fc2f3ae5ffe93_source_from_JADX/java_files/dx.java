import com.aide.uidesigner.ProxyTextView;

public class dx {
    private static final int[] DW;
    private int EQ;
    private int[] FH;
    private int[] Hw;
    private boolean[] VH;
    private int[] Zo;
    private boolean[] gn;
    public final dx$a j6;
    private int tp;
    private int u7;
    private int[] v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public dx() {
        this.j6 = new dx$a();
        this.EQ = 0;
        this.FH = new int[DW[this.EQ]];
        this.v5 = new int[DW[this.EQ]];
        this.u7 = 0;
        this.tp = 0;
    }

    public dx(ee eeVar) {
        int i;
        int i2 = 0;
        this.j6 = new dx$a();
        this.tp = eeVar.readInt();
        this.u7 = eeVar.readInt();
        this.EQ = eeVar.readInt();
        this.FH = new int[DW[this.EQ]];
        for (i = 0; i < this.FH.length; i++) {
            this.FH[i] = eeVar.readInt();
        }
        this.v5 = new int[DW[this.EQ]];
        for (i = 0; i < this.v5.length; i++) {
            this.v5[i] = eeVar.readInt();
        }
        if (eeVar.readBoolean()) {
            this.VH = new boolean[DW[this.EQ]];
            while (i2 < this.VH.length) {
                this.VH[i2] = eeVar.readBoolean();
                i2++;
            }
        }
    }

    public void j6(ef efVar) {
        boolean z;
        int i = 0;
        efVar.writeInt(this.tp);
        efVar.writeInt(this.u7);
        efVar.writeInt(this.EQ);
        for (int writeInt : this.FH) {
            efVar.writeInt(writeInt);
        }
        for (int writeInt2 : this.v5) {
            efVar.writeInt(writeInt2);
        }
        if (this.VH != null) {
            z = true;
        } else {
            z = false;
        }
        efVar.writeBoolean(z);
        if (this.VH != null) {
            while (i < this.VH.length) {
                efVar.writeBoolean(this.VH[i]);
                i++;
            }
        }
    }

    public void j6() {
        if (this.u7 > 0) {
            int i;
            for (i = 0; i < this.FH.length; i++) {
                this.FH[i] = 0;
            }
            if (this.VH != null) {
                for (i = 0; i < this.VH.length; i++) {
                    this.VH[i] = false;
                }
            }
            this.u7 = 0;
            this.tp = 0;
        }
    }

    public void j6(int i, int i2) {
        j6(i);
        DW(i, i2);
    }

    public void DW(int i, int i2) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        boolean z = false;
        int i3 = this.FH[length];
        while (i3 != 0) {
            if (i3 == i) {
                if (this.v5[length] != i2) {
                    z = true;
                } else {
                    return;
                }
            }
            length = (length + length2) % this.FH.length;
            i3 = this.FH[length];
        }
        this.FH[length] = i;
        this.v5[length] = i2;
        if (z) {
            if (this.VH == null) {
                this.VH = new boolean[this.FH.length];
            }
            this.VH[length] = true;
        }
        this.tp++;
        this.u7++;
        if (this.u7 * 2 > this.FH.length) {
            DW();
        }
    }

    public boolean FH(int i, int i2) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i3 = this.FH[length];
        while (true) {
            if (i3 == i && this.v5[length] == i2) {
                return true;
            }
            if (i3 == 0) {
                return false;
            }
            length = (length + length2) % this.FH.length;
            i3 = this.FH[length];
        }
    }

    public void j6(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = (i & Integer.MAX_VALUE) % this.FH.length;
        int length2 = ((Integer.MAX_VALUE & i) % (this.FH.length - 2)) + 1;
        int i2 = this.FH[length];
        while (i2 != 0) {
            if (i2 == i) {
                this.FH[length] = Integer.MIN_VALUE;
                this.tp--;
            }
            length = (length + length2) % this.FH.length;
            i2 = this.FH[length];
        }
    }

    public boolean DW(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        int length = ((i & Integer.MAX_VALUE) % (this.FH.length - 2)) + 1;
        int length2 = (Integer.MAX_VALUE & i) % this.FH.length;
        int i2 = this.FH[length2];
        while (i2 != i) {
            if (i2 == 0) {
                return false;
            }
            length2 = (length2 + length) % this.FH.length;
            i2 = this.FH[length2];
        }
        return true;
    }

    private void DW() {
        int[] iArr;
        int[] iArr2;
        int i;
        boolean[] zArr = null;
        int i2 = 0;
        if (this.tp * 2 > this.FH.length) {
            this.EQ++;
            this.Hw = null;
            this.Zo = null;
            this.gn = null;
            iArr = new int[DW[this.EQ]];
            iArr2 = new int[DW[this.EQ]];
            if (this.VH != null) {
                zArr = new boolean[DW[this.EQ]];
            }
        } else if (this.Hw == null || this.Hw.length != this.FH.length) {
            this.Hw = this.FH;
            this.Zo = this.v5;
            this.gn = this.VH;
            iArr = new int[DW[this.EQ]];
            iArr2 = new int[DW[this.EQ]];
            if (this.VH != null) {
                zArr = new boolean[DW[this.EQ]];
            }
        } else {
            int i3;
            boolean[] zArr2;
            iArr = this.Hw;
            for (i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = 0;
            }
            if (this.gn != null) {
                zArr = this.gn;
                for (i3 = 0; i3 < zArr.length; i3++) {
                    zArr[i3] = false;
                }
                zArr2 = zArr;
            } else {
                zArr2 = null;
            }
            int[] iArr3 = this.Zo;
            this.Hw = this.FH;
            this.Zo = this.v5;
            this.gn = this.VH;
            boolean[] zArr3 = zArr2;
            iArr2 = iArr3;
            zArr = zArr3;
        }
        int i4;
        int length;
        int length2;
        if (this.VH == null) {
            i = 0;
            while (i2 < this.FH.length) {
                i4 = this.FH[i2];
                if (!(i4 == 0 || i4 == Integer.MIN_VALUE)) {
                    length = ((i4 & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                    length2 = (i4 & Integer.MAX_VALUE) % iArr.length;
                    while (iArr[length2] != 0) {
                        length2 = (length2 + length) % iArr.length;
                    }
                    iArr[length2] = i4;
                    iArr2[length2] = this.v5[i2];
                    i++;
                }
                i2++;
            }
        } else {
            i = 0;
            while (i2 < this.FH.length) {
                length = this.FH[i2];
                if (!(length == 0 || length == Integer.MIN_VALUE)) {
                    int length3 = ((length & Integer.MAX_VALUE) % (iArr.length - 2)) + 1;
                    length2 = (length & Integer.MAX_VALUE) % iArr.length;
                    if (!this.VH[i2]) {
                        while (iArr[length2] != 0) {
                            length2 = (length2 + length3) % iArr.length;
                        }
                        iArr[length2] = length;
                        iArr2[length2] = this.v5[i2];
                        i4 = i + 1;
                        int length4 = ((length & Integer.MAX_VALUE) % (this.FH.length - 2)) + 1;
                        i = (length & Integer.MAX_VALUE) % this.FH.length;
                        while (this.FH[i] != 0) {
                            if (this.FH[i] == length && i != i2) {
                                while (iArr[length2] != 0) {
                                    length2 = (length2 + length3) % iArr.length;
                                }
                                iArr[length2] = length;
                                iArr2[length2] = this.v5[i];
                                if (zArr != null) {
                                    zArr[length2] = true;
                                }
                                i4++;
                            }
                            i = (i + length4) % this.FH.length;
                        }
                        i = i4;
                    }
                }
                i2++;
            }
        }
        this.VH = zArr;
        this.FH = iArr;
        this.v5 = iArr2;
        this.u7 = i;
    }

    public String toString() {
        String str = "{";
        for (int i = 0; i < this.FH.length; i++) {
            int i2 = this.FH[i];
            if (!(i2 == 0 || i2 == Integer.MIN_VALUE)) {
                int i3 = this.v5[i];
                if (i2 == Integer.MAX_VALUE) {
                    str = str + "0->" + i3 + ", ";
                } else {
                    str = str + i2 + "->" + i3 + ", ";
                }
            }
        }
        return str + "}";
    }
}
