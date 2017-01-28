import com.aide.uidesigner.ProxyTextView;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ao {
    private ck DW;
    private final ba j6;

    public ao(ba baVar) {
        this.DW = new ck();
        this.j6 = baVar;
    }

    public void j6(bv bvVar, co coVar) {
        this.j6.rN.DW();
        Iterator it = this.j6.sh.j6(bvVar).iterator();
        if (it.hasNext()) {
            cj cjVar = (cj) it.next();
            cjVar.tp().u7().j6(cjVar);
            ea eaVar = new ea(this.j6.cb);
            eaVar.j6((bs) coVar);
            String j6 = cjVar.tp().v5().j6(cjVar, 1, 1, eaVar);
            if (j6.length() > 0) {
                int j3 = cjVar.j3();
                int aM = cjVar.aM();
                this.j6.rN.j6(bvVar, j3, aM, j3, aM, j6);
                this.j6.rN.DW(bvVar, j3 + 1, j3 + 1);
            }
            this.j6.rN.Ws();
            this.j6.sh.j6(cjVar);
        }
    }

    public void j6(bv bvVar, Hashtable<String, String> hashtable) {
        this.j6.rN.DW();
        Iterator it = this.j6.sh.j6(bvVar).iterator();
        if (it.hasNext()) {
            cj cjVar = (cj) it.next();
            cjVar.tp().u7().DW(cjVar);
            this.DW.j6();
            dq dqVar = new dq(this.j6.cb);
            ea eaVar = new ea(this.j6.cb);
            dt dtVar = new dt();
            j6(cjVar, cjVar.Ws(), dqVar, eaVar, dtVar);
            Hashtable hashtable2 = new Hashtable();
            dtVar.j6.j6();
            while (dtVar.j6.DW()) {
                bs j6 = j6(cjVar, dtVar.j6.FH(), dtVar.j6.Hw(), (Hashtable) hashtable, hashtable2);
                if (j6 != null) {
                    dqVar.j6(j6, j6.lg());
                }
            }
            if (hashtable2.isEmpty()) {
                do XL = cjVar.XL();
                for (int i = 0; i < XL.Hw(); i++) {
                    this.DW.j6(cjVar, XL.FH(i));
                }
                int U2 = cjVar.U2();
                int Mr = cjVar.Mr();
                String j62 = cjVar.tp().v5().j6(cjVar, dqVar, eaVar);
                String j63 = cjVar.tp().v5().j6(cjVar, dqVar);
                if (j63.length() > 0) {
                    if (j62.length() > 0) {
                        j62 = j62 + "\n\n";
                    }
                    j62 = j62 + j63;
                }
                if (j62.length() > 0) {
                    String str;
                    if (XL.Hw() == 0) {
                        str = j62 + "\n\n";
                    } else {
                        str = j62;
                    }
                    this.DW.j6(U2, Mr, U2, Mr, str);
                    this.j6.rN.j6(bvVar, U2, Mr, U2, Mr, str);
                    j62 = str;
                }
                for (int Hw = XL.Hw() - 1; Hw >= 0; Hw -= 2) {
                    int FH = XL.FH(Hw - 1);
                    int FH2 = XL.FH(Hw);
                    this.j6.rN.j6(bvVar, this.DW.DW(cjVar, FH), this.DW.FH(cjVar, FH), this.DW.Hw(cjVar, FH2), this.DW.v5(cjVar, FH2), "");
                }
                if (j62.length() > 0) {
                    this.j6.rN.DW(bvVar, U2, j6(j62) + U2);
                }
                this.j6.rN.Ws();
                this.j6.sh.j6(cjVar);
                return;
            }
            this.j6.sh.j6(cjVar);
            this.j6.rN.j6(bvVar.er(), hashtable2);
        }
    }

    private void j6(cj cjVar, int i, dq<bp, bs> dqVar, ea<ce> eaVar, dt dtVar) {
        if (cjVar.sy(i)) {
            bs bsVar;
            switch (cjVar.J8(i)) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    if (cjVar.kQ(i)) {
                        String j6 = this.j6.ro.j6(cjVar.gW(i));
                        if (j6.length() > 1 || "R".equals(j6)) {
                            dtVar.DW(cjVar.gW(i), cjVar.jJ(i));
                            break;
                        }
                    }
                    break;
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    bsVar = (bp) cjVar.QX(i);
                    dqVar.j6(bsVar, bsVar.lg());
                    break;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    bz bzVar = (bz) cjVar.QX(i);
                    if (bzVar.cn()) {
                        eaVar.j6(bzVar.Xa().rN());
                        break;
                    }
                    break;
                case 24:
                case 25:
                    bsVar = ((bz) cjVar.QX(i)).Xa();
                    dqVar.j6(bsVar, bsVar.lg());
                    break;
            }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), (dq) dqVar, (ea) eaVar, dtVar);
        }
    }

    private bp j6(cj cjVar, int i, int i2, Hashtable<String, String> hashtable, Hashtable<String, String[]> hashtable2) {
        Object obj;
        bs Hw;
        dq j6 = this.j6.cb.j6(i, i2, cjVar.we(), cjVar.tp());
        if (j6.FH() > 1) {
            ea eaVar = new ea(this.j6.cb);
            j6.j6.j6();
            while (j6.j6.DW()) {
                eaVar.j6(j6.j6.Hw());
            }
            if (eaVar.Hw() > 1) {
                String j62 = this.j6.ro.j6(i);
                if (hashtable.containsKey(j62)) {
                    obj = (String) hashtable.get(j62);
                    if (j6.FH() > 0) {
                        return null;
                    }
                    j6.j6.j6();
                    while (j6.j6.DW()) {
                        bp bpVar = (bp) j6.j6.FH();
                        Hw = j6.j6.Hw();
                        if (obj != null) {
                            if (Hw.iW().equals(obj)) {
                            }
                        }
                        return bpVar;
                    }
                    return null;
                }
                Vector vector = new Vector();
                eaVar.j6.j6();
                while (eaVar.j6.DW()) {
                    vector.addElement(eaVar.j6.FH().iW());
                }
                Object obj2 = new String[vector.size()];
                vector.copyInto(obj2);
                hashtable2.put(j62, obj2);
                return null;
            }
        }
        obj = null;
        if (j6.FH() > 0) {
            return null;
        }
        j6.j6.j6();
        while (j6.j6.DW()) {
            bp bpVar2 = (bp) j6.j6.FH();
            Hw = j6.j6.Hw();
            if (obj != null) {
                if (Hw.iW().equals(obj)) {
                }
            }
            return bpVar2;
        }
        return null;
    }

    private int j6(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '\n') {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
