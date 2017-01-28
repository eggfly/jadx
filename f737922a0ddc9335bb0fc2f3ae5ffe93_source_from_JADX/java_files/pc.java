import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.aide.engine.SyntaxError;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class pc {
    private HashSet<String> DW;
    private HashMap<String, List<SyntaxError>> EQ;
    private HashMap<String, Boolean> FH;
    private HashSet<String> Hw;
    private Set<pc$a> J0;
    private Toast J8;
    private int VH;
    private int Zo;
    private int gn;
    private Object j6;
    private boolean tp;
    private int u7;
    private HashMap<String, SyntaxError[]> v5;
    private int we;

    public pc() {
        this.j6 = new Object();
        this.DW = new HashSet();
        this.FH = new HashMap();
        this.Hw = new HashSet();
        this.v5 = new HashMap();
        this.EQ = new HashMap();
        this.J0 = new HashSet();
    }

    public void j6() {
        e.XL().j6(new pc$1(this));
    }

    public void DW() {
        u7();
        this.DW.clear();
        this.FH.clear();
        this.Hw.clear();
        this.v5.clear();
        this.Zo = 0;
        this.VH = 0;
        J8();
    }

    public List<SyntaxError> j6(String str) {
        List arrayList;
        synchronized (this.j6) {
            arrayList = new ArrayList();
            if (str != null && this.v5.containsKey(str)) {
                for (SyntaxError syntaxError : (SyntaxError[]) this.v5.get(str)) {
                    if (syntaxError.DW() || syntaxError.Zo() || syntaxError.FH()) {
                        arrayList.add(syntaxError);
                    }
                }
            }
            if (str != null && this.EQ.containsKey(str)) {
                arrayList.addAll((Collection) this.EQ.get(str));
            }
        }
        return arrayList;
    }

    public List<SyntaxError> DW(String str) {
        List arrayList;
        synchronized (this.j6) {
            arrayList = new ArrayList();
            if (str != null && this.v5.containsKey(str)) {
                for (SyntaxError syntaxError : (SyntaxError[]) this.v5.get(str)) {
                    if (syntaxError.DW() || syntaxError.Zo()) {
                        arrayList.add(syntaxError);
                    }
                }
            }
            if (str != null && this.EQ.containsKey(str)) {
                arrayList.addAll((Collection) this.EQ.get(str));
            }
        }
        return arrayList;
    }

    public List<SyntaxError> FH(String str) {
        List arrayList;
        synchronized (this.j6) {
            arrayList = new ArrayList();
            if (str != null && this.v5.containsKey(str)) {
                for (SyntaxError syntaxError : (SyntaxError[]) this.v5.get(str)) {
                    if (syntaxError.DW()) {
                        arrayList.add(syntaxError);
                    }
                }
            }
            if (str != null && this.EQ.containsKey(str)) {
                arrayList.addAll((Collection) this.EQ.get(str));
            }
        }
        return arrayList;
    }

    public int FH() {
        int i;
        synchronized (this.j6) {
            i = this.Zo + this.we;
        }
        return i;
    }

    public boolean Hw() {
        boolean z;
        synchronized (this.j6) {
            z = this.tp;
        }
        return z;
    }

    public int v5() {
        int i;
        synchronized (this.j6) {
            i = this.gn;
        }
        return i;
    }

    public int Zo() {
        int i;
        synchronized (this.j6) {
            i = this.u7;
        }
        return i;
    }

    private int j6(String str, SyntaxError[] syntaxErrorArr) {
        int i = 0;
        if (syntaxErrorArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i < syntaxErrorArr.length) {
            SyntaxError syntaxError = syntaxErrorArr[i];
            if (!j6(str, syntaxError) && syntaxError.DW()) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private boolean j6(String str, SyntaxError syntaxError) {
        return false;
    }

    private void EQ() {
        this.Hw.clear();
        synchronized (this.j6) {
            this.tp = true;
            this.gn = 0;
            this.u7 = 0;
        }
        J8();
    }

    private void v5(String str) {
        synchronized (this.j6) {
            if (!this.FH.containsKey(str)) {
                this.FH.put(str, Boolean.FALSE);
            }
            this.u7++;
        }
    }

    private void we() {
        String str;
        int j6;
        int i;
        synchronized (this.j6) {
            Map map = this.FH;
            this.FH = new HashMap();
            this.tp = false;
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        for (String str2 : this.v5.keySet()) {
            if (this.Hw.contains(str2)) {
                if (this.DW.contains(str2)) {
                    j6 = j6(str2, (SyntaxError[]) this.v5.get(str2));
                    if (j6 != 0) {
                        j6 = i2 + j6;
                        i = i3 + 1;
                    }
                }
                j6 = i2;
                i = i3;
            } else {
                hashSet.add(str2);
                map.put(str2, Boolean.TRUE);
                j6 = i2;
                i = i3;
            }
            i2 = j6;
            i3 = i;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            synchronized (this.j6) {
                this.v5.remove(str2);
            }
        }
        synchronized (this.j6) {
            this.VH = i3;
            this.Zo = i2;
        }
        i = 0;
        for (String str22 : map.keySet()) {
            if (map.get(str22) == Boolean.TRUE) {
                j6 = 1;
            } else {
                j6 = 0;
            }
            i = j6 | i;
        }
        J8();
    }

    private void j6(String str, SyntaxError[] syntaxErrorArr, boolean z) {
        synchronized (this.j6) {
            if (z) {
                this.DW.add(str);
                SyntaxError[] syntaxErrorArr2 = (SyntaxError[]) this.v5.get(str);
                int j6 = j6(str, syntaxErrorArr2);
                int j62 = j6(str, syntaxErrorArr);
                if (j6 != j62) {
                    this.Zo += j62 - j6;
                    if (j62 == 0) {
                        this.VH--;
                    } else if (j6 == 0) {
                        this.VH++;
                    }
                } else if (j6 == 0 && j62 == 0) {
                    if (syntaxErrorArr.length == 0 && syntaxErrorArr2 != null && syntaxErrorArr2.length == 0) {
                    }
                }
            } else {
                this.DW.remove(str);
            }
            if (syntaxErrorArr.length == 0) {
                this.v5.remove(str);
            } else {
                this.v5.put(str, syntaxErrorArr);
            }
            if (this.FH.containsKey(str)) {
                this.FH.remove(str);
            }
            if (this.gn < this.u7) {
                this.gn++;
            }
        }
        this.Hw.add(str);
        DW(str, syntaxErrorArr);
    }

    private void Zo(String str) {
        this.Hw.add(str);
    }

    private void DW(String str, SyntaxError[] syntaxErrorArr) {
        e.j6(new pc$2(this, str));
    }

    private void VH(String str) {
        if (this.J0 != null) {
            for (pc$a DW : this.J0) {
                DW.DW(str);
            }
        }
    }

    private void J0() {
        if (this.J0 != null) {
            for (pc$a Mr : this.J0) {
                Mr.Mr();
            }
        }
    }

    private void J8() {
        e.j6(new pc$3(this));
    }

    public void VH() {
        this.J0 = null;
    }

    public void j6(pc$a pc_a) {
        this.J0.add(pc_a);
    }

    public void DW(pc$a pc_a) {
        this.J0.remove(pc_a);
    }

    public List<String> gn() {
        List arrayList;
        synchronized (this.j6) {
            Collection hashSet = new HashSet(this.v5.keySet());
            hashSet.addAll(this.EQ.keySet());
            arrayList = new ArrayList(hashSet);
        }
        return arrayList;
    }

    public SyntaxError j6(String str, int i, int i2, int i3, int i4) {
        SyntaxError syntaxError = null;
        for (SyntaxError syntaxError2 : DW(str)) {
            SyntaxError syntaxError22;
            if (!(j6(syntaxError22.FH, syntaxError22.Hw, syntaxError22.v5, syntaxError22.Zo, i, i2, i3, i4) && (syntaxError == null || syntaxError.gn == null))) {
                syntaxError22 = syntaxError;
            }
            syntaxError = syntaxError22;
        }
        return syntaxError;
    }

    public SyntaxError DW(String str, int i, int i2, int i3, int i4) {
        SyntaxError syntaxError;
        SyntaxError syntaxError2 = null;
        for (SyntaxError syntaxError3 : DW(str)) {
            if (!(j6(syntaxError3.FH, syntaxError3.Hw, syntaxError3.v5, syntaxError3.Zo, i, i2, i3, i4) && (syntaxError2 == null || syntaxError2.gn == null))) {
                syntaxError3 = syntaxError2;
            }
            syntaxError2 = syntaxError3;
        }
        if (syntaxError2 == null) {
            for (SyntaxError syntaxError32 : DW(str)) {
                if (j6(syntaxError32.FH, 1, syntaxError32.v5, Integer.MAX_VALUE, i, 1, i3, Integer.MAX_VALUE) && (r10 == null || r10.gn == null)) {
                    syntaxError2 = syntaxError32;
                }
            }
        }
        return syntaxError2;
    }

    private boolean j6(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return j6(i, i2, i3, i4, i5, i6) || j6(i, i2, i3, i4, i7, i8);
    }

    private boolean j6(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i == i3) {
            if (i5 != i || i2 > i6 || i4 < i6) {
                return false;
            }
            return true;
        } else if (i < i5 && i3 > i5) {
            return true;
        } else {
            if (i == i5 && i2 <= i6) {
                return true;
            }
            if (i3 != i5 || i4 < i6) {
                return false;
            }
            return true;
        }
    }

    public Pair<qg, SyntaxError> j6(String str, int i, int i2) {
        List gn = gn();
        Collections.sort(gn);
        int i3 = 0;
        while (i3 < gn.size()) {
            String str2 = (String) gn.get(i3);
            if (str2.equals(str)) {
                break;
            } else if (str2.compareTo(str) > 0) {
                i2 = 1;
                i = 1;
                break;
            } else {
                i3++;
            }
        }
        Object obj = null;
        int i4 = i3;
        while (true) {
            int i5;
            if (i4 >= gn.size()) {
                i5 = 0;
            } else {
                i5 = i4;
            }
            String str3 = (String) gn.get(i5);
            SyntaxError DW = DW(FH(str3), i, i2);
            if (DW != null) {
                return new Pair(new qg(str3, DW.FH, DW.Hw, DW.v5, DW.Zo), DW);
            }
            i4 = i5 + 1;
            if (obj != null) {
                return null;
            }
            if (i4 == i3) {
                obj = 1;
            } else {
                obj = null;
            }
            i2 = 1;
            i = 1;
        }
    }

    public Pair<qg, SyntaxError> DW(String str, int i, int i2) {
        List gn = gn();
        Collections.sort(gn);
        int size = gn.size() - 1;
        while (size >= 0) {
            String str2 = (String) gn.get(size);
            if (str2.equals(str)) {
                break;
            } else if (str2.compareTo(str) < 0) {
                i2 = 1000000;
                i = 1000000;
                break;
            } else {
                size--;
            }
        }
        Object obj = null;
        int i3 = size;
        while (true) {
            if (i3 < 0) {
                i3 = gn.size() - 1;
            }
            String str3 = (String) gn.get(i3);
            SyntaxError j6 = j6(FH(str3), i, i2);
            if (j6 != null) {
                return new Pair(new qg(str3, j6.FH, j6.Hw, j6.v5, j6.Zo), j6);
            }
            int i4 = i3 - 1;
            if (obj != null) {
                return null;
            }
            Object obj2;
            if (i4 == size) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            obj = obj2;
            i2 = 1000000;
            i = 1000000;
            i3 = i4;
        }
    }

    private SyntaxError j6(List<SyntaxError> list, int i, int i2) {
        Collections.sort(list, new pc$4(this));
        Collections.reverse(list);
        for (SyntaxError syntaxError : list) {
            if (j6(i, i2, syntaxError.FH, syntaxError.Hw) > 0) {
                return syntaxError;
            }
        }
        return null;
    }

    private SyntaxError DW(List<SyntaxError> list, int i, int i2) {
        Collections.sort(list, new pc$5(this));
        for (SyntaxError syntaxError : list) {
            if (j6(i, i2, syntaxError.FH, syntaxError.Hw) < 0) {
                return syntaxError;
            }
        }
        return null;
    }

    private int j6(int i, int i2, int i3, int i4) {
        if (i < i3) {
            return -1;
        }
        if (i > i3) {
            return 1;
        }
        return i2 - i4;
    }

    public void u7() {
        HashSet hashSet = new HashSet(this.EQ.keySet());
        this.EQ.clear();
        this.we = 0;
        j6(hashSet);
    }

    public void j6(String str, Map<String, List<SyntaxError>> map) {
        DW(str, (Map) map);
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.EQ.keySet());
        j6(hashSet);
    }

    private void j6(HashSet<String> hashSet) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            VH((String) it.next());
        }
        J0();
    }

    private void DW(String str, Map<String, List<SyntaxError>> map) {
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            for (SyntaxError DW : (List) entry.getValue()) {
                DW(str2, DW);
            }
        }
    }

    private void DW(String str, SyntaxError syntaxError) {
        this.we++;
        if (!this.EQ.containsKey(str)) {
            this.EQ.put(str, new ArrayList());
        }
        ((List) this.EQ.get(str)).add(syntaxError);
    }

    public void j6(SyntaxError syntaxError) {
        View inflate = LayoutInflater.from(e.gn()).inflate(R.c.error_popup, null);
        ((TextView) inflate.findViewById(R.b.errorPopupText)).setText(syntaxError.j6());
        if (this.J8 != null) {
            this.J8.cancel();
        }
        this.J8 = new Toast(e.gn());
        this.J8.setDuration(0);
        this.J8.setView(inflate);
        this.J8.show();
    }

    public boolean Hw(String str) {
        for (Entry entry : this.v5.entrySet()) {
            if (((String) entry.getKey()).endsWith(str)) {
                for (SyntaxError DW : (SyntaxError[]) entry.getValue()) {
                    if (DW.DW()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public List<String> tp() {
        List<String> arrayList = new ArrayList();
        for (Entry entry : this.v5.entrySet()) {
            if (((String) entry.getKey()).endsWith(".java")) {
                for (SyntaxError syntaxError : (SyntaxError[]) entry.getValue()) {
                    if (syntaxError.Hw()) {
                        arrayList.add(syntaxError.v5());
                    }
                }
            }
        }
        return arrayList;
    }
}
