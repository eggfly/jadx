import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ig implements bh {
    private final ih DW;
    private eu FH;
    private ij Hw;
    private final cc j6;

    public ig(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new ih(ccVar, true);
        if (ccVar != null) {
            this.FH = new eu(ccVar.ro, ccVar.sG, this.DW, new ii((Reader) null));
            this.Hw = new ij((ic) this.DW.u7(), ccVar.ro, ccVar.sG, ccVar.cb, (ik) this.DW.Hw(), true);
        }
    }

    public String j6() {
        return "XML";
    }

    public String[] Hw() {
        return new String[]{"*.xml", "*.xsl", "*.xslt", "*.xsd", "*.*proj", "*.resx", "*.settings", "*.config", "*.tld", "*.svg"};
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
        cm DW = this.j6.ef.DW();
        this.FH.j6(bvVar, reader, z, map.containsKey(this.DW), DW);
        this.Hw.j6(DW, bvVar, z, (cj) map.get(this.DW));
        this.j6.ef.j6(DW);
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
