import com.aide.common.m;
import com.aide.engine.service.j.a;
import com.aide.ui.e;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class pq$1 extends a {
    final /* synthetic */ pq j6;

    pq$1(pq pqVar) {
        this.j6 = pqVar;
    }

    public void j6(String str, Map map) {
        e.j6(new pq$1$1(this, map, str));
    }

    private void j6(String str, List<String> list, int i, Map<String, String[]> map, Hashtable<String, String> hashtable) {
        e.u7().J0();
        String str2 = (String) list.get(i);
        List asList = Arrays.asList((Object[]) map.get(str2));
        m.j6(e.u7(), "Which '" + str2 + "' to import ?", asList, new pq$1$2(this, hashtable, str2, i, list, str, map));
    }

    public void j6(String str, String str2) {
        e.j6(new pq$1$3(this, str, str2));
    }

    public void j6(String str) {
        e.j6(new pq$1$4(this, str));
    }

    public void j6(List list) {
        e.j6(new pq$1$5(this, list));
    }

    public void j6(String str, List list) {
        e.j6(new pq$1$6(this, str, list));
    }
}
