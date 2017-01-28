import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ey implements bh {
    private final ez DW;
    private final gk FH;
    private fa Hw;
    private gl VH;
    private gx Zo;
    private gq gn;
    private final cc j6;
    private gr u7;
    private gy v5;

    public ey(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new ez(ccVar);
        this.FH = new gk(ccVar, false);
        this.Hw = new fa();
        if (ccVar != null) {
            this.gn = new gq(ccVar, this.DW);
            this.u7 = new gr(ccVar, this.DW, this);
            this.v5 = new gy(ccVar.ro, ccVar.sG, false, this.DW, this.FH);
            this.Zo = new gx(ccVar.ro, ccVar.sG, ccVar.cb, (ha) this.DW.Hw(), true);
            this.VH = new gl(ccVar);
        }
    }

    public String j6() {
        return "Java Binary";
    }

    public String[] Hw() {
        return new String[]{"*.jar", "*.war", "*.ear", "*.zip", "*.class"};
    }

    public String[] v5() {
        return new String[0];
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
        this.v5.j6(bvVar, reader, false, false, false, false, (cm) map.get(this.DW), (cm) map.get(this.FH));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        cm DW = this.j6.ef.DW();
        cm DW2 = this.j6.ef.DW();
        this.v5.j6(bvVar, reader, false, false, map.containsKey(this.DW), map.containsKey(this.FH), DW, DW2);
        if (map.containsKey(this.DW)) {
            this.Zo.j6(DW, bvVar, z, (cj) map.get(this.DW));
        }
        this.j6.ef.j6(DW);
        if (map.containsKey(this.FH)) {
            this.VH.j6(DW2, bvVar, z, (cj) map.get(this.FH));
        }
        this.j6.ef.j6(DW2);
    }

    public boolean VH() {
        return true;
    }

    public long j6(String str) {
        return this.Hw.j6(str);
    }

    public String[] DW(String str) {
        return this.Hw.DW(str);
    }

    public Reader j6(String str, String str2, String str3) {
        return this.Hw.j6(str, str2, str3);
    }

    public void gn() {
        this.Hw.j6();
    }

    public bg tp() {
        return this.u7;
    }

    public bf u7() {
        return this.gn;
    }

    public void DW() {
        this.Hw.DW();
    }

    public boolean FH() {
        return false;
    }

    public bi EQ() {
        return null;
    }
}
