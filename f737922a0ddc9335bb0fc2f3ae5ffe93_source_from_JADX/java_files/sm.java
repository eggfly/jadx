public class sm {
    private final rx DW;
    private final sc FH;
    private final sm$a Hw;
    private final sf j6;

    public sm(sf sfVar, ry ryVar) {
        if (sfVar == null) {
            throw new NullPointerException("machine == null");
        } else if (ryVar == null) {
            throw new NullPointerException("method == null");
        } else {
            this.j6 = sfVar;
            this.DW = ryVar.EQ();
            this.FH = ryVar.J0();
            this.Hw = new sm$a(this);
        }
    }

    public void j6(rt rtVar, sa saVar) {
        int FH = rtVar.FH();
        this.Hw.j6(saVar);
        try {
            int DW = rtVar.DW();
            while (DW < FH) {
                int j6 = this.DW.j6(DW, this.Hw);
                this.Hw.j6(DW);
                DW += j6;
            }
        } catch (ada e) {
            saVar.j6(e);
            throw e;
        }
    }

    private static sl DW() {
        return new sl("stack mismatch: illegal top-of-stack for opcode");
    }

    private static abl DW(abl abl, abl abl2) {
        if (abl2 == abl.tp) {
            return abl.Mr();
        }
        if (abl == abl.Ws && abl2.QX() && abl2.U2().Ws()) {
            return abl2;
        }
        if (abl == abl.DW && abl2 == abl.BT) {
            return abl.BT;
        }
        return abl.Mr();
    }
}
