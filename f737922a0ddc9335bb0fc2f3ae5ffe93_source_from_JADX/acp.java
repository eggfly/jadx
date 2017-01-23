import java.util.ArrayList;

public abstract class acp {
    protected final acn DW;
    protected final acj j6;

    public abstract acd DW();

    public abstract boolean j6();

    public acp(acj acj, acn acn) {
        this.j6 = acj;
        this.DW = acn;
    }

    protected final zw j6(int i) {
        aci FH = this.j6.FH(i);
        return FH == null ? null : FH.Ws();
    }

    protected final zw j6(aci aci, zw zwVar) {
        acg QX = aci.QX();
        ArrayList FH = QX.FH();
        int indexOf = FH.indexOf(aci);
        if (indexOf < 0) {
            throw new IllegalArgumentException("specified insn is not in this block");
        } else if (indexOf != FH.size() - 1) {
            throw new IllegalArgumentException("Adding move here not supported:" + aci.Hw());
        } else {
            zw j6 = zw.j6(this.j6.Ws(), zwVar.gn());
            FH.add(indexOf, aci.j6(new zu(aab.j6(j6.j6()), aac.j6, j6, zx.j6(zwVar)), QX));
            int VH = j6.VH();
            adf DW = QX.XL().DW();
            while (DW.j6()) {
                this.DW.j6(VH, DW.DW());
            }
            zx DW2 = aci.DW();
            int m_ = DW2.m_();
            for (int i = 0; i < m_; i++) {
                this.DW.j6(VH, DW2.DW(i).VH());
            }
            this.j6.J0();
            return j6;
        }
    }
}
