import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ft implements bh {
    private final cc DW;
    private final fu FH;
    private eu Hw;
    private er VH;
    private fx Zo;
    private cj gn;
    private Map<String, String> j6;
    private fw v5;

    public ft(cc ccVar) {
        this.DW = ccVar;
        this.FH = new fu(ccVar);
        if (ccVar != null) {
            this.Hw = new eu(ccVar.ro, ccVar.sG, this.FH, new fv((Reader) null));
            this.v5 = new fw(ccVar.ro, ccVar.sG, ccVar.cb, this.FH.tp());
            this.Zo = new fx(ccVar, this, this.FH, this.Hw);
            this.VH = new er(ccVar);
            this.gn = new cj(ccVar);
            this.j6 = new HashMap();
            J0();
        }
    }

    public String we() {
        return "-//HTML 5";
    }

    private void J0() {
        j6("-//W3C//DTD XHTML 1.0 Strict//EN", "xhtml1-strict.dtd");
        j6("-//W3C//DTD XHTML 1.0 Transitional//EN", "xhtml1-transitional.dtd");
        j6("-//W3C//DTD XHTML 1.0 Frameset//EN", "xhtml1-frameset.dtd");
        j6("-//W3C//ENTITIES Latin 1 for XHTML//EN", "xhtml-lat1.ent");
        j6("-//W3C//ENTITIES Symbols for XHTML//EN", "xhtml-symbol.ent");
        j6("-//W3C//ENTITIES Special for XHTML//EN", "xhtml-special.ent");
        j6("-//W3C//DTD HTML 4.01//EN", "strict.dtd");
        j6("-//W3C//DTD HTML 4.01 Transitional//EN", "loose.dtd");
        j6("-//W3C//DTD HTML 4.01 Frameset//EN", "frameset.dtd");
        j6("-//W3C//ENTITIES Latin1//EN//HTML", "HTMLlat1.ent");
        j6("-//W3C//ENTITIES Symbols//EN//HTML", "HTMLsymbol.ent");
        j6("-//W3C//ENTITIES Special//EN//HTML", "HTMLspecial.ent");
        j6("-//HTML 5", "html5.dtd");
    }

    private void j6(String str, String str2) {
        InputStream j6;
        try {
            j6 = ep.j6().j6("dtds/" + str2);
            if (j6 != null) {
                Reader inputStreamReader = new InputStreamReader(j6, "UTF-8");
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[4096];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        stringWriter.close();
                        this.j6.put(str, stringWriter.toString());
                        j6.close();
                        return;
                    }
                }
            }
        } catch (IOException e) {
        } catch (Throwable th) {
            j6.close();
        }
    }

    public fs FH(String str) {
        boolean z = true;
        if (this.j6.containsKey(str)) {
            try {
                j6(new StringReader((String) this.j6.get(str)));
                if (str.indexOf("HTML") != -1) {
                    z = str.indexOf("XHTML") != -1;
                }
                return new fs(this.DW, this.gn, z);
            } catch (IOException e) {
            }
        }
        return null;
    }

    bv Hw(String str) {
        return null;
    }

    Reader v5(String str) {
        if (this.j6.containsKey(str)) {
            return new StringReader((String) this.j6.get(str));
        }
        return null;
    }

    private void j6(StringReader stringReader) {
        cm DW = this.DW.ef.DW();
        this.Hw.j6(null, stringReader, false, true, DW);
        this.VH.j6();
        this.Zo.j6(null, DW, this.VH, false);
        this.gn.FH();
        this.gn.j6(null, this.FH);
        cm DW2 = this.DW.ef.DW();
        this.Hw.j6(null, this.VH.Hw(), false, true, DW2);
        this.v5.j6(DW2, null, false, this.gn);
        this.DW.ef.j6(DW2);
        this.DW.ef.j6(DW);
    }

    public String j6() {
        return "DTD";
    }

    public String[] Hw() {
        return new String[]{"*.dtd"};
    }

    public String[] v5() {
        return new String[0];
    }

    public void DW() {
    }

    public List<bj> Zo() {
        List<bj> arrayList = new ArrayList();
        arrayList.add(this.FH);
        return arrayList;
    }

    public void j6(bv bvVar, bj bjVar) {
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cm> map) {
        cm DW = this.DW.ef.DW();
        this.VH.j6();
        this.Hw.j6(bvVar, reader, false, true, DW);
        this.Zo.j6(bvVar, DW, this.VH, false);
        this.Hw.j6(bvVar, this.VH.Hw(), false, false, (cm) map.get(this.FH));
    }

    public void j6(bv bvVar, Reader reader, Map<bj, cj> map, boolean z) {
        cm DW = this.DW.ef.DW();
        this.Hw.j6(bvVar, reader, false, true, DW);
        this.VH.j6();
        this.Zo.j6(bvVar, DW, this.VH, z);
        cm DW2 = this.DW.ef.DW();
        bv bvVar2 = bvVar;
        boolean z2 = z;
        this.Hw.j6(bvVar2, this.VH.Hw(), z2, map.containsKey(this.FH), DW2);
        boolean z3 = z;
        this.v5.j6(DW2, bvVar, z3, (cj) map.get(this.FH));
        this.DW.ef.j6(DW2);
        this.DW.ef.j6(DW);
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
