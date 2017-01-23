import com.aide.common.y;
import com.aide.ui.e;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class pq$1$2 implements y<String> {
    final /* synthetic */ String DW;
    final /* synthetic */ int FH;
    final /* synthetic */ List Hw;
    final /* synthetic */ pq$1 VH;
    final /* synthetic */ Map Zo;
    final /* synthetic */ Hashtable j6;
    final /* synthetic */ String v5;

    pq$1$2(pq$1 pq_1, Hashtable hashtable, String str, int i, List list, String str2, Map map) {
        this.VH = pq_1;
        this.j6 = hashtable;
        this.DW = str;
        this.FH = i;
        this.Hw = list;
        this.v5 = str2;
        this.Zo = map;
    }

    public void j6(String str) {
        this.j6.put(this.DW, str);
        int i = this.FH + 1;
        if (i >= this.Hw.size()) {
            e.u7().we();
            e.XL().j6(this.v5, this.j6);
            return;
        }
        this.VH.j6(this.v5, this.Hw, i, this.Zo, this.j6);
    }
}
