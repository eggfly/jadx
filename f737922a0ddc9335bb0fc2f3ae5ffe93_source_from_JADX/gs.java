import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class gs implements bh {
    private final gv DW;
    private final gk FH;
    private gq Hw;
    private gx VH;
    private gy Zo;
    private gl gn;
    private final cc j6;
    private gr v5;

    public gs(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new gv(ccVar);
        this.FH = new gk(ccVar, false);
        if (ccVar != null) {
            this.Hw = new gq(ccVar, this.DW);
            this.v5 = new gr(ccVar, this.DW, this);
            this.Zo = new gy(ccVar.ro, ccVar.sG, false, this.DW, this.FH);
            this.VH = new gx(ccVar.ro, ccVar.sG, ccVar.cb, (ha) this.DW.Hw(), false);
            this.gn = new gl(ccVar);
        }
    }

    public String j6() {
        return "Java";
    }

    public String[] Hw() {
        return new String[]{"*.java"};
    }

    public String[] v5() {
        return new String[0];
    }

    public void DW() {
        this.Hw.j6();
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
        this.Zo.j6(bvVar, reader, false, false, false, false, (cm) map.get(this.DW), (cm) map.get(this.FH));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        boolean z2 = true;
        cm DW = this.j6.ef.DW();
        cm DW2 = this.j6.ef.DW();
        gy gyVar = this.Zo;
        boolean z3 = z && map.containsKey(this.DW);
        if (!(z && map.containsKey(this.FH))) {
            z2 = false;
        }
        gyVar.j6(bvVar, reader, z3, z2, map.containsKey(this.DW), map.containsKey(this.FH), DW, DW2);
        if (map.containsKey(this.DW)) {
            this.VH.j6(DW, bvVar, z, (cj) map.get(this.DW));
        }
        this.j6.ef.j6(DW);
        if (map.containsKey(this.FH)) {
            this.gn.j6(DW2, bvVar, z, (cj) map.get(this.FH));
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
        return this.v5;
    }

    public bf u7() {
        return this.Hw;
    }

    public boolean FH() {
        return false;
    }

    public bi EQ() {
        return null;
    }
}
