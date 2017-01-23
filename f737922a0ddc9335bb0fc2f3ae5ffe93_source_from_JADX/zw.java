import java.util.HashMap;

public final class zw implements abm, adq, Comparable<zw> {
    private static final zw$a DW;
    private static final HashMap<Object, zw> j6;
    private final int FH;
    private final abm Hw;
    private final zq v5;

    public /* synthetic */ int compareTo(Object obj) {
        return FH((zw) obj);
    }

    static {
        j6 = new HashMap(1000);
        DW = new zw$a();
    }

    private static zw Hw(int i, abm abm, zq zqVar) {
        zw zwVar;
        synchronized (j6) {
            DW.j6(i, abm, zqVar);
            zwVar = (zw) j6.get(DW);
            if (zwVar != null) {
            } else {
                zwVar = DW.j6();
                j6.put(zwVar, zwVar);
            }
        }
        return zwVar;
    }

    public static zw j6(int i, abm abm) {
        return Hw(i, abm, null);
    }

    public static zw j6(int i, abm abm, zq zqVar) {
        if (zqVar != null) {
            return Hw(i, abm, zqVar);
        }
        throw new NullPointerException("local  == null");
    }

    public static zw DW(int i, abm abm, zq zqVar) {
        return Hw(i, abm, zqVar);
    }

    public static String j6(int i) {
        return "v" + i;
    }

    private zw(int i, abm abm, zq zqVar) {
        if (i < 0) {
            throw new IllegalArgumentException("reg < 0");
        } else if (abm == null) {
            throw new NullPointerException("type == null");
        } else {
            this.FH = i;
            this.Hw = abm;
            this.v5 = zqVar;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof zw) {
            zw zwVar = (zw) obj;
            return v5(zwVar.FH, zwVar.Hw, zwVar.v5);
        } else if (!(obj instanceof zw$a)) {
            return false;
        } else {
            zw$a zw_a = (zw$a) obj;
            return v5(zw_a.j6, zw_a.DW, zw_a.FH);
        }
    }

    public boolean j6(zw zwVar) {
        if (DW(zwVar) && this.FH == zwVar.FH) {
            return true;
        }
        return false;
    }

    public boolean DW(zw zwVar) {
        if (zwVar == null || !this.Hw.j6().equals(zwVar.Hw.j6())) {
            return false;
        }
        if (this.v5 == zwVar.v5 || (this.v5 != null && this.v5.equals(zwVar.v5))) {
            return true;
        }
        return false;
    }

    private boolean v5(int i, abm abm, zq zqVar) {
        return this.FH == i && this.Hw.equals(abm) && (this.v5 == zqVar || (this.v5 != null && this.v5.equals(zqVar)));
    }

    public int FH(zw zwVar) {
        if (this.FH < zwVar.FH) {
            return -1;
        }
        if (this.FH > zwVar.FH) {
            return 1;
        }
        int j6 = this.Hw.j6().j6(zwVar.Hw.j6());
        if (j6 != 0) {
            return j6;
        }
        if (this.v5 == null) {
            if (zwVar.v5 == null) {
                return 0;
            }
            return -1;
        } else if (zwVar.v5 == null) {
            return 1;
        } else {
            return this.v5.j6(zwVar.v5);
        }
    }

    public int hashCode() {
        return Zo(this.FH, this.Hw, this.v5);
    }

    private static int Zo(int i, abm abm, zq zqVar) {
        return ((((zqVar != null ? zqVar.hashCode() : 0) * 31) + abm.hashCode()) * 31) + i;
    }

    public String toString() {
        return j6(false);
    }

    public String Hw() {
        return j6(true);
    }

    public abl j6() {
        return this.Hw.j6();
    }

    public abm DW() {
        return this.Hw.DW();
    }

    public final int FH() {
        return this.Hw.FH();
    }

    public final int v5() {
        return this.Hw.v5();
    }

    public final boolean Zo() {
        return false;
    }

    public int VH() {
        return this.FH;
    }

    public abm gn() {
        return this.Hw;
    }

    public zq u7() {
        return this.v5;
    }

    public int tp() {
        return this.FH + EQ();
    }

    public int EQ() {
        return this.Hw.j6().tp();
    }

    public boolean we() {
        return this.Hw.j6().we();
    }

    public String J0() {
        return j6(this.FH);
    }

    public zw j6(zw zwVar, boolean z) {
        if (this == zwVar) {
            return this;
        }
        if (zwVar == null || this.FH != zwVar.VH()) {
            return null;
        }
        zq zqVar = (this.v5 == null || !this.v5.equals(zwVar.u7())) ? null : this.v5;
        Object obj;
        if (zqVar == this.v5) {
            obj = 1;
        } else {
            obj = null;
        }
        if (z && r3 == null) {
            return null;
        }
        abl j6 = j6();
        if (j6 != zwVar.j6()) {
            return null;
        }
        if (this.Hw.equals(zwVar.gn())) {
            abm abm = this.Hw;
        } else {
            Object obj2 = j6;
        }
        if (abm == this.Hw && r3 != null) {
            return this;
        }
        return zqVar == null ? j6(this.FH, abm) : j6(this.FH, abm, zqVar);
    }

    public zw DW(int i) {
        return this.FH == i ? this : DW(i, this.Hw, this.v5);
    }

    public zw j6(abm abm) {
        return DW(this.FH, abm, this.v5);
    }

    public zw FH(int i) {
        return i == 0 ? this : DW(this.FH + i);
    }

    public zw J8() {
        abm abm;
        abm abm2 = this.Hw;
        if (abm2 instanceof abl) {
            abm = (abl) abm2;
        } else {
            abm = abm2.j6();
        }
        if (abm.aM()) {
            abm = abm.j3();
        }
        return abm == abm2 ? this : DW(this.FH, abm, this.v5);
    }

    public zw j6(zq zqVar) {
        if (this.v5 != zqVar) {
            return (this.v5 == null || !this.v5.equals(zqVar)) ? DW(this.FH, this.Hw, zqVar) : this;
        } else {
            return this;
        }
    }

    private String j6(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(J0());
        stringBuffer.append(":");
        if (this.v5 != null) {
            stringBuffer.append(this.v5.toString());
        }
        abl j6 = this.Hw.j6();
        stringBuffer.append(j6);
        if (j6 != this.Hw) {
            stringBuffer.append("=");
            if (z && (this.Hw instanceof abe)) {
                stringBuffer.append(((abe) this.Hw).u7());
            } else if (z && (this.Hw instanceof aah)) {
                stringBuffer.append(this.Hw.Hw());
            } else {
                stringBuffer.append(this.Hw);
            }
        }
        return stringBuffer.toString();
    }
}
