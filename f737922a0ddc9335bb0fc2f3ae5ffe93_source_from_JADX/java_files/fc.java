import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class fc implements bh {
    private eu DW;
    private final fd j6;

    public fc(cc ccVar) {
        this.j6 = new fd(ccVar);
        if (ccVar != null) {
            this.DW = new eu(ccVar.ro, ccVar.sG, this.j6, new fe((Reader) null));
        }
    }

    public String j6() {
        return "C++";
    }

    public void DW() {
    }

    public boolean FH() {
        return true;
    }

    public String[] Hw() {
        return new String[]{"*.cpp", "*.cc", "*.c", "*.h", "*.hh", "*.hpp", "*.inl", "*.gradle"};
    }

    public String[] v5() {
        return new String[0];
    }

    public List<bj> Zo() {
        List<bj> arrayList = new ArrayList();
        arrayList.add(this.j6);
        return arrayList;
    }

    public void j6(bv bvVar, bj bjVar) {
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cm> map) {
        this.DW.j6(bvVar, reader, false, false, (cm) map.get(this.j6));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        if (map.containsKey(this.j6)) {
            cj cjVar = (cj) map.get(this.j6);
            cjVar.j6(cjVar.j6(0, true, new int[0], 0, 0, 1, 1));
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

    public bf u7() {
        return null;
    }

    public bg tp() {
        return null;
    }

    public bi EQ() {
        return null;
    }
}
