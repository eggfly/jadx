import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.ui.R;
import com.aide.ui.build.c;
import com.aide.ui.e;
import com.aide.ui.htmluidesigner.WebDesignActivity;
import com.aide.ui.trainer.c.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ox implements og {
    public pn$a[] j6() {
        String str = "Website";
        String str2 = "Html/Css/JavaScript";
        String str3 = "MyWebsite";
        String str4 = "com.aide.web";
        String str5 = "WEBSITE";
        String str6 = "course_web";
        boolean z = e.Hw() || e.j6.equals("com.aide.web");
        pn$b pn_b = new pn$b(this, 6, str, str2, str3, false, false, str4, str5, str6, z);
        r8 = new pn$a[2];
        r8[0] = new pn$a("Website", pn_b, R.drawable.ic_launcher_web, "Website.zip", new String[]{"index.html", "styles.css"}, null);
        r8[1] = new pn$a("Bootstrap Website", pn_b, R.drawable.ic_launcher_web, "WebsiteBootstrap.zip", new String[]{"index.html", "styles.css"}, null);
        return r8;
    }

    public List<b> DW() {
        b[] bVarArr = new b[1];
        bVarArr[0] = new b("course_web", 20, new String[]{"com.aide.web"});
        return Arrays.asList(bVarArr);
    }

    public int v5(String str) {
        return R.f.command_files_open_website_project;
    }

    public boolean DW(String str) {
        return ov.j6(str);
    }

    public String Hw(String str) {
        if (FH(str)) {
            return null;
        }
        return "com.aide.web";
    }

    public boolean FH(String str) {
        return e.Hw() || e.j6.equals("com.aide.web");
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
        return ow.j6(e.a8().u7(), e.Ws().Hw());
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
        e.Mr().j6(e.tp(), (int) R.f.shop_feature_premium_projects, "large_project", false, false);
    }

    public boolean FH() {
        if (e.Hw() || e.Mr().XL() || e.Mr().FH()) {
            return false;
        }
        return J8();
    }

    private boolean J8() {
        if (qh.j6(e.a8().u7(), Ws(), ".html", ".htm", ".css", ".js") >= Ws()) {
            return true;
        }
        return false;
    }

    private int Ws() {
        return 3;
    }

    public String v5() {
        return "<b>Website Home:</b><br/><br/>" + e.a8().u7();
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
        return true;
    }

    public void j6(boolean z) {
        if (e.j3().DW(false, false)) {
            e.sG().j6(c.Hw);
            c.Hw.gn();
            return;
        }
        e.Mr().j6(e.tp(), (int) R.f.shop_feature_premium_projects, "large_project", false, false);
    }

    public boolean QX(String str) {
        if ((e.Hw() || e.j6.equals("com.aide.web")) && ov.DW(str) && qh.FH(e.a8().u7(), str) && !str.equals(ov.FH(e.a8().u7()))) {
            return true;
        }
        return false;
    }

    public void XL(String str) {
        if ((!e.Hw() && !e.j6.equals("com.aide.web")) || !ov.DW(str)) {
            return;
        }
        if (e.j3().DW(false, false)) {
            WebDesignActivity.j6(e.u7(), e.a8().u7(), str, 0);
        } else {
            e.Mr().j6(e.tp(), (int) R.f.shop_feature_premium_projects, "large_project", false, false);
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
        e.u7().j6(e.j6((int) R.f.dialog_community_rate_title, new Object[0]), e.j6((int) R.f.dialog_community_rate_website_message, new Object[0]), null);
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
