import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.ui.R;
import com.aide.ui.build.c;
import com.aide.ui.e;
import com.aide.ui.trainer.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class oq implements og {
    public pn$a[] j6() {
        boolean z;
        String str = "JavaScript Application";
        String str2 = "JavaScript";
        String str3 = "MyJavaScriptApplication";
        String str4 = "com.aide.web";
        String str5 = "JAVASCRIPT";
        String str6 = "course_javascript";
        if (e.Hw() || e.j6.equals("com.aide.web")) {
            z = true;
        } else {
            z = false;
        }
        pn$a[] pn_aArr = new pn$a[1];
        pn$b pn_b = new pn$b(this, 7, str, str2, str3, false, false, str4, str5, str6, z);
        pn_aArr[0] = new pn$a("JavaScript Application", pn_b, R.drawable.ic_launcher_javascript, "HelloJavaScript.zip", new String[]{"main.js"}, null);
        return pn_aArr;
    }

    public List<b> DW() {
        b[] bVarArr = new b[1];
        bVarArr[0] = new b("course_javascript", 10, new String[]{"com.aide.web"});
        return Arrays.asList(bVarArr);
    }

    public boolean DW(String str) {
        return new File(str, "main.js").exists();
    }

    public boolean FH(String str) {
        return e.Hw() || e.j6.equals("com.aide.web");
    }

    public String Hw(String str) {
        if (FH(str)) {
            return null;
        }
        return "com.aide.web";
    }

    public int v5(String str) {
        return R.f.command_files_open_javascript_project;
    }

    public void j6(String str, Map<String, List<String>> map, List<String> list) {
        map.put(str, new ArrayList());
        list.add(str);
    }

    public void Hw() {
        e.Mr().j6(e.tp(), (int) R.f.shop_feature_premium_projects, "large_project", false, false);
    }

    public boolean FH() {
        if (e.Hw() || e.Mr().XL()) {
            return false;
        }
        return J8();
    }

    private boolean J8() {
        if (qh.j6(e.a8().u7(), Ws(), ".js") >= Ws()) {
            return true;
        }
        return false;
    }

    private int Ws() {
        return 2;
    }

    public String v5() {
        return "<b>JavaScript Project Home:</b><br/><br/>" + e.a8().u7() + "<br/><br/>";
    }

    public boolean Zo(String str) {
        for (String FH : e.a8().EQ().keySet()) {
            if (qh.FH(FH, str)) {
                return true;
            }
        }
        return false;
    }

    public EngineSolution Zo() {
        return op.j6(e.a8().u7(), e.Ws().Hw());
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

    public void j6(List<String> list, boolean z) {
    }

    public boolean gn() {
        return true;
    }

    public void j6(boolean z) {
        if (e.j3().DW(false, false)) {
            e.sG().j6(c.v5);
            c.v5.gn();
            return;
        }
        e.Mr().j6(e.tp(), (int) R.f.shop_feature_premium_projects, "large_project", false, false);
    }

    public boolean QX(String str) {
        return false;
    }

    public void XL(String str) {
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
