import com.aide.analytics.c;
import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.trainer.c.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class oo implements og {
    public pn$a[] j6() {
        boolean z;
        String str = "Java Application";
        String str2 = "Java";
        String str3 = "MyJavaConsoleApp";
        String str4 = "com.aide.ui";
        String str5 = "JAVA";
        String str6 = "course_java";
        if (e.Hw() || e.j6.equals("com.aide.ui")) {
            z = true;
        } else {
            z = false;
        }
        pn$a[] pn_aArr = new pn$a[1];
        pn$b pn_b = new pn$b(this, 3, str, str2, str3, false, false, str4, str5, str6, z);
        pn_aArr[0] = new pn$a("Java Application", pn_b, R.drawable.ic_launcher_java, "JavaConsole.zip", new String[]{"Main.java"}, null);
        return pn_aArr;
    }

    public List<b> DW() {
        b[] bVarArr = new b[1];
        bVarArr[0] = new b("course_java", 1, new String[]{"com.aide.ui", "com.aide.trainer.java"});
        return Arrays.asList(bVarArr);
    }

    public boolean DW(String str) {
        return qh.VH(Mr(str)) && !qh.VH(str + "/AndroidManifest.xml");
    }

    public static String Mr(String str) {
        return str + "/.classpath";
    }

    public boolean FH(String str) {
        return e.Hw() || e.j6.equals("com.aide.ui") || e.j6.equals("com.aide.trainer.java");
    }

    public String Hw(String str) {
        if (FH(str)) {
            return null;
        }
        return "com.aide.ui";
    }

    public int v5(String str) {
        return R.f.command_files_open_java_project;
    }

    public void j6(String str, Map<String, List<String>> map, List<String> list) {
        map.put(str, new ArrayList());
        list.add(str);
    }

    public void Hw() {
        e.Mr().j6(e.u7(), (int) R.f.shop_feature_premium_projects, "large_project");
    }

    public boolean FH() {
        if (e.Hw() || e.Mr().FH()) {
            return false;
        }
        if (c.j6(e.u7(), "AllowSavingOneJavaFileInNonPremium", 1.0d, 0.0d)) {
            return J8();
        }
        return true;
    }

    private boolean J8() {
        int i = 0;
        for (String j6 : a8(e.a8().u7())) {
            i += qh.j6(j6, Ws(), ".java");
            if (i >= Ws()) {
                return true;
            }
        }
        return false;
    }

    private int Ws() {
        return 2;
    }

    public String v5() {
        String str = ("<b>Java Project:</b><br/><br/>" + e.a8().u7() + "<br/><br/>") + "<i>Library JARs:</i><br/><br/>";
        String[] U2 = U2(e.a8().u7());
        if (U2.length == 0) {
            return str + "&lt;none&gt;<br/><br/>";
        }
        int length = U2.length;
        String str2 = str;
        int i = 0;
        while (i < length) {
            String str3 = U2[i];
            if (!qh.VH(str3)) {
                str2 = str2 + "(NOT FOUND) ";
            }
            i++;
            str2 = str2 + str3 + "<br/><br/>";
        }
        return str2;
    }

    public EngineSolution Zo() {
        return om.j6(e.a8().u7(), e.a8().VH(), null);
    }

    public boolean VH(String str) {
        return str.toLowerCase().endsWith(".jar") && !Arrays.asList(U2(e.a8().u7())).contains(str);
    }

    public boolean gn(String str) {
        return Arrays.asList(U2(e.a8().u7())).contains(str);
    }

    public void u7(String str) {
        String u7 = e.a8().u7();
        List list = ((od) new od().J0(Mr(u7))).j6;
        list.add(new od$a("lib", qh.Zo(u7, str), false));
        od.j6(Mr(u7), list);
    }

    public void tp(String str) {
        String u7 = e.a8().u7();
        List<od$a> list = ((od) new od().J0(Mr(u7))).j6;
        for (od$a od_a : list) {
            if (od_a.v5() && od_a.j6(u7).equals(str)) {
                list.remove(od_a);
                break;
            }
        }
        od.j6(Mr(u7), list);
    }

    public boolean EQ(String str) {
        return on.j6(str);
    }

    public void j6(String str, y<String> yVar) {
        on.j6(str, yVar);
    }

    public int we(String str) {
        return on.DW(str);
    }

    public int J0(String str) {
        return on.FH(str);
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
        com.aide.ui.build.c.DW.j6(z, e.a8().Hw());
    }

    public boolean QX(String str) {
        return false;
    }

    public void XL(String str) {
    }

    public boolean tp() {
        return false;
    }

    public static String j6(Map<String, List<String>> map, String str) {
        for (String str2 : j6((Map) map)) {
            if (qh.FH(str2, str)) {
                return qh.DW(str2, str).replace('/', '.');
            }
        }
        return null;
    }

    public static String[] j6(Map<String, List<String>> map) {
        List arrayList = new ArrayList();
        for (String str : map.keySet()) {
            for (od$a od_a : ((od) new od().J0(Mr(str))).j6) {
                if (od_a.Hw()) {
                    arrayList.add(od_a.j6(str));
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String j6(String str, boolean z) {
        for (od$a od_a : ((od) new od().J0(Mr(str))).j6) {
            if (od_a.Zo()) {
                String j6 = od_a.j6(str);
                if (z) {
                    return j6 + "/debug";
                }
                return j6 + "/release";
            }
        }
        if (z) {
            return str + "/bin/debug";
        }
        return str + "/bin/release";
    }

    public static String[] U2(String str) {
        List arrayList = new ArrayList();
        for (od$a od_a : ((od) new od().J0(Mr(str))).j6) {
            if (od_a.v5()) {
                arrayList.add(od_a.j6(str));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public boolean Zo(String str) {
        for (String FH : e.a8().EQ().keySet()) {
            if (qh.FH(FH, str)) {
                return true;
            }
        }
        for (String FH2 : a8(e.a8().u7())) {
            if (qh.FH(FH2, str)) {
                return true;
            }
        }
        return false;
    }

    public static String[] a8(String str) {
        List arrayList = new ArrayList();
        for (od$a od_a : ((od) new od().J0(Mr(str))).j6) {
            if (od_a.Hw()) {
                arrayList.add(od_a.j6(str));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String DW(String str, String str2) {
        for (String str3 : a8(str)) {
            if (qh.FH(str3, str2)) {
                return qh.DW(str3, str2).replace('/', '.');
            }
        }
        return null;
    }

    public static String DW(String str, boolean z) {
        return j6(str, z) + "/dex";
    }

    public static String FH(String str, boolean z) {
        return j6(str, z) + "/dex/classes.dex.zip";
    }

    public static String Hw(String str, boolean z) {
        return j6(str, z) + "/dex/jars";
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
        return "com.aide.ui";
    }

    public String J8(String str) {
        String[] j6 = j6(e.a8().EQ());
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        for (String str2 : j6) {
            String str22 = str22 + str;
            if (qh.VH(str22)) {
                return str22;
            }
        }
        return null;
    }

    public String Ws(String str) {
        String j6 = j6(e.a8().EQ(), qh.v5(str));
        if (j6 == null) {
            return str;
        }
        return j6.replace('.', '/') + "/" + qh.Zo(str);
    }

    public List<String> j6(String str) {
        return null;
    }
}
