import com.aide.uidesigner.ProxyTextView;

public final class zz {
    private final abl DW;
    private final abn FH;
    private final abn Hw;
    private final String VH;
    private final boolean Zo;
    private final int j6;
    private final int v5;

    public zz(int i, abl abl, abn abn, abn abn2, int i2, boolean z, String str) {
        if (abl == null) {
            throw new NullPointerException("result == null");
        } else if (abn == null) {
            throw new NullPointerException("sources == null");
        } else if (abn2 == null) {
            throw new NullPointerException("exceptions == null");
        } else if (i2 < 1 || i2 > 6) {
            throw new IllegalArgumentException("bogus branchingness");
        } else if (abn2.m_() == 0 || i2 == 6) {
            this.j6 = i;
            this.DW = abl;
            this.FH = abn;
            this.Hw = abn2;
            this.v5 = i2;
            this.Zo = z;
            this.VH = str;
        } else {
            throw new IllegalArgumentException("exceptions / branchingness mismatch");
        }
    }

    public zz(int i, abl abl, abn abn, int i2, String str) {
        this(i, abl, abn, abk.j6, i2, false, str);
    }

    public zz(int i, abl abl, abn abn, String str) {
        this(i, abl, abn, abk.j6, 1, false, str);
    }

    public zz(int i, abl abl, abn abn, abn abn2, String str) {
        this(i, abl, abn, abn2, 6, false, str);
    }

    public zz(int i, abn abn, abn abn2) {
        this(i, abl.u7, abn, abn2, 6, true, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zz)) {
            return false;
        }
        zz zzVar = (zz) obj;
        if (this.j6 == zzVar.j6 && this.v5 == zzVar.v5 && this.DW == zzVar.DW && this.FH.equals(zzVar.FH) && this.Hw.equals(zzVar.Hw)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.j6 * 31) + this.v5) * 31) + this.DW.hashCode()) * 31) + this.FH.hashCode()) * 31) + this.Hw.hashCode();
    }

    public String toString() {
        int i;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append("Rop{");
        stringBuffer.append(zv.j6(this.j6));
        if (this.DW != abl.u7) {
            stringBuffer.append(" ");
            stringBuffer.append(this.DW);
        } else {
            stringBuffer.append(" .");
        }
        stringBuffer.append(" <-");
        int m_ = this.FH.m_();
        if (m_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (i = 0; i < m_; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(this.FH.j6(i));
            }
        }
        if (this.Zo) {
            stringBuffer.append(" call");
        }
        i = this.Hw.m_();
        if (i == 0) {
            switch (this.v5) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    stringBuffer.append(" flows");
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    stringBuffer.append(" returns");
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    stringBuffer.append(" gotos");
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    stringBuffer.append(" ifs");
                    break;
                case 5:
                    stringBuffer.append(" switches");
                    break;
                default:
                    stringBuffer.append(" " + add.v5(this.v5));
                    break;
            }
        }
        stringBuffer.append(" throws");
        while (i2 < i) {
            stringBuffer.append(' ');
            if (this.Hw.j6(i2) == abl.aM) {
                stringBuffer.append("<any>");
            } else {
                stringBuffer.append(this.Hw.j6(i2));
            }
            i2++;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int j6() {
        return this.j6;
    }

    public abl DW() {
        return this.DW;
    }

    public abn FH() {
        return this.FH;
    }

    public int Hw() {
        return this.v5;
    }

    public boolean v5() {
        return this.Zo;
    }

    public boolean Zo() {
        switch (this.j6) {
            case 14:
            case 16:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 21:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public String VH() {
        if (this.VH != null) {
            return this.VH;
        }
        return toString();
    }

    public final boolean gn() {
        return this.Hw.m_() != 0;
    }
}
