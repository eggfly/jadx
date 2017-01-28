import com.aide.analytics.c;
import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.ui.R;
import com.aide.ui.build.android.m;
import com.aide.ui.e;
import com.aide.ui.trainer.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class os implements og {
    public pn$a[] j6() {
        boolean z;
        String str = "C/C++ Application";
        String str2 = "C/C++";
        String str3 = "MyNativeExecutable";
        String str4 = "com.aide.ui";
        String str5 = "JAVA";
        String str6 = "course_cpp";
        if (e.Hw() || e.j6.equals("com.aide.ui")) {
            z = true;
        } else {
            z = false;
        }
        pn$a[] pn_aArr = new pn$a[1];
        pn$b pn_b = new pn$b(this, 3, str, str2, str3, false, false, str4, str5, str6, z);
        pn_aArr[0] = new pn$a("Console Application", pn_b, R.drawable.ic_launcher, "CppHelloWorld.zip", new String[]{"hello.cpp"}, null);
        return pn_aArr;
    }

    public List<b> DW() {
        return null;
    }

    public boolean DW(String str) {
        return qh.j6("^\\s*include\\s*\\$\\(\\s*BUILD_EXECUTABLE\\s*\\)\\s*$", str + "/jni/Android.mk");
    }

    public boolean FH(String str) {
        return e.Hw() || e.j6.equals("com.aide.ui");
    }

    public String Hw(String str) {
        if (FH(str)) {
            return null;
        }
        return "com.aide.ui";
    }

    public int v5(String str) {
        return R.f.command_files_open_nativeexecutable_project;
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
        if (c.DW(e.u7(), "AllowSavingOneNativeExecutableFileInNonPremium")) {
            return J8();
        }
        return true;
    }

    private boolean J8() {
        int i = 0;
        for (String j6 : oo.a8(e.a8().u7())) {
            i += qh.j6(j6, Ws(), ".c", ".cc", ".cpp");
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
        return "<b>Native Executable Project Home:</b><br/><br/>" + e.a8().u7();
    }

    public EngineSolution Zo() {
        return or.j6(e.a8().u7());
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
        return -1;
    }

    public boolean VH() {
        if (m.Zo()) {
            return false;
        }
        e.KD().j6(e.tp(), "This project contains native code. ");
        return true;
    }

    public void j6(List<String> list, boolean z) {
    }

    public boolean gn() {
        return true;
    }

    public void j6(boolean z) {
        com.aide.ui.build.c.FH.DW(z);
    }

    public boolean QX(String str) {
        return false;
    }

    public void XL(String str) {
    }

    public boolean tp() {
        return false;
    }

    public boolean Zo(String str) {
        for (String FH : e.a8().EQ().keySet()) {
            if (qh.FH(FH, str)) {
                return true;
            }
        }
        return false;
    }

    public List<String> aM(String str) {
        return Collections.emptyList();
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
        return true;
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
