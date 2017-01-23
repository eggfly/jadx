import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.aide.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class pl {
    private Map<String, Long> DW;
    private pl$b FH;
    private String Hw;
    private Map<String, pl$a> j6;
    private List<pl$c> v5;

    public pl() {
        this.j6 = new LinkedHashMap();
        this.DW = new HashMap();
        this.v5 = new ArrayList();
    }

    public void j6() {
    }

    public void j6(String str) {
        int i = 0;
        if (!e.VH()) {
            if (str != null) {
                try {
                    gn(str);
                    return;
                } catch (IOException e) {
                    Toast.makeText(e.gn(), str + " could not be loaded!", 1).show();
                    return;
                }
            }
            String string = e.gn().getSharedPreferences("OpenFileService", 0).getString("CurrentFiles", null);
            if (string != null) {
                String[] split = string.split(";");
                HashSet hashSet = new HashSet();
                int length = split.length;
                while (i < length) {
                    String str2 = split[i];
                    if (qh.VH(str2) && !hashSet.contains(str2)) {
                        hashSet.add(str2);
                        try {
                            gn(str2);
                        } catch (IOException e2) {
                            Toast.makeText(e.gn(), str2 + " could not be loaded!", 1).show();
                        }
                    }
                    i++;
                }
            }
        }
    }

    private void J8() {
        String str = "";
        for (String str2 : this.j6.keySet()) {
            if (str.length() > 0) {
                str = str + ";";
            }
            str = str + str2;
        }
        Editor edit = e.gn().getSharedPreferences("OpenFileService", 0).edit();
        edit.putString("CurrentFiles", str);
        edit.commit();
    }

    public void j6(pl$c pl_c) {
        this.v5.add(pl_c);
    }

    public void DW(pl$c pl_c) {
        this.v5.remove(pl_c);
    }

    public void DW() {
        for (Entry entry : this.j6.entrySet()) {
            DW((String) entry.getKey(), (pl$a) entry.getValue());
        }
        e.XL().j6(new pl$1(this));
    }

    public void j6(pl$b pl_b) {
        this.FH = pl_b;
    }

    private pl$a Ws() {
        return (pl$a) this.j6.get(this.FH.getVisibleFile());
    }

    public pl$a DW(String str) {
        return (pl$a) this.j6.get(str);
    }

    public void FH() {
        if (this.Hw != null) {
            ((pl$a) this.j6.get(this.Hw)).d_();
            this.Hw = null;
        }
    }

    public pl$a FH(String str) {
        pl$a DW = DW(str);
        if (DW != null) {
            return DW;
        }
        FH();
        this.Hw = str;
        DW = this.FH.DW(str);
        j6(str, DW);
        return DW;
    }

    private void gn(String str) {
        if (!VH(str)) {
            j6(str, this.FH.DW(str));
        }
    }

    private void j6(String str, pl$a pl_a) {
        this.j6.put(str, pl_a);
        DW(str, pl_a);
        while (this.j6.size() > 10) {
            if (!u7(str)) {
                return;
            }
        }
    }

    private boolean u7(String str) {
        String str2 = null;
        for (Entry entry : this.j6.entrySet()) {
            String str3 = (String) entry.getKey();
            pl$a pl_a = (pl$a) entry.getValue();
            if (str3.equals(str) || pl_a.gn() || pl_a.VH() || (str2 != null && tp(str2) <= tp(str3))) {
                str3 = str2;
            }
            str2 = str3;
        }
        if (str2 == null) {
            for (Entry entry2 : this.j6.entrySet()) {
                str3 = (String) entry2.getKey();
                pl_a = (pl$a) entry2.getValue();
                if (!(str3.equals(str) || pl_a.gn())) {
                    if (str2 == null || tp(str2) > tp(str3)) {
                        str2 = str3;
                    }
                }
            }
        }
        if (str2 == null) {
            return false;
        }
        Hw(str2);
        return true;
    }

    private long tp(String str) {
        if (this.DW.containsKey(str)) {
            return ((Long) this.DW.get(str)).longValue();
        }
        return 0;
    }

    public String Hw() {
        return this.FH.getVisibleFile();
    }

    public void Hw(String str) {
        ((pl$a) this.j6.get(str)).u7();
        this.j6.remove(str);
        e.XL().j6(str);
        this.FH.j6(str);
        e.XL().VH();
        J8();
    }

    public void v5() {
        HashSet hashSet = new HashSet();
        for (Entry entry : this.j6.entrySet()) {
            if (!((pl$a) entry.getValue()).gn()) {
                hashSet.add(entry.getKey());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Hw((String) it.next());
        }
    }

    public void v5(String str) {
        if (VH(str)) {
            this.FH.FH(str);
        }
    }

    public void j6(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                boolean z;
                String str = (String) list.get(i);
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                j6(str, z);
            } catch (IOException e) {
                Toast.makeText(e.gn(), ((String) list.get(i)) + " could not be loaded!", 1).show();
            }
        }
    }

    public void j6(String str, boolean z) {
        if (!str.equals(Hw())) {
            boolean VH = VH(str);
            gn(str);
            if (VH(str)) {
                if (!VH) {
                    e.nw().DW(str);
                }
                if (z) {
                    this.FH.FH(str);
                }
                this.DW.put(str, Long.valueOf(System.currentTimeMillis()));
                J8();
            }
        }
    }

    public long Zo() {
        return Ws().Zo();
    }

    private void DW(String str, pl$a pl_a) {
        e.XL().j6(str, new pl$2(this, pl_a));
    }

    public void j6(boolean z, boolean z2) {
        DW(z, z2);
    }

    public boolean DW(boolean z, boolean z2) {
        boolean QX = e.a8().QX();
        List arrayList = new ArrayList();
        boolean z3 = true;
        for (Entry entry : this.j6.entrySet()) {
            boolean z4;
            String str = (String) entry.getKey();
            pl$a pl_a = (pl$a) entry.getValue();
            if (!pl_a.gn()) {
                z4 = z3;
            } else if (QX) {
                z4 = false;
            } else {
                if (z) {
                    arrayList.add(str);
                }
                pl_a.d_();
                z4 = z3;
            }
            z3 = z4;
        }
        if (!arrayList.isEmpty()) {
            e.a8().j6(arrayList, z2);
        }
        return z3;
    }

    public void j6(String str, String str2) {
        Map hashMap = new HashMap();
        for (Entry key : this.j6.entrySet()) {
            String str3 = (String) key.getKey();
            if (qh.FH(str, str3)) {
                hashMap.put(str3, qh.j6(str3, str, str2));
            }
        }
        for (Entry key2 : hashMap.entrySet()) {
            String str4 = (String) key2.getKey();
            str3 = (String) key2.getValue();
            e.XL().j6(str4, str3);
            ((pl$a) this.j6.get(str4)).j6(str3);
            this.j6.put(str3, this.j6.get(str4));
            this.j6.remove(str4);
        }
    }

    public void Zo(String str) {
        Set<String> hashSet = new HashSet();
        for (Entry key : this.j6.entrySet()) {
            String str2 = (String) key.getKey();
            if (qh.FH(str, str2)) {
                hashSet.add(str2);
            }
        }
        for (String str22 : hashSet) {
            Hw(str22);
        }
    }

    public boolean VH() {
        return Hw() != null;
    }

    public boolean gn() {
        return (Hw() == null || qh.tp(Hw())) ? false : true;
    }

    public boolean u7() {
        return VH() && Hw().toLowerCase().endsWith(".java") && e.a8().J0();
    }

    public boolean tp() {
        return VH() && EQ(Hw()) && e.a8().J0();
    }

    private boolean EQ(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.endsWith(".java") || toLowerCase.endsWith(".class") || toLowerCase.endsWith(".xml") || toLowerCase.endsWith(".c") || toLowerCase.endsWith(".cpp") || toLowerCase.endsWith(".cc") || toLowerCase.endsWith(".h") || toLowerCase.endsWith(".hh") || toLowerCase.endsWith(".hpp") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm") || toLowerCase.endsWith(".css") || toLowerCase.endsWith(".js")) {
            return true;
        }
        return false;
    }

    public boolean EQ() {
        return !this.j6.isEmpty();
    }

    public boolean we() {
        for (pl$a gn : this.j6.values()) {
            if (gn.gn()) {
                return true;
            }
        }
        return false;
    }

    public boolean VH(String str) {
        return this.j6.containsKey(str);
    }

    public void j6(boolean z) {
        List arrayList = new ArrayList();
        for (Entry entry : this.j6.entrySet()) {
            String str = (String) entry.getKey();
            pl$a pl_a = (pl$a) entry.getValue();
            if (pl_a.DW()) {
                pl_a.c_();
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty() && z) {
            e.a8().j6(arrayList, false);
        }
    }

    public boolean J0() {
        if (!e.a8().QX()) {
            return false;
        }
        for (Entry entry : this.j6.entrySet()) {
            String str = (String) entry.getKey();
            if (((pl$a) entry.getValue()).gn()) {
                return true;
            }
        }
        return false;
    }
}
