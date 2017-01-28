public abstract class zo implements adq {
    private final aac DW;
    private final zw FH;
    private final zx Hw;
    private final zz j6;

    public abstract abn DW();

    public abstract zo j6(abl abl);

    public abstract zo j6(zw zwVar, zx zxVar);

    public abstract void j6(zo$b zo_b);

    public zo(zz zzVar, aac aac, zw zwVar, zx zxVar) {
        if (zzVar == null) {
            throw new NullPointerException("opcode == null");
        } else if (aac == null) {
            throw new NullPointerException("position == null");
        } else if (zxVar == null) {
            throw new NullPointerException("sources == null");
        } else {
            this.j6 = zzVar;
            this.DW = aac;
            this.FH = zwVar;
            this.Hw = zxVar;
        }
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        return j6(j6());
    }

    public String Hw() {
        return DW(j6());
    }

    public String j6() {
        return null;
    }

    public final zz Zo() {
        return this.j6;
    }

    public final aac VH() {
        return this.DW;
    }

    public final zw gn() {
        return this.FH;
    }

    public final zw u7() {
        zw DW;
        if (this.j6.j6() == 54) {
            DW = this.Hw.DW(0);
        } else {
            DW = this.FH;
        }
        if (DW == null || DW.u7() == null) {
            return null;
        }
        return DW;
    }

    public final zx tp() {
        return this.Hw;
    }

    public final boolean EQ() {
        return this.j6.gn();
    }

    public zo we() {
        return this;
    }

    private static boolean j6(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean j6(zo zoVar) {
        return this.j6 == zoVar.Zo() && this.DW.equals(zoVar.VH()) && getClass() == zoVar.getClass() && j6(this.FH, zoVar.gn()) && j6(this.Hw, zoVar.tp()) && abk.j6(DW(), zoVar.DW());
    }

    protected final String j6(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append("Insn{");
        stringBuffer.append(this.DW);
        stringBuffer.append(' ');
        stringBuffer.append(this.j6);
        if (str != null) {
            stringBuffer.append(' ');
            stringBuffer.append(str);
        }
        stringBuffer.append(" :: ");
        if (this.FH != null) {
            stringBuffer.append(this.FH);
            stringBuffer.append(" <- ");
        }
        stringBuffer.append(this.Hw);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    protected final String DW(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(this.DW);
        stringBuffer.append(": ");
        stringBuffer.append(this.j6.VH());
        if (str != null) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")");
        }
        if (this.FH == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.FH.Hw());
        }
        stringBuffer.append(" <-");
        int m_ = this.Hw.m_();
        if (m_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < m_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.Hw.DW(i).Hw());
            }
        }
        return stringBuffer.toString();
    }
}
