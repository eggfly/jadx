import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.util.Hashtable;

public class ba extends cc {
    public final ak DW;
    public final aq EQ;
    public final aw FH;
    public final av Hw;
    public final ao J0;
    public final am J8;
    public final al QX;
    public final aj VH;
    public final ay Ws;
    public final ax XL;
    public final bb Zo;
    public final az aM;
    public final ai gn;
    public final as j3;
    public final ap j6;
    public final ar tp;
    public final at u7;
    public final an v5;
    public final au we;

    public ba(cx cxVar, cz czVar, da daVar, cu cuVar, db dbVar, cr crVar, cy cyVar, df dfVar, cs csVar, cq cqVar, ct ctVar, de deVar, dd ddVar, cv cvVar, dc dcVar, cw cwVar) {
        super(daVar, cuVar, dbVar, crVar, cyVar, dfVar, csVar, cqVar, ctVar, czVar, cxVar, deVar, ddVar, cvVar, dcVar, cwVar);
        this.j6 = new ap(this);
        this.DW = new ak(this);
        this.FH = new aw(this);
        this.Hw = new av(this);
        this.v5 = new an(this);
        this.Zo = new bb(this);
        this.VH = new aj(this);
        this.gn = new ai(this);
        this.u7 = new at(this);
        this.tp = new ar(this);
        this.EQ = new aq(this);
        this.we = new au(this);
        this.J0 = new ao(this);
        this.J8 = new am(this);
        this.Ws = new ay(this);
        this.XL = new ax(this);
        this.QX = new al(this);
        this.aM = new az(this);
        this.j3 = new as(this);
    }

    public void j6(boolean z) {
        super.j6(z);
        if (z) {
            this.DW.j6();
        }
    }

    public void DW(boolean z) {
        this.ei.j6();
        super.DW(z);
        if (!this.P8.DW()) {
            this.J8.j6();
        }
    }

    public void FH(boolean z) {
        super.FH(z);
        if (!this.P8.DW()) {
            this.DW.DW();
            if (!this.P8.DW()) {
                this.j6.j6();
            }
        }
    }

    public void j6(ee eeVar) {
        super.j6(eeVar);
        this.j6.j6(eeVar);
        this.DW.j6(eeVar);
        if (!"END".equals(eeVar.readUTF())) {
            throw new IOException("END not found");
        }
    }

    public void j6(ef efVar) {
        super.j6(efVar);
        this.j6.j6(efVar);
        this.DW.j6(efVar);
        efVar.writeUTF("END");
    }

    public void j6() {
        super.j6();
        this.DW.FH();
    }

    public void j6(bu$c bu_c) {
        switch (bu_c.j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.we, bu_c.J0, bu_c.aM);
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                this.j3.DW(bu_c.Hw, bu_c.tp, bu_c.EQ);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                this.J0.j6(bu_c.Hw, (bp) bu_c.FH);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                bu_c.j3.v5().j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.v5, (co) bu_c.FH);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                bu_c.j3.v5().j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.Zo, bu_c.v5, (co) bu_c.FH);
            case 5:
                bu_c.j3.v5().j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.Zo, bu_c.v5, (co) bu_c.FH, bu_c.VH, bu_c.gn, bu_c.u7);
            case 7:
                j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.we, bu_c.J0, bu_c.J8, bu_c.Ws, bu_c.QX, bu_c.XL);
            case 8:
                this.j3.v5(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.tp, bu_c.EQ);
            case 9:
                bu_c.j3.v5().VH(bu_c.Hw, bu_c.tp, bu_c.EQ);
            case 10:
                this.we.j6(bu_c.Hw, bu_c.tp, bu_c.EQ, bu_c.v5, (co) bu_c.FH);
            case 11:
                this.J0.j6(bu_c.Hw, new Hashtable());
            default:
        }
    }

    private void j6(bv bvVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.rN.DW();
        this.rN.j6(bvVar, i, i2, i3, i4, "");
        this.rN.j6(bvVar, i5, i6, i7, i8, "");
        this.rN.gn();
    }

    private void j6(bv bvVar, int i, int i2, int i3, int i4, String str) {
        int i5 = 0;
        this.rN.DW();
        int i6 = 0;
        while (i5 < str.length()) {
            int i7;
            if (str.charAt(i5) == '\n') {
                i7 = i6 + 1;
            } else {
                i7 = i6;
            }
            i5++;
            i6 = i7;
        }
        if (i6 > 0) {
            this.rN.j6(bvVar, i, i2, i3, i4, str);
            this.rN.DW(bvVar, i, i + i6);
        } else {
            this.rN.j6(bvVar, i, i2, i3, i4, str);
        }
        this.rN.gn();
    }
}
