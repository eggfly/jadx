import android.app.Activity;
import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.htmluidesigner.PhonegapDesignActivity;
import com.aide.ui.trainer.c.b;
import com.aide.uidesigner.XmlLayoutDesignActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ou implements og {
    public pn$a[] j6() {
        return null;
    }

    public List<b> DW() {
        return null;
    }

    public int v5(String str) {
        return R.f.command_files_open_phonegap_project;
    }

    public boolean Zo(String str) {
        for (String FH : e.a8().EQ().keySet()) {
            if (qh.FH(FH, str)) {
                return true;
            }
        }
        return false;
    }

    public boolean DW(String str) {
        return Mr(str);
    }

    private static boolean Mr(String str) {
        return qh.VH(new StringBuilder().append(str).append("/www").toString()) && qh.VH(str + "/.cordova");
    }

    public String Hw(String str) {
        if (FH(str)) {
            return null;
        }
        return "com.aide.phonegap";
    }

    public boolean FH(String str) {
        return e.Hw() || e.j6.equals("com.aide.phonegap");
    }

    public EngineSolution Zo() {
        return ot.j6(e.a8().u7(), e.Ws().Hw());
    }

    public void j6(String str, Map<String, List<String>> map, List<String> list) {
        map.put(str, new ArrayList());
        list.add(str);
    }

    public void j6(List<String> list, boolean z) {
    }

    public boolean VH(String str) {
        return false;
    }

    public boolean gn(String str) {
        return false;
    }

    public void u7(String str) {
    }

    public void tp(String str) {
    }

    public void Hw() {
    }

    public boolean FH() {
        return false;
    }

    public String v5() {
        return "<b>Phonegap 3 Project Home:</b><br/><br/>" + e.a8().u7();
    }

    public boolean EQ(String str) {
        return false;
    }

    public void j6(String str, y<String> yVar) {
    }

    public int we(String str) {
        return -1;
    }

    public int J0(String str) {
        return 0;
    }

    public boolean VH() {
        return false;
    }

    public boolean gn() {
        return false;
    }

    public void j6(boolean z) {
    }

    public boolean QX(String str) {
        if ((e.Hw() || e.j6.equals("com.aide.phonegap")) && str.toLowerCase().endsWith(".html")) {
            if (qh.gn(str, "www") != null) {
                return true;
            }
            return false;
        } else if ((!e.Hw() && !e.j6.equals("com.aide.ui")) || !str.toLowerCase().endsWith(".xml")) {
            return false;
        } else {
            if (!qh.Zo(qh.v5(str)).startsWith("layout") || qh.gn(str, "res") == null) {
                return false;
            }
            return true;
        }
    }

    public void XL(String str) {
        if ((e.Hw() || e.j6.equals("com.aide.phonegap")) && str.toLowerCase().endsWith(".html")) {
            PhonegapDesignActivity.j6(e.u7(), qh.gn(str, "www"), str);
        } else if ((e.Hw() || e.j6.equals("com.aide.ui")) && str.toLowerCase().endsWith(".xml")) {
            boolean z;
            Activity u7 = e.u7();
            String vJ = e.vJ();
            if (e.Mr().j3()) {
                z = false;
            } else {
                z = true;
            }
            XmlLayoutDesignActivity.j6(u7, vJ, str, z, false);
        }
    }

    public boolean tp() {
        return false;
    }

    public List<String> aM(String str) {
        return null;
    }

    public void j6(String str, String str2) {
    }

    public boolean EQ() {
        return false;
    }

    public void we() {
    }

    public void J0() {
    }

    public boolean j3(String str) {
        return false;
    }

    public String u7() {
        return null;
    }

    public String J8(String str) {
        return null;
    }

    public String Ws(String str) {
        return null;
    }

    public List<String> j6(String str) {
        return null;
    }
}
