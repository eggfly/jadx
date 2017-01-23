import android.os.Build.VERSION;

public class ad {
    private static final ad$c j6;
    private final Object DW;

    static {
        if (VERSION.SDK_INT >= 16) {
            j6 = new ad$d();
        } else if (VERSION.SDK_INT >= 15) {
            j6 = new ad$b();
        } else if (VERSION.SDK_INT >= 14) {
            j6 = new ad$a();
        } else {
            j6 = new ad$e();
        }
    }

    public ad(Object obj) {
        this.DW = obj;
    }

    public static ad j6() {
        return new ad(j6.j6());
    }

    public void j6(boolean z) {
        j6.j6(this.DW, z);
    }

    public void j6(int i) {
        j6.DW(this.DW, i);
    }

    public void DW(int i) {
        j6.j6(this.DW, i);
    }

    public void FH(int i) {
        j6.v5(this.DW, i);
    }

    public void Hw(int i) {
        j6.FH(this.DW, i);
    }

    public void v5(int i) {
        j6.Hw(this.DW, i);
    }

    public void Zo(int i) {
        j6.Zo(this.DW, i);
    }

    public void VH(int i) {
        j6.VH(this.DW, i);
    }

    public int hashCode() {
        return this.DW == null ? 0 : this.DW.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ad adVar = (ad) obj;
        if (this.DW == null) {
            if (adVar.DW != null) {
                return false;
            }
            return true;
        } else if (this.DW.equals(adVar.DW)) {
            return true;
        } else {
            return false;
        }
    }
}
