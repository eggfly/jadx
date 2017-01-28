import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class bt {
    private static final long DW;
    private static final long FH;
    private do EQ;
    private final bw Hw;
    private du J0;
    private dy J8;
    private ds Mr;
    private bs[] QX;
    private dg U2;
    private final cz VH;
    private int Ws;
    private dw XL;
    private final by Zo;
    private int[] a8;
    private dw aM;
    private dr<bp> er;
    private int gW;
    private do gn;
    private dg j3;
    public bz$b j6;
    private ce lg;
    private dy rN;
    private dv<bt$a> tp;
    private boolean u7;
    private final cl v5;
    private dp we;
    private Map<bv, String> yS;

    static {
        DW = 4000000;
        FH = 2000000;
    }

    public bt(by byVar, bw bwVar, cl clVar, cz czVar) {
        this.gn = new do();
        this.EQ = new do();
        this.we = new dp();
        this.a8 = new int[1000];
        this.j6 = new bz$b(this);
        this.Zo = byVar;
        this.Hw = bwVar;
        this.v5 = clVar;
        this.VH = czVar;
        this.J0 = new du();
        this.J8 = new dy();
        this.tp = new dv();
        this.Ws = 30;
        this.QX = new bs[1000];
        this.XL = new dw();
        this.aM = new dw();
        this.j3 = new dg();
        this.U2 = new dg();
        this.Mr = new ds();
        this.rN = new dy();
        this.yS = new HashMap();
    }

    protected void j6(int i) {
        this.gW -= i;
    }

    protected void DW(int i) {
        this.gW += i;
    }

    protected void j6() {
        j6(0);
    }

    protected void DW() {
        if (((long) this.gW) > DW) {
            System.out.println("Shrink incremental: " + this.gW);
            j6(FH);
        }
    }

    protected void j6(long j) {
        int i = 0;
        if (((long) this.gW) > j) {
            int FH;
            this.EQ.j6();
            this.we.j6();
            this.tp.j6.j6();
            while (this.tp.j6.DW()) {
                FH = this.tp.j6.FH();
                bt$a bt_a = (bt$a) this.tp.j6.Hw();
                if (bt_a.v5() > 0) {
                    this.EQ.DW(FH);
                    this.we.j6(bt_a.Hw());
                }
            }
            DW(0, this.EQ.Hw() - 1);
            for (FH = 0; FH < this.EQ.Hw() && ((long) this.gW) > j; FH++) {
                ((bt$a) this.tp.FH(this.EQ.FH(FH))).tp();
            }
            while (i < this.QX.length) {
                if (FH(i) instanceof cf) {
                    ((cf) FH(i)).j6();
                }
                i++;
            }
        }
    }

    private void DW(int i, int i2) {
        if (i < i2) {
            long j6 = this.we.j6(((i2 - i) / 2) + i);
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                while (this.we.j6(i4) < j6) {
                    i4++;
                }
                while (j6 < this.we.j6(i3)) {
                    i3--;
                }
                if (i4 <= i3) {
                    int FH = this.EQ.FH(i3);
                    this.EQ.j6(i3, this.EQ.FH(i4));
                    this.EQ.j6(i4, FH);
                    long j62 = this.we.j6(i3);
                    this.we.j6(i3, this.we.j6(i4));
                    this.we.j6(i4, j62);
                    i4++;
                    i3--;
                }
            }
            DW(i, i3);
            DW(i4, i2);
        }
    }

    protected void j6(ef efVar) {
        efVar.writeInt(this.Ws);
        for (int i = 0; i < this.Ws; i++) {
            if (this.QX[i] == null) {
                efVar.writeByte(0);
            } else if (FH(i).zh()) {
                efVar.writeByte(1);
            } else if (FH(i).cT()) {
                efVar.writeByte(3);
            } else if (FH(i).AL()) {
                efVar.writeByte(4);
            } else if (FH(i).qp()) {
                efVar.writeByte(6);
            } else if (FH(i).Z1()) {
                efVar.writeByte(7);
            } else if (FH(i).q7()) {
                efVar.writeByte(8);
            } else if (FH(i).n5()) {
                efVar.writeByte(9);
            } else if (FH(i).k2()) {
                efVar.writeByte(10);
            } else if (FH(i).w9()) {
                efVar.writeByte(11);
            } else if (FH(i).hK()) {
                efVar.writeByte(12);
            } else {
                efVar.writeByte(0);
            }
        }
    }

    protected void j6(ee eeVar) {
        this.Ws = eeVar.readInt();
        this.QX = new bs[(this.Ws * 2)];
        for (int i = 0; i < this.Ws; i++) {
            switch (eeVar.readByte()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.QX[i] = new bz(this, this.Zo, this.Hw);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.QX[i] = new bp(this, this.Hw, this.Zo);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    this.QX[i] = new bo(this.Hw, this);
                    break;
                case (byte) 6:
                    this.QX[i] = new ce(this, this.Zo, this.Hw);
                    break;
                case (byte) 7:
                    this.QX[i] = new ca(this, this.Zo, this.Hw);
                    break;
                case (byte) 8:
                    this.QX[i] = new cg(this, this.Zo, this.Hw);
                    break;
                case (byte) 9:
                    this.QX[i] = new cf(this.Hw, this);
                    break;
                case (byte) 10:
                    this.QX[i] = new cb(this.Hw, this);
                    break;
                case (byte) 11:
                    this.QX[i] = new ch(this.Hw, this);
                    break;
                case (byte) 12:
                    this.QX[i] = new ci(this, this.Hw);
                    break;
                default:
                    break;
            }
        }
    }

    protected void DW(ee eeVar) {
        int i;
        int i2 = 0;
        this.lg = (ce) FH(eeVar.readInt());
        this.J0 = new du(eeVar);
        this.J8 = new dy(eeVar);
        this.tp = new dv();
        int readInt = eeVar.readInt();
        for (i = 0; i < readInt; i++) {
            this.tp.j6(eeVar.readInt(), new bt$a(this.Hw, this, eeVar));
            if (eeVar.readChar() != 'S') {
                throw new IOException("Corrupted file ");
            }
        }
        this.XL = new dw(eeVar);
        this.aM = new dw(eeVar);
        this.j3 = new dg(eeVar);
        this.U2 = new dg(eeVar);
        this.Mr = new ds(eeVar);
        for (i = 0; i < this.Ws; i++) {
            if (this.QX[i] != null) {
                this.QX[i].j6(eeVar);
                if (eeVar.readChar() != 'E') {
                    throw new IOException("Corrupted file " + this.QX[i]);
                }
            }
        }
        this.rN = new dy(eeVar);
        i = eeVar.readInt();
        while (i2 < i) {
            this.yS.put(this.Hw.gn(eeVar.readInt()), eeVar.readUTF());
            i2++;
        }
    }

    protected void DW(ef efVar) {
        efVar.writeInt(j6(this.lg));
        this.J0.j6(efVar);
        this.J8.j6(efVar);
        efVar.writeInt(this.tp.j6());
        this.tp.j6.j6();
        while (this.tp.j6.DW()) {
            bt$a bt_a = (bt$a) this.tp.j6.Hw();
            efVar.writeInt(this.tp.j6.FH());
            bt_a.j6(efVar);
            efVar.writeChar(83);
        }
        this.XL.j6(efVar);
        this.aM.j6(efVar);
        this.j3.j6(efVar);
        this.U2.j6(efVar);
        this.Mr.j6(efVar);
        for (int i = 0; i < this.Ws; i++) {
            if (this.QX[i] != null) {
                this.QX[i].j6(efVar);
                efVar.writeChar(69);
            }
        }
        this.rN.j6(efVar);
        efVar.writeInt(this.yS.size());
        for (Entry entry : this.yS.entrySet()) {
            efVar.writeInt(((bv) entry.getKey()).vy());
            efVar.writeUTF((String) entry.getValue());
        }
    }

    protected void FH() {
        int i = 0;
        eb ebVar = new eb(this.Hw);
        eb ebVar2 = new eb(this.Hw);
        this.tp.j6.j6();
        while (this.tp.j6.DW()) {
            bt$a bt_a;
            if (this.VH == null || !this.VH.DW() || ebVar.FH() != 0 || ebVar2.FH() != 0) {
                bt_a = (bt$a) this.tp.j6.Hw();
                bj j6 = bt_a.j6();
                bv DW = bt_a.DW();
                long QX = DW.QX();
                long Ws = bt_a.Ws();
                if (!(QX == Ws || Ws == -1)) {
                    this.yS.remove(DW);
                    bt_a.VH();
                    cj j62 = this.v5.j6(DW, j6);
                    Ws = j62.v5();
                    if (!(Ws == bt_a.XL() || bt_a.XL() == -1)) {
                        bt_a.DW(Ws);
                        ebVar.j6(DW);
                    }
                    Ws = j62.gn();
                    if (!(Ws == bt_a.QX() || bt_a.QX() == -1)) {
                        bt_a.j6(Ws);
                        ebVar2.j6(DW);
                    }
                    if (DW.Ws() != bt_a.J8()) {
                        ebVar2.j6(DW);
                    }
                    bt_a.FH(QX);
                    this.v5.j6(j62);
                }
            } else {
                return;
            }
        }
        if (ebVar.FH() > 0) {
            for (int i2 = 0; i2 < this.QX.length; i2++) {
                if (FH(i2) instanceof ce) {
                    ((ce) FH(i2)).j6();
                }
            }
        }
        if (ebVar2.FH() > 0) {
            this.tp.j6.j6();
            while (this.tp.j6.DW()) {
                bt_a = (bt$a) this.tp.j6.Hw();
                if (ebVar2.FH(bt_a.FH)) {
                    bt_a.u7();
                    bt_a.gn();
                }
            }
            Hw();
            return;
        }
        if (ebVar.FH() > 0) {
            while (i < this.QX.length) {
                if (FH(i) instanceof cf) {
                    ((cf) FH(i)).j6();
                }
                i++;
            }
        }
        eb ebVar3 = new eb(this.Hw);
        this.tp.j6.j6();
        while (this.tp.j6.DW()) {
            bt_a = (bt$a) this.tp.j6.Hw();
            bv j63 = bt_a.FH;
            if (!ebVar.FH(j63)) {
                ebVar.j6.j6();
                while (ebVar.j6.DW()) {
                    if (this.J8.FH(j63.vy(), ebVar.j6.FH().vy())) {
                        ebVar3.j6(j63);
                        bt_a.u7();
                        break;
                    }
                }
            }
            ebVar3.j6(j63);
            bt_a.u7();
        }
        this.J8.j6(ebVar3);
    }

    protected void Hw() {
        int i = 0;
        this.u7 = false;
        this.rN.j6();
        for (int i2 = 0; i2 < this.QX.length; i2++) {
            if (FH(i2) instanceof ce) {
                ((ce) FH(i2)).DW();
            }
        }
        while (i < this.QX.length) {
            if (FH(i) instanceof cf) {
                ((cf) FH(i)).j6();
            }
            i++;
        }
        this.er = null;
        this.tp.j6.j6();
        while (this.tp.j6.DW()) {
            ((bt$a) this.tp.j6.Hw()).u7();
        }
        this.J8.j6();
    }

    protected void v5() {
        int i = 0;
        this.u7 = false;
        this.rN.j6();
        for (int i2 = 0; i2 < this.QX.length; i2++) {
            if (FH(i2) instanceof ce) {
                ((ce) FH(i2)).DW();
            }
        }
        while (i < this.QX.length) {
            if (FH(i) instanceof cf) {
                ((cf) FH(i)).j6();
            }
            i++;
        }
    }

    public ce Zo() {
        if (this.lg == null) {
            this.lg = new ce(this, this.Zo, this.Hw, this.Zo.j6(""), null);
        }
        return this.lg;
    }

    public bs FH(int i) {
        if (i == -1) {
            return null;
        }
        return this.QX[i];
    }

    public int j6(bs bsVar) {
        if (bsVar == null) {
            return -1;
        }
        return bsVar.v5();
    }

    public ea<bs> j6(bv bvVar) {
        ea<bs> eaVar = new ea(this);
        if (bvVar.BT() != null) {
            for (bj bjVar : bvVar.BT().Zo()) {
                if (bjVar.Zo() != null) {
                    eaVar.j6(u7(bvVar, bjVar).aM());
                }
            }
        }
        return eaVar;
    }

    public String DW(bv bvVar) {
        if (this.yS.containsKey(bvVar)) {
            return (String) this.yS.get(bvVar);
        }
        String str;
        bp Hw = Hw(bvVar);
        if (Hw == null) {
            str = "";
        } else {
            str = Hw.iW();
        }
        this.yS.put(bvVar, str);
        return str;
    }

    private bp Hw(bv bvVar) {
        if (bvVar.BT() != null) {
            for (bj bjVar : bvVar.BT().Zo()) {
                if (bjVar.Zo() != null) {
                    try {
                        return u7(bvVar, bjVar).EQ();
                    } catch (ej e) {
                    }
                }
            }
        }
        return null;
    }

    public dq<bp, ce> FH(bv bvVar) {
        dq<bp, ce> dqVar = new dq(this);
        if (bvVar.BT() != null) {
            for (bj bjVar : bvVar.BT().Zo()) {
                if (bjVar.Zo() != null) {
                    dqVar.j6(u7(bvVar, bjVar).we());
                }
            }
        }
        return dqVar;
    }

    public dq<bp, bs> j6(int i, int i2, bv bvVar, bj bjVar) {
        dq DW = DW(i, i2, bvVar, bjVar);
        if (DW.FH() == 0) {
            j6(j6("android", "view"), i, i2, bvVar, DW);
            j6(j6("android", "widget"), i, i2, bvVar, DW);
        }
        return DW;
    }

    public dq<bp, bs> DW(int i, int i2, bv bvVar, bj bjVar) {
        EQ();
        dq<bp, bs> dqVar = new dq(this);
        this.er.j6.j6(i);
        while (this.er.j6.DW()) {
            bs bsVar = (bp) this.er.j6.Hw();
            if (bsVar.j6(bvVar, bjVar)) {
                dqVar.DW(bsVar, bsVar.rN());
            }
        }
        return dqVar;
    }

    public ce j6(String... strArr) {
        ce Zo = Zo();
        for (String j6 : strArr) {
            Zo = Zo.j6(this.Zo.j6(j6));
        }
        return Zo;
    }

    private void j6(ce ceVar, int i, int i2, bv bvVar, dq<bp, bs> dqVar) {
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            bs bsVar = (bp) gn.j6.Hw();
            dr et = bsVar.et();
            et.j6.j6(i);
            while (et.j6.DW()) {
                bs bsVar2 = (bp) et.j6.Hw();
                if (cd.J0(bsVar2.Ev())) {
                    dqVar.DW(bsVar2, bsVar);
                }
            }
        }
    }

    private void j6(ce ceVar, bv bvVar, dr<bp> drVar) {
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            dr et = ((bp) gn.j6.Hw()).et();
            et.j6.j6();
            while (et.j6.DW()) {
                bs bsVar = (bp) et.j6.Hw();
                if (cd.J0(bsVar.Ev())) {
                    drVar.j6(bsVar.aq(), bsVar);
                }
            }
        }
    }

    public ec FH(int i, int i2, bv bvVar, bj bjVar) {
        EQ();
        ec ecVar = new ec();
        this.er.j6.j6(i);
        while (this.er.j6.DW()) {
            bp bpVar = (bp) this.er.j6.Hw();
            if (!bpVar.j6(bvVar, bjVar)) {
                ecVar.j6(bpVar.tp().gn());
            }
        }
        return ecVar;
    }

    public dr<bp> VH() {
        EQ();
        return this.er;
    }

    public dr<bp> j6(bv bvVar, bj bjVar) {
        EQ();
        dr drVar = new dr(this);
        this.er.j6.j6();
        while (this.er.j6.DW()) {
            int FH = this.er.j6.FH();
            bs bsVar = (bp) this.er.j6.Hw();
            if (bsVar.j6(bvVar, bjVar)) {
                drVar.DW(FH, bsVar);
            }
        }
        j6(j6("android", "view"), bvVar, drVar);
        j6(j6("android", "widget"), bvVar, drVar);
        return drVar;
    }

    private void EQ() {
        if (this.er == null) {
            u7();
            this.er = new dr(this);
            eb v5 = this.Hw.v5();
            v5.j6.j6();
            while (v5.j6.DW()) {
                bv FH = v5.j6.FH();
                if (FH.nw()) {
                    dq FH2 = FH(FH);
                    FH2.j6.j6();
                    while (FH2.j6.DW()) {
                        bs bsVar = (bp) FH2.j6.FH();
                        ce ceVar = (ce) FH2.j6.Hw();
                        this.er.DW(u7(FH, bsVar.Hw()).j6((bp) bsVar), bsVar);
                    }
                }
            }
        }
    }

    public int DW(bs bsVar) {
        if (this.Ws >= this.QX.length) {
            Object obj = new bs[((this.QX.length * 2) + 1)];
            System.arraycopy(this.QX, 0, obj, 0, this.QX.length);
            this.QX = obj;
        }
        this.QX[this.Ws] = bsVar;
        int i = this.Ws;
        this.Ws = i + 1;
        return i;
    }

    public void j6(bv bvVar, bj bjVar, ce ceVar, int i, boolean z, int i2) {
        try {
            bp j6 = u7(bvVar, bjVar).j6(0, ceVar, i);
            ceVar.j6(i, j6);
            j6.j6(ceVar, i, z, i2);
            j6(ceVar, bvVar, bjVar);
            u7(bvVar, bjVar).j6(ceVar, j6, i);
        } catch (ej e) {
        }
    }

    public boolean gn() {
        return this.gn.Hw() == 0;
    }

    public boolean DW(bv bvVar, bj bjVar) {
        return u7(bvVar, bjVar).Mr();
    }

    public void j6(bp bpVar) {
        if (!bpVar.hz() && bpVar.Xa().XG()) {
            bpVar.u7();
        }
        this.gn.j6(bpVar.v5());
        if (!bpVar.yO()) {
            bpVar.gn();
        }
    }

    public void DW(bp bpVar) {
        this.gn.DW();
        if (!bpVar.yO()) {
            bpVar.VH();
        }
    }

    public void FH(bp bpVar) {
        bpVar.Zo();
        FH(bpVar.tp(), bpVar.Hw());
    }

    public void j6(bp bpVar, bp bpVar2) {
        j6(bpVar.tp(), (bs) bpVar2);
        if (!bpVar.yO()) {
            for (int i = 0; i < this.gn.Hw(); i++) {
                if (bpVar2.FH((bp) FH(this.gn.FH(i)))) {
                    bpVar.u7();
                    bpVar2.u7();
                    FH(bpVar.tp(), bpVar.Hw());
                    return;
                }
            }
            if (bpVar2.jJ()) {
                bpVar.Zo();
                FH(bpVar.tp(), bpVar.Hw());
            }
            if (bpVar2.XG()) {
                bpVar.u7();
                FH(bpVar.tp(), bpVar.Hw());
                return;
            }
            bpVar.j6(bpVar2);
        }
    }

    public void j6(bp bpVar, co coVar) {
        bpVar.j6(coVar);
    }

    public void FH(bv bvVar, bj bjVar) {
        u7(bvVar, bjVar).Zo();
    }

    public void DW(bp bpVar, co coVar) {
        bpVar.DW(coVar);
    }

    public ce j6(ce ceVar, bv bvVar, bj bjVar) {
        ceVar.j6(bvVar);
        u7(bvVar, bjVar).j6(ceVar);
        return ceVar;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, i4);
        DW.j6(i4, i3, ceVar, i2, 0, DW, DW, z, false, false, false, z2, z3);
        u7(bvVar, bjVar).j6(ceVar, DW, i4);
        return DW;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, int i2, bp bpVar, int i3, int i4, boolean z) {
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, i4);
        DW.j6(i4, i3, ceVar, i2, 0, bpVar.CU(), bpVar, z, false, false, false, false, false);
        bpVar.j6(i4, DW);
        return DW;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, int i2, bp bpVar, int i3, int i4, boolean z, boolean z2) {
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, i4);
        DW.j6(i4, i3, ceVar, i2, 0, bpVar.CU(), bpVar, z2, false, true, z, false, false);
        bpVar.j6(i4, DW);
        return DW;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, bp bpVar, boolean z, boolean z2) {
        int j6 = this.Zo.j6(i + "");
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, j6);
        DW.j6(j6, 0, ceVar, 0, 0, bpVar.CU(), bpVar, z2, true, false, z, false, false);
        return DW;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, int i2, int i3, int i4, int i5) {
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, i4);
        DW.j6(i4, i3, ceVar, i2, i5, DW, DW, false, false, false, false, false, false);
        u7(bvVar, bjVar).j6(ceVar, DW, i4);
        return DW;
    }

    public bp j6(bv bvVar, bj bjVar, int i, ce ceVar, int i2, bp bpVar, int i3, int i4, int i5) {
        bp DW = u7(bvVar, bjVar).DW(i, ceVar, i4);
        DW.j6(i4, i3, ceVar, i2, i5, bpVar.CU(), bpVar, false, false, false, false, false, false);
        bpVar.j6(i4, DW);
        return DW;
    }

    public void j6(bv bvVar, bj bjVar, int i, bp bpVar, int i2, int i3) {
        cg gn = u7(bvVar, bjVar).gn(i);
        gn.j6(i3, bpVar, i2);
        bpVar.j6(i2, i3, gn);
    }

    public void j6(bv bvVar, bj bjVar, int i, bz bzVar, int i2, int i3) {
        ca VH = u7(bvVar, bjVar).VH(i);
        VH.j6(i3, bzVar, i2);
        bzVar.j6(i2, i3, VH);
    }

    public void j6(bp bpVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        bpVar.j6(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public bz j6(bv bvVar, bj bjVar, int i, bp bpVar, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4) {
        bz u7 = u7(bvVar, bjVar).u7(i);
        bpVar.DW(i3, u7);
        u7.j6(bpVar, i2, i3, z, z2, z3, z4);
        return u7;
    }

    public void j6(bz bzVar, long j) {
        bzVar.j6(j);
    }

    public void j6(bz bzVar, String str) {
        bzVar.j6(str);
    }

    public void j6(bz bzVar, co coVar, int i) {
        bzVar.j6(coVar, i);
    }

    public void DW(bz bzVar, co coVar, int i) {
        bzVar.DW(coVar, i);
    }

    public void j6(bz bzVar, co coVar) {
        bzVar.j6(coVar);
    }

    public void j6(bz bzVar, int i, int i2, int i3) {
        bzVar.j6(i, i2, i3);
    }

    public void j6(ca caVar, co coVar) {
        caVar.j6(coVar);
    }

    public void j6(cg cgVar, co coVar) {
        cgVar.j6(coVar);
    }

    public void j6(bz bzVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        bzVar.j6(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public void j6(ca caVar, int i, int i2, int i3) {
        caVar.j6(i, i2, i3);
    }

    public void j6(cg cgVar, int i, int i2, int i3) {
        cgVar.j6(i, i2, i3);
    }

    public void j6(bz bzVar, int i) {
        bzVar.j6(i);
    }

    public bz j6(bv bvVar, bj bjVar, int i, bp bpVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6) {
        bz u7 = u7(bvVar, bjVar).u7(i);
        bpVar.j6(i3, u7);
        u7.j6(bpVar, i2, i4, i5, z, z2, 0, i3, false, false, false, i6);
        return u7;
    }

    public bz j6(bv bvVar, bj bjVar, int i, bp bpVar, int i2, int i3, int i4, boolean z, int i5) {
        bz u7 = u7(bvVar, bjVar).u7(i);
        bpVar.j6(u7);
        u7.j6(bpVar, i2, i3, i4, z, false, 0, bpVar.aq(), true, false, false, i5);
        return u7;
    }

    protected void j6(bv bvVar, bs bsVar) {
        bv tp;
        if (bsVar.cT()) {
            tp = bsVar.tp();
            if (tp.J8()) {
                tp = tp.EQ();
            }
            if (bvVar != tp) {
                this.J8.DW(bvVar.vy(), tp.vy());
            }
        } else if (bsVar.n5()) {
            tp = ((cf) bsVar).gn().tp();
            if (tp.J8()) {
                tp = tp.EQ();
            }
            if (bvVar != tp) {
                this.J8.DW(bvVar.vy(), tp.vy());
            }
        }
    }

    public bp j6(bv bvVar, bj bjVar, int i) {
        return u7(bvVar, bjVar).Hw(i);
    }

    public bz DW(bv bvVar, bj bjVar, int i) {
        return u7(bvVar, bjVar).FH(i);
    }

    public cg FH(bv bvVar, bj bjVar, int i) {
        return u7(bvVar, bjVar).v5(i);
    }

    public ca Hw(bv bvVar, bj bjVar, int i) {
        return u7(bvVar, bjVar).Zo(i);
    }

    public co j6(bp bpVar, co[] coVarArr, int[] iArr) {
        int kQ = bpVar.kQ();
        bp bpVar2 = bpVar;
        while (true) {
            kQ -= bpVar2.XX();
            if (!bpVar2.we()) {
                break;
            }
            bp Xa = bpVar2.Xa();
            if (Xa == bpVar2) {
                break;
            }
            bpVar2 = Xa;
        }
        for (int i = 0; i < kQ; i++) {
            try {
                coVarArr[i] = bpVar.DW(i);
            } catch (ej e) {
            }
            iArr[i] = -1;
        }
        int kQ2 = bpVar.kQ();
        for (kQ = 0; kQ < kQ2; kQ++) {
            if (iArr[kQ] != -1) {
                for (kQ = 0; kQ < kQ2; kQ++) {
                    if (iArr[kQ] == -1) {
                        iArr[kQ] = 0;
                        try {
                            coVarArr[kQ] = v5(bpVar.tp(), bpVar.Hw());
                        } catch (ej e2) {
                        }
                    }
                }
                for (kQ = 0; kQ < kQ2; kQ++) {
                    this.a8[kQ] = coVarArr[kQ].v5();
                }
                if (this.Mr.DW(bpVar.v5(), this.a8, iArr, 0, kQ2)) {
                    return (cf) FH(this.Mr.j6(bpVar.v5(), this.a8, iArr, 0, kQ2));
                }
                co cfVar = new cf(this.Hw, this, bpVar, coVarArr, iArr);
                this.Mr.j6(bpVar.v5(), this.a8, iArr, 0, kQ2, cfVar.v5());
                return cfVar;
            }
        }
        return bpVar;
    }

    public cb j6(ca caVar) {
        if (!this.U2.DW(caVar.v5())) {
            this.U2.j6(caVar.v5(), new cb(this.Hw, this, caVar).v5());
        }
        return (cb) FH(this.U2.FH(caVar.v5()));
    }

    public bo j6(co coVar, int i) {
        long v5 = ((long) i) | (((long) coVar.v5()) << 32);
        if (this.XL.j6(v5)) {
            return (bo) FH(this.XL.FH(v5));
        }
        bo boVar = new bo(this.Hw, this, coVar, i);
        this.XL.j6(v5, boVar.v5());
        return boVar;
    }

    public ci j6(bj bjVar, int i) {
        long j6 = ((long) i) | (((long) this.Hw.j6(bjVar)) << 32);
        if (this.aM.j6(j6)) {
            return (ci) FH(this.aM.FH(j6));
        }
        ci ciVar = new ci(this, this.Hw, bjVar.VH().j6(i), bjVar);
        this.aM.j6(j6, ciVar.v5());
        return ciVar;
    }

    public ea<co> j6(bv bvVar, bj bjVar, bo boVar) {
        return bjVar.VH().j6(bvVar, boVar);
    }

    public bp Hw(bv bvVar, bj bjVar) {
        return bjVar.VH().j6(bvVar);
    }

    public bp v5(bv bvVar, bj bjVar) {
        return bjVar.VH().DW(bvVar);
    }

    public long j6(boolean z) {
        return z ? 1 : 0;
    }

    public boolean DW(long j) {
        return j == 1;
    }

    public long j6(double d) {
        return Double.doubleToLongBits(d);
    }

    public double FH(long j) {
        return Double.longBitsToDouble(j);
    }

    public long j6(float f) {
        return (long) Float.floatToIntBits(f);
    }

    public float Hw(long j) {
        return Float.intBitsToFloat((int) j);
    }

    public long Hw(int i) {
        return (long) i;
    }

    public int v5(long j) {
        return (int) j;
    }

    public long Zo(long j) {
        return j;
    }

    public long VH(long j) {
        return j;
    }

    public long j6(bv bvVar, bj bjVar, long j, co coVar, co coVar2) {
        if (coVar.Hw(coVar2)) {
            return j;
        }
        if (coVar.Mz()) {
            return j6(bvVar, bjVar, j, ((bp) coVar.a_()).j6(bvVar), coVar2);
        } else if (coVar2.Mz()) {
            return j6(bvVar, bjVar, j, coVar, ((bp) coVar2.a_()).j6(bvVar));
        } else {
            switch (coVar2.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return Hw((byte) v5(j));
                        case 9:
                        case 10:
                            return Hw((byte) ((int) VH(j)));
                        case 13:
                            return Hw((byte) ((int) Hw(j)));
                        case 14:
                            return Hw((byte) ((int) FH(j)));
                        default:
                            break;
                    }
                case 5:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return Hw((short) v5(j));
                        case 9:
                        case 10:
                            return Hw((short) ((int) VH(j)));
                        case 13:
                            return Hw((short) ((int) Hw(j)));
                        case 14:
                            return Hw((short) ((int) FH(j)));
                        default:
                            break;
                    }
                case 6:
                case 12:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return Hw((char) v5(j));
                        case 9:
                        case 10:
                            return Hw((char) ((int) VH(j)));
                        case 13:
                            return Hw((char) ((int) Hw(j)));
                        case 14:
                            return Hw((char) ((int) FH(j)));
                        default:
                            break;
                    }
                case 7:
                case 8:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return j;
                        case 9:
                        case 10:
                            return Hw((int) VH(j));
                        case 13:
                            return Hw((int) Hw(j));
                        case 14:
                            return Hw((int) FH(j));
                        default:
                            break;
                    }
                case 9:
                case 10:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return Zo((long) v5(j));
                        case 13:
                            return Zo((long) Hw(j));
                        case 14:
                            return Zo((long) FH(j));
                        default:
                            break;
                    }
                case 13:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return j6((float) v5(j));
                        case 9:
                        case 10:
                            return j6((float) VH(j));
                        case 14:
                            return j6((float) FH(j));
                        default:
                            break;
                    }
                case 14:
                    switch (coVar.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 12:
                            return j6((double) v5(j));
                        case 9:
                        case 10:
                            return j6((double) VH(j));
                        case 13:
                            return j6((double) Hw(j));
                        default:
                            break;
                    }
            }
            throw new ej();
        }
    }

    public long j6(bv bvVar, int i, long j, co coVar) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        return Hw(-v5(j));
                    case 9:
                        return Zo(-VH(j));
                    case 13:
                        return j6(-Hw(j));
                    case 14:
                        return j6(-FH(j));
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_date /*20*/:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 12:
                        return Hw(v5(j) ^ -1);
                    case 9:
                        return Zo(VH(j) ^ -1);
                    default:
                        break;
                }
            case 21:
                return j6(!DW(j));
        }
        throw new ej();
    }

    public long j6(bv bvVar, bj bjVar, int i, long j, long j2, co coVar, co coVar2) {
        co j6;
        long j62;
        long j63;
        boolean z;
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                try {
                    if (!coVar.Mz()) {
                        j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                        j62 = j6(bvVar, bjVar, j, coVar, j6);
                        j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                        switch (j6.Gj()) {
                            case 7:
                            case 8:
                                return Hw(v5(j63) + v5(j62));
                            case 9:
                            case 10:
                                return Zo(VH(j63) + VH(j62));
                            case 13:
                                return j6(Hw(j63) + Hw(j62));
                            case 14:
                                return j6(FH(j63) + FH(j62));
                            default:
                                break;
                        }
                    }
                    return j6(bvVar, bjVar, i, j6(bvVar, bjVar, j, coVar, ((bp) coVar.a_()).j6(bvVar)), j2, ((bp) coVar.a_()).j6(bvVar), coVar2);
                } catch (Exception e) {
                    break;
                }
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j62) - v5(j63));
                    case 9:
                    case 10:
                        return Zo(VH(j62) - VH(j63));
                    case 13:
                        return j6(Hw(j62) - Hw(j63));
                    case 14:
                        return j6(FH(j62) - FH(j63));
                    default:
                        break;
                }
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j62) / v5(j63));
                    case 9:
                    case 10:
                        return Zo(VH(j62) / VH(j63));
                    case 13:
                        return j6(Hw(j62) / Hw(j63));
                    case 14:
                        return j6(FH(j62) / FH(j63));
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j62) % v5(j63));
                    case 9:
                    case 10:
                        return Zo(VH(j62) % VH(j63));
                    case 13:
                        return j6(Hw(j62) % Hw(j63));
                    case 14:
                        return j6(FH(j62) % FH(j63));
                    default:
                        break;
                }
            case 5:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j63) * v5(j62));
                    case 9:
                    case 10:
                        return Zo(VH(j63) * VH(j62));
                    case 13:
                        return j6(Hw(j63) * Hw(j62));
                    case 14:
                        return j6(FH(j63) * FH(j62));
                    default:
                        break;
                }
            case 6:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j63) | v5(j62));
                    case 9:
                    case 10:
                        return Zo(VH(j63) | VH(j62));
                    case 11:
                        return j6(DW(j63) | DW(j62));
                    default:
                        break;
                }
            case 7:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j63) & v5(j62));
                    case 9:
                    case 10:
                        return Zo(VH(j63) & VH(j62));
                    case 11:
                        return j6(DW(j63) & DW(j62));
                    default:
                        break;
                }
            case 8:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return Hw(v5(j63) ^ v5(j62));
                    case 9:
                    case 10:
                        return Zo(VH(j63) ^ VH(j62));
                    case 11:
                        return j6(DW(j63) ^ DW(j62));
                    default:
                        break;
                }
            case 9:
                j6 = coVar == coVar2 ? coVar : coVar.DW(bvVar, bjVar, coVar2) ? coVar2 : coVar;
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        if (v5(j62) == v5(j63)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return j6(z);
                    case 9:
                    case 10:
                        return j6(VH(j62) == VH(j63));
                    case 11:
                        return j6(DW(j62) == DW(j63));
                    case 13:
                        return j6(Hw(j62) == Hw(j63));
                    case 14:
                        return j6(FH(j62) == FH(j63));
                    default:
                        break;
                }
            case 10:
                j6 = coVar == coVar2 ? coVar : coVar.DW(bvVar, bjVar, coVar2) ? coVar2 : coVar;
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        if (v5(j62) != v5(j63)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return j6(z);
                    case 9:
                    case 10:
                        return j6(VH(j62) != VH(j63));
                    case 11:
                        return j6(DW(j62) != DW(j63));
                    case 13:
                        return j6(Hw(j62) != Hw(j63));
                    case 14:
                        return j6(FH(j62) != FH(j63));
                    default:
                        break;
                }
            case 11:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return j6(v5(j62) < v5(j63));
                    case 9:
                    case 10:
                        return j6(VH(j62) < VH(j63));
                    case 13:
                        return j6(Hw(j62) < Hw(j63));
                    case 14:
                        return j6(FH(j62) < FH(j63));
                    default:
                        break;
                }
            case 12:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return j6(v5(j62) <= v5(j63));
                    case 9:
                    case 10:
                        return j6(VH(j62) <= VH(j63));
                    case 13:
                        return j6(Hw(j62) <= Hw(j63));
                    case 14:
                        return j6(FH(j62) <= FH(j63));
                    default:
                        break;
                }
            case 13:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return j6(v5(j62) > v5(j63));
                    case 9:
                    case 10:
                        return j6(VH(j62) > VH(j63));
                    case 13:
                        return j6(Hw(j62) > Hw(j63));
                    case 14:
                        return j6(FH(j62) > FH(j63));
                    default:
                        break;
                }
            case 14:
                j6 = bjVar.VH().j6(bvVar, i, coVar, coVar2);
                j62 = j6(bvVar, bjVar, j, coVar, j6);
                j63 = j6(bvVar, bjVar, j2, coVar2, j6);
                switch (j6.Gj()) {
                    case 7:
                    case 8:
                        return j6(v5(j62) >= v5(j63));
                    case 9:
                    case 10:
                        return j6(VH(j62) >= VH(j63));
                    case 13:
                        return j6(Hw(j62) >= Hw(j63));
                    case 14:
                        return j6(FH(j62) >= FH(j63));
                    default:
                        break;
                }
            case 15:
                z = DW(j) || DW(j2);
                return j6(z);
            case 16:
                z = DW(j) && DW(j2);
                return j6(z);
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                switch (coVar2.Gj()) {
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        switch (coVar.Gj()) {
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) << v5(j2));
                            case 9:
                                return Zo(VH(j) << v5(j2));
                            default:
                                break;
                        }
                    case 9:
                        switch (coVar.Gj()) {
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) << ((int) VH(j2)));
                            case 9:
                                return Zo(VH(j) << ((int) VH(j2)));
                            default:
                                break;
                        }
                    default:
                        break;
                }
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                switch (coVar2.Gj()) {
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 7:
                    case 12:
                        switch (coVar.Gj()) {
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) >> v5(j2));
                            case 9:
                                return Zo(VH(j) >> v5(j2));
                            default:
                                break;
                        }
                    case 9:
                        switch (coVar.Gj()) {
                            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) >> ((int) VH(j2)));
                            case 9:
                                return Zo(VH(j) >> ((int) VH(j2)));
                            default:
                                break;
                        }
                    default:
                        break;
                }
            case 19:
                switch (coVar2.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        switch (coVar.Gj()) {
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) >>> v5(j2));
                            case 9:
                                return Zo(VH(j) >>> v5(j2));
                            default:
                                break;
                        }
                    case 9:
                        switch (coVar.Gj()) {
                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            case 5:
                            case 7:
                            case 12:
                                return Hw(v5(j) >>> ((int) VH(j2)));
                            case 9:
                                return Zo(VH(j) >>> ((int) VH(j2)));
                            default:
                                break;
                        }
                    default:
                        break;
                }
        }
        throw new ej();
    }

    public long j6(bv bvVar, bj bjVar, long j, long j2, long j3, co coVar, co coVar2) {
        co j6 = bjVar.VH().j6(bvVar, coVar, coVar2);
        if (DW(j)) {
            return j6(bvVar, bjVar, j2, coVar, j6);
        }
        return j6(bvVar, bjVar, j3, coVar2, j6);
    }

    protected boolean j6(int i, int i2) {
        return this.rN.FH(i, i2);
    }

    protected boolean j6(bv bvVar, bj bjVar, co coVar, co coVar2) {
        return bjVar.VH().FH(bvVar, coVar, coVar2);
    }

    protected boolean DW(bv bvVar, bj bjVar, co coVar, co coVar2) {
        return bjVar.VH().DW(bvVar, coVar, coVar2);
    }

    protected void j6(bz bzVar) {
        if (bzVar.Hw().Zo() != null) {
            bzVar.Hw().Zo().j6(bzVar);
        }
    }

    protected void Hw(bp bpVar) {
        if (bpVar.Hw().Zo() != null) {
            bpVar.Hw().Zo().Hw(bpVar);
        }
    }

    protected void v5(bp bpVar) {
        if (bpVar.Hw().Zo() != null) {
            bpVar.Hw().Zo().FH(bpVar);
        }
    }

    protected void Zo(bp bpVar) {
        if (bpVar.Hw().Zo() != null) {
            bpVar.Hw().Zo().j6(bpVar);
        }
    }

    protected void j6(bv bvVar, bj bjVar, bp bpVar) {
        if (bjVar.Zo() != null) {
            bjVar.Zo().DW(bpVar);
        }
    }

    protected void Zo(bv bvVar, bj bjVar) {
        u7(bvVar, bjVar).j3();
    }

    protected void VH(bv bvVar, bj bjVar) {
        u7(bvVar, bjVar).lg();
    }

    protected void gn(bv bvVar, bj bjVar) {
        u7(bvVar, bjVar).a8();
    }

    protected void u7() {
    }

    protected void tp() {
        if (!this.u7) {
            bv FH;
            this.u7 = true;
            eb v5 = this.Hw.v5();
            v5.j6.j6();
            while (v5.j6.DW()) {
                FH = v5.j6.FH();
                if (FH.nw() && FH.BT() != null) {
                    for (bj bjVar : FH.BT().Zo()) {
                        if (bjVar.Zo() != null) {
                            u7(FH, bjVar).U2();
                            if (this.VH != null && this.VH.DW()) {
                                this.u7 = false;
                                return;
                            }
                        }
                    }
                    continue;
                }
            }
            eb v52 = this.Hw.v5();
            v52.j6.j6();
            while (v52.j6.DW()) {
                bv FH2 = v52.j6.FH();
                if (FH2.nw() && FH2.BT() != null) {
                    for (bj bjVar2 : FH2.BT().Zo()) {
                        if (bjVar2.Zo() != null) {
                            ea J0 = u7(FH2, bjVar2).J0();
                            J0.j6.j6();
                            while (J0.j6.DW()) {
                                j6((ce) J0.j6.FH(), FH2, bjVar2);
                            }
                            dq we = u7(FH2, bjVar2).we();
                            we.j6.j6();
                            while (we.j6.DW()) {
                                bp bpVar = (bp) we.j6.FH();
                                ((ce) we.j6.Hw()).j6(u7(FH2, bjVar2).j6(bpVar), bpVar);
                            }
                        }
                    }
                }
            }
            v5 = this.Hw.v5();
            v5.j6.j6();
            while (v5.j6.DW()) {
                FH = v5.j6.FH();
                if (FH.nw() && FH.BT() != null) {
                    for (bj bjVar22 : FH.BT().Zo()) {
                        if (bjVar22.Zo() != null) {
                            ec FH3 = u7(FH, bjVar22).FH();
                            FH3.j6.j6();
                            while (FH3.j6.DW()) {
                                this.rN.DW(FH.gn(), FH3.j6.FH());
                            }
                        }
                    }
                }
            }
        }
    }

    protected String FH(bs bsVar) {
        bv tp = bsVar.tp();
        if (tp == null) {
            return "";
        }
        for (cj cjVar : this.v5.DW(tp)) {
            int j6 = j6(cjVar, cjVar.Ws(), bsVar.er(), bsVar.gW());
            if (j6 != -1) {
                String j3 = cjVar.tp().Hw().j3(cjVar, j6);
                if (j3 != null) {
                    return j3;
                }
            }
            this.v5.j6(cjVar);
        }
        return "";
    }

    protected String Hw(bs bsVar) {
        bv tp = bsVar.tp();
        if (tp == null) {
            return "";
        }
        for (cj cjVar : this.v5.DW(tp)) {
            int j6 = j6(cjVar, cjVar.Ws(), bsVar.er(), bsVar.gW());
            if (j6 != -1) {
                String aM = cjVar.tp().Hw().aM(cjVar, j6);
                if (aM != null) {
                    return aM;
                }
            }
            this.v5.j6(cjVar);
        }
        return "";
    }

    private int j6(cj cjVar, int i, int i2, int i3) {
        int i4;
        if (!cjVar.tp().Hw().XL(cjVar, i) || cjVar.SI(i) >= i2 || cjVar.SI(i) < i2 - 10) {
            i4 = -1;
        } else {
            i4 = i;
        }
        int lg = cjVar.lg(i);
        for (int i5 = 0; i5 < lg; i5++) {
            int j6 = j6(cjVar, cjVar.Hw(i, i5), i2, i3);
            if (j6 != -1 && (i4 == -1 || cjVar.SI(j6) > cjVar.SI(i4))) {
                i4 = j6;
            }
        }
        return i4;
    }

    private bt$a u7(bv bvVar, bj bjVar) {
        int j6 = this.Hw.j6(bvVar, bjVar);
        if (this.tp.j6(j6)) {
            return (bt$a) this.tp.FH(j6);
        }
        bt$a bt_a = new bt$a(this.Hw, this, bvVar, bjVar);
        this.tp.j6(j6, bt_a);
        return bt_a;
    }
}
