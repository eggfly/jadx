import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class hp implements bh {
    private final hq DW;
    private final hl FH;
    private hs Hw;
    private hm Zo;
    private final cc j6;
    private hr v5;

    public hp(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new hq(ccVar);
        this.FH = new hl(ccVar);
        if (ccVar != null) {
            this.Hw = new hs(ccVar.ro, ccVar.sG, this.DW, this.FH);
            this.v5 = new hr(ccVar.ro, ccVar.sG, ccVar.cb, (hu) this.DW.Hw());
            this.Zo = new hm(ccVar);
        }
    }

    public String j6() {
        return "JavaScript";
    }

    public String[] Hw() {
        return new String[]{"*.js"};
    }

    public String[] v5() {
        return new String[]{"*.min.js"};
    }

    public void DW() {
    }

    public List<bj> Zo() {
        List<bj> arrayList = new ArrayList();
        arrayList.add(this.DW);
        arrayList.add(this.FH);
        return arrayList;
    }

    public void j6(bv bvVar, bj bjVar) {
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cm> map) {
        this.Hw.j6(bvVar, reader, false, false, false, false, (cm) map.get(this.DW), (cm) map.get(this.FH));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        boolean z2 = true;
        cm DW = this.j6.ef.DW();
        cm DW2 = this.j6.ef.DW();
        hs hsVar = this.Hw;
        boolean z3 = z && map.containsKey(this.DW);
        if (!(z && map.containsKey(this.FH))) {
            z2 = false;
        }
        hsVar.j6(bvVar, reader, z3, z2, map.containsKey(this.DW), map.containsKey(this.FH), DW, DW2);
        if (map.containsKey(this.DW)) {
            this.v5.j6(DW, bvVar, z, (cj) map.get(this.DW));
        }
        this.j6.ef.j6(DW);
        if (map.containsKey(this.FH)) {
            this.Zo.j6(DW2, bvVar, z, (cj) map.get(this.FH));
        }
        this.j6.ef.j6(DW2);
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
        return null;
    }
}
