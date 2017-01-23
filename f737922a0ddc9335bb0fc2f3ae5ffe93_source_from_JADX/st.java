import java.util.ArrayList;

public class st implements rx$c {
    private final ti DW;
    private final acu j6;

    public st(acu acu, ti tiVar) {
        if (acu == null) {
            throw new NullPointerException("bytes == null");
        } else if (tiVar == null) {
            throw new NullPointerException("observer == null");
        } else {
            this.j6 = acu;
            this.DW = tiVar;
        }
    }

    public void j6(int i, int i2, int i3) {
        this.DW.j6(this.j6, i2, i3, DW(i2));
    }

    public void j6(int i, int i2, int i3, abl abl) {
        this.DW.j6(this.j6, i2, i3, DW(i2));
    }

    public void j6(int i, int i2, int i3, int i4, abl abl, int i5) {
        Object obj = 1;
        String v5 = i3 <= 3 ? add.v5(i4) : add.FH(i4);
        if (i3 != 1) {
            obj = null;
        }
        String str = "";
        if (i == 132) {
            str = ", #" + (i3 <= 3 ? add.u7(i5) : add.gn(i5));
        }
        String str2 = "";
        if (abl.we()) {
            str2 = (obj != null ? "," : " //") + " category-2";
        }
        this.DW.j6(this.j6, i2, i3, DW(i2) + (obj != null ? " // " : " ") + v5 + str + str2);
    }

    public void j6(int i, int i2, int i3, aah aah, int i4) {
        if (aah instanceof aav) {
            j6(i, i2, i3, null);
        } else if (aah instanceof aat) {
            DW(i, i2, i3, i4);
        } else if (aah instanceof aaz) {
            j6(i, i2, i3, ((aaz) aah).J8());
        } else if (aah instanceof aas) {
            FH(i, i2, i3, ((aas) aah).tp());
        } else if (aah instanceof aap) {
            DW(i, i2, i3, ((aap) aah).EQ());
        } else {
            String str = "";
            if (i4 != 0) {
                str = ", ";
                if (i == 197) {
                    str = str + add.v5(i4);
                } else {
                    str = str + add.FH(i4);
                }
            }
            this.DW.j6(this.j6, i2, i3, DW(i2) + " " + aah + str);
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        this.DW.j6(this.j6, i2, i3, DW(i2) + " " + (i3 <= 3 ? add.FH(i4) : add.j6(i4)));
    }

    public void j6(int i, int i2, int i3, sn snVar, int i4) {
        int j6 = snVar.j6();
        StringBuffer stringBuffer = new StringBuffer((j6 * 20) + 100);
        stringBuffer.append(DW(i2));
        if (i4 != 0) {
            stringBuffer.append(" // padding: " + add.j6(i4));
        }
        stringBuffer.append('\n');
        for (int i5 = 0; i5 < j6; i5++) {
            stringBuffer.append("  ");
            stringBuffer.append(add.VH(snVar.j6(i5)));
            stringBuffer.append(": ");
            stringBuffer.append(add.FH(snVar.DW(i5)));
            stringBuffer.append('\n');
        }
        stringBuffer.append("  default: ");
        stringBuffer.append(add.FH(snVar.DW()));
        this.DW.j6(this.j6, i2, i3, stringBuffer.toString());
    }

    public void j6(int i, int i2, abf abf, ArrayList<aah> arrayList) {
        this.DW.j6(this.j6, i, i2, DW(i) + (i2 == 1 ? " // " : " ") + abf.u7().U2().Hw());
    }

    public void j6(int i) {
    }

    public int j6() {
        return -1;
    }

    private String DW(int i) {
        int v5 = this.j6.v5(i);
        String j6 = rw.j6(v5);
        if (v5 == 196) {
            j6 = j6 + " " + rw.j6(this.j6.v5(i + 1));
        }
        return add.FH(i) + ": " + j6;
    }

    private void DW(int i, int i2, int i3, int i4) {
        String str;
        String str2 = i3 == 1 ? " // " : " ";
        int v5 = this.j6.v5(i2);
        if (i3 == 1 || v5 == 16) {
            str = "#" + add.u7(i4);
        } else if (v5 == 17) {
            str = "#" + add.gn(i4);
        } else {
            str = "#" + add.VH(i4);
        }
        this.DW.j6(this.j6, i2, i3, DW(i2) + str2 + str);
    }

    private void j6(int i, int i2, int i3, long j) {
        String u7;
        String str = i3 == 1 ? " // " : " #";
        if (i3 == 1) {
            u7 = add.u7((int) j);
        } else {
            u7 = add.DW(j);
        }
        this.DW.j6(this.j6, i2, i3, DW(i2) + str + u7);
    }

    private void FH(int i, int i2, int i3, int i4) {
        this.DW.j6(this.j6, i2, i3, DW(i2) + (i3 != 1 ? " #" + add.j6(i4) : "") + " // " + Float.intBitsToFloat(i4));
    }

    private void DW(int i, int i2, int i3, long j) {
        this.DW.j6(this.j6, i2, i3, DW(i2) + (i3 != 1 ? " #" + add.j6(j) : "") + " // " + Double.longBitsToDouble(j));
    }
}
