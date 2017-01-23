import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class fj implements bh {
    private final fl DW;
    private eu FH;
    private fn Hw;
    private final cc j6;

    public fj(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new fl(ccVar);
        if (ccVar != null) {
            this.FH = new eu(ccVar.ro, ccVar.sG, this.DW, new fm((Reader) null));
            this.Hw = new fn(ccVar.ro, ccVar.sG, ccVar.cb, this.DW.tp());
        }
    }

    public String j6() {
        return "Css";
    }

    public String[] Hw() {
        return new String[]{"*.css"};
    }

    public String[] v5() {
        return new String[0];
    }

    public void DW() {
    }

    public List<bj> Zo() {
        List<bj> arrayList = new ArrayList();
        arrayList.add(this.DW);
        return arrayList;
    }

    public void j6(bv bvVar, bj bjVar) {
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cm> map) {
        this.FH.j6(bvVar, reader, false, false, (cm) map.get(this.DW));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        cj cjVar = (cj) map.get(this.DW);
        if (cjVar != null) {
            cm DW = this.j6.ef.DW();
            this.FH.j6(bvVar, reader, false, true, DW, false, 1000);
            this.Hw.j6(DW, bvVar, z, cjVar);
            if (z) {
                this.DW.EQ().j6(bvVar, DW);
            }
            this.j6.ef.j6(DW);
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
        return null;
    }
}
