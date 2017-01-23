import android.content.SharedPreferences.Editor;
import com.aide.common.k;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ph {
    private Map<String, k> j6;

    public ph() {
        this.j6 = new HashMap();
    }

    public void j6() {
        try {
            for (Entry entry : e.gn().getSharedPreferences("KeybindingsService_2", 0).getAll().entrySet()) {
                if (entry.getValue() instanceof String) {
                    k j6 = k.j6(entry.getValue().toString());
                    if (j6 != null) {
                        this.j6.put(entry.getKey(), j6);
                    }
                }
            }
        } catch (Throwable th) {
            com.aide.common.e.j6(th);
        }
    }

    private String DW(qi qiVar) {
        if (qiVar instanceof qj) {
            return ((qj) qiVar).Hw();
        }
        return qiVar.getClass().getName();
    }

    private void FH() {
        try {
            Editor edit = e.gn().getSharedPreferences("KeybindingsService_2", 0).edit();
            edit.clear();
            for (Entry entry : this.j6.entrySet()) {
                edit.putString((String) entry.getKey(), ((k) entry.getValue()).Hw());
            }
            edit.commit();
        } catch (Throwable th) {
            com.aide.common.e.j6(th);
        }
    }

    public List<k> j6(qi qiVar) {
        List<k> arrayList = new ArrayList();
        k kVar = (k) this.j6.get(DW(qiVar));
        if (kVar != null) {
            arrayList.add(kVar);
        } else {
            arrayList.add(qiVar.j6());
            if (qiVar instanceof qn) {
                arrayList.addAll(((qn) qiVar).Hw());
            }
        }
        return arrayList;
    }

    public void j6(qi qiVar, k kVar) {
        if (kVar == null) {
            this.j6.remove(DW(qiVar));
        } else {
            this.j6.put(DW(qiVar), kVar);
        }
        FH();
    }

    public void DW() {
        this.j6.clear();
        FH();
    }
}
