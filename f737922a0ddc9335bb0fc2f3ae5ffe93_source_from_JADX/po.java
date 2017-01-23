import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.aide.analytics.a;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.engine.EngineSolution;
import com.aide.engine.service.l;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class po {
    private og DW;
    private Map<String, List<String>> FH;
    private List<String> Hw;
    private String j6;
    private boolean v5;

    public void j6(String str) {
        SharedPreferences sharedPreferences = e.gn().getSharedPreferences("ProjectService", 0);
        if (!e.VH()) {
            if (str != null) {
                a.DW("App init: From intent");
                SI(j3(str));
            } else {
                this.j6 = sharedPreferences.getString("CurrentAppHome", null);
                if (this.j6 != null && nw(this.j6) == null) {
                    this.j6 = null;
                }
            }
        }
        this.DW = nw(this.j6);
        vy();
        if (this.DW != null) {
            e.Sf().j6(this.DW.u7(), true);
        }
        if (this.j6 != null) {
            a.DW("App init: Opened existing project");
            P8();
            j6(null, false);
            QX("init");
        }
    }

    private void vy() {
        this.Hw = new ArrayList();
        this.FH = new HashMap();
        if (this.j6 != null) {
            this.DW.j6(this.j6, this.FH, this.Hw);
        }
    }

    public String j6() {
        if (this.j6 == null) {
            return "";
        }
        return e.gn().getSharedPreferences("ProjectService", 0).getString("BuildVariant_" + this.j6, "debug");
    }

    public List<String> DW() {
        if (this.j6 == null) {
            return null;
        }
        return this.DW.j6(u7());
    }

    public List<String> FH() {
        if (this.j6 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("release");
        arrayList.add("debug");
        arrayList.add("debug-aide");
        List<String> j6 = this.DW.j6(u7());
        if (j6 != null) {
            for (String str : j6) {
                arrayList.add(str + " " + "release");
                arrayList.add(str + " " + "debug");
                arrayList.add(str + " " + "debug-aide");
            }
        }
        return arrayList;
    }

    public String Hw() {
        return P8(j6());
    }

    private static String P8(String str) {
        String[] split = str.split(" ");
        if (split.length >= 1) {
            return split[split.length - 1];
        }
        return null;
    }

    public String v5() {
        String[] split = j6().split(" ");
        if (split.length == 2) {
            return split[0];
        }
        return null;
    }

    public void DW(String str) {
        String v5 = v5();
        if (v5 != null) {
            str = v5 + " " + str;
        }
        FH(str);
    }

    public void Zo() {
        m.j6(e.u7(), e.j6((int) R.f.dialog_variants_title, new Object[0]), FH(), j6(), new po$1(this));
    }

    public void FH(String str) {
        if (this.j6 != null && !str.equals(j6())) {
            if (e.U2().DW()) {
                Toast.makeText(e.u7(), e.j6((int) R.f.view_toast_cannot_switch_variant, new Object[0]), 0).show();
                return;
            }
            Toast.makeText(e.u7(), e.j6((int) R.f.view_toast_switched_variant, str), 0).show();
            ei(str);
            e.Sf().j6(this.DW.u7());
            e.U2().gn();
            aM();
        }
    }

    private void ei(String str) {
        if (this.j6 != null) {
            e.gn().getSharedPreferences("ProjectService", 0).edit().putString("BuildVariant_" + this.j6, str).commit();
        }
    }

    public void Hw(String str) {
        if (!v5(str)) {
            String j3 = j3(str);
            if (j3 != null) {
                m.DW(e.u7(), e.j6((int) R.f.dialog_open_project_title, new Object[0]), e.j6((int) R.f.dialog_open_project_message, j3), new po$2(this, j3, str), null);
            }
        }
    }

    public boolean v5(String str) {
        return this.DW != null && this.DW.Zo(str);
    }

    public String VH() {
        String aM = h.aM();
        return qh.VH(aM) ? aM : e.Ws().VH();
    }

    public boolean Zo(String str) {
        return this.DW != null && this.DW.VH(str);
    }

    public boolean VH(String str) {
        return this.DW != null && this.DW.gn(str);
    }

    public void gn(String str) {
        this.DW.u7(str);
        aM();
    }

    public boolean gn() {
        if (this.DW != null) {
            return this.DW.VH();
        }
        return false;
    }

    public void u7(String str) {
        this.DW.tp(str);
        aM();
    }

    public void tp(String str) {
        if (qh.VH(str)) {
            h.DW(str);
            ei();
        }
    }

    public String u7() {
        return this.j6;
    }

    public List<String> tp() {
        return this.Hw;
    }

    public Map<String, List<String>> EQ(String str) {
        return of.DW(str, this.FH);
    }

    public Map<String, List<String>> EQ() {
        return this.FH;
    }

    public List<String> we() {
        List arrayList = new ArrayList();
        arrayList.add(u7());
        Collection hashSet = new HashSet(this.FH.keySet());
        hashSet.remove(u7());
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public boolean we(String str) {
        return nw(str) != null;
    }

    public int J0(String str) {
        return nw(str).v5(str);
    }

    private og nw(String str) {
        if (str == null) {
            return null;
        }
        for (og ogVar : e.j6()) {
            if (ogVar.DW(str)) {
                return ogVar;
            }
        }
        return null;
    }

    public boolean J0() {
        return this.j6 != null;
    }

    public boolean J8(String str) {
        return j3(str) != null;
    }

    private void SI(String str) {
        this.j6 = str;
        Editor edit = e.gn().getSharedPreferences("ProjectService", 0).edit();
        edit.putString("CurrentAppHome", str);
        edit.commit();
    }

    public void J8() {
        if (this.j6 != null) {
            SI(null);
            P8();
            e.aM().DW();
            e.rN().Zo();
            e.j3().v5();
            this.DW = null;
            this.FH = new HashMap();
            e.Sf().j6();
            e.u7().u7();
            ei();
        }
    }

    private void P8() {
    }

    public void Ws(String str) {
        og nw = nw(str);
        if (nw != null) {
            String Hw = nw.Hw(str);
            if (Hw != null) {
                e.Mr().v5(e.u7(), Hw, "open_project");
                return;
            }
            XL(str);
            QX("openProjectUser");
        }
    }

    public void QX(String str) {
        Map hashMap = new HashMap();
        hashMap.put("isPremium", Boolean.toString(QX()));
        hashMap.put("libraryCount", Integer.toString(this.FH.size()));
        hashMap.put("referrer", str);
        if (ok.P8(u7())) {
            hashMap.put("package", ok.DW(u7(), null));
        }
        a.j6("Project opened", hashMap);
    }

    public void XL(String str) {
        j6(str, true);
    }

    public void j6(String str, boolean z) {
        if (aM(str) && str != null && !str.equals(u7())) {
            SI(str);
            P8();
            e.aM().DW();
            e.rN().Zo();
            e.j3().v5();
            e.U2().VH();
            e.dx().DW();
            this.DW = nw(str);
            e.j6(e.u7(), "Opening project...", new po$3(this), new po$4(this, z));
        }
    }

    public void Ws() {
        this.DW.Hw();
    }

    public boolean QX() {
        return J0() && !e.VH() && this.DW.FH();
    }

    public String XL() {
        if (this.DW != null) {
            return this.DW.v5();
        }
        return "";
    }

    public boolean aM(String str) {
        og nw = nw(str);
        if (nw != null) {
            return nw.FH(str);
        }
        return false;
    }

    private void ei() {
        if (this.j6 != null) {
            e.XL().j6(this.DW.Zo());
        } else {
            e.XL().j6(new EngineSolution(new ArrayList(), null, l.j6(e.DW()), e.DW()));
        }
        e.XL().u7();
        e.XL().VH();
    }

    public String j3(String str) {
        if (!qh.gn(str)) {
            while (!qh.Hw(str)) {
                if (nw(str) != null) {
                    return str;
                }
                str = qh.v5(str);
            }
        }
        return null;
    }

    public String[] Mr(String str) {
        List list = (List) this.FH.get(str);
        if (list == null) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return strArr;
    }

    public void aM() {
        if (this.j6 != null && nw(this.j6) == null) {
            J8();
        }
        e.Sf().FH();
        if (this.j6 != null) {
            e.j6(e.u7(), "Reloading project...", new po$5(this), new po$6(this));
            return;
        }
        vy();
        ei();
    }

    public void j3() {
        if (this.j6 != null && nw(this.j6) == null) {
            J8();
        }
        if (this.j6 != null) {
            vy();
        }
        ei();
    }

    public void j6(List<String> list, boolean z) {
        if (this.DW != null) {
            this.DW.j6((List) list, z);
        }
    }

    public void Mr() {
        ei();
    }

    public void j6(String str, y<String> yVar) {
        this.DW.j6(str, (y) yVar);
    }

    public boolean U2(String str) {
        return J0() && this.DW.EQ(str);
    }

    public int a8(String str) {
        return this.DW.we(str);
    }

    public int lg(String str) {
        return this.DW.J0(str);
    }

    public void j6(boolean z) {
        if (z) {
            j3();
        }
        if (a8()) {
            this.v5 = true;
            this.DW.j6(z);
        } else if (z) {
            e.XL().Zo();
        }
    }

    public boolean U2() {
        return J0() && !e.U2().DW();
    }

    public boolean a8() {
        return U2() && this.DW != null && this.DW.gn();
    }

    public boolean lg() {
        return U2() && this.DW != null && this.DW.EQ();
    }

    public boolean rN() {
        String Hw = e.j3().Hw();
        if (Hw == null) {
            return false;
        }
        String j3 = j3(Hw);
        if (j3 == null) {
            return false;
        }
        if (!e.VH() || e.QX().FH(Hw)) {
            return nw(j3).QX(Hw);
        }
        return false;
    }

    public boolean er() {
        String Hw = e.j3().Hw();
        if (Hw == null) {
            return false;
        }
        String j3 = j3(Hw);
        if (j3 == null) {
            return false;
        }
        e.j3().j6(true, false);
        e.u7().sh().QX();
        nw(j3).XL(Hw);
        return true;
    }

    public boolean yS() {
        if (this.DW == null) {
            return false;
        }
        return this.DW.tp();
    }

    public List<String> rN(String str) {
        return this.DW.aM(str);
    }

    public void j6(String str, String str2) {
        this.DW.j6(str, str2);
    }

    public void gW() {
        this.DW.we();
    }

    public void BT() {
        if (e.VH()) {
            e.EQ().DW();
        } else if (this.DW != null && this.v5) {
            this.v5 = false;
            this.DW.J0();
        }
    }

    public String er(String str) {
        return this.DW == null ? null : this.DW.J8(str);
    }

    public String yS(String str) {
        return this.DW == null ? null : this.DW.Ws(str);
    }

    public boolean gW(String str) {
        return this.DW != null && this.DW.j3(str);
    }

    public static String BT(String str) {
        if (str == null) {
            return null;
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1886964253:
                if (str.equals("debug-aide")) {
                    obj = 2;
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    obj = 1;
                    break;
                }
                break;
            case 1090594823:
                if (str.equals("release")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return "release";
            default:
                return "debug";
        }
    }
}
