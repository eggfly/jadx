public final class zy extends adm {
    public static final zy j6;
    private final zw[] DW;
    private int FH;

    static {
        j6 = new zy(0);
    }

    public zy(int i) {
        boolean z;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        super(z);
        this.DW = new zw[i];
        this.FH = 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zy)) {
            return false;
        }
        zy zyVar = (zy) obj;
        zw[] zwVarArr = zyVar.DW;
        int length = this.DW.length;
        if (length != zwVarArr.length || Hw() != zyVar.Hw()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            zw zwVar = this.DW[i];
            zw zwVar2 = zwVarArr[i];
            if (zwVar != zwVar2) {
                if (zwVar == null) {
                    return false;
                }
                if (!zwVar.equals(zwVar2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (zw zwVar : this.DW) {
            i = (i * 31) + (zwVar == null ? 0 : zwVar.hashCode());
        }
        return i;
    }

    public String toString() {
        Object obj = null;
        StringBuffer stringBuffer = new StringBuffer(r2 * 25);
        stringBuffer.append('{');
        for (Object obj2 : this.DW) {
            if (obj2 != null) {
                if (obj != null) {
                    stringBuffer.append(", ");
                } else {
                    obj = 1;
                }
                stringBuffer.append(obj2);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int DW() {
        return this.DW.length;
    }

    public int Hw() {
        int i = 0;
        int i2 = this.FH;
        if (i2 < 0) {
            int length = this.DW.length;
            i2 = 0;
            while (i < length) {
                if (this.DW[i] != null) {
                    i2++;
                }
                i++;
            }
            this.FH = i2;
        }
        return i2;
    }

    public zw j6(int i) {
        try {
            return this.DW[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    public zw j6(zw zwVar) {
        return j6(zwVar.VH());
    }

    public zw DW(zw zwVar) {
        for (zw zwVar2 : this.DW) {
            if (zwVar2 != null && zwVar.DW(zwVar2)) {
                return zwVar2;
            }
        }
        return null;
    }

    public zw j6(zq zqVar) {
        for (zw zwVar : this.DW) {
            if (zwVar != null && zqVar.equals(zwVar.u7())) {
                return zwVar;
            }
        }
        return null;
    }

    public void FH(zw zwVar) {
        try {
            this.DW[zwVar.VH()] = null;
            this.FH = -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    public void Hw(zw zwVar) {
        we();
        if (zwVar == null) {
            throw new NullPointerException("spec == null");
        }
        this.FH = -1;
        try {
            int VH = zwVar.VH();
            this.DW[VH] = zwVar;
            if (VH > 0) {
                int i = VH - 1;
                zw zwVar2 = this.DW[i];
                if (zwVar2 != null && zwVar2.EQ() == 2) {
                    this.DW[i] = null;
                }
            }
            if (zwVar.EQ() == 2) {
                this.DW[VH + 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("spec.getReg() out of range");
        }
    }

    public void j6(zy zyVar) {
        int DW = zyVar.DW();
        for (int i = 0; i < DW; i++) {
            zw j6 = zyVar.j6(i);
            if (j6 != null) {
                Hw(j6);
            }
        }
    }

    public void j6(zy zyVar, boolean z) {
        we();
        zw[] zwVarArr = zyVar.DW;
        int length = this.DW.length;
        int min = Math.min(length, zwVarArr.length);
        this.FH = -1;
        for (int i = 0; i < min; i++) {
            zw zwVar = this.DW[i];
            if (zwVar != null) {
                zw j6 = zwVar.j6(zwVarArr[i], z);
                if (j6 != zwVar) {
                    this.DW[i] = j6;
                }
            }
        }
        while (min < length) {
            this.DW[min] = null;
            min++;
        }
    }

    public zy DW(int i) {
        zy zyVar = new zy(r1 + i);
        for (zw zwVar : this.DW) {
            if (zwVar != null) {
                zyVar.Hw(zwVar.FH(i));
            }
        }
        zyVar.FH = this.FH;
        if (EQ()) {
            zyVar.l_();
        }
        return zyVar;
    }

    public zy v5() {
        zy zyVar = new zy(r1);
        for (zw zwVar : this.DW) {
            if (zwVar != null) {
                zyVar.Hw(zwVar);
            }
        }
        zyVar.FH = this.FH;
        return zyVar;
    }
}
