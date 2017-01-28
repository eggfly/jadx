public final class ry implements tf {
    private final abe DW;
    private final boolean FH;
    private final qv Hw;
    private final sc Zo;
    private final tf j6;
    private final sb v5;

    public ry(tf tfVar, tb tbVar, boolean z, boolean z2) {
        this(tfVar, tbVar.FH(), tbVar.EQ(), z, z2);
    }

    public ry(tf tfVar, int i, abe abe, boolean z, boolean z2) {
        sb sbVar;
        sc DW;
        this.j6 = tfVar;
        this.FH = (i & 32) != 0;
        this.DW = abe;
        this.Hw = (qv) tfVar.v5().j6("Code");
        ta Zo = this.Hw.Zo();
        sb sbVar2 = sb.j6;
        if (z) {
            sbVar = sbVar2;
            sz szVar = (rb) Zo.j6("LineNumberTable");
            while (szVar != null) {
                sb j6 = sb.j6(sbVar, szVar.DW());
                Object obj = (rb) Zo.j6(szVar);
                sbVar = j6;
            }
        } else {
            sbVar = sbVar2;
        }
        this.v5 = sbVar;
        sc scVar = sc.j6;
        if (z2) {
            sz szVar2;
            for (szVar2 = (rc) Zo.j6("LocalVariableTable"); szVar2 != null; rc rcVar = (rc) Zo.j6(szVar2)) {
                scVar = sc.j6(scVar, szVar2.DW());
            }
            sc scVar2 = sc.j6;
            for (szVar2 = (rd) Zo.j6("LocalVariableTypeTable"); szVar2 != null; rd rdVar = (rd) Zo.j6(szVar2)) {
                scVar2 = sc.j6(scVar2, szVar2.DW());
            }
            if (scVar2.m_() != 0) {
                DW = sc.DW(scVar, scVar2);
                this.Zo = DW;
            }
        }
        DW = scVar;
        this.Zo = DW;
    }

    public abc j6() {
        return this.j6.j6();
    }

    public abe DW() {
        return this.j6.DW();
    }

    public abe FH() {
        return this.j6.FH();
    }

    public int Hw() {
        return this.j6.Hw();
    }

    public ta v5() {
        return this.j6.v5();
    }

    public abf Zo() {
        return this.j6.Zo();
    }

    public abj VH() {
        return this.j6.VH();
    }

    public boolean gn() {
        return this.FH;
    }

    public int u7() {
        return this.Hw.DW();
    }

    public int tp() {
        return this.Hw.FH();
    }

    public rx EQ() {
        return this.Hw.Hw();
    }

    public rv we() {
        return this.Hw.v5();
    }

    public sc J0() {
        return this.Zo;
    }

    public aac j6(int i) {
        return new aac(this.DW, i, this.v5.DW(i));
    }
}
