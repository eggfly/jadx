import com.aide.uidesigner.ProxyTextView;

public class dy {
    private static final int[] DW;
    private long[] FH;
    private long[] Hw;
    private int VH;
    private int Zo;
    public final dy$a j6;
    private int v5;

    static {
        DW = new int[]{5, 11, 17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, ProxyTextView.INPUTTYPE_textAutoComplete, 131101, 262147, 524309, 1048583, 2097169, 4194319, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923, 1073741827, 2147383649};
    }

    public dy() {
        this.j6 = new dy$a();
        this.VH = 0;
        this.FH = new long[DW[this.VH]];
        this.v5 = 0;
        this.Zo = 0;
    }

    public dy(ee eeVar) {
        this.j6 = new dy$a();
        this.Zo = eeVar.readInt();
        this.v5 = eeVar.readInt();
        this.VH = eeVar.readInt();
        this.FH = new long[DW[this.VH]];
        for (int i = 0; i < this.FH.length; i++) {
            this.FH[i] = eeVar.readLong();
        }
    }

    public void j6(int i, int i2) {
        long j = (((long) i) << 32) | ((long) i2);
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != 0) {
            if (j2 != j) {
                length = (length + length2) % this.FH.length;
                j2 = this.FH[length];
            } else {
                return;
            }
        }
        this.FH[length] = j;
        this.Zo++;
        this.v5++;
        if (this.v5 * 2 > this.FH.length) {
            DW();
        }
    }

    public void j6(eb ebVar) {
        for (int i = 0; i < this.FH.length; i++) {
            long j = this.FH[i];
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                if (j == Long.MAX_VALUE) {
                    j = 0;
                }
                if (ebVar.j6((int) (j >> 32))) {
                    this.FH[i] = Long.MIN_VALUE;
                    this.Zo--;
                }
            }
        }
    }

    public void j6(ef efVar) {
        efVar.writeInt(this.Zo);
        efVar.writeInt(this.v5);
        efVar.writeInt(this.VH);
        for (long writeLong : this.FH) {
            efVar.writeLong(writeLong);
        }
    }

    public void j6() {
        if (this.v5 > 0) {
            for (int i = 0; i < this.FH.length; i++) {
                this.FH[i] = 0;
            }
            this.v5 = 0;
            this.Zo = 0;
        }
    }

    public void j6(dy dyVar) {
        for (long j : dyVar.FH) {
            if (j == Long.MAX_VALUE) {
                j6(0);
            } else if (!(j == 0 || j == Long.MIN_VALUE)) {
                j6(j);
            }
        }
    }

    public void j6(long j) {
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != 0) {
            if (j2 != j) {
                length = (length + length2) % this.FH.length;
                j2 = this.FH[length];
            } else {
                return;
            }
        }
        this.FH[length] = j;
        this.Zo++;
        this.v5++;
        if (this.v5 * 2 > this.FH.length) {
            DW();
        }
    }

    public void DW(int i, int i2) {
        long j = (((long) i) << 32) | ((long) i2);
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != 0) {
            if (j2 != j) {
                length = (length + length2) % this.FH.length;
                j2 = this.FH[length];
            } else {
                return;
            }
        }
        this.FH[length] = j;
        this.Zo++;
        this.v5++;
        if (this.v5 * 2 > this.FH.length) {
            DW();
        }
    }

    public void j6(int i) {
        for (int i2 = 0; i2 < this.FH.length; i2++) {
            long j = this.FH[i2];
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                if (j == Long.MAX_VALUE) {
                    j = 0;
                }
                if (((int) (j >> 32)) == i) {
                    this.FH[i2] = Long.MIN_VALUE;
                    this.Zo--;
                }
            }
        }
    }

    public void j6(ec ecVar) {
        for (int i = 0; i < this.FH.length; i++) {
            long j = this.FH[i];
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                if (j == Long.MAX_VALUE) {
                    j = 0;
                }
                if (ecVar.FH((int) (j >> 32))) {
                    this.FH[i] = Long.MIN_VALUE;
                    this.Zo--;
                }
            }
        }
    }

    public boolean FH(int i, int i2) {
        long j = (((long) i) << 32) | ((long) i2);
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        int length = (int) ((j & Long.MAX_VALUE) % ((long) this.FH.length));
        int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) this.FH.length) - 2))) + 1;
        long j2 = this.FH[length];
        while (j2 != j) {
            if (j2 == 0) {
                return false;
            }
            length = (length + length2) % this.FH.length;
            j2 = this.FH[length];
        }
        return true;
    }

    private void DW() {
        long[] jArr;
        if (this.Zo * 2 > this.FH.length) {
            this.VH++;
            this.Hw = null;
            jArr = new long[DW[this.VH]];
        } else if (this.Hw == null || this.Hw.length != this.FH.length) {
            this.Hw = this.FH;
            jArr = new long[DW[this.VH]];
        } else {
            long[] jArr2 = this.Hw;
            for (int i = 0; i < jArr2.length; i++) {
                jArr2[i] = 0;
            }
            this.Hw = this.FH;
            jArr = jArr2;
        }
        int i2 = 0;
        for (long j : this.FH) {
            if (!(j == 0 || j == Long.MIN_VALUE)) {
                int length = (int) ((Long.MAX_VALUE & j) % ((long) jArr.length));
                int length2 = ((int) ((Long.MAX_VALUE & j) % (((long) jArr.length) - 2))) + 1;
                while (jArr[length] != 0) {
                    length = (length + length2) % jArr.length;
                }
                jArr[length] = j;
                i2++;
            }
        }
        this.FH = jArr;
        this.v5 = i2;
    }

    public String toString() {
        String str = "{";
        for (long j : this.FH) {
            long j2;
            if (!(j2 == 0 || j2 == Long.MIN_VALUE)) {
                if (j2 == Long.MAX_VALUE) {
                    j2 = 0;
                }
                str = str + ((int) (j2 >> 32)) + " - " + ((int) (j2 & -1)) + ", ";
            }
        }
        return str + "}";
    }
}
