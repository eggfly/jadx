import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class fz implements bh {
    private final ih DW;
    private ij EQ;
    private final hq FH;
    private final hl Hw;
    private hs VH;
    private hz Zo;
    private hr gn;
    private final cc j6;
    private eu tp;
    private hm u7;
    private cj v5;
    private hy we;

    public fz(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new ih(ccVar, false);
        this.FH = new hq(ccVar);
        this.Hw = new hl(ccVar);
        this.we = new hy(ccVar, this.DW);
        if (ccVar != null) {
            et iiVar = new ii((Reader) null);
            iiVar.j6(true);
            this.tp = new eu(ccVar.ro, ccVar.sG, this.DW, iiVar);
            this.EQ = new ij((ic) this.DW.u7(), ccVar.ro, ccVar.sG, ccVar.cb, (ik) this.DW.Hw(), false);
            this.v5 = new cj(ccVar);
            this.Zo = new hz(ccVar);
            this.VH = new hs(ccVar.ro, ccVar.sG, this.FH, this.Hw);
            this.gn = new hr(ccVar.ro, ccVar.sG, ccVar.cb, (hu) this.FH.Hw());
            this.u7 = new hm(ccVar);
        }
    }

    public String j6() {
        return "HTML";
    }

    public String[] Hw() {
        return new String[]{"*.html", "*.htm", "*.xhtml"};
    }

    public String[] v5() {
        return new String[0];
    }

    public void DW() {
    }

    public List<bj> Zo() {
        List<bj> arrayList = new ArrayList();
        arrayList.add(this.FH);
        arrayList.add(this.Hw);
        arrayList.add(this.DW);
        return arrayList;
    }

    public void j6(bv bvVar, bj bjVar) {
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cm> map) {
        this.v5.FH();
        this.v5.j6(bvVar, this.DW);
        this.tp.j6(bvVar, reader, false, true, (cm) map.get(this.DW));
        this.EQ.j6((cm) map.get(this.DW), bvVar, false, this.v5);
        this.Zo.j6(this.v5, (cm) map.get(this.DW), true);
        this.VH.j6(bvVar, this.Zo.j6(), false, false, false, false, (cm) map.get(this.FH), (cm) map.get(this.Hw));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        cj cjVar;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (map.containsKey(this.DW)) {
            cjVar = (cj) map.get(this.DW);
        } else {
            this.v5.FH();
            this.v5.j6(bvVar, this.DW);
            cjVar = this.v5;
        }
        cm DW = this.j6.ef.DW();
        eu euVar = this.tp;
        if (z && map.containsKey(this.DW)) {
            z2 = true;
        } else {
            z2 = false;
        }
        euVar.j6(bvVar, reader, z2, true, DW);
        ij ijVar = this.EQ;
        if (z && map.containsKey(this.DW)) {
            z3 = true;
        } else {
            z3 = false;
        }
        ijVar.j6(DW, bvVar, z3, cjVar);
        this.j6.ef.j6(DW);
        if (map.containsKey(this.Hw) || map.containsKey(this.FH)) {
            this.Zo.j6(cjVar, null, false);
            cm DW2 = this.j6.ef.DW();
            cm DW3 = this.j6.ef.DW();
            hs hsVar = this.VH;
            Reader j6 = this.Zo.j6();
            if (z && map.containsKey(this.FH)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(z && map.containsKey(this.Hw))) {
                z4 = false;
            }
            hsVar.j6(bvVar, j6, z2, z4, map.containsKey(this.FH), map.containsKey(this.Hw), DW2, DW3);
            if (map.containsKey(this.FH)) {
                this.gn.j6(DW2, bvVar, z, (cj) map.get(this.FH));
            }
            this.j6.ef.j6(DW2);
            if (map.containsKey(this.Hw)) {
                this.u7.j6(DW3, bvVar, z, (cj) map.get(this.Hw));
            }
            this.j6.ef.j6(DW3);
        }
    }

    public boolean VH() {
        return false;
    }

    public long j6(String str) {
        return 0;
    }

    public String[] DW(String str) {
        return null;
    }

    public Reader j6(String str, String str2, String str3) {
        return null;
    }

    public void gn() {
    }

    public bg tp() {
        return null;
    }

    public bf u7() {
        return null;
    }

    public boolean FH() {
        return true;
    }

    public bi EQ() {
        return this.we;
    }
}
